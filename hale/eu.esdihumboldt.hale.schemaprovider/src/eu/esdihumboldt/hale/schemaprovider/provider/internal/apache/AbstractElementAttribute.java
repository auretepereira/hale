/*
 * HUMBOLDT: A Framework for Data Harmonisation and Service Integration.
 * EU Integrated Project #030962                 01.10.2006 - 30.09.2010
 * 
 * For more information on the project, please refer to the this web site:
 * http://www.esdi-humboldt.eu
 * 
 * LICENSE: For information on the license under which this program is 
 * available, please refer to http:/www.esdi-humboldt.eu/license.html#core
 * (c) the HUMBOLDT Consortium, 2007 to 2010.
 */

package eu.esdihumboldt.hale.schemaprovider.provider.internal.apache;

import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.ws.commons.schema.XmlSchemaAnnotated;
import org.apache.ws.commons.schema.XmlSchemaDocumentation;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaObject;
import org.apache.ws.commons.schema.XmlSchemaObjectCollection;
import org.geotools.feature.AttributeTypeBuilder;
import org.geotools.feature.NameImpl;
import org.geotools.feature.type.AttributeDescriptorImpl;
import org.opengis.feature.type.AttributeDescriptor;
import org.opengis.feature.type.AttributeType;
import org.opengis.feature.type.Name;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.vividsolutions.jts.geom.Geometry;

import eu.esdihumboldt.hale.schemaprovider.model.AttributeDefinition;
import eu.esdihumboldt.hale.schemaprovider.model.TypeDefinition;

/**
 * 
 *
 * @author Simon Templer
 * @partner 01 / Fraunhofer Institute for Computer Graphics Research
 * @version $Id$ 
 */
public abstract class AbstractElementAttribute extends AttributeDefinition {

	private static final Logger log = Logger.getLogger(AbstractElementAttribute.class);
	
	private boolean nillable;
	
	private final long minOccurs;
	
	private final long maxOccurs;
	
	/**
	 * Constructor
	 * 
	 * @param declaringType the declaring type, if it is <code>null</code>,
	 *   the attribute type will not be determined
	 * @param name the attribute name
	 * @param typeName the name of the attribute type
	 * @param element the element defining the attribute
	 */
	public AbstractElementAttribute(TypeDefinition declaringType, String name, Name typeName,
			XmlSchemaElement element) {
		super(name, typeName, null, true);
		
		nillable = element.isNillable(); //XXX correct?
		minOccurs = element.getMinOccurs(); //XXX correct?
		maxOccurs = element.getMaxOccurs(); //XXX correct?
		
		String description = getDescription(element);
		if (description != null) {
			setDescription(description);
		}
		
		if (declaringType != null) {
			// set the declaring type
			declaringType.addDeclaredAttribute(this);
		}
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param other
	 */
	protected AbstractElementAttribute(AbstractElementAttribute other) {
		super(other);
		
		nillable = other.isNillable();
		minOccurs = other.getMinOccurs();
		maxOccurs = other.getMaxOccurs();
	}
	
	/**
	 * Check if the given type definition should be set as the attribute type
	 * 
	 * @param typeDef the type definition
	 * 
	 * @return the type definition that shall be set as the attribute type
	 */
	protected TypeDefinition checkAttributeType(TypeDefinition typeDef) {
		// inspire geometry attributes
//		if (getName().equals("geometry") && typeDef != null && 
//				!Geometry.class.isAssignableFrom(typeDef.getType(null).getBinding())) {
//			return createDefaultGeometryType(typeDef);
//		}
		// geometry property types
//		else if (typeDef != null && typeDef.getName().getLocalPart().equals("GeometryPropertyType") &&
//				!Geometry.class.isAssignableFrom(typeDef.getType(null).getBinding())) {
//			return createDefaultGeometryType(typeDef);
//		}
		
		// default: leave type untouched
		return typeDef;
	}
	
	private TypeDefinition createDefaultGeometryType(TypeDefinition typeDef) {
		// create an attribute type with a geometry binding
		AttributeTypeBuilder builder = new AttributeTypeBuilder();
		builder.setBinding(Geometry.class);
		builder.setName(getTypeName().getLocalPart());
		builder.setNamespaceURI(getTypeName().getNamespaceURI());
		builder.setNillable(true);
		AttributeType attributeType = builder.buildType();
		
		TypeDefinition result = new TypeDefinition(getTypeName(), attributeType, typeDef.getSuperType());
		result.setDescription(typeDef.getDescription());
		result.setLocation(typeDef.getLocation());
		return result;
	}

	/**
	 * Get the documentation from an annotated XML object
	 * 
	 * @param element the annotated element
	 * @return the description or <code>null</code>
	 */
	public static String getDescription(XmlSchemaAnnotated element) {
		if (element.getAnnotation() != null) {
			XmlSchemaObjectCollection annotationItems = element.getAnnotation().getItems();
			StringBuffer desc = new StringBuffer();
			for (int i = 0; i < annotationItems.getCount(); i++) {
				XmlSchemaObject item = annotationItems.getItem(i);
				if (item instanceof XmlSchemaDocumentation) {
					XmlSchemaDocumentation doc = (XmlSchemaDocumentation) item;
					NodeList markup = doc.getMarkup();
					for (int j = 0; j < markup.getLength(); j++) {
						Node node = markup.item(j);
						desc.append(node.getTextContent());
						desc.append('\n');
					}
				}
			}
			
			String description = desc.toString();
			if (!description.isEmpty()) {
				return description;
			}
		}
		
		return null;
	}

	/**
	 * @see AttributeDefinition#createAttributeDescriptor(Set)
	 */
	public AttributeDescriptor createAttributeDescriptor(Set<TypeDefinition> resolving) {
		TypeDefinition attType = getAttributeType();
		if (attType != null) {
			if (resolving != null && resolving.contains(attType)) {
				log.warn("Cycle detected, skipping creation of attribute descriptor "
						+ getName() + ":" + attType.getDisplayName() + " in " + getDeclaringType().getDisplayName());
				return null;
			}
			else {
				AttributeType type = attType.getType(resolving);
				if (type != null) {
					//Name parentName = getDeclaringType().getName();
					return new AttributeDescriptorImpl(
							type,
							new NameImpl(null, /*parentName.getNamespaceURI() + "/" + parentName.getLocalPart(), */getName()),
							(int) minOccurs,
							(int) maxOccurs,
							true, // always nillable, else creating the features fails
							null); 
				}
				else {
					return null;
				}
			}
		}
		else {
			return null;
		}
	}

	/**
	 * @see AttributeDefinition#getMaxOccurs()
	 */
	@Override
	public long getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * @see AttributeDefinition#getMinOccurs()
	 */
	@Override
	public long getMinOccurs() {
		return minOccurs;
	}

	/**
	 * @see AttributeDefinition#isNillable()
	 */
	@Override
	public boolean isNillable() {
		return nillable;
	}

	/**
	 * Only use this method if the initial configuration has not been correct
	 * 
	 * @param nillable the nillable to set
	 */
	public void setNillable(boolean nillable) {
		this.nillable = nillable;
	}

}

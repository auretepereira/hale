//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.12.04 at 05:21:33 PM MEZ 
//


package eu.esdihumboldt.goml.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyQualifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyQualifierType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omwg.org/TR/d7/ontology/alignment}EntityType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omwg.org/TR/d7/ontology/alignment}domainRestriction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omwg.org/TR/d7/ontology/alignment}typeCondition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omwg.org/TR/d7/ontology/alignment}valueCondition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyQualifierType", propOrder = {
    "domainRestriction",
    "typeCondition",
    "valueCondition"
})
public class PropertyQualifierType
    extends EntityType
{

    protected List<DomainRestrictionType> domainRestriction;
    protected List<String> typeCondition;
    protected List<ValueConditionType> valueCondition;

    /**
     * Gets the value of the domainRestriction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domainRestriction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomainRestriction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomainRestrictionType }
     * 
     * 
     */
    public List<DomainRestrictionType> getDomainRestriction() {
        if (domainRestriction == null) {
            domainRestriction = new ArrayList<DomainRestrictionType>();
        }
        return this.domainRestriction;
    }

    /**
     * Gets the value of the typeCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTypeCondition() {
        if (typeCondition == null) {
            typeCondition = new ArrayList<String>();
        }
        return this.typeCondition;
    }

    /**
     * Gets the value of the valueCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueConditionType }
     * 
     * 
     */
    public List<ValueConditionType> getValueCondition() {
        if (valueCondition == null) {
            valueCondition = new ArrayList<ValueConditionType>();
        }
        return this.valueCondition;
    }

}

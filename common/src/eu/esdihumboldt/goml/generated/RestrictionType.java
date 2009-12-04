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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RestrictionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RestrictionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{http://www.omwg.org/TR/d7/ontology/alignment}onAttribute" minOccurs="0"/>
 *           &lt;element ref="{http://www.omwg.org/TR/d7/ontology/alignment}comparator"/>
 *           &lt;choice>
 *             &lt;element name="value" type="{http://www.omwg.org/TR/d7/ontology/alignment}valueExprType" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element ref="{http://www.esdi-humboldt.eu/goml}ValueClass" minOccurs="0"/>
 *           &lt;/choice>
 *         &lt;/sequence>
 *         &lt;element ref="{http://www.esdi-humboldt.eu/goml}cqlStr" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestrictionType", propOrder = {
    "onAttribute",
    "comparator",
    "value",
    "valueClass",
    "cqlStr"
})
public class RestrictionType {

    protected OnAttributeType onAttribute;
    protected ComparatorEnumType comparator;
    protected List<ValueExprType> value;
    @XmlElement(name = "ValueClass", namespace = "http://www.esdi-humboldt.eu/goml")
    protected ValueClassType valueClass;
    @XmlElement(namespace = "http://www.esdi-humboldt.eu/goml")
    protected String cqlStr;

    /**
     * Gets the value of the onAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link OnAttributeType }
     *     
     */
    public OnAttributeType getOnAttribute() {
        return onAttribute;
    }

    /**
     * Sets the value of the onAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link OnAttributeType }
     *     
     */
    public void setOnAttribute(OnAttributeType value) {
        this.onAttribute = value;
    }

    /**
     * Gets the value of the comparator property.
     * 
     * @return
     *     possible object is
     *     {@link ComparatorEnumType }
     *     
     */
    public ComparatorEnumType getComparator() {
        return comparator;
    }

    /**
     * Sets the value of the comparator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComparatorEnumType }
     *     
     */
    public void setComparator(ComparatorEnumType value) {
        this.comparator = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueExprType }
     * 
     * 
     */
    public List<ValueExprType> getValue() {
        if (value == null) {
            value = new ArrayList<ValueExprType>();
        }
        return this.value;
    }

    /**
     * Gets the value of the valueClass property.
     * 
     * @return
     *     possible object is
     *     {@link ValueClassType }
     *     
     */
    public ValueClassType getValueClass() {
        return valueClass;
    }

    /**
     * Sets the value of the valueClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueClassType }
     *     
     */
    public void setValueClass(ValueClassType value) {
        this.valueClass = value;
    }

    /**
     * Gets the value of the cqlStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCqlStr() {
        return cqlStr;
    }

    /**
     * Sets the value of the cqlStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCqlStr(String value) {
        this.cqlStr = value;
    }

}

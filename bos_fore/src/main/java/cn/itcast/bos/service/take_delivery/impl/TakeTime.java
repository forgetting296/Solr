
package cn.itcast.bos.service.take_delivery.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for takeTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="takeTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="normalDutyTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="normalWorkTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatingCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatingTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="satDutyTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="satWorkTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sunDutyTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sunWorkTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "takeTime", propOrder = {
    "company",
    "id",
    "name",
    "normalDutyTime",
    "normalWorkTime",
    "operatingCompany",
    "operatingTime",
    "operator",
    "satDutyTime",
    "satWorkTime",
    "status",
    "sunDutyTime",
    "sunWorkTime"
})
public class TakeTime {

    protected String company;
    protected Integer id;
    protected String name;
    protected String normalDutyTime;
    protected String normalWorkTime;
    protected String operatingCompany;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operatingTime;
    protected String operator;
    protected String satDutyTime;
    protected String satWorkTime;
    protected String status;
    protected String sunDutyTime;
    protected String sunWorkTime;

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the normalDutyTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormalDutyTime() {
        return normalDutyTime;
    }

    /**
     * Sets the value of the normalDutyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormalDutyTime(String value) {
        this.normalDutyTime = value;
    }

    /**
     * Gets the value of the normalWorkTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormalWorkTime() {
        return normalWorkTime;
    }

    /**
     * Sets the value of the normalWorkTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormalWorkTime(String value) {
        this.normalWorkTime = value;
    }

    /**
     * Gets the value of the operatingCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatingCompany() {
        return operatingCompany;
    }

    /**
     * Sets the value of the operatingCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatingCompany(String value) {
        this.operatingCompany = value;
    }

    /**
     * Gets the value of the operatingTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOperatingTime() {
        return operatingTime;
    }

    /**
     * Sets the value of the operatingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOperatingTime(XMLGregorianCalendar value) {
        this.operatingTime = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * Gets the value of the satDutyTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSatDutyTime() {
        return satDutyTime;
    }

    /**
     * Sets the value of the satDutyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSatDutyTime(String value) {
        this.satDutyTime = value;
    }

    /**
     * Gets the value of the satWorkTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSatWorkTime() {
        return satWorkTime;
    }

    /**
     * Sets the value of the satWorkTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSatWorkTime(String value) {
        this.satWorkTime = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the sunDutyTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSunDutyTime() {
        return sunDutyTime;
    }

    /**
     * Sets the value of the sunDutyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSunDutyTime(String value) {
        this.sunDutyTime = value;
    }

    /**
     * Gets the value of the sunWorkTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSunWorkTime() {
        return sunWorkTime;
    }

    /**
     * Sets the value of the sunWorkTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSunWorkTime(String value) {
        this.sunWorkTime = value;
    }

}

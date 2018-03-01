
package cn.itcast.bos.service.take_delivery.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for courier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="courier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="courierNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deltag" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="fixedAreas" type="{http://impl.take_delivery.service.bos.itcast.cn/}fixedArea" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="standard" type="{http://impl.take_delivery.service.bos.itcast.cn/}standard" minOccurs="0"/>
 *         &lt;element name="takeTime" type="{http://impl.take_delivery.service.bos.itcast.cn/}takeTime" minOccurs="0"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vehicleNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vehicleType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "courier", propOrder = {
    "checkPwd",
    "company",
    "courierNum",
    "deltag",
    "fixedAreas",
    "id",
    "name",
    "pda",
    "standard",
    "takeTime",
    "telephone",
    "type",
    "vehicleNum",
    "vehicleType"
})
public class Courier {

    protected String checkPwd;
    protected String company;
    protected String courierNum;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer deltag;
    @XmlElement(nillable = true)
    protected List<FixedArea> fixedAreas;
    protected Integer id;
    protected String name;
    protected String pda;
    protected Standard standard;
    protected TakeTime takeTime;
    protected String telephone;
    protected String type;
    protected String vehicleNum;
    protected String vehicleType;

    /**
     * Gets the value of the checkPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckPwd() {
        return checkPwd;
    }

    /**
     * Sets the value of the checkPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckPwd(String value) {
        this.checkPwd = value;
    }

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
     * Gets the value of the courierNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourierNum() {
        return courierNum;
    }

    /**
     * Sets the value of the courierNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourierNum(String value) {
        this.courierNum = value;
    }

    /**
     * Gets the value of the deltag property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeltag() {
        return deltag;
    }

    /**
     * Sets the value of the deltag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeltag(Integer value) {
        this.deltag = value;
    }

    /**
     * Gets the value of the fixedAreas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fixedAreas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFixedAreas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FixedArea }
     * 
     * 
     */
    public List<FixedArea> getFixedAreas() {
        if (fixedAreas == null) {
            fixedAreas = new ArrayList<FixedArea>();
        }
        return this.fixedAreas;
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
     * Gets the value of the pda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPda() {
        return pda;
    }

    /**
     * Sets the value of the pda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPda(String value) {
        this.pda = value;
    }

    /**
     * Gets the value of the standard property.
     * 
     * @return
     *     possible object is
     *     {@link Standard }
     *     
     */
    public Standard getStandard() {
        return standard;
    }

    /**
     * Sets the value of the standard property.
     * 
     * @param value
     *     allowed object is
     *     {@link Standard }
     *     
     */
    public void setStandard(Standard value) {
        this.standard = value;
    }

    /**
     * Gets the value of the takeTime property.
     * 
     * @return
     *     possible object is
     *     {@link TakeTime }
     *     
     */
    public TakeTime getTakeTime() {
        return takeTime;
    }

    /**
     * Sets the value of the takeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TakeTime }
     *     
     */
    public void setTakeTime(TakeTime value) {
        this.takeTime = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the vehicleNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleNum() {
        return vehicleNum;
    }

    /**
     * Sets the value of the vehicleNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleNum(String value) {
        this.vehicleNum = value;
    }

    /**
     * Gets the value of the vehicleType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets the value of the vehicleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleType(String value) {
        this.vehicleType = value;
    }

}

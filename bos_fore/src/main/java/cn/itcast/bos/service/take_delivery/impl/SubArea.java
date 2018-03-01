
package cn.itcast.bos.service.take_delivery.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subArea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subArea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="area" type="{http://impl.take_delivery.service.bos.itcast.cn/}area" minOccurs="0"/>
 *         &lt;element name="assistKeyWords" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fixedArea" type="{http://impl.take_delivery.service.bos.itcast.cn/}fixedArea" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keyWords" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="single" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="startNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subArea", propOrder = {
    "area",
    "assistKeyWords",
    "endNum",
    "fixedArea",
    "id",
    "keyWords",
    "single",
    "startNum"
})
public class SubArea {

    protected Area area;
    protected String assistKeyWords;
    protected String endNum;
    protected FixedArea fixedArea;
    protected String id;
    protected String keyWords;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer single;
    protected String startNum;

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link Area }
     *     
     */
    public Area getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link Area }
     *     
     */
    public void setArea(Area value) {
        this.area = value;
    }

    /**
     * Gets the value of the assistKeyWords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistKeyWords() {
        return assistKeyWords;
    }

    /**
     * Sets the value of the assistKeyWords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistKeyWords(String value) {
        this.assistKeyWords = value;
    }

    /**
     * Gets the value of the endNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndNum() {
        return endNum;
    }

    /**
     * Sets the value of the endNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndNum(String value) {
        this.endNum = value;
    }

    /**
     * Gets the value of the fixedArea property.
     * 
     * @return
     *     possible object is
     *     {@link FixedArea }
     *     
     */
    public FixedArea getFixedArea() {
        return fixedArea;
    }

    /**
     * Sets the value of the fixedArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedArea }
     *     
     */
    public void setFixedArea(FixedArea value) {
        this.fixedArea = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the keyWords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * Sets the value of the keyWords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyWords(String value) {
        this.keyWords = value;
    }

    /**
     * Gets the value of the single property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSingle() {
        return single;
    }

    /**
     * Sets the value of the single property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSingle(Integer value) {
        this.single = value;
    }

    /**
     * Gets the value of the startNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartNum() {
        return startNum;
    }

    /**
     * Sets the value of the startNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartNum(String value) {
        this.startNum = value;
    }

}


package cn.itcast.bos.service.take_delivery.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for order complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="courier" type="{http://impl.take_delivery.service.bos.itcast.cn/}courier" minOccurs="0"/>
 *         &lt;element name="customer_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="goodsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="orderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="orderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payTypeNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recArea" type="{http://impl.take_delivery.service.bos.itcast.cn/}area" minOccurs="0"/>
 *         &lt;element name="recCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendArea" type="{http://impl.take_delivery.service.bos.itcast.cn/}area" minOccurs="0"/>
 *         &lt;element name="sendCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendMobileMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendProNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wayBill" type="{http://impl.take_delivery.service.bos.itcast.cn/}wayBill" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="workBills" type="{http://impl.take_delivery.service.bos.itcast.cn/}workBill" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = {
    "courier",
    "customerId",
    "goodsType",
    "id",
    "orderNum",
    "orderTime",
    "orderType",
    "payTypeNum",
    "recAddress",
    "recArea",
    "recCompany",
    "recMobile",
    "recName",
    "remark",
    "sendAddress",
    "sendArea",
    "sendCompany",
    "sendMobile",
    "sendMobileMsg",
    "sendName",
    "sendProNum",
    "status",
    "telephone",
    "wayBill",
    "weight",
    "workBills"
})
public class Order {

    protected Courier courier;
    @XmlElement(name = "customer_id")
    protected Integer customerId;
    protected String goodsType;
    protected Integer id;
    protected String orderNum;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderTime;
    protected String orderType;
    protected String payTypeNum;
    protected String recAddress;
    protected Area recArea;
    protected String recCompany;
    protected String recMobile;
    protected String recName;
    protected String remark;
    protected String sendAddress;
    protected Area sendArea;
    protected String sendCompany;
    protected String sendMobile;
    protected String sendMobileMsg;
    protected String sendName;
    protected String sendProNum;
    protected String status;
    protected String telephone;
    protected WayBill wayBill;
    protected Double weight;
    @XmlElement(nillable = true)
    protected List<WorkBill> workBills;

    /**
     * Gets the value of the courier property.
     * 
     * @return
     *     possible object is
     *     {@link Courier }
     *     
     */
    public Courier getCourier() {
        return courier;
    }

    /**
     * Sets the value of the courier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Courier }
     *     
     */
    public void setCourier(Courier value) {
        this.courier = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCustomerId(Integer value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the goodsType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * Sets the value of the goodsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsType(String value) {
        this.goodsType = value;
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
     * Gets the value of the orderNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * Sets the value of the orderNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNum(String value) {
        this.orderNum = value;
    }

    /**
     * Gets the value of the orderTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderTime() {
        return orderTime;
    }

    /**
     * Sets the value of the orderTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderTime(XMLGregorianCalendar value) {
        this.orderTime = value;
    }

    /**
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * Gets the value of the payTypeNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayTypeNum() {
        return payTypeNum;
    }

    /**
     * Sets the value of the payTypeNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayTypeNum(String value) {
        this.payTypeNum = value;
    }

    /**
     * Gets the value of the recAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecAddress() {
        return recAddress;
    }

    /**
     * Sets the value of the recAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecAddress(String value) {
        this.recAddress = value;
    }

    /**
     * Gets the value of the recArea property.
     * 
     * @return
     *     possible object is
     *     {@link Area }
     *     
     */
    public Area getRecArea() {
        return recArea;
    }

    /**
     * Sets the value of the recArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Area }
     *     
     */
    public void setRecArea(Area value) {
        this.recArea = value;
    }

    /**
     * Gets the value of the recCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecCompany() {
        return recCompany;
    }

    /**
     * Sets the value of the recCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecCompany(String value) {
        this.recCompany = value;
    }

    /**
     * Gets the value of the recMobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecMobile() {
        return recMobile;
    }

    /**
     * Sets the value of the recMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecMobile(String value) {
        this.recMobile = value;
    }

    /**
     * Gets the value of the recName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecName() {
        return recName;
    }

    /**
     * Sets the value of the recName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecName(String value) {
        this.recName = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the sendAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendAddress() {
        return sendAddress;
    }

    /**
     * Sets the value of the sendAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendAddress(String value) {
        this.sendAddress = value;
    }

    /**
     * Gets the value of the sendArea property.
     * 
     * @return
     *     possible object is
     *     {@link Area }
     *     
     */
    public Area getSendArea() {
        return sendArea;
    }

    /**
     * Sets the value of the sendArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Area }
     *     
     */
    public void setSendArea(Area value) {
        this.sendArea = value;
    }

    /**
     * Gets the value of the sendCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendCompany() {
        return sendCompany;
    }

    /**
     * Sets the value of the sendCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendCompany(String value) {
        this.sendCompany = value;
    }

    /**
     * Gets the value of the sendMobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendMobile() {
        return sendMobile;
    }

    /**
     * Sets the value of the sendMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendMobile(String value) {
        this.sendMobile = value;
    }

    /**
     * Gets the value of the sendMobileMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendMobileMsg() {
        return sendMobileMsg;
    }

    /**
     * Sets the value of the sendMobileMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendMobileMsg(String value) {
        this.sendMobileMsg = value;
    }

    /**
     * Gets the value of the sendName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * Sets the value of the sendName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendName(String value) {
        this.sendName = value;
    }

    /**
     * Gets the value of the sendProNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendProNum() {
        return sendProNum;
    }

    /**
     * Sets the value of the sendProNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendProNum(String value) {
        this.sendProNum = value;
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
     * Gets the value of the wayBill property.
     * 
     * @return
     *     possible object is
     *     {@link WayBill }
     *     
     */
    public WayBill getWayBill() {
        return wayBill;
    }

    /**
     * Sets the value of the wayBill property.
     * 
     * @param value
     *     allowed object is
     *     {@link WayBill }
     *     
     */
    public void setWayBill(WayBill value) {
        this.wayBill = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeight(Double value) {
        this.weight = value;
    }

    /**
     * Gets the value of the workBills property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workBills property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkBills().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkBill }
     * 
     * 
     */
    public List<WorkBill> getWorkBills() {
        if (workBills == null) {
            workBills = new ArrayList<WorkBill>();
        }
        return this.workBills;
    }

}

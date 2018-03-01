
package cn.itcast.bos.service.take_delivery.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wayBill complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wayBill">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actlweit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="arriveCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeitemnum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="floadreqr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goodsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="num" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="order" type="{http://impl.take_delivery.service.bos.itcast.cn/}order" minOccurs="0"/>
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
 *         &lt;element name="sendName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendProNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wayBillNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wayBillType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wayBill", propOrder = {
    "actlweit",
    "arriveCity",
    "delTag",
    "feeitemnum",
    "floadreqr",
    "goodsType",
    "id",
    "num",
    "order",
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
    "sendName",
    "sendProNum",
    "signStatus",
    "vol",
    "wayBillNum",
    "wayBillType",
    "weight"
})
public class WayBill {

    protected Double actlweit;
    protected String arriveCity;
    protected String delTag;
    protected Integer feeitemnum;
    protected String floadreqr;
    protected String goodsType;
    protected Integer id;
    protected Integer num;
    protected Order order;
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
    protected String sendName;
    protected String sendProNum;
    protected Integer signStatus;
    protected String vol;
    protected String wayBillNum;
    protected String wayBillType;
    protected Double weight;

    /**
     * Gets the value of the actlweit property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getActlweit() {
        return actlweit;
    }

    /**
     * Sets the value of the actlweit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setActlweit(Double value) {
        this.actlweit = value;
    }

    /**
     * Gets the value of the arriveCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArriveCity() {
        return arriveCity;
    }

    /**
     * Sets the value of the arriveCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArriveCity(String value) {
        this.arriveCity = value;
    }

    /**
     * Gets the value of the delTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelTag() {
        return delTag;
    }

    /**
     * Sets the value of the delTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelTag(String value) {
        this.delTag = value;
    }

    /**
     * Gets the value of the feeitemnum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFeeitemnum() {
        return feeitemnum;
    }

    /**
     * Sets the value of the feeitemnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFeeitemnum(Integer value) {
        this.feeitemnum = value;
    }

    /**
     * Gets the value of the floadreqr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloadreqr() {
        return floadreqr;
    }

    /**
     * Sets the value of the floadreqr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloadreqr(String value) {
        this.floadreqr = value;
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
     * Gets the value of the num property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNum() {
        return num;
    }

    /**
     * Sets the value of the num property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNum(Integer value) {
        this.num = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setOrder(Order value) {
        this.order = value;
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
     * Gets the value of the signStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSignStatus() {
        return signStatus;
    }

    /**
     * Sets the value of the signStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSignStatus(Integer value) {
        this.signStatus = value;
    }

    /**
     * Gets the value of the vol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVol() {
        return vol;
    }

    /**
     * Sets the value of the vol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVol(String value) {
        this.vol = value;
    }

    /**
     * Gets the value of the wayBillNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWayBillNum() {
        return wayBillNum;
    }

    /**
     * Sets the value of the wayBillNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWayBillNum(String value) {
        this.wayBillNum = value;
    }

    /**
     * Gets the value of the wayBillType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWayBillType() {
        return wayBillType;
    }

    /**
     * Sets the value of the wayBillType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWayBillType(String value) {
        this.wayBillType = value;
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

}


package cn.itcast.crm.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerServiceImpl", targetNamespace = "http://service.crm.itcast.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerServiceImpl {


    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "LinkFixedAreaAndCustomer")
    @RequestWrapper(localName = "LinkFixedAreaAndCustomer", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.LinkFixedAreaAndCustomer")
    @ResponseWrapper(localName = "LinkFixedAreaAndCustomerResponse", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.LinkFixedAreaAndCustomerResponse")
    public void linkFixedAreaAndCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        List<Integer> arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<cn.itcast.crm.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLinkedCustomer", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.GetLinkedCustomer")
    @ResponseWrapper(localName = "getLinkedCustomerResponse", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.GetLinkedCustomerResponse")
    public List<Customer> getLinkedCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns cn.itcast.crm.service.Customer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByTelephone", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.FindByTelephone")
    @ResponseWrapper(localName = "findByTelephoneResponse", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.FindByTelephoneResponse")
    public Customer findByTelephone(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<cn.itcast.crm.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUnLinkedCustomer", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.GetUnLinkedCustomer")
    @ResponseWrapper(localName = "getUnLinkedCustomerResponse", targetNamespace = "http://service.crm.itcast.cn/", className = "cn.itcast.crm.service.GetUnLinkedCustomerResponse")
    public List<Customer> getUnLinkedCustomer();

}

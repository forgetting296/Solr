
package cn.itcast.crm.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.itcast.crm.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUnLinkedCustomer_QNAME = new QName("http://service.crm.itcast.cn/", "getUnLinkedCustomer");
    private final static QName _GetUnLinkedCustomerResponse_QNAME = new QName("http://service.crm.itcast.cn/", "getUnLinkedCustomerResponse");
    private final static QName _LinkFixedAreaAndCustomerResponse_QNAME = new QName("http://service.crm.itcast.cn/", "LinkFixedAreaAndCustomerResponse");
    private final static QName _GetLinkedCustomer_QNAME = new QName("http://service.crm.itcast.cn/", "getLinkedCustomer");
    private final static QName _LinkFixedAreaAndCustomer_QNAME = new QName("http://service.crm.itcast.cn/", "LinkFixedAreaAndCustomer");
    private final static QName _FindByTelephone_QNAME = new QName("http://service.crm.itcast.cn/", "findByTelephone");
    private final static QName _GetLinkedCustomerResponse_QNAME = new QName("http://service.crm.itcast.cn/", "getLinkedCustomerResponse");
    private final static QName _FindByTelephoneResponse_QNAME = new QName("http://service.crm.itcast.cn/", "findByTelephoneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.itcast.crm.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLinkedCustomer }
     * 
     */
    public GetLinkedCustomer createGetLinkedCustomer() {
        return new GetLinkedCustomer();
    }

    /**
     * Create an instance of {@link LinkFixedAreaAndCustomerResponse }
     * 
     */
    public LinkFixedAreaAndCustomerResponse createLinkFixedAreaAndCustomerResponse() {
        return new LinkFixedAreaAndCustomerResponse();
    }

    /**
     * Create an instance of {@link GetUnLinkedCustomer }
     * 
     */
    public GetUnLinkedCustomer createGetUnLinkedCustomer() {
        return new GetUnLinkedCustomer();
    }

    /**
     * Create an instance of {@link GetUnLinkedCustomerResponse }
     * 
     */
    public GetUnLinkedCustomerResponse createGetUnLinkedCustomerResponse() {
        return new GetUnLinkedCustomerResponse();
    }

    /**
     * Create an instance of {@link FindByTelephoneResponse }
     * 
     */
    public FindByTelephoneResponse createFindByTelephoneResponse() {
        return new FindByTelephoneResponse();
    }

    /**
     * Create an instance of {@link GetLinkedCustomerResponse }
     * 
     */
    public GetLinkedCustomerResponse createGetLinkedCustomerResponse() {
        return new GetLinkedCustomerResponse();
    }

    /**
     * Create an instance of {@link FindByTelephone }
     * 
     */
    public FindByTelephone createFindByTelephone() {
        return new FindByTelephone();
    }

    /**
     * Create an instance of {@link LinkFixedAreaAndCustomer }
     * 
     */
    public LinkFixedAreaAndCustomer createLinkFixedAreaAndCustomer() {
        return new LinkFixedAreaAndCustomer();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnLinkedCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "getUnLinkedCustomer")
    public JAXBElement<GetUnLinkedCustomer> createGetUnLinkedCustomer(GetUnLinkedCustomer value) {
        return new JAXBElement<GetUnLinkedCustomer>(_GetUnLinkedCustomer_QNAME, GetUnLinkedCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnLinkedCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "getUnLinkedCustomerResponse")
    public JAXBElement<GetUnLinkedCustomerResponse> createGetUnLinkedCustomerResponse(GetUnLinkedCustomerResponse value) {
        return new JAXBElement<GetUnLinkedCustomerResponse>(_GetUnLinkedCustomerResponse_QNAME, GetUnLinkedCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkFixedAreaAndCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "LinkFixedAreaAndCustomerResponse")
    public JAXBElement<LinkFixedAreaAndCustomerResponse> createLinkFixedAreaAndCustomerResponse(LinkFixedAreaAndCustomerResponse value) {
        return new JAXBElement<LinkFixedAreaAndCustomerResponse>(_LinkFixedAreaAndCustomerResponse_QNAME, LinkFixedAreaAndCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLinkedCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "getLinkedCustomer")
    public JAXBElement<GetLinkedCustomer> createGetLinkedCustomer(GetLinkedCustomer value) {
        return new JAXBElement<GetLinkedCustomer>(_GetLinkedCustomer_QNAME, GetLinkedCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkFixedAreaAndCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "LinkFixedAreaAndCustomer")
    public JAXBElement<LinkFixedAreaAndCustomer> createLinkFixedAreaAndCustomer(LinkFixedAreaAndCustomer value) {
        return new JAXBElement<LinkFixedAreaAndCustomer>(_LinkFixedAreaAndCustomer_QNAME, LinkFixedAreaAndCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByTelephone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findByTelephone")
    public JAXBElement<FindByTelephone> createFindByTelephone(FindByTelephone value) {
        return new JAXBElement<FindByTelephone>(_FindByTelephone_QNAME, FindByTelephone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLinkedCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "getLinkedCustomerResponse")
    public JAXBElement<GetLinkedCustomerResponse> createGetLinkedCustomerResponse(GetLinkedCustomerResponse value) {
        return new JAXBElement<GetLinkedCustomerResponse>(_GetLinkedCustomerResponse_QNAME, GetLinkedCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByTelephoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findByTelephoneResponse")
    public JAXBElement<FindByTelephoneResponse> createFindByTelephoneResponse(FindByTelephoneResponse value) {
        return new JAXBElement<FindByTelephoneResponse>(_FindByTelephoneResponse_QNAME, FindByTelephoneResponse.class, null, value);
    }

}

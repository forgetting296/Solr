
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

    private final static QName _RegistResponse_QNAME = new QName("http://service.crm.itcast.cn/", "registResponse");
    private final static QName _FindAll_QNAME = new QName("http://service.crm.itcast.cn/", "findAll");
    private final static QName _GetUnLinkedCustomer_QNAME = new QName("http://service.crm.itcast.cn/", "getUnLinkedCustomer");
    private final static QName _GetLinkedCustomer_QNAME = new QName("http://service.crm.itcast.cn/", "getLinkedCustomer");
    private final static QName _FindByEmailResponse_QNAME = new QName("http://service.crm.itcast.cn/", "findByEmailResponse");
    private final static QName _FindByTelephone_QNAME = new QName("http://service.crm.itcast.cn/", "findByTelephone");
    private final static QName _GetLinkedCustomerResponse_QNAME = new QName("http://service.crm.itcast.cn/", "getLinkedCustomerResponse");
    private final static QName _UpdateType_QNAME = new QName("http://service.crm.itcast.cn/", "updateType");
    private final static QName _UpdateTypeResponse_QNAME = new QName("http://service.crm.itcast.cn/", "updateTypeResponse");
    private final static QName _FindByEmail_QNAME = new QName("http://service.crm.itcast.cn/", "findByEmail");
    private final static QName _GetUnLinkedCustomerResponse_QNAME = new QName("http://service.crm.itcast.cn/", "getUnLinkedCustomerResponse");
    private final static QName _LinkFixedAreaAndCustomerResponse_QNAME = new QName("http://service.crm.itcast.cn/", "LinkFixedAreaAndCustomerResponse");
    private final static QName _FindByAddressResponse_QNAME = new QName("http://service.crm.itcast.cn/", "findByAddressResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://service.crm.itcast.cn/", "findAllResponse");
    private final static QName _LinkFixedAreaAndCustomer_QNAME = new QName("http://service.crm.itcast.cn/", "LinkFixedAreaAndCustomer");
    private final static QName _FindByAddress_QNAME = new QName("http://service.crm.itcast.cn/", "findByAddress");
    private final static QName _FindByTelephoneResponse_QNAME = new QName("http://service.crm.itcast.cn/", "findByTelephoneResponse");
    private final static QName _Regist_QNAME = new QName("http://service.crm.itcast.cn/", "regist");

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
     * Create an instance of {@link GetUnLinkedCustomer }
     * 
     */
    public GetUnLinkedCustomer createGetUnLinkedCustomer() {
        return new GetUnLinkedCustomer();
    }

    /**
     * Create an instance of {@link RegistResponse }
     * 
     */
    public RegistResponse createRegistResponse() {
        return new RegistResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link GetLinkedCustomerResponse }
     * 
     */
    public GetLinkedCustomerResponse createGetLinkedCustomerResponse() {
        return new GetLinkedCustomerResponse();
    }

    /**
     * Create an instance of {@link UpdateType }
     * 
     */
    public UpdateType createUpdateType() {
        return new UpdateType();
    }

    /**
     * Create an instance of {@link FindByEmailResponse }
     * 
     */
    public FindByEmailResponse createFindByEmailResponse() {
        return new FindByEmailResponse();
    }

    /**
     * Create an instance of {@link FindByTelephone }
     * 
     */
    public FindByTelephone createFindByTelephone() {
        return new FindByTelephone();
    }

    /**
     * Create an instance of {@link LinkFixedAreaAndCustomerResponse }
     * 
     */
    public LinkFixedAreaAndCustomerResponse createLinkFixedAreaAndCustomerResponse() {
        return new LinkFixedAreaAndCustomerResponse();
    }

    /**
     * Create an instance of {@link GetUnLinkedCustomerResponse }
     * 
     */
    public GetUnLinkedCustomerResponse createGetUnLinkedCustomerResponse() {
        return new GetUnLinkedCustomerResponse();
    }

    /**
     * Create an instance of {@link UpdateTypeResponse }
     * 
     */
    public UpdateTypeResponse createUpdateTypeResponse() {
        return new UpdateTypeResponse();
    }

    /**
     * Create an instance of {@link FindByEmail }
     * 
     */
    public FindByEmail createFindByEmail() {
        return new FindByEmail();
    }

    /**
     * Create an instance of {@link Regist }
     * 
     */
    public Regist createRegist() {
        return new Regist();
    }

    /**
     * Create an instance of {@link FindByTelephoneResponse }
     * 
     */
    public FindByTelephoneResponse createFindByTelephoneResponse() {
        return new FindByTelephoneResponse();
    }

    /**
     * Create an instance of {@link FindByAddress }
     * 
     */
    public FindByAddress createFindByAddress() {
        return new FindByAddress();
    }

    /**
     * Create an instance of {@link LinkFixedAreaAndCustomer }
     * 
     */
    public LinkFixedAreaAndCustomer createLinkFixedAreaAndCustomer() {
        return new LinkFixedAreaAndCustomer();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindByAddressResponse }
     * 
     */
    public FindByAddressResponse createFindByAddressResponse() {
        return new FindByAddressResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "registResponse")
    public JAXBElement<RegistResponse> createRegistResponse(RegistResponse value) {
        return new JAXBElement<RegistResponse>(_RegistResponse_QNAME, RegistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLinkedCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "getLinkedCustomer")
    public JAXBElement<GetLinkedCustomer> createGetLinkedCustomer(GetLinkedCustomer value) {
        return new JAXBElement<GetLinkedCustomer>(_GetLinkedCustomer_QNAME, GetLinkedCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findByEmailResponse")
    public JAXBElement<FindByEmailResponse> createFindByEmailResponse(FindByEmailResponse value) {
        return new JAXBElement<FindByEmailResponse>(_FindByEmailResponse_QNAME, FindByEmailResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "updateType")
    public JAXBElement<UpdateType> createUpdateType(UpdateType value) {
        return new JAXBElement<UpdateType>(_UpdateType_QNAME, UpdateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "updateTypeResponse")
    public JAXBElement<UpdateTypeResponse> createUpdateTypeResponse(UpdateTypeResponse value) {
        return new JAXBElement<UpdateTypeResponse>(_UpdateTypeResponse_QNAME, UpdateTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findByEmail")
    public JAXBElement<FindByEmail> createFindByEmail(FindByEmail value) {
        return new JAXBElement<FindByEmail>(_FindByEmail_QNAME, FindByEmail.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findByAddressResponse")
    public JAXBElement<FindByAddressResponse> createFindByAddressResponse(FindByAddressResponse value) {
        return new JAXBElement<FindByAddressResponse>(_FindByAddressResponse_QNAME, FindByAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findByAddress")
    public JAXBElement<FindByAddress> createFindByAddress(FindByAddress value) {
        return new JAXBElement<FindByAddress>(_FindByAddress_QNAME, FindByAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByTelephoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "findByTelephoneResponse")
    public JAXBElement<FindByTelephoneResponse> createFindByTelephoneResponse(FindByTelephoneResponse value) {
        return new JAXBElement<FindByTelephoneResponse>(_FindByTelephoneResponse_QNAME, FindByTelephoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Regist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.itcast.cn/", name = "regist")
    public JAXBElement<Regist> createRegist(Regist value) {
        return new JAXBElement<Regist>(_Regist_QNAME, Regist.class, null, value);
    }

}

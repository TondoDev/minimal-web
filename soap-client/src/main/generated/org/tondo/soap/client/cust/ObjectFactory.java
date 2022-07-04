
package org.tondo.soap.client.cust;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tondo.soap.client.cust package. 
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

    private final static QName _CustomerSearchResult_QNAME = new QName("http://svc.server.soap.tondo.org/", "customerSearchResult");
    private final static QName _SearchCustomer_QNAME = new QName("http://svc.server.soap.tondo.org/", "searchCustomer");
    private final static QName _SearchCustomerResponse_QNAME = new QName("http://svc.server.soap.tondo.org/", "searchCustomerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tondo.soap.client.cust
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerSearchResult }
     * 
     */
    public CustomerSearchResult createCustomerSearchResult() {
        return new CustomerSearchResult();
    }

    /**
     * Create an instance of {@link SearchCustomer }
     * 
     */
    public SearchCustomer createSearchCustomer() {
        return new SearchCustomer();
    }

    /**
     * Create an instance of {@link SearchCustomerResponse }
     * 
     */
    public SearchCustomerResponse createSearchCustomerResponse() {
        return new SearchCustomerResponse();
    }

    /**
     * Create an instance of {@link SearchCriteria }
     * 
     */
    public SearchCriteria createSearchCriteria() {
        return new SearchCriteria();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerSearchResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerSearchResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://svc.server.soap.tondo.org/", name = "customerSearchResult")
    public JAXBElement<CustomerSearchResult> createCustomerSearchResult(CustomerSearchResult value) {
        return new JAXBElement<CustomerSearchResult>(_CustomerSearchResult_QNAME, CustomerSearchResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://svc.server.soap.tondo.org/", name = "searchCustomer")
    public JAXBElement<SearchCustomer> createSearchCustomer(SearchCustomer value) {
        return new JAXBElement<SearchCustomer>(_SearchCustomer_QNAME, SearchCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://svc.server.soap.tondo.org/", name = "searchCustomerResponse")
    public JAXBElement<SearchCustomerResponse> createSearchCustomerResponse(SearchCustomerResponse value) {
        return new JAXBElement<SearchCustomerResponse>(_SearchCustomerResponse_QNAME, SearchCustomerResponse.class, null, value);
    }

}

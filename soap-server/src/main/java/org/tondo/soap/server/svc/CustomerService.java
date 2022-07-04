package org.tondo.soap.server.svc;

import java.time.LocalDate;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public class CustomerService {

	
	@WebMethod
	public CustomerSearchResult searchCustomer(@WebParam(name = "criteria") SearchCriteria criteria) {
		CustomerSearchResult result = new CustomerSearchResult();
		
		String firstName = criteria.getName() == null ? "Dilino" : criteria.getName();
		
		result.setName(firstName);
		result.setSurname("Surname:"+firstName);
		result.setBirthDate(LocalDate.of(1890, 1, 15));
		result.setCredit(1008.85);
		result.setCustId(criteria.getCustId() == null ? 1324 : criteria.getCustId());
		
		return result;
	}
}

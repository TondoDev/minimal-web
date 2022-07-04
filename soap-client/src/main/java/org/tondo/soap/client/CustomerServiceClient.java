package org.tondo.soap.client;

import org.tondo.soap.client.cust.CustomerSearchResult;
import org.tondo.soap.client.cust.CustomerService;
import org.tondo.soap.client.cust.CustomerServiceService;
import org.tondo.soap.client.cust.SearchCriteria;

public class CustomerServiceClient {

	public static void main(String[] args) {
		
		CustomerServiceService customerServiceProvider = new CustomerServiceService();
		
		CustomerService customerServicePort = customerServiceProvider.getCustomerServicePort();
		
		SearchCriteria criteria = new SearchCriteria();
		criteria.setCustId(5);
		criteria.setName("Tondo");
		CustomerSearchResult customerResult = customerServicePort.searchCustomer(criteria);
	
		System.out.println("Name: " + customerResult.getName());
		System.out.println("Surname: " + customerResult.getSurname());
		System.out.println("Credit: " + customerResult.getCredit());
		System.out.println("CustId: " + customerResult.getCustId());
		System.out.println("birtDate: " + customerResult.getBirthDate());
	}
}

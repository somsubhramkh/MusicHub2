package musichub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import musichub.dao.CustomerDAO;
import musichub.dao.ProductDAO;
import musichub.model.Customer;
import musichub.model.Product;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO c) {
		this.customerDAO = c;
	}

	@Transactional
	public void addCustomer(Customer c) {
		customerDAO.addCustomer(c);
	}

	@Transactional
	public void updateCustomer(Customer c) {
		customerDAO.updateCustomer(c);
	}

	@Transactional
	public List<Customer> listCustomers() {
		return customerDAO.listCustomers();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

}

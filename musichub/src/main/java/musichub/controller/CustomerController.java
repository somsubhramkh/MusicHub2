package musichub.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import musichub.model.Customer;
import musichub.service.CustomerService;


public class CustomerController {

	private CustomerService customerService;

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	public void setCustomerService(CustomerService ps) {
		this.customerService = ps;
	}

	@RequestMapping(value = "/CustomerAdmin/add")
	public String addProduct(@Valid @ModelAttribute("customer") Customer c, BindingResult result) {

		customerService.addCustomer(c);
		
		
			return "redirect:/ProductAdmin";
		}

	}




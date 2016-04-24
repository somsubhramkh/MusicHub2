package musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import musichub.dao.ProductDAO;
import musichub.model.Product;
import musichub.service.ProductService;

@Controller
public class HomeController {
	
	
	private ProductService productService;
	 
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps){
		this.productService = ps;
	}
	 	

	@RequestMapping("/")
	public ModelAndView index()
	{
		ModelAndView model=new ModelAndView("index");
		return model;
	}
	
	@RequestMapping("/Register")
	public ModelAndView registerPage()
	{
		ModelAndView model=new ModelAndView("Register");
		return model;
	}
	
	@RequestMapping("/AboutUs")
	public ModelAndView aboutUsPage()
	{
		ModelAndView model=new ModelAndView("AboutUs");
		return model;
	}
	
	@RequestMapping("/ContactUs")
	public ModelAndView contactUsPage()
	{
		ModelAndView model=new ModelAndView("ContactUs");
		return model;
	}
	
	
	@RequestMapping("/Product")
	public ModelAndView productPage()
	{
		
		List<Product> products= productService.listProducts();
		String json=new Gson().toJson(products);
		
		ModelAndView model=new ModelAndView("Product");
		model.addObject("prodData", json);
		return model;
	}
	
	
	
	
	/* Added for implementing Spring Security*/
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
     
    return "Login";
     
    }
     
    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
    model.addAttribute("error", "true");
    return "Login";
     
    }
    
    @RequestMapping("/ProductDetails")
	public ModelAndView productDetailsPage(){
		ModelAndView model=new ModelAndView("ProductDetails");
		return model;
    }

    
	
}

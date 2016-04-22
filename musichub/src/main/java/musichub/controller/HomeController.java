package musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import musichub.dao.ProductDAO;
import musichub.model.Product;
import musichub.service.ProductService;

@Controller
public class HomeController {
	
	

	/*@Autowired*/
	private ProductService productService;
	 
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps){
		this.productService = ps;
	}
	 

	/*@Autowired(required=true)
	@Qualifier(value="productService")
	public ProductService getProductService() {
		return productService;
	}*/
	

	

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
	
	@RequestMapping("/Product/{category}")
	public ModelAndView productPage(@PathVariable("category") String category)
	{
		
		List<Product> products= productService.listProducts();
		String json=new Gson().toJson(products);
		
		ModelAndView model=new ModelAndView("Product");
		model.addObject("prodData", json);
		model.addObject("category", category);
		return model;
	}
	
	/*@RequestMapping("/Product/{cat}")
	public ModelAndView productPage(@PathVariable("cat") int cat)
	{
		
		List<Product> products= productService.listProducts();
		String json=new Gson().toJson(products);
		
		ModelAndView model=new ModelAndView("Product/"+cat);
		model.addObject("prodData", json);
		model.addObject("cat",cat);
		return model;
	}*/
	/*Experimental Block*/
	
	@RequestMapping(value = "/ProductAdmin")
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "ProductAdmin";
    }
     
    
    @RequestMapping(value= "/ProductAdmin/add")
    public String addProduct(@ModelAttribute("product") Product p){
         
        if(p.getId() == 0){
            
            this.productService.addProduct(p);
        }else{
            
            this.productService.updateProduct(p);
        }
         
        return "redirect:/ProductAdmin";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
         
        this.productService.removeProduct(id);
        return "redirect:/ProductAdmin";
    }
  
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "ProductAdmin";
    }

	
	
	
	/*@RequestMapping("/Product/{cat}")
	public String productPage(@PathVariable("cat")String cat,Model model)
	{
		List<Product> products= productService.listProducts();
		String json=new Gson().toJson(products);
		model.addAttribute("cat",cat);
		model.addAttribute("prodData", json);
		return "Product";
	}*/
}

package musichub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import musichub.model.Product;
import musichub.service.ProductService;

public class AdminController {

	/*
	private ProductService productService;
	 
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps){
		this.productService = ps;
	}
     
    @RequestMapping(value = "/ProductAdmin", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "ProductAdmin";
    }
     
    
    @RequestMapping(value= "/ProductAdmin/add", method = RequestMethod.POST)
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
	*/
	
}

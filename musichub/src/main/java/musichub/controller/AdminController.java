package musichub.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import musichub.model.Product;
import musichub.service.ProductService;


@Controller
public class AdminController {
	
	

	private ProductService productService;
	 
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps){
		this.productService = ps;
	}

	@RequestMapping(value = "/ProductAdmin")
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "ProductAdmin";
    }
     
    
    @RequestMapping(value= "/ProductAdmin/add")
    public String addProduct(@Valid @ModelAttribute("product") Product p, BindingResult result){
     
		if (result.hasErrors()) {
			//ModelAndView model = new ModelAndView("/ProductAdmin");
			return "ProductAdmin";
		} else {
			if (p.getId() == 0) {

				this.productService.addProduct(p);
			} else {

				this.productService.updateProduct(p);
			}

			return "redirect:/ProductAdmin";
		}
         
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

		
}

package musichub.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;



import musichub.model.Product;
import musichub.service.ProductService;


@Controller
public class AdminController{
	
	

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
     
    
   /* @RequestMapping(value= "/ProductAdmin/add")
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
         
    }*/
	

	@RequestMapping(value= "/ProductAdmin/add")
    public String addProduct(@Valid @ModelAttribute("product") Product p, BindingResult result, HttpServletRequest request){
     
		  String filename=null;
		  byte[] bytes;
		  if(!p.getImage().isEmpty())
	        {
			 
	            try
	            {
	                //filename=p.getImage().getOriginalFilename();
	               
	            	 bytes=p.getImage().getBytes();
	                productService.addProduct(p);
	                System.out.println("Data Inserted");
	            
	           
	        
	        //ServletContext context=request.getServletContext();
	        //String path=servletContext.getRealPath("./resources/"+p.getId()+".jpg");
		    String path=request.getSession().getServletContext().getRealPath("/resources/"+p.getId()+".jpg");
	        System.out.println("Path = "+path);
	        System.out.println("File name = "+p.getImage().getOriginalFilename());
	        //File f=new File(path);
	        File f=new File(path);
	        BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
            bs.write(bytes);
            bs.close();
            System.out.println("Image uploaded");
	            }
            catch(Exception ex)
	            {
	                System.out.println(ex.getMessage());
	            }
	        }
       
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

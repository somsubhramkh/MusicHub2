package musichub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import musichub.dao.ProductDAO;
import musichub.model.Product;

@Service
public class ProductService {
    
	@Autowired
	private ProductDAO productDAO;
	
	
	public void setProductDAO(ProductDAO p){
		this.productDAO = p;
	}
	
/*	public void setProductDAO(ProductDAOImpl productDAO) {
		this.productDAO = productDAO;
	}*/

	
	@Transactional
	public void addProduct(Product p) {
		productDAO.addProduct(p);
	}

	
	@Transactional
	public void updateProduct(Product p) {
		productDAO.updateProduct(p);
	}

	
	@Transactional
	public List<Product> listProducts() {
		return productDAO.listProducts();
	}

	
	@Transactional
	public Product getProductById(int id) {
		return productDAO.getProductById(id);
	}

	
	@Transactional
	public void removeProduct(int id) {
		this.productDAO.removeProduct(id);
	}
 
}
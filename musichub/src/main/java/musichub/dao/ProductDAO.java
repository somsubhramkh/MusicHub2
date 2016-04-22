package musichub.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musichub.model.Product;

@Repository
public class ProductDAO{

	private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	
	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Product saved successfully, Product Details="+p);
		
	}


	public void updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Product updated successfully, Product Details="+p);
	}

	@SuppressWarnings("unchecked")

	public List<Product> listProducts() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Product> productList = session.createQuery("from Product").list();
		for(Product p : productList){
            logger.info("Product List::"+p);
        }
	
		return productList;
	}


	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Product p = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product loaded successfully, Product details="+p);
		return p;
	}


	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Product deleted successfully, Product details="+p);
		
	}
	
	
	
	
/*	 //list is working as a database
	   List<Product> products;
	   
	   @Autowired
	   private ApplicationContext appContext;
	   
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	  
	  Session session;
	   
	   private SessionFactory sessionFactory;
	   
	   public SessionFactory getSessionFactory() {
	   return sessionFactory;
	   }
	   public void setSessionFactory(SessionFactory sessionFactory) {
	   this.sessionFactory = sessionFactory;
	   }
	  
	  @Autowired
	  public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	        }
	    

	   public ProductDAOImpl(){
		   
		   
		   BeanFactory bf=(BeanFactory)appContext.getBean("sessionFactory");
		   sessionFactory=((SessionFactory)bf);
		   session=sessionFactory.getCurrentSession();
		   
	      products = new ArrayList<Product>();
	      Product product1 = new Product(1, "SA 110 Accoustic Guitar", 9700.00, "Accoustic Guitar", "Fender", "Guitar");
	      Product product2 = new Product(2, "SA 105 Accoustic Guitar", 7800.00, "Accoustic Guitar", "Fender", "Guitar");
	      products.add(product1);
	      products.add(product2);
	   }
	   
	   
	   public void deleteProduct(Product product) {
	      products.remove(product.getID());
	      
	   }

	 
	   public List<Product> getAllProducts() {
	      //return products;
		   
		   Session session = sessionFactory.getCurrentSession();
		   //session.beginTransaction();
		   //Query q=session.createQuery("from Product");
	        List<Product> productList = session.createQuery("from Product").list();
	        if(productList==null)
	        {
	        	System.out.println("Product List is empty");
	        }
	        for(Product p : productList){
	            logger.info("Person List::"+p);
	        }
	        
	        //session.getTransaction().commit();
	        session.flush();
	        
	        
	        return productList;
	   }

	   
	   public Product getProduct(int ID) {
	      return products.get(ID);
	   }

	   
	   public void updateProduct(Product product) {
	      products.get(product.getID()).setName(product.getName());
	      
	   }*/
	}


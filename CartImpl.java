package com.PickFresh.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PickFresh.DAO.CartDAO;
import com.PickFresh.model.AddProduct;
import com.PickFresh.model.Cart;

@Service("CartDAO")
public class CartImpl implements CartDAO{

	@Autowired
	SessionFactory sessionFactory;
	public void cartsave(Cart ap) {
		System.out.println("Cart DAO");
		//UserCredential uc=new UserCredential();
		//uc.setUsername(r.getUsername());
		//uc.setPassword(r.getPassword());
		//System.out.println("User Credentials");
		try
		{
		Session session= sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//tx.begin();
		session.save(ap);
		
		//session.save(uc);
		tx.commit();
		session.flush();
		session.close();
		} 
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}		
	}
	 public List<Cart> cartlist() {
	    	Session session =sessionFactory.openSession();
	    	//System.out.println("view product session object"+session);
	    	 Transaction transaction =  session.beginTransaction();
	    	List<Cart> productList=null;
	        try {
	        productList= session.createQuery("from Cart").list();   
      	    transaction.commit();                 
        }
       catch (Exception e) {
       transaction.rollback();
       e.printStackTrace();
	       }
	     session.close();
		 return productList;
	    }
	 public AddProduct single_object(int pid)
     {
        Session session =sessionFactory.openSession();
       // System.out.println("single object session"+session);
	      Transaction transaction =  session.beginTransaction();
	      List<AddProduct> b4=null;
	    	try
	        {
	    	//String query=.list();
	    	//System.out.println(query);
          b4 =  session.createQuery("from AddProduct where pid= :pid").setParameter("pid",pid).list();
       //  System.out.println("*****"+b4.get(0));
          transaction.commit();
          session.close();             
	    }        
	    catch (Exception e) 
	    {
         transaction.rollback();
         e.printStackTrace();
      }
	     return b4.get(0);
     }
	 public void deleteRow(int productId) {  
    	   Session session =sessionFactory.openSession();
     	   Transaction transaction =  session.beginTransaction();
	       List<Cart> del=null;
	       try{
	    	 del=session.createQuery("from Cart where productId=:productId").setParameter("productId", productId).list();
	          session.delete(del.get(0));
	          transaction.commit();
            session.close();
	    
	       }
    catch(Exception e){
        transaction.rollback();
        e.printStackTrace();
  }
}
}


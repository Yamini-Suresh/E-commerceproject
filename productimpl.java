package com.PickFresh.serviceimp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PickFresh.dao.productdao;
import com.PickFresh.model.product;


@Service
public class productimpl implements productdao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void addproduct(product add) {
		System.out.println("product dao");
		System.out.println(add.getName());
		//UserCredential uc=new UserCredential();
		//uc.setUsername(r.getUsername());
		//uc.setPassword(r.getPassword());
		
		try
		{
		Session session= sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//tx.begin();
		session.save(add);
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
	
 	public List<product> getproducts() {
    	Session session =sessionFactory.openSession();
    	 Transaction transaction =  session.beginTransaction();
    	List<product> productList=null;
	        try {
	        productList= session.createQuery("from product").list();   
	        transaction.commit();                 
       }
      catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
       }
	     session.close();
	 return productList;
    }
 	 public void edit_list(product adp){
 	       Session session =sessionFactory.openSession();
 	    Transaction transaction =  session.beginTransaction();
 	    List<product> editlist=null;
 	            try {
 	        String query1="from product where pid= :adp.getid() ";
 	            editlist =  session.createQuery(query1).list();
 	            
 	            editlist.get(0).setId(adp.getId());
 	            editlist.get(0).setName(adp.getName());
 	            editlist.get(0).setPrice(adp.getPrice());
 	            editlist.get(0).setPrice(adp.getDesc());
 	            editlist.get(0).setQuantity(adp.getQuantity());
 	           editlist.get(0).setAvailablity(adp.getAvailablity());
 	            session.saveOrUpdate(editlist.get(0));
 	            transaction.commit();
 	            }
 	           catch (Exception e) {
 	               transaction.rollback();
 	               e.printStackTrace();
 	       }
 	           session.close();  
 	        }
 	       
 	       public product single_object(int id)
 	       {
 	    Session session =sessionFactory.openSession();
 	    Transaction transaction =  session.beginTransaction();
 	    List<product> b4=null;
 	    try
 	    {
 	   // String query="from product where pid= :id";
 	        b4 =  session.createQuery("from product where pid= :id").setParameter("id", id).list();
 	        transaction.commit();
 	       }        
 	    catch (Exception e) {
 	              transaction.rollback();
 	              e.printStackTrace();
 	       }
 	           session.close();
 	    return b4.get(0);
 	       }
 	              
}
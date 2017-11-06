package com.PickFresh.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PickFresh.model.AddProduct;
import com.PickFresh.serviceimpl.AddProductImpl;
@Controller
public class UserController {

	@Autowired
	AddProductImpl apdao;
	
	@RequestMapping("/logout")  
	 public ModelAndView getLoginForm(  
	   @RequestParam(value = "logout", required = false) String logout) {  
	  
	  String message = "";  
	   if (logout != null) {  
	   message = "Logout successful !";  
	  }  
	  return new ModelAndView("login", "message", message);  
	 }  
	  
	@RequestMapping(value="getallproducts")
    public ModelAndView listOfTeams() {
	 //AddProduct addp=new AddProduct();
        ModelAndView modelAndView = new ModelAndView("getallproducts");
         	        List<AddProduct> teams = apdao.getProducts();
         	        //System.out.println("obj:"+teams);
        modelAndView.addObject("lists", teams);
        	        return modelAndView;
    }
	@RequestMapping(value="cart")
	 
	 public String cart()
	 {
		 System.out.println("cart");
		 return "cart";
	 }
	
}

package com.PickFresh.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

		
import com.PickFresh.dao.productdao;
import com.PickFresh.model.product;

	

	@Controller("productcontroller")
	public class productcontroller 
	{
		
		@Autowired
        productdao pdao;
		@RequestMapping(value="product", method=RequestMethod.GET)
		public ModelAndView getLogin(@ModelAttribute("product")product product)
		{
				System.out.println("product");	
				ModelAndView model=new ModelAndView("product");
				return model;
		}
		
		
		@RequestMapping(value="product", method=RequestMethod.POST)
		public ModelAndView Success(product add, Model m)
		{
				pdao.addproduct(add);
				ModelAndView model=new ModelAndView("product","product", new product());
				return model;
		}
		
		@RequestMapping(value="viewproduct")
	    public ModelAndView listOfTeams() {
		 //AddProduct addp=new AddProduct();
	        ModelAndView modelAndView = new ModelAndView("viewproduct");
	         	        List<product> teams = pdao.getproducts();
	         	        //System.out.println("obj:"+teams);
	        modelAndView.addObject("lists", teams);
	        	        return modelAndView;
	    }

		@RequestMapping("editproduct/{id}")  
		public ModelAndView editUser(@PathVariable int id) {  
		  product apobj = pdao.single_object(id);  
		  return new ModelAndView("editproduct", "command",apobj );  
		}  
		@RequestMapping(value="update",method=RequestMethod.POST)  
		public ModelAndView updateUser(@ModelAttribute("apobj") product adp) {  
		  pdao.edit_list(adp);  
		  return new ModelAndView("edit-success");  
		}  
		
	}
		


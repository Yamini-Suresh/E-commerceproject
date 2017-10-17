package com.PickFresh.Controller;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.PickFresh.Dao.registerDao;
import com.PickFresh.model.UserCredential;

@Controller
public class loginController {

	
	@Autowired
	 registerDao registerdao;

	//@SuppressWarnings("unchecked")
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/login_session_attributes")
		public String login_session_attributes(HttpSession session,Model model) {
			System.out.println("Spring Security");
			String userid = SecurityContextHolder.getContext().getAuthentication().getName();
			//UserCredential user = registerdao.getuserid(userid);
			//session.setAttribute("name", user.getName());
			//session.setAttribute("password", user.getPassword());
			//session.setAttribute("LoggedIn", "true");

			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			String page="";
			String role="ROLE_USER";
			for (GrantedAuthority authority : authorities) 
			{
			  
			     if (authority.getAuthority().equals(role)) 
			     {
			    	 session.setAttribute("edit", "true");
			    	 //session.setAttribute("name", userid);
				     page="/edit_success";
			    	 //session.setAttribute("cartsize",cartDAO.cartsize((int)session.getAttribute("userId")));
			     }
			     else 
			     {
			    	 session.setAttribute("admin", "true");
				     page="/admin";
				     break;
			    }
			}
			return page;
		}


	   //@RequestMapping(value="product")
		//public String product()
		//{
			//System.out.println("product");
			//return "product";
		//}

}

package com.PickFresh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("homepagecontroller")
class homepagecontroller {
@RequestMapping(value="login")
public String login()
{
System.out.println("login");
return "login";
}

	@RequestMapping(value="register")
public String register()
{
System.out.println("register");
return "register";
}



@RequestMapping(value="about")
public String about()
{
System.out.println("about");
return "about";
}


@RequestMapping(value="contact")
public String contact()
{
System.out.println("contact");
return "contact";
}
@RequestMapping(value="product")
public String product()
{
System.out.println("product");
return "product";
}
}
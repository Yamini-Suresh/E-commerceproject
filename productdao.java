package com.PickFresh.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PickFresh.model.product;

@Service("productdao")
public interface productdao {
	public void addproduct(product add);
	//public void editproduct(int i);
	//public void delproduct(int i);
	//public void showproduct();
	public List<product> getproducts();
	public product single_object(int pid);
	public void edit_list(product adp);
	

}

package com.PickFresh.DAO;

import java.util.List;

import com.PickFresh.model.AddProduct;
import com.PickFresh.model.Cart;

public interface CartDAO {

  void cartsave(Cart cart1);
  List<Cart> cartlist();
AddProduct single_object(int pid);
public void deleteRow(int productId);
}

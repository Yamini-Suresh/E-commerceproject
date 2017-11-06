package com.PickFresh.model;

public class Items {
	 
	 private AddProduct product=new  AddProduct();
	 
	 private int quantity;

	 public AddProduct getProduct() {
	  return product;
	 }

	 public void setProduct(AddProduct product) {
	  this.product = product;
	 }

	 public int getQuantity() {
	  return quantity;
	 }

	 public void setQuantity(int quantity) {
	  this.quantity = quantity;
	 }

	 public Items(AddProduct product, int quantity) {
	  super();
	  this.product = product;
	  this.quantity = quantity;
	 }

	 public Items() {
	  super();
	 }
	 
	 

	}
package com.PickFresh.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class product
{
@Id()
@GeneratedValue(strategy=GenerationType.AUTO)
 int id;
@Column
String name;
@Column
String quantity;
@Column
String price;
@Column
String  availablity;
@Column
String desc;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getAvailablity() {
	return availablity;
}
public void setAvailablity(String availablity) {
	this.availablity = availablity;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}

}


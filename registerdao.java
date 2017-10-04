package com.PickFresh.dao;
import org.springframework.stereotype.Repository;
import com.PickFresh.model.register;
@Repository
public interface registerdao
{
public void adduser(register r);
public void getinfo();
public void edituser(int i);
public void deluser(int i);
public void showuser();
}
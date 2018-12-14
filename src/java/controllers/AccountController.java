/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import entities.Employee;
import interfaces.AccountInterface;
import interfaces.DAOInterface;
import org.hibernate.SessionFactory;

/**
 *
 * @author yudafatah
 */
public class AccountController implements AccountInterface{
    DAOInterface daoi;

    public AccountController() {
    }

    public AccountController(SessionFactory factory) {
        this.daoi = new GeneralDAO(factory);
    }
    public boolean login(String username, String password){
        return daoi.login(username, password);
    }

    @Override
    public Object getById(Object entity, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee find(String username) {
        return daoi.find(username);
    }
}

package controllers;

import daos.GeneralDAO;
import interfaces.DAOInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author EMDES
 */
public class EmployeeController implements interfaces.EmployeeInterface {

        DAOInterface daoi;

    public EmployeeController() {
    }

    public EmployeeController(SessionFactory factory) {
        this.daoi = new GeneralDAO(factory);
    }
    /**
     * 
     * @param Id
     * @return 
     */
    @Override
    public Object getById(String Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param id
     * @param name
     * @return 
     */
    @Override
    public String update(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

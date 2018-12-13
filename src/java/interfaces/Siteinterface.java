/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Andi SR
 */
public interface Siteinterface {
     public  List<Object> getAllSite (Object entity, String keyword, Object id);
     public List<Object> getAllDataObj(Object entity);
    
}

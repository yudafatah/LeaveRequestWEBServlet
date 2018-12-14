/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Employee;

/**
 *
 * @author yudafatah
 */
public interface AccountInterface {
    public boolean login(String username, String password);
    public Object getById(Object entity, Object id);
    public Employee find(String username);
}

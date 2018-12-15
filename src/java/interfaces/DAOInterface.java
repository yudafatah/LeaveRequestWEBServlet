/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Employee;
import java.util.List;

/**
 *
 * @author yudafatah
 */
public interface DAOInterface {
    public boolean login(String username, String password);
    public boolean doDML(Object object, boolean isDelete);//iud
    public List<Object> doDDL(Object table, String keyword, Object id);//sga
    public Object getById(Object entity,Object id);
    public List<Object> getDatasWaiting(Object entity, Object managerId);
    public List<Object> getUserHistories(Object entity, int id);
    public Employee find(String username);
    public Object getByIdObj(Object entity, Object id);
    public List<Object> getAllDataObj(Object entity, String keyword);
    public List<Object> getAllDatasMaxId(Object entities);
    public List<Object> getAllDatasHistories(Object entities, String key);
    public List<Object> searchRejectedLR(Object entities, String key);
    public List<Object> searchApprovedLR(Object entities, String key);
    public List<Object> getAllApproved(Object entities);
    public List<Object> getAllRejected(Object entities);
    public  List<Object> searchHistoryUser(Object entities, int id, String name);
}

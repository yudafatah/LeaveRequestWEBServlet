/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Employee;
import interfaces.DAOInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yudafatah
 */
public class GeneralDAO implements DAOInterface{
    FunctionDAO fdao;

    public GeneralDAO() {
    }

    public GeneralDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    @Override
    public boolean login(String username, String password){
        return this.fdao.login(username, password);
    }

    @Override
    public boolean doDML(Object object, boolean isDelete) {
        return this.fdao.insertOrUpdateOrDelete(object, isDelete);
    }

    @Override
    public List<Object> doDDL(Object table, String keyword, Object id) {
        return this.fdao.getDatas(table, keyword, id);
    }

    @Override
    public Object getById(Object entity, Object id) {
        return this.fdao.getById(entity, id);
    }

    @Override
    public List<Object> getDatasWaiting(Object entity, Object managerId) {
        return this.fdao.getDatasWaiting(entity, managerId);
    }

    @Override
    public List<Object> getUserHistories(Object entity, int id) {
        return this.fdao.getUserHistories(entity, id);
    }

    @Override
    public Employee find(String username) {
        return this.fdao.find(username);
    }

    @Override
    public Object getByIdObj(Object entity, Object id) {
        return this.fdao.getByIdObj(entity, id);
    }

    @Override
    public List<Object> getAllDataObj(Object entity, String keyword) {
        return this.fdao.getAllDatas(entity, keyword);
    }

    @Override
    public List<Object> getAllDatasMaxId(Object entities) {
        return this.fdao.getAllDatas(entities);
    }

    @Override
    public List<Object> getAllDatasHistories(Object entities, String key) {
        return this.fdao.getAllDatasHistories(entities, key);
    }

    @Override
    public List<Object> searchRejectedLR(Object entities, String key) {
        return this.fdao.getDatasRejected(entities, key);
    }

    @Override
    public List<Object> searchApprovedLR(Object entities, String key) {
        return this.fdao.getDatasApproved(entities, key);
    }

    @Override
    public List<Object> getAllApproved(Object entities) {
        return this.fdao.getAllApproved(entities);
    }

    @Override
    public List<Object> getAllRejected(Object entities) {
        return this.fdao.getAllRejected(entities);
    }

    @Override
    public List<Object> searchHistoryUser(Object entities, int id, String name) {
        return this.fdao.searchHistoryUser(entities, id, name);
    }
}

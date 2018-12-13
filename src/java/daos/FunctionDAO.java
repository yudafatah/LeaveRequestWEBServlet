/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;


import entities.Employee;
import helpers.BCrypt;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yudafatah
 */
public class FunctionDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FunctionDAO() {
    }

    public FunctionDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    /**
     * Fungsi untuk melakukan insert, update atau delete 
     * @param Object 
     * @param isDelete boolean true for delete false for update or insert
     * @return 
     */
    public boolean insertOrUpdateOrDelete(Object object, 
            boolean isDelete){
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isDelete) {
                session.delete(object);
            }else{
                session.saveOrUpdate(object);
            }
            result = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return result;
    }
    
    /**
     * get all data of specific employee
     * @param query
     * @return List Object of Employee entity
     */
    public List<Object> getDatas(Object entities, String key, Object id) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where (delete_status = "
                + "'Available' or delete_status = 'available') and employee_id = "+id+" ORDER BY request_date";
        System.out.println(className);
        if (!key.equals("")) {
            query = getQuery(entities, key);
        }
        System.out.println(query);
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * query to search data
     * @param entity
     * @param key
     * @return 
     */
    public String getQuery(Object entity, String key) {
        String className = entity.getClass().getSimpleName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "FROM "+className+" WHERE ";
        for (Object r : entity.getClass().getDeclaredFields()) {
            String field = r + "";
            if (!field.contains("UID") && !field.contains("List") && !field.contains("Status")) {
                field = field.substring(field.lastIndexOf(".") + 1);
                query += field + " LIKE '%" + key + "%' OR ";
            }
        }
        query = query.substring(0, query.lastIndexOf("OR")) + " ORDER BY 1";

        return query;
    }
    /**
     * search to get data which want to show with request status waiting
     * @param entity object leave request
     * @param key keyword
     * @return 
     */
    private String getQueryWaiting(Object entity, String key) {
        String className = entity.getClass().getSimpleName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "FROM "+className+" WHERE ";
        System.out.println(query);
        for (Object r : entity.getClass().getDeclaredFields()) {
            String field = r + "";
            System.out.println("coba gagal");
            if (!field.contains("UID") && !field.contains("List") && !field.contains("Status")) {
                field = field.substring(field.lastIndexOf(".") + 1);
                query += field + " LIKE '%" + key + "%' OR ";
            }
        }
        query = query.substring(0, query.lastIndexOf("OR"))
                + " and (requestStatus = "
                + "'Waiting' or requestStatus = 'waiting') "
                + "and (deleteStatus = 'Available' or deleteStatus = 'available') ORDER BY 1";
        System.out.println(query);
        return query;
    }
    
    /**
     * show data with specific leave request id
     * @param entity Object Leave Request
     * @return Objek Leave Request
     */
    public Object getById(Object entity, Object id){
        Object object = new Object();
        String className = entity.getClass().getSimpleName();
        String query = className.toLowerCase() +"Id";
        try {
            System.out.println("xx");
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = session.createQuery("FROM "+ entity.getClass().getSimpleName() 
                    +" WHERE lr_id ="+id)
                    .uniqueResult();
            transaction.commit();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return object;
    }
    /**
     * to find password by username
     * @param entity Object table
     * @param username username of account
     * @return 
     */
    public Employee find(String username){
        Employee account = null;
        session = factory.openSession();
        transaction =null;
        try {
            transaction = session.beginTransaction();
            account = (Employee) session.createQuery("FROM Employee WHERE"
                    + " username = :username").setString("username", username).uniqueResult();
            transaction.commit();
            //System.out.println(account);
        } catch (Exception e) {
            account = null;
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return account;
    }
    /**
     * to compare password from input with password that was be decrypted 
     * @param username
     * @param password
     * @return true for valid
     */
    public boolean login(String username, String password){
        boolean result = false;
        Employee account = this.find(username);
        System.out.println(account+"bbbb");
        if (account != null){
            System.out.println("cc");
            if(BCrypt.checkpw(password, account.getPassword())){
                result = true;
                System.out.println("berhasil");
            }
        }
        return result;
    }
    /**
     * get all data with status is waiting
     * @param entities
     * @param key
     * @return 
     */
    public List<Object> getDatasWaiting(Object entities, String key) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where (request_status = "
                + "'Waiting' or request_status = 'waiting') and (delete_status "
                + "= 'Available' or delete_status = 'available') ORDER BY request_date";
        System.out.println(className);
        System.out.println(query);
        if (!key.equals("")){
            query=getQueryWaiting(entities, key);
        }
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get all data with no condition
     * @param entities
     * @param key
     * @return 
     */
    public List<Object> getAllDatas(Object entities, String key) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " ORDER BY 1";
        System.out.println(className);
        System.out.println(query);
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * to get list data of leave request searched by manager name
     * @param entities
     * @param id
     * @param name
     * @return 
     */
    public List<Object> searchHistoryUser(Object entities, int id, String name){
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where employee_id = "+id+" "
                + "and delete_status = 'Available' and (request_status like '%Approved by "+name+"%' "
                + "or request_status like '%Rejected by "+name+"%') ORDER BY request_date";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get all user histories with specific id
     * @param entities
     * @param id
     * @return 
     */
    public List<Object> getUserHistories(Object entities, int id) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where employee_id = "+id+" "
                + "and delete_status = 'Available' and (request_status like '%Approved%' "
                + "or request_status like '%Rejected%') ORDER BY request_date";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get id by Object entity
     * @param entity
     * @param id
     * @return 
     */
    public Object getByIdObj(Object entity, Object id){
        Object object = new Object();
        String className = entity.getClass().getSimpleName();
        String query = className.toLowerCase() +"Id";
        try {
            System.out.println("xx");
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = session.createQuery("FROM "+ entity.getClass().getSimpleName() 
                    +" WHERE "+query+" = "+id)
                    .uniqueResult();
            transaction.commit();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return object;
    }
    /**
     * get data with no condition with search parameter
     * @param entities
     * @param key
     * @return 
     */
    public List<Object> getDatas1(Object entities, String key) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " ORDER BY 1 ";
        System.out.println(className);
        if (!key.equals("")) {
            query = getQuery(entities, key);
        }
        System.out.println(query);
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * show all list data order by id and take last id
     * @param entities
     * @return 
     */
    public List<Object> getAllDatasMaxId(Object entities) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " ORDER BY 1";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get all histories data 
     * @param entities
     * @param key
     * @return 
     */
    public List<Object> getAllDatasHistories(Object entities, String key) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where request_status like '%Rejected%' "
                + "or request_status like '%Approved%' ORDER BY request_date";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get all data leave request which was rejected by manager name
     * @param entities
     * @param key
     * @return 
     */
    public List<Object> getDatasRejected(Object entities, String key) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where delete_status = 'Available' "
                + "and request_status like '%Rejected by " + key + "%'";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get all data leave request which was approved by manager name
     * @param entities
     * @param key
     * @return 
     */
    public List<Object> getDatasApproved(Object entities, String key) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where delete_status = 'Available' "
                + "and request_status like '%Approved by " + key + "%'";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get all data of leave request which was approved
     * @param entities
     * @return 
     */
    public List<Object> getAllApproved(Object entities) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where delete_status = 'Available' and "
                + "request_status like '%Approved%'  or request_status like '%approved%' "
                + "ORDER BY request_date";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    /**
     * get data of leave request which was rejected
     * @param entities
     * @return 
     */
    public List<Object> getAllRejected(Object entities) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " where delete_status = 'Available' and "
                + "request_status like '%Rejected%' or request_status like '%rejected%' "
                + "ORDER BY request_date";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
}

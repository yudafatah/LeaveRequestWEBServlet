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
public interface LeaveRequestInterface {
    /**
     * Get all data of entity with specific data filtered by id
     * @param entity LeaveRequest
     * @param keyword search all
     * @param id the specific user id
     * @return 
     */
    public List<Object> getAlls(Object entity, String keyword, Object id);
    public Object getById(Object entity, Object id);
    public String insert(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String notereq, String noterej, String reqStat, String delStat, byte[] image);
    public String update(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String notereq, String noterej, String reqStat, String delStat, byte[] image);
    public String delete(Object entity, boolean isDelete);
    /**
     * Get all data from employee which the request status is waiting filtered by manager id
     * @param entity LeaveRequest
     * @return List LeaveRequest
     */
    public List<Object> getDatasWaiting(Object entity, Object managerId);
    public String approve(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String note, String reqStat, String delStat, byte[] image);
    public String reject(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String note, String reqStat, String delStat, byte[] image, String noterej);
    public List<Object> getUserHistories(Object entity, String id);
    public Object getByIdObj(Object entity, Object id);
    public String updateObj(Object object);
    public List<Object> getAllDatasOrderById(Object entities);
    public List<Object> getAllDatasHistories(Object entities, String key);
    public List<Object> searchRejectedLR(Object entities, String key);
    public List<Object> searchApprovedLR(Object entities, String key);
    public List<Object> getAllApproved(Object entities);
    public List<Object> getAllRejected(Object entities);
    public  List<Object> searchHistoryUser(Object entities, int id, String name);
}

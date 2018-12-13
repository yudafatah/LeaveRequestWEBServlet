/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import entities.Employee;
import entities.LeaveRequest;
import entities.LeaveRequestType;
import interfaces.DAOInterface;
import interfaces.LeaveRequestInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.SessionFactory;

/**
 *
 * @author yudafatah
 */
public class LeaveRequestController implements LeaveRequestInterface{
    DAOInterface daoi;

    public LeaveRequestController() {
    }

    public LeaveRequestController(SessionFactory factory) {
        this.daoi = new GeneralDAO(factory);
    }

    @Override
    public List<Object> getAlls(Object entity, String keyword, Object id) {
        return daoi.doDDL(entity, keyword, id);
    }

    @Override
    public Object getById(Object entity, Object id) {
        return daoi.getById(entity, id);
    }

    @Override
    public String insert(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String notereq, String noterej, String reqStat, String delStat, byte[] image) {
        String result = "Insert failed";
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date requestDate = format.parse(reqDate);
            Date startdate = format.parse(startDate);
            Date enddate = format.parse(endDate);
            Employee employee = new Employee(Integer.parseInt(empid));
            LeaveRequestType lrt = new LeaveRequestType(Integer.parseInt(typelr));
            LeaveRequest leaveRequest = new LeaveRequest(null, requestDate, 
                    startdate, enddate, Integer.parseInt(lrDuration), notereq, 
                    reqStat, image, noterej, employee, 
                             lrt);
            if(daoi.doDML(leaveRequest, false)){
                result = "New data has been created";
            }else{
                result = "Insert failed!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String update(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String notereq, String noterej, String reqStat, String delStat, byte[] image) {
        String result = "Cancel request failed";
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date requestDate = format.parse(reqDate);
            Date startdate = format.parse(startDate);
            Date enddate = format.parse(endDate);
            Employee employee = new Employee(Integer.parseInt(empid));
            LeaveRequestType lrt = new LeaveRequestType(Integer.parseInt(typelr));
            System.out.println(empid);
            LeaveRequest leaveRequest = new LeaveRequest(null, requestDate, 
                    startdate, enddate, Integer.parseInt(lrDuration), notereq, 
                    reqStat, image, noterej, employee, 
                             lrt);
            if(daoi.doDML(leaveRequest, false)){
                result = "The request has been canceled";
            }else{
                result = "Cancel request failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String delete(Object entity, boolean isDelete) {
        if(daoi.doDML(entity, true)){
            return "The data has been deleted";
        }else{
            return "Delete failed!";
        }
    }

    @Override
    public List<Object> getDatasWaiting(Object entity) {
        return daoi.getDatasWaiting(entity);
    }

    @Override
    public List<Object> getAllDatas(Object entity) {
        return daoi.getAllDatas(entity,"");
    }

    @Override
    public String approve(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String note, String reqStat, String delStat, byte[] image) {
        String result = "Approve failed";
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date requestDate = format.parse(reqDate);
            Date startdate = format.parse(startDate);
            Date enddate = format.parse(endDate);
            Employee employee = new Employee(Integer.parseInt(empid));
            LeaveRequestType lrt = new LeaveRequestType(Integer.parseInt(typelr));
            System.out.println(empid);
            LeaveRequest leaveRequest = new LeaveRequest(null, requestDate, 
                    startdate, enddate, Integer.parseInt(lrDuration), note, 
                    reqStat, image, "", employee, 
                             lrt);
            if(daoi.doDML(leaveRequest, false)){
                result = "The request has been approved";
            }else{
                result = "Approve failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String reject(String lrid, String empid, String typelr, String reqDate, String startDate, String endDate, String lrDuration, String note, String reqStat, String delStat, byte[] image, String noterej) {
        String result = "Reject failed";
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date requestDate = format.parse(reqDate);
            Date startdate = format.parse(startDate);
            Date enddate = format.parse(endDate);
            Employee employee = new Employee(Integer.parseInt(empid));
            LeaveRequestType lrt = new LeaveRequestType(Integer.parseInt(typelr));
            System.out.println(empid);
            LeaveRequest leaveRequest = new LeaveRequest(null, requestDate, 
                    startdate, enddate, Integer.parseInt(lrDuration), note, 
                    reqStat, image, noterej, employee, 
                             lrt);
            if(daoi.doDML(leaveRequest, false)){
                result = "The request has been rejected";
            }else{
                result = "Reject failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Object> searchWaiting(Object entity, String key) {
        return daoi.getAllDatas(entity, key);
    }

    @Override
    public List<Object> getUserHistories(Object entity, String id) {
        return daoi.getUserHistories(entity, Integer.parseInt(id));
    }

    @Override
    public Object getByIdObj(Object entity, Object id) {
        return daoi.getByIdObj(entity, id);
    }

    @Override
    public String updateObj(Object object) {
        if(daoi.doDML(object, false)){
            return "The data has been updated";
        }
        else{
            return "The data failed to update";
        }
    }

    @Override
    public List<Object> getAllDatasMaxId(Object entities) {
        return daoi.getAllDatasMaxId(entities);
    }

    @Override
    public List<Object> getAllDatasHistories(Object entities, String key) {
        return daoi.getAllDatasHistories(entities, key);
    }

    @Override
    public List<Object> searchRejectedLR(Object entities, String key) {
        return daoi.searchRejectedLR(entities, key);
    }

    @Override
    public List<Object> searchApprovedLR(Object entities, String key) {
        return daoi.searchApprovedLR(entities, key);
    }

    @Override
    public List<Object> getAllApproved(Object entities) {
        return daoi.getAllApproved(entities);
    }

    @Override
    public List<Object> getAllRejected(Object entities) {
        return daoi.getAllRejected(entities);
    }

    @Override
    public List<Object> searchHistoryUser(Object entities, int id, String name) {
        return daoi.searchHistoryUser(entities, id, name);
    }
}

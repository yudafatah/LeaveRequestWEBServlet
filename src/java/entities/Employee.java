/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByJoinDate", query = "SELECT e FROM Employee e WHERE e.joinDate = :joinDate")
    , @NamedQuery(name = "Employee.findByQuotaThisyear", query = "SELECT e FROM Employee e WHERE e.quotaThisyear = :quotaThisyear")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic(optional = false)
    @Lob
    @Column(name = "employee_name")
    private String employeeName;
    @Basic(optional = false)
    @Lob
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Lob
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "join_date")
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "quota_thisyear")
    private int quotaThisyear;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<LeaveRequest> leaveRequestList;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee managerId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role roleId;
    @JoinColumn(name = "site_id", referencedColumnName = "site_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Site siteId;

    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(Integer employeeId, String employeeName, String gender, String address, Date joinDate, String email, String username, int quotaThisyear, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.address = address;
        this.joinDate = joinDate;
        this.email = email;
        this.username = username;
        this.quotaThisyear = quotaThisyear;
        this.password = password;
    }

    public Employee(Integer employeeId, String employeeName, String gender, String address, Date joinDate, String email, String username, int quotaThisyear, String password, Employee managerId, Role roleId, Site siteId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.address = address;
        this.joinDate = joinDate;
        this.email = email;
        this.username = username;
        this.quotaThisyear = quotaThisyear;
        this.password = password;
        this.managerId = managerId;
        this.roleId = roleId;
        this.siteId = siteId;
    }

    
    
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuotaThisyear() {
        return quotaThisyear;
    }

    public void setQuotaThisyear(int quotaThisyear) {
        this.quotaThisyear = quotaThisyear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<LeaveRequest> getLeaveRequestList() {
        return leaveRequestList;
    }

    public void setLeaveRequestList(List<LeaveRequest> leaveRequestList) {
        this.leaveRequestList = leaveRequestList;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getManagerId() {
        return managerId;
    }

    public void setManagerId(Employee managerId) {
        this.managerId = managerId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Site getSiteId() {
        return siteId;
    }

    public void setSiteId(Site siteId) {
        this.siteId = siteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employee[ employeeId=" + employeeId + " ]";
    }
    
}

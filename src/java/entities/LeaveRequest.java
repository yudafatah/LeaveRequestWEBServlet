/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "leave_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequest.findAll", query = "SELECT l FROM LeaveRequest l")
    , @NamedQuery(name = "LeaveRequest.findByLrId", query = "SELECT l FROM LeaveRequest l WHERE l.lrId = :lrId")
    , @NamedQuery(name = "LeaveRequest.findByRequestDate", query = "SELECT l FROM LeaveRequest l WHERE l.requestDate = :requestDate")
    , @NamedQuery(name = "LeaveRequest.findByStartDate", query = "SELECT l FROM LeaveRequest l WHERE l.startDate = :startDate")
    , @NamedQuery(name = "LeaveRequest.findByEndDate", query = "SELECT l FROM LeaveRequest l WHERE l.endDate = :endDate")
    , @NamedQuery(name = "LeaveRequest.findByLrDuration", query = "SELECT l FROM LeaveRequest l WHERE l.lrDuration = :lrDuration")})
public class LeaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lr_id")
    private Integer lrId;
    @Basic(optional = false)
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "lr_duration")
    private int lrDuration;
    @Basic(optional = false)
    @Lob
    @Column(name = "note_request")
    private String noteRequest;
    @Basic(optional = false)
    @Lob
    @Column(name = "request_status")
    private String requestStatus;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Lob
    @Column(name = "note_reject")
    private String noteReject;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeId;
    @JoinColumn(name = "type_lr_id", referencedColumnName = "type_lr_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private LeaveRequestType typeLrId;

    public LeaveRequest() {
    }

    public LeaveRequest(Integer lrId) {
        this.lrId = lrId;
    }

    public LeaveRequest(Integer lrId, Date requestDate, Date startDate, Date endDate, int lrDuration, String noteRequest, String requestStatus) {
        this.lrId = lrId;
        this.requestDate = requestDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lrDuration = lrDuration;
        this.noteRequest = noteRequest;
        this.requestStatus = requestStatus;
    }

    public LeaveRequest(Integer lrId, Date requestDate, Date startDate, Date endDate, int lrDuration, String noteRequest, String requestStatus, byte[] image, String noteReject, Employee employeeId, LeaveRequestType typeLrId) {
        this.lrId = lrId;
        this.requestDate = requestDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lrDuration = lrDuration;
        this.noteRequest = noteRequest;
        this.requestStatus = requestStatus;
        this.image = image;
        this.noteReject = noteReject;
        this.employeeId = employeeId;
        this.typeLrId = typeLrId;
    }

    
    
    public Integer getLrId() {
        return lrId;
    }

    public void setLrId(Integer lrId) {
        this.lrId = lrId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getLrDuration() {
        return lrDuration;
    }

    public void setLrDuration(int lrDuration) {
        this.lrDuration = lrDuration;
    }

    public String getNoteRequest() {
        return noteRequest;
    }

    public void setNoteRequest(String noteRequest) {
        this.noteRequest = noteRequest;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getNoteReject() {
        return noteReject;
    }

    public void setNoteReject(String noteReject) {
        this.noteReject = noteReject;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public LeaveRequestType getTypeLrId() {
        return typeLrId;
    }

    public void setTypeLrId(LeaveRequestType typeLrId) {
        this.typeLrId = typeLrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lrId != null ? lrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveRequest)) {
            return false;
        }
        LeaveRequest other = (LeaveRequest) object;
        if ((this.lrId == null && other.lrId != null) || (this.lrId != null && !this.lrId.equals(other.lrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LeaveRequest[ lrId=" + lrId + " ]";
    }
    
}

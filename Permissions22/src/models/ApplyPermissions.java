package models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employeepermissionrequests")
public class ApplyPermissions {

	@Override
	public String toString() {
		return "ApplyPermissions [id=" + id + ", current_date=" + current_date + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", reason=" + reason + ", eprq_status=" + eprq_status
				+ ", eprq_approvedby=" + eprq_approvedby + ", ep_remarks=" + ep_remarks + "]";
	}

	@EmbeddedId
	private PermissionCompositeKey id;

	@Column(name = "eprq_date")
	private Date current_date;

	@Column(name = "eprq_sttime")
	private Time start_time;

	@Column(name = "eprq_endtime")
	private Time end_time;

	@Column(name = "reason")
	private String reason;

	@Column(name = "eprq_status")
	private String eprq_status;

	@Column(name = "eprq_approvedby")
	private String eprq_approvedby;

	@Column(name = "ep_remarks")
	private String ep_remarks;

	public String getEprq_status() {
		return eprq_status;
	}

	public void setEprq_status(String eprq_status) {
		this.eprq_status = eprq_status;
	}

	public String getEprq_approvedby() {
		return eprq_approvedby;
	}

	public void setEprq_approvedby(String eprq_approvedby) {
		this.eprq_approvedby = eprq_approvedby;
	}

	public String getEp_remarks() {
		return ep_remarks;
	}

	public void setEp_remarks(String ep_remarks) {
		this.ep_remarks = ep_remarks;
	}

	public PermissionCompositeKey getId() {
		return id;
	}

	public void setId(PermissionCompositeKey id) {
		this.id = id;
	}

	public Date getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}

	public Time getStart_time() {
		return start_time;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}

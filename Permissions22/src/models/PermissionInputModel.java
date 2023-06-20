package models;

public class PermissionInputModel {

	private int id;
	private String current_date;
	private String start_time;
	private String end_time;
	private String reason;

	public PermissionInputModel(int id, String current_date, String start_time, String end_time, String reason) {
		super();
		this.id = id;
		this.current_date = current_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.reason = reason;

	}

	public PermissionInputModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}

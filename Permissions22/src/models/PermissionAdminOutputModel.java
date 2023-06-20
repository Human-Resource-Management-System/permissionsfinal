package models;

public class PermissionAdminOutputModel {
	private int id;
	private String name;
	private String current_date;
	private String st_time;
	private String end_time;
	
	
	public PermissionAdminOutputModel(int id, String name, String current_date, String st_time, String end_time) {
		super();
		this.id = id;
		this.name = name;
		this.current_date = current_date;
		this.st_time = st_time;
		this.end_time = end_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}
	public String getSt_time() {
		return st_time;
	}
	public void setSt_time(String st_time) {
		this.st_time = st_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

}

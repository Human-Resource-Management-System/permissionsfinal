package models;

public class PermissionAdminModel {

	private int id;
	private int index;
	private String eprq_status;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public PermissionAdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermissionAdminModel(int id, String eprq_status) {
		super();
		this.id = id;
		this.eprq_status = eprq_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEprq_status() {
		return eprq_status;
	}

	public void setEprq_status(String eprq_status) {
		this.eprq_status = eprq_status;
	}

}

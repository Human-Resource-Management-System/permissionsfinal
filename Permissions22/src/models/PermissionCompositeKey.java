package models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PermissionCompositeKey implements Serializable {

	private int empl_id;

	private int ep_index;

	public int getId() {
		return empl_id;
	}

	public void setId(int empl_id) {
		this.empl_id = empl_id;
	}

	public int getEp_index() {
		return ep_index;
	}

	public void setEp_index(int ep_index) {
		this.ep_index = ep_index;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		PermissionCompositeKey that = (PermissionCompositeKey) obj;
		return empl_id == that.empl_id && ep_index == that.ep_index;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empl_id, ep_index);
	}

}

package persistence.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_WATERING")
public class Watering {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "gardenId")
	private int gardenId;
	
	@Column(name = "date")
	private Date date;
	//hour
	
	public Watering(int id, int gardenId, Date date) {
		super();
		this.id = id;
		this.gardenId = gardenId;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGardenId() {
		return gardenId;
	}
	public void setGardenId(int gardenId) {
		this.gardenId = gardenId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Watering [id=" + id + ", id_garden=" + gardenId + ", date=" + date + "]";
	}

	
	
}

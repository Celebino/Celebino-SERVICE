package org.celebino.persistence.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ArtificialLight {
	
	@Id @GeneratedValue
	@Column
	private Long id;
	
	@Column
	private int gardenId;
	
	@Column
	private Date date;
	//hour
	
	public ArtificialLight(){}
	
	public ArtificialLight(Long id, int gardenId, Date date) {
		super();
		this.id = id;
		this.gardenId = gardenId;
		this.date = date;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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

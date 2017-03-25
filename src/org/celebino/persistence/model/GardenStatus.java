package org.celebino.persistence.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GardenStatus {
	
	@Id @GeneratedValue
	@Column
	private Long id;
	
	@Column
	private Long gardenId;
	
	@Column
	private Date date;
	//hour
	
	@Column
	private int sunLight;
	
	@Column
	private int soilHumidity;
	
	@Column
	private int airHumidity;
	
	@Column
	private int airTemperature;
	
	
	public GardenStatus(Long id, Long gardenId, Date date, int sunLight, int soilHumidity, int airHumidity,
			int airTemperature) {
		super();
		this.id = id;
		this.gardenId = gardenId;
		this.date = date;
		this.sunLight = sunLight;
		this.soilHumidity = soilHumidity;
		this.airHumidity = airHumidity;
		this.airTemperature = airTemperature;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGardenId() {
		return gardenId;
	}
	public void setGardenId(Long gardenId) {
		this.gardenId = gardenId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSunLight() {
		return sunLight;
	}
	public void setSunLight(int sunLight) {
		this.sunLight = sunLight;
	}
	public int getSoilHumidity() {
		return soilHumidity;
	}
	public void setSoilHumidity(int soilHumidity) {
		this.soilHumidity = soilHumidity;
	}
	public int getAirHumidity() {
		return airHumidity;
	}
	public void setAirHumidity(int airHumidity) {
		this.airHumidity = airHumidity;
	}
	public int getAirTemperature() {
		return airTemperature;
	}
	public void setAirTemperature(int airTemperature) {
		this.airTemperature = airTemperature;
	}



	@Override
	public String toString() {
		return "GardenStatus [id=" + id + ", id_garden=" + gardenId + ", date=" + date + ", sunLight=" + sunLight
				+ ", soilHumidity=" + soilHumidity + ", airHumidity=" + airHumidity + ", airTemperature="
				+ airTemperature + "]";
	}

	
	

}

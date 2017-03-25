package org.celebino.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Garden {
	
	@Id @GeneratedValue
	@Column
	private Long id;
	
	@Column
	private Long userId;
	 
	@Column	
	private int soilHumidity;
	
	@Column
	private int sunLight;
	
	@Column
	private int airHumidity;
	
	@Column
	private int airTemperature;

	public Garden(Long id, Long userId, int soilHumidity, int sunLight, int airHumidity, int airTemperature) {
		super();
		this.id = id;
		this.userId = userId;
		this.soilHumidity = soilHumidity;
		this.sunLight = sunLight;
		this.airHumidity = airHumidity;
		this.airTemperature = airTemperature;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public int getSoilHumidity() {
		return soilHumidity;
	}

	public void setSoilHumidity(int soilHumidity) {
		this.soilHumidity = soilHumidity;
	}

	
	public int getSunLight() {
		return sunLight;
	}

	public void setSunLight(int sunLight) {
		this.sunLight = sunLight;
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
		return "Garden [id=" + id + ", userId=" + userId + ", soilHumidity=" + soilHumidity + ", sunLight=" + sunLight
				+ ", airHumidity=" + airHumidity + ", airTemperature=" + airTemperature + "]";
	}


}

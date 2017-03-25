package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_GARDEN")
public class GardenStatus {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "gardenId")
	private int gardenId;
	
	@Column(name = "date")
	private Date date;
	//hour
	
	@Column(name = "sunLight")
	private int sunLight;
	
	@Column(name = "soilHumidity")
	private int soilHumidity;
	
	@Column(name = "airHumidity")
	private int airHumidity;
	
	@Column(name = "airTemperature")
	private int airTemperature;
	
	
	public GardenStatus(int id, int gardenId, Date date, int sunLight, int soilHumidity, int airHumidity,
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

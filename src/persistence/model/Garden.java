package persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_GARDEN")
public class Garden {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "userId")
	private String userId;
	 
	@Column(name = "soilHumidity")
	private int soilHumidity;
	
	@Column(name = "sunLight")
	private int sunLight;
	
	@Column(name = "airHumidity")
	private int airHumidity;
	
	@Column(name = "airTemperature")
	private int airTemperature;

	public Garden(int id, String userId, int soilHumidity, int sunLight, int airHumidity, int airTemperature) {
		super();
		this.id = id;
		this.userId = userId;
		this.soilHumidity = soilHumidity;
		this.sunLight = sunLight;
		this.airHumidity = airHumidity;
		this.airTemperature = airTemperature;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

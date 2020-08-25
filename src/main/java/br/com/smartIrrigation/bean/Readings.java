package br.com.smartIrrigation.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Readings {

	private Long id;
	private Timestamp verificationTime;
	private Integer humidity;
	private Integer signalStrength;

	public Readings() {
	}

	public Readings(Timestamp verificationTime, Integer humidity, Integer signalStrength) {
		this.verificationTime = verificationTime;
		this.humidity = humidity;
		this.signalStrength = signalStrength;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@ApiModelProperty(example = "dd/MM/yyyy hh:mm:ss")
	public Timestamp getVerificationTime() {
		return verificationTime;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public Integer getSignalStrength() {
		return signalStrength;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVerificationTime(Timestamp verificationTime) {
		this.verificationTime = verificationTime;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public void setSignalStrength(Integer signalStrength) {
		this.signalStrength = signalStrength;
	}

	@Override
	public String toString() {
		return "Reading[id:" + this.id + ", verificationTime:" + this.verificationTime + ", humidity:" + this.humidity
				+ ", signalStrength:" + this.signalStrength + "]";
	}

}
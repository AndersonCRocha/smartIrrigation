package br.com.smartIrrigation.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parameters {

	private Integer id;
	private Boolean sporadicIrrigationNow;
	private Integer sporadicIrrigationDuration;
	private LocalDateTime nextScheduledIrrigation;
	private Integer scheduledIrrigationTime;
	private Integer criticalHumidity;
	private Integer timeBetweenReadings;
	private Boolean irrigateOnlyIfLowHumidity;

	@Id
	public Integer getId() {
		return id;
	}

	public Boolean getSporadicIrrigationNow() {
		return sporadicIrrigationNow;
	}

	public Integer getSporadicIrrigationDuration() {
		return sporadicIrrigationDuration;
	}

	public LocalDateTime getNextScheduledIrrigation() {
		return nextScheduledIrrigation;
	}

	public Integer getScheduledIrrigationTime() {
		return scheduledIrrigationTime;
	}

	public Integer getCriticalHumidity() {
		return criticalHumidity;
	}
	
	public Integer getTimeBetweenReadings() {
		return timeBetweenReadings;
	}

	public Boolean getIrrigateOnlyIfLowHumidity() {
		return irrigateOnlyIfLowHumidity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSporadicIrrigationNow(Boolean sporadicIrrigationNow) {
		this.sporadicIrrigationNow = sporadicIrrigationNow;
	}

	public void setSporadicIrrigationDuration(Integer sporadicIrrigationDuration) {
		this.sporadicIrrigationDuration = sporadicIrrigationDuration;
	}

	public void setNextScheduledIrrigation(LocalDateTime nextScheduledIrrigation) {
		this.nextScheduledIrrigation = nextScheduledIrrigation;
	}

	public void setScheduledIrrigationTime(Integer scheduledIrrigationTime) {
		this.scheduledIrrigationTime = scheduledIrrigationTime;
	}

	public void setCriticalHumidity(Integer criticalHumidity) {
		this.criticalHumidity = criticalHumidity;
	}
	
	public void setTimeBetweenReadings(Integer timeBetweenReadings) {
		this.timeBetweenReadings = timeBetweenReadings;
	}

	public void setIrrigateOnlyIfLowHumidity(Boolean irrigateOnlyIfLowHumidity) {
		this.irrigateOnlyIfLowHumidity = irrigateOnlyIfLowHumidity;
	}

}
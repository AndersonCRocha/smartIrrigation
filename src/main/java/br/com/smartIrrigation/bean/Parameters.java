package br.com.smartIrrigation.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parameters {
	
	private Integer id;
	private Boolean irrigate;
	private Integer criticalHumidity;
	private Integer milliseconds;
	
	@Id
	public Integer getId() {
		return id;
	}
	public Boolean getIrrigate() {
		return irrigate;
	}
	public Integer getCriticalHumidity() {
		return criticalHumidity;
	}
	public Integer getMilliseconds() {
		return milliseconds;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIrrigate(Boolean irrigate) {
		this.irrigate = irrigate;
	}
	public void setCriticalHumidity(Integer criticalHumidity) {
		this.criticalHumidity = criticalHumidity;
	}
	public void setMilliseconds(Integer milliseconds) {
		this.milliseconds = milliseconds;
	}
	
}

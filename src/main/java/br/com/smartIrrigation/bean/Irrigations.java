package br.com.smartIrrigation.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.smartIrrigation.enummeration.IrrigationsType;

@Entity
public class Irrigations {

	private Long id;
	private LocalDateTime startAt;
	private LocalDateTime endAt;
	private IrrigationsType type;
	private Integer startHumidity;
	private Integer endHumidity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}
	
	public LocalDateTime getEndAt() {
		return endAt;
	}
	
	public IrrigationsType getType() {
		return type;
	}

	public Integer getStartHumidity() {
		return startHumidity;
	}
	
	public Integer getEndHumidity() {
		return endHumidity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}

	public void setEndAt(LocalDateTime endAt) {
		this.endAt = endAt;
	}
	
	public void setType(IrrigationsType type) {
		this.type = type;
	}

	public void setStartHumidity(Integer startHumidity) {
		this.startHumidity = startHumidity;
	}
	
	public void setEndHumidity(Integer endHumidity) {
		this.endHumidity = endHumidity;
	}

}
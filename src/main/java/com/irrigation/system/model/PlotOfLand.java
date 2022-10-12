package com.irrigation.system.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.irrigation.system.enums.PlotOfLandIrregationStatus;

import lombok.Data;

//@Data
@Entity
@Table(name="plotOfLand")
public class PlotOfLand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private PlotOfLandIrregationStatus status;
	
	@Column
    private Double area;
	
	@Column
    private Double amountOfWaterNeeded;
	
	@OneToMany
	private List<TimeSlot> timeslots;
	
	@OneToOne
    @JoinColumn(name = "sensorId")
	private Sensor sensor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PlotOfLandIrregationStatus getStatus() {
		return status;
	}

	public void setStatus(PlotOfLandIrregationStatus status) {
		this.status = status;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getAmountOfWaterNeeded() {
		return amountOfWaterNeeded;
	}

	public void setAmountOfWaterNeeded(Double amountOfWaterNeeded) {
		this.amountOfWaterNeeded = amountOfWaterNeeded;
	}

	public List<TimeSlot> getTimeslots() {
		return timeslots;
	}

	public void setTimeslots(List<TimeSlot> timeslots) {
		this.timeslots = timeslots;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	
    
    
}

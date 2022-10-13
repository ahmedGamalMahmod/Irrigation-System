package com.irrigation.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.irrigation.system.enums.SensorStatus;

import lombok.Data;

@Data
@Entity
@Table(name="sensor")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private SensorStatus status;


}

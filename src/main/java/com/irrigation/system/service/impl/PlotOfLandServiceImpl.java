package com.irrigation.system.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.irrigation.system.enums.PlotOfLandIrregationStatus;
import com.irrigation.system.enums.SensorStatus;
import com.irrigation.system.enums.TimeSlotStatus;
import com.irrigation.system.exception.ResourceNotFoundException;
import com.irrigation.system.model.PlotOfLand;
import com.irrigation.system.model.Sensor;
import com.irrigation.system.model.TimeSlot;
import com.irrigation.system.repository.PlotOfLandRebository;
import com.irrigation.system.service.PlotOfLandService;
@Service
public class PlotOfLandServiceImpl implements PlotOfLandService {
	
	private final PlotOfLandRebository  plotOfLandRebository;
	public PlotOfLandServiceImpl(PlotOfLandRebository plotOfLandRebository) {
		this.plotOfLandRebository = plotOfLandRebository;
	}

	@Override
	public PlotOfLand addNewPlotOfLand(PlotOfLand plotOfLand) {
		return plotOfLandRebository.save(plotOfLand);
	}

	@Override
	public PlotOfLand configurePlotOfLand(Integer id ,Integer sensorId, String agriculturalCrop) {
		
		Optional<PlotOfLand> plotOfLand =plotOfLandRebository.findById(id);
		if(plotOfLand.get()==null) {
			throw new ResourceNotFoundException("Plot Of Land", "Id", id);
		}else {
			Sensor sensor = new Sensor();
			sensor.setId(sensorId);
			sensor.setStatus(SensorStatus.NOTAVAILABLE);
			plotOfLand.get().setSensor(sensor);
			plotOfLand.get().setAmountOfWaterNeeded(predictAmountOfWater(agriculturalCrop, plotOfLand.get().getArea()));
			if(plotOfLand.get().getTimeslots()!=null) {
				plotOfLand.get().getTimeslots().add(predictTimeSlot(plotOfLand.get().getAmountOfWaterNeeded()));
			}else {
				List<TimeSlot> list = new ArrayList<>();
				list.add(predictTimeSlot(plotOfLand.get().getAmountOfWaterNeeded()));
				plotOfLand.get().setTimeslots(list);
			}
			
		}
		return plotOfLandRebository.save(plotOfLand.get());
	}

	@Override
	public PlotOfLand editPlotOfLand(String status ,Integer id) {
		Optional<PlotOfLand> plotOfLand =plotOfLandRebository.findById(id);
		if(plotOfLand==null) {
			throw new ResourceNotFoundException("Plot Of Land", "Id", id);
		}else {
			plotOfLand.get().setStatus(PlotOfLandIrregationStatus.valueOf(status));
		}
		return plotOfLandRebository.save(plotOfLand.get());
	}

	@Override
	public List<PlotOfLand> getAllPlotOfLand() {
		return plotOfLandRebository.findAll();
	}
	
	private Double predictAmountOfWater(String agriculturalCrop, Double area) {
		if(agriculturalCrop.equals("tree")&&area> 175) {
			return 20.0;
		}else if (agriculturalCrop.equals("tree")&&area< 175) {
			return 15.0;
		}else if(agriculturalCrop.equals("fruits")&&area> 175) {
			return 17.0;
		}else if (agriculturalCrop.equals("fruits")&&area< 175) {
			return 13.0;
		}else if(agriculturalCrop.equals("vegetables")&&area> 175) {
			return 12.0;
		}else if (agriculturalCrop.equals("vegetables")&&area< 175) {
			return 10.0;
		}
		return 10.0;
	}
	
	private TimeSlot predictTimeSlot(double amountOfWater) {
		TimeSlot timeSlot = new TimeSlot(TimeSlotStatus.RESERVED,LocalDateTime.now());
		
		if(amountOfWater==20.0) {
			timeSlot.setTimeNeeded(30.0);
			return timeSlot;
		}else if (amountOfWater==15.0) {
			timeSlot.setTimeNeeded(25.0);
			return timeSlot;
		}else if(amountOfWater==17.0) {
			timeSlot.setTimeNeeded(27.0);
			return timeSlot;
		}else if (amountOfWater==13.0) {
			timeSlot.setTimeNeeded(20.0);
			return timeSlot;
		}else if(amountOfWater==12.0) {
			timeSlot.setTimeNeeded(17.0);
			return timeSlot;
		}else if (amountOfWater==10.0) {
			timeSlot.setTimeNeeded(15.0);
			return timeSlot;
		}
		timeSlot.setTimeNeeded(15.0);
		return timeSlot;
	}
}

package com.irrigation.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.irrigation.system.enums.PlotOfLandIrregationStatus;
import com.irrigation.system.enums.SensorStatus;
import com.irrigation.system.exception.ResourceNotFoundException;
import com.irrigation.system.model.PlotOfLand;
import com.irrigation.system.model.Sensor;
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
	public PlotOfLand configurePlotOfLand(Integer id ,Integer sensorId) {
		
		Optional<PlotOfLand> plotOfLand =plotOfLandRebository.findById(id);
		if(plotOfLand==null) {
			throw new ResourceNotFoundException("Plot Of Land", "Id", id);
		}else {
			Sensor sensor = new Sensor();
			sensor.setId(sensorId);
			sensor.setStatus(SensorStatus.NOTAVAILABLE);
			plotOfLand.get().setSensor(sensor);
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

}

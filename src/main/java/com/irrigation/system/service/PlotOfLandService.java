package com.irrigation.system.service;

import java.util.List;

import com.irrigation.system.model.PlotOfLand;

public interface PlotOfLandService {
	
	 PlotOfLand addNewPlotOfLand(PlotOfLand plotOfLand); 
	 PlotOfLand configurePlotOfLand(Integer id ,Integer sensorId); 
	 PlotOfLand editPlotOfLand(String status ,Integer id); 
	 List<PlotOfLand> getAllPlotOfLand();


}

package com.irrigation.system.irrigation.system;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.irrigation.system.model.PlotOfLand;
import com.irrigation.system.model.Sensor;
import com.irrigation.system.repository.PlotOfLandRebository;
import com.irrigation.system.service.PlotOfLandService;

@SpringBootTest
class ApplicationTests {

	
	@Autowired
	private PlotOfLandService  plotOfLandService;
	@Mock
	private PlotOfLandRebository  plotOfLandRebository;
	
	
	@Test
	void addNewPlotOfLand_test() {
		
		Optional<PlotOfLand> plotOfLand =Optional.of(getPlotOfLand());
		when(plotOfLandRebository.findById(Mockito.anyInt())).thenReturn(plotOfLand);
		when(plotOfLandRebository.save(Mockito.any(PlotOfLand.class))).thenReturn(plotOfLand.get());
		plotOfLandService.addNewPlotOfLand(plotOfLand.get());
		
		
	}
	
	@Test
	void configurePlotOfLand_test() {
		Optional<PlotOfLand> plotOfLand =Optional.of(getPlotOfLand());
		when(plotOfLandRebository.findById(Mockito.anyInt())).thenReturn(plotOfLand);
		when(plotOfLandRebository.save(Mockito.any(PlotOfLand.class))).thenReturn(plotOfLand.get());
		plotOfLandService.configurePlotOfLand(1, 1,"tree");
	}
	@Test
	void editPlotOfLand_test() {
		Optional<PlotOfLand> plotOfLand =Optional.of(getPlotOfLand());
		when(plotOfLandRebository.findById(Mockito.anyInt())).thenReturn(plotOfLand);
		when(plotOfLandRebository.save(Mockito.any(PlotOfLand.class))).thenReturn(plotOfLand.get());
		plotOfLandService.editPlotOfLand("IRREGATED",1);
	}
	@Test
	void getAllPlotOfLand_test() {
		
		List<PlotOfLand> plotOfLands = getListOfPlotOfLands();
		when(plotOfLandRebository.findAll()).thenReturn(plotOfLands);
		plotOfLandService.getAllPlotOfLand();
	}
	
	
	public PlotOfLand getPlotOfLand() {
		PlotOfLand plotOfLand =new PlotOfLand();
		plotOfLand.setId(1);
		plotOfLand.setAmountOfWaterNeeded(3.0);
		plotOfLand.setArea(4.5);
		plotOfLand.setTimeslots(new ArrayList<>());
		Sensor sensor =new Sensor();
		sensor.setId(1);
		plotOfLand.setSensor(sensor);
		return plotOfLand;
	}
	
	public List<PlotOfLand> getListOfPlotOfLands(){
		PlotOfLand plotOfLand =getPlotOfLand();
		List<PlotOfLand> list =new ArrayList<>();
		list.add(plotOfLand);
		return list;
	}
	

}

package com.irrigation.system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.model.PlotOfLand;
import com.irrigation.system.service.PlotOfLandService;


@RestController
@RequestMapping("/api/irrigation/system/plot")
public class PlotOfLandController {

	private final PlotOfLandService plotOfLandService;

	public PlotOfLandController(PlotOfLandService plotOfLandService) {
		this.plotOfLandService = plotOfLandService;
	}
	
		@PostMapping()
		public ResponseEntity<PlotOfLand> savePlotOfLand(@RequestBody PlotOfLand plotOfLand){
			return new ResponseEntity<PlotOfLand>(plotOfLandService.addNewPlotOfLand(plotOfLand), HttpStatus.CREATED);
		}
		
		@GetMapping
		public List<PlotOfLand> getAllPlotsOfLand(){
			return plotOfLandService.getAllPlotOfLand();
		}
		@PutMapping("/edit/{id}")
		public ResponseEntity<PlotOfLand> editPlotOfLand(@PathVariable("id") Integer id
													  ,@RequestParam String status){
			return new ResponseEntity<PlotOfLand>(plotOfLandService.editPlotOfLand(status,id), HttpStatus.OK);
		}
		
		@PutMapping("/cofigure/{id}")
		public ResponseEntity<PlotOfLand> configurePlotOfLand(@PathVariable("id") Integer id
													  ,@RequestParam Integer sensorId){
			return new ResponseEntity<PlotOfLand>(plotOfLandService.configurePlotOfLand(id,sensorId), HttpStatus.OK);
		}
	
	
}

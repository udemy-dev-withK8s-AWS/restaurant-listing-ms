package com.codedecode.restaurantlisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants() {
		
		return new ResponseEntity<List<RestaurantDto>>(restaurantService.findAllRestaurants(), HttpStatus.OK);
	}
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
		
		return new ResponseEntity<RestaurantDto>(restaurantService.addRestaurant(restaurantDto), HttpStatus.CREATED);
	}
	

	@GetMapping("/fetchRestaurantById/{id}")
	public ResponseEntity<RestaurantDto> fetchRestaurantById(@PathVariable Integer id) {
		
		return restaurantService.findRestaurantById(id);
	}
	
}

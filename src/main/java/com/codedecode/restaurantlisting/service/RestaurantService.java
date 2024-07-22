package com.codedecode.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.entity.Restaurant;
import com.codedecode.restaurantlisting.mapper.RestaurantMapper;
import com.codedecode.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;
	
	public List<RestaurantDto> findAllRestaurants(){
		return restaurantRepo.findAll().stream()
				.map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant))
				.collect(Collectors.toList());
	}
	
	public RestaurantDto addRestaurant(RestaurantDto restaurantDto){
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(
				restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto)));

	}
	
	public ResponseEntity<RestaurantDto> findRestaurantById(Integer id){
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		
		if(restaurant.isPresent()) {
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantRepo.findById(id).get()),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Restaurant Not Found!!")));
	}
	
	
	
}

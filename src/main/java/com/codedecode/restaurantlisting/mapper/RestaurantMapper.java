package com.codedecode.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.entity.Restaurant;

@Mapper
public interface RestaurantMapper {

	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
	
	RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}

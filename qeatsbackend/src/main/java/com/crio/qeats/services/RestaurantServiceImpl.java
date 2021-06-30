
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exceptions.InvalidRequest;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
// @Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakHoursServingRadiusInKms = 3.0;
  private final Double normalHoursServingRadiusInKms = 5.0;
  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;



  // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement findAllRestaurantsCloseby.
  // Check RestaurantService.java file for the interface contract.
  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(GetRestaurantsRequest getRestaurantsRequest,
      LocalTime currentTime) {
    List<Restaurant> result = new ArrayList<>();

    if (currentTime.getHour() >= 8 || currentTime.getHour() <= 10 || currentTime.getHour() >= 13
        || currentTime.getHour() <= 14 || currentTime.getHour() >= 19 || currentTime.getHour() <= 21) {
      result = restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(),
          getRestaurantsRequest.getLongitude(), currentTime, peakHoursServingRadiusInKms);
    } else {
      result = restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(),
          getRestaurantsRequest.getLongitude(), currentTime, normalHoursServingRadiusInKms);
    }

    return new GetRestaurantsResponse(result);
  }

  public boolean validateRequest(GetRestaurantsRequest getRestaurantsRequest){
    boolean isValid =true;
    // throw new InvalidRequest(HttpStatus.BAD_REQUEST,"error");
    if (getRestaurantsRequest.getLatitude() == null || getRestaurantsRequest.getLongitude() == null){
      // throw new InvalidRequest(HttpStatus.BAD_REQUEST,"error");
      isValid = false;
    }
    if (getRestaurantsRequest.getLongitude() < -180 || getRestaurantsRequest.getLongitude() > 180){
      isValid =false;
    }
    if (getRestaurantsRequest.getLatitude() < -90 || getRestaurantsRequest.getLatitude() > 90){
      isValid =false;
    }
    // if (getRestaurantsRequest.getLatitude() < -90 || getRestaurantsRequest.getLatitude() > 90){
    //   throw new InvalidRequest(HttpStatus.BAD_REQUEST,"error");
    // }

    return isValid;
  }

}

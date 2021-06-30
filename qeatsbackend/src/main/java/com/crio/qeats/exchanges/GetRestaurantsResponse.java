/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;

import com.crio.qeats.dto.Restaurant;

import org.springframework.stereotype.Component;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Component
public class GetRestaurantsResponse {

    private List<Restaurant> restaurants;

}



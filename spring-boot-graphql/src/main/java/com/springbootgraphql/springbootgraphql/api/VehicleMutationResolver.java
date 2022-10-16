package com.springbootgraphql.springbootgraphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.springbootgraphql.springbootgraphql.dto.VehicleDto;
import com.springbootgraphql.springbootgraphql.entity.Vehicle;
import com.springbootgraphql.springbootgraphql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto){
        return vehicleRepository.save(dtoEntity(vehicleDto));
    }

    private Vehicle dtoEntity(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(new Date());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setType(vehicleDto.getType());
        return vehicle;
    }
}

package com.bms.services;

import com.bms.entities.Place;
import com.bms.repo.PlacesRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
public class PlacesServiceImpl implements  PlacesService{

    @Autowired
    PlacesRepo placesRepo ;
    @Override
    public HashMap<String, Object> savePlace(String data) {
        Place place =new Place();
        HashMap<String, Object> responseMap = new HashMap<>();
        try{
            ObjectMapper om = new ObjectMapper();
          place = om.readValue(data,Place.class);
            System.out.println(place);
            responseMap.put("data",this.placesRepo.save(place));

        }
        catch (Exception e){
    e.printStackTrace();
        }
        return responseMap;
    }

    @Override
    public HashMap<String, Object> getAllPlaces() {
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("places",placesRepo.findAll());
        return responseMap;
    }
}

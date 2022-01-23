package com.bms.services;

import com.bms.entities.Place;

import java.util.HashMap;

public interface PlacesService {
    public HashMap<String, Object> savePlace(String data);

    HashMap<String, Object> getAllPlaces();
}

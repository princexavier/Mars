package com.bms.entities;

import javax.persistence.*;

@Entity(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_seq")
    @Column(name = "id")
    private Long placeId;
    @Column(name = "district_code")
    private Long districtCode;
    @Column(name = "place_name")
    private String placeName;

    @Override
    public String toString() {
        return "Place{" +
                "placeName='" + placeName + '\'' +
                '}';
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }


}

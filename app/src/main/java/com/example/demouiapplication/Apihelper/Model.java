// Model.java
package com.example.demouiapplication.Apihelper;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("results")
    @Expose
    public List<Result> results;
    @SerializedName("generationtime_ms")
    @Expose
    public Float generationtimeMs;


    public class Result {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("latitude")
        @Expose
        public Float latitude;
        @SerializedName("longitude")
        @Expose
        public Float longitude;
        @SerializedName("elevation")
        @Expose
        public Float elevation;
        @SerializedName("feature_code")
        @Expose
        public String featureCode;
        @SerializedName("country_code")
        @Expose
        public String countryCode;
        @SerializedName("admin1_id")
        @Expose
        public Integer admin1Id;
        @SerializedName("timezone")
        @Expose
        public String timezone;
        @SerializedName("population")
        @Expose
        public Integer population;
        @SerializedName("country_id")
        @Expose
        public Integer countryId;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("admin1")
        @Expose
        public String admin1;
        @SerializedName("admin2_id")
        @Expose
        public Integer admin2Id;
        @SerializedName("admin2")
        @Expose
        public String admin2;


    }

}

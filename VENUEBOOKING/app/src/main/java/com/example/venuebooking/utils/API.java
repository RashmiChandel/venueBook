package com.example.venuebooking.utils;

import com.example.venuebooking.entity.User;
import com.example.venuebooking.entity.Venue;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    String BASE_URL ="http://192.168.0.10:4000";

    @POST("/user/login")
    Call<JsonObject> loginUser(@Body User user);

    @POST("/user/register")
    Call<JsonObject> registerUser(@Body User user);
    @GET("/venue/")
   Call<JsonObject> getAllVenues();

    @POST("/booking/bookvenue")
    Call<JsonObject> bookVenue(@Body Venue venue);





//    @GET("/user/{id}")
//    Call<JsonObject> getUserById(@Path("id")int id);

//    @GET("/mobile/")
//    Call<JsonObject> getAllMobiles();
//
//    @POST("/orders/placeorder")
//    Call<JsonObject> placeOrder(@Body Order order);
//
//    @GET("/orders/{id}")
//    Call<JsonObject> getuserOrders(@Path("id")int id);
}
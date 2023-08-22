package com.example.venuebooking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.venuebooking.R;
import com.example.venuebooking.entity.Booking;
import com.example.venuebooking.entity.Venue;
import com.example.venuebooking.utils.API;
import com.example.venuebooking.utils.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    TextView
            textName,textDescription,textAddress,textContact,textPrice;
    ImageView imageView;
    Venue venue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textName = findViewById(R.id.textName);
        textDescription = findViewById(R.id.textDescription);
        textAddress = findViewById(R.id.textAddress);
        textContact = findViewById(R.id.textContact);
        textPrice = findViewById(R.id.textPrice);
        imageView = findViewById(R.id.imageView);
        venue =(Venue) getIntent().getSerializableExtra("venue");

        getVenueDetails();
    }

    private void getVenueDetails() {
        textName.setText("Name  :"+venue.getVenue_name());
        textDescription.setText("Description :"+venue.getVenue_description());
        textAddress.setText("Address  :"+venue.getVenue_address());
        textContact.setText("Contact  :"+venue.getVenue_contact());
        textPrice.setText("PricePerDay  :"+venue.getVenue_amountPerDay());
        Glide.with(this).load(API.BASE_URL+"/"+venue.getVenue_image()).into(imageView);
    }

    public void book(View view){
   int User_id = getSharedPreferences("VENUEBOOKING",MODE_PRIVATE).getInt("User_id",0);
        int Venue_id = venue.getVenue_id();
        Booking booking = new Booking();
        booking.setUser_id(User_id);
        booking.setVenue_id(Venue_id);

        RetrofitClient.getInstance().getApi().bookVenue(venue).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.body().getAsJsonObject().get("status").getAsString().equals("success")){
                    Toast.makeText(DetailsActivity.this, "Venue Booked", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(DetailsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

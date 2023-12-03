package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.EmailVerification;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailVerificationActivity extends AppCompatActivity {
    PinView pinView ;
    Button btVerify;
    ImageView leftarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        String email = getIntent().getStringExtra("EMAIL");
        TextView tvGmail = findViewById(R.id.tvGmail);
        tvGmail.setText(email);

        pinView = findViewById(R.id.pinview1);
        btVerify = findViewById(R.id.btVerify);
        leftarrow = findViewById(R.id.leftarrow);

        leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailVerificationActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences shp = getSharedPreferences("REGISTER", Context.MODE_PRIVATE);

                FoodieService foodieService = APIUtil.getFoodieService();
                Call<EmailVerification> emailVerificationCall = foodieService.verifyEmail("Bearer" +shp,tvGmail.getText().toString(),pinView.getText().toString());

                emailVerificationCall.enqueue(new Callback<EmailVerification>() {

                    @Override
                    public void onResponse(Call<EmailVerification> call, Response<EmailVerification> response) {
                        if (response.code() == 200) {
                            Toast.makeText(EmailVerificationActivity.this, "Email is Verified", Toast.LENGTH_SHORT).show();

                            //save Token
                            SharedPreferences sharedPreferences = getSharedPreferences("OTP", Context.MODE_PRIVATE);
                            String savedToken = sharedPreferences.getString("TOKEN","");
                            sharedPreferences.edit().putBoolean("OTP", true).apply();

                            Intent intent = new Intent(EmailVerificationActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();

                        } else if (response.code() == 401) {
                            Toast.makeText(EmailVerificationActivity.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(EmailVerificationActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<EmailVerification> call, Throwable t) {
                        Toast.makeText(EmailVerificationActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }}
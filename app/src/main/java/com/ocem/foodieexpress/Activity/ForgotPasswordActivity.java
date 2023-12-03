package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.ForgotPassword;
import com.ocem.foodieexpress.model.Login;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;

import java.text.BreakIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ImageView imageView = findViewById(R.id.leftarrow);
        TextView tiEmail = findViewById(R.id.tifEmail);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Button btsend = findViewById(R.id.btSend);
        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodieService foodieService = APIUtil.getFoodieService();
                Call<ForgotPassword> forgotPasswordCall = foodieService.verifyGmail(tiEmail.getText().toString());

                forgotPasswordCall.enqueue(new Callback<ForgotPassword>() {

                    @Override
                    public void onResponse(Call<ForgotPassword> call, Response<ForgotPassword> response) {
                        if (response.code() == 200) {
                            Toast.makeText(ForgotPasswordActivity.this, "Success", Toast.LENGTH_SHORT).show();

                            //save Token
                            SharedPreferences sharedPreferences = getSharedPreferences("EMAIL", MODE_PRIVATE);
                            sharedPreferences.edit().putBoolean("EMAIL", true).apply();

                            Intent intent = new Intent(ForgotPasswordActivity.this, CreateNewPasswordActivity.class);
                            startActivity(intent);
                            finish();

                        } else if (response.code() == 401) {
                            Toast.makeText(ForgotPasswordActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(ForgotPasswordActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ForgotPassword> call, Throwable t) {
                        Toast.makeText(ForgotPasswordActivity.this, "Fail", Toast.LENGTH_SHORT).show();

                    }
                });
            }
});
    }
}
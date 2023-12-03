package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.Login;
import com.ocem.foodieexpress.model.ResetPassword;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateNewPasswordActivity extends AppCompatActivity {

    TextInputEditText tiPEmail,tiotp,tiNewPassword;
    ProgressBar progressResetpw;
    Button btResetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password);

        ImageView imageView = findViewById(R.id.leftarrow);
        tiPEmail = findViewById(R.id.tiPEmail);
        tiotp = findViewById(R.id.tiotp);
        tiNewPassword = findViewById(R.id.tiNewPassword);
        btResetPassword = findViewById(R.id.btResetPassword);

        progressResetpw.findViewById(R.id.progressResetpw);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateNewPasswordActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        btResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btResetPassword.setVisibility(View.GONE);
                progressResetpw.setVisibility(View.VISIBLE);

                FoodieService foodieService = APIUtil.getFoodieService();
                Call<ResetPassword> resetPasswordCall = foodieService.resetPassword(tiPEmail.getText().toString(),
                       tiotp.getText().toString(), tiNewPassword.getText().toString());

                resetPasswordCall.enqueue(new Callback<ResetPassword>() {

                    @Override
                    public void onResponse(Call<ResetPassword> call, Response<ResetPassword> response) {
                        if (response.code() == 200) {
                            Toast.makeText(CreateNewPasswordActivity.this, "Password Reset Successfully", Toast.LENGTH_SHORT).show();

                            btResetPassword.setVisibility(View.VISIBLE);
                            progressResetpw.setVisibility(View.GONE);

                            //save Token
                            SharedPreferences sharedPreferences = getSharedPreferences("RESET", MODE_PRIVATE);
                            sharedPreferences.edit().putBoolean("RESET", true).apply();

                            Intent intent = new Intent(CreateNewPasswordActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();

                        } else if (response.code() == 401) {
                            Toast.makeText(CreateNewPasswordActivity.this, "Invalid Email or Otp", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(CreateNewPasswordActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResetPassword> call, Throwable t) {
                        btResetPassword.setVisibility(View.VISIBLE);
                        progressResetpw.setVisibility(View.GONE);
                        Toast.makeText(CreateNewPasswordActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
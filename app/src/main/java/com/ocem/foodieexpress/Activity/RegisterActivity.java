package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.Register;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText tiRUsername, tiREmail, tiRPassword;
    Button btRegister;
    ProgressBar progressRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tiRUsername = findViewById(R.id.tiRUsername);
        tiREmail = findViewById(R.id.tiREmail);
        tiRPassword = findViewById(R.id.tiCPassword);
        btRegister = findViewById(R.id.btRegister);

        progressRegister = findViewById(R.id.progressRegister);

        TextView tvSignIn = findViewById(R.id.tvSignIn);
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkRegister()) {
                    // Hide the register button and show the loading indicator
                    btRegister.setVisibility(View.GONE);
                    progressRegister.setVisibility(View.VISIBLE);

                    FoodieService foodieService = APIUtil.getFoodieService();
                    Call<Register> registerCall = foodieService.registerUser(
                            tiRUsername.getText().toString(),
                            tiREmail.getText().toString(),
                            tiRPassword.getText().toString()
                    );

                    registerCall.enqueue(new Callback<Register>() {
                        @Override
                        public void onResponse(Call<Register> call, Response<Register> response) {
                            // Log the response code and response body for debugging
                            Log.d("Response Code", String.valueOf(response.code()));
                            Log.d("Response Body", response.body() != null ? response.body().toString() : "null");

                            // After the registration process is complete (success or failure),
                            // restore the button and hide the loading indicator
                            btRegister.setVisibility(View.VISIBLE);
                            progressRegister.setVisibility(View.GONE);

                            handleRegistrationResponse(response);
                        }

                        @Override
                        public void onFailure(Call<Register> call, Throwable t) {
                            // In case of failure, also restore the button and hide the loading indicator
                            btRegister.setVisibility(View.VISIBLE);
                            progressRegister.setVisibility(View.GONE);

                            Toast.makeText(RegisterActivity.this, "Failed to register", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private boolean checkRegister() {
        String username = tiRUsername.getText().toString();
        String email = tiREmail.getText().toString();
        String password = tiRPassword.getText().toString();

        if (TextUtils.isEmpty(username)) {
            tiRUsername.setError("Username is required");
            return false;
        }

        // Check for if an email is not provided and email format is wrong
        if (TextUtils.isEmpty(email)) {
            tiREmail.setError("Email is required");
            return false;
        } else if (!isValidEmail(email)) {
            tiREmail.setError("Invalid email format");
            return false;
        }

        // Check for a valid password format
        if (TextUtils.isEmpty(password)) {
            tiRPassword.setError("Password is required");
            return false;
       }
//        else if (!isValidPassword(password)) {
//            tiRPassword.setError("Password must be 6 characters long");
//            return false;
//        }
        return true;
    }

    private boolean isValidEmail(String email) {
        // Define a regular expression for a valid email format
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        // Use the regular expression to validate the email format
        return email.matches(emailPattern);
    }

//    private boolean isValidPassword(String password) {
//        // Define a regular expression for a valid password format
//        // Example: Minimum 8 characters, at least one uppercase letter, one lowercase letter, and one digit
//        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
//
//        // Use the regular expression to validate the password format
//        return password.matches(passwordPattern);
//    }

    private void handleRegistrationResponse(Response<Register> response) {
        int statusCode = response.code();
        switch (statusCode) {
            case 200:
                // Successful registration
                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                Register register = response.body();
                String token = register.getToken();

                // Store the token and registration status in SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("REGISTER", MODE_PRIVATE);
                sharedPreferences.edit().putString("TOKEN", token).apply();
                sharedPreferences.edit().putBoolean("REGISTER", true).apply();

                Intent intent = new Intent(RegisterActivity.this, EmailVerificationActivity.class);
                intent.putExtra("EMAIL", tiREmail.getText().toString());
                startActivity(intent);
                finish();
                break;
            case 400:
                // Bad Request: Invalid input data
                Toast.makeText(RegisterActivity.this, "Invalid input data", Toast.LENGTH_SHORT).show();
                break;
            case 401:
                // Unauthorized: Invalid Username or Password
                Toast.makeText(RegisterActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                break;
            case 403:
                // Forbidden: User registration not allowed
                Toast.makeText(RegisterActivity.this, "Registration not allowed", Toast.LENGTH_SHORT).show();
                break;
            case 409:
                // Conflict: User with the same email already exists
                Toast.makeText(RegisterActivity.this, "User with the same email already exists", Toast.LENGTH_SHORT).show();
                break;
            case 504:
                // Gateway Timeout: No Internet Connection
                Toast.makeText(RegisterActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                break;
            default:
                // Other errors
                Toast.makeText(RegisterActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}




//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.material.textfield.TextInputEditText;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.model.Login;
//import com.ocem.foodieexpress.model.Register;
//import com.ocem.foodieexpress.remote.APIUtil;
//import com.ocem.foodieexpress.remote.FoodieService;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class RegisterActivity extends AppCompatActivity {
//
//    TextInputEditText tiRUsername,tiREmail,tiRPassword;
////            ,tiCPassword;
//    Button btRegister;
//    String name,email,password;
////            ,confirmPassword;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//         tiRUsername = findViewById(R.id.tiRUsername);
//         tiREmail = findViewById(R.id.tiREmail);
//         tiRPassword = findViewById(R.id.tiCPassword);
//         btRegister = findViewById(R.id.btRegister);
//
//        TextView tvSignIn = findViewById(R.id.tvSignIn);
//        tvSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(i);
//            }
//        });
//
//
//
//        btRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String email =  tiREmail.getText().toString();
//
//              checkRegister();
//                FoodieService foodieService = APIUtil.getFoodieService();
//                Call<Register> registerCall = foodieService.registerUser(tiRUsername.getText().toString(),
//                        tiREmail.getText().toString() , tiRPassword.getText().toString());
//
//                registerCall.enqueue(new Callback<Register>(){
//                    @Override
//                    public void onResponse(Call<Register> call, Response<Register> response) {
//                        if (response.code() == 200) {
//                            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                            Register register = response.body();
//                            String token = register.getToken();
//
//                            SharedPreferences sharedPreferences = getSharedPreferences("REGISTER", MODE_PRIVATE);
//                            sharedPreferences.edit().putString("TOKEN", token).apply();
//                            sharedPreferences.edit().putBoolean("REGISTER", true).apply();
//
//                            Intent intent = new Intent(RegisterActivity.this, EmailVerificationActivity.class);
//                            intent.putExtra("EMAIL",email);
//                            startActivity(intent);
//                            finish();
//
//                        } else if (response.code() == 401) {
//                            Toast.makeText(RegisterActivity.this,
//                                    "Invalid Username or Password", Toast.LENGTH_SHORT).show();
//                        } else if (response.code() == 504) {
//                                Toast.makeText(RegisterActivity.this,
//                                        "No Internet Connection", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(RegisterActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Register> call, Throwable t) {
//                        Toast.makeText(RegisterActivity.this, "Fail", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//    }
//
//    private void checkRegister() {
////        name = tiRUsername.getText().toString();
////        email = tiREmail.getText().toString();
////        password = tiRPassword.getText().toString();
////        confirmPassword = tiCPassword.getText().toString();
//
//        if (TextUtils.isEmpty(tiRUsername.getText().toString())){
//            tiRUsername.setError("Username is required");
//            return;
//        }
//
//        if (TextUtils.isEmpty(tiREmail.getText().toString())){
//            tiREmail.setError("Email is required");
//            return;
//        }
//
//        if (TextUtils.isEmpty(tiRPassword.getText().toString())){
//            tiRPassword.setError("Password is required");
//        }
////        else if ( !password.equals(confirmPassword)){
////            alertFail("Password and Password Confirmation doesn't match");
////        }
////        else {
////            sendRegister();
////        }
//    }
//
////    private void sendRegister() {
////
////        alertSuccess("Register Successfully");
////    }
//
////    private void alertSuccess(String register_successfully) {
////        new AlertDialog.Builder(this)
////                .setTitle("Success")
////                .setMessage(register_successfully)
////                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        onBackPressed();
////                    }
////                }).show();
////    }
//
////    private void alertFail(String s) {
////        new AlertDialog.Builder(this)
////                .setTitle("Failed")
////                .setMessage(s)
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        dialog.dismiss();
////                    }
////                }).show();
////    }
//}
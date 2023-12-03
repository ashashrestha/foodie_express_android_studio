package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ocem.foodieexpress.Activity.bg.LoginTask;
import com.ocem.foodieexpress.R;

public class LoginActivity extends AppCompatActivity implements LoginTask.LoginCallback {

    TextInputEditText tiEmail, tiPassword;
    Button btLogin;
    TextView tvSignup, tvforgotpw;
    String email, password;
    ProgressBar progressLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();

//        if (isLoggedIn) {
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }

        tiEmail = findViewById(R.id.tiEmail);
        tiPassword = findViewById(R.id.tiPassword);
        btLogin = findViewById(R.id.btLogin);
        progressLogin = findViewById(R.id.progressLogin); // Find the progress bar

        tvforgotpw = findViewById(R.id.tvforgotPw);
        tvforgotpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

        tvSignup = findViewById(R.id.tvSignup);
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkLoginFields()) {
                    // Start the AsyncTask to perform login
                    LoginTask loginTask = new LoginTask(LoginActivity.this, LoginActivity.this);
                    loginTask.execute(email, password);
                }
            }
        });
    }

    private boolean checkLoginFields() {
        email = tiEmail.getText().toString().trim();
        password = tiPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            tiEmail.setError("Email is required");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            tiPassword.setError("Password is required");
            return false;
        }

        return true;
    }

    @Override
    public void onLoginComplete(boolean success) {
        // Handle login completion here, if needed
        if (success) {
            // Login was successful, you can perform any necessary actions here.
            // For example, you might want to start the MainActivity.
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finish the LoginActivity so the user can't navigate back to it after login.
        } else {
            // Login failed. You can display an error message to the user if needed.
            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
























//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//
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
//import com.ocem.foodieexpress.remote.APIUtil;
//import com.ocem.foodieexpress.remote.FoodieService;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
//public class LoginActivity extends AppCompatActivity {
//
//    TextInputEditText tiEmail,tiPassword;
//    Button btLogin;
//    TextView tvSignup,tvforgotpw;
//    String email,password;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN",MODE_PRIVATE);
//        Boolean isLoggedIn = sharedPreferences.getBoolean("LOGIN",false);
//
//        if(isLoggedIn){
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//
//        tiEmail = findViewById(R.id.tiEmail);
//        tiPassword = findViewById(R.id.tiPassword);
//        btLogin = findViewById(R.id.btLogin);
//
//        tvforgotpw = findViewById(R.id.tvforgotPw);
//        tvforgotpw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
//                startActivity(i);
//            }
//        });
//
//        tvSignup = findViewById(R.id.tvSignup);
//       tvSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(i);
//            }
//        });
//
//        btLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              checkLogin();
//                FoodieService foodieService = APIUtil.getFoodieService();
//                Call<Login> loginCall = foodieService.validateUser(tiEmail.getText().toString(),
//                        tiPassword.getText().toString());
//
//                loginCall.enqueue(new Callback<Login>() {
//
//                    @Override
//                    public void onResponse(Call<Login> call, Response<Login> response) {
//
//                        if (response.code() == 200) {
//                            Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                            Login login = response.body();
//                            String token = login.getToken();
//
//                            //save Token
//                            SharedPreferences sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
//                            sharedPreferences.edit().putString("TOKEN", token).apply();
//                            sharedPreferences.edit().putBoolean("LOGIN", true).apply();
//
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
//
//                        } else if (response.code() == 401) {
//                            Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(LoginActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Login> call, Throwable t) {
//                        Toast.makeText(LoginActivity.this, "Fail", Toast.LENGTH_SHORT).show();
//
//                    }
//
//            });
//            }
//        });
//
//    }
//
//  private void checkLogin() {
//       if (TextUtils.isEmpty(tiEmail.getText().toString())){
//           tiEmail.setError("Email is required");
//           return;
//        }
//
//      if (TextUtils.isEmpty(tiPassword.getText().toString())){
//         tiPassword.setError("Password is required");
//      }
////        else {
////            sendLogin();
////        }
// }
////
////    private void sendLogin() {
////       Intent i = new Intent(LoginActivity.this,HomeActivity.class);
////       startActivity(i);
////       finish();
////    }
////
//// private void alertFail(String email_and_password_is_required) {
////     new AlertDialog.Builder(this)
////             .setTitle("Failed")
////            .setMessage(email_and_password_is_required)
////              .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                   public void onClick(DialogInterface dialog, int which) {
////
////                        dialog.dismiss();
////                  }
////               })
////              .show();
//// }
//
//}









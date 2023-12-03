package com.ocem.foodieexpress.Activity.bg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;

import com.ocem.foodieexpress.Activity.MainActivity;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.Login;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginTask extends AsyncTask<String, Void, Boolean> {

    private Context context;
    private LoginCallback callback;
    private String email;
    private String password;

    public LoginTask(Context context, LoginCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        email = params[0];
        password = params[1];

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            return false; // Invalid input
        }

        try {
            FoodieService foodieService = APIUtil.getFoodieService();
            Call<Login> loginCall = foodieService.validateUser(email, password);
            Response<Login> response = loginCall.execute();

            if (response.isSuccessful()) {
                // Login successful
                Login login = response.body();
                String token = login.getToken();

                // Save Token
                SharedPreferences sharedPreferences = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("TOKEN", token);
                editor.putBoolean("LOGIN", true);
                editor.apply();

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // Login failed
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if (success) {
            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
        }
        if (callback != null) {
            callback.onLoginComplete(success);
        }
    }

    public interface LoginCallback {
        void onLoginComplete(boolean success);
    }
}


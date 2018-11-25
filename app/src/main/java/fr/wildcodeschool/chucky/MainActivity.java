package fr.wildcodeschool.chucky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.bt_refresh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                String url = "https://api.chucknorris.io/jokes/random";

                final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String iconUrl = response.getString("icon_url");
                                    String value = response.getString("value");
                                    TextView textView = findViewById(R.id.tv_joke);
                                    textView.setText(value);
                                    ImageView imageView = findViewById(R.id.iv_icon);
                                    Glide.with(MainActivity.this).load(iconUrl).into(imageView);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // Afficher l'erreur
                                Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                            }
                        }
                );
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}

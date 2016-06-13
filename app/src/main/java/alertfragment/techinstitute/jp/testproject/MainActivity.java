package alertfragment.techinstitute.jp.testproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private enum KU {
        OTAKU("大田区");

        private String ku;

        KU(String ku) {
            this.ku = ku;
        }

        public String getKu() {
            return this.ku;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.weatherWebAPIAccess((TextView) findViewById(R.id.hello));
    }


    /**
     * 天気予報WebAPIを呼び出し,
     * 引数で渡されるTextViewに表示する
     *
     * @param textView 天気出力先
     */
    private void weatherWebAPIAccess(@NonNull final TextView textView) {

        int method = Request.Method.GET;

        // 東京都の天気予報
        String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010";


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("TEST", response.toString());

                JSONArray locations = null;
                JSONObject location = null;
                String ootaku = null;
                try {
                    locations = response.getJSONArray("pinpointLocations");
                    for (int i = 0; i < locations.length(); i++) {
                        location = locations.getJSONObject(i);
                        if (KU.OTAKU.getKu().equals(location.getString("name"))) {


                        }


                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                textView.setText(response.toString());
            }

        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = error.getMessage();
                Log.d("TEST", message);
            }
        };

        // JSONObject requestBody = null;
        queue.add(new JsonObjectRequest(method, url, null, listener, errorListener));
    }
}

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

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.socialIMEAccess((TextView) findViewById(R.id.hello));

    }

    /**
     * 天気予報WebAPIを呼び出し,
     * 引数で渡されるTextViewに表示する
     *
     * @param textView 天気出力先
     */
    private void socialIMEAccess(@NonNull final TextView textView) {

        int method = Request.Method.GET;

        // 東京都の天気予報
        String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010";

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("TEST", response.toString());
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

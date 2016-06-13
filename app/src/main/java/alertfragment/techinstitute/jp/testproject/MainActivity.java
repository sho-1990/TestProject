package alertfragment.techinstitute.jp.testproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * ソーシャルIMEを呼び出し,
     * 引数に渡される文字列を変換する
     *
     * @param params 変換対象文字列
     * @return 変換後文字列
     */
    private String socialIMEAccess(String[] params) {

        assert params != null;

        int method = Request.Method.GET;
        // 東京都の天気予報
        String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010";

        mQueue = Volley.newRequestQueue(getApplicationContext());

        JSONObject requestBody = null;
        Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("TEST", response.toString());
            }

        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = error.getMessage();
                Log.d("TEST", message);
            }
        };

        mQueue.add(new JsonObjectRequest(method, url, requestBody, listener, errorListener));
    }
}

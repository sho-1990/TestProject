package alertfragment.techinstitute.jp.testproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.widget.TabHost;
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

import java.util.List;

import javax.inject.Inject;

import alertfragment.techinstitute.jp.testproject.component.DaggerPrefecturesMapComponent;
import alertfragment.techinstitute.jp.testproject.dao.PrefecturesMap;
import alertfragment.techinstitute.jp.testproject.entity.PrefecturesEntity;
import layout.fragments.TabFragment;

public class MainActivity extends FragmentActivity implements TabFragment.OnFragmentInteractionListener, TabHost.OnTabChangeListener {

    @Inject
    PrefecturesMap mPrefecturesMap;


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

        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        if (tabHost != null) {
            tabHost.setup(this, getSupportFragmentManager(), R.id.honshu);

            TabHost.TabSpec tabSpec1, tabSpec2;
            tabSpec1 = tabHost.newTabSpec("tab1");
            tabSpec1.setIndicator("tab1");
            tabHost.addTab(tabSpec1, TabFragment.class, null);

            tabSpec2 = tabHost.newTabSpec("tab2");
            tabSpec2.setIndicator("tab2");
            tabHost.addTab(tabSpec2, TabFragment.class, null);

            tabHost.setOnTabChangedListener(this);
        }

//        this.weatherWebAPIAccess((TextView) findViewById(R.id.hello));

        mPrefecturesMap = DaggerPrefecturesMapComponent.create().maker();
        List<PrefecturesEntity> prefecturesEntities = mPrefecturesMap.selectPrefectures("mock");
        TextView t1 = (TextView) findViewById(R.id.hello);
        if (t1 != null) {
            t1.setText(prefecturesEntities.get(0).getPrefecture());
        }
    }


    @Override
    public void onTabChanged(String tabId) {
        Log.d("onTabChanged", "tabId: " + tabId);

    }
    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("onTabChanged", "uri: " + uri);
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

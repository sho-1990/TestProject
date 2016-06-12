package alertfragment.techinstitute.jp.testproject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class MyAsyncTaskURLConnection extends AsyncTask<Void, Void, Void> {

    private TextView mTextView;
    private Map<String, List<String>> mResponseHeaders;

    public MyAsyncTaskURLConnection(TextView textView) {
        super();

        assert textView instanceof TextView;

        mTextView = textView;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            URL url = new URL("https://www.google.co.jp");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Host", "www.google.co.jp");
            connection.connect();

            int responseCode = connection.getResponseCode();
            Log.d("TEST", "responseCode=" + responseCode);
            String contentLength = connection.getHeaderField("Content-Length");
            Log.d("TEST", "Content-Length=" + contentLength);
            String contentType = connection.getHeaderField("Content-Type");
            Log.d("TEST", "contentType" + contentType);
            mResponseHeaders = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : mResponseHeaders.entrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                Log.d("KEY", entry.getKey());
                for (String value : entry.getValue()) {
                    Log.d("VALUE", value);
                }
            }

            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                Log.d("TEST", new String(buffer, 0, length));

            }
            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        mTextView.setText("task end!");
    }
}

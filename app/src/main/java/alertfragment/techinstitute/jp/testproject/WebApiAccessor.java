package alertfragment.techinstitute.jp.testproject;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Web Api呼び出しクラス
 */
public class WebApiAccessor extends AsyncTask<String, Void, String> {

    private TextView mTextView;

    public WebApiAccessor(TextView textView) {
        mTextView = textView;
    }

    @Override
    protected String doInBackground(@NonNull String... params) {

        assert params[0] != null;

        try {
            String keyword = params[0];
            URL url = new URL("http://www.social-ime.com/api/?string=" + keyword);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();

            StringBuilder sb = new StringBuilder();
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, length, "EUC-JP"));
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }
}

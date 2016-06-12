package alertfragment.techinstitute.jp.testproject;


import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {

        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("www.google.co.jp", 80));

            String request = "GET / HTTP/1.1\n"
                    + "Host: www.google.co.jp\n"
                    + "\n\n";

            outputStream = socket.getOutputStream();
            outputStream.write(request.getBytes());
            outputStream.flush();

            // レスポンス
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                Log.d("TEST", new String(buffer, 0, length));

            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

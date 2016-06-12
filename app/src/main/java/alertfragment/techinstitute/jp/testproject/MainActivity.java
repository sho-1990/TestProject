package alertfragment.techinstitute.jp.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebApiAccessor task = new WebApiAccessor((TextView)findViewById(R.id.hello));
        task.execute("漢字");
    }
}

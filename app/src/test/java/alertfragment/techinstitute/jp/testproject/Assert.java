package alertfragment.techinstitute.jp.testproject;

import org.junit.Test;

public class Assert {

    MyAsyncTask task;

    @Test
    public void test() {
        task = new MyAsyncTask();
        task.execute();
    }


}

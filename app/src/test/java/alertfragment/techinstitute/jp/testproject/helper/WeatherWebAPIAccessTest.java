package alertfragment.techinstitute.jp.testproject.helper;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * テスト
 */
public class WeatherWebAPIAccessTest {

    @Test
    public void testFetchPointWeatherOfJSON() {
        System.out.println("fetchPointWeatherOfJSON");
        Assert.assertSame(WeatherWebAPIAccess.fetchPointWeatherOfJSON("東京", "大田区"),
                new JSONObject());
    }

}
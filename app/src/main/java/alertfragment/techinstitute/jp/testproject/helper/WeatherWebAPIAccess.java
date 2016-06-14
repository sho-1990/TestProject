package alertfragment.techinstitute.jp.testproject.helper;

import android.support.annotation.NonNull;

import org.json.JSONObject;

/**
 * 天気取得ヘルパー
 * 指定された都道府県の特定地域の天気情報をJSON形式で返す
 */
public class WeatherWebAPIAccess {

    private WeatherWebAPIAccess() {}

    /***
     *
     * @param location 都道府県を示す文字列(例：東京都)
     * @param point locationに含まれる特定の地域を示す文字列(例：大田区)
     * @return
     */
    public static JSONObject fetchPointWeatherOfJSON(@NonNull final String location,
                                                     @NonNull final String point) {




        return new JSONObject();

    }
}

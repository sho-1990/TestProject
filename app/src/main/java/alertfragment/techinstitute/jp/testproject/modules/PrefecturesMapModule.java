package alertfragment.techinstitute.jp.testproject.modules;

import alertfragment.techinstitute.jp.testproject.dao.PrefecturesMap;
import alertfragment.techinstitute.jp.testproject.dao.PrefecturesMapImpl;
import dagger.Module;
import dagger.Provides;

/**
 * モジュール
 */
@Module
public class PrefecturesMapModule {

    @Provides
    public PrefecturesMap providePrefecturesMap() {
        return new PrefecturesMapImpl();
    }
}

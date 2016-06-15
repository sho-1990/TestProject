package alertfragment.techinstitute.jp.testproject.component;

import alertfragment.techinstitute.jp.testproject.dao.PrefecturesMap;
import alertfragment.techinstitute.jp.testproject.modules.PrefecturesMapModule;
import dagger.Component;

/**
 * コンポーネント
 */
@Component(modules = PrefecturesMapModule.class)
public interface PrefecturesMapComponent {
    PrefecturesMap maker();
}

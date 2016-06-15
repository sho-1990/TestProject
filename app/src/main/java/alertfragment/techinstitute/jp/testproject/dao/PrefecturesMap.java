package alertfragment.techinstitute.jp.testproject.dao;

import java.util.List;

import alertfragment.techinstitute.jp.testproject.entity.PrefecturesEntity;

/**
 *
 */
public interface PrefecturesMap {

    public List<PrefecturesEntity> selectPrefectures(String area);
}

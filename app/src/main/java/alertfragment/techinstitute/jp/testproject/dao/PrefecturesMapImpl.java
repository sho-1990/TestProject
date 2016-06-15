package alertfragment.techinstitute.jp.testproject.dao;

import java.util.ArrayList;
import java.util.List;

import alertfragment.techinstitute.jp.testproject.entity.PrefecturesEntity;

/**
 *
 */
public class PrefecturesMapImpl implements PrefecturesMap {

    private List<PrefecturesEntity> mPrefectures;

    @Override
    public List<PrefecturesEntity> selectPrefectures(String area) {

        // todo DBへのアクセスを書く
        mPrefectures = new ArrayList<>();

        PrefecturesEntity prefecturesEntity = new PrefecturesEntity();
        prefecturesEntity.setId("430010");
        prefecturesEntity.setPrefecture("熊本");
        mPrefectures.add(prefecturesEntity);
        prefecturesEntity = new PrefecturesEntity();
        prefecturesEntity.setId("430020");
        prefecturesEntity.setPrefecture("阿蘇乙姫");
        mPrefectures.add(prefecturesEntity);
        return mPrefectures;
    }
}

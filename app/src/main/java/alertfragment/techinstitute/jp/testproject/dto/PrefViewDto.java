package alertfragment.techinstitute.jp.testproject.dto;

import alertfragment.techinstitute.jp.testproject.R;

/**
 * 都道府県名表示用データ
 */
public class PrefViewDto {

    private String pref;
    private int resourceId = R.mipmap.ic_launcher;

    public PrefViewDto(String pref, int resourceId) {
        this.pref = pref;
        this.resourceId = resourceId;
    }

    public String getPref() {
        return this.pref;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}

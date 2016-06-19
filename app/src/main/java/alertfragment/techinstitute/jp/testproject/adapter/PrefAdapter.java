package alertfragment.techinstitute.jp.testproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;

import alertfragment.techinstitute.jp.testproject.dto.CityViewDto;

/**
 * 都道府県名表示用Adapter
 */
public class PrefAdapter extends BaseExpandableListAdapter{

    private List<String> groups;
    private List<List<CityViewDto>> children;
    private Context context = null;
    private int[] rowId;

    public PrefAdapter(Context context,
                       int[] rowId,
                       List<String> groups,
                       List<List<CityViewDto>> children) {
        this.groups = groups;
        this.children = children;
        this.context = context;
        this.rowId = rowId;
    }

    @Override
    public int getGroupCount() {
        return children.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}

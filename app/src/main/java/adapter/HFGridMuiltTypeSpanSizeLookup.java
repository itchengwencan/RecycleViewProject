package adapter;

import android.support.v7.widget.GridLayoutManager;

import com.igeek.comicmuilttyperecycleviewproject.MainActivity;
import com.igeek.hfrecyleviewlib.BasicHFRecyAdapter;

/**
 * Created by User on 16/7/1.
 */
public class HFGridMuiltTypeSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    private GridLayoutManager layoutManager;
    private BasicHFRecyAdapter adapter;

    @Override
    public int getSpanSize(int position) {
        if (layoutManager != null && adapter != null) {
            if (adapter.needMatchParentWidth(position)) {
                return layoutManager.getSpanCount();
            } else {
                final int type = adapter.getItemViewType(position);
                if (type == MainActivity.type1) {
                    //标题导航类型
                    return layoutManager.getSpanCount();
                } else if (type == MainActivity.type2) {
                    //一张大图类型
                    return layoutManager.getSpanCount();
                } else if (type == MainActivity.type3) {
                    //横向图文模式
                    return layoutManager.getSpanCount();
                } else if (type == MainActivity.type4) {
                    //横向图文模式
                    return 1;
                }else if (type == MainActivity.type5) {
                    //横向图文模式
                    return layoutManager.getSpanCount();
                }else if (type == MainActivity.type6) {
                    //横向图文模式
                    return layoutManager.getSpanCount();
                }else if (type == MainActivity.type7) {
                    //横向图文模式
                    return 1;
                }
            }
        }
        return 1;
    }

    public void setLayoutManager(GridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public BasicHFRecyAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(BasicHFRecyAdapter adapter) {
        this.adapter = adapter;
    }
}

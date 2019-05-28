package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.i;
import com.tencent.smtt.sdk.WebView;

public class d implements i {
    private ImageView ikh;
    private ListView mListView;
    private Bitmap zWg;
    int zWh = WebView.NIGHT_MODE_COLOR;

    public d(ListView listView) {
        this.mListView = listView;
    }

    public final View Qw(int i) {
        AppMethodBeat.i(113109);
        ListView listView = this.mListView;
        View childAt = listView.getChildAt((listView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            AppMethodBeat.o(113109);
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.zWg = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.ikh == null) {
            this.ikh = new ImageView(this.mListView.getContext());
        }
        this.ikh.setBackgroundColor(this.zWh);
        this.ikh.setPadding(0, 0, 0, 0);
        this.ikh.setImageBitmap(this.zWg);
        this.ikh.setLayoutParams(new LayoutParams(childAt.getWidth(), childAt.getHeight()));
        childAt = this.ikh;
        AppMethodBeat.o(113109);
        return childAt;
    }

    public void h(Point point) {
    }

    public final void fr(View view) {
        AppMethodBeat.i(113110);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        }
        ai.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", this.zWg.toString());
        this.zWg.recycle();
        this.zWg = null;
        AppMethodBeat.o(113110);
    }
}

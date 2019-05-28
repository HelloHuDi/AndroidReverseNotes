package com.tencent.p177mm.p612ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C16019i;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.ui.widget.sortlist.d */
public class C46704d implements C16019i {
    private ImageView ikh;
    private ListView mListView;
    private Bitmap zWg;
    int zWh = WebView.NIGHT_MODE_COLOR;

    public C46704d(ListView listView) {
        this.mListView = listView;
    }

    /* renamed from: Qw */
    public final View mo28382Qw(int i) {
        AppMethodBeat.m2504i(113109);
        ListView listView = this.mListView;
        View childAt = listView.getChildAt((listView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            AppMethodBeat.m2505o(113109);
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
        AppMethodBeat.m2505o(113109);
        return childAt;
    }

    /* renamed from: h */
    public void mo28384h(Point point) {
    }

    /* renamed from: fr */
    public final void mo28383fr(View view) {
        AppMethodBeat.m2504i(113110);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        }
        C5227ai.m7973i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", this.zWg.toString());
        this.zWg.recycle();
        this.zWg = null;
        AppMethodBeat.m2505o(113110);
    }
}

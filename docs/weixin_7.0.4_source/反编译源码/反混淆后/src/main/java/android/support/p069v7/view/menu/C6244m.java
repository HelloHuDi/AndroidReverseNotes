package android.support.p069v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.view.menu.m */
abstract class C6244m implements C0628o, C0632s, OnItemClickListener {
    Rect ach;

    /* renamed from: f */
    public abstract void mo14219f(C6236h c6236h);

    public abstract void setAnchorView(View view);

    public abstract void setForceShowIcon(boolean z);

    public abstract void setGravity(int i);

    public abstract void setHorizontalOffset(int i);

    public abstract void setOnDismissListener(OnDismissListener onDismissListener);

    public abstract void setShowTitle(boolean z);

    public abstract void setVerticalOffset(int i);

    C6244m() {
    }

    /* renamed from: a */
    public final void mo1598a(Context context, C6236h c6236h) {
    }

    /* renamed from: b */
    public final boolean mo1602b(C6239j c6239j) {
        return false;
    }

    /* renamed from: c */
    public final boolean mo1604c(C6239j c6239j) {
        return false;
    }

    public final int getId() {
        return 0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        C6244m.m10139a(listAdapter).abn.mo14116a((MenuItem) listAdapter.getItem(i), (C0628o) this, mo14220gq() ? 0 : 4);
    }

    /* renamed from: a */
    protected static int m10138a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i2, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= i) {
                return i;
            }
            if (itemViewType <= i4) {
                itemViewType = i4;
            }
            i2++;
            i4 = itemViewType;
        }
        return i4;
    }

    /* renamed from: a */
    protected static C0622g m10139a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (C0622g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (C0622g) listAdapter;
    }

    /* renamed from: h */
    protected static boolean m10140h(C6236h c6236h) {
        int size = c6236h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c6236h.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: gq */
    public boolean mo14220gq() {
        return true;
    }
}

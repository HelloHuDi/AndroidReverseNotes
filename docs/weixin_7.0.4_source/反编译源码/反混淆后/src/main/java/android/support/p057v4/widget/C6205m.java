package android.support.p057v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.m */
public final class C6205m extends C0521a {
    /* renamed from: QU */
    private final ListView f1794QU;

    public C6205m(ListView listView) {
        super(listView);
        this.f1794QU = listView;
    }

    /* renamed from: aN */
    public final void mo1280aN(int i) {
        ListView listView = this.f1794QU;
        if (VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }

    /* renamed from: aO */
    public final boolean mo1281aO(int i) {
        ListView listView = this.f1794QU;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}

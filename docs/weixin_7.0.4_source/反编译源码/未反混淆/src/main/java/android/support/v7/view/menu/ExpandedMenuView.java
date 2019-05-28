package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.h.b;
import android.support.v7.widget.bc;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements b, p, OnItemClickListener {
    private static final int[] aaV = new int[]{16842964, 16843049};
    private int aaW;
    private h lo;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        bc a = bc.a(context, attributeSet, aaV, i, 0);
        if (a.hasValue(0)) {
            setBackgroundDrawable(a.getDrawable(0));
        }
        if (a.hasValue(1)) {
            setDivider(a.getDrawable(1));
        }
        a.atG.recycle();
    }

    public final void a(h hVar) {
        this.lo = hVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final boolean f(j jVar) {
        return this.lo.a((MenuItem) jVar, null, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        f((j) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.aaW;
    }
}

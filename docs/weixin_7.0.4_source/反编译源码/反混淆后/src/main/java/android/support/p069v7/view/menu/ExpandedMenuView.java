package android.support.p069v7.view.menu;

import android.content.Context;
import android.support.p069v7.view.menu.C6236h.C0624b;
import android.support.p069v7.widget.C0699bc;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/* renamed from: android.support.v7.view.menu.ExpandedMenuView */
public final class ExpandedMenuView extends ListView implements C0624b, C0630p, OnItemClickListener {
    private static final int[] aaV = new int[]{16842964, 16843049};
    private int aaW;
    /* renamed from: lo */
    private C6236h f1884lo;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0699bc a = C0699bc.m1555a(context, attributeSet, aaV, i, 0);
        if (a.hasValue(0)) {
            setBackgroundDrawable(a.getDrawable(0));
        }
        if (a.hasValue(1)) {
            setDivider(a.getDrawable(1));
        }
        a.atG.recycle();
    }

    /* renamed from: a */
    public final void mo1612a(C6236h c6236h) {
        this.f1884lo = c6236h;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    /* renamed from: f */
    public final boolean mo1586f(C6239j c6239j) {
        return this.f1884lo.mo14116a((MenuItem) c6239j, null, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo1586f((C6239j) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.aaW;
    }
}

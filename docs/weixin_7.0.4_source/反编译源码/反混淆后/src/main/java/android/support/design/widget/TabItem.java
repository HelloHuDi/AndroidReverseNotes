package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.C37097a.C37096a;
import android.support.p069v7.widget.C0699bc;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
    final CharSequence mText;
    /* renamed from: rP */
    final Drawable f2209rP;
    /* renamed from: rQ */
    final int f2210rQ;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0699bc a = C0699bc.m1554a(context, attributeSet, C37096a.TabItem);
        this.mText = a.getText(2);
        this.f2209rP = a.getDrawable(0);
        this.f2210rQ = a.getResourceId(1, 0);
        a.atG.recycle();
    }
}

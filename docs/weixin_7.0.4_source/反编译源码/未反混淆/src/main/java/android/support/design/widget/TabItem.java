package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v7.widget.bc;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
    final CharSequence mText;
    final Drawable rP;
    final int rQ;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bc a = bc.a(context, attributeSet, a.TabItem);
        this.mText = a.getText(2);
        this.rP = a.getDrawable(0);
        this.rQ = a.getResourceId(1, 0);
        a.atG.recycle();
    }
}

package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AuthorizeItemListView extends ListView {
    public int afg;

    public AuthorizeItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AuthorizeItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(77513);
        if (this.afg <= 5) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, j.INVALID_ID));
            AppMethodBeat.o(77513);
            return;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(77513);
    }
}

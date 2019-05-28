package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.AuthorizeItemListView */
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
        AppMethodBeat.m2504i(77513);
        if (this.afg <= 5) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID));
            AppMethodBeat.m2505o(77513);
            return;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(77513);
    }
}

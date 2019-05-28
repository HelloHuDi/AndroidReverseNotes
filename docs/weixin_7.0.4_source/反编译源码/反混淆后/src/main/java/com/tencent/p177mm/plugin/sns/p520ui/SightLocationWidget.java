package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.p177mm.boot.C1319a.C1318a;

/* renamed from: com.tencent.mm.plugin.sns.ui.SightLocationWidget */
public class SightLocationWidget extends LocationWidget {
    public SightLocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightLocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public int getNormalStateImageResource() {
        return C1318a.sight_icon_location_normal;
    }

    /* Access modifiers changed, original: protected */
    public int getSelectedStateImageResource() {
        return C1318a.sight_icon_location_selected;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return 2130969948;
    }
}

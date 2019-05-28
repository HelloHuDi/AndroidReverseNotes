package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;

public class SightLocationWidget extends LocationWidget {
    public SightLocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightLocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public int getNormalStateImageResource() {
        return R.raw.sight_icon_location_normal;
    }

    /* Access modifiers changed, original: protected */
    public int getSelectedStateImageResource() {
        return R.raw.sight_icon_location_selected;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return R.layout.a__;
    }
}

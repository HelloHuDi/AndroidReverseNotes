package com.tencent.p177mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.header.RubbishView */
public abstract class RubbishView extends FrameLayout {
    public abstract void setHeaderContainer(HeaderContainer headerContainer);

    public RubbishView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RubbishView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

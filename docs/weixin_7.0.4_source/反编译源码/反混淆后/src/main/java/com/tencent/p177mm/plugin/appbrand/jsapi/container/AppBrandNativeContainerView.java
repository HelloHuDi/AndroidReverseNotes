package com.tencent.p177mm.plugin.appbrand.jsapi.container;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.C45592o;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView */
public class AppBrandNativeContainerView extends FrameLayout implements C45592o {
    public boolean hIN;

    public AppBrandNativeContainerView(Context context) {
        super(context);
    }

    public AppBrandNativeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandNativeContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setFullscreenWithChild(boolean z) {
        this.hIN = z;
    }
}

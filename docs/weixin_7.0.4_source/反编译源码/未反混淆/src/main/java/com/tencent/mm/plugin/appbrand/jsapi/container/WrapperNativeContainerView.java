package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;

public class WrapperNativeContainerView extends CoverViewContainer {
    public WrapperNativeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrapperNativeContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public WrapperNativeContainerView(Context context, View view) {
        super(context, view);
    }
}

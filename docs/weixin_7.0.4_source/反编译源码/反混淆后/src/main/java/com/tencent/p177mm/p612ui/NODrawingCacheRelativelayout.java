package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* renamed from: com.tencent.mm.ui.NODrawingCacheRelativelayout */
public class NODrawingCacheRelativelayout extends RelativeLayout {
    public NODrawingCacheRelativelayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NODrawingCacheRelativelayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }
}

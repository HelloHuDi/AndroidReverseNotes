package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

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

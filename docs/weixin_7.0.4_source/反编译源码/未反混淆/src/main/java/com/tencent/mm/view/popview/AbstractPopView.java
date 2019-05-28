package com.tencent.mm.view.popview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;

public abstract class AbstractPopView extends FrameLayout {
    public abstract void fw(View view);

    public abstract LayoutParams getWindowLayoutParams();

    public AbstractPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

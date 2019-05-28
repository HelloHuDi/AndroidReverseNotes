package com.tencent.p177mm.view.popview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;

/* renamed from: com.tencent.mm.view.popview.AbstractPopView */
public abstract class AbstractPopView extends FrameLayout {
    /* renamed from: fw */
    public abstract void mo49356fw(View view);

    public abstract LayoutParams getWindowLayoutParams();

    public AbstractPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

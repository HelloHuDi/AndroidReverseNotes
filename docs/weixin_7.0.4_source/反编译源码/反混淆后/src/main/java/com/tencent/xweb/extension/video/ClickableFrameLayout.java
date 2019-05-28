package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClickableFrameLayout extends FrameLayout {
    private GestureDetector iay;
    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(84558);
        super.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
        AppMethodBeat.m2505o(84558);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.iay = gestureDetector;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mOnClickListener != null;
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

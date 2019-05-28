package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.WrapScollview */
public class WrapScollview extends ScrollView {
    private View contentView;
    private boolean rEz = true;

    public WrapScollview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public WrapScollview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        AppMethodBeat.m2504i(39930);
        if (this.contentView != null) {
            View view = this.contentView;
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = view.getWidth() + i2;
            int i3 = iArr[1];
            int height = view.getHeight() + i3;
            if (((float) i2) >= rawX || rawX >= ((float) width) || ((float) i3) >= rawY || rawY >= ((float) height)) {
                i = 0;
            }
            if (i != 0) {
                AppMethodBeat.m2505o(39930);
                return false;
            }
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(39930);
        return onInterceptTouchEvent;
    }

    public void setDoComputeScrollDeltaToGetChildRectOnScreen(boolean z) {
        this.rEz = z;
    }

    /* Access modifiers changed, original: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        AppMethodBeat.m2504i(39931);
        if (this.rEz) {
            int computeScrollDeltaToGetChildRectOnScreen = super.computeScrollDeltaToGetChildRectOnScreen(rect);
            AppMethodBeat.m2505o(39931);
            return computeScrollDeltaToGetChildRectOnScreen;
        }
        AppMethodBeat.m2505o(39931);
        return 0;
    }
}

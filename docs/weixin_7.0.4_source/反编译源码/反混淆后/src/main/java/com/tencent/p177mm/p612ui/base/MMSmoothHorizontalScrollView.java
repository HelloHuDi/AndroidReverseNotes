package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.MMSmoothHorizontalScrollView */
public class MMSmoothHorizontalScrollView extends HorizontalScrollView {
    /* renamed from: mJ */
    private Interpolator f17244mJ = new DecelerateInterpolator();
    private float mLastMotionX;
    private Rect mRect = new Rect();
    private TranslateAnimation pCM;
    private View yxk;

    public MMSmoothHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106794);
        setFadingEdgeLength(0);
        AppMethodBeat.m2505o(106794);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(106795);
        if (getChildCount() > 0) {
            this.yxk = getChildAt(0);
        }
        AppMethodBeat.m2505o(106795);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.m2504i(106796);
        boolean onTouchEvent;
        if (this.yxk == null) {
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(106796);
            return onTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastMotionX = motionEvent.getX();
                break;
            case 1:
            case 3:
                this.mLastMotionX = 0.0f;
                if (this.mRect.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    this.pCM = new TranslateAnimation((float) this.yxk.getLeft(), (float) this.mRect.left, 0.0f, 0.0f);
                    this.pCM.setInterpolator(this.f17244mJ);
                    this.pCM.setDuration((long) Math.abs(this.yxk.getLeft() - this.mRect.left));
                    this.yxk.startAnimation(this.pCM);
                    this.yxk.layout(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
                    this.mRect.setEmpty();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX();
                if (this.mLastMotionX == 0.0f) {
                    this.mLastMotionX = x;
                }
                int i3 = ((int) (this.mLastMotionX - x)) / 2;
                scrollBy(i3, 0);
                this.mLastMotionX = x;
                int measuredWidth = this.yxk.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                int scrollX = getScrollX();
                if (scrollX == 0 || scrollX == measuredWidth) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    if (this.mRect.isEmpty()) {
                        this.mRect.set(this.yxk.getLeft(), this.yxk.getTop(), this.yxk.getRight(), this.yxk.getBottom());
                    }
                    this.yxk.layout(this.yxk.getLeft() - i3, this.yxk.getTop(), this.yxk.getRight() - i3, this.yxk.getBottom());
                    break;
                }
                break;
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(106796);
        return onTouchEvent;
    }
}

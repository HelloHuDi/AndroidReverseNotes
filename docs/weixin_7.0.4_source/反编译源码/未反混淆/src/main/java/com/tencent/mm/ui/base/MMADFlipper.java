package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMADFlipper extends ViewGroup {
    private View abB;
    private View kZq;
    private Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int yto;
    private Interpolator ytp;
    private int ytq;
    private int ytr;
    private boolean yts;
    private boolean ytt;
    private a ytu;

    public interface a {
    }

    public MMADFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMADFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106388);
        this.yto = 0;
        this.yts = false;
        this.ytt = true;
        this.mContext = context;
        this.ytp = getInterpolator();
        this.mScroller = new Scroller(this.mContext, this.ytp);
        this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
        AppMethodBeat.o(106388);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(106389);
        super.onFinishInflate();
        AppMethodBeat.o(106389);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106390);
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
        AppMethodBeat.o(106390);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106391);
        super.onMeasure(i, i2);
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
        AppMethodBeat.o(106391);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106393);
        if (getChildCount() == 1) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(106393);
            return onTouchEvent;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case 0:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = x;
                break;
            case 1:
            case 3:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000);
                action = (int) velocityTracker.getXVelocity();
                if (action > 600) {
                    if (dzC()) {
                        this.ytq--;
                        NB(this.ytq);
                    }
                    this.yts = true;
                } else if (action < -600) {
                    if (dzC()) {
                        this.ytq++;
                        NB(this.ytq);
                    }
                    this.yts = true;
                } else {
                    action = getWidth();
                    NB((getScrollX() + (action / 2)) / action);
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                this.yto = 0;
                this.mLastMotionX = 0.0f;
                this.mLastMotionY = 0.0f;
                break;
            case 2:
                action = (int) (this.mLastMotionX - x);
                this.mLastMotionX = x;
                scrollBy(action, 0);
                break;
        }
        AppMethodBeat.o(106393);
        return true;
    }

    private Interpolator getInterpolator() {
        AppMethodBeat.i(106394);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        AppMethodBeat.o(106394);
        return linearInterpolator;
    }

    public void setHeaderView(View view) {
        this.abB = view;
    }

    public void setFooterView(View view) {
        this.kZq = view;
    }

    public void setScrollEnable(boolean z) {
        this.ytt = z;
    }

    private boolean dzC() {
        AppMethodBeat.i(106395);
        if (getChildCount() > 1) {
            AppMethodBeat.o(106395);
            return true;
        }
        AppMethodBeat.o(106395);
        return false;
    }

    public int getRealChildCount() {
        AppMethodBeat.i(106396);
        int childCount;
        if (getChildCount() > 1) {
            childCount = getChildCount() - 2;
            AppMethodBeat.o(106396);
            return childCount;
        }
        childCount = getChildCount();
        AppMethodBeat.o(106396);
        return childCount;
    }

    public int getCurScreen() {
        return this.ytq;
    }

    public int getRealCurScreen() {
        AppMethodBeat.i(106397);
        int i;
        if (getChildCount() > 1) {
            i = this.ytq - 1;
            AppMethodBeat.o(106397);
            return i;
        }
        i = this.ytq;
        AppMethodBeat.o(106397);
        return i;
    }

    private void NB(int i) {
        AppMethodBeat.i(106398);
        NC(i);
        ab.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", Integer.valueOf(this.ytq), Integer.valueOf(this.ytr), Integer.valueOf(i));
        this.ytr = i;
        AppMethodBeat.o(106398);
    }

    private void NC(int i) {
        AppMethodBeat.i(106399);
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (max * getWidth()) - getScrollX();
            this.mScroller.startScroll(getScrollX(), 0, width, 0, com.tencent.mm.bz.a.ao(getContext(), Math.abs(width) * 2));
            invalidate();
        }
        AppMethodBeat.o(106399);
    }

    public void computeScroll() {
        AppMethodBeat.i(106400);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            AppMethodBeat.o(106400);
            return;
        }
        if (this.yts) {
            this.yts = false;
            if (this.ytq <= 0) {
                this.ytq = getRealChildCount();
                setScrollXOffest(this.ytq * getWidth());
                AppMethodBeat.o(106400);
                return;
            } else if (this.ytq >= getChildCount() - 1) {
                this.ytq = 1;
                setScrollXOffest(this.ytq * getWidth());
            }
        }
        AppMethodBeat.o(106400);
    }

    public void setOnScreenChangedListener(a aVar) {
        this.ytu = aVar;
    }

    @TargetApi(14)
    public void setScrollXOffest(int i) {
        AppMethodBeat.i(106401);
        if (VERSION.SDK_INT >= 14) {
            setScrollX(i);
            AppMethodBeat.o(106401);
            return;
        }
        if (this.mScroller != null) {
            this.mScroller.setFinalX(i);
        }
        AppMethodBeat.o(106401);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106392);
        boolean onInterceptTouchEvent;
        if (!this.ytt) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(106392);
            return onInterceptTouchEvent;
        } else if (getChildCount() == 1) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(106392);
            return onInterceptTouchEvent;
        } else {
            int action = motionEvent.getAction();
            if (action != 2 || this.yto == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                switch (action) {
                    case 0:
                        this.mLastMotionX = x;
                        this.mLastMotionY = y;
                        this.yto = this.mScroller.isFinished() ? 0 : 1;
                        break;
                    case 1:
                    case 3:
                        this.yto = 0;
                        break;
                    case 2:
                        boolean z;
                        action = (int) Math.abs(this.mLastMotionX - x);
                        int abs = (int) Math.abs(this.mLastMotionY - y);
                        if (action <= this.mTouchSlop || abs >= this.mTouchSlop) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            this.yto = 0;
                            break;
                        }
                        this.yto = 1;
                        break;
                        break;
                }
                if (this.yto != 0) {
                    AppMethodBeat.o(106392);
                    return true;
                }
                AppMethodBeat.o(106392);
                return false;
            }
            AppMethodBeat.o(106392);
            return true;
        }
    }
}

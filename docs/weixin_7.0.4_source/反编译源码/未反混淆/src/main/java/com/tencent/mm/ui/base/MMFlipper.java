package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class MMFlipper extends ViewGroup {
    private Interpolator mJ;
    private float mLastMotionX;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int yto;
    protected int ytq;
    protected int ytr;
    private boolean ytt;
    protected int yuc;
    private int yud;
    private boolean yue;
    private b yuf;
    private a yug;
    int yuh;
    int yui;

    public interface a {
        void fe(int i, int i2);
    }

    public interface b {
        void BZ(int i);
    }

    static class c implements Interpolator {
        private float pCO;

        public c() {
            this.pCO = 1.3f;
            this.pCO = 0.0f;
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (f2 * f2)) + 1.0f;
        }
    }

    public MMFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(106543);
        init(context);
        AppMethodBeat.o(106543);
    }

    public MMFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106544);
        this.yud = 0;
        this.yto = 0;
        this.yue = false;
        this.ytt = true;
        this.yuh = -123454321;
        this.yui = -123454321;
        init(context);
        AppMethodBeat.o(106544);
    }

    /* Access modifiers changed, original: protected */
    public Interpolator getInterpolator() {
        AppMethodBeat.i(106545);
        c cVar = new c();
        AppMethodBeat.o(106545);
        return cVar;
    }

    private void init(Context context) {
        AppMethodBeat.i(106546);
        this.mJ = getInterpolator();
        this.mScroller = new Scroller(context, this.mJ);
        this.ytr = -1;
        int i = this.yud;
        this.ytq = i;
        this.yuc = i;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        AppMethodBeat.o(106546);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106547);
        long yz = bo.yz();
        int i5 = 0;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                ab.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(measuredWidth)));
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
        ab.v("MicroMsg.MMFlipper", "use " + bo.az(yz) + " ms, flipper onLayout changed:" + z + " Left,Top,Right,Bottom:" + i + "," + i2 + "," + i3 + "," + i4);
        AppMethodBeat.o(106547);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106548);
        long yz = bo.yz();
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.yug != null) {
            this.yug.fe(size, size2);
        }
        this.yuh = size;
        this.yui = size2;
        int childCount = getChildCount();
        for (size2 = 0; size2 < childCount; size2++) {
            getChildAt(size2).measure(i, i2);
        }
        scrollTo(this.ytq * size, 0);
        ab.i("MicroMsg.MMFlipper", "flipper onMeasure:" + size + "," + MeasureSpec.getSize(i2) + " childCount:" + childCount + ", use " + bo.az(yz));
        AppMethodBeat.o(106548);
    }

    public void setOnMeasureListener(a aVar) {
        this.yug = aVar;
    }

    public void setOnScreenChangedListener(b bVar) {
        this.yuf = bVar;
    }

    private void NC(int i) {
        AppMethodBeat.i(106549);
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (getWidth() * max) - getScrollX();
            this.mScroller.startScroll(getScrollX(), 0, width, 0, com.tencent.mm.bz.a.ao(getContext(), (int) (((float) Math.abs(width)) * 1.3f)));
            if (this.ytq != max) {
                this.yue = true;
                this.yuc += max - this.ytq;
            }
            this.ytr = this.ytq;
            this.ytq = max;
            invalidate();
        }
        AppMethodBeat.o(106549);
    }

    public final void NF(int i) {
        AppMethodBeat.i(106550);
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.yue = false;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        this.ytr = this.ytq;
        this.ytq = max;
        scrollTo(max * getWidth(), 0);
        AppMethodBeat.o(106550);
    }

    public final void NG(int i) {
        this.yuc = i;
    }

    public void setToScreen(int i) {
        AppMethodBeat.i(106551);
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.yue = false;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        if (this.yuf != null) {
            this.yuf.BZ(max);
        }
        this.ytr = this.ytq;
        this.ytq = max;
        this.yuc = max;
        scrollTo(max * getWidth(), 0);
        AppMethodBeat.o(106551);
    }

    public int getCurScreen() {
        AppMethodBeat.i(106552);
        ab.d("MicroMsg.MMFlipper", "cur screen is %d", Integer.valueOf(this.ytq));
        int i = this.ytq;
        AppMethodBeat.o(106552);
        return i;
    }

    public void computeScroll() {
        AppMethodBeat.i(106553);
        this.mScroller.getCurrX();
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            AppMethodBeat.o(106553);
            return;
        }
        if (this.yue) {
            this.yue = false;
            if (this.yuf != null) {
                this.yuf.BZ(this.yuc);
            }
        }
        AppMethodBeat.o(106553);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106554);
        if (getChildCount() == 1) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(106554);
            return onTouchEvent;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        motionEvent.getY();
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
                if (action > 600 && this.ytq > 0) {
                    NC(this.ytq - 1);
                } else if (action >= -600 || this.ytq >= getChildCount() - 1) {
                    action = getWidth();
                    NC((getScrollX() + (action / 2)) / action);
                } else {
                    NC(this.ytq + 1);
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
        AppMethodBeat.o(106554);
        return true;
    }

    public void setScrollEnable(boolean z) {
        this.ytt = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106555);
        boolean onInterceptTouchEvent;
        if (!this.ytt) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(106555);
            return onInterceptTouchEvent;
        } else if (getChildCount() == 1) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(106555);
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
                        ab.v("MicroMsg.MMFlipper", "xDif = " + action + ", yDif = " + abs);
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
                }
                if (this.yto != 0) {
                    AppMethodBeat.o(106555);
                    return true;
                }
                AppMethodBeat.o(106555);
                return false;
            }
            AppMethodBeat.o(106555);
            return true;
        }
    }
}

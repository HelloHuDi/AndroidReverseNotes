package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.base.MMFlipper */
public class MMFlipper extends ViewGroup {
    /* renamed from: mJ */
    private Interpolator f13738mJ;
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
    private C5251b yuf;
    private C5250a yug;
    int yuh;
    int yui;

    /* renamed from: com.tencent.mm.ui.base.MMFlipper$a */
    public interface C5250a {
        /* renamed from: fe */
        void mo10769fe(int i, int i2);
    }

    /* renamed from: com.tencent.mm.ui.base.MMFlipper$b */
    public interface C5251b {
        /* renamed from: BZ */
        void mo10770BZ(int i);
    }

    /* renamed from: com.tencent.mm.ui.base.MMFlipper$c */
    static class C30367c implements Interpolator {
        private float pCO;

        public C30367c() {
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
        AppMethodBeat.m2504i(106543);
        init(context);
        AppMethodBeat.m2505o(106543);
    }

    public MMFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106544);
        this.yud = 0;
        this.yto = 0;
        this.yue = false;
        this.ytt = true;
        this.yuh = -123454321;
        this.yui = -123454321;
        init(context);
        AppMethodBeat.m2505o(106544);
    }

    /* Access modifiers changed, original: protected */
    public Interpolator getInterpolator() {
        AppMethodBeat.m2504i(106545);
        C30367c c30367c = new C30367c();
        AppMethodBeat.m2505o(106545);
        return c30367c;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(106546);
        this.f13738mJ = getInterpolator();
        this.mScroller = new Scroller(context, this.f13738mJ);
        this.ytr = -1;
        int i = this.yud;
        this.ytq = i;
        this.yuc = i;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        AppMethodBeat.m2505o(106546);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106547);
        long yz = C5046bo.m7588yz();
        int i5 = 0;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                C4990ab.m7418v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(measuredWidth)));
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
        C4990ab.m7418v("MicroMsg.MMFlipper", "use " + C5046bo.m7525az(yz) + " ms, flipper onLayout changed:" + z + " Left,Top,Right,Bottom:" + i + "," + i2 + "," + i3 + "," + i4);
        AppMethodBeat.m2505o(106547);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106548);
        long yz = C5046bo.m7588yz();
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.yug != null) {
            this.yug.mo10769fe(size, size2);
        }
        this.yuh = size;
        this.yui = size2;
        int childCount = getChildCount();
        for (size2 = 0; size2 < childCount; size2++) {
            getChildAt(size2).measure(i, i2);
        }
        scrollTo(this.ytq * size, 0);
        C4990ab.m7416i("MicroMsg.MMFlipper", "flipper onMeasure:" + size + "," + MeasureSpec.getSize(i2) + " childCount:" + childCount + ", use " + C5046bo.m7525az(yz));
        AppMethodBeat.m2505o(106548);
    }

    public void setOnMeasureListener(C5250a c5250a) {
        this.yug = c5250a;
    }

    public void setOnScreenChangedListener(C5251b c5251b) {
        this.yuf = c5251b;
    }

    /* renamed from: NC */
    private void m48390NC(int i) {
        AppMethodBeat.m2504i(106549);
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (getWidth() * max) - getScrollX();
            this.mScroller.startScroll(getScrollX(), 0, width, 0, C1338a.m2859ao(getContext(), (int) (((float) Math.abs(width)) * 1.3f)));
            if (this.ytq != max) {
                this.yue = true;
                this.yuc += max - this.ytq;
            }
            this.ytr = this.ytq;
            this.ytq = max;
            invalidate();
        }
        AppMethodBeat.m2505o(106549);
    }

    /* renamed from: NF */
    public final void mo48692NF(int i) {
        AppMethodBeat.m2504i(106550);
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.yue = false;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        this.ytr = this.ytq;
        this.ytq = max;
        scrollTo(max * getWidth(), 0);
        AppMethodBeat.m2505o(106550);
    }

    /* renamed from: NG */
    public final void mo48693NG(int i) {
        this.yuc = i;
    }

    public void setToScreen(int i) {
        AppMethodBeat.m2504i(106551);
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.yue = false;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        if (this.yuf != null) {
            this.yuf.mo10770BZ(max);
        }
        this.ytr = this.ytq;
        this.ytq = max;
        this.yuc = max;
        scrollTo(max * getWidth(), 0);
        AppMethodBeat.m2505o(106551);
    }

    public int getCurScreen() {
        AppMethodBeat.m2504i(106552);
        C4990ab.m7411d("MicroMsg.MMFlipper", "cur screen is %d", Integer.valueOf(this.ytq));
        int i = this.ytq;
        AppMethodBeat.m2505o(106552);
        return i;
    }

    public void computeScroll() {
        AppMethodBeat.m2504i(106553);
        this.mScroller.getCurrX();
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            AppMethodBeat.m2505o(106553);
            return;
        }
        if (this.yue) {
            this.yue = false;
            if (this.yuf != null) {
                this.yuf.mo10770BZ(this.yuc);
            }
        }
        AppMethodBeat.m2505o(106553);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106554);
        if (getChildCount() == 1) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(106554);
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
                    m48390NC(this.ytq - 1);
                } else if (action >= -600 || this.ytq >= getChildCount() - 1) {
                    action = getWidth();
                    m48390NC((getScrollX() + (action / 2)) / action);
                } else {
                    m48390NC(this.ytq + 1);
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
        AppMethodBeat.m2505o(106554);
        return true;
    }

    public void setScrollEnable(boolean z) {
        this.ytt = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106555);
        boolean onInterceptTouchEvent;
        if (!this.ytt) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(106555);
            return onInterceptTouchEvent;
        } else if (getChildCount() == 1) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(106555);
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
                        C4990ab.m7418v("MicroMsg.MMFlipper", "xDif = " + action + ", yDif = " + abs);
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
                    AppMethodBeat.m2505o(106555);
                    return true;
                }
                AppMethodBeat.m2505o(106555);
                return false;
            }
            AppMethodBeat.m2505o(106555);
            return true;
        }
    }
}

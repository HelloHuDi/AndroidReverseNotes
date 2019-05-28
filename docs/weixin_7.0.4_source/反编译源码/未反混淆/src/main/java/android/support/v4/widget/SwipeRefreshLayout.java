package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.i;
import android.support.v4.view.k;
import android.support.v4.view.l;
import android.support.v4.view.n;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

public class SwipeRefreshLayout extends ViewGroup implements i, l {
    private static final int[] LAYOUT_ATTRS = new int[]{16842766};
    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    private View Ov;
    b RS;
    boolean RT = false;
    private float RU = -1.0f;
    private float RV;
    private final k RW;
    private final int[] RX = new int[2];
    private final int[] RY = new int[2];
    private boolean RZ;
    private int Sa;
    int Sb;
    private float Sc;
    boolean Sd;
    private boolean Se;
    private final DecelerateInterpolator Sf;
    c Sg;
    private int Sh = -1;
    float Si;
    protected int Sj;
    int Sk;
    d Sl;
    private Animation Sm;
    private Animation Sn;
    private Animation So;
    private Animation Sp;
    private Animation Sq;
    boolean Sr;
    private int Ss;
    boolean St;
    private a Su;
    private AnimationListener Sv = new AnimationListener() {
        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (SwipeRefreshLayout.this.RT) {
                SwipeRefreshLayout.this.Sl.setAlpha(255);
                SwipeRefreshLayout.this.Sl.start();
                SwipeRefreshLayout.this.Sb = SwipeRefreshLayout.this.Sg.getTop();
                return;
            }
            SwipeRefreshLayout.this.reset();
        }
    };
    private final Animation Sw = new Animation() {
        public final void applyTransformation(float f, Transformation transformation) {
            int i;
            if (SwipeRefreshLayout.this.St) {
                i = SwipeRefreshLayout.this.Sk;
            } else {
                i = SwipeRefreshLayout.this.Sk - Math.abs(SwipeRefreshLayout.this.Sj);
            }
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((((int) (((float) (i - SwipeRefreshLayout.this.mFrom)) * f)) + SwipeRefreshLayout.this.mFrom) - SwipeRefreshLayout.this.Sg.getTop());
            SwipeRefreshLayout.this.Sl.B(1.0f - f);
        }
    };
    private final Animation Sx = new Animation() {
        public final void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.L(f);
        }
    };
    private int mActivePointerId = -1;
    protected int mFrom;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private int mTouchSlop;
    private final n pF;

    public interface a {
        boolean eW();
    }

    public interface b {
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        this.Sg.clearAnimation();
        this.Sl.stop();
        this.Sg.setVisibility(8);
        setColorViewAlpha(255);
        if (this.Sd) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.Sj - this.Sb);
        }
        this.Sb = this.Sg.getTop();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void setColorViewAlpha(int i) {
        this.Sg.getBackground().setAlpha(i);
        this.Sl.setAlpha(i);
    }

    public int getProgressViewStartOffset() {
        return this.Sj;
    }

    public int getProgressViewEndOffset() {
        return this.Sk;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.Ss = (int) (displayMetrics.density * 56.0f);
            } else {
                this.Ss = (int) (displayMetrics.density * 40.0f);
            }
            this.Sg.setImageDrawable(null);
            this.Sl.aQ(i);
            this.Sg.setImageDrawable(this.Sl);
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.Sa = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.Sf = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.Ss = (int) (40.0f * displayMetrics.density);
        this.Sg = new c(getContext());
        this.Sl = new d(getContext());
        this.Sl.aQ(1);
        this.Sg.setImageDrawable(this.Sl);
        this.Sg.setVisibility(8);
        addView(this.Sg);
        setChildrenDrawingOrderEnabled(true);
        this.Sk = (int) (displayMetrics.density * 64.0f);
        this.RU = (float) this.Sk;
        this.pF = new n(this);
        this.RW = new k(this);
        setNestedScrollingEnabled(true);
        int i = -this.Ss;
        this.Sb = i;
        this.Sj = i;
        L(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* Access modifiers changed, original: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.Sh < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.Sh;
        }
        if (i2 >= this.Sh) {
            return i2 + 1;
        }
        return i2;
    }

    public void setOnRefreshListener(b bVar) {
        this.RS = bVar;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.RT == z) {
            f(z, false);
            return;
        }
        int i;
        this.RT = z;
        if (this.St) {
            i = this.Sk;
        } else {
            i = this.Sk + this.Sj;
        }
        setTargetOffsetTopAndBottom(i - this.Sb);
        this.Sr = false;
        AnimationListener animationListener = this.Sv;
        this.Sg.setVisibility(0);
        this.Sl.setAlpha(255);
        this.Sm = new Animation() {
            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.Sm.setDuration((long) this.Sa);
        if (animationListener != null) {
            this.Sg.OW = animationListener;
        }
        this.Sg.clearAnimation();
        this.Sg.startAnimation(this.Sm);
    }

    /* Access modifiers changed, original: 0000 */
    public void setAnimationProgress(float f) {
        this.Sg.setScaleX(f);
        this.Sg.setScaleY(f);
    }

    private void f(boolean z, boolean z2) {
        if (this.RT != z) {
            this.Sr = z2;
            eU();
            this.RT = z;
            if (this.RT) {
                a(this.Sb, this.Sv);
            } else {
                a(this.Sv);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(AnimationListener animationListener) {
        this.Sn = new Animation() {
            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.Sn.setDuration(150);
        this.Sg.OW = animationListener;
        this.Sg.clearAnimation();
        this.Sg.startAnimation(this.Sn);
    }

    private void eS() {
        this.So = C(this.Sl.getAlpha(), 76);
    }

    private void eT() {
        this.Sp = C(this.Sl.getAlpha(), 255);
    }

    private Animation C(final int i, final int i2) {
        AnonymousClass4 anonymousClass4 = new Animation() {
            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.Sl.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        anonymousClass4.setDuration(300);
        this.Sg.OW = null;
        this.Sg.clearAnimation();
        this.Sg.startAnimation(anonymousClass4);
        return anonymousClass4;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(android.support.v4.content.b.i(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.Sg.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = android.support.v4.content.b.i(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        eU();
        d dVar = this.Sl;
        dVar.Pd.setColors(iArr);
        dVar.Pd.aR(0);
        dVar.invalidateSelf();
    }

    private void eU() {
        if (this.Ov == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.Sg)) {
                    i++;
                } else {
                    this.Ov = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.RU = (float) i;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.Ov == null) {
                eU();
            }
            if (this.Ov != null) {
                View view = this.Ov;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.Sg.getMeasuredWidth();
                this.Sg.layout((measuredWidth / 2) - (measuredHeight / 2), this.Sb, (measuredWidth / 2) + (measuredHeight / 2), this.Sb + this.Sg.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Ov == null) {
            eU();
        }
        if (this.Ov != null) {
            this.Ov.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), ErrorDialogData.SUPPRESSED));
            this.Sg.measure(MeasureSpec.makeMeasureSpec(this.Ss, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(this.Ss, ErrorDialogData.SUPPRESSED));
            this.Sh = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.Sg) {
                    this.Sh = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.Ss;
    }

    private boolean eV() {
        if (this.Su != null) {
            return this.Su.eW();
        }
        if (!(this.Ov instanceof ListView)) {
            return this.Ov.canScrollVertically(-1);
        }
        ListView listView = (ListView) this.Ov;
        if (VERSION.SDK_INT >= 19) {
            return listView.canScrollList(-1);
        }
        if (listView.getChildCount() != 0) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int top = listView.getChildAt(0).getTop();
            if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
                return true;
            }
        }
        return false;
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.Su = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        eU();
        int actionMasked = motionEvent.getActionMasked();
        if (this.Se && actionMasked == 0) {
            this.Se = false;
        }
        if (!isEnabled() || this.Se || eV() || this.RT || this.RZ) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                setTargetOffsetTopAndBottom(this.Sj - this.Sg.getTop());
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                if (actionMasked >= 0) {
                    this.Sc = motionEvent.getY(actionMasked);
                    break;
                }
                return false;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (this.mActivePointerId == -1) {
                    return false;
                }
                actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                if (actionMasked >= 0) {
                    K(motionEvent.getY(actionMasked));
                    break;
                }
                return false;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.Ov instanceof AbsListView)) {
            return;
        }
        if (this.Ov == null || s.aq(this.Ov)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.Se || this.RT || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.pF.Ms = i;
        startNestedScroll(i & 2);
        this.RV = 0.0f;
        this.RZ = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.RV > 0.0f) {
            if (((float) i2) > this.RV) {
                iArr[1] = i2 - ((int) this.RV);
                this.RV = 0.0f;
            } else {
                this.RV -= (float) i2;
                iArr[1] = i2;
            }
            I(this.RV);
        }
        if (this.St && i2 > 0 && this.RV == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.Sg.setVisibility(8);
        }
        int[] iArr2 = this.RX;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.pF.Ms;
    }

    public void onStopNestedScroll(View view) {
        this.pF.Ms = 0;
        this.RZ = false;
        if (this.RV > 0.0f) {
            J(this.RV);
            this.RV = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.RY);
        int i5 = this.RY[1] + i4;
        if (i5 < 0 && !eV()) {
            this.RV = ((float) Math.abs(i5)) + this.RV;
            I(this.RV);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.RW.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.RW.Mp;
    }

    public boolean startNestedScroll(int i) {
        return this.RW.w(i, 0);
    }

    public void stopNestedScroll() {
        this.RW.aJ(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.RW.aI(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.RW.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.RW.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.RW.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.RW.dispatchNestedPreFling(f, f2);
    }

    private static boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void I(float f) {
        float f2;
        this.Sl.H(true);
        float min = Math.min(1.0f, Math.abs(f / this.RU));
        float max = (Math.max((float) (((double) min) - 0.4d), 0.0f) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.RU;
        if (this.St) {
            f2 = (float) (this.Sk - this.Sj);
        } else {
            f2 = (float) this.Sk;
        }
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.Sj;
        if (this.Sg.getVisibility() != 0) {
            this.Sg.setVisibility(0);
        }
        if (!this.Sd) {
            this.Sg.setScaleX(1.0f);
            this.Sg.setScaleY(1.0f);
        }
        if (this.Sd) {
            setAnimationProgress(Math.min(1.0f, f / this.RU));
        }
        if (f < this.RU) {
            if (this.Sl.getAlpha() > 76 && !a(this.So)) {
                eS();
            }
        } else if (this.Sl.getAlpha() < 255 && !a(this.Sp)) {
            eT();
        }
        this.Sl.C(Math.min(0.8f, max * 0.8f));
        this.Sl.B(Math.min(1.0f, max));
        this.Sl.D(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.Sb);
    }

    private void J(float f) {
        if (f > this.RU) {
            f(true, true);
            return;
        }
        this.RT = false;
        this.Sl.C(0.0f);
        AnimationListener animationListener = null;
        if (!this.Sd) {
            animationListener = new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.Sd) {
                        SwipeRefreshLayout.this.a(null);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            };
        }
        b(this.Sb, animationListener);
        this.Sl.H(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.Se && actionMasked == 0) {
            this.Se = false;
        }
        if (!isEnabled() || this.Se || eV() || this.RT || this.RZ) {
            return false;
        }
        float y;
        switch (actionMasked) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                break;
            case 1:
                actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                if (actionMasked < 0) {
                    return false;
                }
                if (this.mIsBeingDragged) {
                    y = (motionEvent.getY(actionMasked) - this.mInitialMotionY) * 0.5f;
                    this.mIsBeingDragged = false;
                    J(y);
                }
                this.mActivePointerId = -1;
                return false;
            case 2:
                actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                if (actionMasked < 0) {
                    return false;
                }
                y = motionEvent.getY(actionMasked);
                K(y);
                if (this.mIsBeingDragged) {
                    y = (y - this.mInitialMotionY) * 0.5f;
                    if (y > 0.0f) {
                        I(y);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                actionMasked = motionEvent.getActionIndex();
                if (actionMasked >= 0) {
                    this.mActivePointerId = motionEvent.getPointerId(actionMasked);
                    break;
                }
                return false;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return true;
    }

    private void K(float f) {
        if (f - this.Sc > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.Sc + ((float) this.mTouchSlop);
            this.mIsBeingDragged = true;
            this.Sl.setAlpha(76);
        }
    }

    private void a(int i, AnimationListener animationListener) {
        this.mFrom = i;
        this.Sw.reset();
        this.Sw.setDuration(200);
        this.Sw.setInterpolator(this.Sf);
        if (animationListener != null) {
            this.Sg.OW = animationListener;
        }
        this.Sg.clearAnimation();
        this.Sg.startAnimation(this.Sw);
    }

    private void b(int i, AnimationListener animationListener) {
        if (this.Sd) {
            c(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.Sx.reset();
        this.Sx.setDuration(200);
        this.Sx.setInterpolator(this.Sf);
        if (animationListener != null) {
            this.Sg.OW = animationListener;
        }
        this.Sg.clearAnimation();
        this.Sg.startAnimation(this.Sx);
    }

    /* Access modifiers changed, original: final */
    public final void L(float f) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) (((float) (this.Sj - this.mFrom)) * f))) - this.Sg.getTop());
    }

    private void c(int i, AnimationListener animationListener) {
        this.mFrom = i;
        this.Si = this.Sg.getScaleX();
        this.Sq = new Animation() {
            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.Si + ((-SwipeRefreshLayout.this.Si) * f));
                SwipeRefreshLayout.this.L(f);
            }
        };
        this.Sq.setDuration(150);
        if (animationListener != null) {
            this.Sg.OW = animationListener;
        }
        this.Sg.clearAnimation();
        this.Sg.startAnimation(this.Sq);
    }

    /* Access modifiers changed, original: 0000 */
    public void setTargetOffsetTopAndBottom(int i) {
        this.Sg.bringToFront();
        s.q(this.Sg, i);
        this.Sb = this.Sg.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}

package android.support.p057v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.view.C0468i;
import android.support.p057v4.view.C0469k;
import android.support.p057v4.view.C0470l;
import android.support.p057v4.view.C0471n;
import android.support.p057v4.view.C0477s;
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

/* renamed from: android.support.v4.widget.SwipeRefreshLayout */
public class SwipeRefreshLayout extends ViewGroup implements C0468i, C0470l {
    private static final int[] LAYOUT_ATTRS = new int[]{16842766};
    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    /* renamed from: Ov */
    private View f3950Ov;
    /* renamed from: RS */
    C17462b f3951RS;
    /* renamed from: RT */
    boolean f3952RT = false;
    /* renamed from: RU */
    private float f3953RU = -1.0f;
    /* renamed from: RV */
    private float f3954RV;
    /* renamed from: RW */
    private final C0469k f3955RW;
    /* renamed from: RX */
    private final int[] f3956RX = new int[2];
    /* renamed from: RY */
    private final int[] f3957RY = new int[2];
    /* renamed from: RZ */
    private boolean f3958RZ;
    /* renamed from: Sa */
    private int f3959Sa;
    /* renamed from: Sb */
    int f3960Sb;
    /* renamed from: Sc */
    private float f3961Sc;
    /* renamed from: Sd */
    boolean f3962Sd;
    /* renamed from: Se */
    private boolean f3963Se;
    /* renamed from: Sf */
    private final DecelerateInterpolator f3964Sf;
    /* renamed from: Sg */
    C37133c f3965Sg;
    /* renamed from: Sh */
    private int f3966Sh = -1;
    /* renamed from: Si */
    float f3967Si;
    /* renamed from: Sj */
    protected int f3968Sj;
    /* renamed from: Sk */
    int f3969Sk;
    /* renamed from: Sl */
    C44963d f3970Sl;
    /* renamed from: Sm */
    private Animation f3971Sm;
    /* renamed from: Sn */
    private Animation f3972Sn;
    /* renamed from: So */
    private Animation f3973So;
    /* renamed from: Sp */
    private Animation f3974Sp;
    /* renamed from: Sq */
    private Animation f3975Sq;
    /* renamed from: Sr */
    boolean f3976Sr;
    /* renamed from: Ss */
    private int f3977Ss;
    /* renamed from: St */
    boolean f3978St;
    /* renamed from: Su */
    private C17460a f3979Su;
    /* renamed from: Sv */
    private AnimationListener f3980Sv = new C174631();
    /* renamed from: Sw */
    private final Animation f3981Sw = new C174586();
    /* renamed from: Sx */
    private final Animation f3982Sx = new C174617();
    private int mActivePointerId = -1;
    protected int mFrom;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private int mTouchSlop;
    /* renamed from: pF */
    private final C0471n f3983pF;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$2 */
    class C84132 extends Animation {
        C84132() {
        }

        public final void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$3 */
    class C174563 extends Animation {
        C174563() {
        }

        public final void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$5 */
    class C174575 implements AnimationListener {
        C174575() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (!SwipeRefreshLayout.this.f3962Sd) {
                SwipeRefreshLayout.this.mo31753a(null);
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$6 */
    class C174586 extends Animation {
        C174586() {
        }

        public final void applyTransformation(float f, Transformation transformation) {
            int i;
            if (SwipeRefreshLayout.this.f3978St) {
                i = SwipeRefreshLayout.this.f3969Sk;
            } else {
                i = SwipeRefreshLayout.this.f3969Sk - Math.abs(SwipeRefreshLayout.this.f3968Sj);
            }
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((((int) (((float) (i - SwipeRefreshLayout.this.mFrom)) * f)) + SwipeRefreshLayout.this.mFrom) - SwipeRefreshLayout.this.f3965Sg.getTop());
            SwipeRefreshLayout.this.f3970Sl.mo72178B(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$8 */
    class C174598 extends Animation {
        C174598() {
        }

        public final void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f3967Si + ((-SwipeRefreshLayout.this.f3967Si) * f));
            SwipeRefreshLayout.this.mo31752L(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$a */
    public interface C17460a {
        /* renamed from: eW */
        boolean mo31793eW();
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$7 */
    class C174617 extends Animation {
        C174617() {
        }

        public final void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.mo31752L(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$b */
    public interface C17462b {
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$1 */
    class C174631 implements AnimationListener {
        C174631() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (SwipeRefreshLayout.this.f3952RT) {
                SwipeRefreshLayout.this.f3970Sl.setAlpha(255);
                SwipeRefreshLayout.this.f3970Sl.start();
                SwipeRefreshLayout.this.f3960Sb = SwipeRefreshLayout.this.f3965Sg.getTop();
                return;
            }
            SwipeRefreshLayout.this.reset();
        }
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        this.f3965Sg.clearAnimation();
        this.f3970Sl.stop();
        this.f3965Sg.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f3962Sd) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f3968Sj - this.f3960Sb);
        }
        this.f3960Sb = this.f3965Sg.getTop();
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
        this.f3965Sg.getBackground().setAlpha(i);
        this.f3970Sl.setAlpha(i);
    }

    public int getProgressViewStartOffset() {
        return this.f3968Sj;
    }

    public int getProgressViewEndOffset() {
        return this.f3969Sk;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f3977Ss = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f3977Ss = (int) (displayMetrics.density * 40.0f);
            }
            this.f3965Sg.setImageDrawable(null);
            this.f3970Sl.mo72182aQ(i);
            this.f3965Sg.setImageDrawable(this.f3970Sl);
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3959Sa = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f3964Sf = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3977Ss = (int) (40.0f * displayMetrics.density);
        this.f3965Sg = new C37133c(getContext());
        this.f3970Sl = new C44963d(getContext());
        this.f3970Sl.mo72182aQ(1);
        this.f3965Sg.setImageDrawable(this.f3970Sl);
        this.f3965Sg.setVisibility(8);
        addView(this.f3965Sg);
        setChildrenDrawingOrderEnabled(true);
        this.f3969Sk = (int) (displayMetrics.density * 64.0f);
        this.f3953RU = (float) this.f3969Sk;
        this.f3983pF = new C0471n(this);
        this.f3955RW = new C0469k(this);
        setNestedScrollingEnabled(true);
        int i = -this.f3977Ss;
        this.f3960Sb = i;
        this.f3968Sj = i;
        mo31752L(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* Access modifiers changed, original: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f3966Sh < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f3966Sh;
        }
        if (i2 >= this.f3966Sh) {
            return i2 + 1;
        }
        return i2;
    }

    public void setOnRefreshListener(C17462b c17462b) {
        this.f3951RS = c17462b;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f3952RT == z) {
            m27102f(z, false);
            return;
        }
        int i;
        this.f3952RT = z;
        if (this.f3978St) {
            i = this.f3969Sk;
        } else {
            i = this.f3969Sk + this.f3968Sj;
        }
        setTargetOffsetTopAndBottom(i - this.f3960Sb);
        this.f3976Sr = false;
        AnimationListener animationListener = this.f3980Sv;
        this.f3965Sg.setVisibility(0);
        this.f3970Sl.setAlpha(255);
        this.f3971Sm = new C84132();
        this.f3971Sm.setDuration((long) this.f3959Sa);
        if (animationListener != null) {
            this.f3965Sg.f15805OW = animationListener;
        }
        this.f3965Sg.clearAnimation();
        this.f3965Sg.startAnimation(this.f3971Sm);
    }

    /* Access modifiers changed, original: 0000 */
    public void setAnimationProgress(float f) {
        this.f3965Sg.setScaleX(f);
        this.f3965Sg.setScaleY(f);
    }

    /* renamed from: f */
    private void m27102f(boolean z, boolean z2) {
        if (this.f3952RT != z) {
            this.f3976Sr = z2;
            m27100eU();
            this.f3952RT = z;
            if (this.f3952RT) {
                m27094a(this.f3960Sb, this.f3980Sv);
            } else {
                mo31753a(this.f3980Sv);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31753a(AnimationListener animationListener) {
        this.f3972Sn = new C174563();
        this.f3972Sn.setDuration(150);
        this.f3965Sg.f15805OW = animationListener;
        this.f3965Sg.clearAnimation();
        this.f3965Sg.startAnimation(this.f3972Sn);
    }

    /* renamed from: eS */
    private void m27098eS() {
        this.f3973So = m27090C(this.f3970Sl.getAlpha(), 76);
    }

    /* renamed from: eT */
    private void m27099eT() {
        this.f3974Sp = m27090C(this.f3970Sl.getAlpha(), 255);
    }

    /* renamed from: C */
    private Animation m27090C(final int i, final int i2) {
        C84144 c84144 = new Animation() {
            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.f3970Sl.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        c84144.setDuration(300);
        this.f3965Sg.f15805OW = null;
        this.f3965Sg.clearAnimation();
        this.f3965Sg.startAnimation(c84144);
        return c84144;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(C0380b.m652i(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f3965Sg.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = C0380b.m652i(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m27100eU();
        C44963d c44963d = this.f3970Sl;
        c44963d.f17702Pd.setColors(iArr);
        c44963d.f17702Pd.mo59194aR(0);
        c44963d.invalidateSelf();
    }

    /* renamed from: eU */
    private void m27100eU() {
        if (this.f3950Ov == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f3965Sg)) {
                    i++;
                } else {
                    this.f3950Ov = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f3953RU = (float) i;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f3950Ov == null) {
                m27100eU();
            }
            if (this.f3950Ov != null) {
                View view = this.f3950Ov;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f3965Sg.getMeasuredWidth();
                this.f3965Sg.layout((measuredWidth / 2) - (measuredHeight / 2), this.f3960Sb, (measuredWidth / 2) + (measuredHeight / 2), this.f3960Sb + this.f3965Sg.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3950Ov == null) {
            m27100eU();
        }
        if (this.f3950Ov != null) {
            this.f3950Ov.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), ErrorDialogData.SUPPRESSED));
            this.f3965Sg.measure(MeasureSpec.makeMeasureSpec(this.f3977Ss, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(this.f3977Ss, ErrorDialogData.SUPPRESSED));
            this.f3966Sh = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f3965Sg) {
                    this.f3966Sh = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f3977Ss;
    }

    /* renamed from: eV */
    private boolean m27101eV() {
        if (this.f3979Su != null) {
            return this.f3979Su.mo31793eW();
        }
        if (!(this.f3950Ov instanceof ListView)) {
            return this.f3950Ov.canScrollVertically(-1);
        }
        ListView listView = (ListView) this.f3950Ov;
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

    public void setOnChildScrollUpCallback(C17460a c17460a) {
        this.f3979Su = c17460a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m27100eU();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3963Se && actionMasked == 0) {
            this.f3963Se = false;
        }
        if (!isEnabled() || this.f3963Se || m27101eV() || this.f3952RT || this.f3958RZ) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                setTargetOffsetTopAndBottom(this.f3968Sj - this.f3965Sg.getTop());
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                if (actionMasked >= 0) {
                    this.f3961Sc = motionEvent.getY(actionMasked);
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
                    m27093K(motionEvent.getY(actionMasked));
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
        if (VERSION.SDK_INT < 21 && (this.f3950Ov instanceof AbsListView)) {
            return;
        }
        if (this.f3950Ov == null || C0477s.m925aq(this.f3950Ov)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f3963Se || this.f3952RT || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3983pF.f565Ms = i;
        startNestedScroll(i & 2);
        this.f3954RV = 0.0f;
        this.f3958RZ = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f3954RV > 0.0f) {
            if (((float) i2) > this.f3954RV) {
                iArr[1] = i2 - ((int) this.f3954RV);
                this.f3954RV = 0.0f;
            } else {
                this.f3954RV -= (float) i2;
                iArr[1] = i2;
            }
            m27091I(this.f3954RV);
        }
        if (this.f3978St && i2 > 0 && this.f3954RV == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f3965Sg.setVisibility(8);
        }
        int[] iArr2 = this.f3956RX;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f3983pF.f565Ms;
    }

    public void onStopNestedScroll(View view) {
        this.f3983pF.f565Ms = 0;
        this.f3958RZ = false;
        if (this.f3954RV > 0.0f) {
            m27092J(this.f3954RV);
            this.f3954RV = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f3957RY);
        int i5 = this.f3957RY[1] + i4;
        if (i5 < 0 && !m27101eV()) {
            this.f3954RV = ((float) Math.abs(i5)) + this.f3954RV;
            m27091I(this.f3954RV);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f3955RW.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f3955RW.f562Mp;
    }

    public boolean startNestedScroll(int i) {
        return this.f3955RW.mo1075w(i, 0);
    }

    public void stopNestedScroll() {
        this.f3955RW.mo1069aJ(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.f3955RW.mo1068aI(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f3955RW.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f3955RW.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f3955RW.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f3955RW.dispatchNestedPreFling(f, f2);
    }

    /* renamed from: a */
    private static boolean m27095a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    /* renamed from: I */
    private void m27091I(float f) {
        float f2;
        this.f3970Sl.mo72181H(true);
        float min = Math.min(1.0f, Math.abs(f / this.f3953RU));
        float max = (Math.max((float) (((double) min) - 0.4d), 0.0f) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f3953RU;
        if (this.f3978St) {
            f2 = (float) (this.f3969Sk - this.f3968Sj);
        } else {
            f2 = (float) this.f3969Sk;
        }
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.f3968Sj;
        if (this.f3965Sg.getVisibility() != 0) {
            this.f3965Sg.setVisibility(0);
        }
        if (!this.f3962Sd) {
            this.f3965Sg.setScaleX(1.0f);
            this.f3965Sg.setScaleY(1.0f);
        }
        if (this.f3962Sd) {
            setAnimationProgress(Math.min(1.0f, f / this.f3953RU));
        }
        if (f < this.f3953RU) {
            if (this.f3970Sl.getAlpha() > 76 && !SwipeRefreshLayout.m27095a(this.f3973So)) {
                m27098eS();
            }
        } else if (this.f3970Sl.getAlpha() < 255 && !SwipeRefreshLayout.m27095a(this.f3974Sp)) {
            m27099eT();
        }
        this.f3970Sl.mo72179C(Math.min(0.8f, max * 0.8f));
        this.f3970Sl.mo72178B(Math.min(1.0f, max));
        this.f3970Sl.mo72180D(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.f3960Sb);
    }

    /* renamed from: J */
    private void m27092J(float f) {
        if (f > this.f3953RU) {
            m27102f(true, true);
            return;
        }
        this.f3952RT = false;
        this.f3970Sl.mo72179C(0.0f);
        AnimationListener animationListener = null;
        if (!this.f3962Sd) {
            animationListener = new C174575();
        }
        m27096b(this.f3960Sb, animationListener);
        this.f3970Sl.mo72181H(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3963Se && actionMasked == 0) {
            this.f3963Se = false;
        }
        if (!isEnabled() || this.f3963Se || m27101eV() || this.f3952RT || this.f3958RZ) {
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
                    m27092J(y);
                }
                this.mActivePointerId = -1;
                return false;
            case 2:
                actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                if (actionMasked < 0) {
                    return false;
                }
                y = motionEvent.getY(actionMasked);
                m27093K(y);
                if (this.mIsBeingDragged) {
                    y = (y - this.mInitialMotionY) * 0.5f;
                    if (y > 0.0f) {
                        m27091I(y);
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

    /* renamed from: K */
    private void m27093K(float f) {
        if (f - this.f3961Sc > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.f3961Sc + ((float) this.mTouchSlop);
            this.mIsBeingDragged = true;
            this.f3970Sl.setAlpha(76);
        }
    }

    /* renamed from: a */
    private void m27094a(int i, AnimationListener animationListener) {
        this.mFrom = i;
        this.f3981Sw.reset();
        this.f3981Sw.setDuration(200);
        this.f3981Sw.setInterpolator(this.f3964Sf);
        if (animationListener != null) {
            this.f3965Sg.f15805OW = animationListener;
        }
        this.f3965Sg.clearAnimation();
        this.f3965Sg.startAnimation(this.f3981Sw);
    }

    /* renamed from: b */
    private void m27096b(int i, AnimationListener animationListener) {
        if (this.f3962Sd) {
            m27097c(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.f3982Sx.reset();
        this.f3982Sx.setDuration(200);
        this.f3982Sx.setInterpolator(this.f3964Sf);
        if (animationListener != null) {
            this.f3965Sg.f15805OW = animationListener;
        }
        this.f3965Sg.clearAnimation();
        this.f3965Sg.startAnimation(this.f3982Sx);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: L */
    public final void mo31752L(float f) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) (((float) (this.f3968Sj - this.mFrom)) * f))) - this.f3965Sg.getTop());
    }

    /* renamed from: c */
    private void m27097c(int i, AnimationListener animationListener) {
        this.mFrom = i;
        this.f3967Si = this.f3965Sg.getScaleX();
        this.f3975Sq = new C174598();
        this.f3975Sq.setDuration(150);
        if (animationListener != null) {
            this.f3965Sg.f15805OW = animationListener;
        }
        this.f3965Sg.clearAnimation();
        this.f3965Sg.startAnimation(this.f3975Sq);
    }

    /* Access modifiers changed, original: 0000 */
    public void setTargetOffsetTopAndBottom(int i) {
        this.f3965Sg.bringToFront();
        C0477s.m951q(this.f3965Sg, i);
        this.f3960Sb = this.f3965Sg.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}

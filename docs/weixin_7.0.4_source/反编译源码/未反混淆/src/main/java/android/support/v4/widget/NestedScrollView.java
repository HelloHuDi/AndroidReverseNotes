package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.j;
import android.support.v4.view.k;
import android.support.v4.view.l;
import android.support.v4.view.n;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements j, l {
    private static final a Ri = new a();
    private static final int[] Rj = new int[]{16843130};
    private long QV;
    private EdgeEffect QW;
    private EdgeEffect QX;
    private boolean QY;
    private boolean QZ;
    private View Ra;
    private boolean Rb;
    private boolean Rc;
    private final int[] Rd;
    private final int[] Re;
    private int Rf;
    private int Rg;
    private SavedState Rh;
    private final n Rk;
    private final k Rl;
    private float Rm;
    private b Rn;
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private OverScroller qN;
    private int qO;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        public int Ro;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.Ro = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ro);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.Ro + "}";
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView);
    }

    static class a extends android.support.v4.view.a {
        a() {
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.aW(min);
                    return true;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.aW(min);
                    return true;
                default:
                    return false;
            }
        }

        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    bVar.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        bVar.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        bVar.addAction(4096);
                    }
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            int scrollX = nestedScrollView.getScrollX();
            if (VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollX(scrollX);
            }
            scrollX = nestedScrollView.getScrollRange();
            if (VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollY(scrollX);
            }
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        this.QY = true;
        this.QZ = false;
        this.Ra = null;
        this.mIsBeingDragged = false;
        this.Rc = true;
        this.mActivePointerId = -1;
        this.Rd = new int[2];
        this.Re = new int[2];
        this.qN = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Rj, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.Rk = new n(this);
        this.Rl = new k(this);
        setNestedScrollingEnabled(true);
        s.a((View) this, Ri);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.Rl.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.Rl.Mp;
    }

    public boolean startNestedScroll(int i) {
        return this.Rl.w(i, 0);
    }

    private boolean aU(int i) {
        return this.Rl.w(2, i);
    }

    public void stopNestedScroll() {
        this.Rl.aJ(0);
    }

    private void aJ(int i) {
        this.Rl.aJ(i);
    }

    public boolean hasNestedScrollingParent() {
        return this.Rl.aI(0);
    }

    private boolean aI(int i) {
        return this.Rl.aI(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.Rl.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    private boolean a(int i, int i2, int[] iArr, int i3) {
        return this.Rl.a(0, i, 0, i2, iArr, i3);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.Rl.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    private boolean a(int i, int[] iArr, int[] iArr2, int i2) {
        return this.Rl.a(0, i, iArr, iArr2, i2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.Rl.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.Rl.dispatchNestedPreFling(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.Rk.Ms = i;
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.Rk.Ms = 0;
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        aX((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.Rk.Ms;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* Access modifiers changed, original: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.Rn = bVar;
    }

    private boolean er() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.Rb) {
            this.Rb = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.Rc = z;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.Rn != null) {
            this.Rn.a(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Rb && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), ErrorDialogData.SUPPRESSED));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        int i = 33;
        this.mTempRect.setEmpty();
        if (er()) {
            boolean arrowScroll;
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 19:
                        if (!keyEvent.isAltPressed()) {
                            arrowScroll = arrowScroll(33);
                            break;
                        }
                        arrowScroll = fullScroll(33);
                        break;
                    case 20:
                        if (!keyEvent.isAltPressed()) {
                            arrowScroll = arrowScroll(130);
                            break;
                        }
                        arrowScroll = fullScroll(130);
                        break;
                    case 62:
                        if (!keyEvent.isShiftPressed()) {
                            i = 130;
                        }
                        pageScroll(i);
                        break;
                }
            }
            arrowScroll = false;
            return arrowScroll;
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                return false;
            }
            return true;
        }
    }

    private void eM() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void eN() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            eN();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int y;
        switch (action & 255) {
            case 0:
                boolean z2;
                y = (int) motionEvent.getY();
                action = (int) motionEvent.getX();
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    z2 = y >= childAt.getTop() - scrollY && y < childAt.getBottom() - scrollY && action >= childAt.getLeft() && action < childAt.getRight();
                } else {
                    z2 = false;
                }
                if (!z2) {
                    this.mIsBeingDragged = false;
                    eN();
                    break;
                }
                this.qO = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                } else {
                    this.mVelocityTracker.clear();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                this.qN.computeScrollOffset();
                if (this.qN.isFinished()) {
                    z = false;
                }
                this.mIsBeingDragged = z;
                aU(0);
                break;
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                eN();
                if (this.qN.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    s.R(this);
                }
                aJ(0);
                break;
            case 2:
                action = this.mActivePointerId;
                if (action != -1) {
                    y = motionEvent.findPointerIndex(action);
                    if (y != -1) {
                        action = (int) motionEvent.getY(y);
                        if (Math.abs(action - this.qO) > this.mTouchSlop && (getNestedScrollAxes() & 2) == 0) {
                            this.mIsBeingDragged = true;
                            this.qO = action;
                            eM();
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.Rf = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Invalid pointerId=").append(action).append(" in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        eM();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Rf = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.Rf);
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.qN.isFinished();
                    this.mIsBeingDragged = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.qN.isFinished()) {
                        this.qN.abortAnimation();
                    }
                    this.qO = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    aU(0);
                    break;
                }
                return false;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                actionMasked = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(actionMasked) > this.mMinimumVelocity) {
                    aX(-actionMasked);
                } else {
                    if (this.qN.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        s.R(this);
                    }
                }
                this.mActivePointerId = -1;
                endDrag();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    actionMasked = this.qO - y;
                    if (a(actionMasked, this.Re, this.Rd, 0)) {
                        actionMasked -= this.Re[1];
                        obtain.offsetLocation(0.0f, (float) this.Rd[1]);
                        this.Rf += this.Rd[1];
                    }
                    if (!this.mIsBeingDragged && Math.abs(actionMasked) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        if (actionMasked > 0) {
                            actionMasked -= this.mTouchSlop;
                        } else {
                            actionMasked += this.mTouchSlop;
                        }
                    }
                    if (this.mIsBeingDragged) {
                        boolean z2;
                        this.qO = y - this.Rd[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        y = getOverScrollMode();
                        if (y == 0 || (y == 1 && scrollRange > 0)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (g(actionMasked, 0, getScrollY(), scrollRange) && !aI(0)) {
                            this.mVelocityTracker.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!a(scrollY2, actionMasked - scrollY2, this.Rd, 0)) {
                            if (z2) {
                                eO();
                                y = scrollY + actionMasked;
                                if (y < 0) {
                                    i.a(this.QW, ((float) actionMasked) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                    if (!this.QX.isFinished()) {
                                        this.QX.onRelease();
                                    }
                                } else if (y > scrollRange) {
                                    i.a(this.QX, ((float) actionMasked) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                    if (!this.QW.isFinished()) {
                                        this.QW.onRelease();
                                    }
                                }
                                if (!(this.QW == null || (this.QW.isFinished() && this.QX.isFinished()))) {
                                    s.R(this);
                                    break;
                                }
                            }
                        }
                        this.qO -= this.Rd[1];
                        obtain.offsetLocation(0.0f, (float) this.Rd[1]);
                        this.Rf += this.Rd[1];
                        break;
                    }
                }
                new StringBuilder("Invalid pointerId=").append(this.mActivePointerId).append(" in onTouchEvent");
                break;
                break;
            case 3:
                if (this.mIsBeingDragged && getChildCount() > 0) {
                    if (this.qN.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        s.R(this);
                    }
                }
                this.mActivePointerId = -1;
                endDrag();
                break;
            case 5:
                actionMasked = motionEvent.getActionIndex();
                this.qO = (int) motionEvent.getY(actionMasked);
                this.mActivePointerId = motionEvent.getPointerId(actionMasked);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                this.qO = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.qO = (int) motionEvent.getY(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.mIsBeingDragged) {
                    return false;
                }
                float axisValue = motionEvent.getAxisValue(9);
                if (axisValue == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.Rm == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.Rm = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.Rm;
    }

    /* Access modifiers changed, original: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean g(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i5 = i2 + 0;
        int i6 = i3 + i;
        int i7 = i4 + 0;
        if (i5 > 0) {
            i5 = 0;
            z = true;
        } else if (i5 < 0) {
            i5 = 0;
            z = true;
        } else {
            z = false;
        }
        if (i6 > i7) {
            z2 = true;
        } else if (i6 < 0) {
            z2 = true;
            i7 = 0;
        } else {
            z2 = false;
            i7 = i6;
        }
        if (z2 && !aI(1)) {
            this.qN.springBack(i5, i7, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i5, i7, z, z2);
        if (z || z2) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View a(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        View view = null;
        int size = focusables.size();
        int i3 = 0;
        Object obj = null;
        while (i3 < size) {
            Object obj2;
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                obj2 = (i >= top || bottom >= i2) ? null : 1;
                if (view != null) {
                    Object obj3 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj2 == null || obj3 == null)) {
                            obj2 = obj;
                        }
                    } else if (obj2 != null) {
                        int obj22 = 1;
                    } else if (obj3 != null) {
                        obj22 = obj;
                    }
                }
                i3++;
                obj = obj22;
                view = view2;
            }
            obj22 = obj;
            view2 = view;
            i3++;
            obj = obj22;
            view = view2;
        }
        return view;
    }

    private boolean pageScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.mTempRect.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.mTempRect.top + height > childAt.getBottom()) {
                    this.mTempRect.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            if (this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }
        this.mTempRect.bottom = this.mTempRect.top + height;
        return g(i, this.mTempRect.top, this.mTempRect.bottom);
    }

    private boolean fullScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.mTempRect.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.mTempRect.top = this.mTempRect.bottom - height;
            }
        }
        return g(i, this.mTempRect.top, this.mTempRect.bottom);
    }

    private boolean g(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            aV(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !g(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            aV(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            aV(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && aK(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean aK(View view) {
        return !g(view, 0, getHeight());
    }

    private boolean g(View view, int i, int i2) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.bottom + i >= getScrollY() && this.mTempRect.top - i <= getScrollY() + i2;
    }

    private void aV(int i) {
        if (i == 0) {
            return;
        }
        if (this.Rc) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.QV > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.qN.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                s.R(this);
            } else {
                if (!this.qN.isFinished()) {
                    this.qN.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.QV = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void aW(int i) {
        smoothScrollBy(0 - getScrollX(), i - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    /* Access modifiers changed, original: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* Access modifiers changed, original: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        int i = 0;
        if (this.qN.computeScrollOffset()) {
            this.qN.getCurrX();
            int currY = this.qN.getCurrY();
            int i2 = currY - this.Rg;
            if (a(i2, this.Re, null, 1)) {
                i2 -= this.Re[1];
            }
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                g(i2, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                if (!a(scrollY2, i2 - scrollY2, null, 1)) {
                    i2 = getOverScrollMode();
                    if (i2 == 0 || (i2 == 1 && scrollRange > 0)) {
                        i = 1;
                    }
                    if (i != 0) {
                        eO();
                        if (currY <= 0 && scrollY > 0) {
                            this.QW.onAbsorb((int) this.qN.getCurrVelocity());
                        } else if (currY >= scrollRange && scrollY < scrollRange) {
                            this.QX.onAbsorb((int) this.qN.getCurrVelocity());
                        }
                    }
                }
            }
            this.Rg = currY;
            s.R(this);
            return;
        }
        if (aI(1)) {
            aJ(1);
        }
        this.Rg = 0;
    }

    private void aL(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.QY) {
            this.Ra = view2;
        } else {
            aL(view2);
        }
        super.requestChildFocus(view, view2);
    }

    /* Access modifiers changed, original: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocus;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocus == null || aK(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.QY = true;
        super.requestLayout();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.QY = false;
        if (this.Ra != null && b(this.Ra, this)) {
            aL(this.Ra);
        }
        this.Ra = null;
        if (!this.QZ) {
            if (this.Rh != null) {
                scrollTo(getScrollX(), this.Rh.Ro);
                this.Rh = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.QZ = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.QZ = false;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && g(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            aV(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    private static boolean b(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && b((View) parent, view2);
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            aU(1);
            this.qN.fling(getScrollX(), getScrollY(), 0, i, 0, 0, j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, 0, 0);
            this.Rg = getScrollY();
            s.R(this);
        }
    }

    private void aX(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            fling(i);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        eN();
        aJ(0);
        if (this.QW != null) {
            this.QW.onRelease();
            this.QX.onRelease();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int clamp2 = clamp(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    private void eO() {
        if (getOverScrollMode() == 2) {
            this.QW = null;
            this.QX = null;
        } else if (this.QW == null) {
            Context context = getContext();
            this.QW = new EdgeEffect(context);
            this.QX = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        int i = 0;
        super.draw(canvas);
        if (this.QW != null) {
            int width;
            int height;
            int min;
            int paddingLeft;
            int scrollY = getScrollY();
            if (!this.QW.isFinished()) {
                int save = canvas.save();
                width = getWidth();
                height = getHeight();
                min = Math.min(0, scrollY);
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) paddingLeft, (float) min);
                this.QW.setSize(width, height);
                if (this.QW.draw(canvas)) {
                    s.R(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.QX.isFinished()) {
                height = canvas.save();
                paddingLeft = getWidth();
                min = getHeight();
                width = Math.max(getScrollRange(), scrollY) + min;
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    paddingLeft -= getPaddingLeft() + getPaddingRight();
                    i = getPaddingLeft() + 0;
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    min -= getPaddingTop() + getPaddingBottom();
                    width -= getPaddingBottom();
                }
                canvas.translate((float) (i - paddingLeft), (float) width);
                canvas.rotate(180.0f, (float) paddingLeft, 0.0f);
                this.QX.setSize(paddingLeft, min);
                if (this.QX.draw(canvas)) {
                    s.R(this);
                }
                canvas.restoreToCount(height);
            }
        }
    }

    private static int clamp(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.Rh = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ro = getScrollY();
        return savedState;
    }
}

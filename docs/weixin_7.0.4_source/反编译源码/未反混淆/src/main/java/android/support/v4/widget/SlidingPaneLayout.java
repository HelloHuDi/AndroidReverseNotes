package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final e RJ;
    View RA;
    float RB;
    private float RC;
    int RD;
    int RE;
    private d RF;
    final t RG;
    boolean RH;
    final ArrayList<b> RI;
    int Rv;
    private int Rw;
    private Drawable Rx;
    private Drawable Ry;
    private final int Rz;
    private boolean mCanSlide;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final Rect oT;

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] MT = new int[]{16843137};
        boolean RM;
        boolean RN;
        Paint RO;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MT);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    class b implements Runnable {
        final View RL;

        b(View view) {
            this.RL = view;
        }

        public final void run() {
            if (this.RL.getParent() == SlidingPaneLayout.this) {
                this.RL.setLayerType(0, null);
                SlidingPaneLayout.this.aN(this.RL);
            }
            SlidingPaneLayout.this.RI.remove(this);
        }
    }

    public interface d {
    }

    interface e {
        void a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        boolean RP;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel, null);
            this.RP = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.RP ? 1 : 0);
        }
    }

    class a extends android.support.v4.view.a {
        private final Rect oT = new Rect();

        a() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
            int movementGranularities;
            int i = 0;
            android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
            super.onInitializeAccessibilityNodeInfo(view, a);
            Rect rect = this.oT;
            a.getBoundsInParent(rect);
            bVar.setBoundsInParent(rect);
            a.getBoundsInScreen(rect);
            bVar.setBoundsInScreen(rect);
            bVar.setVisibleToUser(a.isVisibleToUser());
            bVar.setPackageName(a.NG.getPackageName());
            bVar.setClassName(a.NG.getClassName());
            bVar.setContentDescription(a.NG.getContentDescription());
            bVar.setEnabled(a.NG.isEnabled());
            bVar.setClickable(a.NG.isClickable());
            bVar.setFocusable(a.NG.isFocusable());
            bVar.setFocused(a.NG.isFocused());
            bVar.setAccessibilityFocused(a.isAccessibilityFocused());
            bVar.setSelected(a.NG.isSelected());
            bVar.setLongClickable(a.NG.isLongClickable());
            bVar.addAction(a.NG.getActions());
            if (VERSION.SDK_INT >= 16) {
                movementGranularities = a.NG.getMovementGranularities();
            } else {
                movementGranularities = 0;
            }
            if (VERSION.SDK_INT >= 16) {
                bVar.NG.setMovementGranularities(movementGranularities);
            }
            a.NG.recycle();
            bVar.setClassName(SlidingPaneLayout.class.getName());
            bVar.setSource(view);
            ViewParent U = s.U(view);
            if (U instanceof View) {
                bVar.setParent((View) U);
            }
            movementGranularities = SlidingPaneLayout.this.getChildCount();
            while (i < movementGranularities) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!aP(childAt) && childAt.getVisibility() == 0) {
                    s.o(childAt, 1);
                    bVar.addChild(childAt);
                }
                i++;
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (aP(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        private boolean aP(View view) {
            return SlidingPaneLayout.this.aO(view);
        }
    }

    class c extends android.support.v4.widget.t.a {
        c() {
        }

        public final boolean b(View view, int i) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).RM;
        }

        public final void N(int i) {
            if (SlidingPaneLayout.this.RG.SG != 0) {
                return;
            }
            if (SlidingPaneLayout.this.RB == 0.0f) {
                SlidingPaneLayout.this.aM(SlidingPaneLayout.this.RA);
                SlidingPaneLayout.this.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.RH = false;
                return;
            }
            SlidingPaneLayout.this.sendAccessibilityEvent(32);
            SlidingPaneLayout.this.RH = true;
        }

        public final void k(View view, int i) {
            SlidingPaneLayout.this.eP();
        }

        public final void b(View view, int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.RA == null) {
                slidingPaneLayout.RB = 0.0f;
            } else {
                boolean eR = slidingPaneLayout.eR();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.RA.getLayoutParams();
                int width = slidingPaneLayout.RA.getWidth();
                if (eR) {
                    i = (slidingPaneLayout.getWidth() - i) - width;
                }
                slidingPaneLayout.RB = ((float) (i - ((eR ? layoutParams.rightMargin : layoutParams.leftMargin) + (eR ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft())))) / ((float) slidingPaneLayout.RD);
                if (slidingPaneLayout.RE != 0) {
                    slidingPaneLayout.H(slidingPaneLayout.RB);
                }
                if (layoutParams.RN) {
                    slidingPaneLayout.a(slidingPaneLayout.RA, slidingPaneLayout.RB, slidingPaneLayout.Rv);
                }
            }
            SlidingPaneLayout.this.invalidate();
        }

        public final void a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.eR()) {
                paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.RB > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.RD;
                }
                paddingRight = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.RA.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.RB > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.RD;
                }
            }
            SlidingPaneLayout.this.RG.D(paddingRight, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public final int s(View view) {
            return SlidingPaneLayout.this.RD;
        }

        public final int d(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.RA.getLayoutParams();
            int width;
            if (SlidingPaneLayout.this.eR()) {
                width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.RA.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.RD);
            }
            width = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, width), SlidingPaneLayout.this.RD + width);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void z(int i, int i2) {
            SlidingPaneLayout.this.RG.u(SlidingPaneLayout.this.RA, i2);
        }
    }

    static class f implements e {
        f() {
        }

        public void a(SlidingPaneLayout slidingPaneLayout, View view) {
            s.c(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class g extends f {
        private Method RQ;
        private Field RR;

        g() {
            try {
                this.RQ = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.RR = View.class.getDeclaredField("mRecreateDisplayList");
                this.RR.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
        }

        public final void a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.RQ == null || this.RR == null) {
                view.invalidate();
                return;
            }
            try {
                this.RR.setBoolean(view, true);
                this.RQ.invoke(view, null);
            } catch (Exception e) {
            }
            super.a(slidingPaneLayout, view);
        }
    }

    static class h extends f {
        h() {
        }

        public final void a(SlidingPaneLayout slidingPaneLayout, View view) {
            s.a(view, ((LayoutParams) view.getLayoutParams()).RO);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            RJ = new h();
        } else if (VERSION.SDK_INT >= 16) {
            RJ = new g();
        } else {
            RJ = new f();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Rv = -858993460;
        this.mFirstLayout = true;
        this.oT = new Rect();
        this.RI = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.Rz = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        s.a((View) this, new a());
        s.o(this, 1);
        this.RG = t.a((ViewGroup) this, 0.5f, new c());
        this.RG.SQ = f * 400.0f;
    }

    public void setParallaxDistance(int i) {
        this.RE = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.RE;
    }

    public void setSliderFadeColor(int i) {
        this.Rv = i;
    }

    public int getSliderFadeColor() {
        return this.Rv;
    }

    public void setCoveredFadeColor(int i) {
        this.Rw = i;
    }

    public int getCoveredFadeColor() {
        return this.Rw;
    }

    public void setPanelSlideListener(d dVar) {
        this.RF = dVar;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aM(View view) {
        int paddingLeft;
        int left;
        int right;
        int bottom;
        int i;
        int childCount;
        int i2;
        boolean eR = eR();
        int width = eR ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (eR) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null) {
            Object obj;
            if (view.isOpaque()) {
                obj = 1;
            } else {
                if (VERSION.SDK_INT < 18) {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        obj = background.getOpacity() == -1 ? 1 : null;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                left = view.getLeft();
                right = view.getRight();
                int top = view.getTop();
                bottom = view.getBottom();
                i = top;
                childCount = getChildCount();
                i2 = 0;
                while (i2 < childCount) {
                    View childAt = getChildAt(i2);
                    if (childAt != view) {
                        if (childAt.getVisibility() != 8) {
                            int max = Math.max(eR ? paddingLeft : width, childAt.getLeft());
                            int max2 = Math.max(paddingTop, childAt.getTop());
                            if (eR) {
                                top = width;
                            } else {
                                top = paddingLeft;
                            }
                            top = Math.min(top, childAt.getRight());
                            int min = Math.min(height, childAt.getBottom());
                            if (max < left || max2 < i || top > right || min > bottom) {
                                top = 0;
                            } else {
                                top = 4;
                            }
                            childAt.setVisibility(top);
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
        bottom = 0;
        i = 0;
        right = 0;
        left = 0;
        childCount = getChildCount();
        i2 = 0;
        while (i2 < childCount) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void eP() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.RI.size();
        for (int i = 0; i < size; i++) {
            ((b) this.RI.get(i)).run();
        }
        this.RI.clear();
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        LayoutParams layoutParams;
        int makeMeasureSpec;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == ErrorDialogData.SUPPRESSED) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    size2 = 300;
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                }
            }
            i3 = mode2;
            i4 = size;
        } else if (isInEditMode()) {
            if (mode != j.INVALID_ID && mode == 0) {
                i3 = mode2;
                i4 = 300;
            }
            i3 = mode2;
            i4 = size;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        size = 0;
        switch (i3) {
            case j.INVALID_ID /*-2147483648*/:
                size2 = (size2 - getPaddingTop()) - getPaddingBottom();
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                mode2 = (size2 - getPaddingTop()) - getPaddingBottom();
                size2 = mode2;
                size = mode2;
                break;
            default:
                size2 = 0;
                break;
        }
        float f = 0.0f;
        int i5 = 0;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.RA = null;
        int i6 = 0;
        int i7 = paddingLeft;
        int i8 = size;
        while (i6 < childCount) {
            float f2;
            View childAt = getChildAt(i6);
            layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.RN = false;
                mode2 = i7;
                f2 = f;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f2 = layoutParams.weight + f;
                    if (layoutParams.width == 0) {
                        mode2 = i7;
                    }
                } else {
                    f2 = f;
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, j.INVALID_ID);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, ErrorDialogData.SUPPRESSED);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, ErrorDialogData.SUPPRESSED);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, j.INVALID_ID);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, ErrorDialogData.SUPPRESSED);
                } else {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, ErrorDialogData.SUPPRESSED);
                }
                childAt.measure(mode, makeMeasureSpec);
                mode = childAt.getMeasuredWidth();
                makeMeasureSpec = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && makeMeasureSpec > i8) {
                    i8 = Math.min(makeMeasureSpec, size2);
                }
                makeMeasureSpec = i7 - mode;
                boolean z = makeMeasureSpec < 0;
                layoutParams.RM = z;
                mode = z | i5;
                if (layoutParams.RM) {
                    this.RA = childAt;
                }
                mode2 = makeMeasureSpec;
                i5 = mode;
            }
            i6++;
            i7 = mode2;
            f = f2;
        }
        if (i5 != 0 || f > 0.0f) {
            int i9 = paddingLeft - this.Rz;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.weight <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (i5 == 0 || childAt2 == this.RA) {
                            if (layoutParams.weight > 0.0f) {
                                if (layoutParams.width != 0) {
                                    size = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), ErrorDialogData.SUPPRESSED);
                                } else if (layoutParams.height == -2) {
                                    size = MeasureSpec.makeMeasureSpec(size2, j.INVALID_ID);
                                } else if (layoutParams.height == -1) {
                                    size = MeasureSpec.makeMeasureSpec(size2, ErrorDialogData.SUPPRESSED);
                                } else {
                                    size = MeasureSpec.makeMeasureSpec(layoutParams.height, ErrorDialogData.SUPPRESSED);
                                }
                                if (i5 != 0) {
                                    mode2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i6 = MeasureSpec.makeMeasureSpec(mode2, ErrorDialogData.SUPPRESSED);
                                    if (makeMeasureSpec != mode2) {
                                        childAt2.measure(i6, size);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.weight * ((float) Math.max(0, i7))) / f)) + makeMeasureSpec, ErrorDialogData.SUPPRESSED), size);
                                }
                            }
                        } else if (layoutParams.width < 0 && (makeMeasureSpec > i9 || layoutParams.weight > 0.0f)) {
                            if (obj == null) {
                                mode2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), ErrorDialogData.SUPPRESSED);
                            } else if (layoutParams.height == -2) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, j.INVALID_ID);
                            } else if (layoutParams.height == -1) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, ErrorDialogData.SUPPRESSED);
                            } else {
                                mode2 = MeasureSpec.makeMeasureSpec(layoutParams.height, ErrorDialogData.SUPPRESSED);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, ErrorDialogData.SUPPRESSED), mode2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i8) + getPaddingBottom());
        this.mCanSlide = i5;
        if (this.RG.SG != 0 && i5 == 0) {
            this.RG.abort();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean eR = eR();
        if (eR) {
            this.RG.SS = 2;
        } else {
            this.RG.SS = 1;
        }
        int i6 = i3 - i;
        int paddingRight = eR ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = eR ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            float f = (this.mCanSlide && this.RH) ? 1.0f : 0.0f;
            this.RB = f;
        }
        int i7 = 0;
        int i8 = paddingRight;
        int i9 = paddingRight;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = 0;
                if (layoutParams.RM) {
                    int min = (Math.min(i8, (i6 - paddingLeft) - this.Rz) - i9) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.RD = min;
                    paddingRight = eR ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.RN = ((i9 + paddingRight) + min) + (measuredWidth / 2) > i6 - paddingLeft;
                    i5 = (int) (((float) min) * this.RB);
                    i10 = i9 + (paddingRight + i5);
                    this.RB = ((float) i5) / ((float) this.RD);
                } else {
                    if (!this.mCanSlide || this.RE == 0) {
                        i5 = 0;
                    } else {
                        i5 = (int) ((1.0f - this.RB) * ((float) this.RE));
                    }
                    i11 = i5;
                    i10 = i8;
                }
                if (eR) {
                    paddingRight = (i6 - i10) + i11;
                    i5 = paddingRight - measuredWidth;
                } else {
                    i5 = i10 - i11;
                    paddingRight = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, paddingRight, childAt.getMeasuredHeight() + paddingTop);
                i5 = childAt.getWidth() + i8;
                paddingRight = i10;
            } else {
                i5 = i8;
                paddingRight = i9;
            }
            i7++;
            i8 = i5;
            i9 = paddingRight;
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.RE != 0) {
                    H(this.RB);
                }
                if (((LayoutParams) this.RA.getLayoutParams()).RN) {
                    a(this.RA, this.RB, this.Rv);
                }
            } else {
                for (i5 = 0; i5 < childCount; i5++) {
                    a(getChildAt(i5), 0.0f, this.Rv);
                }
            }
            aM(this.RA);
        }
        this.mFirstLayout = false;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.RH = view == this.RA;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.RH = !t.i(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.RG.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.RG.cancel();
            return false;
        } else {
            boolean z;
            float x;
            float y;
            switch (actionMasked) {
                case 0:
                    this.mIsUnableToDrag = false;
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    this.mInitialMotionX = x;
                    this.mInitialMotionY = y;
                    if (t.i(this.RA, (int) x, (int) y) && aO(this.RA)) {
                        z = true;
                        break;
                    }
                case 2:
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    x = Math.abs(x - this.mInitialMotionX);
                    y = Math.abs(y - this.mInitialMotionY);
                    if (x > ((float) this.RG.mTouchSlop) && y > x) {
                        this.RG.cancel();
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    z = false;
                    break;
            }
            z = false;
            if (this.RG.f(motionEvent) || z) {
                return true;
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.RG.g(motionEvent);
        float x;
        float y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                break;
            case 1:
                if (aO(this.RA)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.mInitialMotionX;
                    float f2 = y - this.mInitialMotionY;
                    int i = this.RG.mTouchSlop;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && t.i(this.RA, (int) x, (int) y)) {
                        eQ();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean eQ() {
        if (!this.mFirstLayout && !G(0.0f)) {
            return false;
        }
        this.RH = false;
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((WebView.NIGHT_MODE_COLOR & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.RO == null) {
                layoutParams.RO = new Paint();
            }
            layoutParams.RO.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.RO);
            }
            aN(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.RO != null) {
                layoutParams.RO.setColorFilter(null);
            }
            Runnable bVar = new b(view);
            this.RI.add(bVar);
            s.b((View) this, bVar);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (!(!this.mCanSlide || layoutParams.RM || this.RA == null)) {
            canvas.getClipBounds(this.oT);
            if (eR()) {
                this.oT.left = Math.max(this.oT.left, this.RA.getRight());
            } else {
                this.oT.right = Math.min(this.oT.right, this.RA.getLeft());
            }
            canvas.clipRect(this.oT);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* Access modifiers changed, original: final */
    public final void aN(View view) {
        RJ.a(this, view);
    }

    private boolean G(float f) {
        if (!this.mCanSlide) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.RA.getLayoutParams();
        if (eR()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.RD) * f)) + ((float) this.RA.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.RD) * f));
        }
        if (!this.RG.h(this.RA, width, this.RA.getTop())) {
            return false;
        }
        eP();
        s.R(this);
        return true;
    }

    public void computeScroll() {
        if (!this.RG.eX()) {
            return;
        }
        if (this.mCanSlide) {
            s.R(this);
        } else {
            this.RG.abort();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.Rx = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.Ry = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(android.support.v4.content.b.g(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(android.support.v4.content.b.g(getContext(), i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (eR()) {
            drawable = this.Ry;
        } else {
            drawable = this.Rx;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (eR()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(float f) {
        Object obj;
        int childCount;
        int i;
        boolean eR = eR();
        LayoutParams layoutParams = (LayoutParams) this.RA.getLayoutParams();
        if (layoutParams.RN) {
            if ((eR ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt != this.RA) {
                        int i2 = (int) ((1.0f - this.RC) * ((float) this.RE));
                        this.RC = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.RE));
                        if (eR) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj != null) {
                            float f2;
                            if (eR) {
                                f2 = this.RC - 1.0f;
                            } else {
                                f2 = 1.0f - this.RC;
                            }
                            a(childAt, f2, this.Rw);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        while (i < childCount) {
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean aO(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).RN && this.RB > 0.0f;
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.mCanSlide ? !this.mCanSlide || this.RB == 1.0f : this.RH;
        savedState.RP = z;
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.LC);
            if (!savedState.RP) {
                eQ();
            } else if (this.mFirstLayout || G(1.0f)) {
                this.RH = true;
            }
            this.RH = savedState.RP;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: final */
    public final boolean eR() {
        return s.T(this) == 1;
    }
}

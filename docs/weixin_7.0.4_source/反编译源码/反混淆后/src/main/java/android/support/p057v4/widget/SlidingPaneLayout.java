package android.support.p057v4.widget;

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
import android.support.p057v4.content.C0380b;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.widget.C0553t.C0552a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.SlidingPaneLayout */
public class SlidingPaneLayout extends ViewGroup {
    /* renamed from: RJ */
    static final C0513e f649RJ;
    /* renamed from: RA */
    View f650RA;
    /* renamed from: RB */
    float f651RB;
    /* renamed from: RC */
    private float f652RC;
    /* renamed from: RD */
    int f653RD;
    /* renamed from: RE */
    int f654RE;
    /* renamed from: RF */
    private C0512d f655RF;
    /* renamed from: RG */
    final C0553t f656RG;
    /* renamed from: RH */
    boolean f657RH;
    /* renamed from: RI */
    final ArrayList<C0511b> f658RI;
    /* renamed from: Rv */
    int f659Rv;
    /* renamed from: Rw */
    private int f660Rw;
    /* renamed from: Rx */
    private Drawable f661Rx;
    /* renamed from: Ry */
    private Drawable f662Ry;
    /* renamed from: Rz */
    private final int f663Rz;
    private boolean mCanSlide;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    /* renamed from: oT */
    private final Rect f664oT;

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        /* renamed from: MT */
        private static final int[] f643MT = new int[]{16843137};
        /* renamed from: RM */
        boolean f644RM;
        /* renamed from: RN */
        boolean f645RN;
        /* renamed from: RO */
        Paint f646RO;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f643MT);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$b */
    class C0511b implements Runnable {
        /* renamed from: RL */
        final View f648RL;

        C0511b(View view) {
            this.f648RL = view;
        }

        public final void run() {
            if (this.f648RL.getParent() == SlidingPaneLayout.this) {
                this.f648RL.setLayerType(0, null);
                SlidingPaneLayout.this.mo1240aN(this.f648RL);
            }
            SlidingPaneLayout.this.f658RI.remove(this);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$d */
    public interface C0512d {
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$e */
    interface C0513e {
        /* renamed from: a */
        void mo1236a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SavedState */
    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C05101();
        /* renamed from: RP */
        boolean f665RP;

        /* renamed from: android.support.v4.widget.SlidingPaneLayout$SavedState$1 */
        static class C05101 implements ClassLoaderCreator<SavedState> {
            C05101() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel, null);
            this.f665RP = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f665RP ? 1 : 0);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$a */
    class C0514a extends C0449a {
        /* renamed from: oT */
        private final Rect f667oT = new Rect();

        C0514a() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            int movementGranularities;
            int i = 0;
            C0445b a = C0445b.m770a(c0445b);
            super.onInitializeAccessibilityNodeInfo(view, a);
            Rect rect = this.f667oT;
            a.getBoundsInParent(rect);
            c0445b.setBoundsInParent(rect);
            a.getBoundsInScreen(rect);
            c0445b.setBoundsInScreen(rect);
            c0445b.setVisibleToUser(a.isVisibleToUser());
            c0445b.setPackageName(a.f546NG.getPackageName());
            c0445b.setClassName(a.f546NG.getClassName());
            c0445b.setContentDescription(a.f546NG.getContentDescription());
            c0445b.setEnabled(a.f546NG.isEnabled());
            c0445b.setClickable(a.f546NG.isClickable());
            c0445b.setFocusable(a.f546NG.isFocusable());
            c0445b.setFocused(a.f546NG.isFocused());
            c0445b.setAccessibilityFocused(a.isAccessibilityFocused());
            c0445b.setSelected(a.f546NG.isSelected());
            c0445b.setLongClickable(a.f546NG.isLongClickable());
            c0445b.addAction(a.f546NG.getActions());
            if (VERSION.SDK_INT >= 16) {
                movementGranularities = a.f546NG.getMovementGranularities();
            } else {
                movementGranularities = 0;
            }
            if (VERSION.SDK_INT >= 16) {
                c0445b.f546NG.setMovementGranularities(movementGranularities);
            }
            a.f546NG.recycle();
            c0445b.setClassName(SlidingPaneLayout.class.getName());
            c0445b.setSource(view);
            ViewParent U = C0477s.m894U(view);
            if (U instanceof View) {
                c0445b.setParent((View) U);
            }
            movementGranularities = SlidingPaneLayout.this.getChildCount();
            while (i < movementGranularities) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!m1096aP(childAt) && childAt.getVisibility() == 0) {
                    C0477s.m949o(childAt, 1);
                    c0445b.addChild(childAt);
                }
                i++;
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (m1096aP(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        /* renamed from: aP */
        private boolean m1096aP(View view) {
            return SlidingPaneLayout.this.mo1241aO(view);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$c */
    class C0515c extends C0552a {
        C0515c() {
        }

        /* renamed from: b */
        public final boolean mo1218b(View view, int i) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f644RM;
        }

        /* renamed from: N */
        public final void mo1215N(int i) {
            if (SlidingPaneLayout.this.f656RG.f717SG != 0) {
                return;
            }
            if (SlidingPaneLayout.this.f651RB == 0.0f) {
                SlidingPaneLayout.this.mo1239aM(SlidingPaneLayout.this.f650RA);
                SlidingPaneLayout.this.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.f657RH = false;
                return;
            }
            SlidingPaneLayout.this.sendAccessibilityEvent(32);
            SlidingPaneLayout.this.f657RH = true;
        }

        /* renamed from: k */
        public final void mo1224k(View view, int i) {
            SlidingPaneLayout.this.mo1246eP();
        }

        /* renamed from: b */
        public final void mo1217b(View view, int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f650RA == null) {
                slidingPaneLayout.f651RB = 0.0f;
            } else {
                boolean eR = slidingPaneLayout.mo1247eR();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.f650RA.getLayoutParams();
                int width = slidingPaneLayout.f650RA.getWidth();
                if (eR) {
                    i = (slidingPaneLayout.getWidth() - i) - width;
                }
                slidingPaneLayout.f651RB = ((float) (i - ((eR ? layoutParams.rightMargin : layoutParams.leftMargin) + (eR ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft())))) / ((float) slidingPaneLayout.f653RD);
                if (slidingPaneLayout.f654RE != 0) {
                    slidingPaneLayout.mo1237H(slidingPaneLayout.f651RB);
                }
                if (layoutParams.f645RN) {
                    slidingPaneLayout.mo1238a(slidingPaneLayout.f650RA, slidingPaneLayout.f651RB, slidingPaneLayout.f659Rv);
                }
            }
            SlidingPaneLayout.this.invalidate();
        }

        /* renamed from: a */
        public final void mo1216a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.mo1247eR()) {
                paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.f651RB > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f653RD;
                }
                paddingRight = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f650RA.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.f651RB > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f653RD;
                }
            }
            SlidingPaneLayout.this.f656RG.mo1316D(paddingRight, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        /* renamed from: s */
        public final int mo1225s(View view) {
            return SlidingPaneLayout.this.f653RD;
        }

        /* renamed from: d */
        public final int mo1220d(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f650RA.getLayoutParams();
            int width;
            if (SlidingPaneLayout.this.mo1247eR()) {
                width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.f650RA.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.f653RD);
            }
            width = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, width), SlidingPaneLayout.this.f653RD + width);
        }

        /* renamed from: c */
        public final int mo1219c(View view, int i) {
            return view.getTop();
        }

        /* renamed from: z */
        public final void mo1226z(int i, int i2) {
            SlidingPaneLayout.this.f656RG.mo1326u(SlidingPaneLayout.this.f650RA, i2);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$f */
    static class C0516f implements C0513e {
        C0516f() {
        }

        /* renamed from: a */
        public void mo1236a(SlidingPaneLayout slidingPaneLayout, View view) {
            C0477s.m936c(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$g */
    static class C0517g extends C0516f {
        /* renamed from: RQ */
        private Method f669RQ;
        /* renamed from: RR */
        private Field f670RR;

        C0517g() {
            try {
                this.f669RQ = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f670RR = View.class.getDeclaredField("mRecreateDisplayList");
                this.f670RR.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
        }

        /* renamed from: a */
        public final void mo1236a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.f669RQ == null || this.f670RR == null) {
                view.invalidate();
                return;
            }
            try {
                this.f670RR.setBoolean(view, true);
                this.f669RQ.invoke(view, null);
            } catch (Exception e) {
            }
            super.mo1236a(slidingPaneLayout, view);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$h */
    static class C0518h extends C0516f {
        C0518h() {
        }

        /* renamed from: a */
        public final void mo1236a(SlidingPaneLayout slidingPaneLayout, View view) {
            C0477s.m902a(view, ((LayoutParams) view.getLayoutParams()).f646RO);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f649RJ = new C0518h();
        } else if (VERSION.SDK_INT >= 16) {
            f649RJ = new C0517g();
        } else {
            f649RJ = new C0516f();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f659Rv = -858993460;
        this.mFirstLayout = true;
        this.f664oT = new Rect();
        this.f658RI = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.f663Rz = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        C0477s.m905a((View) this, new C0514a());
        C0477s.m949o(this, 1);
        this.f656RG = C0553t.m1196a((ViewGroup) this, 0.5f, new C0515c());
        this.f656RG.f727SQ = f * 400.0f;
    }

    public void setParallaxDistance(int i) {
        this.f654RE = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f654RE;
    }

    public void setSliderFadeColor(int i) {
        this.f659Rv = i;
    }

    public int getSliderFadeColor() {
        return this.f659Rv;
    }

    public void setCoveredFadeColor(int i) {
        this.f660Rw = i;
    }

    public int getCoveredFadeColor() {
        return this.f660Rw;
    }

    public void setPanelSlideListener(C0512d c0512d) {
        this.f655RF = c0512d;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aM */
    public final void mo1239aM(View view) {
        int paddingLeft;
        int left;
        int right;
        int bottom;
        int i;
        int childCount;
        int i2;
        boolean eR = mo1247eR();
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
    /* renamed from: eP */
    public final void mo1246eP() {
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
        int size = this.f658RI.size();
        for (int i = 0; i < size; i++) {
            ((C0511b) this.f658RI.get(i)).run();
        }
        this.f658RI.clear();
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
            if (mode != C8415j.INVALID_ID && mode == 0) {
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
            case C8415j.INVALID_ID /*-2147483648*/:
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
        this.f650RA = null;
        int i6 = 0;
        int i7 = paddingLeft;
        int i8 = size;
        while (i6 < childCount) {
            float f2;
            View childAt = getChildAt(i6);
            layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f645RN = false;
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
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, C8415j.INVALID_ID);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, ErrorDialogData.SUPPRESSED);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, ErrorDialogData.SUPPRESSED);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, C8415j.INVALID_ID);
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
                layoutParams.f644RM = z;
                mode = z | i5;
                if (layoutParams.f644RM) {
                    this.f650RA = childAt;
                }
                mode2 = makeMeasureSpec;
                i5 = mode;
            }
            i6++;
            i7 = mode2;
            f = f2;
        }
        if (i5 != 0 || f > 0.0f) {
            int i9 = paddingLeft - this.f663Rz;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.weight <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (i5 == 0 || childAt2 == this.f650RA) {
                            if (layoutParams.weight > 0.0f) {
                                if (layoutParams.width != 0) {
                                    size = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), ErrorDialogData.SUPPRESSED);
                                } else if (layoutParams.height == -2) {
                                    size = MeasureSpec.makeMeasureSpec(size2, C8415j.INVALID_ID);
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
                                mode2 = MeasureSpec.makeMeasureSpec(size2, C8415j.INVALID_ID);
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
        if (this.f656RG.f717SG != 0 && i5 == 0) {
            this.f656RG.abort();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean eR = mo1247eR();
        if (eR) {
            this.f656RG.f729SS = 2;
        } else {
            this.f656RG.f729SS = 1;
        }
        int i6 = i3 - i;
        int paddingRight = eR ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = eR ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            float f = (this.mCanSlide && this.f657RH) ? 1.0f : 0.0f;
            this.f651RB = f;
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
                if (layoutParams.f644RM) {
                    int min = (Math.min(i8, (i6 - paddingLeft) - this.f663Rz) - i9) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f653RD = min;
                    paddingRight = eR ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f645RN = ((i9 + paddingRight) + min) + (measuredWidth / 2) > i6 - paddingLeft;
                    i5 = (int) (((float) min) * this.f651RB);
                    i10 = i9 + (paddingRight + i5);
                    this.f651RB = ((float) i5) / ((float) this.f653RD);
                } else {
                    if (!this.mCanSlide || this.f654RE == 0) {
                        i5 = 0;
                    } else {
                        i5 = (int) ((1.0f - this.f651RB) * ((float) this.f654RE));
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
                if (this.f654RE != 0) {
                    mo1237H(this.f651RB);
                }
                if (((LayoutParams) this.f650RA.getLayoutParams()).f645RN) {
                    mo1238a(this.f650RA, this.f651RB, this.f659Rv);
                }
            } else {
                for (i5 = 0; i5 < childCount; i5++) {
                    mo1238a(getChildAt(i5), 0.0f, this.f659Rv);
                }
            }
            mo1239aM(this.f650RA);
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
            this.f657RH = view == this.f650RA;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.f657RH = !C0553t.m1213i(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.f656RG.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f656RG.cancel();
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
                    if (C0553t.m1213i(this.f650RA, (int) x, (int) y) && mo1241aO(this.f650RA)) {
                        z = true;
                        break;
                    }
                case 2:
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    x = Math.abs(x - this.mInitialMotionX);
                    y = Math.abs(y - this.mInitialMotionY);
                    if (x > ((float) this.f656RG.mTouchSlop) && y > x) {
                        this.f656RG.cancel();
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    z = false;
                    break;
            }
            z = false;
            if (this.f656RG.mo1323f(motionEvent) || z) {
                return true;
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.f656RG.mo1324g(motionEvent);
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
                if (mo1241aO(this.f650RA)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.mInitialMotionX;
                    float f2 = y - this.mInitialMotionY;
                    int i = this.f656RG.mTouchSlop;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && C0553t.m1213i(this.f650RA, (int) x, (int) y)) {
                        m1088eQ();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    /* renamed from: eQ */
    private boolean m1088eQ() {
        if (!this.mFirstLayout && !m1087G(0.0f)) {
            return false;
        }
        this.f657RH = false;
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo1238a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((WebView.NIGHT_MODE_COLOR & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.f646RO == null) {
                layoutParams.f646RO = new Paint();
            }
            layoutParams.f646RO.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f646RO);
            }
            mo1240aN(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.f646RO != null) {
                layoutParams.f646RO.setColorFilter(null);
            }
            Runnable c0511b = new C0511b(view);
            this.f658RI.add(c0511b);
            C0477s.m934b((View) this, c0511b);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (!(!this.mCanSlide || layoutParams.f644RM || this.f650RA == null)) {
            canvas.getClipBounds(this.f664oT);
            if (mo1247eR()) {
                this.f664oT.left = Math.max(this.f664oT.left, this.f650RA.getRight());
            } else {
                this.f664oT.right = Math.min(this.f664oT.right, this.f650RA.getLeft());
            }
            canvas.clipRect(this.f664oT);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aN */
    public final void mo1240aN(View view) {
        f649RJ.mo1236a(this, view);
    }

    /* renamed from: G */
    private boolean m1087G(float f) {
        if (!this.mCanSlide) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.f650RA.getLayoutParams();
        if (mo1247eR()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.f653RD) * f)) + ((float) this.f650RA.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.f653RD) * f));
        }
        if (!this.f656RG.mo1325h(this.f650RA, width, this.f650RA.getTop())) {
            return false;
        }
        mo1246eP();
        C0477s.m891R(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f656RG.mo1322eX()) {
            return;
        }
        if (this.mCanSlide) {
            C0477s.m891R(this);
        } else {
            this.f656RG.abort();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f661Rx = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f662Ry = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(C0380b.m649g(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(C0380b.m649g(getContext(), i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (mo1247eR()) {
            drawable = this.f662Ry;
        } else {
            drawable = this.f661Rx;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (mo1247eR()) {
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
    /* renamed from: H */
    public final void mo1237H(float f) {
        Object obj;
        int childCount;
        int i;
        boolean eR = mo1247eR();
        LayoutParams layoutParams = (LayoutParams) this.f650RA.getLayoutParams();
        if (layoutParams.f645RN) {
            if ((eR ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt != this.f650RA) {
                        int i2 = (int) ((1.0f - this.f652RC) * ((float) this.f654RE));
                        this.f652RC = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.f654RE));
                        if (eR) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj != null) {
                            float f2;
                            if (eR) {
                                f2 = this.f652RC - 1.0f;
                            } else {
                                f2 = 1.0f - this.f652RC;
                            }
                            mo1238a(childAt, f2, this.f660Rw);
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
    /* renamed from: aO */
    public final boolean mo1241aO(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).f645RN && this.f651RB > 0.0f;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.mCanSlide ? !this.mCanSlide || this.f651RB == 1.0f : this.f657RH;
        savedState.f665RP = z;
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.f507LC);
            if (!savedState.f665RP) {
                m1088eQ();
            } else if (this.mFirstLayout || m1087G(1.0f)) {
                this.f657RH = true;
            }
            this.f657RH = savedState.f665RP;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eR */
    public final boolean mo1247eR() {
        return C0477s.m893T(this) == 1;
    }
}

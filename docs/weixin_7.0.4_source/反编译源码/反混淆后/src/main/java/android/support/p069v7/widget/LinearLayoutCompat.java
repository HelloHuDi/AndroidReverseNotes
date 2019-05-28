package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.smtt.sdk.WebView;

/* renamed from: android.support.v7.widget.LinearLayoutCompat */
public class LinearLayoutCompat extends ViewGroup {
    /* renamed from: Hu */
    private int f998Hu;
    private Drawable ahS;
    private boolean aln;
    private int alo;
    private int alp;
    private int alq;
    private float alr;
    private boolean als;
    private int[] alt;
    private int[] alu;
    private int alv;
    private int alw;
    private int alx;
    private int aly;
    private int mOrientation;

    /* renamed from: android.support.v7.widget.LinearLayoutCompat$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(3, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aln = true;
        this.alo = -1;
        this.alp = 0;
        this.f998Hu = 8388659;
        C0699bc a = C0699bc.m1555a(context, attributeSet, C0554a.LinearLayoutCompat, i, 0);
        int i2 = a.getInt(1, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        i2 = a.getInt(0, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z = a.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.alr = a.getFloat(4, -1.0f);
        this.alo = a.getInt(3, -1);
        this.als = a.getBoolean(6, false);
        setDividerDrawable(a.getDrawable(5));
        this.alx = a.getInt(7, 0);
        this.aly = a.getDimensionPixelSize(8, 0);
        a.atG.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.alx) {
            requestLayout();
        }
        this.alx = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.alx;
    }

    public Drawable getDividerDrawable() {
        return this.ahS;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.ahS) {
            this.ahS = drawable;
            if (drawable != null) {
                this.alv = drawable.getIntrinsicWidth();
                this.alw = drawable.getIntrinsicHeight();
            } else {
                this.alv = 0;
                this.alw = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.aly = i;
    }

    public int getDividerPadding() {
        return this.aly;
    }

    public int getDividerWidth() {
        return this.alv;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (this.ahS != null) {
            int virtualChildCount;
            int i;
            View childAt;
            int height;
            LayoutParams layoutParams;
            if (this.mOrientation == 1) {
                virtualChildCount = getVirtualChildCount();
                i = 0;
                while (i < virtualChildCount) {
                    View childAt2 = getChildAt(i);
                    if (!(childAt2 == null || childAt2.getVisibility() == 8 || !mo1710bV(i))) {
                        m1389b(canvas, (childAt2.getTop() - ((LayoutParams) childAt2.getLayoutParams()).topMargin) - this.alw);
                    }
                    i++;
                }
                if (mo1710bV(virtualChildCount)) {
                    childAt = getChildAt(virtualChildCount - 1);
                    if (childAt == null) {
                        height = (getHeight() - getPaddingBottom()) - this.alw;
                    } else {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                        height = layoutParams.bottomMargin + childAt.getBottom();
                    }
                    m1389b(canvas, height);
                    return;
                }
                return;
            }
            virtualChildCount = getVirtualChildCount();
            boolean bW = C0709bk.m1576bW(this);
            i = 0;
            while (i < virtualChildCount) {
                View childAt3 = getChildAt(i);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !mo1710bV(i))) {
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (bW) {
                        height = layoutParams.rightMargin + childAt3.getRight();
                    } else {
                        height = (childAt3.getLeft() - layoutParams.leftMargin) - this.alv;
                    }
                    m1390c(canvas, height);
                }
                i++;
            }
            if (mo1710bV(virtualChildCount)) {
                childAt = getChildAt(virtualChildCount - 1);
                if (childAt != null) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (bW) {
                        height = (childAt.getLeft() - layoutParams.leftMargin) - this.alv;
                    } else {
                        height = layoutParams.rightMargin + childAt.getRight();
                    }
                } else if (bW) {
                    height = getPaddingLeft();
                } else {
                    height = (getWidth() - getPaddingRight()) - this.alv;
                }
                m1390c(canvas, height);
            }
        }
    }

    /* renamed from: b */
    private void m1389b(Canvas canvas, int i) {
        this.ahS.setBounds(getPaddingLeft() + this.aly, i, (getWidth() - getPaddingRight()) - this.aly, this.alw + i);
        this.ahS.draw(canvas);
    }

    /* renamed from: c */
    private void m1390c(Canvas canvas, int i) {
        this.ahS.setBounds(i, getPaddingTop() + this.aly, this.alv + i, (getHeight() - getPaddingBottom()) - this.aly);
        this.ahS.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.aln = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.als = z;
    }

    public int getBaseline() {
        if (this.alo < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.alo) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.alo);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.alp;
            if (this.mOrientation == 1) {
                i = this.f998Hu & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.alq) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.alq;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.alo == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.alo;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.alo = i;
    }

    /* Access modifiers changed, original: 0000 */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.alr;
    }

    public void setWeightSum(float f) {
        this.alr = Math.max(0.0f, f);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            int i3;
            int i4;
            int i5;
            int i6;
            Object obj;
            Object obj2;
            int i7;
            int measuredWidth;
            int max;
            int i8;
            LayoutParams layoutParams;
            this.alq = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            Object obj3 = 1;
            float f = 0.0f;
            int virtualChildCount = getVirtualChildCount();
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            Object obj4 = null;
            Object obj5 = null;
            int i13 = this.alo;
            boolean z = this.als;
            int i14 = 0;
            int i15 = 0;
            while (i15 < virtualChildCount) {
                View childAt = getChildAt(i15);
                if (childAt == null) {
                    this.alq += 0;
                    i3 = i15;
                } else {
                    Object obj6;
                    Object obj7;
                    if (childAt.getVisibility() != 8) {
                        if (mo1710bV(i15)) {
                            this.alq += this.alw;
                        }
                        LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                        float f2 = f + layoutParams2.weight;
                        if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                            i4 = this.alq;
                            this.alq = Math.max(i4, (layoutParams2.topMargin + i4) + layoutParams2.bottomMargin);
                            obj5 = 1;
                            i3 = i14;
                        } else {
                            i4 = C8415j.INVALID_ID;
                            if (layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                                i4 = 0;
                                layoutParams2.height = -2;
                            }
                            i5 = i4;
                            m1391h(childAt, i, 0, i2, f2 == 0.0f ? this.alq : 0);
                            if (i5 != Integer.MIN_VALUE) {
                                layoutParams2.height = i5;
                            }
                            i4 = childAt.getMeasuredHeight();
                            i6 = this.alq;
                            this.alq = Math.max(i6, (((i6 + i4) + layoutParams2.topMargin) + layoutParams2.bottomMargin) + 0);
                            if (z) {
                                i3 = Math.max(i4, i14);
                            } else {
                                i3 = i14;
                            }
                        }
                        if (i13 >= 0 && i13 == i15 + 1) {
                            this.alp = this.alq;
                        }
                        if (i15 >= i13 || layoutParams2.weight <= 0.0f) {
                            obj = null;
                            if (mode == 1073741824 || layoutParams2.width != -1) {
                                obj2 = obj4;
                            } else {
                                obj2 = 1;
                                obj = 1;
                            }
                            i7 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                            measuredWidth = childAt.getMeasuredWidth() + i7;
                            i9 = Math.max(i9, measuredWidth);
                            i14 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
                            obj6 = (obj3 == null || layoutParams2.width != -1) ? null : 1;
                            if (layoutParams2.weight > 0.0f) {
                                if (obj != null) {
                                    i4 = i7;
                                } else {
                                    i4 = measuredWidth;
                                }
                                max = Math.max(i12, i4);
                                i4 = i3;
                                obj7 = obj5;
                                f = f2;
                                i10 = i14;
                            } else {
                                if (obj == null) {
                                    i7 = measuredWidth;
                                }
                                int max2 = Math.max(i11, i7);
                                i4 = i3;
                                obj7 = obj5;
                                f = f2;
                                max = i12;
                                i11 = max2;
                                i10 = i14;
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                    i4 = i14;
                    obj7 = obj5;
                    obj2 = obj4;
                    obj6 = obj3;
                    max = i12;
                    i3 = i15 + 0;
                    i14 = i4;
                    obj5 = obj7;
                    obj4 = obj2;
                    obj3 = obj6;
                    i12 = max;
                }
                i15 = i3 + 1;
            }
            if (this.alq > 0 && mo1710bV(virtualChildCount)) {
                this.alq += this.alw;
            }
            if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                this.alq = 0;
                i8 = 0;
                while (i8 < virtualChildCount) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2 == null) {
                        this.alq += 0;
                        i4 = i8;
                    } else if (childAt2.getVisibility() == 8) {
                        i4 = i8 + 0;
                    } else {
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        i6 = this.alq;
                        this.alq = Math.max(i6, (layoutParams.bottomMargin + ((i6 + i14) + layoutParams.topMargin)) + 0);
                        i4 = i8;
                    }
                    i8 = i4 + 1;
                }
            }
            this.alq += getPaddingTop() + getPaddingBottom();
            i5 = View.resolveSizeAndState(Math.max(this.alq, getSuggestedMinimumHeight()), i2, 0);
            i7 = (16777215 & i5) - this.alq;
            int i16;
            if (obj5 != null || (i7 != 0 && f > 0.0f)) {
                if (this.alr > 0.0f) {
                    f = this.alr;
                }
                this.alq = 0;
                i15 = 0;
                float f3 = f;
                obj5 = obj3;
                i16 = i11;
                i14 = i10;
                i12 = i9;
                while (i15 < virtualChildCount) {
                    float f4;
                    View childAt3 = getChildAt(i15);
                    if (childAt3.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt3.getLayoutParams();
                        float f5 = layoutParams.weight;
                        if (f5 > 0.0f) {
                            View view;
                            i8 = (int) ((((float) i7) * f5) / f3);
                            f5 = f3 - f5;
                            max = i7 - i8;
                            i6 = LinearLayoutCompat.getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width);
                            if (layoutParams.height != 0 || mode2 != 1073741824) {
                                i8 += childAt3.getMeasuredHeight();
                                if (i8 < 0) {
                                    i8 = 0;
                                }
                                view = childAt3;
                            } else if (i8 > 0) {
                                view = childAt3;
                            } else {
                                i8 = 0;
                                view = childAt3;
                            }
                            view.measure(i6, MeasureSpec.makeMeasureSpec(i8, ErrorDialogData.SUPPRESSED));
                            f4 = f5;
                            i7 = max;
                            i14 = View.combineMeasuredStates(i14, childAt3.getMeasuredState() & -256);
                        } else {
                            f4 = f3;
                        }
                        i6 = layoutParams.leftMargin + layoutParams.rightMargin;
                        i3 = childAt3.getMeasuredWidth() + i6;
                        max = Math.max(i12, i3);
                        obj3 = (mode == 1073741824 || layoutParams.width != -1) ? null : 1;
                        if (obj3 == null) {
                            i6 = i3;
                        }
                        i3 = Math.max(i16, i6);
                        obj2 = (obj5 == null || layoutParams.width != -1) ? null : 1;
                        int i17 = this.alq;
                        this.alq = Math.max(i17, (layoutParams.bottomMargin + ((childAt3.getMeasuredHeight() + i17) + layoutParams.topMargin)) + 0);
                        obj = obj2;
                        measuredWidth = i3;
                    } else {
                        f4 = f3;
                        obj = obj5;
                        measuredWidth = i16;
                        max = i12;
                    }
                    i15++;
                    f3 = f4;
                    obj5 = obj;
                    i16 = measuredWidth;
                    i12 = max;
                }
                this.alq += getPaddingTop() + getPaddingBottom();
                obj3 = obj5;
                i4 = i16;
                i10 = i14;
                i8 = i12;
            } else {
                i16 = Math.max(i11, i12);
                if (z && mode2 != 1073741824) {
                    i4 = 0;
                    while (true) {
                        i8 = i4;
                        if (i8 >= virtualChildCount) {
                            break;
                        }
                        View childAt4 = getChildAt(i8);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).weight <= 0.0f)) {
                            childAt4.measure(MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(i14, ErrorDialogData.SUPPRESSED));
                        }
                        i4 = i8 + 1;
                    }
                }
                i4 = i16;
                i8 = i9;
            }
            if (obj3 != null || mode == 1073741824) {
                i4 = i8;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(i4 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i10), i5);
            if (obj4 != null) {
                m1387ad(virtualChildCount, i2);
                return;
            }
            return;
        }
        m1388ae(i, i2);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bV */
    public final boolean mo1710bV(int i) {
        if (i == 0) {
            if ((this.alx & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.alx & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.alx & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: ad */
    private void m1387ad(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), ErrorDialogData.SUPPRESSED);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* renamed from: ae */
    private void m1388ae(int i, int i2) {
        Object obj;
        View childAt;
        LayoutParams layoutParams;
        int i3;
        int i4;
        Object obj2;
        int i5;
        int measuredHeight;
        int baseline;
        int i6;
        Object obj3;
        int max;
        Object obj4;
        LayoutParams layoutParams2;
        this.alq = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        Object obj5 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj6 = null;
        Object obj7 = null;
        if (this.alt == null || this.alu == null) {
            this.alt = new int[4];
            this.alu = new int[4];
        }
        int[] iArr = this.alt;
        int[] iArr2 = this.alu;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.aln;
        boolean z2 = this.als;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i11 = 0;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            int i13;
            childAt = getChildAt(i12);
            if (childAt == null) {
                this.alq += 0;
                i13 = i12;
            } else {
                if (childAt.getVisibility() != 8) {
                    if (mo1710bV(i12)) {
                        this.alq += this.alv;
                    }
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    float f2 = f + layoutParams.weight;
                    if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        if (obj != null) {
                            this.alq += layoutParams.leftMargin + layoutParams.rightMargin;
                        } else {
                            i3 = this.alq;
                            this.alq = Math.max(i3, (layoutParams.leftMargin + i3) + layoutParams.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            childAt.measure(i3, i3);
                            i13 = i11;
                        } else {
                            obj7 = 1;
                            i13 = i11;
                        }
                    } else {
                        i3 = C8415j.INVALID_ID;
                        if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                            i3 = 0;
                            layoutParams.width = -2;
                        }
                        int i14 = i3;
                        m1391h(childAt, i, f2 == 0.0f ? this.alq : 0, i2, 0);
                        if (i14 != Integer.MIN_VALUE) {
                            layoutParams.width = i14;
                        }
                        i3 = childAt.getMeasuredWidth();
                        if (obj != null) {
                            this.alq += ((layoutParams.leftMargin + i3) + layoutParams.rightMargin) + 0;
                        } else {
                            i4 = this.alq;
                            this.alq = Math.max(i4, (((i4 + i3) + layoutParams.leftMargin) + layoutParams.rightMargin) + 0);
                        }
                        if (z2) {
                            i13 = Math.max(i3, i11);
                        } else {
                            i13 = i11;
                        }
                    }
                    Object obj8 = null;
                    if (mode2 == 1073741824 || layoutParams.height != -1) {
                        obj2 = obj6;
                    } else {
                        obj2 = 1;
                        obj8 = 1;
                    }
                    i5 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = childAt.getMeasuredHeight() + i5;
                    i11 = View.combineMeasuredStates(i8, childAt.getMeasuredState());
                    if (z) {
                        baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            i6 = ((((layoutParams.gravity < 0 ? this.f998Hu : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i6] = Math.max(iArr[i6], baseline);
                            iArr2[i6] = Math.max(iArr2[i6], measuredHeight - baseline);
                        }
                    }
                    i7 = Math.max(i7, measuredHeight);
                    obj3 = (obj5 == null || layoutParams.height != -1) ? null : 1;
                    if (layoutParams.weight > 0.0f) {
                        if (obj8 != null) {
                            i3 = i5;
                        } else {
                            i3 = measuredHeight;
                        }
                        max = Math.max(i10, i3);
                        i3 = i13;
                        obj4 = obj7;
                        f = f2;
                        i8 = i11;
                    } else {
                        if (obj8 == null) {
                            i5 = measuredHeight;
                        }
                        baseline = Math.max(i9, i5);
                        i3 = i13;
                        obj4 = obj7;
                        f = f2;
                        max = i10;
                        i9 = baseline;
                        i8 = i11;
                    }
                } else {
                    i3 = i11;
                    obj4 = obj7;
                    obj2 = obj6;
                    obj3 = obj5;
                    max = i10;
                }
                i13 = i12 + 0;
                i11 = i3;
                obj7 = obj4;
                obj6 = obj2;
                obj5 = obj3;
                i10 = max;
            }
            i12 = i13 + 1;
        }
        if (this.alq > 0 && mo1710bV(virtualChildCount)) {
            this.alq += this.alv;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i4 = i7;
        } else {
            i4 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.alq = 0;
            i6 = 0;
            while (i6 < virtualChildCount) {
                View childAt2 = getChildAt(i6);
                if (childAt2 == null) {
                    this.alq += 0;
                    i3 = i6;
                } else if (childAt2.getVisibility() == 8) {
                    i3 = i6 + 0;
                } else {
                    layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (obj != null) {
                        this.alq = ((layoutParams2.rightMargin + (layoutParams2.leftMargin + i11)) + 0) + this.alq;
                        i3 = i6;
                    } else {
                        i5 = this.alq;
                        this.alq = Math.max(i5, (layoutParams2.rightMargin + ((i5 + i11) + layoutParams2.leftMargin)) + 0);
                        i3 = i6;
                    }
                }
                i6 = i3 + 1;
            }
        }
        this.alq += getPaddingLeft() + getPaddingRight();
        i12 = View.resolveSizeAndState(Math.max(this.alq, getSuggestedMinimumWidth()), i, 0);
        max = (16777215 & i12) - this.alq;
        int i15;
        View childAt3;
        if (obj7 != null || (max != 0 && f > 0.0f)) {
            if (this.alr > 0.0f) {
                f = this.alr;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            i10 = -1;
            this.alq = 0;
            i7 = 0;
            float f3 = f;
            Object obj9 = obj5;
            i15 = i9;
            int i16 = i8;
            while (i7 < virtualChildCount) {
                float f4;
                int i17;
                childAt3 = getChildAt(i7);
                if (childAt3 == null || childAt3.getVisibility() == 8) {
                    f4 = f3;
                    i6 = max;
                    obj4 = obj9;
                    measuredHeight = i15;
                    i17 = i10;
                } else {
                    float f5;
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    f = layoutParams2.weight;
                    if (f > 0.0f) {
                        View view;
                        i6 = (int) ((((float) max) * f) / f3);
                        f5 = f3 - f;
                        max -= i6;
                        measuredHeight = LinearLayoutCompat.getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin, layoutParams2.height);
                        if (layoutParams2.width != 0 || mode != 1073741824) {
                            i6 += childAt3.getMeasuredWidth();
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            view = childAt3;
                        } else if (i6 > 0) {
                            view = childAt3;
                        } else {
                            i6 = 0;
                            view = childAt3;
                        }
                        view.measure(MeasureSpec.makeMeasureSpec(i6, ErrorDialogData.SUPPRESSED), measuredHeight);
                        i16 = View.combineMeasuredStates(i16, childAt3.getMeasuredState() & WebView.NIGHT_MODE_COLOR);
                    } else {
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.alq += ((childAt3.getMeasuredWidth() + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0;
                    } else {
                        i6 = this.alq;
                        this.alq = Math.max(i6, (((childAt3.getMeasuredWidth() + i6) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0);
                    }
                    obj3 = (mode2 == 1073741824 || layoutParams2.height != -1) ? null : 1;
                    i4 = layoutParams2.topMargin + layoutParams2.bottomMargin;
                    measuredHeight = childAt3.getMeasuredHeight() + i4;
                    i17 = Math.max(i10, measuredHeight);
                    if (obj3 != null) {
                        i6 = i4;
                    } else {
                        i6 = measuredHeight;
                    }
                    i15 = Math.max(i15, i6);
                    obj2 = (obj9 == null || layoutParams2.height != -1) ? null : 1;
                    if (z) {
                        i6 = childAt3.getBaseline();
                        if (i6 != -1) {
                            i3 = ((((layoutParams2.gravity < 0 ? this.f998Hu : layoutParams2.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i6);
                            iArr2[i3] = Math.max(iArr2[i3], measuredHeight - i6);
                        }
                    }
                    f4 = f5;
                    i6 = max;
                    obj4 = obj2;
                    measuredHeight = i15;
                }
                i7++;
                f3 = f4;
                max = i6;
                obj9 = obj4;
                i15 = measuredHeight;
                i10 = i17;
            }
            this.alq += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i10 = Math.max(i10, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj5 = obj9;
            i3 = i15;
            i8 = i16;
            i6 = i10;
        } else {
            i15 = Math.max(i9, i10);
            if (z2 && mode != 1073741824) {
                i3 = 0;
                while (true) {
                    i6 = i3;
                    if (i6 >= virtualChildCount) {
                        break;
                    }
                    childAt3 = getChildAt(i6);
                    if (!(childAt3 == null || childAt3.getVisibility() == 8 || ((LayoutParams) childAt3.getLayoutParams()).weight <= 0.0f)) {
                        childAt3.measure(MeasureSpec.makeMeasureSpec(i11, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), ErrorDialogData.SUPPRESSED));
                    }
                    i3 = i6 + 1;
                }
            }
            i3 = i15;
            i6 = i4;
        }
        if (obj5 != null || mode2 == 1073741824) {
            i3 = i6;
        }
        setMeasuredDimension((WebView.NIGHT_MODE_COLOR & i8) | i12, View.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i8 << 16));
        if (obj6 != null) {
            measuredHeight = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), ErrorDialogData.SUPPRESSED);
            i3 = 0;
            while (true) {
                int i18 = i3;
                if (i18 < virtualChildCount) {
                    childAt = getChildAt(i18);
                    if (childAt.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                        if (layoutParams.height == -1) {
                            baseline = layoutParams.width;
                            layoutParams.width = childAt.getMeasuredWidth();
                            measureChildWithMargins(childAt, i, 0, measuredHeight, 0);
                            layoutParams.width = baseline;
                        }
                    }
                    i3 = i18 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static int getChildrenSkipCount$5359dca7() {
        return 0;
    }

    /* renamed from: h */
    private void m1391h(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    private static int getLocationOffset$3c7ec8d0() {
        return 0;
    }

    private static int getNextLocationOffset$3c7ec8d0() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:66:0x01d8, code skipped:
            r6 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int paddingRight;
        int paddingRight2;
        int virtualChildCount;
        int i6;
        int i7;
        int i8;
        int measuredWidth;
        int measuredHeight;
        LayoutParams layoutParams;
        int i9;
        if (this.mOrientation == 1) {
            paddingLeft = getPaddingLeft();
            i5 = i3 - i;
            paddingRight = i5 - getPaddingRight();
            paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
            virtualChildCount = getVirtualChildCount();
            i6 = 8388615 & this.f998Hu;
            switch (this.f998Hu & 112) {
                case 16:
                    i5 = getPaddingTop() + (((i4 - i2) - this.alq) / 2);
                    break;
                case 80:
                    i5 = ((getPaddingTop() + i4) - i2) - this.alq;
                    break;
                default:
                    i5 = getPaddingTop();
                    break;
            }
            i7 = 0;
            i8 = i5;
            while (i7 < virtualChildCount) {
                View childAt = getChildAt(i7);
                if (childAt == null) {
                    i8 += 0;
                    i5 = i7;
                } else if (childAt.getVisibility() != 8) {
                    measuredWidth = childAt.getMeasuredWidth();
                    measuredHeight = childAt.getMeasuredHeight();
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    i9 = layoutParams.gravity;
                    if (i9 < 0) {
                        i9 = i6;
                    }
                    switch (C0456d.getAbsoluteGravity(i9, C0477s.m893T(this)) & 7) {
                        case 1:
                            i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                            break;
                        case 5:
                            i9 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                            break;
                        default:
                            i9 = layoutParams.leftMargin + paddingLeft;
                            break;
                    }
                    if (mo1710bV(i7)) {
                        i8 += this.alw;
                    }
                    i8 += layoutParams.topMargin;
                    LinearLayoutCompat.m1392i(childAt, i9, i8 + 0, measuredWidth, measuredHeight);
                    i8 += (layoutParams.bottomMargin + measuredHeight) + 0;
                    i5 = i7 + 0;
                } else {
                    i5 = i7;
                }
                i7 = i5 + 1;
            }
            return;
        }
        boolean bW = C0709bk.m1576bW(this);
        paddingLeft = getPaddingTop();
        i5 = i4 - i2;
        int paddingBottom = i5 - getPaddingBottom();
        measuredWidth = (i5 - paddingLeft) - getPaddingBottom();
        measuredHeight = getVirtualChildCount();
        i5 = this.f998Hu & 8388615;
        virtualChildCount = this.f998Hu & 112;
        boolean z2 = this.aln;
        int[] iArr = this.alt;
        int[] iArr2 = this.alu;
        switch (C0456d.getAbsoluteGravity(i5, C0477s.m893T(this))) {
            case 1:
                paddingRight = getPaddingLeft() + (((i3 - i) - this.alq) / 2);
                break;
            case 5:
                paddingRight = ((getPaddingLeft() + i3) - i) - this.alq;
                break;
            default:
                paddingRight = getPaddingLeft();
                break;
        }
        i6 = 0;
        if (bW) {
            i6 = measuredHeight - 1;
            i9 = -1;
        } else {
            i9 = 1;
        }
        paddingRight2 = 0;
        while (paddingRight2 < measuredHeight) {
            int i10 = i6 + (i9 * paddingRight2);
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                paddingRight += 0;
                i5 = paddingRight2;
            } else if (childAt2.getVisibility() != 8) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                i8 = -1;
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (z2 && layoutParams.height != -1) {
                    i8 = childAt2.getBaseline();
                }
                i7 = layoutParams.gravity;
                if (i7 < 0) {
                    i7 = virtualChildCount;
                }
                switch (i7 & 112) {
                    case 16:
                        i8 = ((((measuredWidth - measuredHeight2) / 2) + paddingLeft) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i7 = layoutParams.topMargin + paddingLeft;
                        if (i8 != -1) {
                            i8 = (iArr[1] - i8) + i7;
                            break;
                        }
                    case 80:
                        i7 = (paddingBottom - measuredHeight2) - layoutParams.bottomMargin;
                        if (i8 != -1) {
                            i8 = i7 - (iArr2[2] - (childAt2.getMeasuredHeight() - i8));
                            break;
                        }
                    default:
                        i8 = paddingLeft;
                        break;
                }
                if (mo1710bV(i10)) {
                    i7 = this.alv + paddingRight;
                } else {
                    i7 = paddingRight;
                }
                i7 += layoutParams.leftMargin;
                LinearLayoutCompat.m1392i(childAt2, i7 + 0, i8, measuredWidth2, measuredHeight2);
                paddingRight = i7 + ((layoutParams.rightMargin + measuredWidth2) + 0);
                i5 = paddingRight2 + 0;
            } else {
                i5 = paddingRight2;
            }
            paddingRight2 = i5 + 1;
        }
    }

    /* renamed from: i */
    private static void m1392i(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.f998Hu != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f998Hu = i2;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f998Hu;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f998Hu & 8388615) != i2) {
            this.f998Hu = i2 | (this.f998Hu & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f998Hu & 112) != i2) {
            this.f998Hu = i2 | (this.f998Hu & -113);
            requestLayout();
        }
    }

    /* renamed from: g */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: hf */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }
}

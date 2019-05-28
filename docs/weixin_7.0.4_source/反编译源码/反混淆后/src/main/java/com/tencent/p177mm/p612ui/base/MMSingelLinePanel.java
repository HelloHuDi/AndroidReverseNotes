package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.base.MMSingelLinePanel */
public class MMSingelLinePanel extends MMTagPanel {
    static final /* synthetic */ boolean $assertionsDisabled = (!MMSingelLinePanel.class.desiredAssertionStatus());
    private boolean mSingleLine;
    private int ysw;
    private int ysx;
    private LinkedList<Integer> ysy;
    private TextView ywY;
    private int ywZ;
    private int yxa;

    static {
        AppMethodBeat.m2504i(106769);
        AppMethodBeat.m2505o(106769);
    }

    public MMSingelLinePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSingelLinePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106764);
        this.ysy = new LinkedList();
        this.ysw = 0;
        this.ysx = 0;
        this.mSingleLine = true;
        this.ywZ = 0;
        this.yxa = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.FlowLayout);
        try {
            this.ysw = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.ysx = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(106764);
        }
    }

    public final void dzU() {
        AppMethodBeat.m2504i(106765);
        super.dzU();
        this.ywY = new TextView(getContext());
        this.ywY.setText("...");
        this.ywY.setTextColor(getResources().getColor(C25738R.color.a61));
        this.ywY.setLayoutParams(generateDefaultLayoutParams());
        addView(this.ywY);
        AppMethodBeat.m2505o(106765);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.m2504i(106766);
        this.mSingleLine = z;
        this.ywY = new TextView(getContext());
        this.ywY.setText("...");
        this.ywY.setLayoutParams(generateDefaultLayoutParams());
        addView(this.ywY);
        AppMethodBeat.m2505o(106766);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106767);
        if ($assertionsDisabled || MeasureSpec.getMode(i) != 0) {
            int makeMeasureSpec;
            int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            this.ysy.clear();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            if (MeasureSpec.getMode(i2) == C8415j.INVALID_ID) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, C8415j.INVALID_ID);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            }
            if (this.mSingleLine && this.ywY != null) {
                this.ywY.measure(MeasureSpec.makeMeasureSpec(size, C8415j.INVALID_ID), makeMeasureSpec);
                this.ywZ = this.ywY.getMeasuredWidth();
                this.yxa = this.ywY.getMeasuredHeight();
                C4990ab.m7411d("MicroMsg.MMTagContactPanel", "mEllipsisWidth %d", Integer.valueOf(this.ywZ));
            }
            if (this.mSingleLine) {
                size -= this.ywZ;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(size, C8415j.INVALID_ID), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i6 = childAt.getMeasuredHeight();
                    if (i3 + measuredWidth > size) {
                        i3 = 0;
                        i4 += this.ysx + i5;
                        this.ysy.add(Integer.valueOf(i5));
                        i5 = 0;
                    }
                    i5 = Math.max(i5, childAt.getMeasuredHeight());
                    i3 += this.ysw + measuredWidth;
                }
            }
            this.ysy.add(Integer.valueOf(i5));
            if (this.mSingleLine) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == 0) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == C8415j.INVALID_ID && i4 + i5 < size2) {
                getPaddingTop();
                getPaddingBottom();
            }
            setMeasuredDimension(MeasureSpec.getSize(i), i6);
            AppMethodBeat.m2505o(106767);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(106767);
        throw assertionError;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106768);
        int childCount;
        int i5;
        int paddingLeft;
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.mSingleLine) {
            childCount = getChildCount();
            i5 = (i3 - i) - this.ywZ;
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
            i6 = 0;
            i7 = 0;
            i8 = 0;
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 8 || childAt == this.ywY) {
                    i9 = i8;
                    i10 = paddingTop;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if ((paddingLeft + measuredWidth) + getPaddingRight() > i5) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += ((Integer) this.ysy.get(i8)).intValue() + this.ysx;
                        i9 = i8 + 1;
                    } else {
                        i9 = i8;
                    }
                    if (i9 <= 0) {
                        childAt.layout(paddingLeft, paddingTop + 0, paddingLeft + measuredWidth, (paddingTop + 0) + measuredHeight);
                        i8 = (this.ysw + measuredWidth) + paddingLeft;
                        i7 = paddingTop;
                        i6 = i8;
                        i10 = paddingTop;
                        paddingLeft = i8;
                    } else {
                        i10 = paddingTop;
                    }
                }
                i11++;
                i8 = i9;
                paddingTop = i10;
            }
            if (this.ywY != null) {
                if (i8 > 0) {
                    this.ywY.layout(i6, i7, this.ywZ + i6, this.yxa + i7);
                    AppMethodBeat.m2505o(106768);
                    return;
                }
                this.ywY.layout(0, 0, 0, 0);
            }
            AppMethodBeat.m2505o(106768);
            return;
        }
        i10 = getChildCount();
        paddingLeft = i3 - i;
        i9 = getPaddingLeft();
        i7 = getPaddingTop();
        i8 = 0;
        for (i6 = 0; i6 < i10; i6++) {
            View childAt2 = getChildAt(i6);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.ywY)) {
                childCount = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                if ((i9 + childCount) + getPaddingRight() > paddingLeft) {
                    paddingTop = getPaddingLeft();
                    i7 += ((Integer) this.ysy.get(i8)).intValue() + this.ysx;
                    i8++;
                } else {
                    paddingTop = i9;
                }
                i9 = (((Integer) this.ysy.get(i8)).intValue() - i5) / 2;
                childAt2.layout(paddingTop, i7 + i9, paddingTop + childCount, (i9 + i7) + i5);
                i9 = (this.ysw + childCount) + paddingTop;
            }
        }
        AppMethodBeat.m2505o(106768);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}

package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.base.FlowLayout */
public class FlowLayout extends ViewGroup {
    static final /* synthetic */ boolean $assertionsDisabled = (!FlowLayout.class.desiredAssertionStatus());
    private int ysw = 0;
    int ysx = 0;
    LinkedList<Integer> ysy = new LinkedList();

    static {
        AppMethodBeat.m2504i(106276);
        AppMethodBeat.m2505o(106276);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106267);
        m79918d(context, attributeSet);
        AppMethodBeat.m2505o(106267);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106268);
        m79918d(context, attributeSet);
        AppMethodBeat.m2505o(106268);
    }

    /* renamed from: d */
    private void m79918d(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(106269);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.FlowLayout);
        try {
            this.ysw = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.ysx = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(106269);
        }
    }

    public int getLineCount() {
        AppMethodBeat.m2504i(106270);
        int size = this.ysy.size();
        AppMethodBeat.m2505o(106270);
        return size;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106271);
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
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(size, C8415j.INVALID_ID), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
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
            makeMeasureSpec = MeasureSpec.getMode(i2) == 0 ? ((i4 + i5) + getPaddingTop()) + getPaddingBottom() : (MeasureSpec.getMode(i2) != C8415j.INVALID_ID || i4 + i5 >= size2) ? size2 : ((i4 + i5) + getPaddingTop()) + getPaddingBottom();
            setMeasuredDimension(MeasureSpec.getSize(i), makeMeasureSpec);
            AppMethodBeat.m2505o(106271);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(106271);
        throw assertionError;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106272);
        int childCount = getChildCount();
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int paddingLeft2;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if ((paddingLeft + measuredWidth) + getPaddingRight() > i5) {
                    paddingLeft2 = getPaddingLeft();
                    paddingTop += ((Integer) this.ysy.get(i6)).intValue() + this.ysx;
                    i6++;
                } else {
                    paddingLeft2 = paddingLeft;
                }
                paddingLeft = (((Integer) this.ysy.get(i6)).intValue() - measuredHeight) / 2;
                childAt.layout(paddingLeft2, paddingTop + paddingLeft, paddingLeft2 + measuredWidth, (paddingLeft + paddingTop) + measuredHeight);
                paddingLeft = (this.ysw + measuredWidth) + paddingLeft2;
            }
        }
        AppMethodBeat.m2505o(106272);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.m2504i(106273);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        AppMethodBeat.m2505o(106273);
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.m2504i(106274);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.m2505o(106274);
        return layoutParams;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        AppMethodBeat.m2504i(106275);
        LayoutParams layoutParams2 = new LayoutParams(layoutParams.width, layoutParams.height);
        AppMethodBeat.m2505o(106275);
        return layoutParams2;
    }
}

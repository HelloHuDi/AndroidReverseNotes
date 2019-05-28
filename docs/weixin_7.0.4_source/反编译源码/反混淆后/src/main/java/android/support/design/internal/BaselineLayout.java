package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
    /* renamed from: kN */
    private int f15658kN = -1;

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i5 = Math.max(i5, baseline);
                    i4 = Math.max(i4, childAt.getMeasuredHeight() - baseline);
                }
                i7 = Math.max(i7, childAt.getMeasuredWidth());
                i6 = Math.max(i6, childAt.getMeasuredHeight());
                i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
            }
        }
        if (i5 != -1) {
            i6 = Math.max(i6, Math.max(i4, getPaddingBottom()) + i5);
            this.f15658kN = i5;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumWidth()), i, i3), View.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i2, i3 << 16));
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i3 - i) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int i6;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = paddingLeft + ((paddingRight - measuredWidth) / 2);
                if (this.f15658kN == -1 || childAt.getBaseline() == -1) {
                    i6 = paddingTop;
                } else {
                    i6 = (this.f15658kN + paddingTop) - childAt.getBaseline();
                }
                childAt.layout(i7, i6, measuredWidth + i7, measuredHeight + i6);
            }
        }
    }

    public int getBaseline() {
        return this.f15658kN;
    }
}

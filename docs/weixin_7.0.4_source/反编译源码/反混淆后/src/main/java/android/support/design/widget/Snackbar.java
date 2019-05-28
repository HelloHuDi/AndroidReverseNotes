package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.C0256b.C0263e;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

public final class Snackbar extends C0256b<Snackbar> {

    public static final class SnackbarLayout extends C0263e {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(measuredWidth, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), ErrorDialogData.SUPPRESSED));
                }
            }
        }
    }
}

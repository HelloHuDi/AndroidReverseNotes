package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class ButtonBarLayout extends LinearLayout {
    private boolean agK;
    private int agL = -1;
    private int agM = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.ButtonBarLayout);
        this.agK = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.agK != z) {
            this.agK = z;
            if (!this.agK && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int size = MeasureSpec.getSize(i);
        if (this.agK) {
            if (size > this.agL && hQ()) {
                setStacked(false);
            }
            this.agL = size;
        }
        if (hQ() || MeasureSpec.getMode(i) != ErrorDialogData.SUPPRESSED) {
            z = false;
            i3 = i;
        } else {
            i3 = MeasureSpec.makeMeasureSpec(size, j.INVALID_ID);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.agK && !hQ()) {
            boolean z2;
            if ((getMeasuredWidthAndState() & WebView.NIGHT_MODE_COLOR) == 16777216) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int bG = bG(0);
        if (bG >= 0) {
            View childAt = getChildAt(bG);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            size = (layoutParams.bottomMargin + ((childAt.getMeasuredHeight() + getPaddingTop()) + layoutParams.topMargin)) + 0;
            if (hQ()) {
                bG = bG(bG + 1);
                if (bG >= 0) {
                    size += getChildAt(bG).getPaddingTop() + ((int) (16.0f * getResources().getDisplayMetrics().density));
                }
            } else {
                size += getPaddingBottom();
            }
        } else {
            size = 0;
        }
        if (s.aa(this) != size) {
            setMinimumHeight(size);
        }
    }

    private int bG(int i) {
        int childCount = getChildCount();
        for (int i2 = i; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                return i2;
            }
        }
        return -1;
    }

    public int getMinimumHeight() {
        return Math.max(this.agM, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(R.id.jd);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean hQ() {
        return getOrientation() == 1;
    }
}

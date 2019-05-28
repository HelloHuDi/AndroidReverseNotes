package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.smtt.sdk.WebView;

/* renamed from: android.support.v7.widget.ButtonBarLayout */
public class ButtonBarLayout extends LinearLayout {
    private boolean agK;
    private int agL = -1;
    private int agM = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.ButtonBarLayout);
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
            if (size > this.agL && m14843hQ()) {
                setStacked(false);
            }
            this.agL = size;
        }
        if (m14843hQ() || MeasureSpec.getMode(i) != ErrorDialogData.SUPPRESSED) {
            z = false;
            i3 = i;
        } else {
            i3 = MeasureSpec.makeMeasureSpec(size, C8415j.INVALID_ID);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.agK && !m14843hQ()) {
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
        int bG = m14842bG(0);
        if (bG >= 0) {
            View childAt = getChildAt(bG);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            size = (layoutParams.bottomMargin + ((childAt.getMeasuredHeight() + getPaddingTop()) + layoutParams.topMargin)) + 0;
            if (m14843hQ()) {
                bG = m14842bG(bG + 1);
                if (bG >= 0) {
                    size += getChildAt(bG).getPaddingTop() + ((int) (16.0f * getResources().getDisplayMetrics().density));
                }
            } else {
                size += getPaddingBottom();
            }
        } else {
            size = 0;
        }
        if (C0477s.m909aa(this) != size) {
            setMinimumHeight(size);
        }
    }

    /* renamed from: bG */
    private int m14842bG(int i) {
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
        View findViewById = findViewById(2131820917);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* renamed from: hQ */
    private boolean m14843hQ() {
        return getOrientation() == 1;
    }
}

package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.support.design.widget.b.b;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;

public class SnackbarContentLayout extends LinearLayout implements b {
    private int di;
    private TextView ma;
    private Button mb;
    private int mc;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.SnackbarLayout);
        this.di = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.mc = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        obtainStyledAttributes.recycle();
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.ma = (TextView) findViewById(R.id.b9j);
        this.mb = (Button) findViewById(R.id.b9k);
    }

    public TextView getMessageView() {
        return this.ma;
    }

    public Button getActionView() {
        return this.mb;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.di > 0 && getMeasuredWidth() > this.di) {
            i = MeasureSpec.makeMeasureSpec(this.di, ErrorDialogData.SUPPRESSED);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.aw);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.z6);
        int i3 = this.ma.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.mc <= 0 || this.mb.getMeasuredWidth() <= this.mc) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (f(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (f(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }

    private boolean f(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.ma.getPaddingTop() == i2 && this.ma.getPaddingBottom() == i3) {
            return z;
        }
        a(this.ma, i2, i3);
        return true;
    }

    private static void a(View view, int i, int i2) {
        if (s.an(view)) {
            s.d(view, s.W(view), i, s.X(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    public final void bw() {
        this.ma.setAlpha(0.0f);
        this.ma.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        if (this.mb.getVisibility() == 0) {
            this.mb.setAlpha(0.0f);
            this.mb.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        }
    }

    public final void bx() {
        this.ma.setAlpha(1.0f);
        this.ma.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        if (this.mb.getVisibility() == 0) {
            this.mb.setAlpha(1.0f);
            this.mb.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        }
    }
}

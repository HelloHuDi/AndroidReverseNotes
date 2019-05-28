package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C37097a.C37096a;
import android.support.design.widget.C0256b.C0269b;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;

public class SnackbarContentLayout extends LinearLayout implements C0269b {
    /* renamed from: di */
    private int f5060di;
    /* renamed from: ma */
    private TextView f5061ma;
    /* renamed from: mb */
    private Button f5062mb;
    /* renamed from: mc */
    private int f5063mc;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.SnackbarLayout);
        this.f5060di = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f5063mc = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        obtainStyledAttributes.recycle();
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f5061ma = (TextView) findViewById(2131823265);
        this.f5062mb = (Button) findViewById(2131823266);
    }

    public TextView getMessageView() {
        return this.f5061ma;
    }

    public Button getActionView() {
        return this.f5062mb;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f5060di > 0 && getMeasuredWidth() > this.f5060di) {
            i = MeasureSpec.makeMeasureSpec(this.f5060di, ErrorDialogData.SUPPRESSED);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9672aw);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.f10363z6);
        int i3 = this.f5061ma.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.f5063mc <= 0 || this.f5062mb.getMeasuredWidth() <= this.f5063mc) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (m39886f(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (m39886f(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: f */
    private boolean m39886f(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.f5061ma.getPaddingTop() == i2 && this.f5061ma.getPaddingBottom() == i3) {
            return z;
        }
        m39885a(this.f5061ma, i2, i3);
        return true;
    }

    /* renamed from: a */
    private static void m39885a(View view, int i, int i2) {
        if (C0477s.m922an(view)) {
            C0477s.m939d(view, C0477s.m896W(view), i, C0477s.m897X(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    /* renamed from: bw */
    public final void mo444bw() {
        this.f5061ma.setAlpha(0.0f);
        this.f5061ma.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        if (this.f5062mb.getVisibility() == 0) {
            this.f5062mb.setAlpha(0.0f);
            this.f5062mb.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        }
    }

    /* renamed from: bx */
    public final void mo445bx() {
        this.f5061ma.setAlpha(1.0f);
        this.f5061ma.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        if (this.f5062mb.getVisibility() == 0) {
            this.f5062mb.setAlpha(1.0f);
            this.f5062mb.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        }
    }
}

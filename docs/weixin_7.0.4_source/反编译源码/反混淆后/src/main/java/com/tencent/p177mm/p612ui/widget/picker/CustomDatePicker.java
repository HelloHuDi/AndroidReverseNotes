package com.tencent.p177mm.p612ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.picker.YADatePicker.C16012c;
import com.tencent.p177mm.p612ui.widget.picker.YADatePicker.C44398d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.mm.ui.widget.picker.CustomDatePicker */
public class CustomDatePicker extends YADatePicker {
    private Date jkA;
    private Calendar jkB;
    private String[] jkC;
    public boolean jku = true;
    public boolean jkv = true;
    private NumberPicker jkw;
    private NumberPicker jkx;
    private NumberPicker jky;
    private Date jkz;

    /* renamed from: com.tencent.mm.ui.widget.picker.CustomDatePicker$1 */
    class C56671 implements OnValueChangeListener {
        C56671() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            AppMethodBeat.m2504i(112781);
            CustomDatePicker.m24314a(CustomDatePicker.this);
            AppMethodBeat.m2505o(112781);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24314a(CustomDatePicker customDatePicker) {
        AppMethodBeat.m2504i(112796);
        customDatePicker.aRJ();
        AppMethodBeat.m2505o(112796);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112782);
        initView();
        AppMethodBeat.m2505o(112782);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112783);
        initView();
        AppMethodBeat.m2505o(112783);
    }

    private void initView() {
        AppMethodBeat.m2504i(112784);
        this.jkC = new String[12];
        for (int i = 0; i < this.jkC.length; i++) {
            this.jkC[i] = (i + 1);
        }
        this.jkB = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.jkw = ((C16012c) getUIDelegate()).zSP;
        this.jkx = ((C16012c) getUIDelegate()).zSO;
        this.jky = ((C16012c) getUIDelegate()).zSN;
        dLk();
        C24104e.m37072c(this.jkw);
        C24104e.m37072c(this.jkx);
        C24104e.m37072c(this.jky);
        C56671 c56671 = new C56671();
        if (this.jkw != null) {
            this.jkw.setOnValueChangedListener(c56671);
            this.jkw.setMinValue(1900);
        }
        if (this.jkx != null) {
            this.jkx.setOnValueChangedListener(c56671);
        }
        if (this.jky != null) {
            this.jky.setOnValueChangedListener(c56671);
        }
        aRJ();
        C24104e.m37074e(this.jkw);
        C24104e.m37074e(this.jkx);
        C24104e.m37074e(this.jky);
        AppMethodBeat.m2505o(112784);
    }

    private void dLk() {
        AppMethodBeat.m2504i(112785);
        Drawable drawable = getResources().getDrawable(C25738R.drawable.f6961wx);
        C24104e.m37070a(this.jkw, drawable);
        C24104e.m37070a(this.jkx, drawable);
        C24104e.m37070a(this.jky, drawable);
        AppMethodBeat.m2505o(112785);
    }

    /* Access modifiers changed, original: final */
    public final void aRJ() {
        int i = 0;
        AppMethodBeat.m2504i(112786);
        if (this.jkw == null || this.jkx == null || this.jky == null) {
            AppMethodBeat.m2505o(112786);
            return;
        }
        int i2;
        this.jkx.setDisplayedValues(null);
        if (this.jkw.getValue() != this.jkw.getMaxValue() || this.jkA == null) {
            this.jkx.setMaxValue(11);
            i2 = 0;
        } else {
            this.jkx.setMaxValue(this.jkA.getMonth());
            if (this.jkx.getValue() == this.jkx.getMaxValue() && this.jkA != null) {
                this.jky.setMaxValue(this.jkA.getDate());
                i2 = 1;
            }
            i2 = 0;
        }
        if (i2 == 0) {
            this.jkB.set(this.jkw.getValue(), this.jkx.getValue(), 1);
            this.jky.setMaxValue(this.jkB.getActualMaximum(5));
        }
        if (this.jkw.getValue() != this.jkw.getMinValue() || this.jkz == null) {
            this.jkx.setMinValue(0);
        } else {
            this.jkx.setMinValue(this.jkz.getMonth());
            if (this.jkx.getValue() == this.jkx.getMinValue() && this.jkz != null) {
                this.jky.setMinValue(this.jkz.getDate());
                i = 1;
            }
        }
        if (i == 0) {
            this.jky.setMinValue(1);
        }
        this.jkx.setDisplayedValues((String[]) Arrays.copyOfRange(this.jkC, this.jkx.getMinValue(), this.jkx.getMaxValue() + 1));
        this.jkw.setWrapSelectorWheel(true);
        this.jkx.setWrapSelectorWheel(true);
        this.jky.setWrapSelectorWheel(true);
        AppMethodBeat.m2505o(112786);
    }

    public void setMaxDate(long j) {
        AppMethodBeat.m2504i(112787);
        super.setMaxDate(j);
        this.jkA = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMaxValue(this.jkA.getYear() + 1900);
        }
        aRJ();
        AppMethodBeat.m2505o(112787);
    }

    public void setMinDate(long j) {
        AppMethodBeat.m2504i(112788);
        super.setMinDate(j);
        this.jkz = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMinValue(this.jkz.getYear() + 1900);
        }
        AppMethodBeat.m2505o(112788);
    }

    /* renamed from: aA */
    public final void mo28326aA(int i, int i2, int i3) {
        AppMethodBeat.m2504i(112789);
        mo28325a(i, i2, i3, null);
        AppMethodBeat.m2505o(112789);
    }

    /* renamed from: a */
    public final void mo28325a(int i, int i2, int i3, C44398d c44398d) {
        AppMethodBeat.m2504i(112790);
        super.mo28325a(i, Math.max(i2 - 1, 0), i3, c44398d);
        aRJ();
        AppMethodBeat.m2505o(112790);
    }

    public int getYear() {
        AppMethodBeat.m2504i(112791);
        int value;
        if (this.jkw != null) {
            value = this.jkw.getValue();
            AppMethodBeat.m2505o(112791);
            return value;
        }
        value = super.getYear();
        AppMethodBeat.m2505o(112791);
        return value;
    }

    public int getMonth() {
        int value;
        AppMethodBeat.m2504i(112792);
        if (this.jkx != null) {
            value = this.jkx.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        value = Math.max(Math.min(value, 12), 0);
        AppMethodBeat.m2505o(112792);
        return value;
    }

    public int getDayOfMonth() {
        AppMethodBeat.m2504i(112793);
        int value;
        if (this.jky != null) {
            value = this.jky.getValue();
            AppMethodBeat.m2505o(112793);
            return value;
        }
        value = super.getDayOfMonth();
        AppMethodBeat.m2505o(112793);
        return value;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(112794);
        super.onAttachedToWindow();
        C24104e.m37073d(this.jkw);
        C24104e.m37073d(this.jkx);
        C24104e.m37073d(this.jky);
        AppMethodBeat.m2505o(112794);
    }

    /* renamed from: al */
    public final void mo28328al(boolean z, boolean z2) {
        int i = 0;
        AppMethodBeat.m2504i(112795);
        this.jku = z;
        this.jkv = z2;
        if (this.jkw != null) {
            this.jkw.setEnabled(true);
            this.jkw.setVisibility(0);
        }
        if (this.jkx != null) {
            this.jkx.setEnabled(z);
            this.jkx.setVisibility(z ? 0 : 8);
        }
        if (this.jky != null) {
            this.jky.setEnabled(z2);
            NumberPicker numberPicker = this.jky;
            if (!z2) {
                i = 8;
            }
            numberPicker.setVisibility(i);
        }
        AppMethodBeat.m2505o(112795);
    }
}

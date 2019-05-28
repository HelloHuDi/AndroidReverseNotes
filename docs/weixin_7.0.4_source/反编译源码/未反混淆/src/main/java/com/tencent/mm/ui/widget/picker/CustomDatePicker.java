package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

    static /* synthetic */ void a(CustomDatePicker customDatePicker) {
        AppMethodBeat.i(112796);
        customDatePicker.aRJ();
        AppMethodBeat.o(112796);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112782);
        initView();
        AppMethodBeat.o(112782);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112783);
        initView();
        AppMethodBeat.o(112783);
    }

    private void initView() {
        AppMethodBeat.i(112784);
        this.jkC = new String[12];
        for (int i = 0; i < this.jkC.length; i++) {
            this.jkC[i] = (i + 1);
        }
        this.jkB = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.jkw = ((c) getUIDelegate()).zSP;
        this.jkx = ((c) getUIDelegate()).zSO;
        this.jky = ((c) getUIDelegate()).zSN;
        dLk();
        e.c(this.jkw);
        e.c(this.jkx);
        e.c(this.jky);
        AnonymousClass1 anonymousClass1 = new OnValueChangeListener() {
            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                AppMethodBeat.i(112781);
                CustomDatePicker.a(CustomDatePicker.this);
                AppMethodBeat.o(112781);
            }
        };
        if (this.jkw != null) {
            this.jkw.setOnValueChangedListener(anonymousClass1);
            this.jkw.setMinValue(1900);
        }
        if (this.jkx != null) {
            this.jkx.setOnValueChangedListener(anonymousClass1);
        }
        if (this.jky != null) {
            this.jky.setOnValueChangedListener(anonymousClass1);
        }
        aRJ();
        e.e(this.jkw);
        e.e(this.jkx);
        e.e(this.jky);
        AppMethodBeat.o(112784);
    }

    private void dLk() {
        AppMethodBeat.i(112785);
        Drawable drawable = getResources().getDrawable(R.drawable.wx);
        e.a(this.jkw, drawable);
        e.a(this.jkx, drawable);
        e.a(this.jky, drawable);
        AppMethodBeat.o(112785);
    }

    /* Access modifiers changed, original: final */
    public final void aRJ() {
        int i = 0;
        AppMethodBeat.i(112786);
        if (this.jkw == null || this.jkx == null || this.jky == null) {
            AppMethodBeat.o(112786);
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
        AppMethodBeat.o(112786);
    }

    public void setMaxDate(long j) {
        AppMethodBeat.i(112787);
        super.setMaxDate(j);
        this.jkA = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMaxValue(this.jkA.getYear() + 1900);
        }
        aRJ();
        AppMethodBeat.o(112787);
    }

    public void setMinDate(long j) {
        AppMethodBeat.i(112788);
        super.setMinDate(j);
        this.jkz = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMinValue(this.jkz.getYear() + 1900);
        }
        AppMethodBeat.o(112788);
    }

    public final void aA(int i, int i2, int i3) {
        AppMethodBeat.i(112789);
        a(i, i2, i3, null);
        AppMethodBeat.o(112789);
    }

    public final void a(int i, int i2, int i3, d dVar) {
        AppMethodBeat.i(112790);
        super.a(i, Math.max(i2 - 1, 0), i3, dVar);
        aRJ();
        AppMethodBeat.o(112790);
    }

    public int getYear() {
        AppMethodBeat.i(112791);
        int value;
        if (this.jkw != null) {
            value = this.jkw.getValue();
            AppMethodBeat.o(112791);
            return value;
        }
        value = super.getYear();
        AppMethodBeat.o(112791);
        return value;
    }

    public int getMonth() {
        int value;
        AppMethodBeat.i(112792);
        if (this.jkx != null) {
            value = this.jkx.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        value = Math.max(Math.min(value, 12), 0);
        AppMethodBeat.o(112792);
        return value;
    }

    public int getDayOfMonth() {
        AppMethodBeat.i(112793);
        int value;
        if (this.jky != null) {
            value = this.jky.getValue();
            AppMethodBeat.o(112793);
            return value;
        }
        value = super.getDayOfMonth();
        AppMethodBeat.o(112793);
        return value;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(112794);
        super.onAttachedToWindow();
        e.d(this.jkw);
        e.d(this.jkx);
        e.d(this.jky);
        AppMethodBeat.o(112794);
    }

    public final void al(boolean z, boolean z2) {
        int i = 0;
        AppMethodBeat.i(112795);
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
        AppMethodBeat.o(112795);
    }
}

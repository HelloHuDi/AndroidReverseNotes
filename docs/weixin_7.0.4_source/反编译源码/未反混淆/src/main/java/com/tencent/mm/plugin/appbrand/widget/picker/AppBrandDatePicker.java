package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import com.tencent.mm.ui.widget.picker.e;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class AppBrandDatePicker extends YADatePicker implements b<String> {
    private Date jkA;
    private final Calendar jkB;
    private final String[] jkC = new String[12];
    public boolean jku = true;
    public boolean jkv = true;
    public NumberPicker jkw;
    public NumberPicker jkx;
    public NumberPicker jky;
    private Date jkz;
    public boolean jqq = true;

    @Keep
    public AppBrandDatePicker(Context context) {
        super(new ContextThemeWrapper(context, R.style.wg));
        AppMethodBeat.i(126690);
        for (int i = 0; i < this.jkC.length; i++) {
            this.jkC[i] = (i + 1);
        }
        this.jkB = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.jkw = ((c) getUIDelegate()).zSP;
        this.jkx = ((c) getUIDelegate()).zSO;
        this.jky = ((c) getUIDelegate()).zSN;
        Drawable drawable = getResources().getDrawable(R.drawable.cr);
        e.a(this.jkw, drawable);
        e.a(this.jkx, drawable);
        e.a(this.jky, drawable);
        e.c(this.jkw);
        e.c(this.jkx);
        e.c(this.jky);
        e.a(this.jkw);
        e.a(this.jkx);
        e.a(this.jky);
        AnonymousClass1 anonymousClass1 = new OnValueChangeListener() {
            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                AppMethodBeat.i(126689);
                AppBrandDatePicker.a(AppBrandDatePicker.this);
                AppMethodBeat.o(126689);
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
        AppMethodBeat.o(126690);
    }

    private void aRJ() {
        int i = 0;
        AppMethodBeat.i(126691);
        if (this.jkw == null || this.jkx == null || this.jky == null) {
            AppMethodBeat.o(126691);
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
        AppMethodBeat.o(126691);
    }

    public final void setMaxDate(long j) {
        AppMethodBeat.i(126692);
        super.setMaxDate(j);
        this.jkA = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMaxValue(this.jkA.getYear() + 1900);
        }
        AppMethodBeat.o(126692);
    }

    public final void setMinDate(long j) {
        AppMethodBeat.i(126693);
        super.setMinDate(j);
        this.jkz = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMinValue(this.jkz.getYear() + 1900);
        }
        AppMethodBeat.o(126693);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(126694);
        super.onAttachedToWindow();
        e.d(this.jkw);
        e.d(this.jkx);
        e.d(this.jky);
        AppMethodBeat.o(126694);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(126695);
        aRJ();
        AppMethodBeat.o(126695);
    }

    public final void aEH() {
    }

    public final void b(d dVar) {
    }

    public final void aEI() {
    }

    public final void a(int i, int i2, int i3, d dVar) {
        AppMethodBeat.i(126696);
        super.a(i, Math.max(i2 - 1, 0), i3, dVar);
        aRJ();
        AppMethodBeat.o(126696);
    }

    public final int getYear() {
        AppMethodBeat.i(126697);
        int value;
        if (this.jkw != null) {
            value = this.jkw.getValue();
            AppMethodBeat.o(126697);
            return value;
        }
        value = super.getYear();
        AppMethodBeat.o(126697);
        return value;
    }

    public final int getMonth() {
        int value;
        AppMethodBeat.i(126698);
        if (this.jkx != null) {
            value = this.jkx.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        value = Math.max(Math.min(value, 12), 0);
        AppMethodBeat.o(126698);
        return value;
    }

    public final int getDayOfMonth() {
        AppMethodBeat.i(126699);
        int value;
        if (this.jky != null) {
            value = this.jky.getValue();
            AppMethodBeat.o(126699);
            return value;
        }
        value = super.getDayOfMonth();
        AppMethodBeat.o(126699);
        return value;
    }

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.i(126700);
        Object format;
        if (this.jkv) {
            String format2 = String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth())});
            AppMethodBeat.o(126700);
            return format2;
        } else if (this.jku) {
            format = String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth())});
            AppMethodBeat.o(126700);
            return format;
        } else {
            format = String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(getYear())});
            AppMethodBeat.o(126700);
            return format;
        }
    }
}

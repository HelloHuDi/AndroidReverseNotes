package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.picker.C24104e;
import com.tencent.p177mm.p612ui.widget.picker.YADatePicker;
import com.tencent.p177mm.p612ui.widget.picker.YADatePicker.C16012c;
import com.tencent.p177mm.p612ui.widget.picker.YADatePicker.C44398d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C19427b;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker */
public final class AppBrandDatePicker extends YADatePicker implements C19427b<String> {
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

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker$1 */
    class C247121 implements OnValueChangeListener {
        C247121() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            AppMethodBeat.m2504i(126689);
            AppBrandDatePicker.m38577a(AppBrandDatePicker.this);
            AppMethodBeat.m2505o(126689);
        }
    }

    @Keep
    public AppBrandDatePicker(Context context) {
        super(new ContextThemeWrapper(context, C25738R.style.f11314wg));
        AppMethodBeat.m2504i(126690);
        for (int i = 0; i < this.jkC.length; i++) {
            this.jkC[i] = (i + 1);
        }
        this.jkB = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.jkw = ((C16012c) getUIDelegate()).zSP;
        this.jkx = ((C16012c) getUIDelegate()).zSO;
        this.jky = ((C16012c) getUIDelegate()).zSN;
        Drawable drawable = getResources().getDrawable(C25738R.drawable.f6395cr);
        C24104e.m37070a(this.jkw, drawable);
        C24104e.m37070a(this.jkx, drawable);
        C24104e.m37070a(this.jky, drawable);
        C24104e.m37072c(this.jkw);
        C24104e.m37072c(this.jkx);
        C24104e.m37072c(this.jky);
        C2590e.m4839a(this.jkw);
        C2590e.m4839a(this.jkx);
        C2590e.m4839a(this.jky);
        C247121 c247121 = new C247121();
        if (this.jkw != null) {
            this.jkw.setOnValueChangedListener(c247121);
            this.jkw.setMinValue(1900);
        }
        if (this.jkx != null) {
            this.jkx.setOnValueChangedListener(c247121);
        }
        if (this.jky != null) {
            this.jky.setOnValueChangedListener(c247121);
        }
        aRJ();
        C24104e.m37074e(this.jkw);
        C24104e.m37074e(this.jkx);
        C24104e.m37074e(this.jky);
        AppMethodBeat.m2505o(126690);
    }

    private void aRJ() {
        int i = 0;
        AppMethodBeat.m2504i(126691);
        if (this.jkw == null || this.jkx == null || this.jky == null) {
            AppMethodBeat.m2505o(126691);
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
        AppMethodBeat.m2505o(126691);
    }

    public final void setMaxDate(long j) {
        AppMethodBeat.m2504i(126692);
        super.setMaxDate(j);
        this.jkA = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMaxValue(this.jkA.getYear() + 1900);
        }
        AppMethodBeat.m2505o(126692);
    }

    public final void setMinDate(long j) {
        AppMethodBeat.m2504i(126693);
        super.setMinDate(j);
        this.jkz = new Date(j);
        if (this.jkw != null) {
            this.jkw.setMinValue(this.jkz.getYear() + 1900);
        }
        AppMethodBeat.m2505o(126693);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(126694);
        super.onAttachedToWindow();
        C24104e.m37073d(this.jkw);
        C24104e.m37073d(this.jkx);
        C24104e.m37073d(this.jky);
        AppMethodBeat.m2505o(126694);
    }

    public final View getView() {
        return this;
    }

    /* renamed from: a */
    public final void mo22726a(C33642d c33642d) {
        AppMethodBeat.m2504i(126695);
        aRJ();
        AppMethodBeat.m2505o(126695);
    }

    public final void aEH() {
    }

    /* renamed from: b */
    public final void mo22731b(C33642d c33642d) {
    }

    public final void aEI() {
    }

    /* renamed from: a */
    public final void mo28325a(int i, int i2, int i3, C44398d c44398d) {
        AppMethodBeat.m2504i(126696);
        super.mo28325a(i, Math.max(i2 - 1, 0), i3, c44398d);
        aRJ();
        AppMethodBeat.m2505o(126696);
    }

    public final int getYear() {
        AppMethodBeat.m2504i(126697);
        int value;
        if (this.jkw != null) {
            value = this.jkw.getValue();
            AppMethodBeat.m2505o(126697);
            return value;
        }
        value = super.getYear();
        AppMethodBeat.m2505o(126697);
        return value;
    }

    public final int getMonth() {
        int value;
        AppMethodBeat.m2504i(126698);
        if (this.jkx != null) {
            value = this.jkx.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        value = Math.max(Math.min(value, 12), 0);
        AppMethodBeat.m2505o(126698);
        return value;
    }

    public final int getDayOfMonth() {
        AppMethodBeat.m2504i(126699);
        int value;
        if (this.jky != null) {
            value = this.jky.getValue();
            AppMethodBeat.m2505o(126699);
            return value;
        }
        value = super.getDayOfMonth();
        AppMethodBeat.m2505o(126699);
        return value;
    }

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.m2504i(126700);
        Object format;
        if (this.jkv) {
            String format2 = String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth())});
            AppMethodBeat.m2505o(126700);
            return format2;
        } else if (this.jku) {
            format = String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth())});
            AppMethodBeat.m2505o(126700);
            return format;
        } else {
            format = String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(getYear())});
            AppMethodBeat.m2505o(126700);
            return format;
        }
    }
}

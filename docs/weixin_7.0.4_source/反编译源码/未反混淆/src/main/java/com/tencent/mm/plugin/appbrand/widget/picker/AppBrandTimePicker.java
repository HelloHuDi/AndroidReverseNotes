package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;
import com.tencent.mm.ui.widget.picker.e;
import com.tencent.mm.ui.widget.picker.f;
import java.util.Locale;

public final class AppBrandTimePicker extends TimePicker implements b<String> {
    public int hUA = -1;
    public int hUB = -1;
    public int hUy = -1;
    public int hUz = -1;
    public NumberPicker jkY;
    private NumberPicker jkZ;

    @Keep
    public AppBrandTimePicker(Context context) {
        super(new ContextThemeWrapper(context, R.style.wg));
        AppMethodBeat.i(126742);
        setIs24HourView(Boolean.TRUE);
        this.jkY = EL("mHourSpinner");
        this.jkZ = EL("mMinuteSpinner");
        e.c(this.jkY);
        e.c(this.jkZ);
        e.a(this.jkY);
        e.a(this.jkZ);
        Drawable drawable = getResources().getDrawable(R.drawable.cr);
        e.a(this.jkY, drawable);
        e.a(this.jkZ, drawable);
        if (this.jkY != null) {
            this.jkY.setOnValueChangedListener(new OnValueChangeListener() {
                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    AppMethodBeat.i(126741);
                    AppBrandTimePicker.a(AppBrandTimePicker.this);
                    AppMethodBeat.o(126741);
                }
            });
        }
        if (this.jkZ != null && VERSION.SDK_INT >= 21) {
            this.jkZ.setOnValueChangedListener(new OnValueChangeListener() {
                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                }
            });
        }
        e.e(this.jkY);
        e.e(this.jkZ);
        AppMethodBeat.o(126742);
    }

    public final void aRM() {
        AppMethodBeat.i(126743);
        if (f.qS(this.hUy) && f.qR(this.hUz) && this.jkY != null && this.jkZ != null) {
            if (this.jkY.getValue() == this.hUy) {
                this.jkZ.setMinValue(this.hUz);
            } else {
                this.jkZ.setMinValue(0);
            }
        }
        if (!(!f.qS(this.hUA) || this.jkY == null || this.jkZ == null)) {
            if (this.jkY.getValue() == this.hUA) {
                this.jkZ.setMaxValue(this.hUB);
                AppMethodBeat.o(126743);
                return;
            }
            this.jkZ.setMaxValue(59);
        }
        AppMethodBeat.o(126743);
    }

    public final void setCurrentMinute(Integer num) {
        AppMethodBeat.i(126744);
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        aRM();
        AppMethodBeat.o(126744);
    }

    public final void setCurrentHour(Integer num) {
        AppMethodBeat.i(126745);
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        aRM();
        AppMethodBeat.o(126745);
    }

    private NumberPicker EL(String str) {
        AppMethodBeat.i(126746);
        NumberPicker EN;
        if (VERSION.SDK_INT >= 21) {
            EN = EN(str);
            AppMethodBeat.o(126746);
            return EN;
        }
        EN = EM(str);
        AppMethodBeat.o(126746);
        return EN;
    }

    private NumberPicker EM(String str) {
        AppMethodBeat.i(126747);
        try {
            NumberPicker numberPicker = (NumberPicker) new c(this, str, null).get();
            AppMethodBeat.o(126747);
            return numberPicker;
        } catch (Exception e) {
            AppMethodBeat.o(126747);
            return null;
        }
    }

    private NumberPicker EN(String str) {
        AppMethodBeat.i(126748);
        try {
            Object obj = new c(this, "mDelegate", null).get();
            if (obj != null) {
                NumberPicker numberPicker = (NumberPicker) new c(obj, str, null).get();
                AppMethodBeat.o(126748);
                return numberPicker;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(126748);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(126749);
        super.onAttachedToWindow();
        e.d(this.jkY);
        e.d(this.jkZ);
        AppMethodBeat.o(126749);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aEH() {
    }

    public final void b(d dVar) {
    }

    public final void aEI() {
    }

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.i(126750);
        String format = String.format(Locale.US, "%02d:%02d", new Object[]{getCurrentHour(), getCurrentMinute()});
        AppMethodBeat.o(126750);
        return format;
    }
}

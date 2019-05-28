package com.tencent.p177mm.plugin.appbrand.widget.picker;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.p612ui.widget.picker.C24104e;
import com.tencent.p177mm.p612ui.widget.picker.C24105f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C19427b;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker */
public final class AppBrandTimePicker extends TimePicker implements C19427b<String> {
    public int hUA = -1;
    public int hUB = -1;
    public int hUy = -1;
    public int hUz = -1;
    public NumberPicker jkY;
    private NumberPicker jkZ;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker$1 */
    class C25871 implements OnValueChangeListener {
        C25871() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            AppMethodBeat.m2504i(126741);
            AppBrandTimePicker.m84489a(AppBrandTimePicker.this);
            AppMethodBeat.m2505o(126741);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker$2 */
    class C457262 implements OnValueChangeListener {
        C457262() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        }
    }

    @Keep
    public AppBrandTimePicker(Context context) {
        super(new ContextThemeWrapper(context, C25738R.style.f11314wg));
        AppMethodBeat.m2504i(126742);
        setIs24HourView(Boolean.TRUE);
        this.jkY = m84486EL("mHourSpinner");
        this.jkZ = m84486EL("mMinuteSpinner");
        C24104e.m37072c(this.jkY);
        C24104e.m37072c(this.jkZ);
        C2590e.m4839a(this.jkY);
        C2590e.m4839a(this.jkZ);
        Drawable drawable = getResources().getDrawable(C25738R.drawable.f6395cr);
        C24104e.m37070a(this.jkY, drawable);
        C24104e.m37070a(this.jkZ, drawable);
        if (this.jkY != null) {
            this.jkY.setOnValueChangedListener(new C25871());
        }
        if (this.jkZ != null && VERSION.SDK_INT >= 21) {
            this.jkZ.setOnValueChangedListener(new C457262());
        }
        C24104e.m37074e(this.jkY);
        C24104e.m37074e(this.jkZ);
        AppMethodBeat.m2505o(126742);
    }

    public final void aRM() {
        AppMethodBeat.m2504i(126743);
        if (C2591f.m4843qS(this.hUy) && C24105f.m37075qR(this.hUz) && this.jkY != null && this.jkZ != null) {
            if (this.jkY.getValue() == this.hUy) {
                this.jkZ.setMinValue(this.hUz);
            } else {
                this.jkZ.setMinValue(0);
            }
        }
        if (!(!C2591f.m4843qS(this.hUA) || this.jkY == null || this.jkZ == null)) {
            if (this.jkY.getValue() == this.hUA) {
                this.jkZ.setMaxValue(this.hUB);
                AppMethodBeat.m2505o(126743);
                return;
            }
            this.jkZ.setMaxValue(59);
        }
        AppMethodBeat.m2505o(126743);
    }

    public final void setCurrentMinute(Integer num) {
        AppMethodBeat.m2504i(126744);
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        aRM();
        AppMethodBeat.m2505o(126744);
    }

    public final void setCurrentHour(Integer num) {
        AppMethodBeat.m2504i(126745);
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        aRM();
        AppMethodBeat.m2505o(126745);
    }

    /* renamed from: EL */
    private NumberPicker m84486EL(String str) {
        AppMethodBeat.m2504i(126746);
        NumberPicker EN;
        if (VERSION.SDK_INT >= 21) {
            EN = m84488EN(str);
            AppMethodBeat.m2505o(126746);
            return EN;
        }
        EN = m84487EM(str);
        AppMethodBeat.m2505o(126746);
        return EN;
    }

    /* renamed from: EM */
    private NumberPicker m84487EM(String str) {
        AppMethodBeat.m2504i(126747);
        try {
            NumberPicker numberPicker = (NumberPicker) new C1438c(this, str, null).get();
            AppMethodBeat.m2505o(126747);
            return numberPicker;
        } catch (Exception e) {
            AppMethodBeat.m2505o(126747);
            return null;
        }
    }

    /* renamed from: EN */
    private NumberPicker m84488EN(String str) {
        AppMethodBeat.m2504i(126748);
        try {
            Object obj = new C1438c(this, "mDelegate", null).get();
            if (obj != null) {
                NumberPicker numberPicker = (NumberPicker) new C1438c(obj, str, null).get();
                AppMethodBeat.m2505o(126748);
                return numberPicker;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(126748);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(126749);
        super.onAttachedToWindow();
        C24104e.m37073d(this.jkY);
        C24104e.m37073d(this.jkZ);
        AppMethodBeat.m2505o(126749);
    }

    public final View getView() {
        return this;
    }

    /* renamed from: a */
    public final void mo22726a(C33642d c33642d) {
    }

    public final void aEH() {
    }

    /* renamed from: b */
    public final void mo22731b(C33642d c33642d) {
    }

    public final void aEI() {
    }

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.m2504i(126750);
        String format = String.format(Locale.US, "%02d:%02d", new Object[]{getCurrentHour(), getCurrentMinute()});
        AppMethodBeat.m2505o(126750);
        return format;
    }
}

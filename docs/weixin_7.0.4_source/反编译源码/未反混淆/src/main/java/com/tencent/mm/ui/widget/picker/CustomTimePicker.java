package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ai;

public class CustomTimePicker extends TimePicker {
    public int hUA = -1;
    public int hUB = -1;
    public int hUy = -1;
    public int hUz = -1;
    public NumberPicker jkY;
    private NumberPicker jkZ;

    static /* synthetic */ void a(CustomTimePicker customTimePicker) {
        AppMethodBeat.i(112807);
        customTimePicker.aRM();
        AppMethodBeat.o(112807);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.yu), attributeSet);
        AppMethodBeat.i(112798);
        initView();
        AppMethodBeat.o(112798);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112799);
        initView();
        AppMethodBeat.o(112799);
    }

    private void initView() {
        AppMethodBeat.i(112800);
        setIs24HourView(Boolean.TRUE);
        this.jkY = EL("mHourSpinner");
        this.jkZ = EL("mMinuteSpinner");
        e.c(this.jkY);
        e.c(this.jkZ);
        dLk();
        if (this.jkY != null) {
            this.jkY.setOnValueChangedListener(new OnValueChangeListener() {
                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    AppMethodBeat.i(112797);
                    CustomTimePicker.a(CustomTimePicker.this);
                    AppMethodBeat.o(112797);
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
        AppMethodBeat.o(112800);
    }

    public final void aRM() {
        AppMethodBeat.i(112801);
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
                AppMethodBeat.o(112801);
                return;
            }
            this.jkZ.setMaxValue(59);
        }
        AppMethodBeat.o(112801);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(112802);
        super.onAttachedToWindow();
        e.d(this.jkY);
        e.d(this.jkZ);
        AppMethodBeat.o(112802);
    }

    private NumberPicker EL(String str) {
        AppMethodBeat.i(112803);
        NumberPicker EN;
        if (VERSION.SDK_INT >= 21) {
            EN = EN(str);
            AppMethodBeat.o(112803);
            return EN;
        }
        EN = EM(str);
        AppMethodBeat.o(112803);
        return EN;
    }

    private NumberPicker EM(String str) {
        AppMethodBeat.i(112804);
        try {
            NumberPicker numberPicker = (NumberPicker) new ad(this, str).get();
            AppMethodBeat.o(112804);
            return numberPicker;
        } catch (Exception e) {
            AppMethodBeat.o(112804);
            return null;
        }
    }

    private NumberPicker EN(String str) {
        AppMethodBeat.i(112805);
        try {
            Object obj = new ad(this, "mDelegate").get();
            if (obj != null) {
                NumberPicker numberPicker = (NumberPicker) new ad(obj, str).get();
                AppMethodBeat.o(112805);
                return numberPicker;
            }
        } catch (NoSuchFieldException e) {
            ai.printErrStackTrace("CustomTimePicker", e, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
        } catch (IllegalAccessException e2) {
            ai.printErrStackTrace("CustomTimePicker", e2, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
        }
        AppMethodBeat.o(112805);
        return null;
    }

    private void dLk() {
        AppMethodBeat.i(112806);
        Drawable drawable = getResources().getDrawable(R.drawable.wx);
        e.a(this.jkY, drawable);
        e.a(this.jkZ, drawable);
        AppMethodBeat.o(112806);
    }
}

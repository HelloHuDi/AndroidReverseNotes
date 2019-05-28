package com.tencent.p177mm.p612ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C23574ad;
import com.tencent.p177mm.p612ui.C5227ai;

/* renamed from: com.tencent.mm.ui.widget.picker.CustomTimePicker */
public class CustomTimePicker extends TimePicker {
    public int hUA = -1;
    public int hUB = -1;
    public int hUy = -1;
    public int hUz = -1;
    public NumberPicker jkY;
    private NumberPicker jkZ;

    /* renamed from: com.tencent.mm.ui.widget.picker.CustomTimePicker$1 */
    class C160081 implements OnValueChangeListener {
        C160081() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            AppMethodBeat.m2504i(112797);
            CustomTimePicker.m24321a(CustomTimePicker.this);
            AppMethodBeat.m2505o(112797);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.CustomTimePicker$2 */
    class C160092 implements OnValueChangeListener {
        C160092() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24321a(CustomTimePicker customTimePicker) {
        AppMethodBeat.m2504i(112807);
        customTimePicker.aRM();
        AppMethodBeat.m2505o(112807);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, C25738R.style.f11385yu), attributeSet);
        AppMethodBeat.m2504i(112798);
        initView();
        AppMethodBeat.m2505o(112798);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112799);
        initView();
        AppMethodBeat.m2505o(112799);
    }

    private void initView() {
        AppMethodBeat.m2504i(112800);
        setIs24HourView(Boolean.TRUE);
        this.jkY = m24318EL("mHourSpinner");
        this.jkZ = m24318EL("mMinuteSpinner");
        C24104e.m37072c(this.jkY);
        C24104e.m37072c(this.jkZ);
        dLk();
        if (this.jkY != null) {
            this.jkY.setOnValueChangedListener(new C160081());
        }
        if (this.jkZ != null && VERSION.SDK_INT >= 21) {
            this.jkZ.setOnValueChangedListener(new C160092());
        }
        C24104e.m37074e(this.jkY);
        C24104e.m37074e(this.jkZ);
        AppMethodBeat.m2505o(112800);
    }

    public final void aRM() {
        AppMethodBeat.m2504i(112801);
        if (C24105f.m37076qS(this.hUy) && C24105f.m37075qR(this.hUz) && this.jkY != null && this.jkZ != null) {
            if (this.jkY.getValue() == this.hUy) {
                this.jkZ.setMinValue(this.hUz);
            } else {
                this.jkZ.setMinValue(0);
            }
        }
        if (!(!C24105f.m37076qS(this.hUA) || this.jkY == null || this.jkZ == null)) {
            if (this.jkY.getValue() == this.hUA) {
                this.jkZ.setMaxValue(this.hUB);
                AppMethodBeat.m2505o(112801);
                return;
            }
            this.jkZ.setMaxValue(59);
        }
        AppMethodBeat.m2505o(112801);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(112802);
        super.onAttachedToWindow();
        C24104e.m37073d(this.jkY);
        C24104e.m37073d(this.jkZ);
        AppMethodBeat.m2505o(112802);
    }

    /* renamed from: EL */
    private NumberPicker m24318EL(String str) {
        AppMethodBeat.m2504i(112803);
        NumberPicker EN;
        if (VERSION.SDK_INT >= 21) {
            EN = m24320EN(str);
            AppMethodBeat.m2505o(112803);
            return EN;
        }
        EN = m24319EM(str);
        AppMethodBeat.m2505o(112803);
        return EN;
    }

    /* renamed from: EM */
    private NumberPicker m24319EM(String str) {
        AppMethodBeat.m2504i(112804);
        try {
            NumberPicker numberPicker = (NumberPicker) new C23574ad(this, str).get();
            AppMethodBeat.m2505o(112804);
            return numberPicker;
        } catch (Exception e) {
            AppMethodBeat.m2505o(112804);
            return null;
        }
    }

    /* renamed from: EN */
    private NumberPicker m24320EN(String str) {
        AppMethodBeat.m2504i(112805);
        try {
            Object obj = new C23574ad(this, "mDelegate").get();
            if (obj != null) {
                NumberPicker numberPicker = (NumberPicker) new C23574ad(obj, str).get();
                AppMethodBeat.m2505o(112805);
                return numberPicker;
            }
        } catch (NoSuchFieldException e) {
            C5227ai.printErrStackTrace("CustomTimePicker", e, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
        } catch (IllegalAccessException e2) {
            C5227ai.printErrStackTrace("CustomTimePicker", e2, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
        }
        AppMethodBeat.m2505o(112805);
        return null;
    }

    private void dLk() {
        AppMethodBeat.m2504i(112806);
        Drawable drawable = getResources().getDrawable(C25738R.drawable.f6961wx);
        C24104e.m37070a(this.jkY, drawable);
        C24104e.m37070a(this.jkZ, drawable);
        AppMethodBeat.m2505o(112806);
    }
}

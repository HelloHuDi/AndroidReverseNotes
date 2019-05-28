package com.tencent.p177mm.p612ui.base.preference;

import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.preference.b */
final class C40674b {
    /* renamed from: id */
    int f16209id;
    CharSequence text;

    public C40674b(CharSequence charSequence, int i) {
        this.text = charSequence;
        this.f16209id = i;
    }

    /* renamed from: a */
    public final void mo64171a(RadioButton radioButton) {
        AppMethodBeat.m2504i(107144);
        radioButton.setText(this.text);
        radioButton.setId(this.f16209id);
        AppMethodBeat.m2505o(107144);
    }
}

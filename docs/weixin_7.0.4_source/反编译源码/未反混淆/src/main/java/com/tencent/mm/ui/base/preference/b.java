package com.tencent.mm.ui.base.preference;

import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b {
    int id;
    CharSequence text;

    public b(CharSequence charSequence, int i) {
        this.text = charSequence;
        this.id = i;
    }

    public final void a(RadioButton radioButton) {
        AppMethodBeat.i(107144);
        radioButton.setText(this.text);
        radioButton.setId(this.id);
        AppMethodBeat.o(107144);
    }
}

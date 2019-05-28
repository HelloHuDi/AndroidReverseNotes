package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

final class g implements Formatter {
    final StringBuilder mBuilder = new StringBuilder();
    final Object[] zSF = new Object[1];
    char zSG;
    java.util.Formatter zSH;

    g() {
        AppMethodBeat.i(112866);
        d(Locale.getDefault());
        AppMethodBeat.o(112866);
    }

    private void d(Locale locale) {
        AppMethodBeat.i(112867);
        this.zSH = e(locale);
        this.zSG = '0';
        AppMethodBeat.o(112867);
    }

    public final String format(int i) {
        AppMethodBeat.i(112868);
        Locale locale = Locale.getDefault();
        if (this.zSG != '0') {
            d(locale);
        }
        this.zSF[0] = Integer.valueOf(i);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.zSH.format("%02d", this.zSF);
        String formatter = this.zSH.toString();
        AppMethodBeat.o(112868);
        return formatter;
    }

    private java.util.Formatter e(Locale locale) {
        AppMethodBeat.i(112869);
        java.util.Formatter formatter = new java.util.Formatter(this.mBuilder, locale);
        AppMethodBeat.o(112869);
        return formatter;
    }
}

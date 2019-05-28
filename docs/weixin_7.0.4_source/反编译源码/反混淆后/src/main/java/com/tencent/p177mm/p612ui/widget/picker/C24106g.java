package com.tencent.p177mm.p612ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

/* renamed from: com.tencent.mm.ui.widget.picker.g */
final class C24106g implements Formatter {
    final StringBuilder mBuilder = new StringBuilder();
    final Object[] zSF = new Object[1];
    char zSG;
    java.util.Formatter zSH;

    C24106g() {
        AppMethodBeat.m2504i(112866);
        m37077d(Locale.getDefault());
        AppMethodBeat.m2505o(112866);
    }

    /* renamed from: d */
    private void m37077d(Locale locale) {
        AppMethodBeat.m2504i(112867);
        this.zSH = m37078e(locale);
        this.zSG = '0';
        AppMethodBeat.m2505o(112867);
    }

    public final String format(int i) {
        AppMethodBeat.m2504i(112868);
        Locale locale = Locale.getDefault();
        if (this.zSG != '0') {
            m37077d(locale);
        }
        this.zSF[0] = Integer.valueOf(i);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.zSH.format("%02d", this.zSF);
        String formatter = this.zSH.toString();
        AppMethodBeat.m2505o(112868);
        return formatter;
    }

    /* renamed from: e */
    private java.util.Formatter m37078e(Locale locale) {
        AppMethodBeat.m2504i(112869);
        java.util.Formatter formatter = new java.util.Formatter(this.mBuilder, locale);
        AppMethodBeat.m2505o(112869);
        return formatter;
    }
}

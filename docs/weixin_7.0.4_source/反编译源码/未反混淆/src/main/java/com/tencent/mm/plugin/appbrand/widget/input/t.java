package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class t extends r {
    public t(Context context) {
        super(context);
    }

    public final View getInputPanel() {
        AppMethodBeat.i(123738);
        w cN = w.cN(this);
        AppMethodBeat.o(123738);
        return cN;
    }

    public final void setPasswordMode(boolean z) {
        AppMethodBeat.i(123739);
        aRm();
        int inputType = getInputType() | 1;
        if (z) {
            inputType |= 128;
        } else {
            inputType &= -129;
        }
        setInputType(inputType);
        super.setPasswordMode(z);
        aRn();
        AppMethodBeat.o(123739);
    }

    public final void aQR() {
        AppMethodBeat.i(123740);
        try {
            aj.cS(this).restartInput(this);
            AppMethodBeat.o(123740);
        } catch (RuntimeException e) {
            ab.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", e);
            try {
                aj.cS(this).showSoftInput(this, 0);
                AppMethodBeat.o(123740);
            } catch (RuntimeException e2) {
                ab.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", e2);
                AppMethodBeat.o(123740);
            }
        }
    }
}

package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.t */
final class C31335t extends C27417r {
    public C31335t(Context context) {
        super(context);
    }

    public final View getInputPanel() {
        AppMethodBeat.m2504i(123738);
        C38609w cN = C38609w.m65441cN(this);
        AppMethodBeat.m2505o(123738);
        return cN;
    }

    public final void setPasswordMode(boolean z) {
        AppMethodBeat.m2504i(123739);
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
        AppMethodBeat.m2505o(123739);
    }

    public final void aQR() {
        AppMethodBeat.m2504i(123740);
        try {
            C45720aj.m84475cS(this).restartInput(this);
            AppMethodBeat.m2505o(123740);
        } catch (RuntimeException e) {
            C4990ab.m7413e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", e);
            try {
                C45720aj.m84475cS(this).showSoftInput(this, 0);
                AppMethodBeat.m2505o(123740);
            } catch (RuntimeException e2) {
                C4990ab.m7413e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", e2);
                AppMethodBeat.m2505o(123740);
            }
        }
    }
}

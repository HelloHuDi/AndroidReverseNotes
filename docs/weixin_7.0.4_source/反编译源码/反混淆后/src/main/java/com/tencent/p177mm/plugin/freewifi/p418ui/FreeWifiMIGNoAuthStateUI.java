package com.tencent.p177mm.plugin.freewifi.p418ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiMIGNoAuthStateUI */
public class FreeWifiMIGNoAuthStateUI extends FreeWifiNoAuthStateUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bzA() {
        AppMethodBeat.m2504i(21007);
        String string = getString(C25738R.string.czt);
        AppMethodBeat.m2505o(21007);
        return string;
    }
}

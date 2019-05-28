package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FreeWifiMIGNoAuthStateUI extends FreeWifiNoAuthStateUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bzA() {
        AppMethodBeat.i(21007);
        String string = getString(R.string.czt);
        AppMethodBeat.o(21007);
        return string;
    }
}

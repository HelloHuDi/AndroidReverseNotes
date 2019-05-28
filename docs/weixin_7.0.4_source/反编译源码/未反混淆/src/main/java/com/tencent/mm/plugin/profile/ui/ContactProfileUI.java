package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;

public class ContactProfileUI extends DrawStatusBarPreference {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23426);
        super.onCreate(bundle);
        AppMethodBeat.o(23426);
    }

    public final int JC() {
        AppMethodBeat.i(23427);
        int JC = super.JC();
        AppMethodBeat.o(23427);
        return JC;
    }
}

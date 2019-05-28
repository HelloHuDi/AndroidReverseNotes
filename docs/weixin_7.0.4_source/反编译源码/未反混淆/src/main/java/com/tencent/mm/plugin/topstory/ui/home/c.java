package com.tencent.mm.plugin.topstory.ui.home;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class c extends b {
    public c(MMActivity mMActivity) {
        super(mMActivity, true);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(1679);
        super.onCreate(bundle);
        AppMethodBeat.o(1679);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cFE() {
        return false;
    }
}

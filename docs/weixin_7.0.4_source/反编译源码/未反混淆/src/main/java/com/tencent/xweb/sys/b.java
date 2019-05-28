package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements com.tencent.xweb.c.b.b {
    CookieSyncManager APF;

    public final void init(Context context) {
        AppMethodBeat.i(84647);
        this.APF = CookieSyncManager.createInstance(context);
        AppMethodBeat.o(84647);
    }

    public final void sync() {
        AppMethodBeat.i(84648);
        if (this.APF != null) {
            this.APF.sync();
        }
        AppMethodBeat.o(84648);
    }
}

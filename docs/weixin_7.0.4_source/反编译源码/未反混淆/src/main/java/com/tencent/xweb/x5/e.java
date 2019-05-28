package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.xweb.c.b.b;

public final class e implements b {
    CookieSyncManager AQs;

    public final void init(Context context) {
        AppMethodBeat.i(84806);
        this.AQs = CookieSyncManager.createInstance(context);
        AppMethodBeat.o(84806);
    }

    public final void sync() {
        AppMethodBeat.i(84807);
        if (this.AQs != null) {
            this.AQs.sync();
        }
        AppMethodBeat.o(84807);
    }
}

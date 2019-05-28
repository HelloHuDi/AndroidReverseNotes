package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.b;
import org.xwalk.core.XWalkCookieManager;

public final class e implements b {
    XWalkCookieManager ARR = new XWalkCookieManager();

    public e() {
        AppMethodBeat.i(85214);
        AppMethodBeat.o(85214);
    }

    public final void init(Context context) {
    }

    public final void sync() {
        AppMethodBeat.i(85215);
        if (this.ARR != null) {
            this.ARR.flushCookieStore();
        }
        AppMethodBeat.o(85215);
    }
}

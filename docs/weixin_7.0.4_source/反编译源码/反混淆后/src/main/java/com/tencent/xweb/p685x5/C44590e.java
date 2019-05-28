package com.tencent.xweb.p685x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.xweb.p1115c.C44577b.C36585b;

/* renamed from: com.tencent.xweb.x5.e */
public final class C44590e implements C36585b {
    CookieSyncManager AQs;

    public final void init(Context context) {
        AppMethodBeat.m2504i(84806);
        this.AQs = CookieSyncManager.createInstance(context);
        AppMethodBeat.m2505o(84806);
    }

    public final void sync() {
        AppMethodBeat.m2504i(84807);
        if (this.AQs != null) {
            this.AQs.sync();
        }
        AppMethodBeat.m2505o(84807);
    }
}

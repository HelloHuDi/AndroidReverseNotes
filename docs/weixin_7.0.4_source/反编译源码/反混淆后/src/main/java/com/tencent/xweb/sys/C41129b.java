package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C44577b.C36585b;

/* renamed from: com.tencent.xweb.sys.b */
public final class C41129b implements C36585b {
    CookieSyncManager APF;

    public final void init(Context context) {
        AppMethodBeat.m2504i(84647);
        this.APF = CookieSyncManager.createInstance(context);
        AppMethodBeat.m2505o(84647);
    }

    public final void sync() {
        AppMethodBeat.m2504i(84648);
        if (this.APF != null) {
            this.APF.sync();
        }
        AppMethodBeat.m2505o(84648);
    }
}

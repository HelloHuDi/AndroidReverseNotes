package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C44577b.C36585b;
import org.xwalk.core.XWalkCookieManager;

/* renamed from: com.tencent.xweb.xwalk.e */
public final class C6067e implements C36585b {
    XWalkCookieManager ARR = new XWalkCookieManager();

    public C6067e() {
        AppMethodBeat.m2504i(85214);
        AppMethodBeat.m2505o(85214);
    }

    public final void init(Context context) {
    }

    public final void sync() {
        AppMethodBeat.m2504i(85215);
        if (this.ARR != null) {
            this.ARR.flushCookieStore();
        }
        AppMethodBeat.m2505o(85215);
    }
}

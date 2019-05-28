package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C44577b.C36585b;

/* renamed from: com.tencent.xweb.c */
public final class C24526c {
    private static C24526c ALT;
    static C36585b ALU;

    /* renamed from: jx */
    public static synchronized C24526c m38159jx(Context context) {
        C24526c c24526c;
        synchronized (C24526c.class) {
            AppMethodBeat.m2504i(3801);
            if (ALT == null) {
                ALT = new C24526c(context.getApplicationContext());
            }
            c24526c = ALT;
            AppMethodBeat.m2505o(3801);
        }
        return c24526c;
    }

    public static synchronized C24526c dTT() {
        C24526c c24526c;
        synchronized (C24526c.class) {
            AppMethodBeat.m2504i(3802);
            if (ALT == null) {
                IllegalStateException illegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
                AppMethodBeat.m2505o(3802);
                throw illegalStateException;
            }
            c24526c = ALT;
            AppMethodBeat.m2505o(3802);
        }
        return c24526c;
    }

    private C24526c(Context context) {
        AppMethodBeat.m2504i(3803);
        if (ALU != null) {
            ALU.init(context);
        }
        AppMethodBeat.m2505o(3803);
    }

    public static void sync() {
        AppMethodBeat.m2504i(3804);
        if (ALU != null) {
            ALU.sync();
        }
        AppMethodBeat.m2505o(3804);
    }
}

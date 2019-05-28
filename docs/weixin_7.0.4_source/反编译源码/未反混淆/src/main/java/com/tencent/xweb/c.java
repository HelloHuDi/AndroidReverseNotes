package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.b;

public final class c {
    private static c ALT;
    static b ALU;

    public static synchronized c jx(Context context) {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(3801);
            if (ALT == null) {
                ALT = new c(context.getApplicationContext());
            }
            cVar = ALT;
            AppMethodBeat.o(3801);
        }
        return cVar;
    }

    public static synchronized c dTT() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(3802);
            if (ALT == null) {
                IllegalStateException illegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
                AppMethodBeat.o(3802);
                throw illegalStateException;
            }
            cVar = ALT;
            AppMethodBeat.o(3802);
        }
        return cVar;
    }

    private c(Context context) {
        AppMethodBeat.i(3803);
        if (ALU != null) {
            ALU.init(context);
        }
        AppMethodBeat.o(3803);
    }

    public static void sync() {
        AppMethodBeat.i(3804);
        if (ALU != null) {
            ALU.sync();
        }
        AppMethodBeat.o(3804);
    }
}

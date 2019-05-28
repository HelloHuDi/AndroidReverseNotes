package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.k;
import com.tencent.xweb.xwalk.b;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class w {
    static b ANl;

    public static void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.i(3957);
        if (context == null) {
            try {
                context = XWalkEnvironment.getApplicationContext();
            } catch (Exception e) {
                Log.e("XWebSdk", "clearAllWebViewCache failed: " + e.getMessage());
                AppMethodBeat.o(3957);
                return;
            }
        }
        if (context == null) {
            AppMethodBeat.o(3957);
            return;
        }
        k.f(WebView.getCurWebType()).clearAllWebViewCache(context, z);
        AppMethodBeat.o(3957);
    }

    public static synchronized void a(b bVar) {
        synchronized (w.class) {
            ANl = bVar;
        }
    }

    public static synchronized b dUo() {
        b bVar;
        synchronized (w.class) {
            bVar = ANl;
        }
        return bVar;
    }

    public static synchronized void setSharedPreferenceProvider(e eVar) {
        synchronized (w.class) {
            AppMethodBeat.i(3958);
            XWalkEnvironment.setSharedPreferenceProvider(eVar);
            AppMethodBeat.o(3958);
        }
    }
}

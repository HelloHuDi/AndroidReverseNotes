package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C44581k;
import com.tencent.xweb.xwalk.C6060b;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.w */
public final class C16403w {
    static C6060b ANl;

    public static void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.m2504i(3957);
        if (context == null) {
            try {
                context = XWalkEnvironment.getApplicationContext();
            } catch (Exception e) {
                Log.m81046e("XWebSdk", "clearAllWebViewCache failed: " + e.getMessage());
                AppMethodBeat.m2505o(3957);
                return;
            }
        }
        if (context == null) {
            AppMethodBeat.m2505o(3957);
            return;
        }
        C44581k.m80968f(WebView.getCurWebType()).clearAllWebViewCache(context, z);
        AppMethodBeat.m2505o(3957);
    }

    /* renamed from: a */
    public static synchronized void m25218a(C6060b c6060b) {
        synchronized (C16403w.class) {
            ANl = c6060b;
        }
    }

    public static synchronized C6060b dUo() {
        C6060b c6060b;
        synchronized (C16403w.class) {
            c6060b = ANl;
        }
        return c6060b;
    }

    public static synchronized void setSharedPreferenceProvider(C16384e c16384e) {
        synchronized (C16403w.class) {
            AppMethodBeat.m2504i(3958);
            XWalkEnvironment.setSharedPreferenceProvider(c16384e);
            AppMethodBeat.m2505o(3958);
        }
    }
}

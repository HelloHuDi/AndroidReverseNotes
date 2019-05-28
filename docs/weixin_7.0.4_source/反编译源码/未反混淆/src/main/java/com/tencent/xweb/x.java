package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.k;
import com.tencent.xweb.c.k.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.f;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class x {
    static boolean ANm = false;
    static boolean ANn = false;

    public static void a(Context context, c cVar) {
        AppMethodBeat.i(3959);
        a(context, cVar, null, null, null);
        AppMethodBeat.o(3959);
    }

    public static synchronized void a(Context context, c cVar, e eVar, u uVar, WebViewExtensionListener webViewExtensionListener) {
        synchronized (x.class) {
            AppMethodBeat.i(3960);
            if (cVar != null) {
                Log.SetLogCallBack(cVar);
            }
            if (uVar != null) {
                f.a(uVar);
            }
            if (eVar != null) {
                w.setSharedPreferenceProvider(eVar);
            }
            jz(context);
            if (webViewExtensionListener != null) {
                k.f(d.WV_KIND_CW).initCallback(webViewExtensionListener);
            }
            XWebCoreContentProvider.dUm();
            AppMethodBeat.o(3960);
        }
    }

    public static synchronized void initInterface() {
        synchronized (x.class) {
            AppMethodBeat.i(3961);
            if (ANm) {
                AppMethodBeat.o(3961);
            } else {
                ANm = true;
                a f = k.f(d.WV_KIND_CW);
                if (f != null) {
                    f.initInterface();
                }
                f = k.f(d.WV_KIND_X5);
                if (f != null) {
                    f.initInterface();
                }
                AppMethodBeat.o(3961);
            }
        }
    }

    private static synchronized void jz(Context context) {
        synchronized (x.class) {
            AppMethodBeat.i(3962);
            if (context == null) {
                AppMethodBeat.o(3962);
            } else if (ANn) {
                AppMethodBeat.o(3962);
            } else {
                XWalkEnvironment.init(context);
                a f = k.f(d.WV_KIND_CW);
                if (f != null) {
                    f.initEnviroment(context);
                }
                f = k.f(d.WV_KIND_X5);
                if (f != null) {
                    f.initEnviroment(context);
                }
                ANn = true;
                AppMethodBeat.o(3962);
            }
        }
    }
}

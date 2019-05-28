package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p1115c.C44581k;
import com.tencent.xweb.p1115c.C44581k.C44580a;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C6036c;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.x */
public final class C46838x {
    static boolean ANm = false;
    static boolean ANn = false;

    /* renamed from: a */
    public static void m89072a(Context context, C6036c c6036c) {
        AppMethodBeat.m2504i(3959);
        C46838x.m89073a(context, c6036c, null, null, null);
        AppMethodBeat.m2505o(3959);
    }

    /* renamed from: a */
    public static synchronized void m89073a(Context context, C6036c c6036c, C16384e c16384e, C24531u c24531u, WebViewExtensionListener webViewExtensionListener) {
        synchronized (C46838x.class) {
            AppMethodBeat.m2504i(3960);
            if (c6036c != null) {
                Log.SetLogCallBack(c6036c);
            }
            if (c24531u != null) {
                C24532f.m38168a(c24531u);
            }
            if (c16384e != null) {
                C16403w.setSharedPreferenceProvider(c16384e);
            }
            C46838x.m89074jz(context);
            if (webViewExtensionListener != null) {
                C44581k.m80968f(C44570d.WV_KIND_CW).initCallback(webViewExtensionListener);
            }
            XWebCoreContentProvider.dUm();
            AppMethodBeat.m2505o(3960);
        }
    }

    public static synchronized void initInterface() {
        synchronized (C46838x.class) {
            AppMethodBeat.m2504i(3961);
            if (ANm) {
                AppMethodBeat.m2505o(3961);
            } else {
                ANm = true;
                C44580a f = C44581k.m80968f(C44570d.WV_KIND_CW);
                if (f != null) {
                    f.initInterface();
                }
                f = C44581k.m80968f(C44570d.WV_KIND_X5);
                if (f != null) {
                    f.initInterface();
                }
                AppMethodBeat.m2505o(3961);
            }
        }
    }

    /* renamed from: jz */
    private static synchronized void m89074jz(Context context) {
        synchronized (C46838x.class) {
            AppMethodBeat.m2504i(3962);
            if (context == null) {
                AppMethodBeat.m2505o(3962);
            } else if (ANn) {
                AppMethodBeat.m2505o(3962);
            } else {
                XWalkEnvironment.init(context);
                C44580a f = C44581k.m80968f(C44570d.WV_KIND_CW);
                if (f != null) {
                    f.initEnviroment(context);
                }
                f = C44581k.m80968f(C44570d.WV_KIND_X5);
                if (f != null) {
                    f.initEnviroment(context);
                }
                ANn = true;
                AppMethodBeat.m2505o(3962);
            }
        }
    }
}

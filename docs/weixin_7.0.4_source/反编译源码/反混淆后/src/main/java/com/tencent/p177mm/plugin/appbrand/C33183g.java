package com.tencent.p177mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C27277i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.g */
public final class C33183g {
    private static final Iterator<C33186c> gNa = new C331871();
    private static final Map<String, C33185b> gNb = new HashMap();
    private static final Map<String, C33184d> gNc = new HashMap();
    private static final C27277i<String, C33186c> gNd = new C27277i();
    private static final C27277i<String, C19214a> gNe = new C27277i();

    /* renamed from: com.tencent.mm.plugin.appbrand.g$a */
    public interface C19214a {
        boolean asO();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.g$d */
    public enum C33184d {
        CLOSE,
        BACK,
        HIDE,
        HANG,
        HOME_PRESSED,
        RECENT_APPS_PRESSED,
        LAUNCH_NATIVE_PAGE,
        LAUNCH_MINI_PROGRAM;

        static {
            AppMethodBeat.m2505o(90955);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.g$b */
    public enum C33185b {
        INIT,
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY;

        static {
            AppMethodBeat.m2505o(90952);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.g$c */
    public static class C33186c {
        public void onCreate() {
        }

        public void onDestroy() {
        }

        /* renamed from: a */
        public void mo6074a(C33184d c33184d) {
        }

        public void onResume() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.g$1 */
    static class C331871 implements Iterator<C33186c> {
        C331871() {
        }

        public final /* bridge */ /* synthetic */ Object next() {
            return null;
        }

        public final boolean hasNext() {
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(90971);
        AppMethodBeat.m2505o(90971);
    }

    /* renamed from: a */
    public static void m54274a(String str, C33186c c33186c) {
        AppMethodBeat.m2504i(90956);
        if (TextUtils.isEmpty(str) || c33186c == null) {
            AppMethodBeat.m2505o(90956);
            return;
        }
        gNd.mo44963f(str, c33186c);
        AppMethodBeat.m2505o(90956);
    }

    /* renamed from: wM */
    private static Iterator<C33186c> m54277wM(String str) {
        AppMethodBeat.m2504i(90957);
        Set bC = gNd.mo44961bC(str);
        if (bC != null) {
            Iterator it = bC.iterator();
            AppMethodBeat.m2505o(90957);
            return it;
        }
        Iterator<C33186c> it2 = gNa;
        AppMethodBeat.m2505o(90957);
        return it2;
    }

    /* renamed from: wN */
    public static void m54278wN(String str) {
        AppMethodBeat.m2504i(90958);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90958);
            return;
        }
        Iterator wM = C33183g.m54277wM(str);
        while (wM.hasNext()) {
            ((C33186c) wM.next()).onCreate();
        }
        AppMethodBeat.m2505o(90958);
    }

    /* renamed from: wO */
    public static void m54279wO(String str) {
        AppMethodBeat.m2504i(90959);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90959);
            return;
        }
        Iterator wM = C33183g.m54277wM(str);
        while (wM.hasNext()) {
            ((C33186c) wM.next()).onDestroy();
        }
        AppMethodBeat.m2505o(90959);
    }

    /* renamed from: wP */
    public static void m54280wP(String str) {
        AppMethodBeat.m2504i(90960);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90960);
            return;
        }
        Iterator wM = C33183g.m54277wM(str);
        while (wM.hasNext()) {
            ((C33186c) wM.next()).mo6074a(C33183g.m54286wV(str));
        }
        AppMethodBeat.m2505o(90960);
    }

    /* renamed from: wQ */
    public static void m54281wQ(String str) {
        AppMethodBeat.m2504i(90961);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90961);
            return;
        }
        Iterator wM = C33183g.m54277wM(str);
        while (wM.hasNext()) {
            ((C33186c) wM.next()).onResume();
        }
        AppMethodBeat.m2505o(90961);
    }

    /* renamed from: wR */
    public static void m54282wR(String str) {
        AppMethodBeat.m2504i(90962);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90962);
            return;
        }
        Iterator wM = C33183g.m54277wM(str);
        while (wM.hasNext()) {
            wM.next();
        }
        AppMethodBeat.m2505o(90962);
    }

    /* renamed from: b */
    public static void m54276b(String str, C33186c c33186c) {
        AppMethodBeat.m2504i(90963);
        if (c33186c == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90963);
            return;
        }
        C27277i c27277i = gNd;
        if (c33186c == null) {
            AppMethodBeat.m2505o(90963);
            return;
        }
        Set b = c27277i.mo44960b(str, false);
        if (b != null) {
            synchronized (b) {
                try {
                    b.remove(c33186c);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(90963);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(90963);
    }

    /* renamed from: wS */
    public static boolean m54283wS(String str) {
        AppMethodBeat.m2504i(90964);
        Set<C19214a> bC = gNe.mo44961bC(str);
        if (bC != null) {
            for (C19214a asO : bC) {
                if (asO.asO()) {
                    AppMethodBeat.m2505o(90964);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(90964);
        return false;
    }

    /* renamed from: wT */
    public static void m54284wT(String str) {
        AppMethodBeat.m2504i(90965);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90965);
            return;
        }
        gNd.mo44962bD(str);
        gNe.mo44962bD(str);
        AppMethodBeat.m2505o(90965);
    }

    /* renamed from: wU */
    public static void m54285wU(String str) {
        AppMethodBeat.m2504i(90966);
        C33183g.m54275a(str, C33184d.HIDE);
        AppMethodBeat.m2505o(90966);
    }

    /* renamed from: wV */
    public static C33184d m54286wV(String str) {
        AppMethodBeat.m2504i(90967);
        C33184d c33184d = (C33184d) gNc.get(str);
        if (c33184d == null) {
            c33184d = C33184d.HIDE;
            AppMethodBeat.m2505o(90967);
            return c33184d;
        }
        AppMethodBeat.m2505o(90967);
        return c33184d;
    }

    /* renamed from: a */
    public static void m54275a(String str, C33184d c33184d) {
        AppMethodBeat.m2504i(90968);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90968);
            return;
        }
        gNc.put(str, c33184d);
        AppMethodBeat.m2505o(90968);
    }

    /* renamed from: a */
    public static void m54273a(String str, C33185b c33185b) {
        AppMethodBeat.m2504i(90969);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90969);
            return;
        }
        gNb.put(str, c33185b);
        AppMethodBeat.m2505o(90969);
    }

    /* renamed from: wW */
    public static C33185b m54287wW(String str) {
        AppMethodBeat.m2504i(90970);
        C33185b c33185b = (C33185b) gNb.get(str);
        if (c33185b == null) {
            c33185b = C33185b.INIT;
        }
        AppMethodBeat.m2505o(90970);
        return c33185b;
    }
}

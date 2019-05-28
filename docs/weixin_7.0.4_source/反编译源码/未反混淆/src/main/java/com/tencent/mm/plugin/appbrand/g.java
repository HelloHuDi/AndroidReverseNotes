package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g {
    private static final Iterator<c> gNa = new Iterator<c>() {
        public final /* bridge */ /* synthetic */ Object next() {
            return null;
        }

        public final boolean hasNext() {
            return false;
        }
    };
    private static final Map<String, b> gNb = new HashMap();
    private static final Map<String, d> gNc = new HashMap();
    private static final i<String, c> gNd = new i();
    private static final i<String, a> gNe = new i();

    public interface a {
        boolean asO();
    }

    public enum d {
        CLOSE,
        BACK,
        HIDE,
        HANG,
        HOME_PRESSED,
        RECENT_APPS_PRESSED,
        LAUNCH_NATIVE_PAGE,
        LAUNCH_MINI_PROGRAM;

        static {
            AppMethodBeat.o(90955);
        }
    }

    public enum b {
        INIT,
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY;

        static {
            AppMethodBeat.o(90952);
        }
    }

    public static class c {
        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void a(d dVar) {
        }

        public void onResume() {
        }
    }

    static {
        AppMethodBeat.i(90971);
        AppMethodBeat.o(90971);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(90956);
        if (TextUtils.isEmpty(str) || cVar == null) {
            AppMethodBeat.o(90956);
            return;
        }
        gNd.f(str, cVar);
        AppMethodBeat.o(90956);
    }

    private static Iterator<c> wM(String str) {
        AppMethodBeat.i(90957);
        Set bC = gNd.bC(str);
        if (bC != null) {
            Iterator it = bC.iterator();
            AppMethodBeat.o(90957);
            return it;
        }
        Iterator<c> it2 = gNa;
        AppMethodBeat.o(90957);
        return it2;
    }

    public static void wN(String str) {
        AppMethodBeat.i(90958);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90958);
            return;
        }
        Iterator wM = wM(str);
        while (wM.hasNext()) {
            ((c) wM.next()).onCreate();
        }
        AppMethodBeat.o(90958);
    }

    public static void wO(String str) {
        AppMethodBeat.i(90959);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90959);
            return;
        }
        Iterator wM = wM(str);
        while (wM.hasNext()) {
            ((c) wM.next()).onDestroy();
        }
        AppMethodBeat.o(90959);
    }

    public static void wP(String str) {
        AppMethodBeat.i(90960);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90960);
            return;
        }
        Iterator wM = wM(str);
        while (wM.hasNext()) {
            ((c) wM.next()).a(wV(str));
        }
        AppMethodBeat.o(90960);
    }

    public static void wQ(String str) {
        AppMethodBeat.i(90961);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90961);
            return;
        }
        Iterator wM = wM(str);
        while (wM.hasNext()) {
            ((c) wM.next()).onResume();
        }
        AppMethodBeat.o(90961);
    }

    public static void wR(String str) {
        AppMethodBeat.i(90962);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90962);
            return;
        }
        Iterator wM = wM(str);
        while (wM.hasNext()) {
            wM.next();
        }
        AppMethodBeat.o(90962);
    }

    public static void b(String str, c cVar) {
        AppMethodBeat.i(90963);
        if (cVar == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90963);
            return;
        }
        i iVar = gNd;
        if (cVar == null) {
            AppMethodBeat.o(90963);
            return;
        }
        Set b = iVar.b(str, false);
        if (b != null) {
            synchronized (b) {
                try {
                    b.remove(cVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(90963);
                }
            }
            return;
        }
        AppMethodBeat.o(90963);
    }

    public static boolean wS(String str) {
        AppMethodBeat.i(90964);
        Set<a> bC = gNe.bC(str);
        if (bC != null) {
            for (a asO : bC) {
                if (asO.asO()) {
                    AppMethodBeat.o(90964);
                    return true;
                }
            }
        }
        AppMethodBeat.o(90964);
        return false;
    }

    public static void wT(String str) {
        AppMethodBeat.i(90965);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90965);
            return;
        }
        gNd.bD(str);
        gNe.bD(str);
        AppMethodBeat.o(90965);
    }

    public static void wU(String str) {
        AppMethodBeat.i(90966);
        a(str, d.HIDE);
        AppMethodBeat.o(90966);
    }

    public static d wV(String str) {
        AppMethodBeat.i(90967);
        d dVar = (d) gNc.get(str);
        if (dVar == null) {
            dVar = d.HIDE;
            AppMethodBeat.o(90967);
            return dVar;
        }
        AppMethodBeat.o(90967);
        return dVar;
    }

    public static void a(String str, d dVar) {
        AppMethodBeat.i(90968);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90968);
            return;
        }
        gNc.put(str, dVar);
        AppMethodBeat.o(90968);
    }

    public static void a(String str, b bVar) {
        AppMethodBeat.i(90969);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90969);
            return;
        }
        gNb.put(str, bVar);
        AppMethodBeat.o(90969);
    }

    public static b wW(String str) {
        AppMethodBeat.i(90970);
        b bVar = (b) gNb.get(str);
        if (bVar == null) {
            bVar = b.INIT;
        }
        AppMethodBeat.o(90970);
        return bVar;
    }
}

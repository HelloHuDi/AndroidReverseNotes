package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    private static final SparseArray<a> unE = new SparseArray();
    private static volatile b unF = null;
    private static final byte[] unG = new byte[0];
    public final String appId;
    public final String path;
    public final b unD = cYi();

    public static final class a extends fk {
        private static final com.tencent.mm.sdk.e.c.a fjX = fk.Hm();

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final com.tencent.mm.sdk.e.c.a Ag() {
            return fjX;
        }

        static {
            AppMethodBeat.i(6816);
            AppMethodBeat.o(6816);
        }
    }

    public static final class b extends j<a> {
        public final boolean hrm;

        public b(e eVar) {
            super(eVar, a.fjX, "WebViewCacheAppIdOccupation", null);
            AppMethodBeat.i(6817);
            this.hrm = eVar != null;
            AppMethodBeat.o(6817);
        }

        /* Access modifiers changed, original: final */
        public final void ay(String str, long j) {
            AppMethodBeat.i(6818);
            if (this.hrm) {
                a aVar = new a();
                aVar.field_appId = str;
                if (b((c) aVar, new String[0])) {
                    aVar.field_occupation += j;
                    c(aVar, new String[0]);
                    AppMethodBeat.o(6818);
                    return;
                }
                aVar.field_occupation = j;
                b((c) aVar);
                AppMethodBeat.o(6818);
                return;
            }
            AppMethodBeat.o(6818);
        }
    }

    static {
        AppMethodBeat.i(6824);
        AppMethodBeat.o(6824);
    }

    public static com.tencent.mm.plugin.webview.modelcache.e.a cYh() {
        AppMethodBeat.i(6819);
        int hashCode = "WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode();
        String[] strArr = new String[1];
        Class cls = fk.class;
        strArr[0] = j.a(fk.Hm(), "WebViewCacheAppIdOccupation");
        com.tencent.mm.plugin.webview.modelcache.e.a aVar = new com.tencent.mm.plugin.webview.modelcache.e.a(hashCode, strArr);
        AppMethodBeat.o(6819);
        return aVar;
    }

    public static a aeH(String str) {
        AppMethodBeat.i(6820);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6820);
            return null;
        }
        int hashCode = str.hashCode();
        a aVar = (a) unE.get(hashCode);
        if (aVar == null) {
            aVar = new a(str);
            unE.put(hashCode, aVar);
        } else {
            com.tencent.mm.vfs.e.tf(aVar.path);
        }
        AppMethodBeat.o(6820);
        return aVar;
    }

    static void clearCache() {
        AppMethodBeat.i(6821);
        unE.clear();
        AppMethodBeat.o(6821);
    }

    private static b cYi() {
        AppMethodBeat.i(6822);
        b bVar;
        if (g.RK()) {
            synchronized (unG) {
                try {
                    if (unF == null || !unF.hrm) {
                        g.RQ();
                        unF = new b(g.RP().eJN);
                    }
                    bVar = unF;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(6822);
                }
            }
            return bVar;
        }
        bVar = new b(null);
        AppMethodBeat.o(6822);
        return bVar;
    }

    private a(String str) {
        AppMethodBeat.i(6823);
        this.appId = str;
        com.tencent.mm.vfs.e.tf(com.tencent.mm.compatible.util.e.evd + "sfs");
        this.path = com.tencent.mm.compatible.util.e.evd + String.valueOf(str.hashCode());
        com.tencent.mm.vfs.e.tf(this.path);
        AppMethodBeat.o(6823);
    }
}

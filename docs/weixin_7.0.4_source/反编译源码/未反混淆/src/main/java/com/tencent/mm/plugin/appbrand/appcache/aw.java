package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class aw {
    private static final Map<i, aw> gVb = new HashMap();
    private static final aw gVc = new aw() {
        /* Access modifiers changed, original: protected|final */
        public final <T> T d(String str, Class<T> cls) {
            return null;
        }
    };
    private final u gVd;
    private final LinkedList<o> gVe;
    private final String mAppId;

    static final class d implements b<String> {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final /* synthetic */ Object c(String str, InputStream inputStream) {
            AppMethodBeat.i(86814);
            String convertStreamToString = com.tencent.mm.plugin.appbrand.r.d.convertStreamToString(inputStream);
            AppMethodBeat.o(86814);
            return convertStreamToString;
        }
    }

    interface b<T> {

        public static class a {
            static final Map<Class, b> gVh;

            static {
                AppMethodBeat.i(86813);
                HashMap hashMap = new HashMap();
                gVh = hashMap;
                hashMap.put(InputStream.class, new c());
                gVh.put(WebResourceResponse.class, new e());
                gVh.put(String.class, new d());
                gVh.put(byte[].class, new a());
                AppMethodBeat.o(86813);
            }
        }

        T c(String str, InputStream inputStream);
    }

    static final class c implements b<InputStream> {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ Object c(String str, InputStream inputStream) {
            return inputStream;
        }
    }

    static final class e implements b<WebResourceResponse> {
        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final /* synthetic */ Object c(String str, InputStream inputStream) {
            AppMethodBeat.i(86815);
            WebResourceResponse webResourceResponse = new WebResourceResponse(com.tencent.mm.sdk.f.b.ako(str), "UTF-8", inputStream);
            AppMethodBeat.o(86815);
            return webResourceResponse;
        }
    }

    static final class a implements b<byte[]> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object c(String str, InputStream inputStream) {
            AppMethodBeat.i(86812);
            byte[] k = com.tencent.mm.plugin.appbrand.r.d.k(inputStream);
            AppMethodBeat.o(86812);
            return k;
        }
    }

    /* synthetic */ aw() {
        this(null);
    }

    public static void p(i iVar) {
        AppMethodBeat.i(86816);
        aw r = r(iVar);
        if (!(r == null || r.gVd == null)) {
            r.gVd.avK();
        }
        AppMethodBeat.o(86816);
    }

    public static u q(i iVar) {
        AppMethodBeat.i(86817);
        u uVar = r(iVar).gVd;
        AppMethodBeat.o(86817);
        return uVar;
    }

    public static String a(i iVar, String str) {
        AppMethodBeat.i(86818);
        String nullAsNil = bo.nullAsNil((String) r(iVar).d(str, String.class));
        AppMethodBeat.o(86818);
        return nullAsNil;
    }

    public static boolean b(i iVar, String str) {
        AppMethodBeat.i(86819);
        InputStream d = d(iVar, str);
        if (d != null) {
            bo.b(d);
            AppMethodBeat.o(86819);
            return true;
        }
        AppMethodBeat.o(86819);
        return false;
    }

    public static WebResourceResponse c(i iVar, String str) {
        AppMethodBeat.i(86820);
        WebResourceResponse webResourceResponse = (WebResourceResponse) r(iVar).d(str, WebResourceResponse.class);
        AppMethodBeat.o(86820);
        return webResourceResponse;
    }

    public static InputStream d(i iVar, String str) {
        AppMethodBeat.i(86821);
        InputStream inputStream = (InputStream) r(iVar).d(str, InputStream.class);
        AppMethodBeat.o(86821);
        return inputStream;
    }

    public static String e(i iVar, String str) {
        AppMethodBeat.i(86822);
        if (xD(str)) {
            AppMethodBeat.o(86822);
            return null;
        }
        p asE = iVar.asE();
        if (asE instanceof t) {
            ao findAppropriateModuleInfo = ((IWxaFileSystemWithModularizing) ((t) asE).ae(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(str);
            if (findAppropriateModuleInfo != null) {
                String a = w.a(findAppropriateModuleInfo, str);
                AppMethodBeat.o(86822);
                return a;
            }
        }
        AppMethodBeat.o(86822);
        return null;
    }

    public static void a(i iVar, o oVar) {
        AppMethodBeat.i(86823);
        aw r = r(iVar);
        synchronized (r.gVe) {
            try {
                oVar.init();
                r.gVe.addFirst(oVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86823);
            }
        }
    }

    static {
        AppMethodBeat.i(86830);
        AppMethodBeat.o(86830);
    }

    private static aw r(i iVar) {
        AppMethodBeat.i(86824);
        aw awVar;
        if (iVar == null || iVar.mFinished) {
            awVar = gVc;
            AppMethodBeat.o(86824);
            return awVar;
        }
        synchronized (gVb) {
            try {
                awVar = (aw) gVb.get(iVar);
                if (awVar == null) {
                    awVar = new aw(iVar);
                    gVb.put(iVar, awVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86824);
            }
        }
        return awVar;
    }

    private aw(final i iVar) {
        AppMethodBeat.i(86825);
        this.gVe = new LinkedList();
        if (iVar == null) {
            this.gVd = null;
            this.mAppId = null;
            AppMethodBeat.o(86825);
            return;
        }
        this.mAppId = iVar.mAppId;
        this.gVd = new u(iVar.ye().hhd);
        this.gVd.avK();
        g.a(this.mAppId, new com.tencent.mm.plugin.appbrand.g.c() {
            public final void onDestroy() {
                AppMethodBeat.i(86811);
                g.b(aw.this.mAppId, this);
                synchronized (aw.gVb) {
                    try {
                        aw.gVb.remove(iVar);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(86811);
                    }
                }
                aw.b(aw.this);
            }
        });
        AppMethodBeat.o(86825);
    }

    /* Access modifiers changed, original: protected */
    public <T> T d(String str, Class<T> cls) {
        AppMethodBeat.i(86826);
        if (xD(str)) {
            AppMethodBeat.o(86826);
            return null;
        }
        String yk;
        T c;
        String yk2 = l.yk(str);
        if (yk2.startsWith("/__APP__")) {
            yk = l.yk(yk2.substring(8));
        } else {
            yk = yk2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        InputStream xE = xE(yk);
        if (xE != null) {
            c = ((b) a.gVh.get(cls)).c(yk, xE);
        } else {
            c = null;
        }
        String str2 = "MicroMsg.WxaPkgRuntimeReader";
        String str3 = "openRead, appId = %s, reqURL = %s, null(%B), type = %s, cost = %dms";
        Object[] objArr = new Object[5];
        objArr[0] = this.mAppId;
        objArr[1] = yk;
        objArr[2] = Boolean.valueOf(c == null);
        objArr[3] = cls.getName();
        objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        ab.i(str2, str3, objArr);
        AppMethodBeat.o(86826);
        return c;
    }

    private static boolean xD(String str) {
        AppMethodBeat.i(86827);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(86827);
            return true;
        } else if (h.t(str, "about:blank")) {
            AppMethodBeat.o(86827);
            return true;
        } else if (com.tencent.mm.plugin.appbrand.r.d.Ed(str)) {
            AppMethodBeat.o(86827);
            return true;
        } else if (URLUtil.isFileUrl(str)) {
            AppMethodBeat.o(86827);
            return true;
        } else {
            AppMethodBeat.o(86827);
            return false;
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0027, code skipped:
            r0 = r4.gVd.findAppropriateModuleInfo(r5);
     */
    /* JADX WARNING: Missing block: B:12:0x002d, code skipped:
            if (r0 != null) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:13:0x002f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(86828);
     */
    /* JADX WARNING: Missing block: B:18:0x003a, code skipped:
            r0 = r0.xy(r5);
            com.tencent.matrix.trace.core.AppMethodBeat.o(86828);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:25:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private InputStream xE(String str) {
        InputStream openRead;
        AppMethodBeat.i(86828);
        synchronized (this.gVe) {
            try {
                Iterator it = this.gVe.iterator();
                while (it.hasNext()) {
                    openRead = ((o) it.next()).openRead(str);
                    if (openRead != null) {
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86828);
            }
        }
        return openRead;
    }

    static /* synthetic */ void b(aw awVar) {
        AppMethodBeat.i(86829);
        if (awVar.gVd != null) {
            awVar.gVd.close();
        }
        AppMethodBeat.o(86829);
    }
}

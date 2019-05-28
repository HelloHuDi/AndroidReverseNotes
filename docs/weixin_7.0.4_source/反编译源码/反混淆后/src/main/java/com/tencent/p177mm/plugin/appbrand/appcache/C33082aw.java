package com.tencent.p177mm.plugin.appbrand.appcache;

import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C36710t;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw */
public class C33082aw {
    private static final Map<C6750i, C33082aw> gVb = new HashMap();
    private static final C33082aw gVc = new C190371();
    private final C42361u gVd;
    private final LinkedList<C19062o> gVe;
    private final String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw$d */
    static final class C10082d implements C19039b<String> {
        private C10082d() {
        }

        /* synthetic */ C10082d(byte b) {
            this();
        }

        /* renamed from: c */
        public final /* synthetic */ Object mo21440c(String str, InputStream inputStream) {
            AppMethodBeat.m2504i(86814);
            String convertStreamToString = C45672d.convertStreamToString(inputStream);
            AppMethodBeat.m2505o(86814);
            return convertStreamToString;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw$1 */
    static class C190371 extends C33082aw {
        C190371() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: d */
        public final <T> T mo34273d(String str, Class<T> cls) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw$b */
    interface C19039b<T> {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw$b$a */
        public static class C19040a {
            static final Map<Class, C19039b> gVh;

            static {
                AppMethodBeat.m2504i(86813);
                HashMap hashMap = new HashMap();
                gVh = hashMap;
                hashMap.put(InputStream.class, new C26741c());
                gVh.put(WebResourceResponse.class, new C26742e());
                gVh.put(String.class, new C10082d());
                gVh.put(byte[].class, new C33083a());
                AppMethodBeat.m2505o(86813);
            }
        }

        /* renamed from: c */
        T mo21440c(String str, InputStream inputStream);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw$c */
    static final class C26741c implements C19039b<InputStream> {
        private C26741c() {
        }

        /* synthetic */ C26741c(byte b) {
            this();
        }

        /* renamed from: c */
        public final /* bridge */ /* synthetic */ Object mo21440c(String str, InputStream inputStream) {
            return inputStream;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw$e */
    static final class C26742e implements C19039b<WebResourceResponse> {
        private C26742e() {
        }

        /* synthetic */ C26742e(byte b) {
            this();
        }

        /* renamed from: c */
        public final /* synthetic */ Object mo21440c(String str, InputStream inputStream) {
            AppMethodBeat.m2504i(86815);
            WebResourceResponse webResourceResponse = new WebResourceResponse(C44216b.ako(str), "UTF-8", inputStream);
            AppMethodBeat.m2505o(86815);
            return webResourceResponse;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aw$a */
    static final class C33083a implements C19039b<byte[]> {
        private C33083a() {
        }

        /* synthetic */ C33083a(byte b) {
            this();
        }

        /* renamed from: c */
        public final /* synthetic */ Object mo21440c(String str, InputStream inputStream) {
            AppMethodBeat.m2504i(86812);
            byte[] k = C45672d.m84373k(inputStream);
            AppMethodBeat.m2505o(86812);
            return k;
        }
    }

    /* synthetic */ C33082aw() {
        this(null);
    }

    /* renamed from: p */
    public static void m54075p(C6750i c6750i) {
        AppMethodBeat.m2504i(86816);
        C33082aw r = C33082aw.m54077r(c6750i);
        if (!(r == null || r.gVd == null)) {
            r.gVd.avK();
        }
        AppMethodBeat.m2505o(86816);
    }

    /* renamed from: q */
    public static C42361u m54076q(C6750i c6750i) {
        AppMethodBeat.m2504i(86817);
        C42361u c42361u = C33082aw.m54077r(c6750i).gVd;
        AppMethodBeat.m2505o(86817);
        return c42361u;
    }

    /* renamed from: a */
    public static String m54068a(C6750i c6750i, String str) {
        AppMethodBeat.m2504i(86818);
        String nullAsNil = C5046bo.nullAsNil((String) C33082aw.m54077r(c6750i).mo34273d(str, String.class));
        AppMethodBeat.m2505o(86818);
        return nullAsNil;
    }

    /* renamed from: b */
    public static boolean m54071b(C6750i c6750i, String str) {
        AppMethodBeat.m2504i(86819);
        InputStream d = C33082aw.m54073d(c6750i, str);
        if (d != null) {
            C5046bo.m7527b(d);
            AppMethodBeat.m2505o(86819);
            return true;
        }
        AppMethodBeat.m2505o(86819);
        return false;
    }

    /* renamed from: c */
    public static WebResourceResponse m54072c(C6750i c6750i, String str) {
        AppMethodBeat.m2504i(86820);
        WebResourceResponse webResourceResponse = (WebResourceResponse) C33082aw.m54077r(c6750i).mo34273d(str, WebResourceResponse.class);
        AppMethodBeat.m2505o(86820);
        return webResourceResponse;
    }

    /* renamed from: d */
    public static InputStream m54073d(C6750i c6750i, String str) {
        AppMethodBeat.m2504i(86821);
        InputStream inputStream = (InputStream) C33082aw.m54077r(c6750i).mo34273d(str, InputStream.class);
        AppMethodBeat.m2505o(86821);
        return inputStream;
    }

    /* renamed from: e */
    public static String m54074e(C6750i c6750i, String str) {
        AppMethodBeat.m2504i(86822);
        if (C33082aw.m54078xD(str)) {
            AppMethodBeat.m2505o(86822);
            return null;
        }
        C19092p asE = c6750i.asE();
        if (asE instanceof C36710t) {
            C45512ao findAppropriateModuleInfo = ((IWxaFileSystemWithModularizing) ((C36710t) asE).mo53654ae(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(str);
            if (findAppropriateModuleInfo != null) {
                String a = C19073w.m29638a(findAppropriateModuleInfo, str);
                AppMethodBeat.m2505o(86822);
                return a;
            }
        }
        AppMethodBeat.m2505o(86822);
        return null;
    }

    /* renamed from: a */
    public static void m54069a(C6750i c6750i, C19062o c19062o) {
        AppMethodBeat.m2504i(86823);
        C33082aw r = C33082aw.m54077r(c6750i);
        synchronized (r.gVe) {
            try {
                c19062o.init();
                r.gVe.addFirst(c19062o);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86823);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(86830);
        AppMethodBeat.m2505o(86830);
    }

    /* renamed from: r */
    private static C33082aw m54077r(C6750i c6750i) {
        AppMethodBeat.m2504i(86824);
        C33082aw c33082aw;
        if (c6750i == null || c6750i.mFinished) {
            c33082aw = gVc;
            AppMethodBeat.m2505o(86824);
            return c33082aw;
        }
        synchronized (gVb) {
            try {
                c33082aw = (C33082aw) gVb.get(c6750i);
                if (c33082aw == null) {
                    c33082aw = new C33082aw(c6750i);
                    gVb.put(c6750i, c33082aw);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86824);
            }
        }
        return c33082aw;
    }

    private C33082aw(final C6750i c6750i) {
        AppMethodBeat.m2504i(86825);
        this.gVe = new LinkedList();
        if (c6750i == null) {
            this.gVd = null;
            this.mAppId = null;
            AppMethodBeat.m2505o(86825);
            return;
        }
        this.mAppId = c6750i.mAppId;
        this.gVd = new C42361u(c6750i.mo15034ye().hhd);
        this.gVd.avK();
        C33183g.m54274a(this.mAppId, new C33186c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(86811);
                C33183g.m54276b(C33082aw.this.mAppId, this);
                synchronized (C33082aw.gVb) {
                    try {
                        C33082aw.gVb.remove(c6750i);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(86811);
                    }
                }
                C33082aw.m54070b(C33082aw.this);
            }
        });
        AppMethodBeat.m2505o(86825);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public <T> T mo34273d(String str, Class<T> cls) {
        AppMethodBeat.m2504i(86826);
        if (C33082aw.m54078xD(str)) {
            AppMethodBeat.m2505o(86826);
            return null;
        }
        String yk;
        T c;
        String yk2 = C42367l.m74946yk(str);
        if (yk2.startsWith("/__APP__")) {
            yk = C42367l.m74946yk(yk2.substring(8));
        } else {
            yk = yk2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        InputStream xE = m54079xE(yk);
        if (xE != null) {
            c = ((C19039b) C19040a.gVh.get(cls)).mo21440c(yk, xE);
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
        C4990ab.m7417i(str2, str3, objArr);
        AppMethodBeat.m2505o(86826);
        return c;
    }

    /* renamed from: xD */
    private static boolean m54078xD(String str) {
        AppMethodBeat.m2504i(86827);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(86827);
            return true;
        } else if (C8874h.m15849t(str, "about:blank")) {
            AppMethodBeat.m2505o(86827);
            return true;
        } else if (C45672d.m84372Ed(str)) {
            AppMethodBeat.m2505o(86827);
            return true;
        } else if (URLUtil.isFileUrl(str)) {
            AppMethodBeat.m2505o(86827);
            return true;
        } else {
            AppMethodBeat.m2505o(86827);
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
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(86828);
     */
    /* JADX WARNING: Missing block: B:18:0x003a, code skipped:
            r0 = r0.mo73324xy(r5);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(86828);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:25:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: xE */
    private InputStream m54079xE(String str) {
        InputStream openRead;
        AppMethodBeat.m2504i(86828);
        synchronized (this.gVe) {
            try {
                Iterator it = this.gVe.iterator();
                while (it.hasNext()) {
                    openRead = ((C19062o) it.next()).openRead(str);
                    if (openRead != null) {
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86828);
            }
        }
        return openRead;
    }

    /* renamed from: b */
    static /* synthetic */ void m54070b(C33082aw c33082aw) {
        AppMethodBeat.m2504i(86829);
        if (c33082aw.gVd != null) {
            c33082aw.gVd.close();
        }
        AppMethodBeat.m2505o(86829);
    }
}

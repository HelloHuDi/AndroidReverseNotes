package com.tencent.p177mm.plugin.appbrand.game.preload;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f.C19252a;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f.C19253b;
import com.tencent.p177mm.plugin.appbrand.p298j.C45569d;
import com.tencent.p177mm.plugin.appbrand.p321l.C10567c;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C19548m;
import com.tencent.p177mm.plugin.appbrand.p321l.C27146b.C27147a;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.preload.d */
public class C45564d {
    private static volatile C45564d htm;
    public boolean hasInit = false;
    public C41243o htn;
    public C19548m hto;
    public C38414a htp;
    public C19092p htq;
    public C38231c htr;
    public CopyOnWriteArrayList<String> hts = new CopyOnWriteArrayList();
    public boolean htt = false;
    public AtomicInteger htu;
    public AtomicInteger htv;
    public AtomicInteger htw;
    public AtomicInteger htx;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.preload.d$2 */
    public class C382322 implements C27147a {
        final /* synthetic */ String fYh;
        final /* synthetic */ String val$url;

        public C382322(String str, String str2) {
            this.val$url = str;
            this.fYh = str2;
        }

        /* renamed from: c */
        public final void mo21951c(int i, String str, String str2, int i2) {
            AppMethodBeat.m2504i(130295);
            C4990ab.m7419v("MicroMsg.WAGamePreloadManager", "download errMsg:%d,mimeType:%s,filePath:%s,statusCode:%d,url:%s", Integer.valueOf(i), str, str2, Integer.valueOf(i2), this.val$url);
            if (C45564d.this.htq == null || i2 != 200) {
                C4990ab.m7412e("MicroMsg.WAGamePreloadManager", "download fileSystem is null or download failed!");
                AppMethodBeat.m2505o(130295);
                return;
            }
            C45564d.m84052a(C45564d.this, this.val$url);
            C45564d.m84054b(C45564d.this);
            C45518j X = C45564d.this.htq.mo5830X(this.fYh.substring(0, this.fYh.lastIndexOf("/") + 1), true);
            if (X == C45518j.OK || X == C45518j.RET_ALREADY_EXISTS) {
                C45564d.this.htq.mo5838a(this.fYh, new File(str2), true);
            }
            C45564d.this.htv.addAndGet(1);
            AppMethodBeat.m2505o(130295);
        }

        /* renamed from: g */
        public final void mo21952g(int i, long j, long j2) {
        }

        /* renamed from: AD */
        public final void mo21950AD(String str) {
        }

        /* renamed from: p */
        public final void mo21953p(JSONObject jSONObject) {
            AppMethodBeat.m2504i(130296);
            if (jSONObject != null) {
                try {
                    C45564d.this.htu.addAndGet(jSONObject.getInt("Content-Length"));
                    AppMethodBeat.m2505o(130296);
                    return;
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.WAGamePreloadManager", e, "content-length get error", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(130296);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m84054b(C45564d c45564d) {
        AppMethodBeat.m2504i(130306);
        c45564d.aBB();
        AppMethodBeat.m2505o(130306);
    }

    private C45564d() {
        AppMethodBeat.m2504i(130297);
        AppMethodBeat.m2505o(130297);
    }

    public static C45564d aBz() {
        AppMethodBeat.m2504i(130298);
        if (htm == null) {
            synchronized (C45564d.class) {
                try {
                    if (htm == null) {
                        htm = new C45564d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(130298);
                    }
                }
            }
        }
        C45564d c45564d = htm;
        AppMethodBeat.m2505o(130298);
        return c45564d;
    }

    public final boolean isDownloading(String str) {
        AppMethodBeat.m2504i(130299);
        synchronized (this.hts) {
            try {
                if (this.hts == null) {
                    AppMethodBeat.m2505o(130299);
                    return false;
                } else if (this.hts.contains(str)) {
                    C4990ab.m7417i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", str, Integer.valueOf(this.hts.size()));
                    this.htx.addAndGet(1);
                } else {
                    AppMethodBeat.m2505o(130299);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130299);
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m84053a(C38414a c38414a, String str) {
        AppMethodBeat.m2504i(130300);
        if (!(c38414a.ioe ? false : c38414a.iof) || C19538j.m30275c(c38414a.bQI, str)) {
            AppMethodBeat.m2505o(130300);
            return true;
        }
        C4990ab.m7417i("MicroMsg.WAGamePreloadManager", "not in domain url %s", str);
        AppMethodBeat.m2505o(130300);
        return false;
    }

    public static String aBA() {
        AppMethodBeat.m2504i(130301);
        StringBuilder stringBuilder = new StringBuilder();
        C10567c.aIB();
        String stringBuilder2 = stringBuilder.append(C10567c.aIA()).toString();
        AppMethodBeat.m2505o(130301);
        return stringBuilder2;
    }

    public final void aBB() {
        AppMethodBeat.m2504i(130302);
        if (this.hts != null && this.hts.size() == 0) {
            if (this.htn == null || this.htn.getAppConfig() == null) {
                C4990ab.m7412e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
                AppMethodBeat.m2505o(130302);
                return;
            }
            ArrayList arrayList = this.htn.getAppConfig().hfd;
            String str = "MicroMsg.WAGamePreloadManager";
            String str2 = "predownload subPackage size:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            C4990ab.m7417i(str, str2, objArr);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    final String str3 = (String) it.next();
                    C4990ab.m7417i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", str3);
                    str = this.htn.atH().hhd.mo53645xL(str3);
                    C1178g.m2587cz(str3);
                    if (C19253b.inO == null) {
                        C4990ab.m7412e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
                    } else {
                        C19251f i = C19253b.inO.mo34457i(this.htn, str);
                        i.mo34453a(new C19252a() {
                            /* renamed from: ds */
                            public final void mo34456ds(String str) {
                                AppMethodBeat.m2504i(130293);
                                C4990ab.m7417i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", str3, str);
                                C45564d.this.htw.addAndGet(1);
                                AppMethodBeat.m2505o(130293);
                            }

                            /* renamed from: a */
                            public final void mo34455a(C45569d c45569d) {
                                AppMethodBeat.m2504i(130294);
                                C4990ab.m7417i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", c45569d);
                                AppMethodBeat.m2505o(130294);
                            }
                        });
                        i.start();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(130302);
    }

    /* renamed from: dQ */
    public static void m84057dQ(boolean z) {
        AppMethodBeat.m2504i(130303);
        C38233e.aBD().htH = z;
        AppMethodBeat.m2505o(130303);
    }

    public final void aBC() {
        AppMethodBeat.m2504i(130304);
        C38233e.aBD().mo60956cY(2002, (int) (C5046bo.anU() - this.htn.atI().startTime));
        C38233e.aBD().mo60956cY(3002, this.htv.intValue());
        C38233e.aBD().mo60956cY(3004, this.htu.intValue());
        C38233e.aBD().mo60956cY(WearableStatusCodes.UNKNOWN_LISTENER, this.htw.intValue());
        C38233e.aBD().mo60956cY(3005, this.htx.intValue());
        AppMethodBeat.m2505o(130304);
    }
}

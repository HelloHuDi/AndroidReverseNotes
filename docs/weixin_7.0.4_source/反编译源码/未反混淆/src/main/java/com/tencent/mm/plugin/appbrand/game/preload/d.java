package com.tencent.mm.plugin.appbrand.game.preload;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.j.f;
import com.tencent.mm.plugin.appbrand.l.a;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.appbrand.l.c;
import com.tencent.mm.plugin.appbrand.l.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static volatile d htm;
    public boolean hasInit = false;
    public o htn;
    public m hto;
    public a htp;
    public p htq;
    public c htr;
    public CopyOnWriteArrayList<String> hts = new CopyOnWriteArrayList();
    public boolean htt = false;
    public AtomicInteger htu;
    public AtomicInteger htv;
    public AtomicInteger htw;
    public AtomicInteger htx;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.preload.d$2 */
    public class AnonymousClass2 implements b.a {
        final /* synthetic */ String fYh;
        final /* synthetic */ String val$url;

        public AnonymousClass2(String str, String str2) {
            this.val$url = str;
            this.fYh = str2;
        }

        public final void c(int i, String str, String str2, int i2) {
            AppMethodBeat.i(130295);
            ab.v("MicroMsg.WAGamePreloadManager", "download errMsg:%d,mimeType:%s,filePath:%s,statusCode:%d,url:%s", Integer.valueOf(i), str, str2, Integer.valueOf(i2), this.val$url);
            if (d.this.htq == null || i2 != 200) {
                ab.e("MicroMsg.WAGamePreloadManager", "download fileSystem is null or download failed!");
                AppMethodBeat.o(130295);
                return;
            }
            d.a(d.this, this.val$url);
            d.b(d.this);
            j X = d.this.htq.X(this.fYh.substring(0, this.fYh.lastIndexOf("/") + 1), true);
            if (X == j.OK || X == j.RET_ALREADY_EXISTS) {
                d.this.htq.a(this.fYh, new File(str2), true);
            }
            d.this.htv.addAndGet(1);
            AppMethodBeat.o(130295);
        }

        public final void g(int i, long j, long j2) {
        }

        public final void AD(String str) {
        }

        public final void p(JSONObject jSONObject) {
            AppMethodBeat.i(130296);
            if (jSONObject != null) {
                try {
                    d.this.htu.addAndGet(jSONObject.getInt("Content-Length"));
                    AppMethodBeat.o(130296);
                    return;
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.WAGamePreloadManager", e, "content-length get error", new Object[0]);
                }
            }
            AppMethodBeat.o(130296);
        }
    }

    static /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(130306);
        dVar.aBB();
        AppMethodBeat.o(130306);
    }

    private d() {
        AppMethodBeat.i(130297);
        AppMethodBeat.o(130297);
    }

    public static d aBz() {
        AppMethodBeat.i(130298);
        if (htm == null) {
            synchronized (d.class) {
                try {
                    if (htm == null) {
                        htm = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(130298);
                    }
                }
            }
        }
        d dVar = htm;
        AppMethodBeat.o(130298);
        return dVar;
    }

    public final boolean isDownloading(String str) {
        AppMethodBeat.i(130299);
        synchronized (this.hts) {
            try {
                if (this.hts == null) {
                    AppMethodBeat.o(130299);
                    return false;
                } else if (this.hts.contains(str)) {
                    ab.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", str, Integer.valueOf(this.hts.size()));
                    this.htx.addAndGet(1);
                } else {
                    AppMethodBeat.o(130299);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130299);
            }
        }
        return true;
    }

    public static boolean a(a aVar, String str) {
        AppMethodBeat.i(130300);
        if (!(aVar.ioe ? false : aVar.iof) || com.tencent.mm.plugin.appbrand.l.j.c(aVar.bQI, str)) {
            AppMethodBeat.o(130300);
            return true;
        }
        ab.i("MicroMsg.WAGamePreloadManager", "not in domain url %s", str);
        AppMethodBeat.o(130300);
        return false;
    }

    public static String aBA() {
        AppMethodBeat.i(130301);
        StringBuilder stringBuilder = new StringBuilder();
        c.aIB();
        String stringBuilder2 = stringBuilder.append(c.aIA()).toString();
        AppMethodBeat.o(130301);
        return stringBuilder2;
    }

    public final void aBB() {
        AppMethodBeat.i(130302);
        if (this.hts != null && this.hts.size() == 0) {
            if (this.htn == null || this.htn.getAppConfig() == null) {
                ab.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
                AppMethodBeat.o(130302);
                return;
            }
            ArrayList arrayList = this.htn.getAppConfig().hfd;
            String str = "MicroMsg.WAGamePreloadManager";
            String str2 = "predownload subPackage size:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            ab.i(str, str2, objArr);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    final String str3 = (String) it.next();
                    ab.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", str3);
                    str = this.htn.atH().hhd.xL(str3);
                    g.cz(str3);
                    if (f.b.inO == null) {
                        ab.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
                    } else {
                        f i = f.b.inO.i(this.htn, str);
                        i.a(new f.a() {
                            public final void ds(String str) {
                                AppMethodBeat.i(130293);
                                ab.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", str3, str);
                                d.this.htw.addAndGet(1);
                                AppMethodBeat.o(130293);
                            }

                            public final void a(com.tencent.mm.plugin.appbrand.j.d dVar) {
                                AppMethodBeat.i(130294);
                                ab.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", dVar);
                                AppMethodBeat.o(130294);
                            }
                        });
                        i.start();
                    }
                }
            }
        }
        AppMethodBeat.o(130302);
    }

    public static void dQ(boolean z) {
        AppMethodBeat.i(130303);
        e.aBD().htH = z;
        AppMethodBeat.o(130303);
    }

    public final void aBC() {
        AppMethodBeat.i(130304);
        e.aBD().cY(2002, (int) (bo.anU() - this.htn.atI().startTime));
        e.aBD().cY(3002, this.htv.intValue());
        e.aBD().cY(3004, this.htu.intValue());
        e.aBD().cY(WearableStatusCodes.UNKNOWN_LISTENER, this.htw.intValue());
        e.aBD().cY(3005, this.htx.intValue());
        AppMethodBeat.o(130304);
    }
}

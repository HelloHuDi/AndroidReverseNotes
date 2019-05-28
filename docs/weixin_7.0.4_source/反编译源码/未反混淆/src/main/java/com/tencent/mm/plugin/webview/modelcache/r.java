package com.tencent.mm.plugin.webview.modelcache;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.g.a.b.d;
import com.tencent.mm.pluginsdk.g.a.b.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class r {
    private volatile al ftB;
    private final Object iRa;
    public final c uoc;
    public final c uod;
    private volatile j uoe;
    final SparseArray<m> uof;
    public final d uog;
    final f uoh;
    public final byte[] uoi;
    public final SparseArray<Set<Object>> uoj;

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.r$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ List uoq;

        public AnonymousClass5(List list) {
            this.uoq = list;
        }

        public final void run() {
            AppMethodBeat.i(6884);
            for (String str : this.uoq) {
                ab.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate requestURL = %s", str);
                if (!bo.isNullOrNil(str)) {
                    int cYk;
                    if (str.startsWith("http://")) {
                        cYk = com.tencent.mm.plugin.webview.modelcache.b.a.cYk();
                    } else if (str.startsWith("https://")) {
                        cYk = com.tencent.mm.plugin.webview.modelcache.b.a.IL(com.tencent.mm.plugin.webview.modelcache.b.a.cYk());
                    } else {
                        ab.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, unsupported scheme, url = %s", str);
                    }
                    String aeM = q.aeM(str);
                    l cYo = l.cYo();
                    List list;
                    if (!cYo.hrm) {
                        list = null;
                    } else if (bo.isNullOrNil(aeM)) {
                        list = null;
                    } else {
                        list = cYo.o(String.format("select * from %s where %s=? and %s=?", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", "protocol"}), String.valueOf(ag.ck(aeM).hashCode()), String.valueOf(cYk));
                    }
                    if (bo.ek(list)) {
                        ab.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, not cached requestURL = %s, parsed mainURL = %s, protocol = %s", str, aeM, com.tencent.mm.plugin.webview.modelcache.b.a.toString(cYk));
                    } else {
                        String aeM2 = q.aeM(str);
                        if (!bo.isNullOrNil(aeM2)) {
                            Object obj;
                            long anT = bo.anT();
                            for (g gVar : list) {
                                if (anT - gVar.field_createTime > 60 && aeM2.equals(gVar.field_version)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                ab.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, createTime not exceed 1min, no need to update this mainDocument, url = %s", str);
                            } else {
                                byte[] aeO = q.aeO(str);
                                if (bo.cb(aeO)) {
                                    ab.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, get empty bytes from requestURL = %s", str);
                                } else {
                                    l cYo2 = l.cYo();
                                    List list2;
                                    if (!cYo2.hrm) {
                                        list2 = null;
                                    } else if (bo.isNullOrNil(aeM)) {
                                        list2 = null;
                                    } else {
                                        list2 = cYo2.o(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", l.IN(cYk)}), String.valueOf(ag.ck(aeM).hashCode()));
                                    }
                                    if (bo.ek(list2)) {
                                        ab.e("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, get empty list ");
                                    } else {
                                        String w = ag.w(aeO);
                                        for (g gVar2 : list2) {
                                            ab.d("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cacheRes = %s", gVar2);
                                            if (!bo.isNullOrNil(gVar2.field_localPath)) {
                                                if (w.equals(gVar2.field_contentMd5)) {
                                                    ab.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cache not updated");
                                                } else {
                                                    a aeH = a.aeH(gVar2.field_appId);
                                                    if (aeH != null) {
                                                        String str2 = gVar2.field_localPath;
                                                        if (!(bo.isNullOrNil(str2) || bo.cb(aeO))) {
                                                            if ((e.b(str2, aeO, aeO.length) == 0 ? 1 : null) != null && str2.startsWith(aeH.path)) {
                                                                aeH.unD.ay(aeH.appId, (long) aeO.length);
                                                            }
                                                        }
                                                        gVar2.field_contentMd5 = w;
                                                        l.cYo().b(gVar2);
                                                        ab.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, updated cacheRes = %s", gVar2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(6884);
        }
    }

    public static final class a {
        private static final r uor = new r();

        static {
            AppMethodBeat.i(6885);
            AppMethodBeat.o(6885);
        }
    }

    /* synthetic */ r(byte b) {
        this();
    }

    private r() {
        AppMethodBeat.i(6886);
        this.uoc = new c<vm>() {
            {
                AppMethodBeat.i(6877);
                this.xxI = vm.class.getName().hashCode();
                AppMethodBeat.o(6877);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(6878);
                vm vmVar = (vm) bVar;
                if (vmVar == null) {
                    AppMethodBeat.o(6878);
                    return false;
                }
                final f fVar = new f(vmVar.cSw.url, vmVar.cSw.filePath, vmVar.cSw.version, vmVar.cSw.appId, vmVar.cSw.cSx, vmVar.cSw.cSy, vmVar.cSw.cSz, vmVar.cSw.bqF, vmVar.cSw.aHW, vmVar.cSw.exception);
                r.this.aNS().aa(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:126:0x0331  */
                    /* JADX WARNING: Removed duplicated region for block: B:117:0x02cb  */
                    /* JADX WARNING: Missing block: B:124:0x032d, code skipped:
            if (r6.b((com.tencent.mm.sdk.e.c) r2, "appId", "domain", "cacheType", "urlMd5Hashcode", "packageId") == false) goto L_0x032f;
     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        AppMethodBeat.i(6876);
                        f fVar = fVar;
                        if (fVar != null) {
                            if (bo.isNullOrNil(fVar.appId) || bo.isNullOrNil(fVar.cSx) || bo.isNullOrNil(fVar.filePath)) {
                                ab.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, invalid response = %s", fVar);
                                AppMethodBeat.o(6876);
                                return;
                            }
                            String str;
                            Object obj;
                            ab.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response = %s", fVar);
                            List<f.c> u = a.uor.uoh.u(fVar.url, fVar.appId, fVar.cSx, fVar.cSy);
                            Exception exception = fVar.exception;
                            if (exception != null) {
                                ab.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response.exception = %s", exception);
                                if (!bo.ek(u)) {
                                    if (exception instanceof SocketTimeoutException) {
                                        str = "timeout";
                                    } else if (exception instanceof d) {
                                        str = "not support redirect resource";
                                    } else if (exception instanceof g) {
                                        str = "not support 0kb resource";
                                    } else if (!(exception instanceof com.tencent.mm.pluginsdk.g.a.b.a) || fVar.aHW < 5242880) {
                                        str = "batch download fail";
                                    } else {
                                        str = "exceed cache threshold";
                                    }
                                    for (f.c cVar : u) {
                                        h.JR(cVar.unN).K(cVar.unO, fVar.cSz == 3 ? "publicCache" : "cache", str);
                                        if (fVar.cSz == 1) {
                                            a.uor.uoh.a(cVar.unN, fVar.appId, fVar.cSx, fVar.cSy, fVar.cSz, fVar.url);
                                        } else {
                                            a.uor.uoh.a(cVar.unN, fVar.appId, fVar.cSx, fVar.cSy, fVar.cSz);
                                        }
                                    }
                                }
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                n.lQ(7);
                                AppMethodBeat.o(6876);
                                return;
                            }
                            String str2;
                            String str3;
                            if (com.tencent.mm.a.e.cs(fVar.filePath) == 0) {
                                ab.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, readFileLength = 0, return");
                                if (!bo.ek(u)) {
                                    for (f.c cVar2 : u) {
                                        h.JR(cVar2.unN).K(cVar2.unO, fVar.cSz == 3 ? "publicCache" : "cache", "batch download fail");
                                        a.uor.uoh.a(cVar2.unN, fVar.appId, fVar.cSx, fVar.cSy, fVar.cSz, fVar.url);
                                    }
                                }
                                obj = null;
                            } else {
                                m mVar;
                                String aeM = q.aeM(fVar.url);
                                r cYq = a.uor;
                                str2 = fVar.appId;
                                str3 = fVar.cSx;
                                int i = fVar.cSz;
                                String str4 = fVar.cSy;
                                if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(aeM)) {
                                    ab.e("MicroMsg.WebViewCacheWorkerManager", "getWebViewCacheWriter, invalid params | appId = %s, domain = %s, mainURL = %s", str2, str3, aeM);
                                    mVar = null;
                                } else {
                                    int hashCode = String.format("%s_%s_%s_%s", new Object[]{str2, str3, Integer.valueOf(i), aeM}).hashCode();
                                    m mVar2 = (m) cYq.uof.get(hashCode);
                                    if (mVar2 == null) {
                                        mVar2 = new m(str2, str3, i, aeM, str4);
                                        cYq.uof.put(hashCode, mVar2);
                                    }
                                    mVar = mVar2;
                                }
                                obj = null;
                                if (mVar != null) {
                                    String str5 = fVar.filePath;
                                    aeM = fVar.version;
                                    str4 = fVar.bqF;
                                    if (bo.isNullOrNil(str5)) {
                                        ab.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, filePath is null or nil");
                                        obj = -1;
                                    } else if (!com.tencent.mm.a.e.ct(str5)) {
                                        ab.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file not exists");
                                        obj = -1;
                                    } else if (com.tencent.mm.a.e.cs(str5) <= 0) {
                                        ab.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file size = 0kb");
                                        obj = 6;
                                    } else if (bo.isNullOrNil(aeM)) {
                                        ab.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, resVersion is null or nil, return");
                                        obj = -1;
                                    } else if (mVar.unT == null) {
                                        ab.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, appIdDir is null, return");
                                        obj = -1;
                                    } else {
                                        long j;
                                        g gVar;
                                        a aVar = mVar.unT;
                                        String str6 = mVar.cHg;
                                        if (bo.isNullOrNil(str5) || bo.isNullOrNil(str6)) {
                                            j = 0;
                                        } else {
                                            j = e.y(str5, str6);
                                            if (j > 0 && str6.startsWith(aVar.path)) {
                                                aVar.unD.ay(aVar.appId, j);
                                            }
                                        }
                                        l cYo = l.cYo();
                                        str = mVar.appId;
                                        String str7 = mVar.cSx;
                                        int i2 = mVar.cSz;
                                        String str8 = mVar.unS;
                                        String str9 = mVar.cSy;
                                        if (cYo.hrm) {
                                            if (bo.isNullOrNil(str) || bo.isNullOrNil(str7) || bo.isNullOrNil(str8) || bo.isNullOrNil(str9)) {
                                                gVar = null;
                                                if (gVar != null) {
                                                    ab.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, no db record stored");
                                                    obj = -1;
                                                } else {
                                                    gVar.field_localPath = mVar.cHg;
                                                    gVar.field_version = aeM;
                                                    gVar.field_contentType = str4;
                                                    gVar.field_contentMd5 = q.aeP(gVar.field_localPath);
                                                    gVar.field_contentLength = j;
                                                    l.cYo().b(gVar);
                                                    ab.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, updated record = %s", gVar);
                                                    obj = null;
                                                }
                                            } else {
                                                gVar = new g();
                                                gVar.field_appId = str;
                                                gVar.field_domain = str7;
                                                gVar.field_cacheType = i2;
                                                gVar.field_urlMd5Hashcode = ag.ck(str8).hashCode();
                                                gVar.field_packageId = str9;
                                            }
                                        }
                                        gVar = null;
                                        if (gVar != null) {
                                        }
                                    }
                                    obj = obj == null ? 1 : null;
                                }
                                if (obj == null) {
                                    if (!bo.ek(u)) {
                                        for (f.c cVar22 : u) {
                                            h.JR(cVar22.unN).K(cVar22.unO, fVar.cSz == 3 ? "publicCache" : "cache", "batch save fail");
                                            if (fVar.cSz == 1) {
                                                a.uor.uoh.a(cVar22.unN, fVar.appId, fVar.cSx, fVar.cSy, fVar.cSz, fVar.url);
                                            } else {
                                                a.uor.uoh.a(cVar22.unN, fVar.appId, fVar.cSx, fVar.cSy, fVar.cSz);
                                            }
                                        }
                                    }
                                    obj = null;
                                } else {
                                    obj = 1;
                                }
                            }
                            if (obj == null) {
                                n.lQ(8);
                                AppMethodBeat.o(6876);
                                return;
                            } else if (fVar.cSz != 1) {
                                l cYo2 = l.cYo();
                                str2 = fVar.appId;
                                str3 = fVar.cSx;
                                String str10 = fVar.cSy;
                                List list;
                                if (!cYo2.hrm) {
                                    list = null;
                                } else if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(str10)) {
                                    list = null;
                                } else {
                                    list = cYo2.o(String.format("select * from %s where %s=? and %s=? and %s=?", new Object[]{"WebViewResourceCache", "appId", "domain", "packageId"}), str2, str3, str10);
                                }
                                if (!bo.ek(list)) {
                                    for (g gVar2 : list) {
                                        boolean z;
                                        if (gVar2 == null) {
                                            z = false;
                                            continue;
                                        } else {
                                            z = !bo.isNullOrNil(gVar2.field_contentMd5) && bo.nullAsNil(q.aeP(gVar2.field_localPath)).equals(gVar2.field_contentMd5);
                                            ab.d("MicroMsg.WebViewCacheUtils", "isCacheResValid, cacheRes = %s, ret = %b", gVar2, Boolean.valueOf(z));
                                            continue;
                                        }
                                        if (!z) {
                                            obj = null;
                                            break;
                                        }
                                    }
                                    int i3 = 1;
                                    if (!(obj == null || bo.ek(u))) {
                                        for (f.c cVar222 : u) {
                                            h.JR(cVar222.unN).K(cVar222.unO, "cache", "ok");
                                            a.uor.uoh.a(cVar222.unN, fVar.appId, fVar.cSx, fVar.cSy, fVar.cSz);
                                        }
                                    }
                                }
                            } else if (!bo.ek(u)) {
                                for (f.c cVar2222 : u) {
                                    h.JR(cVar2222.unN).K(cVar2222.unO, "cache", "ok");
                                    a.uor.uoh.a(cVar2222.unN, fVar.appId, fVar.cSx, fVar.cSy, fVar.cSz, fVar.url);
                                }
                                AppMethodBeat.o(6876);
                                return;
                            }
                        }
                        AppMethodBeat.o(6876);
                    }
                });
                AppMethodBeat.o(6878);
                return false;
            }
        };
        this.uod = new c<mp>() {
            {
                AppMethodBeat.i(6879);
                this.xxI = mp.class.getName().hashCode();
                AppMethodBeat.o(6879);
            }

            public final /* bridge */ /* synthetic */ boolean a(b bVar) {
                return false;
            }
        };
        this.uof = new SparseArray();
        this.uog = new d();
        this.uoh = new f();
        this.iRa = new Object();
        this.uoi = new byte[0];
        this.uoj = new SparseArray();
        AppMethodBeat.o(6886);
    }

    public final void release(boolean z) {
        AppMethodBeat.i(6887);
        for (int i = 0; i < this.uof.size(); i++) {
            this.uof.valueAt(i);
        }
        this.uof.clear();
        a.clearCache();
        if (this.ftB != null) {
            synchronized (this.iRa) {
                try {
                    if (this.ftB == null) {
                    } else if (z) {
                        this.ftB.oAl.quit();
                        AppMethodBeat.o(6887);
                    } else {
                        final al alVar = this.ftB;
                        this.ftB.aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(6883);
                                Looper.myQueue().addIdleHandler(new IdleHandler() {
                                    public final boolean queueIdle() {
                                        AppMethodBeat.i(6882);
                                        if (VERSION.SDK_INT >= 18) {
                                            alVar.oAl.getLooper().quitSafely();
                                        } else {
                                            alVar.oAl.getLooper().quit();
                                        }
                                        AppMethodBeat.o(6882);
                                        return false;
                                    }
                                });
                                AppMethodBeat.o(6883);
                            }
                        });
                        this.ftB = null;
                        AppMethodBeat.o(6887);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(6887);
                }
            }
        } else {
            AppMethodBeat.o(6887);
        }
    }

    public final al aNS() {
        AppMethodBeat.i(6888);
        if (this.ftB == null) {
            synchronized (this.iRa) {
                try {
                    if (this.ftB == null) {
                        this.ftB = new al("WebViewCacheWorkerManager#WorkerThread") {
                            public final int aa(final Runnable runnable) {
                                AppMethodBeat.i(6881);
                                int aa = super.aa(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(6880);
                                        if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                                            Process.setThreadPriority(10);
                                        }
                                        if (runnable != null) {
                                            runnable.run();
                                        }
                                        AppMethodBeat.o(6880);
                                    }
                                });
                                AppMethodBeat.o(6881);
                                return aa;
                            }
                        };
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(6888);
                    }
                }
            }
        }
        al alVar = this.ftB;
        AppMethodBeat.o(6888);
        return alVar;
    }

    public final void IP(int i) {
        AppMethodBeat.i(6889);
        if (com.tencent.mm.kernel.g.RK()) {
            try {
                a.uor.uoh.IM(i);
                IQ(i);
                AppMethodBeat.o(6889);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewCacheWorkerManager", "onWebViewUIDestroy, accHasReady, but occurred exception = %s", e);
            }
        }
        AppMethodBeat.o(6889);
    }

    private void IQ(int i) {
        Set set;
        AppMethodBeat.i(6890);
        synchronized (this.uoi) {
            try {
                set = (Set) this.uoj.get(i);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(6890);
                }
            }
        }
        if (set != null && set.size() > 0) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                it.next();
                if (this.uoe == null) {
                    this.uoe = new j();
                }
                j jVar = this.uoe;
            }
        }
        AppMethodBeat.o(6890);
    }
}

package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p321l.C27146b.C27147a;
import com.tencent.p177mm.plugin.appbrand.p321l.p1537a.C38413b;
import com.tencent.p177mm.plugin.appbrand.p321l.p1537a.C45634a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.l.m */
public final class C19548m {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    private final Map<String, ConcurrentLinkedQueue<C27147a>> gVq;
    private C2241c hvw;
    private final String ibJ;
    private int ioq;
    private String ior = (C6457e.euQ + "appbrand/");
    private SSLContext ios;
    protected final ArrayList<String> iot = new ArrayList();
    private final ArrayList<C38413b> iov = new ArrayList();
    private final ConcurrentLinkedQueue<C38413b> ipg = new ConcurrentLinkedQueue();

    public C19548m(C2241c c2241c) {
        AppMethodBeat.m2504i(108249);
        this.hvw = c2241c;
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        this.ioq = c38414a.bQy;
        this.ibJ = c38414a.ioo;
        this.ios = C19538j.m30268a(c38414a);
        this.gVq = new Hashtable(10);
        AppMethodBeat.m2505o(108249);
    }

    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:42:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo34743a(JSONObject jSONObject, int i, Map<String, String> map, ArrayList<String> arrayList, int i2, final C27147a c27147a, String str, String str2) {
        AppMethodBeat.m2504i(108250);
        String optString = jSONObject.optString("url");
        String str3 = this.ior + C4995ag.m7428ck(optString) + "temp";
        String CS = C19538j.m30261CS(optString);
        synchronized (this.gVq) {
            try {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                if (this.gVq.get(CS) == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    concurrentLinkedQueue.offer(c27147a);
                    this.gVq.put(CS, concurrentLinkedQueue);
                } else {
                    ((ConcurrentLinkedQueue) this.gVq.get(CS)).offer(c27147a);
                    C4990ab.m7421w("MicroMsg.AppBrandPreloadNetworkDownload", "predownload the same task is working url:%s,size:%d", CS, Integer.valueOf(concurrentLinkedQueue.size()));
                }
            } finally {
                AppMethodBeat.m2505o(108250);
            }
        }
        final String str4 = str;
        int c38413b = new C38413b(this.hvw, CS, str3, this.ibJ, new C45634a() {
            /* renamed from: c */
            public final void mo34728c(String str, String str2, String str3, int i) {
                AppMethodBeat.m2504i(108243);
                C19548m.m30314a(C19548m.this, str4);
                Iterator it = ((ConcurrentLinkedQueue) C19548m.this.gVq.get(str3)).iterator();
                while (it.hasNext()) {
                    ((C27147a) it.next()).mo21951c(C19548m.SUCCESS, str2, str, i);
                }
                C4990ab.m7417i("MicroMsg.AppBrandPreloadNetworkDownload", "download success! filename %s, url %s", str, str3);
                AppMethodBeat.m2505o(108243);
            }

            /* renamed from: p */
            public final void mo34730p(JSONObject jSONObject) {
                AppMethodBeat.m2504i(108244);
                c27147a.mo21953p(jSONObject);
                AppMethodBeat.m2505o(108244);
            }

            /* renamed from: a */
            public final void mo34727a(String str, int i, long j, long j2) {
                AppMethodBeat.m2504i(108245);
                Iterator it = ((ConcurrentLinkedQueue) C19548m.this.gVq.get(str)).iterator();
                while (it.hasNext()) {
                    ((C27147a) it.next()).mo21952g(i, j, j2);
                }
                AppMethodBeat.m2505o(108245);
            }

            /* renamed from: E */
            public final void mo34726E(String str, String str2, String str3) {
                AppMethodBeat.m2504i(108246);
                C4990ab.m7413e("MicroMsg.AppBrandPreloadNetworkDownload", "download error! filename %s, url %s", str, str2);
                Iterator it = ((ConcurrentLinkedQueue) C19548m.this.gVq.get(str2)).iterator();
                while (it.hasNext()) {
                    C27147a c27147a = (C27147a) it.next();
                    int i = C19548m.FAILED;
                    c27147a.mo21950AD(str3);
                }
                C19548m.m30314a(C19548m.this, str4);
                AppMethodBeat.m2505o(108246);
            }

            /* renamed from: cH */
            public final void mo34729cH(String str, String str2) {
                AppMethodBeat.m2504i(108247);
                C4990ab.m7417i("MicroMsg.AppBrandPreloadNetworkDownload", "download start! filename %s, url %s", str, str2);
                AppMethodBeat.m2505o(108247);
            }

            /* renamed from: CI */
            public final void mo34725CI(String str) {
                AppMethodBeat.m2504i(108248);
                C19548m.this.iot.remove(str);
                AppMethodBeat.m2505o(108248);
            }
        });
        c38413b.ipC = map;
        c38413b.azs = i;
        c38413b.isRunning = true;
        c38413b.ioN = arrayList;
        c38413b.ipD = i2;
        c38413b.ios = this.ios;
        c38413b.hvr = str;
        c38413b.ioR = str2;
        ArrayList arrayList2 = this.iov;
        synchronized (arrayList2) {
            try {
                if (this.iov.size() >= this.ioq) {
                    synchronized (this.ipg) {
                        this.ipg.add(c38413b);
                    }
                } else {
                    this.iov.add(c38413b);
                    C7305d.post(c38413b, "appbrand_predownload_thread");
                }
            } catch (Throwable th) {
                c38413b = th;
                AppMethodBeat.m2505o(arrayList2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108250);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m30314a(C19548m c19548m, String str) {
        AppMethodBeat.m2504i(108251);
        if (str != null) {
            synchronized (c19548m.iov) {
                try {
                    C38413b c38413b;
                    Iterator it = c19548m.iov.iterator();
                    while (it.hasNext()) {
                        c38413b = (C38413b) it.next();
                        if (str.equals(c38413b.hvr)) {
                            c19548m.iov.remove(c38413b);
                            break;
                        }
                    }
                    if (c19548m.iov.size() < c19548m.ioq && c19548m.ipg.peek() != null) {
                        c38413b = (C38413b) c19548m.ipg.poll();
                        c19548m.iov.add(c38413b);
                        C7305d.post(c38413b, "appbrand_preload_download_thread");
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108251);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(108251);
    }
}

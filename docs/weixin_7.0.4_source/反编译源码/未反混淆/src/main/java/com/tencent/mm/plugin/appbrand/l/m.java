package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.a.b;
import com.tencent.mm.plugin.appbrand.l.b.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class m {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    private final Map<String, ConcurrentLinkedQueue<a>> gVq;
    private c hvw;
    private final String ibJ;
    private int ioq;
    private String ior = (e.euQ + "appbrand/");
    private SSLContext ios;
    protected final ArrayList<String> iot = new ArrayList();
    private final ArrayList<b> iov = new ArrayList();
    private final ConcurrentLinkedQueue<b> ipg = new ConcurrentLinkedQueue();

    public m(c cVar) {
        AppMethodBeat.i(108249);
        this.hvw = cVar;
        a aVar = (a) cVar.aa(a.class);
        this.ioq = aVar.bQy;
        this.ibJ = aVar.ioo;
        this.ios = j.a(aVar);
        this.gVq = new Hashtable(10);
        AppMethodBeat.o(108249);
    }

    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:42:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(JSONObject jSONObject, int i, Map<String, String> map, ArrayList<String> arrayList, int i2, final a aVar, String str, String str2) {
        AppMethodBeat.i(108250);
        String optString = jSONObject.optString("url");
        String str3 = this.ior + ag.ck(optString) + "temp";
        String CS = j.CS(optString);
        synchronized (this.gVq) {
            try {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                if (this.gVq.get(CS) == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    concurrentLinkedQueue.offer(aVar);
                    this.gVq.put(CS, concurrentLinkedQueue);
                } else {
                    ((ConcurrentLinkedQueue) this.gVq.get(CS)).offer(aVar);
                    ab.w("MicroMsg.AppBrandPreloadNetworkDownload", "predownload the same task is working url:%s,size:%d", CS, Integer.valueOf(concurrentLinkedQueue.size()));
                }
            } finally {
                AppMethodBeat.o(108250);
            }
        }
        final String str4 = str;
        int bVar = new b(this.hvw, CS, str3, this.ibJ, new com.tencent.mm.plugin.appbrand.l.a.a() {
            public final void c(String str, String str2, String str3, int i) {
                AppMethodBeat.i(108243);
                m.a(m.this, str4);
                Iterator it = ((ConcurrentLinkedQueue) m.this.gVq.get(str3)).iterator();
                while (it.hasNext()) {
                    ((a) it.next()).c(m.SUCCESS, str2, str, i);
                }
                ab.i("MicroMsg.AppBrandPreloadNetworkDownload", "download success! filename %s, url %s", str, str3);
                AppMethodBeat.o(108243);
            }

            public final void p(JSONObject jSONObject) {
                AppMethodBeat.i(108244);
                aVar.p(jSONObject);
                AppMethodBeat.o(108244);
            }

            public final void a(String str, int i, long j, long j2) {
                AppMethodBeat.i(108245);
                Iterator it = ((ConcurrentLinkedQueue) m.this.gVq.get(str)).iterator();
                while (it.hasNext()) {
                    ((a) it.next()).g(i, j, j2);
                }
                AppMethodBeat.o(108245);
            }

            public final void E(String str, String str2, String str3) {
                AppMethodBeat.i(108246);
                ab.e("MicroMsg.AppBrandPreloadNetworkDownload", "download error! filename %s, url %s", str, str2);
                Iterator it = ((ConcurrentLinkedQueue) m.this.gVq.get(str2)).iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    int i = m.FAILED;
                    aVar.AD(str3);
                }
                m.a(m.this, str4);
                AppMethodBeat.o(108246);
            }

            public final void cH(String str, String str2) {
                AppMethodBeat.i(108247);
                ab.i("MicroMsg.AppBrandPreloadNetworkDownload", "download start! filename %s, url %s", str, str2);
                AppMethodBeat.o(108247);
            }

            public final void CI(String str) {
                AppMethodBeat.i(108248);
                m.this.iot.remove(str);
                AppMethodBeat.o(108248);
            }
        });
        bVar.ipC = map;
        bVar.azs = i;
        bVar.isRunning = true;
        bVar.ioN = arrayList;
        bVar.ipD = i2;
        bVar.ios = this.ios;
        bVar.hvr = str;
        bVar.ioR = str2;
        ArrayList arrayList2 = this.iov;
        synchronized (arrayList2) {
            try {
                if (this.iov.size() >= this.ioq) {
                    synchronized (this.ipg) {
                        this.ipg.add(bVar);
                    }
                } else {
                    this.iov.add(bVar);
                    d.post(bVar, "appbrand_predownload_thread");
                }
            } catch (Throwable th) {
                bVar = th;
                AppMethodBeat.o(arrayList2);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108250);
            }
        }
    }

    static /* synthetic */ void a(m mVar, String str) {
        AppMethodBeat.i(108251);
        if (str != null) {
            synchronized (mVar.iov) {
                try {
                    b bVar;
                    Iterator it = mVar.iov.iterator();
                    while (it.hasNext()) {
                        bVar = (b) it.next();
                        if (str.equals(bVar.hvr)) {
                            mVar.iov.remove(bVar);
                            break;
                        }
                    }
                    if (mVar.iov.size() < mVar.ioq && mVar.ipg.peek() != null) {
                        bVar = (b) mVar.ipg.poll();
                        mVar.iov.add(bVar);
                        d.post(bVar, "appbrand_preload_download_thread");
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108251);
                }
            }
            return;
        }
        AppMethodBeat.o(108251);
    }
}

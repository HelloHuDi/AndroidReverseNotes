package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class b {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public c hvw;
    public final String ibJ;
    public int ioq;
    public String ior = (e.euQ + "appbrand/");
    public SSLContext ios;
    protected final ArrayList<String> iot = new ArrayList();
    public final Map<String, ConcurrentLinkedQueue<Runnable>> iou;
    public final ArrayList<com.tencent.mm.plugin.appbrand.l.a.b> iov = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.appbrand.l.b$1 */
    public class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.l.a.a {
        final /* synthetic */ String hvm;
        final /* synthetic */ a iow;

        public AnonymousClass1(String str, a aVar) {
            this.hvm = str;
            this.iow = aVar;
        }

        public final void c(String str, String str2, String str3, int i) {
            AppMethodBeat.i(108127);
            b.a(b.this, this.hvm);
            this.iow.c(b.SUCCESS, str2, str, i);
            ab.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", str, str3);
            AppMethodBeat.o(108127);
        }

        public final void p(JSONObject jSONObject) {
            AppMethodBeat.i(108128);
            this.iow.p(jSONObject);
            AppMethodBeat.o(108128);
        }

        public final void a(String str, int i, long j, long j2) {
            AppMethodBeat.i(108129);
            this.iow.g(i, j, j2);
            AppMethodBeat.o(108129);
        }

        public final void E(String str, String str2, String str3) {
            AppMethodBeat.i(108130);
            ab.e("MicroMsg.AppBrandNetworkDownload", "download error! errorMessage:%s, filename %s, url %s", str3, str, str2);
            b.a(b.this, this.hvm);
            a aVar = this.iow;
            int i = b.FAILED;
            aVar.AD(str3);
            AppMethodBeat.o(108130);
        }

        public final void cH(String str, String str2) {
            AppMethodBeat.i(108131);
            ab.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", str, str2);
            AppMethodBeat.o(108131);
        }

        public final void CI(String str) {
            AppMethodBeat.i(108132);
            b.this.iot.remove(str);
            AppMethodBeat.o(108132);
        }
    }

    public interface a {
        void AD(String str);

        void c(int i, String str, String str2, int i2);

        void g(int i, long j, long j2);

        void p(JSONObject jSONObject);
    }

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(108140);
        bVar.kP(str);
        AppMethodBeat.o(108140);
    }

    static /* synthetic */ void b(b bVar, String str) {
        AppMethodBeat.i(108141);
        bVar.CF(str);
        AppMethodBeat.o(108141);
    }

    public b(c cVar) {
        AppMethodBeat.i(108134);
        this.hvw = cVar;
        a aVar = (a) cVar.aa(a.class);
        this.ioq = aVar.bQy;
        this.ibJ = aVar.ioo;
        this.ios = j.a(aVar);
        this.iou = new Hashtable(10);
        AppMethodBeat.o(108134);
    }

    public final void CF(final String str) {
        AppMethodBeat.i(108135);
        d.post(new Runnable() {
            public final void run() {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                Runnable runnable;
                AppMethodBeat.i(108133);
                synchronized (b.this.iou) {
                    try {
                        concurrentLinkedQueue = (ConcurrentLinkedQueue) b.this.iou.get(str);
                        ab.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", str, Integer.valueOf(concurrentLinkedQueue.size()));
                        runnable = (Runnable) concurrentLinkedQueue.peek();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(108133);
                        }
                    }
                }
                if (runnable != null) {
                    runnable.run();
                    concurrentLinkedQueue.poll();
                    if (concurrentLinkedQueue.size() > 0) {
                        ab.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
                        b.b(b.this, str);
                    }
                }
                AppMethodBeat.o(108133);
            }
        }, "appbrand_download_thread");
        AppMethodBeat.o(108135);
    }

    private void kP(String str) {
        AppMethodBeat.i(108136);
        if (str == null) {
            AppMethodBeat.o(108136);
            return;
        }
        synchronized (this.iov) {
            try {
                Iterator it = this.iov.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.appbrand.l.a.b bVar = (com.tencent.mm.plugin.appbrand.l.a.b) it.next();
                    if (str.equals(bVar.hvr)) {
                        this.iov.remove(bVar);
                        break;
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108136);
            }
        }
    }

    public final com.tencent.mm.plugin.appbrand.l.a.b CG(String str) {
        com.tencent.mm.plugin.appbrand.l.a.b bVar;
        AppMethodBeat.i(108137);
        if (str == null) {
            AppMethodBeat.o(108137);
            return null;
        }
        synchronized (this.iov) {
            try {
                Iterator it = this.iov.iterator();
                while (it.hasNext()) {
                    bVar = (com.tencent.mm.plugin.appbrand.l.a.b) it.next();
                    if (str.equals(bVar.hvr)) {
                    }
                }
                AppMethodBeat.o(108137);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108137);
            }
        }
        return bVar;
    }

    public final void a(com.tencent.mm.plugin.appbrand.l.a.b bVar) {
        AppMethodBeat.i(108138);
        if (bVar == null) {
            AppMethodBeat.o(108138);
            return;
        }
        this.iot.add(bVar.hvr);
        kP(bVar.hvr);
        bVar.aIP();
        AppMethodBeat.o(108138);
    }

    public final boolean CH(String str) {
        AppMethodBeat.i(108139);
        boolean contains = this.iot.contains(str);
        AppMethodBeat.o(108139);
        return contains;
    }
}

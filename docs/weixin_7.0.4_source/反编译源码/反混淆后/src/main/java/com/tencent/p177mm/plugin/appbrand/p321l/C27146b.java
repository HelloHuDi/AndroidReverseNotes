package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p321l.p1537a.C38413b;
import com.tencent.p177mm.plugin.appbrand.p321l.p1537a.C45634a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.l.b */
public final class C27146b {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public C2241c hvw;
    public final String ibJ;
    public int ioq;
    public String ior = (C6457e.euQ + "appbrand/");
    public SSLContext ios;
    protected final ArrayList<String> iot = new ArrayList();
    public final Map<String, ConcurrentLinkedQueue<Runnable>> iou;
    public final ArrayList<C38413b> iov = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.appbrand.l.b$1 */
    public class C195371 implements C45634a {
        final /* synthetic */ String hvm;
        final /* synthetic */ C27147a iow;

        public C195371(String str, C27147a c27147a) {
            this.hvm = str;
            this.iow = c27147a;
        }

        /* renamed from: c */
        public final void mo34728c(String str, String str2, String str3, int i) {
            AppMethodBeat.m2504i(108127);
            C27146b.m43140a(C27146b.this, this.hvm);
            this.iow.mo21951c(C27146b.SUCCESS, str2, str, i);
            C4990ab.m7417i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", str, str3);
            AppMethodBeat.m2505o(108127);
        }

        /* renamed from: p */
        public final void mo34730p(JSONObject jSONObject) {
            AppMethodBeat.m2504i(108128);
            this.iow.mo21953p(jSONObject);
            AppMethodBeat.m2505o(108128);
        }

        /* renamed from: a */
        public final void mo34727a(String str, int i, long j, long j2) {
            AppMethodBeat.m2504i(108129);
            this.iow.mo21952g(i, j, j2);
            AppMethodBeat.m2505o(108129);
        }

        /* renamed from: E */
        public final void mo34726E(String str, String str2, String str3) {
            AppMethodBeat.m2504i(108130);
            C4990ab.m7413e("MicroMsg.AppBrandNetworkDownload", "download error! errorMessage:%s, filename %s, url %s", str3, str, str2);
            C27146b.m43140a(C27146b.this, this.hvm);
            C27147a c27147a = this.iow;
            int i = C27146b.FAILED;
            c27147a.mo21950AD(str3);
            AppMethodBeat.m2505o(108130);
        }

        /* renamed from: cH */
        public final void mo34729cH(String str, String str2) {
            AppMethodBeat.m2504i(108131);
            C4990ab.m7417i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", str, str2);
            AppMethodBeat.m2505o(108131);
        }

        /* renamed from: CI */
        public final void mo34725CI(String str) {
            AppMethodBeat.m2504i(108132);
            C27146b.this.iot.remove(str);
            AppMethodBeat.m2505o(108132);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.b$a */
    public interface C27147a {
        /* renamed from: AD */
        void mo21950AD(String str);

        /* renamed from: c */
        void mo21951c(int i, String str, String str2, int i2);

        /* renamed from: g */
        void mo21952g(int i, long j, long j2);

        /* renamed from: p */
        void mo21953p(JSONObject jSONObject);
    }

    /* renamed from: a */
    static /* synthetic */ void m43140a(C27146b c27146b, String str) {
        AppMethodBeat.m2504i(108140);
        c27146b.m43142kP(str);
        AppMethodBeat.m2505o(108140);
    }

    /* renamed from: b */
    static /* synthetic */ void m43141b(C27146b c27146b, String str) {
        AppMethodBeat.m2504i(108141);
        c27146b.mo44817CF(str);
        AppMethodBeat.m2505o(108141);
    }

    public C27146b(C2241c c2241c) {
        AppMethodBeat.m2504i(108134);
        this.hvw = c2241c;
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        this.ioq = c38414a.bQy;
        this.ibJ = c38414a.ioo;
        this.ios = C19538j.m30268a(c38414a);
        this.iou = new Hashtable(10);
        AppMethodBeat.m2505o(108134);
    }

    /* renamed from: CF */
    public final void mo44817CF(final String str) {
        AppMethodBeat.m2504i(108135);
        C7305d.post(new Runnable() {
            public final void run() {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                Runnable runnable;
                AppMethodBeat.m2504i(108133);
                synchronized (C27146b.this.iou) {
                    try {
                        concurrentLinkedQueue = (ConcurrentLinkedQueue) C27146b.this.iou.get(str);
                        C4990ab.m7411d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", str, Integer.valueOf(concurrentLinkedQueue.size()));
                        runnable = (Runnable) concurrentLinkedQueue.peek();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(108133);
                        }
                    }
                }
                if (runnable != null) {
                    runnable.run();
                    concurrentLinkedQueue.poll();
                    if (concurrentLinkedQueue.size() > 0) {
                        C4990ab.m7416i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
                        C27146b.m43141b(C27146b.this, str);
                    }
                }
                AppMethodBeat.m2505o(108133);
            }
        }, "appbrand_download_thread");
        AppMethodBeat.m2505o(108135);
    }

    /* renamed from: kP */
    private void m43142kP(String str) {
        AppMethodBeat.m2504i(108136);
        if (str == null) {
            AppMethodBeat.m2505o(108136);
            return;
        }
        synchronized (this.iov) {
            try {
                Iterator it = this.iov.iterator();
                while (it.hasNext()) {
                    C38413b c38413b = (C38413b) it.next();
                    if (str.equals(c38413b.hvr)) {
                        this.iov.remove(c38413b);
                        break;
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108136);
            }
        }
    }

    /* renamed from: CG */
    public final C38413b mo44818CG(String str) {
        C38413b c38413b;
        AppMethodBeat.m2504i(108137);
        if (str == null) {
            AppMethodBeat.m2505o(108137);
            return null;
        }
        synchronized (this.iov) {
            try {
                Iterator it = this.iov.iterator();
                while (it.hasNext()) {
                    c38413b = (C38413b) it.next();
                    if (str.equals(c38413b.hvr)) {
                    }
                }
                AppMethodBeat.m2505o(108137);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108137);
            }
        }
        return c38413b;
    }

    /* renamed from: a */
    public final void mo44820a(C38413b c38413b) {
        AppMethodBeat.m2504i(108138);
        if (c38413b == null) {
            AppMethodBeat.m2505o(108138);
            return;
        }
        this.iot.add(c38413b.hvr);
        m43142kP(c38413b.hvr);
        c38413b.aIP();
        AppMethodBeat.m2505o(108138);
    }

    /* renamed from: CH */
    public final boolean mo44819CH(String str) {
        AppMethodBeat.m2504i(108139);
        boolean contains = this.iot.contains(str);
        AppMethodBeat.m2505o(108139);
        return contains;
    }
}

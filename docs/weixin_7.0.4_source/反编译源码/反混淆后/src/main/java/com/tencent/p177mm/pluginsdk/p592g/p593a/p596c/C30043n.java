package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C18172y;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4717a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4718d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4720c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.n */
public class C30043n extends C4716f<C35792l> {
    private final C4717a vfp;
    protected final C40430c vfq;

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.n$c */
    static final class C4727c extends PriorityBlockingQueue<Runnable> {

        /* renamed from: com.tencent.mm.pluginsdk.g.a.c.n$c$1 */
        class C47281 implements Comparator<Runnable> {
            C47281() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                int random;
                AppMethodBeat.m2504i(79592);
                Runnable runnable = (Runnable) obj;
                Runnable runnable2 = (Runnable) obj2;
                if ((runnable instanceof C4720c) && (runnable2 instanceof C4720c) && (((C4720c) runnable).vfb instanceof C35792l) && (((C4720c) runnable2).vfb instanceof C35792l)) {
                    C35792l c35792l = (C35792l) ((C4720c) runnable).vfb;
                    C35792l c35792l2 = (C35792l) ((C4720c) runnable2).vfb;
                    int i = c35792l.priority - c35792l2.priority;
                    random = (c35792l.dig() && c35792l2.dig()) ? i != 0 ? i : ((int) (Math.random() * 50.0d)) - 25 : i;
                } else {
                    random = 0;
                }
                random = 0 - random;
                AppMethodBeat.m2505o(79592);
                return random;
            }
        }

        public final /* synthetic */ boolean offer(Object obj) {
            AppMethodBeat.m2504i(79596);
            Runnable runnable = (Runnable) obj;
            boolean offer = super.offer(runnable);
            C4990ab.m7411d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + C4727c.m7076ac(runnable), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(79596);
            return offer;
        }

        public C4727c() {
            super(11, new C47281());
            AppMethodBeat.m2504i(79593);
            AppMethodBeat.m2505o(79593);
        }

        /* renamed from: ac */
        private static String m7076ac(Runnable runnable) {
            AppMethodBeat.m2504i(79594);
            String format;
            if (!(runnable instanceof C4720c)) {
                format = String.format("unknown runnable = %s", new Object[]{runnable});
                AppMethodBeat.m2505o(79594);
                return format;
            } else if (((C4720c) runnable).vfb instanceof C35792l) {
                format = String.format("priority = %d, urlKey = %s", new Object[]{Integer.valueOf(((C35792l) ((C4720c) runnable).vfb).priority), ((C4720c) runnable).vfb.dib()});
                AppMethodBeat.m2505o(79594);
                return format;
            } else {
                format = String.format("unknown request = %s", new Object[]{((C4720c) runnable).vfb});
                AppMethodBeat.m2505o(79594);
                return format;
            }
        }

        public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
            AppMethodBeat.m2504i(79595);
            Runnable runnable = (Runnable) super.poll(j, timeUnit);
            if (runnable != null) {
                C4990ab.m7411d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + C4727c.m7076ac(runnable), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.m2505o(79595);
            return runnable;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.n$a */
    public static abstract class C30044a<Req extends C35792l> extends C4718d<Req> implements C4715e {
        private static final ThreadLocal<C35791j> vfr = new C232391();
        private final int vdM;
        private final AtomicInteger vfs = new AtomicInteger(this.vdM);
        public volatile C40430c vft;

        /* renamed from: com.tencent.mm.pluginsdk.g.a.c.n$a$1 */
        static class C232391 extends ThreadLocal<C35791j> {
            C232391() {
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object initialValue() {
                AppMethodBeat.m2504i(79591);
                C35791j c35791j = new C35791j();
                AppMethodBeat.m2505o(79591);
                return c35791j;
            }
        }

        protected C30044a(Req req) {
            super(req);
            this.vdM = req.vdM;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public C40432m mo9630a(C35791j c35791j) {
            if (!awe()) {
                return C35791j.m58654a(this);
            }
            C44049s ajg = C14857a.vfA.ajg(dib());
            if (ajg != null) {
                ajg.field_status = 1;
                C14857a.vfA.mo27179h(ajg);
            }
            return C35791j.m58654a(this);
        }

        /* Access modifiers changed, original: protected */
        public boolean awe() {
            return true;
        }

        public final void run() {
            C40432m a = mo9630a((C35791j) vfr.get());
            if (a != null) {
                this.vft.mo9858a((C4715e) this, a);
                return;
            }
            C4990ab.m7413e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", awa());
        }

        public boolean awb() {
            return false;
        }

        public boolean awc() {
            return true;
        }

        public boolean awd() {
            return false;
        }

        public boolean awf() {
            return true;
        }

        public String getURL() {
            return ((C35792l) awh()).url;
        }

        public final String dis() {
            return "GET";
        }

        public final Collection<C35789b> dit() {
            Map requestHeaders = ((C35792l) awh()).getRequestHeaders();
            if (requestHeaders == null || requestHeaders.size() == 0) {
                return null;
            }
            Set<String> keySet = requestHeaders.keySet();
            if (keySet == null || keySet.size() == 0) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (String str : keySet) {
                String str2 = (String) requestHeaders.get(str);
                if (!C5046bo.isNullOrNil(str2)) {
                    linkedList.add(new C35789b(str, str2));
                }
            }
            return linkedList;
        }

        public final int getConnectTimeout() {
            return ((C35792l) awh()).getConnectTimeout();
        }

        public final int getReadTimeout() {
            return ((C35792l) awh()).getReadTimeout();
        }

        public final int diu() {
            return ((C35792l) awh()).diu();
        }

        public final String div() {
            return "application/x-www-form-urlencoded;charset=utf-8";
        }

        public final String dib() {
            return ((C35792l) awh()).vdC;
        }

        public final String getFilePath() {
            return ((C35792l) awh()).getFilePath();
        }

        public boolean awg() {
            boolean z;
            if (this.vfs.decrementAndGet() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.vft.mo9861u(dib(), this.vdM, this.vfs.get());
            return z;
        }

        /* renamed from: gh */
        public boolean mo9636gh(long j) {
            this.vft.mo9862w(dib(), j);
            C4990ab.m7417i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", dib(), Long.valueOf(C5034bd.dpq()));
            if (C5034bd.dpq() >= j) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.n$b */
    static class C30045b extends C30044a<C35792l> {
        C30045b(C35792l c35792l) {
            super(c35792l);
        }

        public final String awa() {
            return "ResDownload";
        }
    }

    public C30043n(C44051u c44051u, C40430c c40430c) {
        this(c44051u, c40430c, (byte) 0);
    }

    private C30043n(C44051u c44051u, C40430c c40430c, byte b) {
        AppMethodBeat.m2504i(79597);
        this.vfp = new C4717a(4, 4, 3000, TimeUnit.MILLISECONDS, new C4727c(), c44051u);
        this.vfp.setKeepAliveTime(30000, TimeUnit.MILLISECONDS);
        this.vfp.allowCoreThreadTimeOut(true);
        this.vfq = c40430c;
        AppMethodBeat.m2505o(79597);
    }

    /* Access modifiers changed, original: protected|final */
    public final C4717a dik() {
        return this.vfp;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C4718d mo21433a(C35792l c35792l) {
        AppMethodBeat.m2504i(79600);
        C4990ab.m7416i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + c35792l.getClass().getSimpleName());
        C14857a.vfA;
        C30044a c = C14856q.m23117c(c35792l);
        if (c == null) {
            C4990ab.m7416i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c = new C30045b(c35792l);
        }
        c.vft = this.vfq;
        AppMethodBeat.m2505o(79600);
        return c;
    }

    public void shutdown() {
        AppMethodBeat.m2504i(79601);
        this.vfp.shutdownNow();
        for (String str : this.veZ.keySet()) {
            Future future = (Future) this.veZ.get(str);
            if (future != null) {
                future.cancel(true);
            }
        }
        this.pendingRequests.clear();
        this.veZ.clear();
        AppMethodBeat.m2505o(79601);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public int mo21434b(C35792l c35792l) {
        int i = 0;
        AppMethodBeat.m2504i(79598);
        if (ajd(c35792l.vdC) || ajc(c35792l.vdC)) {
            C4990ab.m7417i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", c35792l.vdC);
            AppMethodBeat.m2505o(79598);
            return 0;
        }
        int Me = C18172y.m28611Me();
        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", Integer.valueOf(Me), Integer.valueOf(c35792l.networkType));
        if (Me != 0) {
            if (2 == c35792l.networkType) {
                Me = 1;
            } else if (Me == 1) {
                Me = 1;
            }
            if (Me != 0) {
                C4990ab.m7417i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", c35792l.vdC);
                AppMethodBeat.m2505o(79598);
                return 1;
            }
            if (this.vfp.isShutdown() || this.vfp.isTerminated() || this.vfp.isTerminating()) {
                i = 1;
            }
            if (i != 0) {
                AppMethodBeat.m2505o(79598);
                return 4;
            }
            super.mo9848b(c35792l);
            AppMethodBeat.m2505o(79598);
            return 2;
        }
        Me = 0;
        if (Me != 0) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void ajf(String str) {
        AppMethodBeat.m2504i(79599);
        Future future = (Future) this.veZ.remove(str);
        if (future != null) {
            future.cancel(true);
        }
        this.pendingRequests.remove(str);
        AppMethodBeat.m2505o(79599);
    }
}

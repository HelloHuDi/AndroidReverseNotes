package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class n extends f<l> {
    private final com.tencent.mm.pluginsdk.g.a.c.f.a vfp;
    protected final c vfq;

    static final class c extends PriorityBlockingQueue<Runnable> {
        public final /* synthetic */ boolean offer(Object obj) {
            AppMethodBeat.i(79596);
            Runnable runnable = (Runnable) obj;
            boolean offer = super.offer(runnable);
            ab.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + ac(runnable), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(79596);
            return offer;
        }

        public c() {
            super(11, new Comparator<Runnable>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    int random;
                    AppMethodBeat.i(79592);
                    Runnable runnable = (Runnable) obj;
                    Runnable runnable2 = (Runnable) obj2;
                    if ((runnable instanceof c) && (runnable2 instanceof c) && (((c) runnable).vfb instanceof l) && (((c) runnable2).vfb instanceof l)) {
                        l lVar = (l) ((c) runnable).vfb;
                        l lVar2 = (l) ((c) runnable2).vfb;
                        int i = lVar.priority - lVar2.priority;
                        random = (lVar.dig() && lVar2.dig()) ? i != 0 ? i : ((int) (Math.random() * 50.0d)) - 25 : i;
                    } else {
                        random = 0;
                    }
                    random = 0 - random;
                    AppMethodBeat.o(79592);
                    return random;
                }
            });
            AppMethodBeat.i(79593);
            AppMethodBeat.o(79593);
        }

        private static String ac(Runnable runnable) {
            AppMethodBeat.i(79594);
            String format;
            if (!(runnable instanceof c)) {
                format = String.format("unknown runnable = %s", new Object[]{runnable});
                AppMethodBeat.o(79594);
                return format;
            } else if (((c) runnable).vfb instanceof l) {
                format = String.format("priority = %d, urlKey = %s", new Object[]{Integer.valueOf(((l) ((c) runnable).vfb).priority), ((c) runnable).vfb.dib()});
                AppMethodBeat.o(79594);
                return format;
            } else {
                format = String.format("unknown request = %s", new Object[]{((c) runnable).vfb});
                AppMethodBeat.o(79594);
                return format;
            }
        }

        public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
            AppMethodBeat.i(79595);
            Runnable runnable = (Runnable) super.poll(j, timeUnit);
            if (runnable != null) {
                ab.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + ac(runnable), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.o(79595);
            return runnable;
        }
    }

    public static abstract class a<Req extends l> extends d<Req> implements e {
        private static final ThreadLocal<j> vfr = new ThreadLocal<j>() {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object initialValue() {
                AppMethodBeat.i(79591);
                j jVar = new j();
                AppMethodBeat.o(79591);
                return jVar;
            }
        };
        private final int vdM;
        private final AtomicInteger vfs = new AtomicInteger(this.vdM);
        public volatile c vft;

        protected a(Req req) {
            super(req);
            this.vdM = req.vdM;
        }

        /* Access modifiers changed, original: protected */
        public m a(j jVar) {
            if (!awe()) {
                return j.a(this);
            }
            s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(dib());
            if (ajg != null) {
                ajg.field_status = 1;
                com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
            }
            return j.a(this);
        }

        /* Access modifiers changed, original: protected */
        public boolean awe() {
            return true;
        }

        public final void run() {
            m a = a((j) vfr.get());
            if (a != null) {
                this.vft.a((e) this, a);
                return;
            }
            ab.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", awa());
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
            return ((l) awh()).url;
        }

        public final String dis() {
            return "GET";
        }

        public final Collection<b> dit() {
            Map requestHeaders = ((l) awh()).getRequestHeaders();
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
                if (!bo.isNullOrNil(str2)) {
                    linkedList.add(new b(str, str2));
                }
            }
            return linkedList;
        }

        public final int getConnectTimeout() {
            return ((l) awh()).getConnectTimeout();
        }

        public final int getReadTimeout() {
            return ((l) awh()).getReadTimeout();
        }

        public final int diu() {
            return ((l) awh()).diu();
        }

        public final String div() {
            return "application/x-www-form-urlencoded;charset=utf-8";
        }

        public final String dib() {
            return ((l) awh()).vdC;
        }

        public final String getFilePath() {
            return ((l) awh()).getFilePath();
        }

        public boolean awg() {
            boolean z;
            if (this.vfs.decrementAndGet() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.vft.u(dib(), this.vdM, this.vfs.get());
            return z;
        }

        public boolean gh(long j) {
            this.vft.w(dib(), j);
            ab.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", dib(), Long.valueOf(bd.dpq()));
            if (bd.dpq() >= j) {
                return true;
            }
            return false;
        }
    }

    static class b extends a<l> {
        b(l lVar) {
            super(lVar);
        }

        public final String awa() {
            return "ResDownload";
        }
    }

    public n(u uVar, c cVar) {
        this(uVar, cVar, (byte) 0);
    }

    private n(u uVar, c cVar, byte b) {
        AppMethodBeat.i(79597);
        this.vfp = new com.tencent.mm.pluginsdk.g.a.c.f.a(4, 4, 3000, TimeUnit.MILLISECONDS, new c(), uVar);
        this.vfp.setKeepAliveTime(30000, TimeUnit.MILLISECONDS);
        this.vfp.allowCoreThreadTimeOut(true);
        this.vfq = cVar;
        AppMethodBeat.o(79597);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.pluginsdk.g.a.c.f.a dik() {
        return this.vfp;
    }

    /* Access modifiers changed, original: protected */
    public d a(l lVar) {
        AppMethodBeat.i(79600);
        ab.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + lVar.getClass().getSimpleName());
        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA;
        a c = q.c(lVar);
        if (c == null) {
            ab.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c = new b(lVar);
        }
        c.vft = this.vfq;
        AppMethodBeat.o(79600);
        return c;
    }

    public void shutdown() {
        AppMethodBeat.i(79601);
        this.vfp.shutdownNow();
        for (String str : this.veZ.keySet()) {
            Future future = (Future) this.veZ.get(str);
            if (future != null) {
                future.cancel(true);
            }
        }
        this.pendingRequests.clear();
        this.veZ.clear();
        AppMethodBeat.o(79601);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(l lVar) {
        int i = 0;
        AppMethodBeat.i(79598);
        if (ajd(lVar.vdC) || ajc(lVar.vdC)) {
            ab.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", lVar.vdC);
            AppMethodBeat.o(79598);
            return 0;
        }
        int Me = y.Me();
        ab.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", Integer.valueOf(Me), Integer.valueOf(lVar.networkType));
        if (Me != 0) {
            if (2 == lVar.networkType) {
                Me = 1;
            } else if (Me == 1) {
                Me = 1;
            }
            if (Me != 0) {
                ab.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", lVar.vdC);
                AppMethodBeat.o(79598);
                return 1;
            }
            if (this.vfp.isShutdown() || this.vfp.isTerminated() || this.vfp.isTerminating()) {
                i = 1;
            }
            if (i != 0) {
                AppMethodBeat.o(79598);
                return 4;
            }
            super.b(lVar);
            AppMethodBeat.o(79598);
            return 2;
        }
        Me = 0;
        if (Me != 0) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void ajf(String str) {
        AppMethodBeat.i(79599);
        Future future = (Future) this.veZ.remove(str);
        if (future != null) {
            future.cancel(true);
        }
        this.pendingRequests.remove(str);
        AppMethodBeat.o(79599);
    }
}

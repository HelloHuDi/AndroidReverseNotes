package com.tencent.p177mm.sdk.p604g.p606b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p605a.C4939b;
import com.tencent.p177mm.sdk.p604g.p606b.C4947b.C49481;
import com.tencent.p177mm.sdk.p604g.p606b.C7299d.C4950a;
import com.tencent.p177mm.sdk.p604g.p606b.C7299d.C4951b;
import com.tencent.p177mm.sdk.p604g.p607c.C4960c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.tencent.mm.sdk.g.b.e */
public final class C7301e implements C4946a {
    public C4946a xEB;

    /* renamed from: com.tencent.mm.sdk.g.b.e$a */
    class C7300a implements C4951b, RejectedExecutionHandler {
        public HandlerThread xEC;
        Handler xED;

        private C7300a() {
            AppMethodBeat.m2504i(52664);
            this.xEC = C4960c.anN("ThreadPool#FallBackExecutor");
            this.xED = null;
            AppMethodBeat.m2505o(52664);
        }

        /* synthetic */ C7300a(C7301e c7301e, byte b) {
            this();
        }

        /* renamed from: au */
        private void m12272au(Runnable runnable) {
            AppMethodBeat.m2504i(52665);
            if (this.xED == null) {
                synchronized (this.xEC) {
                    try {
                        if (this.xED == null) {
                            if (!this.xEC.isAlive()) {
                                this.xEC.start();
                            }
                            this.xED = new Handler(this.xEC.getLooper());
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(52665);
                        }
                    }
                }
            }
            this.xED.post(runnable);
            AppMethodBeat.m2505o(52665);
        }

        /* renamed from: at */
        public final void mo10182at(Runnable runnable) {
            AppMethodBeat.m2504i(52666);
            m12272au(runnable);
            AppMethodBeat.m2505o(52666);
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AppMethodBeat.m2504i(52667);
            m12272au(runnable);
            AppMethodBeat.m2505o(52667);
        }
    }

    public C7301e(C4939b c4939b, C4950a c4950a) {
        int i = 42;
        AppMethodBeat.m2504i(52668);
        C7300a c7300a = new C7300a(this, (byte) 0);
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 6;
        if (availableProcessors <= 42) {
            if (availableProcessors < 28) {
                i = 28;
            } else {
                i = availableProcessors;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(i * 2);
        C4990ab.m7417i("MicroMsg.ThreadPoolExecutorProxy", "isHandlerThreadPool:%s coreSize:%s", Boolean.TRUE, Integer.valueOf(i));
        this.xEB = new C49481(i, Math.round(0.8f * ((float) i)), linkedBlockingQueue, C4960c.xEI, c7300a, c4950a, c4939b);
        AppMethodBeat.m2505o(52668);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(52669);
        this.xEB.execute(runnable);
        AppMethodBeat.m2505o(52669);
    }

    public final boolean remove(Runnable runnable) {
        AppMethodBeat.m2504i(52670);
        boolean remove = this.xEB.remove(runnable);
        AppMethodBeat.m2505o(52670);
        return remove;
    }

    public final void shutdown() {
        AppMethodBeat.m2504i(52671);
        this.xEB.shutdown();
        AppMethodBeat.m2505o(52671);
    }

    public final void reset() {
        AppMethodBeat.m2504i(52672);
        this.xEB.reset();
        AppMethodBeat.m2505o(52672);
    }

    /* renamed from: p */
    public final void mo10173p(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52673);
        this.xEB.mo10173p(runnable, j);
        AppMethodBeat.m2505o(52673);
    }

    public final int getCorePoolSize() {
        AppMethodBeat.m2504i(52674);
        int corePoolSize = this.xEB.getCorePoolSize();
        AppMethodBeat.m2505o(52674);
        return corePoolSize;
    }
}

package com.tencent.p177mm.sdk.p604g.p607c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p606b.C40613c;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.sdk.g.c.d */
public final class C35984d {

    /* renamed from: com.tencent.mm.sdk.g.c.d$a */
    static class C23495a implements C4946a {
        int cml;
        String name;
        List<C5004al> xEL = new ArrayList();
        AtomicInteger xEM = new AtomicInteger(0);

        public C23495a(String str, int i) {
            AppMethodBeat.m2504i(52693);
            this.cml = i;
            this.name = str;
            reset();
            AppMethodBeat.m2505o(52693);
        }

        public final boolean remove(Runnable runnable) {
            AppMethodBeat.m2504i(52694);
            for (C5004al doN : this.xEL) {
                doN.doN().removeCallbacks(runnable);
            }
            AppMethodBeat.m2505o(52694);
            return true;
        }

        public final void shutdown() {
            AppMethodBeat.m2504i(52695);
            for (C5004al c5004al : this.xEL) {
                c5004al.oAl.quit();
            }
            AppMethodBeat.m2505o(52695);
        }

        public final void reset() {
            AppMethodBeat.m2504i(52696);
            this.xEL.clear();
            for (int i = 0; i < this.cml; i++) {
                this.xEL.add(new C5004al(this.name + i));
            }
            AppMethodBeat.m2505o(52696);
        }

        /* renamed from: p */
        public final void mo10173p(Runnable runnable, long j) {
            AppMethodBeat.m2504i(52697);
            ((C5004al) this.xEL.get(this.xEM.get())).mo10310m(runnable, j);
            dqr();
            AppMethodBeat.m2505o(52697);
        }

        public final int getCorePoolSize() {
            return this.cml;
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.m2504i(52698);
            ((C5004al) this.xEL.get(this.xEM.get())).mo10302aa(runnable);
            dqr();
            AppMethodBeat.m2505o(52698);
        }

        private void dqr() {
            AppMethodBeat.m2504i(52699);
            if (this.xEM.incrementAndGet() >= this.cml) {
                this.xEM.set(0);
            }
            AppMethodBeat.m2505o(52699);
        }
    }

    /* renamed from: a */
    public static C4946a m59189a(String str, BlockingQueue<Runnable> blockingQueue) {
        AppMethodBeat.m2504i(52700);
        if (C7305d.xDC) {
            C23495a c23495a = new C23495a(str, 6);
            AppMethodBeat.m2505o(52700);
            return c23495a;
        }
        C4946a c40613c = new C40613c(str, blockingQueue);
        AppMethodBeat.m2505o(52700);
        return c40613c;
    }

    public static C4946a anP(String str) {
        AppMethodBeat.m2504i(52701);
        if (C7305d.xDC) {
            C23495a c23495a = new C23495a(str, 1);
            AppMethodBeat.m2505o(52701);
            return c23495a;
        }
        C4946a c40613c = new C40613c(str, 1, 1, new LinkedBlockingQueue());
        AppMethodBeat.m2505o(52701);
        return c40613c;
    }
}

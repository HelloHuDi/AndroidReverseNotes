package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dc */
final class C44503dc implements Runnable {
    /* renamed from: a */
    private /* synthetic */ C36492cx f17405a;

    C44503dc(C36492cx c36492cx) {
        this.f17405a = c36492cx;
    }

    public final void run() {
        AppMethodBeat.m2504i(98697);
        if (this.f17405a.f15301g.size() == 0) {
            this.f17405a.f15308n.incrementAndGet();
            this.f17405a.m60354b(false, true);
            AppMethodBeat.m2505o(98697);
            return;
        }
        this.f17405a.m60349a(true, true);
        AppMethodBeat.m2505o(98697);
    }
}

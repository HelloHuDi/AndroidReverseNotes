package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ck */
final class C16214ck implements Runnable {
    /* renamed from: a */
    private /* synthetic */ boolean[] f3184a;
    /* renamed from: b */
    private /* synthetic */ CountDownLatch f3185b;

    C16214ck(boolean[] zArr, CountDownLatch countDownLatch) {
        this.f3184a = zArr;
        this.f3185b = countDownLatch;
    }

    public final void run() {
        AppMethodBeat.m2504i(98641);
        try {
            this.f3184a[0] = C44502cj.m80709b();
        } catch (Exception e) {
        }
        this.f3185b.countDown();
        AppMethodBeat.m2505o(98641);
    }
}

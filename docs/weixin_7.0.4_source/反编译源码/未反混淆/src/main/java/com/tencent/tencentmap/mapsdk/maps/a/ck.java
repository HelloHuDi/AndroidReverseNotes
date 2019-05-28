package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class ck implements Runnable {
    private /* synthetic */ boolean[] a;
    private /* synthetic */ CountDownLatch b;

    ck(boolean[] zArr, CountDownLatch countDownLatch) {
        this.a = zArr;
        this.b = countDownLatch;
    }

    public final void run() {
        AppMethodBeat.i(98641);
        try {
            this.a[0] = cj.b();
        } catch (Exception e) {
        }
        this.b.countDown();
        AppMethodBeat.o(98641);
    }
}

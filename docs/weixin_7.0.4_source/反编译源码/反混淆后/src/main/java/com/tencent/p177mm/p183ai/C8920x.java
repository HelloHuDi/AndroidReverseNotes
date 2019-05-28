package com.tencent.p177mm.p183ai;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.tencent.mm.ai.x */
public final class C8920x {

    /* renamed from: com.tencent.mm.ai.x$a */
    public static class C8921a<T extends btd> extends C37441a<T> {
        public C8921a() {
            this.errType = 3;
            this.errCode = -13;
        }
    }

    /* renamed from: c */
    public static <T extends btd> C37441a<T> m16082c(C7472b c7472b) {
        AppMethodBeat.m2504i(58316);
        if (c7472b == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cant use NULL rr");
            AppMethodBeat.m2505o(58316);
            throw illegalArgumentException;
        }
        C6300p Rh = C1226w.fuq == null ? null : C1226w.fuq.mo4497Rh();
        IllegalAccessError illegalAccessError;
        if (Rh == null) {
            C4990ab.m7412e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            AppMethodBeat.m2505o(58316);
            return null;
        } else if (C5004al.isMainThread()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in main thread");
            AppMethodBeat.m2505o(58316);
            throw illegalAccessError;
        } else if (Rh.ftB.oAl.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
            AppMethodBeat.m2505o(58316);
            throw illegalAccessError;
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            C1226w.m2654a(c7472b, new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(58313);
                    atomicReference.set(C37441a.m63107a(i, i2, str, (btd) c7472b.fsH.fsP, c1207m, null));
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(58313);
                    return 0;
                }
            });
            new C7564ap(Looper.getMainLooper(), new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(58314);
                    atomicReference.set(new C8921a());
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(58314);
                    return false;
                }
            }, false).mo16770ae(20000, 20000);
            try {
                countDownLatch.await();
                C37441a<T> c37441a = (C37441a) atomicReference.get();
                AppMethodBeat.m2505o(58316);
                return c37441a;
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "latch await exp ", new Object[0]);
                AppMethodBeat.m2505o(58316);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static <T extends btd> C37441a<T> m16081a(C37440a<T> c37440a) {
        AppMethodBeat.m2504i(58317);
        C6300p Rh = C1226w.fuq == null ? null : C1226w.fuq.mo4497Rh();
        IllegalAccessError illegalAccessError;
        if (Rh == null) {
            C4990ab.m7412e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            AppMethodBeat.m2505o(58317);
            return null;
        } else if (C5004al.isMainThread()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in main thread");
            AppMethodBeat.m2505o(58317);
            throw illegalAccessError;
        } else if (Rh.ftB.oAl.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
            AppMethodBeat.m2505o(58317);
            throw illegalAccessError;
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            c37440a.acy().mo60487b(new C5681a<Void, C37441a<T>>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(58315);
                    atomicReference.set((C37441a) obj);
                    countDownLatch.countDown();
                    Void voidR = zXH;
                    AppMethodBeat.m2505o(58315);
                    return voidR;
                }
            });
            try {
                countDownLatch.await();
                C37441a<T> c37441a = (C37441a) atomicReference.get();
                AppMethodBeat.m2505o(58317);
                return c37441a;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "semaphore await exp ", new Object[0]);
                AppMethodBeat.m2505o(58317);
                return null;
            }
        }
    }
}

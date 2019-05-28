package com.tencent.mm.ai;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class x {

    public static class a<T extends btd> extends com.tencent.mm.ai.a.a<T> {
        public a() {
            this.errType = 3;
            this.errCode = -13;
        }
    }

    public static <T extends btd> com.tencent.mm.ai.a.a<T> c(b bVar) {
        AppMethodBeat.i(58316);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cant use NULL rr");
            AppMethodBeat.o(58316);
            throw illegalArgumentException;
        }
        p Rh = w.fuq == null ? null : w.fuq.Rh();
        IllegalAccessError illegalAccessError;
        if (Rh == null) {
            ab.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            AppMethodBeat.o(58316);
            return null;
        } else if (al.isMainThread()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in main thread");
            AppMethodBeat.o(58316);
            throw illegalAccessError;
        } else if (Rh.ftB.oAl.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
            AppMethodBeat.o(58316);
            throw illegalAccessError;
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            w.a(bVar, new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, b bVar, m mVar) {
                    AppMethodBeat.i(58313);
                    atomicReference.set(com.tencent.mm.ai.a.a.a(i, i2, str, (btd) bVar.fsH.fsP, mVar, null));
                    countDownLatch.countDown();
                    AppMethodBeat.o(58313);
                    return 0;
                }
            });
            new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(58314);
                    atomicReference.set(new a());
                    countDownLatch.countDown();
                    AppMethodBeat.o(58314);
                    return false;
                }
            }, false).ae(20000, 20000);
            try {
                countDownLatch.await();
                com.tencent.mm.ai.a.a<T> aVar = (com.tencent.mm.ai.a.a) atomicReference.get();
                AppMethodBeat.o(58316);
                return aVar;
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "latch await exp ", new Object[0]);
                AppMethodBeat.o(58316);
                return null;
            }
        }
    }

    public static <T extends btd> com.tencent.mm.ai.a.a<T> a(a<T> aVar) {
        AppMethodBeat.i(58317);
        p Rh = w.fuq == null ? null : w.fuq.Rh();
        IllegalAccessError illegalAccessError;
        if (Rh == null) {
            ab.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            AppMethodBeat.o(58317);
            return null;
        } else if (al.isMainThread()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in main thread");
            AppMethodBeat.o(58317);
            throw illegalAccessError;
        } else if (Rh.ftB.oAl.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            illegalAccessError = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
            AppMethodBeat.o(58317);
            throw illegalAccessError;
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            aVar.acy().b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<T>>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(58315);
                    atomicReference.set((com.tencent.mm.ai.a.a) obj);
                    countDownLatch.countDown();
                    Void voidR = zXH;
                    AppMethodBeat.o(58315);
                    return voidR;
                }
            });
            try {
                countDownLatch.await();
                com.tencent.mm.ai.a.a<T> aVar2 = (com.tencent.mm.ai.a.a) atomicReference.get();
                AppMethodBeat.o(58317);
                return aVar2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "semaphore await exp ", new Object[0]);
                AppMethodBeat.o(58317);
                return null;
            }
        }
    }
}

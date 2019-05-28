package com.tencent.mm.d.a;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class k implements e {
    private final AtomicInteger chI = new AtomicInteger(0);
    private final Map<Integer, a> chJ = new HashMap();
    private final l chK;

    static final class a {
        final l chK;
        ByteBuffer chL = ByteBuffer.allocateDirect(this.mCapacity);
        SharedV8ArrayBuffer chM = null;
        private final int mCapacity;

        a(int i, l lVar) {
            AppMethodBeat.i(113829);
            this.chK = lVar;
            this.mCapacity = i;
            AppMethodBeat.o(113829);
        }
    }

    public k(l lVar) {
        AppMethodBeat.i(113830);
        this.chK = lVar;
        AppMethodBeat.o(113830);
    }

    public final int gn(int i) {
        AppMethodBeat.i(113831);
        int addAndGet = this.chI.addAndGet(1);
        this.chJ.put(Integer.valueOf(addAndGet), new a(i, this.chK));
        ab.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", Integer.valueOf(i), Integer.valueOf(addAndGet));
        AppMethodBeat.o(113831);
        return addAndGet;
    }

    public final SharedV8ArrayBuffer go(int i) {
        AppMethodBeat.i(113832);
        if (this.chJ.containsKey(Integer.valueOf(i))) {
            a aVar = (a) this.chJ.get(Integer.valueOf(i));
            if (aVar.chM == null) {
                aVar.chM = aVar.chK.CB().newSharedV8ArrayBuffer(aVar.chL);
            }
            SharedV8ArrayBuffer sharedV8ArrayBuffer = aVar.chM;
            AppMethodBeat.o(113832);
            return sharedV8ArrayBuffer;
        }
        ab.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", Integer.valueOf(i));
        AppMethodBeat.o(113832);
        return null;
    }

    public final ByteBuffer gp(int i) {
        AppMethodBeat.i(113833);
        if (this.chJ.containsKey(Integer.valueOf(i))) {
            ByteBuffer byteBuffer = ((a) this.chJ.get(Integer.valueOf(i))).chL;
            AppMethodBeat.o(113833);
            return byteBuffer;
        }
        ab.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", Integer.valueOf(i));
        AppMethodBeat.o(113833);
        return null;
    }

    public final void destroy(int i) {
        AppMethodBeat.i(113834);
        if (this.chJ.containsKey(Integer.valueOf(i))) {
            ab.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", Integer.valueOf(i));
            a aVar = (a) this.chJ.get(Integer.valueOf(i));
            aVar.chK.chO.k(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(113828);
                    ab.i("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release");
                    a.this.chM.manualRelease();
                    AppMethodBeat.o(113828);
                }
            });
            this.chJ.remove(Integer.valueOf(i));
            AppMethodBeat.o(113834);
            return;
        }
        ab.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", Integer.valueOf(i));
        AppMethodBeat.o(113834);
    }
}

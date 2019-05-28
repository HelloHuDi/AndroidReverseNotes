package com.tencent.mm.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class s implements f {
    private final AtomicInteger ciB = new AtomicInteger(0);
    private final AtomicInteger ciC = new AtomicInteger(0);
    private final HashMap<Integer, ByteBuffer> ciD = new HashMap();

    public s() {
        AppMethodBeat.i(113887);
        AppMethodBeat.o(113887);
    }

    public final int Cv() {
        AppMethodBeat.i(113888);
        Integer valueOf = Integer.valueOf(this.ciB.addAndGet(1));
        this.ciD.put(valueOf, null);
        ab.i("V8EngineBufferStore", "generateId:%d", valueOf);
        int intValue = valueOf.intValue();
        AppMethodBeat.o(113888);
        return intValue;
    }

    public final ByteBuffer gq(int i) {
        AppMethodBeat.i(113889);
        if (this.ciD.containsKey(Integer.valueOf(i))) {
            ByteBuffer byteBuffer = (ByteBuffer) this.ciD.get(Integer.valueOf(i));
            this.ciD.remove(Integer.valueOf(i));
            int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
            ab.i("V8EngineBufferStore", "getBuffer:%d remains[%d]", Integer.valueOf(i), Integer.valueOf(this.ciC.addAndGet(-capacity)));
            AppMethodBeat.o(113889);
            return byteBuffer;
        }
        ab.i("V8EngineBufferStore", "getBuffer:%d not contains", Integer.valueOf(i));
        AppMethodBeat.o(113889);
        return null;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.i(113890);
        if (byteBuffer == null) {
            AppMethodBeat.o(113890);
            return;
        }
        ByteBuffer byteBuffer2;
        if (byteBuffer == null) {
            byteBuffer2 = byteBuffer;
        } else if (byteBuffer.isDirect()) {
            byteBuffer2 = byteBuffer;
        } else if (byteBuffer.hasArray()) {
            byteBuffer2 = q.al(byteBuffer.array());
        } else {
            byteBuffer2 = byteBuffer;
        }
        if (!byteBuffer2.isDirect()) {
            ab.i("V8EngineBufferStore", "setBuffer: cannot convert to direct buffer");
            AppMethodBeat.o(113890);
        } else if (this.ciD.containsKey(Integer.valueOf(i))) {
            ab.i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", Integer.valueOf(i), Boolean.valueOf(byteBuffer.isDirect()), Integer.valueOf(this.ciC.addAndGet(byteBuffer.capacity())));
            this.ciD.put(Integer.valueOf(i), byteBuffer2);
            AppMethodBeat.o(113890);
        } else {
            ab.i("V8EngineBufferStore", "setBuffer: already in the store");
            AppMethodBeat.o(113890);
        }
    }
}

package com.tencent.p177mm.p224d.p225a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.d.a.s */
public final class C45303s implements C9256f {
    private final AtomicInteger ciB = new AtomicInteger(0);
    private final AtomicInteger ciC = new AtomicInteger(0);
    private final HashMap<Integer, ByteBuffer> ciD = new HashMap();

    public C45303s() {
        AppMethodBeat.m2504i(113887);
        AppMethodBeat.m2505o(113887);
    }

    /* renamed from: Cv */
    public final int mo20675Cv() {
        AppMethodBeat.m2504i(113888);
        Integer valueOf = Integer.valueOf(this.ciB.addAndGet(1));
        this.ciD.put(valueOf, null);
        C4990ab.m7417i("V8EngineBufferStore", "generateId:%d", valueOf);
        int intValue = valueOf.intValue();
        AppMethodBeat.m2505o(113888);
        return intValue;
    }

    /* renamed from: gq */
    public final ByteBuffer mo20677gq(int i) {
        AppMethodBeat.m2504i(113889);
        if (this.ciD.containsKey(Integer.valueOf(i))) {
            ByteBuffer byteBuffer = (ByteBuffer) this.ciD.get(Integer.valueOf(i));
            this.ciD.remove(Integer.valueOf(i));
            int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
            C4990ab.m7417i("V8EngineBufferStore", "getBuffer:%d remains[%d]", Integer.valueOf(i), Integer.valueOf(this.ciC.addAndGet(-capacity)));
            AppMethodBeat.m2505o(113889);
            return byteBuffer;
        }
        C4990ab.m7417i("V8EngineBufferStore", "getBuffer:%d not contains", Integer.valueOf(i));
        AppMethodBeat.m2505o(113889);
        return null;
    }

    /* renamed from: a */
    public final void mo20676a(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(113890);
        if (byteBuffer == null) {
            AppMethodBeat.m2505o(113890);
            return;
        }
        ByteBuffer byteBuffer2;
        if (byteBuffer == null) {
            byteBuffer2 = byteBuffer;
        } else if (byteBuffer.isDirect()) {
            byteBuffer2 = byteBuffer;
        } else if (byteBuffer.hasArray()) {
            byteBuffer2 = C27295q.m43335al(byteBuffer.array());
        } else {
            byteBuffer2 = byteBuffer;
        }
        if (!byteBuffer2.isDirect()) {
            C4990ab.m7416i("V8EngineBufferStore", "setBuffer: cannot convert to direct buffer");
            AppMethodBeat.m2505o(113890);
        } else if (this.ciD.containsKey(Integer.valueOf(i))) {
            C4990ab.m7417i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", Integer.valueOf(i), Boolean.valueOf(byteBuffer.isDirect()), Integer.valueOf(this.ciC.addAndGet(byteBuffer.capacity())));
            this.ciD.put(Integer.valueOf(i), byteBuffer2);
            AppMethodBeat.m2505o(113890);
        } else {
            C4990ab.m7416i("V8EngineBufferStore", "setBuffer: already in the store");
            AppMethodBeat.m2505o(113890);
        }
    }
}

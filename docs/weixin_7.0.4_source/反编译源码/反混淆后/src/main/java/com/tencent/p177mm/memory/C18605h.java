package com.tencent.p177mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.C40611c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.memory.h */
public final class C18605h extends C40611c<ByteBuffer> {
    public static C18605h fdF = new C18605h();

    /* renamed from: com.tencent.mm.memory.h$1 */
    static class C186061 implements Runnable {
        C186061() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115378);
            for (int i = 0; i < 10; i++) {
                C18605h.m29034a(C18605h.fdF, ByteBuffer.allocate(16384));
            }
            AppMethodBeat.m2505o(115378);
        }
    }

    static {
        AppMethodBeat.m2504i(115379);
        C7305d.post(new C186061(), "DecodeTempStorage_preload");
        AppMethodBeat.m2505o(115379);
    }

    private C18605h() {
        super(20);
    }

    /* renamed from: a */
    static /* synthetic */ void m29034a(C18605h c18605h, Object obj) {
        if (c18605h.f15079gH != null && c18605h.f15080gI < c18605h.f15079gH.length) {
            c18605h.f15079gH[c18605h.f15080gI] = obj;
            c18605h.f15080gI++;
        }
    }
}

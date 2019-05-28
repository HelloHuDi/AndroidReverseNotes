package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.c;
import com.tencent.mm.sdk.g.d;
import java.nio.ByteBuffer;

public final class h extends c<ByteBuffer> {
    public static h fdF = new h();

    static {
        AppMethodBeat.i(115379);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115378);
                for (int i = 0; i < 10; i++) {
                    h.a(h.fdF, ByteBuffer.allocate(16384));
                }
                AppMethodBeat.o(115378);
            }
        }, "DecodeTempStorage_preload");
        AppMethodBeat.o(115379);
    }

    private h() {
        super(20);
    }

    static /* synthetic */ void a(h hVar, Object obj) {
        if (hVar.gH != null && hVar.gI < hVar.gH.length) {
            hVar.gH[hVar.gI] = obj;
            hVar.gI++;
        }
    }
}

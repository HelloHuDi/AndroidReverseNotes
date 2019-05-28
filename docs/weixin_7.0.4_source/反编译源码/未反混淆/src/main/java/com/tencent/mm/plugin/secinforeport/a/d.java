package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public enum d implements c {
    ;
    
    private static c qjq;

    static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean Y(int i, long j) {
            AppMethodBeat.i(126178);
            ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(126178);
            return false;
        }

        public final void ff(int i, int i2) {
            AppMethodBeat.i(126179);
            ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(126179);
        }

        public final void Ch(int i) {
            AppMethodBeat.i(126180);
            ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(126180);
        }

        public final void o(int i, byte[] bArr) {
            AppMethodBeat.i(126181);
            ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(126181);
        }
    }

    private d(String str) {
    }

    static {
        qjq = new a();
        AppMethodBeat.o(126188);
    }

    public static void a(c cVar) {
        if (cVar != null) {
            qjq = cVar;
        }
    }

    public final boolean Y(int i, long j) {
        AppMethodBeat.i(126184);
        boolean Y = qjq.Y(i, j);
        AppMethodBeat.o(126184);
        return Y;
    }

    public final void ff(int i, int i2) {
        AppMethodBeat.i(126185);
        qjq.ff(i, i2);
        AppMethodBeat.o(126185);
    }

    public final void Ch(int i) {
        AppMethodBeat.i(126186);
        qjq.Ch(i);
        AppMethodBeat.o(126186);
    }

    public final void o(int i, byte[] bArr) {
        AppMethodBeat.i(126187);
        qjq.o(i, bArr);
        AppMethodBeat.o(126187);
    }
}

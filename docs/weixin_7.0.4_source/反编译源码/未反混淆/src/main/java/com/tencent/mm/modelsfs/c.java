package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.FilterOutputStream;

public final class c extends FilterOutputStream {
    private a fNS;

    public c(b bVar, long j) {
        super(e.r(bVar));
        AppMethodBeat.i(93160);
        this.fNS = new a(j);
        AppMethodBeat.o(93160);
    }

    public c(String str, String str2) {
        super(e.L(str, false));
        AppMethodBeat.i(93161);
        this.fNS = new a(str2);
        AppMethodBeat.o(93161);
    }

    public final void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(93162);
        this.fNS.z(bArr, i2);
        super.write(bArr, i, i2);
        AppMethodBeat.o(93162);
    }

    public final void close() {
        AppMethodBeat.i(93163);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        AppMethodBeat.o(93163);
    }
}

package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FilterInputStream;

public final class b extends FilterInputStream {
    private boolean fNO = false;
    private a fNS;

    public b(String str, long j) {
        super(e.openRead(str));
        AppMethodBeat.i(93154);
        this.fNS = new a(j);
        AppMethodBeat.o(93154);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(93155);
        if (this.fNO) {
            ab.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bo.dpG().toString());
        }
        int read = super.read(bArr, i, i2);
        if (read < 0) {
            AppMethodBeat.o(93155);
        } else {
            this.fNS.z(bArr, i2);
            AppMethodBeat.o(93155);
        }
        return read;
    }

    public final long skip(long j) {
        AppMethodBeat.i(93156);
        long skip = super.skip(j);
        this.fNS.seek(j);
        AppMethodBeat.o(93156);
        return skip;
    }

    public final void close() {
        AppMethodBeat.i(93157);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        ab.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
        AppMethodBeat.o(93157);
    }

    public final void mark(int i) {
        AppMethodBeat.i(93158);
        super.mark(i);
        this.fNS.aiO();
        AppMethodBeat.o(93158);
    }

    public final void reset() {
        AppMethodBeat.i(93159);
        super.reset();
        this.fNS.reset();
        AppMethodBeat.o(93159);
    }
}

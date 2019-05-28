package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public final class l extends FilterInputStream {
    private long aMp = 0;

    public l(FileInputStream fileInputStream) {
        super(fileInputStream);
    }

    public final boolean markSupported() {
        return true;
    }

    public final void mark(int i) {
        AppMethodBeat.i(51984);
        try {
            this.aMp = ((FileInputStream) this.in).getChannel().position();
            AppMethodBeat.o(51984);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FileSeekingInputStream", e, "Failed seeking FileChannel.", new Object[0]);
            AppMethodBeat.o(51984);
        }
    }

    public final void reset() {
        AppMethodBeat.i(51985);
        ((FileInputStream) this.in).getChannel().position(this.aMp);
        AppMethodBeat.o(51985);
    }
}

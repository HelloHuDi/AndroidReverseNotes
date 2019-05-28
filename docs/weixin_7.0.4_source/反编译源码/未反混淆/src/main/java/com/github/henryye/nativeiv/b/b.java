package com.github.henryye.nativeiv.b;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public final class b extends FilterInputStream {
    private long aMp = 0;

    public b(FileInputStream fileInputStream) {
        super(fileInputStream);
    }

    public final boolean markSupported() {
        return true;
    }

    public final void mark(int i) {
        AppMethodBeat.i(115773);
        try {
            this.aMp = ((FileInputStream) this.in).getChannel().position();
            AppMethodBeat.o(115773);
        } catch (Exception e) {
            c.a("MicroMsg.FileSeekingInputStream", e, "Failed seeking FileChannel.", new Object[0]);
            AppMethodBeat.o(115773);
        }
    }

    public final void reset() {
        AppMethodBeat.i(115774);
        ((FileInputStream) this.in).getChannel().position(this.aMp);
        AppMethodBeat.o(115774);
    }
}

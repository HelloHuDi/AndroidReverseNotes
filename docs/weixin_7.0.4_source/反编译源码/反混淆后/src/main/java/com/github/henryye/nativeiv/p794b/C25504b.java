package com.github.henryye.nativeiv.p794b;

import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;

/* renamed from: com.github.henryye.nativeiv.b.b */
public final class C25504b extends FilterInputStream {
    private long aMp = 0;

    public C25504b(FileInputStream fileInputStream) {
        super(fileInputStream);
    }

    public final boolean markSupported() {
        return true;
    }

    public final void mark(int i) {
        AppMethodBeat.m2504i(115773);
        try {
            this.aMp = ((FileInputStream) this.in).getChannel().position();
            AppMethodBeat.m2505o(115773);
        } catch (Exception e) {
            C17837c.m27913a("MicroMsg.FileSeekingInputStream", e, "Failed seeking FileChannel.", new Object[0]);
            AppMethodBeat.m2505o(115773);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(115774);
        ((FileInputStream) this.in).getChannel().position(this.aMp);
        AppMethodBeat.m2505o(115774);
    }
}

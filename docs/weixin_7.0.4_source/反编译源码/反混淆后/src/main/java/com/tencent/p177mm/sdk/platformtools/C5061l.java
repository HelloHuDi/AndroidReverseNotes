package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;

/* renamed from: com.tencent.mm.sdk.platformtools.l */
public final class C5061l extends FilterInputStream {
    private long aMp = 0;

    public C5061l(FileInputStream fileInputStream) {
        super(fileInputStream);
    }

    public final boolean markSupported() {
        return true;
    }

    public final void mark(int i) {
        AppMethodBeat.m2504i(51984);
        try {
            this.aMp = ((FileInputStream) this.in).getChannel().position();
            AppMethodBeat.m2505o(51984);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FileSeekingInputStream", e, "Failed seeking FileChannel.", new Object[0]);
            AppMethodBeat.m2505o(51984);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(51985);
        ((FileInputStream) this.in).getChannel().position(this.aMp);
        AppMethodBeat.m2505o(51985);
    }
}

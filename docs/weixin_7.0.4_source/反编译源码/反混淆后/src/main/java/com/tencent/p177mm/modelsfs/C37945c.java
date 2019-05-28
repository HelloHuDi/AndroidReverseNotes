package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FilterOutputStream;

/* renamed from: com.tencent.mm.modelsfs.c */
public final class C37945c extends FilterOutputStream {
    private C32819a fNS;

    public C37945c(C5728b c5728b, long j) {
        super(C5730e.m8642r(c5728b));
        AppMethodBeat.m2504i(93160);
        this.fNS = new C32819a(j);
        AppMethodBeat.m2505o(93160);
    }

    public C37945c(String str, String str2) {
        super(C5730e.m8617L(str, false));
        AppMethodBeat.m2504i(93161);
        this.fNS = new C32819a(str2);
        AppMethodBeat.m2505o(93161);
    }

    public final void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(93162);
        this.fNS.mo53392z(bArr, i2);
        super.write(bArr, i, i2);
        AppMethodBeat.m2505o(93162);
    }

    public final void close() {
        AppMethodBeat.m2504i(93163);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        AppMethodBeat.m2505o(93163);
    }
}

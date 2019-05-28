package com.tencent.p177mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

/* renamed from: com.tencent.mm.vfs.d */
public final class C40922d extends FilterInputStream {
    public C40922d(String str) {
        super(C5730e.openRead(str));
        AppMethodBeat.m2504i(54623);
        AppMethodBeat.m2505o(54623);
    }

    public C40922d(C5728b c5728b) {
        super(C5730e.m8625b(c5728b.mUri, c5728b.dMA()));
        AppMethodBeat.m2504i(54624);
        AppMethodBeat.m2505o(54624);
    }
}

package com.tencent.p177mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

/* renamed from: com.tencent.mm.vfs.f */
public final class C5731f extends FilterOutputStream {
    public C5731f(C5728b c5728b) {
        super(C5730e.m8620a(c5728b.mUri, c5728b.dMA(), false));
        AppMethodBeat.m2504i(54664);
        AppMethodBeat.m2505o(54664);
    }
}

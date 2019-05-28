package com.tencent.p177mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;

/* renamed from: com.tencent.mm.vfs.g */
public final class C5732g extends InputStreamReader {
    public C5732g(String str) {
        super(C5730e.openRead(str));
        AppMethodBeat.m2504i(54665);
        AppMethodBeat.m2505o(54665);
    }

    public C5732g(C5728b c5728b) {
        super(C5730e.m8625b(c5728b.mUri, c5728b.dMA()));
        AppMethodBeat.m2504i(54666);
        AppMethodBeat.m2505o(54666);
    }
}

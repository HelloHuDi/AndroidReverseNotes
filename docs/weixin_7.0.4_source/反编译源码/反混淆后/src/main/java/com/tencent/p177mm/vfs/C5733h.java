package com.tencent.p177mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

/* renamed from: com.tencent.mm.vfs.h */
public final class C5733h extends OutputStreamWriter {
    public C5733h(String str) {
        super(C5730e.m8617L(str, false));
        AppMethodBeat.m2504i(54667);
        AppMethodBeat.m2505o(54667);
    }

    public C5733h(C5728b c5728b) {
        super(C5730e.m8620a(c5728b.mUri, c5728b.dMA(), false));
        AppMethodBeat.m2504i(54668);
        AppMethodBeat.m2505o(54668);
    }
}

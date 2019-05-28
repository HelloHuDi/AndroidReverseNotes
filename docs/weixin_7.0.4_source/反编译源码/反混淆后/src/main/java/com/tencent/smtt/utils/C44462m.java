package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C30950k.C5821a;
import java.io.File;

/* renamed from: com.tencent.smtt.utils.m */
final class C44462m implements C5821a {
    C44462m() {
    }

    /* renamed from: a */
    public final boolean mo12209a(File file, File file2) {
        AppMethodBeat.m2504i(65220);
        if (file.length() == file2.length() && file.lastModified() == file2.lastModified()) {
            AppMethodBeat.m2505o(65220);
            return true;
        }
        AppMethodBeat.m2505o(65220);
        return false;
    }
}

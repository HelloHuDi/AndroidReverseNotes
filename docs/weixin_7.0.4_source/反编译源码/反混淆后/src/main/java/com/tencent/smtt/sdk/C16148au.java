package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.sdk.au */
class C16148au implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C5813an f3021a;

    C16148au(C5813an c5813an) {
        this.f3021a = c5813an;
    }

    public boolean accept(File file) {
        AppMethodBeat.m2504i(64402);
        if (file.getName().endsWith(".dex") || file.getName().endsWith(".jar_is_first_load_dex_flag_file")) {
            AppMethodBeat.m2505o(64402);
            return false;
        }
        AppMethodBeat.m2505o(64402);
        return true;
    }
}

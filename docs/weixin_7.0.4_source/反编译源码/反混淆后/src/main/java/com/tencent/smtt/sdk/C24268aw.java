package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.sdk.aw */
class C24268aw implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C5813an f4520a;

    C24268aw(C5813an c5813an) {
        this.f4520a = c5813an;
    }

    public boolean accept(File file) {
        AppMethodBeat.m2504i(64404);
        boolean endsWith = file.getName().endsWith(".jar");
        AppMethodBeat.m2505o(64404);
        return endsWith;
    }
}

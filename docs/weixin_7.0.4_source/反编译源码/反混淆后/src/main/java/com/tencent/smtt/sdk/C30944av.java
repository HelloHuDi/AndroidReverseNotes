package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.sdk.av */
class C30944av implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C5813an f13902a;

    C30944av(C5813an c5813an) {
        this.f13902a = c5813an;
    }

    public boolean accept(File file) {
        AppMethodBeat.m2504i(64403);
        boolean endsWith = file.getName().endsWith(".jar");
        AppMethodBeat.m2505o(64403);
        return endsWith;
    }
}

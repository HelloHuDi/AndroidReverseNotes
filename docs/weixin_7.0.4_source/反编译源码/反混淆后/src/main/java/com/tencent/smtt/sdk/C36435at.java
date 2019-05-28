package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.sdk.at */
class C36435at implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C46736ar f15167a;

    C36435at(C46736ar c46736ar) {
        this.f15167a = c46736ar;
    }

    public boolean accept(File file) {
        AppMethodBeat.m2504i(64400);
        boolean endsWith = file.getName().endsWith("tbs.conf");
        AppMethodBeat.m2505o(64400);
        return endsWith;
    }
}

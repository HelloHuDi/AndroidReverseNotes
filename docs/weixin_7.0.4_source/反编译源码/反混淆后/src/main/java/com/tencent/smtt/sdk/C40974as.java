package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.sdk.as */
class C40974as implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C46736ar f16291a;

    C40974as(C46736ar c46736ar) {
        this.f16291a = c46736ar;
    }

    public boolean accept(File file) {
        AppMethodBeat.m2504i(64399);
        boolean endsWith = file.getName().endsWith(".dex");
        AppMethodBeat.m2505o(64399);
        return endsWith;
    }
}

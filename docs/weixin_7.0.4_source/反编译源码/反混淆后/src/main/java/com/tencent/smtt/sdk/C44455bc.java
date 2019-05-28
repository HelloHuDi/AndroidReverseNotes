package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.sdk.bc */
final class C44455bc implements FileFilter {
    C44455bc() {
    }

    public final boolean accept(File file) {
        AppMethodBeat.m2504i(64567);
        if (file.getName().endsWith(".dex")) {
            AppMethodBeat.m2505o(64567);
            return false;
        }
        AppMethodBeat.m2505o(64567);
        return true;
    }
}

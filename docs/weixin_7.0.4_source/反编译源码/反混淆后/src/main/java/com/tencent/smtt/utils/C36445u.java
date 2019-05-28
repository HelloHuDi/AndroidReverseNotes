package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.utils.u */
final class C36445u implements FileFilter {
    C36445u() {
    }

    public final boolean accept(File file) {
        AppMethodBeat.m2504i(65300);
        String name = file.getName();
        if (TextUtils.isEmpty(name) || !name.endsWith(".dex")) {
            AppMethodBeat.m2505o(65300);
            return false;
        }
        AppMethodBeat.m2505o(65300);
        return true;
    }
}

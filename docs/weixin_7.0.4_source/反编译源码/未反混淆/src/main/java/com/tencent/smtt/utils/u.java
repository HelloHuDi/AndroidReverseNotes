package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class u implements FileFilter {
    u() {
    }

    public final boolean accept(File file) {
        AppMethodBeat.i(65300);
        String name = file.getName();
        if (TextUtils.isEmpty(name) || !name.endsWith(".dex")) {
            AppMethodBeat.o(65300);
            return false;
        }
        AppMethodBeat.o(65300);
        return true;
    }
}

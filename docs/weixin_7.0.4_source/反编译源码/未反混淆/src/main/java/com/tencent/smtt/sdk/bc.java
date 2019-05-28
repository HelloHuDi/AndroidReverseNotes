package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class bc implements FileFilter {
    bc() {
    }

    public final boolean accept(File file) {
        AppMethodBeat.i(64567);
        if (file.getName().endsWith(".dex")) {
            AppMethodBeat.o(64567);
            return false;
        }
        AppMethodBeat.o(64567);
        return true;
    }
}

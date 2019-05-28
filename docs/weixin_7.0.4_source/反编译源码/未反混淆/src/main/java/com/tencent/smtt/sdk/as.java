package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class as implements FileFilter {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public boolean accept(File file) {
        AppMethodBeat.i(64399);
        boolean endsWith = file.getName().endsWith(".dex");
        AppMethodBeat.o(64399);
        return endsWith;
    }
}

package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class at implements FileFilter {
    final /* synthetic */ ar a;

    at(ar arVar) {
        this.a = arVar;
    }

    public boolean accept(File file) {
        AppMethodBeat.i(64400);
        boolean endsWith = file.getName().endsWith("tbs.conf");
        AppMethodBeat.o(64400);
        return endsWith;
    }
}

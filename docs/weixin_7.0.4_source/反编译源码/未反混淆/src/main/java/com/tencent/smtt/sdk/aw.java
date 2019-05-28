package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class aw implements FileFilter {
    final /* synthetic */ an a;

    aw(an anVar) {
        this.a = anVar;
    }

    public boolean accept(File file) {
        AppMethodBeat.i(64404);
        boolean endsWith = file.getName().endsWith(".jar");
        AppMethodBeat.o(64404);
        return endsWith;
    }
}

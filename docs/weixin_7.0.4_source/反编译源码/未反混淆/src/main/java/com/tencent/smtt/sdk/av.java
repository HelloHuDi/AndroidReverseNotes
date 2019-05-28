package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class av implements FileFilter {
    final /* synthetic */ an a;

    av(an anVar) {
        this.a = anVar;
    }

    public boolean accept(File file) {
        AppMethodBeat.i(64403);
        boolean endsWith = file.getName().endsWith(".jar");
        AppMethodBeat.o(64403);
        return endsWith;
    }
}

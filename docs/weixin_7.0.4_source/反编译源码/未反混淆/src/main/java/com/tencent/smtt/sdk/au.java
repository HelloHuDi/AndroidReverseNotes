package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class au implements FileFilter {
    final /* synthetic */ an a;

    au(an anVar) {
        this.a = anVar;
    }

    public boolean accept(File file) {
        AppMethodBeat.i(64402);
        if (file.getName().endsWith(".dex") || file.getName().endsWith(".jar_is_first_load_dex_flag_file")) {
            AppMethodBeat.o(64402);
            return false;
        }
        AppMethodBeat.o(64402);
        return true;
    }
}

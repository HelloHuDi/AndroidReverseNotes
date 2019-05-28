package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class ap implements FileFilter {
    ap() {
    }

    public final boolean accept(File file) {
        AppMethodBeat.i(64397);
        String name = file.getName();
        if (name == null) {
            AppMethodBeat.o(64397);
            return false;
        } else if (name.endsWith(".jar_is_first_load_dex_flag_file")) {
            AppMethodBeat.o(64397);
            return false;
        } else if (VERSION.SDK_INT >= 21 && name.endsWith(".dex")) {
            AppMethodBeat.o(64397);
            return false;
        } else if (VERSION.SDK_INT >= 26 && name.endsWith(".prof")) {
            AppMethodBeat.o(64397);
            return false;
        } else if (VERSION.SDK_INT < 26 || !name.equals("oat")) {
            AppMethodBeat.o(64397);
            return true;
        } else {
            AppMethodBeat.o(64397);
            return false;
        }
    }
}

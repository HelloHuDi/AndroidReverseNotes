package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.tencent.smtt.sdk.ap */
final class C40973ap implements FileFilter {
    C40973ap() {
    }

    public final boolean accept(File file) {
        AppMethodBeat.m2504i(64397);
        String name = file.getName();
        if (name == null) {
            AppMethodBeat.m2505o(64397);
            return false;
        } else if (name.endsWith(".jar_is_first_load_dex_flag_file")) {
            AppMethodBeat.m2505o(64397);
            return false;
        } else if (VERSION.SDK_INT >= 21 && name.endsWith(".dex")) {
            AppMethodBeat.m2505o(64397);
            return false;
        } else if (VERSION.SDK_INT >= 26 && name.endsWith(".prof")) {
            AppMethodBeat.m2505o(64397);
            return false;
        } else if (VERSION.SDK_INT < 26 || !name.equals("oat")) {
            AppMethodBeat.m2505o(64397);
            return true;
        } else {
            AppMethodBeat.m2505o(64397);
            return false;
        }
    }
}

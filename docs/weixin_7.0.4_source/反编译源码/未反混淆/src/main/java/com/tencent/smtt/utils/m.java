package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.k.a;
import java.io.File;

final class m implements a {
    m() {
    }

    public final boolean a(File file, File file2) {
        AppMethodBeat.i(65220);
        if (file.length() == file2.length() && file.lastModified() == file2.lastModified()) {
            AppMethodBeat.o(65220);
            return true;
        }
        AppMethodBeat.o(65220);
        return false;
    }
}

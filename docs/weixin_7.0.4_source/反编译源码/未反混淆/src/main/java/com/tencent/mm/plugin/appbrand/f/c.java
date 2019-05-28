package com.tencent.mm.plugin.appbrand.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.fts.a.a;

public final class c extends a {
    public final void Po() {
        AppMethodBeat.i(129968);
        if (Pp()) {
            K(-104, 2);
        }
        AppMethodBeat.o(129968);
    }

    public final String getTableName() {
        return "WeApp";
    }

    public final String getName() {
        return "FTS5WeAppStorage";
    }

    public final int getType() {
        return 512;
    }

    public final int getPriority() {
        return 512;
    }

    public final boolean Pp() {
        AppMethodBeat.i(129969);
        if (ei(ZipJNI.UNZ_INTERNALERROR, 2)) {
            AppMethodBeat.o(129969);
            return false;
        }
        AppMethodBeat.o(129969);
        return true;
    }
}

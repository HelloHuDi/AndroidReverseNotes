package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public final void Po() {
        AppMethodBeat.i(130063);
        if (Pp()) {
            K(-108, 1);
        }
        AppMethodBeat.o(130063);
    }

    public final String getTableName() {
        return "MiniGame";
    }

    public final String getName() {
        return "FTS5MiniGameStorage";
    }

    public final int getType() {
        return 8;
    }

    public final int getPriority() {
        return 8;
    }

    public final boolean Pp() {
        AppMethodBeat.i(130064);
        if (ei(-108, 1)) {
            AppMethodBeat.o(130064);
            return false;
        }
        AppMethodBeat.o(130064);
        return true;
    }
}

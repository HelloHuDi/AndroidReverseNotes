package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public final String getName() {
        return "FTS5FriendStorage";
    }

    public final int getType() {
        return ActUtil.HEIGHT;
    }

    public final int getPriority() {
        return ActUtil.HEIGHT;
    }

    public final void Po() {
        AppMethodBeat.i(124472);
        if (Pp()) {
            this.mBT.K(-107, 1);
        }
        AppMethodBeat.o(124472);
    }

    public final String getTableName() {
        return "Friend";
    }

    public final boolean Pp() {
        AppMethodBeat.i(124473);
        if (ei(-107, 1)) {
            AppMethodBeat.o(124473);
            return false;
        }
        AppMethodBeat.o(124473);
        return true;
    }
}

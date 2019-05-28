package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;

public final class g implements f {
    h qQa;

    public final boolean coA() {
        AppMethodBeat.i(36810);
        if (this.qQa == null || this.qQa.qPP.size() == 0) {
            AppMethodBeat.o(36810);
            return false;
        }
        AppMethodBeat.o(36810);
        return true;
    }

    public final h coB() {
        AppMethodBeat.i(36811);
        if (this.qQa == null || this.qQa.qPP.size() == 0) {
            AppMethodBeat.o(36811);
            return null;
        }
        h hVar = this.qQa;
        AppMethodBeat.o(36811);
        return hVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
    }
}

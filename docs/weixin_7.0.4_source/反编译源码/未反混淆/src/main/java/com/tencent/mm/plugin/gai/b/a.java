package com.tencent.mm.plugin.gai.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a implements at {
    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(21214);
        ab.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountPostReset!");
        AppMethodBeat.o(21214);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(21215);
        ab.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountRelease!");
        AppMethodBeat.o(21215);
    }
}

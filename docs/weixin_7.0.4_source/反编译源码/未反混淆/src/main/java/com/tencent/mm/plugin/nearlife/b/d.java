package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.story.api.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class d implements at {
    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(22935);
        ab.i("MicroMsg.SubCoreNearLife", "onAccountPostReset SubCoreNearLife");
        g.a(a.class, new a() {
        });
        AppMethodBeat.o(22935);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
    }
}

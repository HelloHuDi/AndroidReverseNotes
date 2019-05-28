package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class o {
    public static d k(String str, int i, int i2, int i3) {
        AppMethodBeat.i(3688);
        ab.i("MicroMsg.ThumbFetcherFactory", "get thumb fetcher, ish265: %s", Boolean.valueOf(e.uD(str)));
        k kVar = new k();
        kVar.init(str, i, i2, i3);
        AppMethodBeat.o(3688);
        return kVar;
    }
}

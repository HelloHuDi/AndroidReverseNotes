package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.pluginsdk.ui.tools.f;

public final class e extends f {
    public e(int i) {
        super(i);
    }

    public final v h(String str, String str2, int i, int i2) {
        AppMethodBeat.i(74000);
        d dVar = new d(str, str2, i, i2);
        AppMethodBeat.o(74000);
        return dVar;
    }
}

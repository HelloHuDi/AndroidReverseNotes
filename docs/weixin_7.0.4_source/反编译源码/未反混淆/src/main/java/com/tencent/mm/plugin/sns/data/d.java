package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cat;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public ConcurrentHashMap<String, CharSequence> qFP = new ConcurrentHashMap();

    public d() {
        AppMethodBeat.i(35794);
        AppMethodBeat.o(35794);
    }

    public final void a(cat cat, CharSequence charSequence) {
        AppMethodBeat.i(35795);
        this.qFP.put(cat.wZG + "-" + cat.wZJ + "-" + cat.ncM, charSequence);
        AppMethodBeat.o(35795);
    }
}

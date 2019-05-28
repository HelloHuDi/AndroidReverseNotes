package com.tencent.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class d {
    final LinkedList<Class<? extends a>> bPc = new LinkedList();

    public d() {
        AppMethodBeat.i(90770);
        AppMethodBeat.o(90770);
    }

    public final void B(List<Class<? extends a>> list) {
        AppMethodBeat.i(90771);
        for (Class add : list) {
            this.bPc.add(add);
        }
        AppMethodBeat.o(90771);
    }
}

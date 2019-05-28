package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.d;
import java.util.List;

public final class a implements c {
    public final void rT(int i) {
        AppMethodBeat.i(90511);
        if (((d) g.M(d.class)).getTinkerLogic() != null) {
            ((d) g.M(d.class)).getTinkerLogic().rT(i);
        }
        AppMethodBeat.o(90511);
    }

    public final void dC(int i, int i2) {
        AppMethodBeat.i(90512);
        if (((d) g.M(d.class)).getTinkerLogic() != null) {
            ((d) g.M(d.class)).getTinkerLogic().dC(i, i2);
        }
        AppMethodBeat.o(90512);
    }

    public final List<com.tencent.mm.plugin.boots.a.a> aVJ() {
        AppMethodBeat.i(90513);
        List aVJ = ((d) g.M(d.class)).getTinkerLogic().aVJ();
        AppMethodBeat.o(90513);
        return aVJ;
    }
}

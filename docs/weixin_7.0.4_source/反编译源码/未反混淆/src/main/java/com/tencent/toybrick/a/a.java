package com.tencent.toybrick.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a extends android.support.v7.h.c.a {
    private List<g> AFL;
    private List<g> AFM;

    public a(List<g> list, List<g> list2) {
        this.AFL = list;
        this.AFM = list2;
    }

    public final int fV() {
        AppMethodBeat.i(113175);
        if (this.AFL == null) {
            AppMethodBeat.o(113175);
            return 0;
        }
        int size = this.AFL.size();
        AppMethodBeat.o(113175);
        return size;
    }

    public final int fW() {
        AppMethodBeat.i(113176);
        if (this.AFM == null) {
            AppMethodBeat.o(113176);
            return 0;
        }
        int size = this.AFM.size();
        AppMethodBeat.o(113176);
        return size;
    }

    public final boolean J(int i, int i2) {
        AppMethodBeat.i(113177);
        g gVar = (g) this.AFL.get(i);
        g gVar2 = (g) this.AFM.get(i2);
        if (gVar == null || gVar2 == null) {
            AppMethodBeat.o(113177);
            return false;
        } else if (gVar.hashCode() == gVar2.hashCode()) {
            AppMethodBeat.o(113177);
            return true;
        } else {
            AppMethodBeat.o(113177);
            return false;
        }
    }

    public final boolean K(int i, int i2) {
        AppMethodBeat.i(113178);
        g gVar = (g) this.AFL.get(i);
        g gVar2 = (g) this.AFM.get(i2);
        if (gVar == null || gVar2 == null) {
            AppMethodBeat.o(113178);
            return false;
        }
        boolean equals = gVar.equals(gVar2);
        AppMethodBeat.o(113178);
        return equals;
    }
}

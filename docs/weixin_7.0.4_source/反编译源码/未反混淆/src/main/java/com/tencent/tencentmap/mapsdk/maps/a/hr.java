package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class hr extends m {
    static ArrayList<hq> c = new ArrayList();
    public int a = 0;
    public ArrayList<hq> b = null;

    public final void writeTo(l lVar) {
        AppMethodBeat.i(99569);
        lVar.a(this.a, 0);
        if (this.b != null) {
            lVar.a(this.b, 1);
        }
        AppMethodBeat.o(99569);
    }

    static {
        AppMethodBeat.i(99571);
        c.add(new hq());
        AppMethodBeat.o(99571);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(99570);
        this.a = kVar.a(this.a, 0, true);
        this.b = (ArrayList) kVar.a(c, 1, false);
        AppMethodBeat.o(99570);
    }
}

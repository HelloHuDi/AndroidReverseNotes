package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class ad extends ak implements Cloneable {
    private static ArrayList<ac> b;
    public ArrayList<ac> a = null;

    public final void a(aj ajVar) {
        AppMethodBeat.i(98410);
        ajVar.a(this.a, 0);
        AppMethodBeat.o(98410);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(98411);
        if (b == null) {
            b = new ArrayList();
            b.add(new ac());
        }
        this.a = (ArrayList) aiVar.a(b, 0, true);
        AppMethodBeat.o(98411);
    }
}

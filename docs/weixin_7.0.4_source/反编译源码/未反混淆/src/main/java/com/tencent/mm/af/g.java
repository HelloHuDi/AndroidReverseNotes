package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.aj.j;
import com.tencent.mm.i.d;
import java.util.LinkedList;
import java.util.Map;

public class g extends f {
    public LinkedList<j> fgf = null;

    public final f Xz() {
        AppMethodBeat.i(16192);
        g gVar = new g();
        AppMethodBeat.o(16192);
        return gVar;
    }

    public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
    }

    public final void a(Map<String, String> map, b bVar) {
        AppMethodBeat.i(16193);
        switch (bVar.showType) {
            case 1:
                this.fgf = j.o(bVar.fgm);
                break;
        }
        AppMethodBeat.o(16193);
    }
}

package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.sdk.b.a;
import java.util.ArrayList;
import java.util.List;

public final class o extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26416);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11028));
        arrayList.add(Integer.valueOf(11027));
        AppMethodBeat.o(26416);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        AppMethodBeat.i(26417);
        switch (i) {
            case 11027:
                Gs(1);
                break;
            case 11028:
                Gs(2);
                break;
        }
        AppMethodBeat.o(26417);
        return null;
    }

    private static void Gs(int i) {
        AppMethodBeat.i(26418);
        vj vjVar = new vj();
        vjVar.cSr.cuy = i;
        a.xxA.m(vjVar);
        AppMethodBeat.o(26418);
    }
}

package com.tencent.mm.plugin.account.security.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;
import java.util.List;

public final class e extends j<d> {
    public static final String[] fnj = new String[]{j.a(d.ccO, "SafeDeviceInfo")};
    h gzi = null;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(69840);
        boolean b = super.b((d) cVar);
        AppMethodBeat.o(69840);
        return b;
    }

    static {
        AppMethodBeat.i(69841);
        AppMethodBeat.o(69841);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.ccO, "SafeDeviceInfo", null);
        AppMethodBeat.i(69836);
        if (eVar instanceof h) {
            this.gzi = (h) eVar;
        }
        AppMethodBeat.o(69836);
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(69837);
        boolean b = super.b((c) dVar);
        AppMethodBeat.o(69837);
        return b;
    }

    public final List<d> aqD() {
        AppMethodBeat.i(69838);
        LinkedList linkedList = new LinkedList();
        if (getCount() > 0) {
            Cursor baR = super.baR();
            while (baR.moveToNext()) {
                d dVar = new d();
                dVar.d(baR);
                linkedList.add(dVar);
            }
            baR.close();
        }
        AppMethodBeat.o(69838);
        return linkedList;
    }
}

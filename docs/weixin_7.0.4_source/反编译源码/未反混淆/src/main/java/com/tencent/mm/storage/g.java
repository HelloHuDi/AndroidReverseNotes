package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class g extends j<com.tencent.mm.g.c.g> {
    public static final String[] fnj = new String[]{j.a(com.tencent.mm.g.c.g.Hm(), "AddContactAntispamTicket")};
    private h fni;
    SparseArray<String> xHR = new SparseArray();

    public static class a extends com.tencent.mm.g.c.g {
        public final com.tencent.mm.sdk.e.c.a Ag() {
            AppMethodBeat.i(80274);
            com.tencent.mm.sdk.e.c.a Hm = com.tencent.mm.g.c.g.Hm();
            AppMethodBeat.o(80274);
            return Hm;
        }
    }

    static {
        AppMethodBeat.i(80280);
        AppMethodBeat.o(80280);
    }

    public g(e eVar) {
        super(eVar, com.tencent.mm.g.c.g.Hm(), "AddContactAntispamTicket", null);
        AppMethodBeat.i(80275);
        this.fni = (h) eVar;
        AppMethodBeat.o(80275);
    }

    public final void x(String str, int i, String str2) {
        AppMethodBeat.i(80276);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(80276);
            return;
        }
        a aVar = new a();
        aVar.field_userName = str;
        aVar.field_scene = i;
        aVar.field_ticket = str2;
        a(aVar);
        ia(str, str2);
        AppMethodBeat.o(80276);
    }

    public final void en(List<com.tencent.mm.g.c.g> list) {
        AppMethodBeat.i(80277);
        if (list.size() == 0) {
            AppMethodBeat.o(80277);
            return;
        }
        long iV = this.fni.iV(Thread.currentThread().getId());
        for (com.tencent.mm.g.c.g a : list) {
            a(a);
        }
        this.fni.mB(iV);
        AppMethodBeat.o(80277);
    }

    public final void ia(String str, String str2) {
        AppMethodBeat.i(80278);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(80278);
            return;
        }
        this.xHR.put(str.hashCode(), str2);
        AppMethodBeat.o(80278);
    }

    public final String aoh(String str) {
        AppMethodBeat.i(80279);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(80279);
            return null;
        }
        String str2 = (String) this.xHR.get(str.hashCode());
        if (bo.isNullOrNil(str2)) {
            a aVar = new a();
            aVar.field_userName = str;
            if (b((c) aVar, "userName")) {
                ia(aVar.field_userName, aVar.field_ticket);
                str2 = aVar.field_ticket;
                AppMethodBeat.o(80279);
                return str2;
            }
            AppMethodBeat.o(80279);
            return null;
        }
        AppMethodBeat.o(80279);
        return str2;
    }
}

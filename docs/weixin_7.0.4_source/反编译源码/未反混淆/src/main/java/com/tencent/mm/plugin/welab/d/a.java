package com.tencent.mm.plugin.welab.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class a extends j<com.tencent.mm.plugin.welab.d.a.a> {
    private e bSd;

    public final /* synthetic */ boolean a(c cVar) {
        AppMethodBeat.i(80583);
        boolean d = d((com.tencent.mm.plugin.welab.d.a.a) cVar);
        AppMethodBeat.o(80583);
        return d;
    }

    public a(e eVar) {
        super(eVar, com.tencent.mm.plugin.welab.d.a.a.ccO, "LabAppInfo", null);
        this.bSd = eVar;
    }

    public final List<com.tencent.mm.plugin.welab.d.a.a> dds() {
        AppMethodBeat.i(80579);
        Cursor baR = baR();
        ArrayList arrayList = new ArrayList();
        while (baR.moveToNext()) {
            com.tencent.mm.plugin.welab.d.a.a aVar = new com.tencent.mm.plugin.welab.d.a.a();
            aVar.d(baR);
            arrayList.add(aVar);
        }
        baR.close();
        AppMethodBeat.o(80579);
        return arrayList;
    }

    public final void ee(List<com.tencent.mm.plugin.welab.d.a.a> list) {
        long iV;
        AppMethodBeat.i(80580);
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(-1);
            hVar = hVar2;
        } else {
            iV = 0;
        }
        for (com.tencent.mm.plugin.welab.d.a.a c : list) {
            c(c);
        }
        if (hVar != null) {
            hVar.mB(iV);
        }
        AppMethodBeat.o(80580);
    }

    public final void c(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(80581);
        if (!d(aVar)) {
            b((c) aVar);
        }
        AppMethodBeat.o(80581);
    }

    private boolean d(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(80582);
        com.tencent.mm.plugin.welab.d.a.a aVar2 = new com.tencent.mm.plugin.welab.d.a.a();
        aVar2.field_LabsAppId = aVar.field_LabsAppId;
        b((c) aVar2, new String[0]);
        if (aVar.field_expId != aVar2.field_expId || aVar.field_sequence >= aVar2.field_sequence) {
            boolean a = super.a(aVar);
            AppMethodBeat.o(80582);
            return a;
        }
        ab.i("LabAppInfoStorage", "sequence old origin.seq " + aVar2.field_sequence + " old.seq " + aVar.field_sequence);
        AppMethodBeat.o(80582);
        return false;
    }
}

package com.tencent.mm.plugin.welab;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {

    public static class a {
        public int action;
        public String csB;
        public long timeStamp;
        public String uLT;
        public boolean uLU;
    }

    public static void a(a aVar) {
        int i;
        AppMethodBeat.i(80540);
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("expid", aVar.uLT + ",");
        dVar.l("appid", aVar.csB + ",");
        dVar.l(NativeProtocol.WEB_DIALOG_ACTION, aVar.action + ",");
        dVar.l(Param.TIMESTAMP, aVar.timeStamp + ",");
        String str = "hasRedPoint";
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.uLU) {
            i = 1;
        } else {
            i = 0;
        }
        dVar.l(str, stringBuilder.append(i).append(",").toString());
        ab.i("WelabReporter", "report " + dVar.Fk());
        h.pYm.e(14206, dVar);
        AppMethodBeat.o(80540);
    }

    public static void t(String str, int i, boolean z) {
        AppMethodBeat.i(80541);
        a aVar = new a();
        aVar.csB = str;
        aVar.action = i;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.uLT = a.ddj().agI(str).field_expId;
        aVar.uLU = z;
        a(aVar);
        AppMethodBeat.o(80541);
    }

    public static void A(String str, String str2, boolean z) {
        AppMethodBeat.i(80542);
        a aVar = new a();
        aVar.csB = str;
        aVar.action = 8;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.uLT = str2;
        aVar.uLU = z;
        a(aVar);
        AppMethodBeat.o(80542);
    }
}

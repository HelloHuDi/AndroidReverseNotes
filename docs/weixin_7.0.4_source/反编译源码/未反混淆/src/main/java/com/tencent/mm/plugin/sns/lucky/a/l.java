package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;

public final class l implements a {
    public final void a(e.a aVar) {
        AppMethodBeat.i(35890);
        if (aVar == null || aVar.eAB == null || aVar.eAB.vED == null) {
            ab.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            AppMethodBeat.o(35890);
            return;
        }
        String a = aa.a(aVar.eAB.vED);
        ab.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(a)));
        String ab = ab(a, "<TimelineObject", "</TimelineObject>");
        if (bo.isNullOrNil(ab)) {
            ab.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            AppMethodBeat.o(35890);
            return;
        }
        String ab2 = ab(a, "<RecXml", "</RecXml>");
        if (bo.isNullOrNil(ab2)) {
            ab.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            AppMethodBeat.o(35890);
            return;
        }
        a = ab(a, "<ADInfo", "</ADInfo>");
        if (bo.isNullOrNil(a)) {
            ab.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            AppMethodBeat.o(35890);
            return;
        }
        TimeLineObject tC = com.tencent.mm.modelsns.e.tC(ab);
        bpx bpx = new bpx();
        bpx.wSg = aa.vy(a);
        cbt cbt = new cbt();
        bpx.wSf = cbt;
        cbt.xbf = aa.vy(ab2);
        cbf cbf = new cbf();
        cbf.vQE = new BigInteger(tC.Id).longValue();
        cbf.pcX = tC.pcX;
        cbf.vHl = tC.jBB;
        cbf.xam = aa.ad(ab.getBytes());
        cbt.wZu = cbf;
        com.tencent.mm.plugin.sns.model.a.b(bpx);
        AppMethodBeat.o(35890);
    }

    private static String ab(String str, String str2, String str3) {
        AppMethodBeat.i(35891);
        String str4;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            str4 = "";
            AppMethodBeat.o(35891);
            return str4;
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            str4 = "";
            AppMethodBeat.o(35891);
            return str4;
        }
        str4 = str.substring(indexOf, indexOf2 + str3.length());
        AppMethodBeat.o(35891);
        return str4;
    }
}

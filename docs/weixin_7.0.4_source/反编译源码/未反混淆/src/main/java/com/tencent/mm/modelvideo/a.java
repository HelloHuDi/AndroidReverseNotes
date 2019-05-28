package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ugc.TXRecordCommon;

public final class a {
    public static void a(s sVar, int i) {
        AppMethodBeat.i(50621);
        if (sVar == null) {
            ab.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            AppMethodBeat.o(50621);
            return;
        }
        int i2;
        long j;
        long yz = bo.yz();
        o.all();
        String uh = t.uh(sVar.getFileName());
        long j2 = 0;
        long j3 = 0;
        if (c.vC(uh)) {
            i2 = 1;
            b bVar = new b();
            j2 = bVar.vB(uh);
            if (bVar.gjR != null) {
                j = bVar.gjR.gjN;
            } else {
                j = 0;
            }
            j3 = j;
        } else {
            ab.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i2 = 0;
        }
        j = sVar.cKK;
        String ue = s.ue(sVar.alw());
        long j4 = (long) sVar.frO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j).append(";").append(ue).append(";");
        stringBuilder.append(j4).append(";");
        stringBuilder.append(i2).append(";").append(j2).append(";");
        stringBuilder.append(j3).append(";").append(i);
        ab.d("MicroMsg.AtomStatUtil", "report moov content : " + stringBuilder.toString() + " cost time: " + bo.az(yz));
        h.pYm.e(11098, Integer.valueOf(TXRecordCommon.AUDIO_SAMPLERATE_8000), uh);
        AppMethodBeat.o(50621);
    }

    public static void j(int i, String str, String str2) {
        AppMethodBeat.i(50622);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            AppMethodBeat.o(50622);
            return;
        }
        try {
            long asZ = e.asZ(str);
            long asZ2 = e.asZ(str2);
            int i2 = (int) ((100 * asZ2) / asZ);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i).append(";").append(asZ).append(";");
            stringBuilder.append(asZ2).append(";").append(i2);
            ab.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(stringBuilder.toString())));
            h.pYm.e(11098, Integer.valueOf(8001), r0);
            AppMethodBeat.o(50622);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AtomStatUtil", e, "", new Object[0]);
            ab.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e.toString());
            AppMethodBeat.o(50622);
        }
    }
}

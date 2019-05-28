package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.p878a.C45479b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.modelvideo.a */
public final class C9713a {
    /* renamed from: a */
    public static void m17288a(C26493s c26493s, int i) {
        AppMethodBeat.m2504i(50621);
        if (c26493s == null) {
            C4990ab.m7420w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            AppMethodBeat.m2505o(50621);
            return;
        }
        int i2;
        long j;
        long yz = C5046bo.m7588yz();
        C37961o.all();
        String uh = C9720t.m17303uh(c26493s.getFileName());
        long j2 = 0;
        long j3 = 0;
        if (C42258c.m74643vC(uh)) {
            i2 = 1;
            C45479b c45479b = new C45479b();
            j2 = c45479b.mo73275vB(uh);
            if (c45479b.gjR != null) {
                j = c45479b.gjR.gjN;
            } else {
                j = 0;
            }
            j3 = j;
        } else {
            C4990ab.m7416i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i2 = 0;
        }
        j = c26493s.cKK;
        String ue = C26493s.m42234ue(c26493s.alw());
        long j4 = (long) c26493s.frO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j).append(";").append(ue).append(";");
        stringBuilder.append(j4).append(";");
        stringBuilder.append(i2).append(";").append(j2).append(";");
        stringBuilder.append(j3).append(";").append(i);
        C4990ab.m7410d("MicroMsg.AtomStatUtil", "report moov content : " + stringBuilder.toString() + " cost time: " + C5046bo.m7525az(yz));
        C7060h.pYm.mo8381e(11098, Integer.valueOf(TXRecordCommon.AUDIO_SAMPLERATE_8000), uh);
        AppMethodBeat.m2505o(50621);
    }

    /* renamed from: j */
    public static void m17289j(int i, String str, String str2) {
        AppMethodBeat.m2504i(50622);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            AppMethodBeat.m2505o(50622);
            return;
        }
        try {
            long asZ = C5730e.asZ(str);
            long asZ2 = C5730e.asZ(str2);
            int i2 = (int) ((100 * asZ2) / asZ);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i).append(";").append(asZ).append(";");
            stringBuilder.append(asZ2).append(";").append(i2);
            C4990ab.m7410d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(stringBuilder.toString())));
            C7060h.pYm.mo8381e(11098, Integer.valueOf(8001), r0);
            AppMethodBeat.m2505o(50622);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AtomStatUtil", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e.toString());
            AppMethodBeat.m2505o(50622);
        }
    }
}

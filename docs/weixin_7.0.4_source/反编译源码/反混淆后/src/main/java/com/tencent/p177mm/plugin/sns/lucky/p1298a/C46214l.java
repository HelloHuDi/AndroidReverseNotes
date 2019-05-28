package com.tencent.p177mm.plugin.sns.lucky.p1298a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.sns.model.C43555a;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bpx;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.math.BigInteger;

/* renamed from: com.tencent.mm.plugin.sns.lucky.a.l */
public final class C46214l implements C1837a {
    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(35890);
        if (c1197a == null || c1197a.eAB == null || c1197a.eAB.vED == null) {
            C4990ab.m7416i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            AppMethodBeat.m2505o(35890);
            return;
        }
        String a = C1946aa.m4148a(c1197a.eAB.vED);
        C4990ab.m7410d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(a)));
        String ab = C46214l.m86420ab(a, "<TimelineObject", "</TimelineObject>");
        if (C5046bo.isNullOrNil(ab)) {
            C4990ab.m7416i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            AppMethodBeat.m2505o(35890);
            return;
        }
        String ab2 = C46214l.m86420ab(a, "<RecXml", "</RecXml>");
        if (C5046bo.isNullOrNil(ab2)) {
            C4990ab.m7416i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            AppMethodBeat.m2505o(35890);
            return;
        }
        a = C46214l.m86420ab(a, "<ADInfo", "</ADInfo>");
        if (C5046bo.isNullOrNil(a)) {
            C4990ab.m7416i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            AppMethodBeat.m2505o(35890);
            return;
        }
        TimeLineObject tC = C37953e.m64188tC(ab);
        bpx bpx = new bpx();
        bpx.wSg = C1946aa.m4154vy(a);
        cbt cbt = new cbt();
        bpx.wSf = cbt;
        cbt.xbf = C1946aa.m4154vy(ab2);
        cbf cbf = new cbf();
        cbf.vQE = new BigInteger(tC.f15074Id).longValue();
        cbf.pcX = tC.pcX;
        cbf.vHl = tC.jBB;
        cbf.xam = C1946aa.m4152ad(ab.getBytes());
        cbt.wZu = cbf;
        C43555a.m77880b(bpx);
        AppMethodBeat.m2505o(35890);
    }

    /* renamed from: ab */
    private static String m86420ab(String str, String str2, String str3) {
        AppMethodBeat.m2504i(35891);
        String str4;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            str4 = "";
            AppMethodBeat.m2505o(35891);
            return str4;
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            str4 = "";
            AppMethodBeat.m2505o(35891);
            return str4;
        }
        str4 = str.substring(indexOf, indexOf2 + str3.length());
        AppMethodBeat.m2505o(35891);
        return str4;
    }
}

package com.tencent.p177mm.plugin.report.p499b;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p124c.p125a.p126a.C0916s;
import com.tencent.p124c.p125a.p126a.C32106n;
import com.tencent.p124c.p125a.p126a.C45079f;
import com.tencent.p124c.p125a.p126a.C8756i;
import com.tencent.p124c.p125a.p126a.C8756i.C87571;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.protobuf.bob;
import com.tencent.p177mm.protocal.protobuf.boc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.report.b.d */
public final class C34829d {
    private static C8756i pXn = C8756i.m15580aG(C4996ah.getContext());
    private static int pXo = 2;

    /* renamed from: com.tencent.mm.plugin.report.b.d$1 */
    static class C288871 implements C45079f {

        /* renamed from: com.tencent.mm.plugin.report.b.d$1$1 */
        class C288881 implements C1224a {
            C288881() {
            }

            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(123496);
                C4990ab.m7417i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.m2505o(123496);
                return 0;
            }
        }

        C288871() {
        }

        /* renamed from: cm */
        public final void mo47010cm(String str) {
            AppMethodBeat.m2504i(123497);
            C4990ab.m7417i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", str, Integer.valueOf(C34829d.pXo));
            if (C34829d.m57190Fd() <= 0) {
                C4990ab.m7413e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", Integer.valueOf(C34829d.pXo));
                AppMethodBeat.m2505o(123497);
                return;
            }
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new bob();
            c1196a.fsK = new boc();
            c1196a.uri = "/cgi-bin/micromsg-bin/querymid";
            c1196a.fsI = 684;
            C7472b acD = c1196a.acD();
            ((bob) acD.fsG.fsP).lWq = str;
            ((bob) acD.fsG.fsP).nbk = 1;
            C1226w.m2655a(acD, new C288881(), true);
            AppMethodBeat.m2505o(123497);
        }
    }

    /* renamed from: Fd */
    static /* synthetic */ int m57190Fd() {
        int i = pXo;
        pXo = i - 1;
        return i;
    }

    static {
        AppMethodBeat.m2504i(123501);
        AppMethodBeat.m2505o(123501);
    }

    public static String cgi() {
        AppMethodBeat.m2504i(123498);
        String str;
        try {
            C8756i.m15579a(new C288871());
            C4990ab.m7417i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", pXn.mo19813zR(), pXn.mo19814zS());
            AppMethodBeat.m2505o(123498);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MidHelper", "QueryMid Error e:%s", C5046bo.m7574l(e));
            str = "";
            AppMethodBeat.m2505o(123498);
            return str;
        }
    }

    /* renamed from: VY */
    public static void m57191VY(String str) {
        AppMethodBeat.m2504i(123499);
        try {
            C8756i c8756i = pXn;
            if (C8756i.mContext != null) {
                C8756i.cbv = System.currentTimeMillis();
                C32106n.cbG = -1;
                try {
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(C8756i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", C8756i.cbv);
                    edit.commit();
                } catch (Exception e) {
                    C0916s.m2090zZ();
                }
                if (C8756i.mHandler != null) {
                    C8756i.mHandler.post(new C87571(str));
                }
            }
            C4990ab.m7417i("MicroMsg.MidHelper", "QueryMid local:%s", pXn.mo19814zS());
            AppMethodBeat.m2505o(123499);
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.MidHelper", "procReturnData Error e:%s", C5046bo.m7574l(e2));
            AppMethodBeat.m2505o(123499);
        }
    }

    /* renamed from: u */
    public static int m57192u(int i, int i2, String str) {
        AppMethodBeat.m2504i(123500);
        if (C1720g.m3531RK()) {
            long anT = C5046bo.anT();
            if (i != 3 || C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(331778, null), 0) < anT) {
                int i3;
                if (C5023at.is2G(C4996ah.getContext())) {
                    i3 = 1;
                } else if (C5023at.isWifi(C4996ah.getContext())) {
                    i3 = 3;
                } else if (C5023at.is3G(C4996ah.getContext())) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                String cgi = C34829d.cgi();
                C4990ab.m7417i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i), cgi);
                C7053e.pXa.mo8381e(11402, cgi, Integer.valueOf(i), Integer.valueOf(i3), C1427q.m3028LM(), Integer.valueOf(i2), str, C5023at.getISPName(C4996ah.getContext()), Integer.valueOf(0), C1427q.getDeviceID(C4996ah.getContext()));
                C1720g.m3536RP().mo5239Ry().set(331778, Long.valueOf(259200 + anT));
                AppMethodBeat.m2505o(123500);
                return 0;
            }
            AppMethodBeat.m2505o(123500);
            return 0;
        }
        C4990ab.m7416i("MicroMsg.MidHelper", "checkReportMid acc not ready");
        AppMethodBeat.m2505o(123500);
        return -1;
    }
}

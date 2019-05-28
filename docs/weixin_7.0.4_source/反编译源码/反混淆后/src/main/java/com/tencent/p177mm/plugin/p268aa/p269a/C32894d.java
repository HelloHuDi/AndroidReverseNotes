package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C42260h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C30203m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.plugin.aa.a.d */
public final class C32894d implements C1202f {
    private static long glA = 4000000;
    private static long glB = 200000;
    private static int glx = 20;
    private static int gly = 20;
    private static int glz = 20;
    public String glC = "";
    public String glD = "";
    C5688b glt;

    private C32894d(String str, String str2) {
        this.glC = str;
        this.glD = str2;
    }

    public static int aoh() {
        AppMethodBeat.m2504i(40598);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(glx))).intValue();
        AppMethodBeat.m2505o(40598);
        return intValue;
    }

    public static int aoi() {
        AppMethodBeat.m2504i(40599);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(glz))).intValue();
        AppMethodBeat.m2505o(40599);
        return intValue;
    }

    public static long aoj() {
        AppMethodBeat.m2504i(40600);
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(glB))).longValue();
        AppMethodBeat.m2505o(40600);
        return longValue;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40601);
        C4990ab.m7417i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            C30203m c30203m = ((C42260h) c1207m).gmm;
            C4990ab.m7417i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(c30203m.kCl), c30203m.kCm, Integer.valueOf(c30203m.vzZ), Integer.valueOf(c30203m.vAa), Integer.valueOf(c30203m.vAb), Long.valueOf(c30203m.vAc), Long.valueOf(c30203m.vAd), c30203m.kCx, c30203m.kCy);
            if (c30203m.kCl == 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(c30203m.vzZ));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AA_MAX_RECEIVER_NUM_INT, Integer.valueOf(c30203m.vAa));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(c30203m.vAb));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AA_MAX_TOTAL_AMOUNT_LONG, Long.valueOf(c30203m.vAc));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(c30203m.vAd));
                C7060h.pYm.mo8378a(407, 33, 1, false);
                C5698f.m8556a(this.glt, new C32894d(c30203m.kCy, c30203m.kCx));
                AppMethodBeat.m2505o(40601);
                return;
            }
            C5698f.dMj().mo11582cR(Boolean.FALSE);
            C7060h.pYm.mo8378a(407, 35, 1, false);
            AppMethodBeat.m2505o(40601);
            return;
        }
        C5698f.dMj().mo11582cR(Boolean.FALSE);
        C7060h.pYm.mo8378a(407, 34, 1, false);
        AppMethodBeat.m2505o(40601);
    }
}

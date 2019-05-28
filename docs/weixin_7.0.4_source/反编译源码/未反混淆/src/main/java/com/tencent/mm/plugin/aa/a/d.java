package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.vending.g.b;

public final class d implements f {
    private static long glA = 4000000;
    private static long glB = 200000;
    private static int glx = 20;
    private static int gly = 20;
    private static int glz = 20;
    public String glC = "";
    public String glD = "";
    b glt;

    private d(String str, String str2) {
        this.glC = str;
        this.glD = str2;
    }

    public static int aoh() {
        AppMethodBeat.i(40598);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(glx))).intValue();
        AppMethodBeat.o(40598);
        return intValue;
    }

    public static int aoi() {
        AppMethodBeat.i(40599);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(glz))).intValue();
        AppMethodBeat.o(40599);
        return intValue;
    }

    public static long aoj() {
        AppMethodBeat.i(40600);
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(glB))).longValue();
        AppMethodBeat.o(40600);
        return longValue;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40601);
        ab.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            com.tencent.mm.protocal.protobuf.m mVar2 = ((h) mVar).gmm;
            ab.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(mVar2.kCl), mVar2.kCm, Integer.valueOf(mVar2.vzZ), Integer.valueOf(mVar2.vAa), Integer.valueOf(mVar2.vAb), Long.valueOf(mVar2.vAc), Long.valueOf(mVar2.vAd), mVar2.kCx, mVar2.kCy);
            if (mVar2.kCl == 0) {
                g.RQ();
                g.RP().Ry().set(a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(mVar2.vzZ));
                g.RQ();
                g.RP().Ry().set(a.USERINFO_AA_MAX_RECEIVER_NUM_INT, Integer.valueOf(mVar2.vAa));
                g.RQ();
                g.RP().Ry().set(a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(mVar2.vAb));
                g.RQ();
                g.RP().Ry().set(a.USERINFO_AA_MAX_TOTAL_AMOUNT_LONG, Long.valueOf(mVar2.vAc));
                g.RQ();
                g.RP().Ry().set(a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(mVar2.vAd));
                com.tencent.mm.plugin.report.service.h.pYm.a(407, 33, 1, false);
                com.tencent.mm.vending.g.f.a(this.glt, new d(mVar2.kCy, mVar2.kCx));
                AppMethodBeat.o(40601);
                return;
            }
            com.tencent.mm.vending.g.f.dMj().cR(Boolean.FALSE);
            com.tencent.mm.plugin.report.service.h.pYm.a(407, 35, 1, false);
            AppMethodBeat.o(40601);
            return;
        }
        com.tencent.mm.vending.g.f.dMj().cR(Boolean.FALSE);
        com.tencent.mm.plugin.report.service.h.pYm.a(407, 34, 1, false);
        AppMethodBeat.o(40601);
    }
}

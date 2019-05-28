package com.tencent.p177mm.plugin.report.p499b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.p1084a.p1085a.C30162c;
import com.tencent.p177mm.protocal.p1084a.p1085a.C40495f;
import com.tencent.p177mm.protocal.protobuf.ahi;
import com.tencent.p177mm.protocal.protobuf.ahj;
import com.tencent.p177mm.protocal.protobuf.atd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.report.b.h */
public final class C7050h extends C1207m implements C1918k {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private C7472b ehh;
    private C1202f ehi;
    private C3732a pXr = new C3732a();
    private ahi pXv = null;

    static {
        AppMethodBeat.m2504i(72688);
        AppMethodBeat.m2505o(72688);
    }

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = isRunning;
        }
        return z;
    }

    private static void setIsRunning(boolean z) {
        synchronized (lock) {
            isRunning = z;
        }
    }

    public C7050h() {
        AppMethodBeat.m2504i(72684);
        C7050h.setIsRunning(true);
        this.pXv = SmcProtoBufUtil.toMMGetStrategyReq();
        if (this.pXv != null) {
            this.pXv.vZL = new atd();
            this.pXv.vZL.wxc = C3732a.m6037BM(0);
        }
        AppMethodBeat.m2505o(72684);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(72685);
        if (C1720g.m3535RO().eJo == null || C1720g.m3535RO().eJo.ftA == null) {
            C4990ab.m7414f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(72685);
        } else if (i2 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnStrategyResp(i2, i3, null, 1);
            SmcLogic.OnStrategyResp(i2, i3, null, 2);
            this.ehi.onSceneEnd(i2, i3, str, this);
            C7050h.setIsRunning(false);
            AppMethodBeat.m2505o(72685);
        } else {
            C4990ab.m7410d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            ahj ahj = (ahj) this.ehh.fsH.fsP;
            this.pXr.mo8372a(ahj.vZV, 0);
            try {
                C40495f toSmcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(ahj);
                C30162c toSmcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(ahj);
                SmcLogic.OnStrategyResp(0, 0, toSmcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, toSmcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), C5046bo.m7574l(e));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            C7050h.setIsRunning(false);
            AppMethodBeat.m2505o(72685);
        }
    }

    public final int getType() {
        AppMethodBeat.m2504i(72686);
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            AppMethodBeat.m2505o(72686);
            return 988;
        }
        AppMethodBeat.m2505o(72686);
        return 989;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        String str;
        AppMethodBeat.m2504i(72687);
        this.ehi = c1202f;
        C1720g.m3534RN();
        boolean QX = C1668a.m3395QX();
        if (!QX) {
            this.pXv.vZK = C1332b.m2847bI(C5046bo.dpz());
        }
        C1196a c1196a = new C1196a();
        c1196a.fsN = false;
        c1196a.fsJ = this.pXv;
        c1196a.fsK = new ahj();
        if (QX) {
            str = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
        } else {
            str = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        }
        c1196a.uri = str;
        c1196a.fsI = getType();
        this.ehh = c1196a.acD();
        if (!QX) {
            this.ehh.mo16652a(C4851z.dmw());
            this.ehh.cQh = 1;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        if (a < 0) {
            C4990ab.m7417i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                C7050h.setIsRunning(false);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), C5046bo.m7574l(e));
            }
        }
        AppMethodBeat.m2505o(72687);
        return a;
    }
}

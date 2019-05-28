package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends m implements k {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private b ehh;
    private f ehi;
    private a pXr = new a();
    private ahi pXv = null;

    static {
        AppMethodBeat.i(72688);
        AppMethodBeat.o(72688);
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

    public h() {
        AppMethodBeat.i(72684);
        setIsRunning(true);
        this.pXv = SmcProtoBufUtil.toMMGetStrategyReq();
        if (this.pXv != null) {
            this.pXv.vZL = new atd();
            this.pXv.vZL.wxc = a.BM(0);
        }
        AppMethodBeat.o(72684);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(72685);
        if (g.RO().eJo == null || g.RO().eJo.ftA == null) {
            ab.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(72685);
        } else if (i2 != 0) {
            ab.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnStrategyResp(i2, i3, null, 1);
            SmcLogic.OnStrategyResp(i2, i3, null, 2);
            this.ehi.onSceneEnd(i2, i3, str, this);
            setIsRunning(false);
            AppMethodBeat.o(72685);
        } else {
            ab.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            ahj ahj = (ahj) this.ehh.fsH.fsP;
            this.pXr.a(ahj.vZV, 0);
            try {
                com.tencent.mm.protocal.a.a.f toSmcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(ahj);
                c toSmcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(ahj);
                SmcLogic.OnStrategyResp(0, 0, toSmcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, toSmcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bo.l(e));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            setIsRunning(false);
            AppMethodBeat.o(72685);
        }
    }

    public final int getType() {
        AppMethodBeat.i(72686);
        g.RN();
        if (a.QX()) {
            AppMethodBeat.o(72686);
            return 988;
        }
        AppMethodBeat.o(72686);
        return 989;
    }

    public final int a(e eVar, f fVar) {
        String str;
        AppMethodBeat.i(72687);
        this.ehi = fVar;
        g.RN();
        boolean QX = a.QX();
        if (!QX) {
            this.pXv.vZK = com.tencent.mm.bt.b.bI(bo.dpz());
        }
        b.a aVar = new b.a();
        aVar.fsN = false;
        aVar.fsJ = this.pXv;
        aVar.fsK = new ahj();
        if (QX) {
            str = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
        } else {
            str = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        }
        aVar.uri = str;
        aVar.fsI = getType();
        this.ehh = aVar.acD();
        if (!QX) {
            this.ehh.a(z.dmw());
            this.ehh.cQh = 1;
        }
        int a = a(eVar, this.ehh, this);
        if (a < 0) {
            ab.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                setIsRunning(false);
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bo.l(e));
            }
        }
        AppMethodBeat.o(72687);
        return a;
    }
}

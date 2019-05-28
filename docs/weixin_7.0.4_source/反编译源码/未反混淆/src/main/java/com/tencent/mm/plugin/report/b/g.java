package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends m implements k {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private b ehh;
    private f ehi;
    private ads pXt = null;
    public ag pXu;

    static {
        AppMethodBeat.i(72683);
        AppMethodBeat.o(72683);
    }

    private static void setIsRunning(boolean z) {
        synchronized (lock) {
            isRunning = z;
        }
    }

    public g(int i, int i2) {
        AppMethodBeat.i(72680);
        setIsRunning(true);
        af afVar = new af();
        this.pXt = new ads();
        try {
            afVar.vBo = i;
            afVar.vBp = i2;
            this.pXt.wlS = afVar;
            AppMethodBeat.o(72680);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
            AppMethodBeat.o(72680);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(72681);
        try {
            this.pXu = null;
            if (com.tencent.mm.kernel.g.RO().eJo == null || com.tencent.mm.kernel.g.RO().eJo.ftA == null) {
                ab.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.ehi.onSceneEnd(i2, i3, str, this);
            } else if (i2 != 0) {
                ab.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                this.ehi.onSceneEnd(i2, i3, str, this);
                setIsRunning(false);
                AppMethodBeat.o(72681);
            } else {
                ab.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
                this.pXu = ((adt) this.ehh.fsH.fsP).wlT;
                this.ehi.onSceneEnd(i2, i3, str, this);
                setIsRunning(false);
                AppMethodBeat.o(72681);
            }
        } finally {
            setIsRunning(false);
            AppMethodBeat.o(72681);
        }
    }

    public final int getType() {
        return 914;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(72682);
        this.ehi = fVar;
        com.tencent.mm.kernel.g.RN();
        if (a.QX()) {
            b.a aVar = new b.a();
            aVar.fsN = false;
            aVar.fsJ = this.pXt;
            aVar.fsK = new adt();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.fsI = 914;
            this.ehh = aVar.acD();
            int a = a(eVar, this.ehh, this);
            if (a < 0) {
                ab.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
                try {
                    this.pXu = null;
                    setIsRunning(false);
                } catch (Exception e) {
                    ab.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bo.l(e));
                }
            }
            AppMethodBeat.o(72682);
            return a;
        }
        ab.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
        AppMethodBeat.o(72682);
        return -1;
    }
}

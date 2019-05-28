package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bs;

public final class e extends m implements k {
    private f ehi;
    private b fAT;
    ctg rPu;

    public e() {
        AppMethodBeat.i(93660);
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
        aVar.fsJ = new ctf();
        aVar.fsK = new ctg();
        this.fAT = aVar.acD();
        ctf ctf = (ctf) this.fAT.fsG.fsP;
        ctf.jBF = d.DEVICE_NAME;
        ctf.vIk = bs.dut();
        ctf.vOA = Build.BRAND;
        ctf.vOz = Build.MODEL;
        ctf.xqm = d.vxk;
        ctf.vOB = d.vxl;
        ctf.vOC = d.vxm;
        ctf.xqn = com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION;
        ctf.xqo = Build.MANUFACTURER;
        ab.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", ctf.vIk, ctf.vOA, ctf.vOz, ctf.jBF, ctf.vOC, ctf.vOB, ctf.vOC, ctf.xqn, ctf.xqo);
        AppMethodBeat.o(93660);
    }

    public final int getType() {
        return 1947;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(93661);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(93661);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(93662);
        ab.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.rPu = (ctg) this.fAT.fsH.fsP;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(93662);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(93662);
    }
}

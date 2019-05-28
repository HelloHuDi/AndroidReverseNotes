package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.protocal.protobuf.wg;

public final class c extends m implements k {
    public final String appId;
    private f ehi;
    private final int scene;

    public c(String str, int i) {
        this.appId = str;
        this.scene = i;
    }

    public final int getType() {
        return 1127;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(126842);
        this.ehi = fVar;
        a aVar = new a();
        wf wfVar = new wf();
        wfVar.csB = this.appId;
        wfVar.cME = this.scene;
        aVar.fsJ = wfVar;
        aVar.uri = "/cgi-bin/mmbiz-bin/deluserauth";
        aVar.fsK = new wg();
        aVar.fsI = 1127;
        aVar.fsL = 0;
        aVar.fsM = 0;
        int a = a(eVar, aVar.acD(), this);
        AppMethodBeat.o(126842);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126843);
        wg wgVar = (wg) ((b) qVar).fsH.fsP;
        this.ehi.onSceneEnd(i2, wgVar.wcK.cyE, wgVar.wcK.cyF, this);
        AppMethodBeat.o(126843);
    }
}

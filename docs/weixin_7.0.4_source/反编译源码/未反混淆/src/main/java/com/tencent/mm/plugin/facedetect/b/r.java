package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.sdk.platformtools.ab;

public final class r extends m implements k {
    private b ehh;
    private f ehi;
    public String mFileName = "";

    public r(String str, long j, String str2, String str3, String str4) {
        AppMethodBeat.i(98);
        a aVar = new a();
        aVar.fsJ = new aaj();
        aVar.fsK = new aak();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
        aVar.fsI = 1197;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.mFileName = str;
        aaj aaj = (aaj) this.ehh.fsG.fsP;
        aaj.csB = str2;
        aaj.wfw = j;
        aaj.wfx = str4;
        aaj.wfE = str3;
        AppMethodBeat.o(98);
    }

    public final int getType() {
        return 1197;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(99);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(99);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(100);
        ab.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(100);
    }
}

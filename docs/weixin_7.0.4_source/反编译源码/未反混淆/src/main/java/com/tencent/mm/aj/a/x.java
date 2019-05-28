package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ab;

public final class x extends m implements k {
    Object data;
    public b ehh;
    private f ehi;

    public x(String str, String str2, kg kgVar, kg kgVar2, Object obj) {
        AppMethodBeat.i(11642);
        a aVar = new a();
        aVar.fsJ = new cjl();
        aVar.fsK = new cjm();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
        this.ehh = aVar.acD();
        cjl cjl = (cjl) this.ehh.fsG.fsP;
        cjl.vNb = str;
        cjl.vMV = str2;
        cjl.xig = kgVar;
        cjl.xih = kgVar2;
        this.data = obj;
        AppMethodBeat.o(11642);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11643);
        ab.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11643);
    }

    public final int getType() {
        return 1357;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11644);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11644);
        return a;
    }
}

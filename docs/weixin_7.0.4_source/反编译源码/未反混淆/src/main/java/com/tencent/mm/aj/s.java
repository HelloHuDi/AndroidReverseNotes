package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

public final class s extends m implements k {
    Object data;
    public b ehh;
    private f ehi;

    public s(String str, int i, Object obj) {
        AppMethodBeat.i(11441);
        a aVar = new a();
        aVar.fsJ = new aft();
        aVar.fsK = new afu();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
        this.ehh = aVar.acD();
        aft aft = (aft) this.ehh.fsG.fsP;
        aft.vNb = str;
        aft.wmV = i;
        aft.wmW = aa.dor().equals("zh_CN") ? 2 : 1;
        this.data = obj;
        AppMethodBeat.o(11441);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11442);
        ab.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11442);
    }

    public final int getType() {
        return 1343;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11443);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11443);
        return a;
    }
}

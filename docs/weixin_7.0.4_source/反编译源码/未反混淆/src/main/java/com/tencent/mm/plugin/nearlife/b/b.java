package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b extends m implements k {
    private com.tencent.mm.ai.b fsB;
    private f oRe;
    public String oRf;

    public b(String str, String str2, String str3, axx axx, int i, LinkedList<bts> linkedList, String str4) {
        AppMethodBeat.i(22924);
        a aVar = new a();
        aVar.fsJ = new uv();
        aVar.fsK = new uw();
        aVar.uri = "/cgi-bin/micromsg-bin/createpoi";
        this.fsB = aVar.acD();
        String bc = bo.bc(str4, "");
        String bc2 = bo.bc(null, "");
        uv uvVar = (uv) this.fsB.fsG.fsP;
        uvVar.Name = str;
        uvVar.wcl = str2;
        uvVar.wcn = axx;
        uvVar.jBv = i;
        if (linkedList != null) {
            uvVar.wco = linkedList;
        }
        uvVar.wcp = bc;
        uvVar.wcq = bc2;
        uvVar.wcm = str3;
        ab.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", str, str2, str3, Float.valueOf(axx.vRq), Float.valueOf(axx.vRp), Integer.valueOf(i), bc, bc2);
        AppMethodBeat.o(22924);
    }

    public final int getType() {
        return 650;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(22925);
        this.oRe = fVar;
        int a = a(eVar, this.fsB, this);
        AppMethodBeat.o(22925);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(22926);
        ab.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        uw uwVar = (uw) this.fsB.fsH.fsP;
        if (this.fsB.fsH.vyl != 0) {
            this.oRe.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(22926);
            return;
        }
        this.oRf = uwVar.wcr;
        ab.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.oRf);
        this.oRe.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22926);
    }
}

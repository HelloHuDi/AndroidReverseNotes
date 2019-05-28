package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends m implements k {
    private final b ehh;
    private f ehi;
    private String geZ;
    private String gfa;
    public bgf gfb;
    private int ret;

    public h(String str, String str2, String str3) {
        AppMethodBeat.i(78855);
        a aVar = new a();
        aVar.fsJ = new alk();
        aVar.fsK = new all();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        this.ehh = aVar.acD();
        this.geZ = str;
        this.gfa = bo.bc(str2, "");
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", str, this.gfa, str3);
        alk alk = (alk) this.ehh.fsG.fsP;
        alk.geZ = str;
        alk.geY = this.gfa;
        alk.cxb = str3;
        AppMethodBeat.o(78855);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78856);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78856);
        return a;
    }

    public final int getType() {
        return 881;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78857);
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geZ);
        if (i2 == 0 && i3 == 0) {
            all all = (all) this.ehh.fsH.fsP;
            this.gfb = all.wqL;
            this.ret = s.a(all);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78857);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78857);
    }
}

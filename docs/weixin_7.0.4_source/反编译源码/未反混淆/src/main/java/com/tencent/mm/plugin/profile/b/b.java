package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    public String pkH;

    public b(String str, String str2) {
        AppMethodBeat.i(23284);
        this.pkH = str;
        a aVar = new a();
        aVar.fsJ = new aqv();
        aVar.fsK = new aqw();
        aVar.uri = "/cgi-bin/micromsg-bin/getwburl";
        this.ehh = aVar.acD();
        aqv aqv = (aqv) this.ehh.fsG.fsP;
        aqv.jBB = str2;
        aw.ZK();
        String nullAsNil = bo.nullAsNil((String) c.Ry().get(46, null));
        aqv.vHP = new SKBuiltinBuffer_t().setBuffer(bo.anf(nullAsNil));
        aw.ZK();
        String nullAsNil2 = bo.nullAsNil((String) c.Ry().get(72, null));
        aqv.wlr = new SKBuiltinBuffer_t().setBuffer(bo.anf(nullAsNil2));
        ab.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + nullAsNil + " , newa2:" + nullAsNil2);
        AppMethodBeat.o(23284);
    }

    public final int getType() {
        return 205;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(23285);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(23285);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(23286);
        ab.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", Integer.valueOf(i2), Integer.valueOf(i3), getURL());
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(23286);
    }

    public final String getURL() {
        return ((aqw) this.ehh.fsH.fsP).URL;
    }
}

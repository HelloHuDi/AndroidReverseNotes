package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k {
    private final b ehh;
    private f ehi;
    private String gff;
    public bvk gfg;
    public String gfh;

    public n(String str) {
        AppMethodBeat.i(78871);
        a aVar = new a();
        aVar.fsJ = new bvl();
        aVar.fsK = new bvm();
        aVar.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", this.gff);
        bvl bvl = (bvl) this.ehh.fsG.fsP;
        bvl.wWz = "";
        bvl.cFl = str;
        bvl.wWA = 1;
        AppMethodBeat.o(78871);
    }

    public n(String str, byte b) {
        AppMethodBeat.i(78872);
        this.gff = str;
        a aVar = new a();
        aVar.fsJ = new bvl();
        aVar.fsK = new bvm();
        aVar.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", str);
        ((bvl) this.ehh.fsG.fsP).wWz = str;
        AppMethodBeat.o(78872);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78873);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78873);
        return a;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78874);
        ab.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gfg = ((bvm) this.ehh.fsH.fsP).wWB;
            h hVar = new h();
            hVar.username = this.gfg.jBB;
            hVar.frW = this.gfg.vXm;
            hVar.frV = this.gfg.vXn;
            hVar.bJt = -1;
            ab.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", hVar.getUsername(), hVar.ack(), hVar.acl());
            hVar.dtR = 3;
            hVar.cB(true);
            o.act().b(hVar);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78874);
            return;
        }
        if (i2 == 4 && i3 == -2034) {
            this.gfh = ((bvm) this.ehh.fsH.fsP).url;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78874);
    }
}

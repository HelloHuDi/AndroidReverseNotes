package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.b.j;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private final b ehh;
    private f ehi;
    private final String id;
    public byte[] jAn;

    public e(String str) {
        AppMethodBeat.i(17891);
        a aVar = new a();
        aVar.fsJ = new aet();
        aVar.fsK = new aeu();
        aVar.uri = "/cgi-bin/micromsg-bin/getbakchatkey";
        aVar.fsI = j.CTRL_INDEX;
        this.ehh = aVar.acD();
        aet aet = (aet) this.ehh.fsG.fsP;
        aet.ID = str;
        aet.wmw = z.dmx().ver;
        this.id = str;
        ab.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", aet.ID, Integer.valueOf(aet.wmw));
        AppMethodBeat.o(17891);
    }

    public final void cancel() {
        AppMethodBeat.i(17892);
        super.cancel();
        AppMethodBeat.o(17892);
    }

    public final int getType() {
        return j.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(17893);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(17893);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(17894);
        ab.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            int i4;
            this.jAn = ((aeu) this.ehh.fsH.fsP).vIn.getBuffer().wR;
            String str2 = "MicroMsg.NetSceneGetBakchatkey";
            String str3 = "id:%s,  key len:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.id;
            if (this.jAn == null) {
                i4 = 0;
            } else {
                i4 = this.jAn.length;
            }
            objArr[1] = Integer.valueOf(i4);
            ab.i(str2, str3, objArr);
            if (this.jAn != null) {
                str2 = "";
                for (byte b : this.jAn) {
                    str2 = str2 + Integer.toHexString(b & 255) + " ";
                }
                ab.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", str2);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(17894);
    }
}

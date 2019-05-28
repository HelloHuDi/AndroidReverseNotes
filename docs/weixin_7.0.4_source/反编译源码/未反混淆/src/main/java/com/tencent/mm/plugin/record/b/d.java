package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d extends m implements k {
    private b ehh;
    private f ehi;
    private a pJk;

    public interface a {
        void ae(String str, int i, int i2);
    }

    public d(String str, String str2, String str3, int i, a aVar) {
        AppMethodBeat.i(135642);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new rh();
        aVar2.fsK = new ri();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmd5";
        this.ehh = aVar2.acD();
        rh rhVar = (rh) this.ehh.fsG.fsP;
        rhVar.fileid = str;
        rhVar.cvZ = str2;
        rhVar.vYy = str3;
        rhVar.vYz = i;
        this.pJk = aVar;
        ab.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", rhVar.fileid, rhVar.cvZ, rhVar.vYy, Integer.valueOf(rhVar.vYz), bo.dpG());
        AppMethodBeat.o(135642);
    }

    public final int getType() {
        return 939;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(135643);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135643);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135644);
        ab.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.pJk != null) {
            String str2;
            a aVar;
            a aVar2;
            if (i2 == 0 && i3 == 0) {
                ri riVar = (ri) ((b) qVar).fsH.fsP;
                a aVar3 = this.pJk;
                if (riVar != null) {
                    str2 = riVar.aeskey;
                    aVar = aVar3;
                    aVar.ae(str2, i2, i3);
                } else {
                    aVar2 = aVar3;
                }
            } else {
                aVar2 = this.pJk;
            }
            str2 = "";
            aVar = aVar2;
            aVar.ae(str2, i2, i3);
        }
        AppMethodBeat.o(135644);
    }
}

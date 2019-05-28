package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.io.File;

public final class b extends m implements k {
    private String clientId;
    private int coc;
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    public String fNa;
    private int frO;
    private String imgPath;
    private String username;

    public b(String str, String str2) {
        this(str);
        this.imgPath = str2;
    }

    private b(String str) {
        AppMethodBeat.i(136858);
        this.username = str;
        this.frO = 0;
        this.coc = 0;
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        this.clientId = stringBuilder.append(a.QF()).append(System.currentTimeMillis()).toString();
        AppMethodBeat.o(136858);
    }

    public final int getType() {
        return 575;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        AppMethodBeat.i(136859);
        com.tencent.mm.ai.m.b bVar;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            bVar = com.tencent.mm.ai.m.b.EFailed;
            AppMethodBeat.o(136859);
            return bVar;
        }
        bVar = com.tencent.mm.ai.m.b.EOk;
        AppMethodBeat.o(136859);
        return bVar;
    }

    public final int acn() {
        return 100;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(136860);
        this.ehi = fVar;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            ab.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
            AppMethodBeat.o(136860);
            return -1;
        } else if (com.tencent.mm.a.e.ct(this.imgPath)) {
            if (this.frO == 0) {
                this.frO = (int) new File(this.imgPath).length();
            }
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new cks();
            aVar.fsK = new ckt();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
            aVar.fsI = 575;
            aVar.fsL = 0;
            aVar.fsM = 0;
            this.ehh = aVar.acD();
            byte[] e = com.tencent.mm.a.e.e(this.imgPath, this.coc, Math.min(this.frO - this.coc, 32768));
            if (e == null) {
                ab.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
                AppMethodBeat.o(136860);
                return -1;
            }
            ab.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(e.length), Integer.valueOf(this.frO));
            cks cks = (cks) this.ehh.fsG.fsP;
            cks.wcP = this.username;
            cks.ptw = this.frO;
            cks.ptx = this.coc;
            cks.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            cks.pty = cks.ptz.getILen();
            cks.ptv = this.clientId;
            int a = a(eVar, this.ehh, this);
            AppMethodBeat.o(136860);
            return a;
        } else {
            ab.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.imgPath);
            AppMethodBeat.o(136860);
            return -1;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(136861);
        ab.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ckt ckt = (ckt) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
            this.fNa = ckt.wGv;
            this.coc = ckt.ptx;
            if (this.coc < this.frO) {
                if (a(this.ftf, this.ehi) < 0) {
                    ab.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                ab.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
                AppMethodBeat.o(136861);
                return;
            }
            if (!bo.isNullOrNil(this.fNa)) {
                ad aoO = ((j) g.K(j.class)).XM().aoO(this.username);
                if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                    aoO.iY(this.fNa);
                    ((j) g.K(j.class)).XM().b(this.username, aoO);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(136861);
            return;
        }
        ab.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(136861);
    }
}

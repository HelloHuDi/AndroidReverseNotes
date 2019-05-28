package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Random;

public final class s extends m implements k {
    private String cEV;
    private String clientId = null;
    private int coc = 0;
    private b ehh;
    private f ehi;
    private g fEW;
    private int frO = 0;
    private String puA;
    private int puB = 0;
    private String puz = null;

    public s(String str, String str2, String[] strArr, int i, g gVar) {
        AppMethodBeat.i(67981);
        this.puz = str;
        this.puB = i;
        this.fEW = gVar;
        if (!bo.isNullOrNil(str)) {
            this.clientId = com.tencent.mm.a.g.x(str.getBytes()) + "_" + System.nanoTime() + "_" + new Random().nextInt();
            this.frO = str.getBytes().length;
            this.coc = 0;
        }
        if (!bo.isNullOrNil(str2)) {
            this.cEV = str2;
        }
        if (strArr != null) {
            this.puA = "";
            for (String str3 : strArr) {
                this.puA += str3 + ",";
            }
            this.puA = this.puA.substring(0, this.puA.length() - 1);
        }
        ab.i("MicroMsg.NetSceneComposeSend", "NetSceneComposeSend, clientId: %s, totalLen: %d", this.clientId, Integer.valueOf(this.frO));
        AppMethodBeat.o(67981);
    }

    public final int acn() {
        return 100;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(67982);
        m.b bVar;
        if (bo.isNullOrNil(this.puz)) {
            ab.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
            bVar = m.b.EFailed;
            AppMethodBeat.o(67982);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(67982);
        return bVar;
    }

    public final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(67983);
        ab.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.coc = ((f) ((b) qVar).fsH.fsP).ptx;
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            if (this.fEW != null) {
                this.fEW.a(this.coc, this.frO, this);
            }
            if (this.coc < this.frO) {
                ab.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", Integer.valueOf(this.coc), Integer.valueOf(this.frO));
                if (a(this.ftf, this.ehi) < 0) {
                    ab.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
                    AppMethodBeat.o(67983);
                    return;
                }
            }
            ab.i("MicroMsg.NetSceneComposeSend", "finished upload");
            AppMethodBeat.o(67983);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67983);
    }

    public final int getType() {
        return 485;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(67984);
        this.ehi = fVar;
        if (bo.isNullOrNil(this.puz)) {
            ab.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
            AppMethodBeat.o(67984);
            return -1;
        }
        int min = Math.min(this.frO - this.coc, 32768);
        ab.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", Integer.valueOf(min));
        byte[] bArr = new byte[min];
        byte[] bytes = this.puz.getBytes();
        int i = 0;
        for (int i2 = this.coc; i2 < this.coc + min; i2++) {
            bArr[i] = bytes[i2];
            i++;
        }
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
            AppMethodBeat.o(67984);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.fsJ = new e();
        aVar.fsK = new f();
        aVar.uri = "/cgi-bin/micromsg-bin/composesend";
        aVar.fsI = 485;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        e eVar2 = (e) this.ehh.fsG.fsP;
        eVar2.ptv = this.clientId;
        eVar2.ptw = this.frO;
        eVar2.ptx = this.coc;
        eVar2.pty = min;
        eVar2.ptA = this.cEV;
        eVar2.ptB = this.puA;
        eVar2.ptC = (int) (((float) this.frO) + (((float) this.puB) * 1.3333334f));
        ab.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", Integer.valueOf(eVar2.ptC));
        eVar2.ptz = aa.ad(bArr);
        ab.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", Integer.valueOf(a(eVar, this.ehh, this)));
        AppMethodBeat.o(67984);
        return a(eVar, this.ehh, this);
    }
}

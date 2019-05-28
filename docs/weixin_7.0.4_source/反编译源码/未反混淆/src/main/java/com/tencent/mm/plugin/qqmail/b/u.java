package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Random;

public final class u extends m implements k {
    private String cJb;
    private int coc = 0;
    private b ehh;
    private f ehi;
    private g fEW;
    public String filePath = null;
    private int frO = 0;

    public u(String str, String str2, g gVar) {
        AppMethodBeat.i(67988);
        this.filePath = str;
        this.cJb = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.fEW = gVar;
        ab.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", this.cJb, this.filePath);
        AppMethodBeat.o(67988);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(67989);
        ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ah ahVar = (ah) ((b) qVar).fsH.fsP;
            String str2 = ahVar.ptv;
            ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", ahVar.ptv, Integer.valueOf(ahVar.ptw), ahVar.ptE);
            if (str2.equals(this.cJb)) {
                this.coc = ahVar.ptx;
                if (this.coc < this.frO) {
                    ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", Integer.valueOf(this.coc), Integer.valueOf(this.frO));
                    if (a(this.ftf, this.ehi) < 0) {
                        ab.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                        if (this.ehi != null) {
                            this.ehi.onSceneEnd(i2, i3, str, this);
                        }
                        if (this.fEW != null) {
                            this.fEW.a(this.coc, this.frO, this);
                        }
                        AppMethodBeat.o(67989);
                        return;
                    }
                }
                String str3 = ahVar.ptE;
                ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", Integer.valueOf(this.coc), Integer.valueOf(this.frO), str3);
                if (this.ehi != null) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                }
                if (this.fEW != null) {
                    this.fEW.a(this.coc, this.frO, this);
                }
                AppMethodBeat.o(67989);
                return;
            }
            AppMethodBeat.o(67989);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67989);
    }

    public final int acn() {
        return 640;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(67990);
        m.b bVar;
        if (bo.isNullOrNil(this.filePath) || !e.ct(this.filePath)) {
            ab.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
            bVar = m.b.EFailed;
            AppMethodBeat.o(67990);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(67990);
        return bVar;
    }

    public final void a(a aVar) {
    }

    public final int getType() {
        return 484;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(67991);
        this.ehi = fVar;
        if (bo.isNullOrNil(this.filePath)) {
            ab.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            AppMethodBeat.o(67991);
            return -1;
        } else if (e.ct(this.filePath)) {
            if (this.frO == 0) {
                this.frO = (int) e.asZ(this.filePath);
                ab.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", Integer.valueOf(this.frO));
            }
            int min = Math.min(this.frO - this.coc, 32768);
            ab.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", Integer.valueOf(this.coc), Integer.valueOf(min));
            byte[] e = e.e(this.filePath, this.coc, min);
            if (e == null) {
                ab.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                AppMethodBeat.o(67991);
                return -1;
            }
            ab.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", Integer.valueOf(e.length));
            b.a aVar = new b.a();
            aVar.fsJ = new ag();
            aVar.fsK = new ah();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadfile";
            aVar.fsI = 484;
            aVar.fsL = 0;
            aVar.fsM = 0;
            this.ehh = aVar.acD();
            ag agVar = (ag) this.ehh.fsG.fsP;
            agVar.ptv = this.cJb;
            agVar.ptw = this.frO;
            agVar.ptx = this.coc;
            agVar.pty = min;
            agVar.ptz = aa.ad(e);
            ab.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", Integer.valueOf(a(eVar, this.ehh, this)));
            AppMethodBeat.o(67991);
            return a(eVar, this.ehh, this);
        } else {
            ab.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", this.filePath);
            AppMethodBeat.o(67991);
            return -1;
        }
    }

    public final ah ccv() {
        if (this.ehh != null) {
            return (ah) this.ehh.fsH.fsP;
        }
        return null;
    }
}

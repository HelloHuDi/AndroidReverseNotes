package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    int Kt = 0;
    private int Lp = 0;
    private final b ehh;
    private com.tencent.mm.ai.f ehi;
    private String filename;
    public boolean sLb = false;
    private boolean sLd = false;
    private Handler sLe = null;
    int sLf = 0;
    private int sLg = 0;
    int sLh = 0;

    public f(String str, int i, int i2, int i3) {
        AppMethodBeat.i(26086);
        ab.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.sLh = i;
        a aVar = new a();
        aVar.fsJ = new brb();
        aVar.fsK = new brc();
        aVar.uri = "/cgi-bin/micromsg-bin/registervoiceprint";
        aVar.fsI = 612;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        brb brb = (brb) this.ehh.fsG.fsP;
        this.filename = str;
        this.Lp = 0;
        brb.wTu = i2;
        brb.jCs = i;
        this.sLf = i3;
        brb.wTs = i3;
        ab.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.sLb = true;
        cHL();
        AppMethodBeat.o(26086);
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 240;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(26087);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(26087);
        return a;
    }

    private int cHL() {
        AppMethodBeat.i(26088);
        brb brb = (brb) this.ehh.fsG.fsP;
        cob cob = new cob();
        g gVar = new g();
        brb.wTt = cob;
        l lVar = new l(m.by(this.filename, false));
        int asZ = (int) com.tencent.mm.vfs.e.asZ(m.by(this.filename, false));
        if (asZ - this.Lp >= 6000) {
            gVar = lVar.cF(this.Lp, 6000);
        } else {
            int i = this.Lp;
            gVar = lVar.cF(i, asZ - i);
        }
        ab.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.Lp), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.cqs), Integer.valueOf(asZ), Boolean.valueOf(this.sLb));
        if (gVar.cqs == 0) {
            AppMethodBeat.o(26088);
            return -2;
        } else if (gVar.ret < 0) {
            ab.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", Integer.valueOf(gVar.ret));
            AppMethodBeat.o(26088);
            return -1;
        } else if (this.Lp >= 469000) {
            ab.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.Lp));
            AppMethodBeat.o(26088);
            return -1;
        } else {
            cob.xlC = new SKBuiltinBuffer_t().setBuffer(gVar.buf);
            cob.ptx = this.Lp;
            cob.xlA = gVar.cqs;
            cob.xlB = 0;
            brb.wTs = this.sLf;
            if (this.sLb && gVar.fXD >= ((int) com.tencent.mm.vfs.e.asZ(m.by(this.filename, false)))) {
                cob.xlB = 1;
                this.sLd = true;
                ab.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(asZ));
            }
            this.Lp = gVar.fXD;
            brb.wTt = cob;
            AppMethodBeat.o(26088);
            return 0;
        }
    }

    public final int getType() {
        return 612;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26089);
        ab.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        brc brc = (brc) ((b) qVar).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            ab.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", Integer.valueOf(brc.wTs), Integer.valueOf(brc.wTv), Integer.valueOf(brc.wTw), Integer.valueOf(brc.wTv));
            this.sLf = brc.wTs;
            this.sLg = brc.wTw;
            this.Kt = brc.wTv;
            if (this.sLd) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(26089);
                return;
            }
            ab.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", Integer.valueOf(cHL()));
            a(this.ftf, this.ehi);
            ab.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
            AppMethodBeat.o(26089);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26089);
    }
}

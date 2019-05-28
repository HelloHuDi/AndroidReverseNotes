package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    int Kt = 0;
    private int Lp = 0;
    private final b ehh;
    private f ehi;
    private String filename;
    private String gCk = "";
    public boolean sLb = false;
    private boolean sLd = false;
    private Handler sLe = null;
    private int sLf = 0;

    public j(String str, int i) {
        AppMethodBeat.i(26104);
        ab.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", Integer.valueOf(i));
        a aVar = new a();
        aVar.fsJ = new cnk();
        aVar.fsK = new cnl();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        aVar.fsI = 613;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cnk cnk = (cnk) this.ehh.fsG.fsP;
        this.filename = str;
        this.Lp = 0;
        cnk.wTu = i;
        this.sLf = 0;
        cnk.wTs = 0;
        ab.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i), Integer.valueOf(0));
        this.sLb = true;
        cHL();
        AppMethodBeat.o(26104);
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 240;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26105);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(26105);
        return a;
    }

    private int cHL() {
        AppMethodBeat.i(26106);
        cnk cnk = (cnk) this.ehh.fsG.fsP;
        cob cob = new cob();
        g gVar = new g();
        cnk.xkT = cob;
        l lVar = new l(m.by(this.filename, false));
        int asZ = (int) com.tencent.mm.vfs.e.asZ(m.by(this.filename, false));
        if (asZ - this.Lp >= 6000) {
            gVar = lVar.cF(this.Lp, 6000);
        } else {
            int i = this.Lp;
            gVar = lVar.cF(i, asZ - i);
        }
        ab.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.Lp), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.cqs), Integer.valueOf(asZ), Boolean.valueOf(this.sLb));
        if (gVar.cqs == 0) {
            AppMethodBeat.o(26106);
            return -2;
        } else if (gVar.ret < 0) {
            ab.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", Integer.valueOf(gVar.ret));
            AppMethodBeat.o(26106);
            return -1;
        } else if (this.Lp >= 469000) {
            ab.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.Lp));
            AppMethodBeat.o(26106);
            return -1;
        } else {
            cob.xlC = new SKBuiltinBuffer_t().setBuffer(gVar.buf);
            cob.ptx = this.Lp;
            cob.xlA = gVar.cqs;
            cob.xlB = 0;
            cnk.wTs = this.sLf;
            if (this.sLb && gVar.fXD >= ((int) com.tencent.mm.vfs.e.asZ(m.by(this.filename, false)))) {
                cob.xlB = 1;
                this.sLd = true;
                ab.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(asZ));
            }
            this.Lp = gVar.fXD;
            cnk.xkT = cob;
            AppMethodBeat.o(26106);
            return 0;
        }
    }

    public final int getType() {
        return 613;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26107);
        ab.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        cnl cnl = (cnl) ((b) qVar).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            this.sLf = cnl.wTs;
            this.Kt = cnl.vYu;
            ab.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", Integer.valueOf(cnl.wTs), Integer.valueOf(this.Kt));
            if (this.sLd) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(26107);
                return;
            }
            ab.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(cHL()));
            a(this.ftf, this.ehi);
            ab.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            AppMethodBeat.o(26107);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26107);
    }
}

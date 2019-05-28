package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class e extends a implements k {
    private b ehh;
    f ehi;
    int fQx;
    boolean fZa;
    String filename;
    ap frk;
    private long gaJ;
    private boolean gaK;
    private String[] gaM;
    private int gaO;
    int retCode;

    public final int amm() {
        return this.retCode;
    }

    public final void amj() {
        this.fZa = true;
    }

    public final String[] amk() {
        return this.gaM;
    }

    public final long aml() {
        return this.gaJ;
    }

    public final List<String> amn() {
        return null;
    }

    public e(String str, int i) {
        AppMethodBeat.i(116689);
        this.retCode = 0;
        this.fZa = false;
        this.fQx = 0;
        this.filename = null;
        this.gaJ = -1;
        this.gaK = false;
        this.gaO = 0;
        this.gaM = new String[0];
        this.frk = new ap(new a() {
            public final boolean BI() {
                AppMethodBeat.i(116688);
                long asZ = com.tencent.mm.vfs.e.asZ(e.this.filename);
                ab.d("MicroMsg.NetSceneVoiceInput", g.Mq() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + asZ + " oldoff:" + e.this.fQx + " isFin:" + e.this.fZa);
                if (asZ - ((long) e.this.fQx) >= 3300 || e.this.fZa) {
                    if (e.this.a(e.this.ftf, e.this.ehi) == -1) {
                        e.this.retCode = g.getLine() + 40000;
                        e.this.ehi.onSceneEnd(3, -1, "doScene failed", e.this);
                    }
                    AppMethodBeat.o(116688);
                    return false;
                }
                AppMethodBeat.o(116688);
                return true;
            }
        }, true);
        this.gaJ = (long) (bo.anU()).hashCode();
        this.filename = str;
        this.gaO = i;
        AppMethodBeat.o(116689);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(116690);
        this.ehi = fVar;
        int asZ = (int) com.tencent.mm.vfs.e.asZ(this.filename);
        ab.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", this.filename, Integer.valueOf(asZ), Integer.valueOf(this.fQx), Boolean.valueOf(this.fZa));
        if (asZ <= 0) {
            ab.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
            this.retCode = g.getLine() + 40000;
            AppMethodBeat.o(116690);
            return -1;
        }
        int i = asZ - this.fQx;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.fZa) {
            ab.e("MicroMsg.NetSceneVoiceInput", g.Mq() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.fZa);
            this.retCode = g.getLine() + 40000;
            AppMethodBeat.o(116690);
            return -1;
        } else if (this.fZa) {
            this.gaK = true;
        }
        ab.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", this.filename, Integer.valueOf(asZ), Boolean.valueOf(this.fZa), Boolean.valueOf(this.fZa), Boolean.valueOf(this.gaK));
        byte[] e = com.tencent.mm.vfs.e.e(this.filename, this.fQx, i);
        if (e == null) {
            ab.e("MicroMsg.NetSceneVoiceInput", g.Mq() + " read failed :" + this.filename + " read:" + i);
            this.retCode = g.getLine() + 40000;
            AppMethodBeat.o(116690);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.fsJ = new clc();
        aVar.fsK = new cld();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
        aVar.fsI = 349;
        aVar.fsL = 158;
        aVar.fsM = 1000000158;
        this.ehh = aVar.acD();
        clc clc = (clc) this.ehh.fsG.fsP;
        clc.jBB = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, (Object) "");
        clc.ptz = new SKBuiltinBuffer_t().setBuffer(e);
        ab.d("MicroMsg.NetSceneVoiceInput", g.Mq() + " read file:" + this.filename + " readlen:" + e.length + " datalen:" + clc.ptz.getBuffer().toByteArray().length + " dataiLen:" + clc.ptz.getILen() + " md5:" + com.tencent.mm.a.g.x(e) + " datamd5:" + com.tencent.mm.a.g.x(clc.ptz.getBuffer().toByteArray()));
        clc.vOq = this.fQx;
        clc.xiM = this.gaJ;
        clc.fJT = this.gaK ? 1 : 0;
        clc.xiN = 0;
        clc.vHr = 0;
        clc.xiO = this.gaO;
        clc.vHo = 0;
        ab.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.gaJ);
        i = a(eVar, this.ehh, this);
        AppMethodBeat.o(116690);
        return i;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 20;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(116691);
        this.ehi.onSceneEnd(3, g.getLine() + 40000, "ecurityCheckError", this);
        AppMethodBeat.o(116691);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116692);
        ab.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        clc clc = (clc) ((b) qVar).fsG.fsP;
        cld cld = (cld) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneVoiceInput", g.Mq() + " onGYNetEnd  file:" + this.filename + " endflag:" + cld.fJT);
            if (clc.fJT == 1) {
                if (!(cld.xiP == null || cld.xiP.getBuffer() == null)) {
                    this.gaM = new String[]{cld.xiP.getBuffer().dlY()};
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(116692);
                return;
            }
            this.fQx = clc.ptz.getILen() + clc.vOq;
            long j = this.fZa ? 0 : 500;
            ab.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.frk.ae(j, j);
            AppMethodBeat.o(116692);
            return;
        }
        ab.e("MicroMsg.NetSceneVoiceInput", g.Mq() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(116692);
    }

    public final int getType() {
        return 349;
    }
}

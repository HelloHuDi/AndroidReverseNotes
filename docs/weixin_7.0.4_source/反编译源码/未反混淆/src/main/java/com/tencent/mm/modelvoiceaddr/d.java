package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.List;

public final class d extends a implements k {
    private b ehh;
    f ehi;
    int fQx;
    boolean fZa;
    String filename;
    ap frk;
    private long gaJ;
    private boolean gaK;
    private int gaL;
    private String[] gaM;
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

    public d(String str, int i) {
        AppMethodBeat.i(116684);
        this.retCode = 0;
        this.fQx = 0;
        this.filename = null;
        this.gaJ = -1;
        this.gaK = false;
        this.fZa = false;
        this.gaM = new String[0];
        this.frk = new ap(new a() {
            public final boolean BI() {
                AppMethodBeat.i(116683);
                long asZ = e.asZ(d.this.filename);
                ab.d("MicroMsg.NetSceneVoiceAddr", g.Mq() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + asZ + " oldoff:" + d.this.fQx + " isFin:" + d.this.fZa);
                if (asZ - ((long) d.this.fQx) >= 3300 || d.this.fZa) {
                    if (d.this.a(d.this.ftf, d.this.ehi) == -1) {
                        d.this.retCode = g.getLine() + 40000;
                        d.this.ehi.onSceneEnd(3, -1, "doScene failed", d.this);
                    }
                    AppMethodBeat.o(116683);
                    return false;
                }
                AppMethodBeat.o(116683);
                return true;
            }
        }, true);
        this.gaJ = bo.anU();
        this.filename = str;
        this.gaL = i;
        AppMethodBeat.o(116684);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(116685);
        this.ehi = fVar;
        long asZ = e.asZ(this.filename);
        ab.d("MicroMsg.NetSceneVoiceAddr", g.Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + " isFin:" + this.fZa);
        if (asZ <= 0) {
            ab.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.retCode = g.getLine() + 40000;
            AppMethodBeat.o(116685);
            return -1;
        }
        int i = (int) (asZ - ((long) this.fQx));
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.fZa) {
            ab.e("MicroMsg.NetSceneVoiceAddr", g.Mq() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.fZa);
            this.retCode = g.getLine() + 40000;
            AppMethodBeat.o(116685);
            return -1;
        } else if (this.fZa) {
            this.gaK = true;
        }
        ab.d("MicroMsg.NetSceneVoiceAddr", g.Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + " isFin:" + this.fZa + " endFlag:" + this.gaK);
        byte[] e = e.e(this.filename, this.fQx, i);
        if (e == null) {
            ab.e("MicroMsg.NetSceneVoiceAddr", g.Mq() + " read failed :" + this.filename + " read:" + i);
            this.retCode = g.getLine() + 40000;
            AppMethodBeat.o(116685);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.fsJ = new cny();
        aVar.fsK = new cnz();
        aVar.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        aVar.fsI = 206;
        aVar.fsL = 94;
        aVar.fsM = 1000000094;
        this.ehh = aVar.acD();
        cny cny = (cny) this.ehh.fsG.fsP;
        cny.ptz = new SKBuiltinBuffer_t().setBuffer(e);
        ab.d("MicroMsg.NetSceneVoiceAddr", g.Mq() + " read file:" + this.filename + " readlen:" + e.length + " datalen:" + cny.ptz.getBuffer().toByteArray().length + " dataiLen:" + cny.ptz.getILen() + " md5:" + com.tencent.mm.a.g.x(e) + " datamd5:" + com.tencent.mm.a.g.x(cny.ptz.getBuffer().toByteArray()));
        cny.jBB = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, (Object) "");
        cny.vOq = this.fQx;
        cny.xiM = this.gaJ;
        cny.fJT = this.gaK ? 1 : 0;
        cny.xiN = 0;
        cny.vHr = 0;
        cny.xiO = 0;
        cny.vHo = 0;
        cny.xlv = this.gaL;
        ab.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.gaJ);
        i = a(eVar, this.ehh, this);
        AppMethodBeat.o(116685);
        return i;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 20;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(116686);
        this.ehi.onSceneEnd(3, g.getLine() + 40000, "ecurityCheckError", this);
        AppMethodBeat.o(116686);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116687);
        ab.d("MicroMsg.NetSceneVoiceAddr", g.Mq() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        cny cny = (cny) ((b) qVar).fsG.fsP;
        cnz cnz = (cnz) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneVoiceAddr", g.Mq() + " onGYNetEnd  file:" + this.filename + " endflag:" + cnz.fJT + " lst:" + cnz.vEg);
            if (cny.fJT == 1) {
                this.gaM = new String[cnz.vEg.size()];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < cnz.vEg.size()) {
                        this.gaM[i5] = ((bts) cnz.vEg.get(i5)).wVI;
                        i4 = i5 + 1;
                    } else {
                        this.ehi.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(116687);
                        return;
                    }
                }
            }
            this.fQx = cny.ptz.getILen() + cny.vOq;
            long j = this.fZa ? 0 : 500;
            ab.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.frk.ae(j, j);
            AppMethodBeat.o(116687);
            return;
        }
        ab.e("MicroMsg.NetSceneVoiceAddr", g.Mq() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(116687);
    }

    public final int getType() {
        return 206;
    }
}

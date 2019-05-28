package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.UUID;

public final class c extends m implements k {
    private String clientId;
    public int ctE;
    private b ehh;
    f ehi;
    public boolean fZa = false;
    String filename = null;
    ap frk = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(26378);
            long cs = ((long) e.cs(c.this.filename)) - ((long) c.this.tYr);
            ab.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", c.this.filename, Long.valueOf((long) e.cs(c.this.filename)), Integer.valueOf(c.this.tYr), Boolean.valueOf(c.this.fZa), Long.valueOf(cs));
            if (cs < 3300 && !c.this.fZa) {
                AppMethodBeat.o(26378);
                return true;
            } else if (!c.this.fZa || cs > 0) {
                if (c.this.a(c.this.ftf, c.this.ehi) == -1) {
                    c.this.ehi.onSceneEnd(3, -1, "doScene failed", c.this);
                }
                AppMethodBeat.o(26378);
                return false;
            } else {
                AppMethodBeat.o(26378);
                return false;
            }
        }
    }, true);
    private boolean gaK = false;
    private int gaO = 0;
    int tYr = 0;
    public String tYs;
    public boolean tYt;
    public String talker;

    public c(String str, String str2, int i) {
        AppMethodBeat.i(26379);
        this.ctE = i;
        this.talker = str2;
        this.filename = str;
        this.gaO = 0;
        this.clientId = UUID.randomUUID().toString();
        AppMethodBeat.o(26379);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(26380);
        this.ehi = fVar;
        int cs = e.cs(this.filename);
        if (cs <= 0) {
            ab.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", this.filename);
            AppMethodBeat.o(26380);
            return -1;
        }
        int i = cs - this.tYr;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.fZa) {
            ab.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", Integer.valueOf(i), Boolean.valueOf(this.fZa));
            AppMethodBeat.o(26380);
            return -1;
        } else if (this.fZa) {
            this.gaK = true;
        }
        ab.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", Integer.valueOf(cs), Integer.valueOf(this.tYr), Boolean.valueOf(this.fZa), Boolean.valueOf(this.gaK), this.filename);
        byte[] e = e.e(this.filename, this.tYr, i);
        if (e != null) {
            b.a aVar = new b.a();
            aVar.fsJ = new clc();
            aVar.fsK = new cld();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            aVar.fsI = 349;
            aVar.fsL = 158;
            aVar.fsM = 1000000158;
            this.ehh = aVar.acD();
            clc clc = (clc) this.ehh.fsG.fsP;
            aw.ZK();
            clc.jBB = (String) com.tencent.mm.model.c.Ry().get(2, (Object) "");
            clc.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            clc.vOq = this.tYr;
            clc.xiM = this.clientId;
            clc.fJT = this.gaK ? 1 : 0;
            clc.xiN = 0;
            clc.vHr = 0;
            clc.xiO = this.gaO;
            clc.vHo = 0;
            cs = a(eVar, this.ehh, this);
            this.tYr = clc.ptz.getILen() + clc.vOq;
            long j = this.fZa ? 0 : 500;
            ab.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", this.filename, Long.valueOf(j), Integer.valueOf(cs));
            this.frk.ae(j, j);
            AppMethodBeat.o(26380);
            return cs;
        } else if (this.gaK) {
            AppMethodBeat.o(26380);
            return 0;
        } else {
            ab.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", Integer.valueOf(i), Boolean.valueOf(this.fZa), Boolean.valueOf(this.gaK));
            AppMethodBeat.o(26380);
            return -1;
        }
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 20;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(26381);
        this.ehi.onSceneEnd(3, 0, "securityCheckError", this);
        AppMethodBeat.o(26381);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26382);
        ab.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", Integer.valueOf(i2), Integer.valueOf(i3), this.filename);
        cld cld = (cld) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", Integer.valueOf(cld.fJT), d(cld.xiP));
            if (cld.fJT == 1) {
                this.tYt = true;
                String d = d(cld.xiP);
                if (d != null) {
                    this.tYs = d;
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(26382);
                return;
            }
            AppMethodBeat.o(26382);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26382);
    }

    private static String d(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(26383);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(26383);
            return null;
        }
        String dlY = sKBuiltinBuffer_t.getBuffer().dlY();
        AppMethodBeat.o(26383);
        return dlY;
    }

    public final int getType() {
        return 349;
    }
}

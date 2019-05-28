package com.tencent.p177mm.plugin.wear.model.p1321d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.clc;
import com.tencent.p177mm.protocal.protobuf.cld;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.wear.model.d.c */
public final class C35555c extends C1207m implements C1918k {
    private String clientId;
    public int ctE;
    private C7472b ehh;
    C1202f ehi;
    public boolean fZa = false;
    String filename = null;
    C7564ap frk = new C7564ap(new C227291(), true);
    private boolean gaK = false;
    private int gaO = 0;
    int tYr = 0;
    public String tYs;
    public boolean tYt;
    public String talker;

    /* renamed from: com.tencent.mm.plugin.wear.model.d.c$1 */
    class C227291 implements C5015a {
        C227291() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26378);
            long cs = ((long) C1173e.m2560cs(C35555c.this.filename)) - ((long) C35555c.this.tYr);
            C4990ab.m7411d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", C35555c.this.filename, Long.valueOf((long) C1173e.m2560cs(C35555c.this.filename)), Integer.valueOf(C35555c.this.tYr), Boolean.valueOf(C35555c.this.fZa), Long.valueOf(cs));
            if (cs < 3300 && !C35555c.this.fZa) {
                AppMethodBeat.m2505o(26378);
                return true;
            } else if (!C35555c.this.fZa || cs > 0) {
                if (C35555c.this.mo4456a(C35555c.this.ftf, C35555c.this.ehi) == -1) {
                    C35555c.this.ehi.onSceneEnd(3, -1, "doScene failed", C35555c.this);
                }
                AppMethodBeat.m2505o(26378);
                return false;
            } else {
                AppMethodBeat.m2505o(26378);
                return false;
            }
        }
    }

    public C35555c(String str, String str2, int i) {
        AppMethodBeat.m2504i(26379);
        this.ctE = i;
        this.talker = str2;
        this.filename = str;
        this.gaO = 0;
        this.clientId = UUID.randomUUID().toString();
        AppMethodBeat.m2505o(26379);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26380);
        this.ehi = c1202f;
        int cs = C1173e.m2560cs(this.filename);
        if (cs <= 0) {
            C4990ab.m7413e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", this.filename);
            AppMethodBeat.m2505o(26380);
            return -1;
        }
        int i = cs - this.tYr;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.fZa) {
            C4990ab.m7413e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", Integer.valueOf(i), Boolean.valueOf(this.fZa));
            AppMethodBeat.m2505o(26380);
            return -1;
        } else if (this.fZa) {
            this.gaK = true;
        }
        C4990ab.m7417i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", Integer.valueOf(cs), Integer.valueOf(this.tYr), Boolean.valueOf(this.fZa), Boolean.valueOf(this.gaK), this.filename);
        byte[] e = C1173e.m2569e(this.filename, this.tYr, i);
        if (e != null) {
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new clc();
            c1196a.fsK = new cld();
            c1196a.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            c1196a.fsI = 349;
            c1196a.fsL = 158;
            c1196a.fsM = 1000000158;
            this.ehh = c1196a.acD();
            clc clc = (clc) this.ehh.fsG.fsP;
            C9638aw.m17190ZK();
            clc.jBB = (String) C18628c.m29072Ry().get(2, (Object) "");
            clc.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            clc.vOq = this.tYr;
            clc.xiM = this.clientId;
            clc.fJT = this.gaK ? 1 : 0;
            clc.xiN = 0;
            clc.vHr = 0;
            clc.xiO = this.gaO;
            clc.vHo = 0;
            cs = mo4457a(c1902e, this.ehh, this);
            this.tYr = clc.ptz.getILen() + clc.vOq;
            long j = this.fZa ? 0 : 500;
            C4990ab.m7417i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", this.filename, Long.valueOf(j), Integer.valueOf(cs));
            this.frk.mo16770ae(j, j);
            AppMethodBeat.m2505o(26380);
            return cs;
        } else if (this.gaK) {
            AppMethodBeat.m2505o(26380);
            return 0;
        } else {
            C4990ab.m7413e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", Integer.valueOf(i), Boolean.valueOf(this.fZa), Boolean.valueOf(this.gaK));
            AppMethodBeat.m2505o(26380);
            return -1;
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 20;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(26381);
        this.ehi.onSceneEnd(3, 0, "securityCheckError", this);
        AppMethodBeat.m2505o(26381);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26382);
        C4990ab.m7417i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", Integer.valueOf(i2), Integer.valueOf(i3), this.filename);
        cld cld = (cld) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", Integer.valueOf(cld.fJT), C35555c.m58379d(cld.xiP));
            if (cld.fJT == 1) {
                this.tYt = true;
                String d = C35555c.m58379d(cld.xiP);
                if (d != null) {
                    this.tYs = d;
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(26382);
                return;
            }
            AppMethodBeat.m2505o(26382);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26382);
    }

    /* renamed from: d */
    private static String m58379d(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.m2504i(26383);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.m2505o(26383);
            return null;
        }
        String dlY = sKBuiltinBuffer_t.getBuffer().dlY();
        AppMethodBeat.m2505o(26383);
        return dlY;
    }

    public final int getType() {
        return 349;
    }
}

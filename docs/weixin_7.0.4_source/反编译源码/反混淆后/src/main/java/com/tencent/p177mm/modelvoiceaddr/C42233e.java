package com.tencent.p177mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.clc;
import com.tencent.p177mm.protocal.protobuf.cld;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.List;

/* renamed from: com.tencent.mm.modelvoiceaddr.e */
public final class C42233e extends C18723a implements C1918k {
    private C7472b ehh;
    C1202f ehi;
    int fQx;
    boolean fZa;
    String filename;
    C7564ap frk;
    private long gaJ;
    private boolean gaK;
    private String[] gaM;
    private int gaO;
    int retCode;

    /* renamed from: com.tencent.mm.modelvoiceaddr.e$1 */
    class C379661 implements C5015a {
        C379661() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116688);
            long asZ = C5730e.asZ(C42233e.this.filename);
            C4990ab.m7410d("MicroMsg.NetSceneVoiceInput", C1447g.m3075Mq() + " onTimerExpired: file:" + C42233e.this.filename + " nowlen:" + asZ + " oldoff:" + C42233e.this.fQx + " isFin:" + C42233e.this.fZa);
            if (asZ - ((long) C42233e.this.fQx) >= 3300 || C42233e.this.fZa) {
                if (C42233e.this.mo4456a(C42233e.this.ftf, C42233e.this.ehi) == -1) {
                    C42233e.this.retCode = C1447g.getLine() + 40000;
                    C42233e.this.ehi.onSceneEnd(3, -1, "doScene failed", C42233e.this);
                }
                AppMethodBeat.m2505o(116688);
                return false;
            }
            AppMethodBeat.m2505o(116688);
            return true;
        }
    }

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

    public C42233e(String str, int i) {
        AppMethodBeat.m2504i(116689);
        this.retCode = 0;
        this.fZa = false;
        this.fQx = 0;
        this.filename = null;
        this.gaJ = -1;
        this.gaK = false;
        this.gaO = 0;
        this.gaM = new String[0];
        this.frk = new C7564ap(new C379661(), true);
        this.gaJ = (long) (C5046bo.anU()).hashCode();
        this.filename = str;
        this.gaO = i;
        AppMethodBeat.m2505o(116689);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(116690);
        this.ehi = c1202f;
        int asZ = (int) C5730e.asZ(this.filename);
        C4990ab.m7411d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", this.filename, Integer.valueOf(asZ), Integer.valueOf(this.fQx), Boolean.valueOf(this.fZa));
        if (asZ <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
            this.retCode = C1447g.getLine() + 40000;
            AppMethodBeat.m2505o(116690);
            return -1;
        }
        int i = asZ - this.fQx;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.fZa) {
            C4990ab.m7412e("MicroMsg.NetSceneVoiceInput", C1447g.m3075Mq() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.fZa);
            this.retCode = C1447g.getLine() + 40000;
            AppMethodBeat.m2505o(116690);
            return -1;
        } else if (this.fZa) {
            this.gaK = true;
        }
        C4990ab.m7411d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", this.filename, Integer.valueOf(asZ), Boolean.valueOf(this.fZa), Boolean.valueOf(this.fZa), Boolean.valueOf(this.gaK));
        byte[] e = C5730e.m8632e(this.filename, this.fQx, i);
        if (e == null) {
            C4990ab.m7412e("MicroMsg.NetSceneVoiceInput", C1447g.m3075Mq() + " read failed :" + this.filename + " read:" + i);
            this.retCode = C1447g.getLine() + 40000;
            AppMethodBeat.m2505o(116690);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clc();
        c1196a.fsK = new cld();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
        c1196a.fsI = 349;
        c1196a.fsL = 158;
        c1196a.fsM = 1000000158;
        this.ehh = c1196a.acD();
        clc clc = (clc) this.ehh.fsG.fsP;
        clc.jBB = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        clc.ptz = new SKBuiltinBuffer_t().setBuffer(e);
        C4990ab.m7410d("MicroMsg.NetSceneVoiceInput", C1447g.m3075Mq() + " read file:" + this.filename + " readlen:" + e.length + " datalen:" + clc.ptz.getBuffer().toByteArray().length + " dataiLen:" + clc.ptz.getILen() + " md5:" + C1178g.m2591x(e) + " datamd5:" + C1178g.m2591x(clc.ptz.getBuffer().toByteArray()));
        clc.vOq = this.fQx;
        clc.xiM = this.gaJ;
        clc.fJT = this.gaK ? 1 : 0;
        clc.xiN = 0;
        clc.vHr = 0;
        clc.xiO = this.gaO;
        clc.vHo = 0;
        C4990ab.m7410d("MicroMsg.NetSceneVoiceInput", "clientId " + this.gaJ);
        i = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(116690);
        return i;
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
        AppMethodBeat.m2504i(116691);
        this.ehi.onSceneEnd(3, C1447g.getLine() + 40000, "ecurityCheckError", this);
        AppMethodBeat.m2505o(116691);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116692);
        C4990ab.m7410d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        clc clc = (clc) ((C7472b) c1929q).fsG.fsP;
        cld cld = (cld) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneVoiceInput", C1447g.m3075Mq() + " onGYNetEnd  file:" + this.filename + " endflag:" + cld.fJT);
            if (clc.fJT == 1) {
                if (!(cld.xiP == null || cld.xiP.getBuffer() == null)) {
                    this.gaM = new String[]{cld.xiP.getBuffer().dlY()};
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(116692);
                return;
            }
            this.fQx = clc.ptz.getILen() + clc.vOq;
            long j = this.fZa ? 0 : 500;
            C4990ab.m7410d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.frk.mo16770ae(j, j);
            AppMethodBeat.m2505o(116692);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneVoiceInput", C1447g.m3075Mq() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(116692);
    }

    public final int getType() {
        return 349;
    }
}

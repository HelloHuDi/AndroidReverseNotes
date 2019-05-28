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
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cny;
import com.tencent.p177mm.protocal.protobuf.cnz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.List;

/* renamed from: com.tencent.mm.modelvoiceaddr.d */
public final class C24673d extends C18723a implements C1918k {
    private C7472b ehh;
    C1202f ehi;
    int fQx;
    boolean fZa;
    String filename;
    C7564ap frk;
    private long gaJ;
    private boolean gaK;
    private int gaL;
    private String[] gaM;
    int retCode;

    /* renamed from: com.tencent.mm.modelvoiceaddr.d$1 */
    class C246741 implements C5015a {
        C246741() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116683);
            long asZ = C5730e.asZ(C24673d.this.filename);
            C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " onTimerExpired: file:" + C24673d.this.filename + " nowlen:" + asZ + " oldoff:" + C24673d.this.fQx + " isFin:" + C24673d.this.fZa);
            if (asZ - ((long) C24673d.this.fQx) >= 3300 || C24673d.this.fZa) {
                if (C24673d.this.mo4456a(C24673d.this.ftf, C24673d.this.ehi) == -1) {
                    C24673d.this.retCode = C1447g.getLine() + 40000;
                    C24673d.this.ehi.onSceneEnd(3, -1, "doScene failed", C24673d.this);
                }
                AppMethodBeat.m2505o(116683);
                return false;
            }
            AppMethodBeat.m2505o(116683);
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

    public C24673d(String str, int i) {
        AppMethodBeat.m2504i(116684);
        this.retCode = 0;
        this.fQx = 0;
        this.filename = null;
        this.gaJ = -1;
        this.gaK = false;
        this.fZa = false;
        this.gaM = new String[0];
        this.frk = new C7564ap(new C246741(), true);
        this.gaJ = C5046bo.anU();
        this.filename = str;
        this.gaL = i;
        AppMethodBeat.m2505o(116684);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(116685);
        this.ehi = c1202f;
        long asZ = C5730e.asZ(this.filename);
        C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + " isFin:" + this.fZa);
        if (asZ <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.retCode = C1447g.getLine() + 40000;
            AppMethodBeat.m2505o(116685);
            return -1;
        }
        int i = (int) (asZ - ((long) this.fQx));
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.fZa) {
            C4990ab.m7412e("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.fZa);
            this.retCode = C1447g.getLine() + 40000;
            AppMethodBeat.m2505o(116685);
            return -1;
        } else if (this.fZa) {
            this.gaK = true;
        }
        C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + " isFin:" + this.fZa + " endFlag:" + this.gaK);
        byte[] e = C5730e.m8632e(this.filename, this.fQx, i);
        if (e == null) {
            C4990ab.m7412e("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " read failed :" + this.filename + " read:" + i);
            this.retCode = C1447g.getLine() + 40000;
            AppMethodBeat.m2505o(116685);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cny();
        c1196a.fsK = new cnz();
        c1196a.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        c1196a.fsI = 206;
        c1196a.fsL = 94;
        c1196a.fsM = 1000000094;
        this.ehh = c1196a.acD();
        cny cny = (cny) this.ehh.fsG.fsP;
        cny.ptz = new SKBuiltinBuffer_t().setBuffer(e);
        C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " read file:" + this.filename + " readlen:" + e.length + " datalen:" + cny.ptz.getBuffer().toByteArray().length + " dataiLen:" + cny.ptz.getILen() + " md5:" + C1178g.m2591x(e) + " datamd5:" + C1178g.m2591x(cny.ptz.getBuffer().toByteArray()));
        cny.jBB = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        cny.vOq = this.fQx;
        cny.xiM = this.gaJ;
        cny.fJT = this.gaK ? 1 : 0;
        cny.xiN = 0;
        cny.vHr = 0;
        cny.xiO = 0;
        cny.vHo = 0;
        cny.xlv = this.gaL;
        C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.gaJ);
        i = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(116685);
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
        AppMethodBeat.m2504i(116686);
        this.ehi.onSceneEnd(3, C1447g.getLine() + 40000, "ecurityCheckError", this);
        AppMethodBeat.m2505o(116686);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116687);
        C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        cny cny = (cny) ((C7472b) c1929q).fsG.fsP;
        cnz cnz = (cnz) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " onGYNetEnd  file:" + this.filename + " endflag:" + cnz.fJT + " lst:" + cnz.vEg);
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
                        AppMethodBeat.m2505o(116687);
                        return;
                    }
                }
            }
            this.fQx = cny.ptz.getILen() + cny.vOq;
            long j = this.fZa ? 0 : 500;
            C4990ab.m7410d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.frk.mo16770ae(j, j);
            AppMethodBeat.m2505o(116687);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneVoiceAddr", C1447g.m3075Mq() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(116687);
    }

    public final int getType() {
        return 206;
    }
}

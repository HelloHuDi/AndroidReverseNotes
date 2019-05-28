package com.tencent.p177mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C1884l;
import com.tencent.p177mm.modelvoice.C37965g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cnk;
import com.tencent.p177mm.protocal.protobuf.cnl;
import com.tencent.p177mm.protocal.protobuf.cob;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.j */
public final class C43719j extends C1207m implements C1918k {
    /* renamed from: Kt */
    int f17224Kt = 0;
    /* renamed from: Lp */
    private int f17225Lp = 0;
    private final C7472b ehh;
    private C1202f ehi;
    private String filename;
    private String gCk = "";
    public boolean sLb = false;
    private boolean sLd = false;
    private Handler sLe = null;
    private int sLf = 0;

    public C43719j(String str, int i) {
        AppMethodBeat.m2504i(26104);
        C4990ab.m7411d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", Integer.valueOf(i));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cnk();
        c1196a.fsK = new cnl();
        c1196a.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        c1196a.fsI = 613;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cnk cnk = (cnk) this.ehh.fsG.fsP;
        this.filename = str;
        this.f17225Lp = 0;
        cnk.wTu = i;
        this.sLf = 0;
        cnk.wTs = 0;
        C4990ab.m7417i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i), Integer.valueOf(0));
        this.sLb = true;
        cHL();
        AppMethodBeat.m2505o(26104);
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 240;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26105);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(26105);
        return a;
    }

    private int cHL() {
        AppMethodBeat.m2504i(26106);
        cnk cnk = (cnk) this.ehh.fsG.fsP;
        cob cob = new cob();
        C37965g c37965g = new C37965g();
        cnk.xkT = cob;
        C1884l c1884l = new C1884l(C22449m.m34137by(this.filename, false));
        int asZ = (int) C5730e.asZ(C22449m.m34137by(this.filename, false));
        if (asZ - this.f17225Lp >= 6000) {
            c37965g = c1884l.mo5461cF(this.f17225Lp, 6000);
        } else {
            int i = this.f17225Lp;
            c37965g = c1884l.mo5461cF(i, asZ - i);
        }
        C4990ab.m7411d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.f17225Lp), Integer.valueOf(c37965g.ret), Integer.valueOf(c37965g.cqs), Integer.valueOf(asZ), Boolean.valueOf(this.sLb));
        if (c37965g.cqs == 0) {
            AppMethodBeat.m2505o(26106);
            return -2;
        } else if (c37965g.ret < 0) {
            C4990ab.m7421w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", Integer.valueOf(c37965g.ret));
            AppMethodBeat.m2505o(26106);
            return -1;
        } else if (this.f17225Lp >= 469000) {
            C4990ab.m7417i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.f17225Lp));
            AppMethodBeat.m2505o(26106);
            return -1;
        } else {
            cob.xlC = new SKBuiltinBuffer_t().setBuffer(c37965g.buf);
            cob.ptx = this.f17225Lp;
            cob.xlA = c37965g.cqs;
            cob.xlB = 0;
            cnk.wTs = this.sLf;
            if (this.sLb && c37965g.fXD >= ((int) C5730e.asZ(C22449m.m34137by(this.filename, false)))) {
                cob.xlB = 1;
                this.sLd = true;
                C4990ab.m7417i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(asZ));
            }
            this.f17225Lp = c37965g.fXD;
            cnk.xkT = cob;
            AppMethodBeat.m2505o(26106);
            return 0;
        }
    }

    public final int getType() {
        return 613;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26107);
        C4990ab.m7410d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        cnl cnl = (cnl) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            this.sLf = cnl.wTs;
            this.f17224Kt = cnl.vYu;
            C4990ab.m7417i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", Integer.valueOf(cnl.wTs), Integer.valueOf(this.f17224Kt));
            if (this.sLd) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(26107);
                return;
            }
            C4990ab.m7417i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(cHL()));
            mo4456a(this.ftf, this.ehi);
            C4990ab.m7416i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            AppMethodBeat.m2505o(26107);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26107);
    }
}

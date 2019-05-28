package com.tencent.p177mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C32775bc.C18618a;
import com.tencent.p177mm.model.C32775bc.C6666b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C18674i;
import com.tencent.p177mm.modelvoice.C1884l;
import com.tencent.p177mm.modelvoice.C37965g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cob;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.h */
public final class C43717h extends C1207m implements C1918k {
    /* renamed from: Kt */
    int f17222Kt = 0;
    /* renamed from: Lp */
    private int f17223Lp = 0;
    C1202f ehi;
    private String filename;
    private final C1929q ftU;
    String gCk = "";
    public boolean sLb = false;
    private boolean sLd = false;
    private Handler sLe = null;
    private int sLf = 0;

    public C43717h(String str, int i, String str2) {
        AppMethodBeat.m2504i(26097);
        C4990ab.m7411d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", Integer.valueOf(i), C5046bo.m7532bc(str2, ""));
        this.ftU = new C29477c();
        C18618a c18618a = (C18618a) this.ftU.acF();
        this.filename = str;
        this.f17223Lp = 0;
        c18618a.fma.wTu = i;
        c18618a.fma.wuc = str2;
        this.sLf = 0;
        c18618a.fma.wTs = 0;
        C4990ab.m7417i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i), Integer.valueOf(0));
        this.sLb = true;
        cHL();
        AppMethodBeat.m2505o(26097);
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
        AppMethodBeat.m2504i(26098);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(26098);
        return a;
    }

    private int cHL() {
        AppMethodBeat.m2504i(26099);
        C18618a c18618a = (C18618a) this.ftU.acF();
        cob cob = new cob();
        C37965g c37965g = new C37965g();
        c18618a.fma.xkT = cob;
        C1884l c1884l = new C1884l(C22449m.m34137by(this.filename, false));
        int asZ = (int) C5730e.asZ(C22449m.m34137by(this.filename, false));
        if (asZ - this.f17223Lp >= 6000) {
            c37965g = c1884l.mo5461cF(this.f17223Lp, 6000);
        } else {
            int i = this.f17223Lp;
            c37965g = c1884l.mo5461cF(i, asZ - i);
        }
        C4990ab.m7411d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.f17223Lp), Integer.valueOf(c37965g.ret), Integer.valueOf(c37965g.cqs), Integer.valueOf(asZ), Boolean.valueOf(this.sLb));
        if (c37965g.cqs == 0) {
            AppMethodBeat.m2505o(26099);
            return -2;
        } else if (c37965g.ret < 0) {
            C4990ab.m7421w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", Integer.valueOf(c37965g.ret));
            AppMethodBeat.m2505o(26099);
            return -1;
        } else if (this.f17223Lp >= 469000) {
            C4990ab.m7417i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.f17223Lp));
            AppMethodBeat.m2505o(26099);
            return -1;
        } else {
            cob.xlC = new SKBuiltinBuffer_t().setBuffer(c37965g.buf);
            cob.ptx = this.f17223Lp;
            cob.xlA = c37965g.cqs;
            cob.xlB = 0;
            c18618a.fma.wTs = this.sLf;
            if (this.sLb && c37965g.fXD >= ((int) C5730e.asZ(C22449m.m34137by(this.filename, false)))) {
                cob.xlB = 1;
                this.sLd = true;
                C4990ab.m7417i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(asZ));
            }
            this.f17223Lp = c37965g.fXD;
            c18618a.fma.xkT = cob;
            AppMethodBeat.m2505o(26099);
            return 0;
        }
    }

    public final int getType() {
        return C38271be.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26100);
        C4990ab.m7410d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        C6666b c6666b = (C6666b) c1929q.mo5618ZS();
        final int i4;
        if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            i4 = c1929q.acF().vyj.ver;
            C4990ab.m7411d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            C9638aw.m17180RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.voiceprint.model.h$1$1 */
                class C400171 implements C1202f {
                    C400171() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(26095);
                        C4990ab.m7411d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C43717h.this.mo4456a(C43717h.this.ftf, C43717h.this.ehi);
                            AppMethodBeat.m2505o(26095);
                            return;
                        }
                        C43717h.this.ehi.onSceneEnd(i, i2, "", C43717h.this);
                        AppMethodBeat.m2505o(26095);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(26096);
                    new C18674i().mo4456a(C43717h.this.ftf, new C400171());
                    AppMethodBeat.m2505o(26096);
                }
            });
            AppMethodBeat.m2505o(26100);
        } else if (i2 == 0 || i3 == 0) {
            this.sLf = c6666b.fmb.wTs;
            this.f17222Kt = c6666b.fmb.vYu;
            this.gCk = c6666b.fmb.xkU;
            String str2 = "MicroMsg.NetSceneRsaVertifyVoicePrint";
            String str3 = "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(c6666b.fmb.wTs);
            objArr[1] = Integer.valueOf(this.f17222Kt);
            objArr[2] = Boolean.valueOf(C5046bo.isNullOrNil(this.gCk));
            if (C5046bo.isNullOrNil(this.gCk)) {
                i4 = 0;
            } else {
                i4 = this.gCk.length();
            }
            objArr[3] = Integer.valueOf(i4);
            C4990ab.m7417i(str2, str3, objArr);
            if (this.sLd) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(26100);
                return;
            }
            C4990ab.m7417i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(cHL()));
            mo4456a(this.ftf, this.ehi);
            C4990ab.m7416i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
            AppMethodBeat.m2505o(26100);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(26100);
        }
    }
}

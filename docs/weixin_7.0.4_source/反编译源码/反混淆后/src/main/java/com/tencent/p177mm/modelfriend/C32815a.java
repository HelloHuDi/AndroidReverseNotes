package com.tencent.p177mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.modelsimple.C18674i;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.protocal.C30167n.C7244a;
import com.tencent.p177mm.protocal.C30167n.C7245b;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bzr;
import com.tencent.p177mm.protocal.protobuf.cfi;
import com.tencent.p177mm.protocal.protobuf.crs;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.modelfriend.a */
public final class C32815a extends C1207m implements C1918k {
    public static C26442a fBa;
    C1202f ehi;
    public final C1929q ftU;
    private int ftx;

    /* renamed from: com.tencent.mm.modelfriend.a$a */
    public interface C26442a {
        String agu();
    }

    /* renamed from: com.tencent.mm.modelfriend.a$b */
    public static class C32816b extends C6297k {
        private final C7244a fBe = new C7244a();
        private final C7245b fBf = new C7245b();

        public C32816b() {
            AppMethodBeat.m2504i(123397);
            AppMethodBeat.m2505o(123397);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.fBe;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fBf;
        }

        public final int getType() {
            return 145;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bindopmobileforreg";
        }

        public final int acC() {
            return 1;
        }
    }

    public C32815a(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, str3, str4);
        AppMethodBeat.m2504i(123398);
        C7244a c7244a = (C7244a) this.ftU.acF();
        c7244a.vyq.vLx = str5;
        c7244a.vyq.vLy = str6;
        AppMethodBeat.m2505o(123398);
    }

    public C32815a(String str, int i, String str2, String str3, String str4) {
        this(str, i, str2, 0, str3);
        AppMethodBeat.m2504i(123399);
        ((C7244a) this.ftU.acF()).vyq.vHS = str4;
        AppMethodBeat.m2505o(123399);
    }

    public C32815a(String str, int i, String str2, int i2, String str3) {
        AppMethodBeat.m2504i(123400);
        this.ehi = null;
        this.ftx = 2;
        this.ftU = new C32816b();
        C7244a c7244a = (C7244a) this.ftU.acF();
        c7244a.vyq.vIJ = i;
        C4990ab.m7410d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        c7244a.vyq.vLs = str;
        c7244a.vyq.vLt = str2;
        c7244a.vyq.vLu = i2;
        c7244a.vyq.vLv = str3;
        c7244a.vyq.luQ = C4988aa.dor();
        c7244a.vyq.vIj = C1668a.m3397Rb();
        if (C5046bo.isNullOrNil(c7244a.vyq.vLx) && C5046bo.isNullOrNil(c7244a.vyq.vLy)) {
            c7244a.vyq.vLx = fBa != null ? fBa.agu() : "";
            c7244a.vyq.vLy = C7243d.DEVICE_NAME;
        }
        AppMethodBeat.m2505o(123400);
    }

    /* renamed from: lo */
    public final void mo53384lo(int i) {
        AppMethodBeat.m2504i(123401);
        ((C7244a) this.ftU.acF()).vyq.vLA = i;
        AppMethodBeat.m2505o(123401);
    }

    /* renamed from: lp */
    public final void mo53385lp(int i) {
        AppMethodBeat.m2504i(123402);
        ((C7244a) this.ftU.acF()).vyq.vLB = i;
        AppMethodBeat.m2505o(123402);
    }

    /* renamed from: Ah */
    public final int mo53366Ah() {
        AppMethodBeat.m2504i(123403);
        int i = ((C7244a) this.ftU.acF()).vyq.vIJ;
        AppMethodBeat.m2505o(123403);
        return i;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(123404);
        this.ehi = c1202f;
        C7244a c7244a = (C7244a) this.ftU.acF();
        if (c7244a.vyq.vLs == null || c7244a.vyq.vLs.length() <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + c7244a.vyq.vLs);
            AppMethodBeat.m2505o(123404);
            return -1;
        } else if ((c7244a.vyq.vIJ == 6 || c7244a.vyq.vIJ == 9) && (c7244a.vyq.vLt == null || c7244a.vyq.vLt.length() <= 0)) {
            C4990ab.m7412e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + c7244a.vyq.vLs);
            AppMethodBeat.m2505o(123404);
            return -1;
        } else {
            int a = mo4457a(c1902e, this.ftU, this);
            AppMethodBeat.m2505o(123404);
            return a;
        }
    }

    public final int getType() {
        return 145;
    }

    public final int acn() {
        return 3;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(123405);
        C4990ab.m7417i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        C7245b c7245b = (C7245b) c1929q.mo5618ZS();
        if (c7245b == null || c7245b.vyr == null) {
            C4990ab.m7417i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", c7245b);
        } else {
            int i4 = c7245b.vyr.vHW;
            C4990ab.m7417i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", Integer.valueOf(i4));
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(47, Integer.valueOf(i4));
            C1902e c1902e = C1720g.m3535RO().eJo.ftA;
            if (c1902e != null) {
                c1902e.mo5534cI((i4 & 1) == 0);
            }
        }
        if (i2 == 4 && i3 == -301) {
            C7484ax.m12918a(true, c7245b.vyr.vLL, c7245b.vyr.vLM, c7245b.vyr.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(123405);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123405);
        } else if (i2 == 4 && i3 == -240) {
            C4990ab.m7417i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(123405);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123405);
        } else if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i5 = c1929q.acF().vyj.ver;
            C4990ab.m7411d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            C1720g.m3539RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.modelfriend.a$1$1 */
                class C66771 implements C1202f {
                    C66771() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(123395);
                        C4990ab.m7411d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C32815a.this.mo4456a(C32815a.this.ftf, C32815a.this.ehi);
                            AppMethodBeat.m2505o(123395);
                            return;
                        }
                        C32815a.this.ehi.onSceneEnd(i, i2, "", C32815a.this);
                        AppMethodBeat.m2505o(123395);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(123396);
                    new C18674i().mo4456a(C32815a.this.ftf, new C66771());
                    AppMethodBeat.m2505o(123396);
                }
            });
            AppMethodBeat.m2505o(123405);
        } else if (i2 == 4 && (i3 == -305 || i3 == -306)) {
            C4990ab.m7417i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i3), Integer.valueOf(C4815f.vxC));
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123405);
        } else if (i2 == 0 && i3 == 0) {
            C7484ax.m12918a(false, c7245b.vyr.vLL, c7245b.vyr.vLM, c7245b.vyr.vLK);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(123405);
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(123405);
        }
    }

    public final String agf() {
        AppMethodBeat.m2504i(123406);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.vLJ;
        AppMethodBeat.m2505o(123406);
        return str;
    }

    public final String getUsername() {
        AppMethodBeat.m2504i(123407);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.vHl;
        AppMethodBeat.m2505o(123407);
        return str;
    }

    public final String agg() {
        AppMethodBeat.m2504i(123408);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.cxb;
        AppMethodBeat.m2505o(123408);
        return str;
    }

    public final String agh() {
        AppMethodBeat.m2504i(123409);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.vHS;
        AppMethodBeat.m2505o(123409);
        return str;
    }

    public final String agi() {
        AppMethodBeat.m2504i(123410);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.vLQ;
        AppMethodBeat.m2505o(123410);
        return str;
    }

    public final int agj() {
        AppMethodBeat.m2504i(123411);
        int i = ((C7245b) this.ftU.mo5618ZS()).vyr.vLC;
        AppMethodBeat.m2505o(123411);
        return i;
    }

    public final String agk() {
        AppMethodBeat.m2504i(123412);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.vLS;
        AppMethodBeat.m2505o(123412);
        return str;
    }

    public final String agl() {
        AppMethodBeat.m2504i(123413);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.vLT;
        AppMethodBeat.m2505o(123413);
        return str;
    }

    /* renamed from: a */
    public final void mo53367a(crs crs) {
        AppMethodBeat.m2504i(123414);
        try {
            ((C7244a) this.ftU.acF()).vyq.vLF = new SKBuiltinBuffer_t().setBuffer(crs.toByteArray());
            AppMethodBeat.m2505o(123414);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(123414);
        }
    }

    public final int agm() {
        int i;
        AppMethodBeat.m2504i(123415);
        bzr bzr = ((C7245b) this.ftU.mo5618ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 6) {
                    i = C5046bo.getInt(cfi.xeN, 3);
                    break;
                }
            }
        }
        i = 3;
        AppMethodBeat.m2505o(123415);
        return i;
    }

    public final int agn() {
        int i;
        AppMethodBeat.m2504i(123416);
        bzr bzr = ((C7245b) this.ftU.mo5618ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 4) {
                    i = C5046bo.getInt(cfi.xeN, 30);
                    break;
                }
            }
        }
        i = 30;
        AppMethodBeat.m2505o(123416);
        return i;
    }

    public final int ago() {
        int i;
        AppMethodBeat.m2504i(123417);
        bzr bzr = ((C7245b) this.ftU.mo5618ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 5) {
                    i = C5046bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.m2505o(123417);
        return i;
    }

    public final boolean agp() {
        int i;
        AppMethodBeat.m2504i(123418);
        bzr bzr = ((C7245b) this.ftU.mo5618ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 7) {
                    i = C5046bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        if (i > 0) {
            AppMethodBeat.m2505o(123418);
            return true;
        }
        AppMethodBeat.m2505o(123418);
        return false;
    }

    public final boolean agq() {
        int i;
        AppMethodBeat.m2504i(123419);
        bzr bzr = ((C7245b) this.ftU.mo5618ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 10) {
                    i = C5046bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        if (i > 0) {
            AppMethodBeat.m2505o(123419);
            return true;
        }
        AppMethodBeat.m2505o(123419);
        return false;
    }

    public final String agr() {
        String str;
        AppMethodBeat.m2504i(123420);
        bzr bzr = ((C7245b) this.ftU.mo5618ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 14) {
                    str = cfi.xeN;
                    break;
                }
            }
        }
        str = null;
        AppMethodBeat.m2505o(123420);
        return str;
    }

    public final String ags() {
        String str;
        AppMethodBeat.m2504i(123421);
        bzr bzr = ((C7245b) this.ftU.mo5618ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 15) {
                    str = cfi.xeN;
                    break;
                }
            }
        }
        str = null;
        AppMethodBeat.m2505o(123421);
        return str;
    }

    public final String agt() {
        AppMethodBeat.m2504i(123422);
        String str = ((C7245b) this.ftU.mo5618ZS()).vyr.vLD;
        AppMethodBeat.m2505o(123422);
        return str;
    }

    /* renamed from: rV */
    public final void mo53386rV(String str) {
        AppMethodBeat.m2504i(123423);
        ((C7244a) this.ftU.acF()).vyq.vLD = str;
        AppMethodBeat.m2505o(123423);
    }
}

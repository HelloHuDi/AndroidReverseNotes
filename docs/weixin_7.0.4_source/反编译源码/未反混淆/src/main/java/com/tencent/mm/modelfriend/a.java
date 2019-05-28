package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class a extends m implements k {
    public static a fBa;
    f ehi;
    public final q ftU;
    private int ftx;

    public interface a {
        String agu();
    }

    public static class b extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.n.a fBe = new com.tencent.mm.protocal.n.a();
        private final com.tencent.mm.protocal.n.b fBf = new com.tencent.mm.protocal.n.b();

        public b() {
            AppMethodBeat.i(123397);
            AppMethodBeat.o(123397);
        }

        public final d ZR() {
            return this.fBe;
        }

        public final e ZS() {
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

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, str3, str4);
        AppMethodBeat.i(123398);
        com.tencent.mm.protocal.n.a aVar = (com.tencent.mm.protocal.n.a) this.ftU.acF();
        aVar.vyq.vLx = str5;
        aVar.vyq.vLy = str6;
        AppMethodBeat.o(123398);
    }

    public a(String str, int i, String str2, String str3, String str4) {
        this(str, i, str2, 0, str3);
        AppMethodBeat.i(123399);
        ((com.tencent.mm.protocal.n.a) this.ftU.acF()).vyq.vHS = str4;
        AppMethodBeat.o(123399);
    }

    public a(String str, int i, String str2, int i2, String str3) {
        AppMethodBeat.i(123400);
        this.ehi = null;
        this.ftx = 2;
        this.ftU = new b();
        com.tencent.mm.protocal.n.a aVar = (com.tencent.mm.protocal.n.a) this.ftU.acF();
        aVar.vyq.vIJ = i;
        ab.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        aVar.vyq.vLs = str;
        aVar.vyq.vLt = str2;
        aVar.vyq.vLu = i2;
        aVar.vyq.vLv = str3;
        aVar.vyq.luQ = aa.dor();
        aVar.vyq.vIj = com.tencent.mm.kernel.a.Rb();
        if (bo.isNullOrNil(aVar.vyq.vLx) && bo.isNullOrNil(aVar.vyq.vLy)) {
            aVar.vyq.vLx = fBa != null ? fBa.agu() : "";
            aVar.vyq.vLy = com.tencent.mm.protocal.d.DEVICE_NAME;
        }
        AppMethodBeat.o(123400);
    }

    public final void lo(int i) {
        AppMethodBeat.i(123401);
        ((com.tencent.mm.protocal.n.a) this.ftU.acF()).vyq.vLA = i;
        AppMethodBeat.o(123401);
    }

    public final void lp(int i) {
        AppMethodBeat.i(123402);
        ((com.tencent.mm.protocal.n.a) this.ftU.acF()).vyq.vLB = i;
        AppMethodBeat.o(123402);
    }

    public final int Ah() {
        AppMethodBeat.i(123403);
        int i = ((com.tencent.mm.protocal.n.a) this.ftU.acF()).vyq.vIJ;
        AppMethodBeat.o(123403);
        return i;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(123404);
        this.ehi = fVar;
        com.tencent.mm.protocal.n.a aVar = (com.tencent.mm.protocal.n.a) this.ftU.acF();
        if (aVar.vyq.vLs == null || aVar.vyq.vLs.length() <= 0) {
            ab.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + aVar.vyq.vLs);
            AppMethodBeat.o(123404);
            return -1;
        } else if ((aVar.vyq.vIJ == 6 || aVar.vyq.vIJ == 9) && (aVar.vyq.vLt == null || aVar.vyq.vLt.length() <= 0)) {
            ab.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + aVar.vyq.vLs);
            AppMethodBeat.o(123404);
            return -1;
        } else {
            int a = a(eVar, this.ftU, this);
            AppMethodBeat.o(123404);
            return a;
        }
    }

    public final int getType() {
        return 145;
    }

    public final int acn() {
        return 3;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }

    public final void a(com.tencent.mm.ai.m.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(123405);
        ab.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.protocal.n.b bVar = (com.tencent.mm.protocal.n.b) qVar.ZS();
        if (bVar == null || bVar.vyr == null) {
            ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", bVar);
        } else {
            int i4 = bVar.vyr.vHW;
            ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", Integer.valueOf(i4));
            g.RQ();
            g.RP().eJH.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.RO().eJo.ftA;
            if (eVar != null) {
                eVar.cI((i4 & 1) == 0);
            }
        }
        if (i2 == 4 && i3 == -301) {
            ax.a(true, bVar.vyr.vLL, bVar.vyr.vLM, bVar.vyr.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(123405);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123405);
        } else if (i2 == 4 && i3 == -240) {
            ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(123405);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123405);
        } else if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i5 = qVar.acF().vyj.ver;
            ab.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(123396);
                    new i().a(a.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(123395);
                            ab.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                a.this.a(a.this.ftf, a.this.ehi);
                                AppMethodBeat.o(123395);
                                return;
                            }
                            a.this.ehi.onSceneEnd(i, i2, "", a.this);
                            AppMethodBeat.o(123395);
                        }
                    });
                    AppMethodBeat.o(123396);
                }
            });
            AppMethodBeat.o(123405);
        } else if (i2 == 4 && (i3 == -305 || i3 == -306)) {
            ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.f.vxC));
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123405);
        } else if (i2 == 0 && i3 == 0) {
            ax.a(false, bVar.vyr.vLL, bVar.vyr.vLM, bVar.vyr.vLK);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(123405);
        } else {
            ab.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(123405);
        }
    }

    public final String agf() {
        AppMethodBeat.i(123406);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vLJ;
        AppMethodBeat.o(123406);
        return str;
    }

    public final String getUsername() {
        AppMethodBeat.i(123407);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHl;
        AppMethodBeat.o(123407);
        return str;
    }

    public final String agg() {
        AppMethodBeat.i(123408);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.cxb;
        AppMethodBeat.o(123408);
        return str;
    }

    public final String agh() {
        AppMethodBeat.i(123409);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHS;
        AppMethodBeat.o(123409);
        return str;
    }

    public final String agi() {
        AppMethodBeat.i(123410);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vLQ;
        AppMethodBeat.o(123410);
        return str;
    }

    public final int agj() {
        AppMethodBeat.i(123411);
        int i = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vLC;
        AppMethodBeat.o(123411);
        return i;
    }

    public final String agk() {
        AppMethodBeat.i(123412);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vLS;
        AppMethodBeat.o(123412);
        return str;
    }

    public final String agl() {
        AppMethodBeat.i(123413);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vLT;
        AppMethodBeat.o(123413);
        return str;
    }

    public final void a(crs crs) {
        AppMethodBeat.i(123414);
        try {
            ((com.tencent.mm.protocal.n.a) this.ftU.acF()).vyq.vLF = new SKBuiltinBuffer_t().setBuffer(crs.toByteArray());
            AppMethodBeat.o(123414);
        } catch (Throwable th) {
            AppMethodBeat.o(123414);
        }
    }

    public final int agm() {
        int i;
        AppMethodBeat.i(123415);
        bzr bzr = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 6) {
                    i = bo.getInt(cfi.xeN, 3);
                    break;
                }
            }
        }
        i = 3;
        AppMethodBeat.o(123415);
        return i;
    }

    public final int agn() {
        int i;
        AppMethodBeat.i(123416);
        bzr bzr = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 4) {
                    i = bo.getInt(cfi.xeN, 30);
                    break;
                }
            }
        }
        i = 30;
        AppMethodBeat.o(123416);
        return i;
    }

    public final int ago() {
        int i;
        AppMethodBeat.i(123417);
        bzr bzr = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 5) {
                    i = bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.o(123417);
        return i;
    }

    public final boolean agp() {
        int i;
        AppMethodBeat.i(123418);
        bzr bzr = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 7) {
                    i = bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        if (i > 0) {
            AppMethodBeat.o(123418);
            return true;
        }
        AppMethodBeat.o(123418);
        return false;
    }

    public final boolean agq() {
        int i;
        AppMethodBeat.i(123419);
        bzr bzr = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 10) {
                    i = bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        if (i > 0) {
            AppMethodBeat.o(123419);
            return true;
        }
        AppMethodBeat.o(123419);
        return false;
    }

    public final String agr() {
        String str;
        AppMethodBeat.i(123420);
        bzr bzr = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHR;
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
        AppMethodBeat.o(123420);
        return str;
    }

    public final String ags() {
        String str;
        AppMethodBeat.i(123421);
        bzr bzr = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vHR;
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
        AppMethodBeat.o(123421);
        return str;
    }

    public final String agt() {
        AppMethodBeat.i(123422);
        String str = ((com.tencent.mm.protocal.n.b) this.ftU.ZS()).vyr.vLD;
        AppMethodBeat.o(123422);
        return str;
    }

    public final void rV(String str) {
        AppMethodBeat.i(123423);
        ((com.tencent.mm.protocal.n.a) this.ftU.acF()).vyq.vLD = str;
        AppMethodBeat.o(123423);
    }
}

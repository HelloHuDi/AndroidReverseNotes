package com.tencent.mm.modelsimple;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.v;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends m implements k {
    f ehi;
    private final int fPA;
    private boolean fPB = true;
    public boolean fPC = false;
    private final String fPt;
    private final String fPu;
    private final String fPv;
    private final String fPw;
    private final String fPx;
    private final String fPy;
    private final int fPz;
    public q ftU;
    private int ftx = 2;

    public s(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2) {
        AppMethodBeat.i(123463);
        ab.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        ab.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i + "bindEmail = " + str4 + " bindMobile = " + str5);
        ab.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i2 + " ticket: " + str6);
        this.fPA = i2;
        this.ftU = new az();
        a aVar = (a) this.ftU.acF();
        aVar.hB(0);
        aVar.vyI.jBB = str;
        aVar.vyI.vLJ = bo.and(str2);
        if (i2 == 4) {
            aVar.vyI.vLJ = str6;
            ab.w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + aVar.vyI.vLJ);
        }
        aVar.vyI.jCH = str3;
        aVar.vyI.vCf = i;
        aVar.vyI.vCg = str4;
        aVar.vyI.vCh = str5;
        aVar.vyI.wdB = str6;
        aVar.vyI.wsN = i2;
        aVar.vyI.luP = bo.dpA();
        aVar.vyI.wdz = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.vyI.luQ = aa.dor();
        aVar.vyI.vIi = 0;
        aVar.vyI.wHX = 0;
        aVar.vyI.wHY = com.tencent.mm.compatible.e.q.getAndroidId();
        aVar.vyI.wfH = com.tencent.mm.compatible.e.q.LP();
        aVar.vyI.wHZ = ah.getContext().getSharedPreferences(ah.doA(), 0).getString("installreferer", "");
        aVar.vyI.wIa = b.oTO.An(2);
        aVar.vyI.wIb = ah.getContext().getSharedPreferences(ah.doA() + "_google_aid", h.Mu()).getString("getgoogleaid", "");
        this.fPt = str;
        this.fPu = str2;
        this.fPv = str3;
        this.fPw = str4;
        this.fPx = str5;
        this.fPz = i;
        this.fPy = "";
        boolean z = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        this.fPB = z;
        aVar.vyI.vIj = com.tencent.mm.kernel.a.Rb();
        AppMethodBeat.o(123463);
    }

    public s(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, boolean z, boolean z2) {
        AppMethodBeat.i(123464);
        ab.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", str, bo.anv(str2), str3, Integer.valueOf(i), str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2));
        this.fPA = i2;
        this.ftU = new az();
        a aVar = (a) this.ftU.acF();
        aVar.hB(0);
        aVar.vyI.jBB = str;
        aVar.vyI.vLJ = bo.and(str2);
        if (i2 == 4) {
            aVar.vyI.vLJ = str8;
            ab.w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + aVar.vyI.vLJ);
        }
        aVar.vyI.jCH = str3;
        aVar.vyI.vCf = i;
        aVar.vyI.vCg = str4;
        aVar.vyI.vCh = str5;
        aVar.vyI.wdB = str8;
        aVar.vyI.wsN = i2;
        aVar.vyI.luP = bo.dpA();
        aVar.vyI.wdz = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.vyI.luQ = aa.dor();
        aVar.vyI.vIi = 0;
        aVar.vyI.guS = str9;
        aVar.vyI.wsM = str11;
        aVar.vyI.wsL = str10;
        aVar.vyI.vLw = z ? 1 : 0;
        aVar.vyI.wHW = z2 ? 1 : 0;
        aVar.vyI.vIj = com.tencent.mm.kernel.a.Rb();
        aVar.vyI.wHY = com.tencent.mm.compatible.e.q.getAndroidId();
        aVar.vyI.wfH = com.tencent.mm.compatible.e.q.LP();
        aVar.vyI.wHZ = ah.getContext().getSharedPreferences(ah.doA(), 0).getString("installreferer", "");
        aVar.vyI.wIa = b.oTO.An(2);
        aVar.vyI.wIb = ah.getContext().getSharedPreferences(ah.doA() + "_google_aid", h.Mu()).getString("getgoogleaid", "");
        this.fPt = str;
        this.fPu = str2;
        this.fPv = str3;
        this.fPw = str4;
        this.fPx = str5;
        this.fPz = i;
        this.fPy = str9;
        boolean z3 = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        this.fPB = z3;
        AppMethodBeat.o(123464);
    }

    public final void lX(int i) {
        AppMethodBeat.i(123465);
        ((a) this.ftU.acF()).vyI.vLC = i;
        AppMethodBeat.o(123465);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(123466);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(123466);
        return a;
    }

    public final int acn() {
        return 3;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final void a(m.a aVar) {
    }

    public final void ts(String str) {
        AppMethodBeat.i(123467);
        if (!bo.isNullOrNil(str)) {
            ((a) this.ftU.acF()).vyI.vLD = str;
            ab.i("MicroMsg.NetSceneReg", "setRegSessionId %s", str);
        }
        AppMethodBeat.o(123467);
    }

    public final void tt(String str) {
        AppMethodBeat.i(123468);
        if (!bo.isNullOrNil(str)) {
            ((a) this.ftU.acF()).vyI.wIg = str;
            ab.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", str);
        }
        AppMethodBeat.o(123468);
    }

    public final int getType() {
        return 126;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        AppMethodBeat.i(123469);
        final v.b bVar = (v.b) qVar.ZS();
        if (bVar.vyJ != null) {
            i4 = bVar.vyJ.vHW;
            ab.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", Integer.valueOf(i4));
            g.RQ();
            g.RP().eJH.set(47, Integer.valueOf(i4));
            e eVar = g.RO().eJo.ftA;
            if (eVar != null) {
                eVar.cI((i4 & 1) == 0);
            }
        } else {
            ab.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", Integer.valueOf(bVar.vyl));
        }
        if (i2 == 4 && i3 == -301) {
            ax.a(true, bVar.vyJ.vLL, bVar.vyJ.vLM, bVar.vyJ.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(123469);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123469);
        } else if (i2 == 4 && i3 == -240) {
            ab.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(123469);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123469);
        } else if (i2 == 4 && i3 == -102) {
            i4 = qVar.acF().vyj.ver;
            ab.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(123461);
                    new i().a(s.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(123460);
                            ab.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                s.this.a(s.this.ftf, s.this.ehi);
                                AppMethodBeat.o(123460);
                                return;
                            }
                            s.this.ehi.onSceneEnd(i, i2, "", s.this);
                            AppMethodBeat.o(123460);
                        }
                    });
                    AppMethodBeat.o(123461);
                }
            });
            AppMethodBeat.o(123469);
        } else if (i2 == 4 && (i3 == -305 || i3 == -306)) {
            ab.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.f.vxC));
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123469);
        } else if (i2 == 0 && i3 == 0) {
            a aVar = (a) qVar.acF();
            ab.d("MicroMsg.NetSceneReg", "dkreg: pass:" + bVar.vyJ.luH + " regtype:" + bVar.vyJ.vCj + " mode:" + aVar.vyI.wsN);
            if (!(bVar.vyJ.luF == 0 || this.fPB)) {
                g.RQ();
                g.jR(bVar.vyJ.luF);
                g.RP().Ry().set(2, aVar.vyI.jBB);
                g.RP().Ry().set(16, Integer.valueOf(1));
                g.RP().Ry().set(52, Integer.valueOf(bVar.vyJ.vCj));
                g.RP().Ry().set(340240, Long.valueOf(System.currentTimeMillis()));
                g.RP().Ry().set(340241, Boolean.TRUE);
                if (!(this.fPt == null || this.fPt.length() <= 0 || this.fPA == 1)) {
                    bVar.vyJ.jBB = this.fPt;
                }
                bVar.vyJ.vCg = this.fPw;
                bVar.vyJ.jBT = 0;
                if (!g.RK() || g.RP().Ry() == null) {
                    r7 = new Object[3];
                    g.RN();
                    r7[1] = p.getString(com.tencent.mm.kernel.a.QF());
                    r7[2] = g.RP().Ry();
                    ab.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", r7);
                } else {
                    Object obj = this.fPy;
                    int i5 = this.fPz;
                    Object obj2 = this.fPv;
                    Object obj3 = this.fPx;
                    Object obj4 = bVar.vyJ.jBB;
                    Object obj5 = bVar.vyJ.vCg;
                    int i6 = bVar.vyJ.jBT;
                    Object obj6 = bVar.vyJ.vCm;
                    Object obj7 = bVar.vyJ.vCn;
                    int i7 = bVar.vyJ.vCo;
                    int i8 = bVar.vyJ.wIi;
                    String str2 = bVar.vyJ.vAN;
                    String str3 = bVar.vyJ.vCp;
                    String str4 = bVar.vyJ.vHO;
                    String str5 = bVar.vyJ.wIh;
                    ab.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", obj4, obj, p.getString(i5), obj2, obj5, obj3, Integer.valueOf(i6), obj6, obj7, Integer.valueOf(i7), Integer.valueOf(i8), bo.anv(str2), str3, Integer.valueOf(0), bo.anv(str4), bo.anv(null), bo.anv(null), bo.anv(null), Integer.valueOf(-1), str5, Integer.valueOf(0));
                    z Ry = g.RP().Ry();
                    av.fly.ak("login_weixin_username", obj4);
                    av.fly.ak("last_login_nick_name", obj2);
                    av.fly.c(obj3, i5, obj5);
                    Ry.set(2, obj4);
                    Ry.set(42, obj);
                    Ry.set(9, Integer.valueOf(i5));
                    Ry.set(4, obj2);
                    Ry.set(5, obj5);
                    Ry.set(6, obj3);
                    Ry.set(7, Integer.valueOf(i6));
                    Ry.set(21, obj6);
                    Ry.set(22, obj7);
                    Ry.set(57, Integer.valueOf(0));
                    Ry.set(17, Integer.valueOf(i7));
                    Ry.set(25, Integer.valueOf(i8));
                    Ry.set(1, (Object) str2);
                    Ry.set(29, (Object) str3);
                    Ry.set(34, Integer.valueOf(0));
                    Ry.set(256, Boolean.FALSE);
                    ab.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
                    Ry.set(-1535680990, (Object) str4);
                    Ry.set(46, null);
                    Ry.set(72, null);
                    Ry.set(64, Integer.valueOf(-1));
                    Ry.dsb();
                    ((PluginAuth) g.M(PluginAuth.class)).getHandleAuthResponseCallbacks().a(bVar, this.fPy, this.fPz, this.fPv, this.fPx, 0);
                }
                ax.a(false, bVar.vyJ.vLL, bVar.vyJ.vLM, bVar.vyJ.vLK);
                g.RP().Ry().dsb();
                g.Rg().a(new bk(new bk.a() {
                    public final void a(e eVar) {
                        AppMethodBeat.i(123462);
                        if (eVar == null) {
                            AppMethodBeat.o(123462);
                            return;
                        }
                        eVar.adg().a(bVar.LA(1), bVar.LA(2), bVar.LA(3), bVar.vyJ.luF);
                        AppMethodBeat.o(123462);
                    }
                }), 0);
                ab.d("MicroMsg.NetSceneReg", "resp return flag" + bVar.vyJ.wIk);
                this.fPC = (bVar.vyJ.wIk & 1) != 0;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(new com.tencent.mm.az.h.a(21, "android-" + VERSION.SDK_INT + "-" + Build.MODEL));
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.az.h(linkedList));
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(123469);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(123469);
        }
    }

    public final byte[] ajo() {
        AppMethodBeat.i(123470);
        byte[] a = com.tencent.mm.platformtools.aa.a(((v.b) this.ftU.ZS()).vyJ.wsO, new byte[0]);
        AppMethodBeat.o(123470);
        return a;
    }

    public final String ajn() {
        AppMethodBeat.i(123471);
        String str = ((v.b) this.ftU.ZS()).vyJ.wsL;
        AppMethodBeat.o(123471);
        return str;
    }

    public final String ajw() {
        AppMethodBeat.i(123472);
        String str = ((v.b) this.ftU.ZS()).vyJ.wIo;
        AppMethodBeat.o(123472);
        return str;
    }

    public final int ajx() {
        int i;
        AppMethodBeat.i(123473);
        bzr bzr = ((v.b) this.ftU.ZS()).vyJ.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 1) {
                    i = bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.o(123473);
        return i;
    }

    public final String ajy() {
        String str;
        AppMethodBeat.i(123474);
        bzr bzr = ((v.b) this.ftU.ZS()).vyJ.vHR;
        String str2 = "";
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 2) {
                    str = cfi.xeN;
                    break;
                }
            }
        }
        str = str2;
        AppMethodBeat.o(123474);
        return str;
    }

    public final int ajz() {
        int i;
        AppMethodBeat.i(123475);
        bzr bzr = ((v.b) this.ftU.ZS()).vyJ.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 3) {
                    i = bo.getInt(cfi.xeN, 2);
                    break;
                }
            }
        }
        i = 2;
        AppMethodBeat.o(123475);
        return i;
    }

    public final String ajA() {
        String str;
        AppMethodBeat.i(123476);
        bzr bzr = ((v.b) this.ftU.ZS()).vyJ.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 17) {
                    str = cfi.xeN;
                    break;
                }
            }
        }
        str = null;
        AppMethodBeat.o(123476);
        return str;
    }
}

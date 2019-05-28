package com.tencent.p177mm.modelsimple;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C42186az;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.auth.PluginAuth;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4842v.C4843a;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.protocal.protobuf.bzr;
import com.tencent.p177mm.protocal.protobuf.cfi;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7580z;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.modelsimple.s */
public final class C26472s extends C1207m implements C1918k {
    C1202f ehi;
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
    public C1929q ftU;
    private int ftx = 2;

    public C26472s(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2) {
        AppMethodBeat.m2504i(123463);
        C4990ab.m7410d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        C4990ab.m7410d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i + "bindEmail = " + str4 + " bindMobile = " + str5);
        C4990ab.m7410d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i2 + " ticket: " + str6);
        this.fPA = i2;
        this.ftU = new C42186az();
        C4843a c4843a = (C4843a) this.ftU.acF();
        c4843a.mo10000hB(0);
        c4843a.vyI.jBB = str;
        c4843a.vyI.vLJ = C5046bo.and(str2);
        if (i2 == 4) {
            c4843a.vyI.vLJ = str6;
            C4990ab.m7420w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + c4843a.vyI.vLJ);
        }
        c4843a.vyI.jCH = str3;
        c4843a.vyI.vCf = i;
        c4843a.vyI.vCg = str4;
        c4843a.vyI.vCh = str5;
        c4843a.vyI.wdB = str6;
        c4843a.vyI.wsN = i2;
        c4843a.vyI.luP = C5046bo.dpA();
        c4843a.vyI.wdz = C1427q.getSimCountryIso();
        c4843a.vyI.luQ = C4988aa.dor();
        c4843a.vyI.vIi = 0;
        c4843a.vyI.wHX = 0;
        c4843a.vyI.wHY = C1427q.getAndroidId();
        c4843a.vyI.wfH = C1427q.m3031LP();
        c4843a.vyI.wHZ = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getString("installreferer", "");
        c4843a.vyI.wIa = C6998b.oTO.mo8083An(2);
        c4843a.vyI.wIb = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_google_aid", C1448h.m3078Mu()).getString("getgoogleaid", "");
        this.fPt = str;
        this.fPu = str2;
        this.fPv = str3;
        this.fPw = str4;
        this.fPx = str5;
        this.fPz = i;
        this.fPy = "";
        boolean z = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        this.fPB = z;
        c4843a.vyI.vIj = C1668a.m3397Rb();
        AppMethodBeat.m2505o(123463);
    }

    public C26472s(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, boolean z, boolean z2) {
        AppMethodBeat.m2504i(123464);
        C4990ab.m7417i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", str, C5046bo.anv(str2), str3, Integer.valueOf(i), str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2));
        this.fPA = i2;
        this.ftU = new C42186az();
        C4843a c4843a = (C4843a) this.ftU.acF();
        c4843a.mo10000hB(0);
        c4843a.vyI.jBB = str;
        c4843a.vyI.vLJ = C5046bo.and(str2);
        if (i2 == 4) {
            c4843a.vyI.vLJ = str8;
            C4990ab.m7420w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + c4843a.vyI.vLJ);
        }
        c4843a.vyI.jCH = str3;
        c4843a.vyI.vCf = i;
        c4843a.vyI.vCg = str4;
        c4843a.vyI.vCh = str5;
        c4843a.vyI.wdB = str8;
        c4843a.vyI.wsN = i2;
        c4843a.vyI.luP = C5046bo.dpA();
        c4843a.vyI.wdz = C1427q.getSimCountryIso();
        c4843a.vyI.luQ = C4988aa.dor();
        c4843a.vyI.vIi = 0;
        c4843a.vyI.guS = str9;
        c4843a.vyI.wsM = str11;
        c4843a.vyI.wsL = str10;
        c4843a.vyI.vLw = z ? 1 : 0;
        c4843a.vyI.wHW = z2 ? 1 : 0;
        c4843a.vyI.vIj = C1668a.m3397Rb();
        c4843a.vyI.wHY = C1427q.getAndroidId();
        c4843a.vyI.wfH = C1427q.m3031LP();
        c4843a.vyI.wHZ = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getString("installreferer", "");
        c4843a.vyI.wIa = C6998b.oTO.mo8083An(2);
        c4843a.vyI.wIb = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_google_aid", C1448h.m3078Mu()).getString("getgoogleaid", "");
        this.fPt = str;
        this.fPu = str2;
        this.fPv = str3;
        this.fPw = str4;
        this.fPx = str5;
        this.fPz = i;
        this.fPy = str9;
        boolean z3 = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        this.fPB = z3;
        AppMethodBeat.m2505o(123464);
    }

    /* renamed from: lX */
    public final void mo44235lX(int i) {
        AppMethodBeat.m2504i(123465);
        ((C4843a) this.ftU.acF()).vyI.vLC = i;
        AppMethodBeat.m2505o(123465);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(123466);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(123466);
        return a;
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

    /* renamed from: ts */
    public final void mo44236ts(String str) {
        AppMethodBeat.m2504i(123467);
        if (!C5046bo.isNullOrNil(str)) {
            ((C4843a) this.ftU.acF()).vyI.vLD = str;
            C4990ab.m7417i("MicroMsg.NetSceneReg", "setRegSessionId %s", str);
        }
        AppMethodBeat.m2505o(123467);
    }

    /* renamed from: tt */
    public final void mo44237tt(String str) {
        AppMethodBeat.m2504i(123468);
        if (!C5046bo.isNullOrNil(str)) {
            ((C4843a) this.ftU.acF()).vyI.wIg = str;
            C4990ab.m7417i("MicroMsg.NetSceneReg", "thirdAppTicket %s", str);
        }
        AppMethodBeat.m2505o(123468);
    }

    public final int getType() {
        return 126;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        int i4;
        AppMethodBeat.m2504i(123469);
        final C4844b c4844b = (C4844b) c1929q.mo5618ZS();
        if (c4844b.vyJ != null) {
            i4 = c4844b.vyJ.vHW;
            C4990ab.m7417i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", Integer.valueOf(i4));
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(47, Integer.valueOf(i4));
            C1902e c1902e = C1720g.m3535RO().eJo.ftA;
            if (c1902e != null) {
                c1902e.mo5534cI((i4 & 1) == 0);
            }
        } else {
            C4990ab.m7417i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", Integer.valueOf(c4844b.vyl));
        }
        if (i2 == 4 && i3 == -301) {
            C7484ax.m12918a(true, c4844b.vyJ.vLL, c4844b.vyJ.vLM, c4844b.vyJ.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(123469);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123469);
        } else if (i2 == 4 && i3 == -240) {
            C4990ab.m7417i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(123469);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123469);
        } else if (i2 == 4 && i3 == -102) {
            i4 = c1929q.acF().vyj.ver;
            C4990ab.m7417i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            C1720g.m3539RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.modelsimple.s$1$1 */
                class C264711 implements C1202f {
                    C264711() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(123460);
                        C4990ab.m7411d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C26472s.this.mo4456a(C26472s.this.ftf, C26472s.this.ehi);
                            AppMethodBeat.m2505o(123460);
                            return;
                        }
                        C26472s.this.ehi.onSceneEnd(i, i2, "", C26472s.this);
                        AppMethodBeat.m2505o(123460);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(123461);
                    new C18674i().mo4456a(C26472s.this.ftf, new C264711());
                    AppMethodBeat.m2505o(123461);
                }
            });
            AppMethodBeat.m2505o(123469);
        } else if (i2 == 4 && (i3 == -305 || i3 == -306)) {
            C4990ab.m7417i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i3), Integer.valueOf(C4815f.vxC));
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123469);
        } else if (i2 == 0 && i3 == 0) {
            C4843a c4843a = (C4843a) c1929q.acF();
            C4990ab.m7410d("MicroMsg.NetSceneReg", "dkreg: pass:" + c4844b.vyJ.luH + " regtype:" + c4844b.vyJ.vCj + " mode:" + c4843a.vyI.wsN);
            if (!(c4844b.vyJ.luF == 0 || this.fPB)) {
                C1720g.m3537RQ();
                C1720g.m3544jR(c4844b.vyJ.luF);
                C1720g.m3536RP().mo5239Ry().set(2, c4843a.vyI.jBB);
                C1720g.m3536RP().mo5239Ry().set(16, Integer.valueOf(1));
                C1720g.m3536RP().mo5239Ry().set(52, Integer.valueOf(c4844b.vyJ.vCj));
                C1720g.m3536RP().mo5239Ry().set(340240, Long.valueOf(System.currentTimeMillis()));
                C1720g.m3536RP().mo5239Ry().set(340241, Boolean.TRUE);
                if (!(this.fPt == null || this.fPt.length() <= 0 || this.fPA == 1)) {
                    c4844b.vyJ.jBB = this.fPt;
                }
                c4844b.vyJ.vCg = this.fPw;
                c4844b.vyJ.jBT = 0;
                if (!C1720g.m3531RK() || C1720g.m3536RP().mo5239Ry() == null) {
                    r7 = new Object[3];
                    C1720g.m3534RN();
                    r7[1] = C1183p.getString(C1668a.m3383QF());
                    r7[2] = C1720g.m3536RP().mo5239Ry();
                    C4990ab.m7413e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", r7);
                } else {
                    Object obj = this.fPy;
                    int i5 = this.fPz;
                    Object obj2 = this.fPv;
                    Object obj3 = this.fPx;
                    Object obj4 = c4844b.vyJ.jBB;
                    Object obj5 = c4844b.vyJ.vCg;
                    int i6 = c4844b.vyJ.jBT;
                    Object obj6 = c4844b.vyJ.vCm;
                    Object obj7 = c4844b.vyJ.vCn;
                    int i7 = c4844b.vyJ.vCo;
                    int i8 = c4844b.vyJ.wIi;
                    String str2 = c4844b.vyJ.vAN;
                    String str3 = c4844b.vyJ.vCp;
                    String str4 = c4844b.vyJ.vHO;
                    String str5 = c4844b.vyJ.wIh;
                    C4990ab.m7417i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", obj4, obj, C1183p.getString(i5), obj2, obj5, obj3, Integer.valueOf(i6), obj6, obj7, Integer.valueOf(i7), Integer.valueOf(i8), C5046bo.anv(str2), str3, Integer.valueOf(0), C5046bo.anv(str4), C5046bo.anv(null), C5046bo.anv(null), C5046bo.anv(null), Integer.valueOf(-1), str5, Integer.valueOf(0));
                    C7580z Ry = C1720g.m3536RP().mo5239Ry();
                    C6665av.fly.mo14897ak("login_weixin_username", obj4);
                    C6665av.fly.mo14897ak("last_login_nick_name", obj2);
                    C6665av.fly.mo14898c(obj3, i5, obj5);
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
                    C4990ab.m7416i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
                    Ry.set(-1535680990, (Object) str4);
                    Ry.set(46, null);
                    Ry.set(72, null);
                    Ry.set(64, Integer.valueOf(-1));
                    Ry.dsb();
                    ((PluginAuth) C1720g.m3530M(PluginAuth.class)).getHandleAuthResponseCallbacks().mo5416a(c4844b, this.fPy, this.fPz, this.fPv, this.fPx, 0);
                }
                C7484ax.m12918a(false, c4844b.vyJ.vLL, c4844b.vyJ.vLM, c4844b.vyJ.vLK);
                C1720g.m3536RP().mo5239Ry().dsb();
                C1720g.m3540Rg().mo14541a(new C6668bk(new C1835a() {
                    /* renamed from: a */
                    public final void mo4918a(C1902e c1902e) {
                        AppMethodBeat.m2504i(123462);
                        if (c1902e == null) {
                            AppMethodBeat.m2505o(123462);
                            return;
                        }
                        c1902e.adg().mo5482a(c4844b.mo10004LA(1), c4844b.mo10004LA(2), c4844b.mo10004LA(3), c4844b.vyJ.luF);
                        AppMethodBeat.m2505o(123462);
                    }
                }), 0);
                C4990ab.m7410d("MicroMsg.NetSceneReg", "resp return flag" + c4844b.vyJ.wIk);
                this.fPC = (c4844b.vyJ.wIk & 1) != 0;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(new C6333a(21, "android-" + VERSION.SDK_INT + "-" + Build.MODEL));
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6332h(linkedList));
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(123469);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(123469);
        }
    }

    public final byte[] ajo() {
        AppMethodBeat.m2504i(123470);
        byte[] a = C1946aa.m4151a(((C4844b) this.ftU.mo5618ZS()).vyJ.wsO, new byte[0]);
        AppMethodBeat.m2505o(123470);
        return a;
    }

    public final String ajn() {
        AppMethodBeat.m2504i(123471);
        String str = ((C4844b) this.ftU.mo5618ZS()).vyJ.wsL;
        AppMethodBeat.m2505o(123471);
        return str;
    }

    public final String ajw() {
        AppMethodBeat.m2504i(123472);
        String str = ((C4844b) this.ftU.mo5618ZS()).vyJ.wIo;
        AppMethodBeat.m2505o(123472);
        return str;
    }

    public final int ajx() {
        int i;
        AppMethodBeat.m2504i(123473);
        bzr bzr = ((C4844b) this.ftU.mo5618ZS()).vyJ.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 1) {
                    i = C5046bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.m2505o(123473);
        return i;
    }

    public final String ajy() {
        String str;
        AppMethodBeat.m2504i(123474);
        bzr bzr = ((C4844b) this.ftU.mo5618ZS()).vyJ.vHR;
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
        AppMethodBeat.m2505o(123474);
        return str;
    }

    public final int ajz() {
        int i;
        AppMethodBeat.m2504i(123475);
        bzr bzr = ((C4844b) this.ftU.mo5618ZS()).vyJ.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 3) {
                    i = C5046bo.getInt(cfi.xeN, 2);
                    break;
                }
            }
        }
        i = 2;
        AppMethodBeat.m2505o(123475);
        return i;
    }

    public final String ajA() {
        String str;
        AppMethodBeat.m2504i(123476);
        bzr bzr = ((C4844b) this.ftU.mo5618ZS()).vyJ.vHR;
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
        AppMethodBeat.m2505o(123476);
        return str;
    }
}

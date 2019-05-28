package com.tencent.p177mm.modelsimple;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C32773aa;
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
import com.tencent.p177mm.p230g.p231a.C37748jt;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.auth.PluginAuth;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.p499b.C34829d;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4824j.C4829d;
import com.tencent.p177mm.protocal.C4824j.C4830e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C7251ar;
import com.tencent.p177mm.protocal.protobuf.C7266hh;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.baf;
import com.tencent.p177mm.protocal.protobuf.bah;
import com.tencent.p177mm.protocal.protobuf.bzr;
import com.tencent.p177mm.protocal.protobuf.cfi;
import com.tencent.p177mm.protocal.protobuf.cjj;
import com.tencent.p177mm.protocal.protobuf.csd;
import com.tencent.p177mm.protocal.protobuf.cwd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.IOException;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.tencent.mm.modelsimple.q */
public final class C6686q extends C1207m implements C1918k {
    public String account;
    C1202f ehi;
    private int errCode;
    private int errType;
    private String fPe;
    private String fPf;
    private boolean fPg;
    private boolean fPh;
    private int fPi;
    private int fPj;
    public String fPk;
    private boolean fPl;
    public final C1929q ftU;
    private int ftx;

    /* renamed from: com.tencent.mm.modelsimple.q$a */
    public static class C6688a {
        public String cEh;
        public String cxb;
        public String fPp;
        public Bundle fPq;
        public int type;
        public String username;

        public final String toString() {
            AppMethodBeat.m2504i(123440);
            String format = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, C5046bo.anv(this.cxb), this.fPp, this.cEh, this.fPq});
            AppMethodBeat.m2505o(123440);
            return format;
        }
    }

    public C6686q(int i, String str, String str2, String str3) {
        this("", "", i, str, str2, str3, 0, "", false, false);
    }

    public C6686q(String str, String str2, String str3, int i) {
        this(str, str2, 0, "", "", "", i, str3, false, false);
    }

    public C6686q(String str, String str2, String str3, String str4) {
        this(str2, str3, 0, "", "", "", 0, str4, true, false);
        this.fPk = str;
    }

    public C6686q(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z, boolean z2) {
        AppMethodBeat.m2504i(123441);
        this.fPe = "";
        this.fPf = "";
        this.account = "";
        this.fPg = false;
        this.fPh = false;
        this.errType = 0;
        this.errCode = 0;
        this.ftx = 3;
        this.fPi = 0;
        this.fPj = 0;
        this.fPl = false;
        C4990ab.m7410d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + str + " secCodetype: " + i + " secCode: " + str3 + " sid: " + str4 + " encryptKey: " + str5 + " inputType: " + i2 + " authTicket: " + str6 + " useRawPwd: " + z + " isMobileAutoLogin: " + z2 + " stack: " + C5046bo.dpG());
        if (z && C5046bo.isNullOrNil(str2)) {
            C4990ab.m7411d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", str2);
        }
        this.account = str;
        this.ftU = new C7484ax(C4815f.vxx ? 252 : 701);
        C4829d c4829d = (C4829d) this.ftU.acF();
        int i3 = C7484ax.m12915ZQ().getInt("key_auth_update_version", 0);
        C4990ab.m7411d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(i3), Integer.valueOf(C7243d.vxo));
        if (i3 == 0) {
            c4829d.vyf = 1;
            C7053e.pXa.mo8378a(148, 0, 1, false);
            c4829d.vxT = true;
        } else if (i3 < C7243d.vxo) {
            c4829d.vyf = 16;
            C7053e.pXa.mo8378a(148, 1, 1, false);
        } else {
            c4829d.vyf = 1;
        }
        c4829d.mo10000hB(0);
        bah bah = new bah();
        baf baf = new baf();
        c4829d.vxS.wEb = bah;
        c4829d.vxS.wEc = baf;
        baf.wEa = i2;
        C7266hh c7266hh = new C7266hh();
        baf.vIg = c7266hh;
        c7266hh.vHS = str6;
        c7266hh.vJW = 0;
        c7266hh.vHN = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        c7266hh.vHM = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        csd csd = new csd();
        c7266hh.vJU = csd;
        csd.vLY = "";
        csd.vLX = "";
        csd.xpA = "";
        cwd cwd = new cwd();
        c7266hh.vJV = cwd;
        cwd.wsM = "";
        cwd.wsL = "";
        if (i == 1) {
            csd.vLY = str3;
            csd.vLX = str4;
            csd.xpA = str5;
            cwd.wsM = "";
            cwd.wsL = "";
        } else if (i == 3) {
            csd.vLY = "";
            csd.vLX = "";
            csd.xpA = "";
            cwd.wsM = str3;
            cwd.wsL = str4;
        }
        if (C5046bo.isNullOrNil(str) && C1720g.m3531RK()) {
            C7053e.pXa.mo8378a(148, 2, 1, false);
            this.fPe = (String) C1720g.m3536RP().mo5239Ry().get(3, null);
            this.fPf = (String) C1720g.m3536RP().mo5239Ry().get(19, null);
            C4830e c4830e = (C4830e) this.ftU.mo5618ZS();
            str = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(2, null));
            if (C5046bo.isNullOrNil(str)) {
                str = new C1183p(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(9, null), 0)).toString();
            } else {
                c4830e.gcF = str;
            }
        } else if (z || z2) {
            this.fPe = str2;
            this.fPf = str2;
        } else {
            this.fPe = C5046bo.and(C5046bo.nullAsNil(str2));
            this.fPf = C5046bo.ane(C5046bo.nullAsNil(str2));
        }
        bah.jBB = str;
        byte[] bArr = null;
        if (!(i == 1 || i == 3)) {
            if (i == 2) {
                bArr = C1720g.m3534RN().mo5158QR().mo4504d(C5046bo.getLong(str, 0), str3);
            } else if (C5046bo.amV(str)) {
                bArr = C1720g.m3534RN().mo5158QR().mo4503a(C5046bo.getLong(str, 0), this.fPf, true);
            }
        }
        String str7 = "MicroMsg.NetSceneManualAuth";
        String str8 = "summerauth loginbuf len:%d content:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = C5046bo.anv(C5046bo.m7539ca(bArr));
        C4990ab.m7417i(str7, str8, objArr);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (C5046bo.m7540cb(bArr)) {
            bArr = new byte[0];
        }
        c7266hh.vJT = sKBuiltinBuffer_t.setBuffer(bArr);
        bah.vLJ = this.fPf;
        bah.vLW = this.fPe;
        C7053e.pXa.mo8378a(148, C4815f.vxx ? 104 : 105, 1, false);
        C7053e.pXa.mo8378a(148, C4815f.vxy ? 106 : 107, 1, false);
        AppMethodBeat.m2505o(123441);
    }

    /* renamed from: tr */
    public final void mo14934tr(String str) {
        AppMethodBeat.m2504i(123442);
        C4829d c4829d = (C4829d) this.ftU.acF();
        c4829d.vxS.wEb.vLJ = str;
        c4829d.vxS.wEb.vLW = str;
        c4829d.vxS.wEc.vIg.vJT = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        this.fPe = str;
        this.fPf = str;
        AppMethodBeat.m2505o(123442);
    }

    public final int getType() {
        return C4815f.vxx ? 252 : 701;
    }

    public final int acn() {
        return 5;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(123443);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(123443);
        return a;
    }

    public final C6686q ajl() {
        this.fPl = true;
        return this;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(123444);
        C4829d c4829d = (C4829d) c1929q.acF();
        final C4830e c4830e = (C4830e) c1929q.mo5618ZS();
        if (c4830e.vxV == null || c4830e.vxV.xid == null) {
            C4990ab.m7417i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", Integer.valueOf(c4830e.vyl));
        } else {
            int i4 = c4830e.vxV.xid.vHW;
            C4990ab.m7417i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", Integer.valueOf(i4));
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(47, Integer.valueOf(i4));
            C1902e c1902e = C1720g.m3535RO().eJo.ftA;
            if (c1902e != null) {
                c1902e.mo5534cI((i4 & 1) == 0);
            }
        }
        this.errType = i2;
        this.errCode = i3;
        cjj cjj = c4830e.vxV;
        if (cjj == null) {
            C4990ab.m7420w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.ehi.onSceneEnd(4, -1, "", this);
            C7053e.pXa.mo8378a(148, 3, 1, false);
            AppMethodBeat.m2505o(123444);
            return;
        }
        int i5 = cjj.xic;
        String str2 = "MicroMsg.NetSceneManualAuth";
        String str3 = "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]";
        Object[] objArr = new Object[10];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = str;
        objArr[3] = cjj;
        objArr[4] = Integer.valueOf(i5);
        objArr[5] = cjj.xid;
        objArr[6] = cjj.xie;
        objArr[7] = cjj.xif;
        objArr[8] = cjj.xid == null ? Integer.valueOf(-1) : cjj.xid.vHY;
        objArr[9] = cjj.xid == null ? Integer.valueOf(-1) : cjj.xid.vHZ;
        C4990ab.m7417i(str2, str3, objArr);
        if (i2 == 0 && i3 == 0) {
            if ((i5 & 2) != 0) {
                C7251ar c7251ar = cjj.xie;
                if (c7251ar == null || C5046bo.isNullOrNil(c7251ar.jBB)) {
                    C4990ab.m7420w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.ehi.onSceneEnd(4, -1, "", this);
                    AppMethodBeat.m2505o(123444);
                    return;
                } else if (C7484ax.m12916a(c1929q) == 2) {
                    C7053e.pXa.mo8378a(148, 7, 1, false);
                    C4990ab.m7411d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", Integer.valueOf(this.fPj));
                    this.fPj++;
                    if (this.fPj > 1) {
                        this.ehi.onSceneEnd(4, -1, "", this);
                        AppMethodBeat.m2505o(123444);
                        return;
                    }
                    ((C4829d) this.ftl.acF()).vxS.wEc.vIg.vJW = 1;
                    mo4456a(this.ftf, this.ehi);
                    AppMethodBeat.m2505o(123444);
                    return;
                } else {
                    C1720g.m3539RS().mo10299Bn();
                    C4990ab.m7411d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
                    C32773aa.m53535a(c4830e.vxV, false);
                    ((PluginAuth) C1720g.m3530M(PluginAuth.class)).getHandleAuthResponseCallbacks().mo5415a(c4829d, c4830e, false);
                    if (!C5046bo.isNullOrNil(this.account)) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, this.account);
                        C6665av.fly.mo14897ak("login_user_name", this.account);
                    }
                    C1720g.m3535RO().eJo.mo14541a(new C6668bk(new C1835a() {
                        /* renamed from: a */
                        public final void mo4918a(C1902e c1902e) {
                            AppMethodBeat.m2504i(123439);
                            if (c1902e == null || c1902e.adg() == null || c4830e.mo9988LA(1) == null || c4830e.mo9988LA(2) == null || c4830e.mo9988LA(3) == null || c4830e.vxV == null || c4830e.vxV.xid == null) {
                                C7053e.pXa.mo8378a(148, 8, 1, false);
                                C4990ab.m7412e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
                                AppMethodBeat.m2505o(123439);
                                return;
                            }
                            C4990ab.m7411d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", C5046bo.anv(C5046bo.m7539ca(c4830e.mo9988LA(1))), C5046bo.anv(C5046bo.m7539ca(c4830e.mo9988LA(2))), C5046bo.anv(C5046bo.m7539ca(c4830e.mo9988LA(3))), Integer.valueOf(c4830e.vxV.xid.luF));
                            c1902e.adg().mo5482a(c4830e.mo9988LA(1), c4830e.mo9988LA(2), c4830e.mo9988LA(3), c4830e.vxV.xid.luF);
                            AppMethodBeat.m2505o(123439);
                        }
                    }), 0);
                    if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(15, null)) != 0) {
                        ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44216lN(10);
                    }
                    if ((cjj.xid.vHV & 8) == 0) {
                        String Yz = C1853r.m3846Yz();
                        if (!TextUtils.isEmpty(Yz)) {
                            C1720g.m3535RO().eJo.mo14541a(new C32826m(Yz), 0);
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", Integer.valueOf(cjj.xid.vHV));
                        C7053e.pXa.mo8378a(148, 9, 1, false);
                    }
                    int i6 = 4;
                    if (c4829d.vxS.wEc.vIg.vJT != null && c4829d.vxS.wEc.vIg.vJT.getILen() > 0) {
                        i6 = 1;
                    } else if (c4829d.vxS.wEc.wEa == 1) {
                        i6 = 2;
                    }
                    C34829d.m57192u(1, i6, c4829d.vxS.wEb.jBB);
                    if (i2 == 0 && i3 == 0) {
                        C4990ab.m7416i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        C37748jt c37748jt = new C37748jt();
                        c37748jt.cER.csN = true;
                        C4879a.xxA.mo10055m(c37748jt);
                    }
                    C1720g.m3539RS().doM();
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(123444);
                    return;
                }
            }
            C4990ab.m7420w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
            this.ehi.onSceneEnd(4, -1, "", this);
            AppMethodBeat.m2505o(123444);
        } else if (i2 == 4 && i3 == -301) {
            C4990ab.m7410d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            C7053e.pXa.mo8378a(148, 4, 1, false);
            if (cjj == null || cjj.xif == null) {
                C4990ab.m7420w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                C7484ax.m12918a(true, cjj.xif.vLL, cjj.xif.vLM, cjj.xif.vLK);
            }
            this.ftx--;
            if (this.ftx <= 0) {
                C4990ab.m7420w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(123444);
                return;
            }
            C4990ab.m7417i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", Integer.valueOf(this.ftx));
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123444);
        } else if (!this.fPl && i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            C7053e.pXa.mo8378a(148, 5, 1, false);
            final int i7 = c1929q.acF().vyj.ver;
            C4990ab.m7417i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i7));
            C1720g.m3539RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.modelsimple.q$1$1 */
                class C18721 implements C1202f {
                    C18721() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(123436);
                        C4990ab.m7411d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C6686q.this.mo4456a(C6686q.this.ftf, C6686q.this.ehi);
                            AppMethodBeat.m2505o(123436);
                            return;
                        }
                        C6686q.this.ehi.onSceneEnd(i, i2, "", C6686q.this);
                        AppMethodBeat.m2505o(123436);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(123437);
                    new C18674i().mo4456a(C6686q.this.ftf, new C18721());
                    AppMethodBeat.m2505o(123437);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(123438);
                    String str = super.toString() + "|onGYNetEnd1";
                    AppMethodBeat.m2505o(123438);
                    return str;
                }
            });
            AppMethodBeat.m2505o(123444);
        } else if (i2 == 4 && (i3 == -305 || i3 == -306)) {
            long j;
            C4990ab.m7417i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i3), Integer.valueOf(C4815f.vxC));
            C7053e c7053e = C7053e.pXa;
            if (i3 == -305) {
                j = 108;
            } else {
                j = 109;
            }
            c7053e.mo8378a(148, j, 1, true);
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123444);
        } else if (i2 == 4 && i3 == -217) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C7053e.pXa.mo8378a(148, 47, 1, false);
            AppMethodBeat.m2505o(123444);
        } else if (i2 == 4 && i3 == -218) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C7053e.pXa.mo8378a(148, 53, 1, false);
            AppMethodBeat.m2505o(123444);
        } else if (i2 == 4 && i3 == -240) {
            C4990ab.m7417i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(123444);
                return;
            }
            C7053e.pXa.mo8378a(148, 57, 1, false);
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(123444);
        } else {
            C4990ab.m7421w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", Integer.valueOf(i3), Integer.valueOf(i2), str);
            this.ehi.onSceneEnd(i2, i3, str, this);
            C7053e.pXa.mo8378a(148, 6, 1, false);
            if (C4815f.vxx && i3 != ZipJNI.UNZ_ERR_OPEN_WRITE) {
                C7053e.pXa.mo8378a(148, 110, 1, false);
            }
            AppMethodBeat.m2505o(123444);
        }
    }

    public final String ajm() {
        AppMethodBeat.m2504i(123445);
        String str;
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.m2505o(123445);
            return str;
        }
        str = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHQ;
        AppMethodBeat.m2505o(123445);
        return str;
    }

    public final String ajn() {
        AppMethodBeat.m2504i(123446);
        String str;
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.m2505o(123446);
            return str;
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHL != null) {
                str = C5046bo.nullAsNil(((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHL.wsL);
                AppMethodBeat.m2505o(123446);
                return str;
            }
        } else if (secCodeType == 1 && ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHK != null) {
            str = C5046bo.nullAsNil(((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHK.vLX);
            AppMethodBeat.m2505o(123446);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(123446);
        return str;
    }

    public final byte[] ajo() {
        AppMethodBeat.m2504i(123447);
        byte[] bArr;
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(123447);
            return bArr;
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHL != null) {
                bArr = C1946aa.m4151a(((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHL.wsO, new byte[0]);
                AppMethodBeat.m2505o(123447);
                return bArr;
            }
        } else if (secCodeType == 1) {
            if (((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHK != null) {
                bArr = C1946aa.m4151a(((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHK.vEF, new byte[0]);
                AppMethodBeat.m2505o(123447);
                return bArr;
            }
        } else if (secCodeType == 2 && ((C4829d) this.ftU.acF()).vxS.wEb != null) {
            C1720g.m3534RN().mo5158QR().mo4502a(C5046bo.getLong(((C4829d) this.ftU.acF()).vxS.wEb.jBB, 0), C1946aa.m4150a(((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHJ));
            bArr = C1720g.m3534RN().mo5158QR().mo4505fs(C5046bo.getLong(((C4829d) this.ftU.acF()).vxS.wEb.jBB, 0));
            AppMethodBeat.m2505o(123447);
            return bArr;
        }
        bArr = new byte[0];
        AppMethodBeat.m2505o(123447);
        return bArr;
    }

    public final int getSecCodeType() {
        AppMethodBeat.m2504i(123448);
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            C4990ab.m7412e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            AppMethodBeat.m2505o(123448);
            return 0;
        } else if (this.errType != 4) {
            C4990ab.m7413e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", Integer.valueOf(this.errType));
            AppMethodBeat.m2505o(123448);
            return 0;
        } else if (this.errCode == -311) {
            AppMethodBeat.m2505o(123448);
            return 2;
        } else if (this.errCode == -6) {
            AppMethodBeat.m2505o(123448);
            return 1;
        } else if (this.errCode == -310) {
            AppMethodBeat.m2505o(123448);
            return 3;
        } else {
            AppMethodBeat.m2505o(123448);
            return 0;
        }
    }

    public final String ajp() {
        AppMethodBeat.m2504i(123449);
        String str;
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.m2505o(123449);
            return str;
        } else if (getSecCodeType() != 1 || ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHK == null) {
            str = "";
            AppMethodBeat.m2505o(123449);
            return str;
        } else if (((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHK.xpA != null) {
            str = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHK.xpA;
            AppMethodBeat.m2505o(123449);
            return str;
        } else {
            AppMethodBeat.m2505o(123449);
            return null;
        }
    }

    public final String agh() {
        AppMethodBeat.m2504i(123450);
        String str = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHS;
        AppMethodBeat.m2505o(123450);
        return str;
    }

    public final String ajq() {
        AppMethodBeat.m2504i(123451);
        String str = ((C4830e) this.ftU.mo5618ZS()).vxV.xie.vCh;
        AppMethodBeat.m2505o(123451);
        return str;
    }

    public final int ajr() {
        AppMethodBeat.m2504i(123452);
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            AppMethodBeat.m2505o(123452);
            return 0;
        }
        int i;
        bzr bzr = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 11) {
                    i = C5046bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.m2505o(123452);
        return i;
    }

    public final BindWordingContent ajs() {
        AppMethodBeat.m2504i(123453);
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            AppMethodBeat.m2505o(123453);
            return null;
        }
        String str;
        BindWordingContent tp;
        bzr bzr = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 12) {
                    str = cfi.xeN;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            C26466a c26466a = new C26466a();
            try {
                tp = C26466a.m42173tp(str);
            } catch (XmlPullParserException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneManualAuth", e, "", new Object[0]);
                tp = null;
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneManualAuth", e2, "", new Object[0]);
            }
            AppMethodBeat.m2505o(123453);
            return tp;
        }
        tp = null;
        AppMethodBeat.m2505o(123453);
        return tp;
    }

    public final String ajt() {
        AppMethodBeat.m2504i(123454);
        String str;
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.m2505o(123454);
            return str;
        }
        bzr bzr = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 16) {
                    str = cfi.xeN;
                    AppMethodBeat.m2505o(123454);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.m2505o(123454);
        return str;
    }

    public final int aju() {
        AppMethodBeat.m2504i(123455);
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            AppMethodBeat.m2505o(123455);
            return 0;
        }
        int i;
        bzr bzr = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 13) {
                    i = C5046bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.m2505o(123455);
        return i;
    }

    public final boolean ajv() {
        AppMethodBeat.m2504i(123456);
        if (((C4830e) this.ftU.mo5618ZS()).vxV.xid == null) {
            AppMethodBeat.m2505o(123456);
            return true;
        }
        bzr bzr = ((C4830e) this.ftU.mo5618ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 18) {
                    if (C5046bo.getInt(cfi.xeN, 0) == 1) {
                        AppMethodBeat.m2505o(123456);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(123456);
        return true;
    }
}

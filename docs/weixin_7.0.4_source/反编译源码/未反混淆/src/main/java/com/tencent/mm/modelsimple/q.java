package com.tencent.mm.modelsimple;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public final class q extends m implements k {
    public String account;
    f ehi;
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
    public final com.tencent.mm.network.q ftU;
    private int ftx;

    public static class a {
        public String cEh;
        public String cxb;
        public String fPp;
        public Bundle fPq;
        public int type;
        public String username;

        public final String toString() {
            AppMethodBeat.i(123440);
            String format = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bo.anv(this.cxb), this.fPp, this.cEh, this.fPq});
            AppMethodBeat.o(123440);
            return format;
        }
    }

    public q(int i, String str, String str2, String str3) {
        this("", "", i, str, str2, str3, 0, "", false, false);
    }

    public q(String str, String str2, String str3, int i) {
        this(str, str2, 0, "", "", "", i, str3, false, false);
    }

    public q(String str, String str2, String str3, String str4) {
        this(str2, str3, 0, "", "", "", 0, str4, true, false);
        this.fPk = str;
    }

    public q(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z, boolean z2) {
        AppMethodBeat.i(123441);
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
        ab.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + str + " secCodetype: " + i + " secCode: " + str3 + " sid: " + str4 + " encryptKey: " + str5 + " inputType: " + i2 + " authTicket: " + str6 + " useRawPwd: " + z + " isMobileAutoLogin: " + z2 + " stack: " + bo.dpG());
        if (z && bo.isNullOrNil(str2)) {
            ab.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", str2);
        }
        this.account = str;
        this.ftU = new ax(com.tencent.mm.protocal.f.vxx ? 252 : 701);
        d dVar = (d) this.ftU.acF();
        int i3 = ax.ZQ().getInt("key_auth_update_version", 0);
        ab.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        if (i3 == 0) {
            dVar.vyf = 1;
            e.pXa.a(148, 0, 1, false);
            dVar.vxT = true;
        } else if (i3 < com.tencent.mm.protocal.d.vxo) {
            dVar.vyf = 16;
            e.pXa.a(148, 1, 1, false);
        } else {
            dVar.vyf = 1;
        }
        dVar.hB(0);
        bah bah = new bah();
        baf baf = new baf();
        dVar.vxS.wEb = bah;
        dVar.vxS.wEc = baf;
        baf.wEa = i2;
        hh hhVar = new hh();
        baf.vIg = hhVar;
        hhVar.vHS = str6;
        hhVar.vJW = 0;
        hhVar.vHN = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        hhVar.vHM = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        csd csd = new csd();
        hhVar.vJU = csd;
        csd.vLY = "";
        csd.vLX = "";
        csd.xpA = "";
        cwd cwd = new cwd();
        hhVar.vJV = cwd;
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
        if (bo.isNullOrNil(str) && g.RK()) {
            e.pXa.a(148, 2, 1, false);
            this.fPe = (String) g.RP().Ry().get(3, null);
            this.fPf = (String) g.RP().Ry().get(19, null);
            j.e eVar = (j.e) this.ftU.ZS();
            str = bo.nullAsNil((String) g.RP().Ry().get(2, null));
            if (bo.isNullOrNil(str)) {
                str = new p(bo.a((Integer) g.RP().Ry().get(9, null), 0)).toString();
            } else {
                eVar.gcF = str;
            }
        } else if (z || z2) {
            this.fPe = str2;
            this.fPf = str2;
        } else {
            this.fPe = bo.and(bo.nullAsNil(str2));
            this.fPf = bo.ane(bo.nullAsNil(str2));
        }
        bah.jBB = str;
        byte[] bArr = null;
        if (!(i == 1 || i == 3)) {
            if (i == 2) {
                bArr = g.RN().QR().d(bo.getLong(str, 0), str3);
            } else if (bo.amV(str)) {
                bArr = g.RN().QR().a(bo.getLong(str, 0), this.fPf, true);
            }
        }
        String str7 = "MicroMsg.NetSceneManualAuth";
        String str8 = "summerauth loginbuf len:%d content:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = bo.anv(bo.ca(bArr));
        ab.i(str7, str8, objArr);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (bo.cb(bArr)) {
            bArr = new byte[0];
        }
        hhVar.vJT = sKBuiltinBuffer_t.setBuffer(bArr);
        bah.vLJ = this.fPf;
        bah.vLW = this.fPe;
        e.pXa.a(148, com.tencent.mm.protocal.f.vxx ? 104 : 105, 1, false);
        e.pXa.a(148, com.tencent.mm.protocal.f.vxy ? 106 : 107, 1, false);
        AppMethodBeat.o(123441);
    }

    public final void tr(String str) {
        AppMethodBeat.i(123442);
        d dVar = (d) this.ftU.acF();
        dVar.vxS.wEb.vLJ = str;
        dVar.vxS.wEb.vLW = str;
        dVar.vxS.wEc.vIg.vJT = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        this.fPe = str;
        this.fPf = str;
        AppMethodBeat.o(123442);
    }

    public final int getType() {
        return com.tencent.mm.protocal.f.vxx ? 252 : 701;
    }

    public final int acn() {
        return 5;
    }

    public final b b(com.tencent.mm.network.q qVar) {
        return b.EOk;
    }

    public final void a(com.tencent.mm.ai.m.a aVar) {
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(123443);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(123443);
        return a;
    }

    public final q ajl() {
        this.fPl = true;
        return this;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(123444);
        d dVar = (d) qVar.acF();
        final j.e eVar = (j.e) qVar.ZS();
        if (eVar.vxV == null || eVar.vxV.xid == null) {
            ab.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", Integer.valueOf(eVar.vyl));
        } else {
            int i4 = eVar.vxV.xid.vHW;
            ab.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", Integer.valueOf(i4));
            g.RQ();
            g.RP().eJH.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar2 = g.RO().eJo.ftA;
            if (eVar2 != null) {
                eVar2.cI((i4 & 1) == 0);
            }
        }
        this.errType = i2;
        this.errCode = i3;
        cjj cjj = eVar.vxV;
        if (cjj == null) {
            ab.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.ehi.onSceneEnd(4, -1, "", this);
            e.pXa.a(148, 3, 1, false);
            AppMethodBeat.o(123444);
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
        ab.i(str2, str3, objArr);
        if (i2 == 0 && i3 == 0) {
            if ((i5 & 2) != 0) {
                ar arVar = cjj.xie;
                if (arVar == null || bo.isNullOrNil(arVar.jBB)) {
                    ab.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.ehi.onSceneEnd(4, -1, "", this);
                    AppMethodBeat.o(123444);
                    return;
                } else if (ax.a(qVar) == 2) {
                    e.pXa.a(148, 7, 1, false);
                    ab.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", Integer.valueOf(this.fPj));
                    this.fPj++;
                    if (this.fPj > 1) {
                        this.ehi.onSceneEnd(4, -1, "", this);
                        AppMethodBeat.o(123444);
                        return;
                    }
                    ((d) this.ftl.acF()).vxS.wEc.vIg.vJW = 1;
                    a(this.ftf, this.ehi);
                    AppMethodBeat.o(123444);
                    return;
                } else {
                    g.RS().Bn();
                    ab.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
                    aa.a(eVar.vxV, false);
                    ((PluginAuth) g.M(PluginAuth.class)).getHandleAuthResponseCallbacks().a(dVar, eVar, false);
                    if (!bo.isNullOrNil(this.account)) {
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LAST_LOGIN_USERNAME_STRING, this.account);
                        av.fly.ak("login_user_name", this.account);
                    }
                    g.RO().eJo.a(new bk(new com.tencent.mm.model.bk.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            AppMethodBeat.i(123439);
                            if (eVar == null || eVar.adg() == null || eVar.LA(1) == null || eVar.LA(2) == null || eVar.LA(3) == null || eVar.vxV == null || eVar.vxV.xid == null) {
                                e.pXa.a(148, 8, 1, false);
                                ab.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
                                AppMethodBeat.o(123439);
                                return;
                            }
                            ab.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", bo.anv(bo.ca(eVar.LA(1))), bo.anv(bo.ca(eVar.LA(2))), bo.anv(bo.ca(eVar.LA(3))), Integer.valueOf(eVar.vxV.xid.luF));
                            eVar.adg().a(eVar.LA(1), eVar.LA(2), eVar.LA(3), eVar.vxV.xid.luF);
                            AppMethodBeat.o(123439);
                        }
                    }), 0);
                    if (bo.h((Integer) g.RP().Ry().get(15, null)) != 0) {
                        ((com.tencent.mm.plugin.zero.b.b) g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().lN(10);
                    }
                    if ((cjj.xid.vHV & 8) == 0) {
                        String Yz = r.Yz();
                        if (!TextUtils.isEmpty(Yz)) {
                            g.RO().eJo.a(new m(Yz), 0);
                        }
                    } else {
                        ab.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", Integer.valueOf(cjj.xid.vHV));
                        e.pXa.a(148, 9, 1, false);
                    }
                    int i6 = 4;
                    if (dVar.vxS.wEc.vIg.vJT != null && dVar.vxS.wEc.vIg.vJT.getILen() > 0) {
                        i6 = 1;
                    } else if (dVar.vxS.wEc.wEa == 1) {
                        i6 = 2;
                    }
                    com.tencent.mm.plugin.report.b.d.u(1, i6, dVar.vxS.wEb.jBB);
                    if (i2 == 0 && i3 == 0) {
                        ab.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        jt jtVar = new jt();
                        jtVar.cER.csN = true;
                        com.tencent.mm.sdk.b.a.xxA.m(jtVar);
                    }
                    g.RS().doM();
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(123444);
                    return;
                }
            }
            ab.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
            this.ehi.onSceneEnd(4, -1, "", this);
            AppMethodBeat.o(123444);
        } else if (i2 == 4 && i3 == -301) {
            ab.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            e.pXa.a(148, 4, 1, false);
            if (cjj == null || cjj.xif == null) {
                ab.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                ax.a(true, cjj.xif.vLL, cjj.xif.vLM, cjj.xif.vLK);
            }
            this.ftx--;
            if (this.ftx <= 0) {
                ab.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(123444);
                return;
            }
            ab.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", Integer.valueOf(this.ftx));
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123444);
        } else if (!this.fPl && i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            e.pXa.a(148, 5, 1, false);
            final int i7 = qVar.acF().vyj.ver;
            ab.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i7));
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(123437);
                    new i().a(q.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(123436);
                            ab.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                q.this.a(q.this.ftf, q.this.ehi);
                                AppMethodBeat.o(123436);
                                return;
                            }
                            q.this.ehi.onSceneEnd(i, i2, "", q.this);
                            AppMethodBeat.o(123436);
                        }
                    });
                    AppMethodBeat.o(123437);
                }

                public final String toString() {
                    AppMethodBeat.i(123438);
                    String str = super.toString() + "|onGYNetEnd1";
                    AppMethodBeat.o(123438);
                    return str;
                }
            });
            AppMethodBeat.o(123444);
        } else if (i2 == 4 && (i3 == -305 || i3 == -306)) {
            long j;
            ab.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.f.vxC));
            e eVar3 = e.pXa;
            if (i3 == -305) {
                j = 108;
            } else {
                j = 109;
            }
            eVar3.a(148, j, 1, true);
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123444);
        } else if (i2 == 4 && i3 == -217) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            e.pXa.a(148, 47, 1, false);
            AppMethodBeat.o(123444);
        } else if (i2 == 4 && i3 == -218) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            e.pXa.a(148, 53, 1, false);
            AppMethodBeat.o(123444);
        } else if (i2 == 4 && i3 == -240) {
            ab.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(123444);
                return;
            }
            e.pXa.a(148, 57, 1, false);
            a(this.ftf, this.ehi);
            AppMethodBeat.o(123444);
        } else {
            ab.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", Integer.valueOf(i3), Integer.valueOf(i2), str);
            this.ehi.onSceneEnd(i2, i3, str, this);
            e.pXa.a(148, 6, 1, false);
            if (com.tencent.mm.protocal.f.vxx && i3 != ZipJNI.UNZ_ERR_OPEN_WRITE) {
                e.pXa.a(148, 110, 1, false);
            }
            AppMethodBeat.o(123444);
        }
    }

    public final String ajm() {
        AppMethodBeat.i(123445);
        String str;
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.o(123445);
            return str;
        }
        str = ((j.e) this.ftU.ZS()).vxV.xid.vHQ;
        AppMethodBeat.o(123445);
        return str;
    }

    public final String ajn() {
        AppMethodBeat.i(123446);
        String str;
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.o(123446);
            return str;
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((j.e) this.ftU.ZS()).vxV.xid.vHL != null) {
                str = bo.nullAsNil(((j.e) this.ftU.ZS()).vxV.xid.vHL.wsL);
                AppMethodBeat.o(123446);
                return str;
            }
        } else if (secCodeType == 1 && ((j.e) this.ftU.ZS()).vxV.xid.vHK != null) {
            str = bo.nullAsNil(((j.e) this.ftU.ZS()).vxV.xid.vHK.vLX);
            AppMethodBeat.o(123446);
            return str;
        }
        str = "";
        AppMethodBeat.o(123446);
        return str;
    }

    public final byte[] ajo() {
        AppMethodBeat.i(123447);
        byte[] bArr;
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            bArr = new byte[0];
            AppMethodBeat.o(123447);
            return bArr;
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((j.e) this.ftU.ZS()).vxV.xid.vHL != null) {
                bArr = com.tencent.mm.platformtools.aa.a(((j.e) this.ftU.ZS()).vxV.xid.vHL.wsO, new byte[0]);
                AppMethodBeat.o(123447);
                return bArr;
            }
        } else if (secCodeType == 1) {
            if (((j.e) this.ftU.ZS()).vxV.xid.vHK != null) {
                bArr = com.tencent.mm.platformtools.aa.a(((j.e) this.ftU.ZS()).vxV.xid.vHK.vEF, new byte[0]);
                AppMethodBeat.o(123447);
                return bArr;
            }
        } else if (secCodeType == 2 && ((d) this.ftU.acF()).vxS.wEb != null) {
            g.RN().QR().a(bo.getLong(((d) this.ftU.acF()).vxS.wEb.jBB, 0), com.tencent.mm.platformtools.aa.a(((j.e) this.ftU.ZS()).vxV.xid.vHJ));
            bArr = g.RN().QR().fs(bo.getLong(((d) this.ftU.acF()).vxS.wEb.jBB, 0));
            AppMethodBeat.o(123447);
            return bArr;
        }
        bArr = new byte[0];
        AppMethodBeat.o(123447);
        return bArr;
    }

    public final int getSecCodeType() {
        AppMethodBeat.i(123448);
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            ab.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            AppMethodBeat.o(123448);
            return 0;
        } else if (this.errType != 4) {
            ab.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", Integer.valueOf(this.errType));
            AppMethodBeat.o(123448);
            return 0;
        } else if (this.errCode == -311) {
            AppMethodBeat.o(123448);
            return 2;
        } else if (this.errCode == -6) {
            AppMethodBeat.o(123448);
            return 1;
        } else if (this.errCode == -310) {
            AppMethodBeat.o(123448);
            return 3;
        } else {
            AppMethodBeat.o(123448);
            return 0;
        }
    }

    public final String ajp() {
        AppMethodBeat.i(123449);
        String str;
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.o(123449);
            return str;
        } else if (getSecCodeType() != 1 || ((j.e) this.ftU.ZS()).vxV.xid.vHK == null) {
            str = "";
            AppMethodBeat.o(123449);
            return str;
        } else if (((j.e) this.ftU.ZS()).vxV.xid.vHK.xpA != null) {
            str = ((j.e) this.ftU.ZS()).vxV.xid.vHK.xpA;
            AppMethodBeat.o(123449);
            return str;
        } else {
            AppMethodBeat.o(123449);
            return null;
        }
    }

    public final String agh() {
        AppMethodBeat.i(123450);
        String str = ((j.e) this.ftU.ZS()).vxV.xid.vHS;
        AppMethodBeat.o(123450);
        return str;
    }

    public final String ajq() {
        AppMethodBeat.i(123451);
        String str = ((j.e) this.ftU.ZS()).vxV.xie.vCh;
        AppMethodBeat.o(123451);
        return str;
    }

    public final int ajr() {
        AppMethodBeat.i(123452);
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            AppMethodBeat.o(123452);
            return 0;
        }
        int i;
        bzr bzr = ((j.e) this.ftU.ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 11) {
                    i = bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.o(123452);
        return i;
    }

    public final BindWordingContent ajs() {
        AppMethodBeat.i(123453);
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            AppMethodBeat.o(123453);
            return null;
        }
        String str;
        BindWordingContent tp;
        bzr bzr = ((j.e) this.ftU.ZS()).vxV.xid.vHR;
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
            a aVar = new a();
            try {
                tp = a.tp(str);
            } catch (XmlPullParserException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneManualAuth", e, "", new Object[0]);
                tp = null;
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.NetSceneManualAuth", e2, "", new Object[0]);
            }
            AppMethodBeat.o(123453);
            return tp;
        }
        tp = null;
        AppMethodBeat.o(123453);
        return tp;
    }

    public final String ajt() {
        AppMethodBeat.i(123454);
        String str;
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            str = "";
            AppMethodBeat.o(123454);
            return str;
        }
        bzr bzr = ((j.e) this.ftU.ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 16) {
                    str = cfi.xeN;
                    AppMethodBeat.o(123454);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.o(123454);
        return str;
    }

    public final int aju() {
        AppMethodBeat.i(123455);
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            AppMethodBeat.o(123455);
            return 0;
        }
        int i;
        bzr bzr = ((j.e) this.ftU.ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 13) {
                    i = bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.o(123455);
        return i;
    }

    public final boolean ajv() {
        AppMethodBeat.i(123456);
        if (((j.e) this.ftU.ZS()).vxV.xid == null) {
            AppMethodBeat.o(123456);
            return true;
        }
        bzr bzr = ((j.e) this.ftU.ZS()).vxV.xid.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 18) {
                    if (bo.getInt(cfi.xeN, 0) == 1) {
                        AppMethodBeat.o(123456);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.o(123456);
        return true;
    }
}

package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.y;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class ax extends k implements c {
    private static a flT = null;
    private final int flQ;
    private final f flR;
    private final g flS;

    public interface a {
        void a(f fVar, g gVar);
    }

    public ax(int i) {
        AppMethodBeat.i(58095);
        boolean z = i == 702 || i == 701 || i == 252 || i == 763;
        Assert.assertTrue(z);
        this.flQ = i;
        if (i == 702 || i == 763) {
            this.flR = new com.tencent.mm.protocal.j.a();
            this.flS = new b();
            AppMethodBeat.o(58095);
            return;
        }
        this.flR = new d();
        this.flS = new e();
        AppMethodBeat.o(58095);
    }

    private q kD(int i) {
        AppMethodBeat.i(58096);
        ab.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i), Integer.valueOf(hashCode()), bo.dpG());
        f fVar = (f) acF();
        g gVar = this.flS;
        SharedPreferences ZQ = ay.ZQ();
        ab.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(ZQ.getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        int i2;
        if (ZQ.getInt("key_auth_update_version", 0) < com.tencent.mm.protocal.d.vxo) {
            if (this.flQ == 702 || this.flQ == 763) {
                i2 = 12;
            } else {
                i2 = 16;
            }
            fVar.vyf = i2;
            com.tencent.mm.plugin.report.e.pXa.a(148, this.flQ == 702 ? 14 : 13, 1, false);
        } else {
            if (this.flQ == 702 || this.flQ == 763) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            fVar.vyf = i2;
        }
        hh hhVar = new hh();
        hhVar.vJW = i;
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
        if (com.tencent.mm.kernel.g.RK()) {
            String pVar;
            byte[] bArr;
            com.tencent.mm.kernel.g.RQ();
            String nullAsNil = bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(2, null));
            com.tencent.mm.kernel.g.RQ();
            p pVar2 = new p(bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(9, null), 0));
            if (bo.isNullOrNil(nullAsNil)) {
                pVar = pVar2.toString();
            } else {
                pVar = nullAsNil;
            }
            com.tencent.mm.kernel.g.RQ();
            y QR = com.tencent.mm.kernel.g.RN().QR();
            long longValue = pVar2.longValue();
            String str = "";
            boolean z = this.flQ == 252 || this.flQ == 701;
            byte[] a = QR.a(longValue, str, z);
            String str2 = "MicroMsg.MMReqRespAuth";
            String str3 = "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]";
            Object[] objArr = new Object[4];
            objArr[0] = pVar;
            objArr[1] = pVar2;
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = a == null ? BuildConfig.COMMAND : bo.anv(bo.ca(a));
            ab.i(str2, str3, objArr);
            SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
            if (bo.cb(a)) {
                bArr = new byte[0];
            } else {
                bArr = a;
            }
            hhVar.vJT = sKBuiltinBuffer_t.setBuffer(bArr);
            if (this.flQ == 702 || this.flQ == 763) {
                com.tencent.mm.protocal.j.a aVar = (com.tencent.mm.protocal.j.a) fVar;
                b bVar = (b) gVar;
                ge geVar = new ge();
                gh ghVar = new gh();
                aVar.vxQ.vIo = ghVar;
                aVar.vxQ.vIp = geVar;
                nullAsNil = ZQ.getString("_auth_key", "");
                String str4 = "MicroMsg.MMReqRespAuth";
                str2 = "summerauths KEY_SP_SUFFIX keyStr[%s]";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Integer.valueOf(nullAsNil == null ? -1 : nullAsNil.length());
                ab.i(str4, str2, objArr2);
                bArr = bo.anf(nullAsNil);
                gf gfVar = new gf();
                if (bo.cb(bArr)) {
                    com.tencent.mm.plugin.report.e.pXa.a(148, 16, 1, false);
                    geVar.vHH = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                } else {
                    geVar.vHH = new SKBuiltinBuffer_t().setBuffer(bArr);
                    ab.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", Integer.valueOf(geVar.vHH.getBuffer().wR.length), Integer.valueOf(bArr.length));
                    try {
                        gfVar.parseFrom(bArr);
                    } catch (IOException e) {
                        com.tencent.mm.plugin.report.e.pXa.a(148, 15, 1, false);
                        ab.printErrStackTrace("MicroMsg.MMReqRespAuth", e, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                    }
                }
                if (gfVar.vIm != null) {
                    ghVar.vIq = gfVar.vIm;
                    ab.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", Integer.valueOf(gfVar.vIm.getBuffer().wR.length), bo.ca(gfVar.vIm.getBuffer().wR));
                } else {
                    com.tencent.mm.plugin.report.e.pXa.a(148, 17, 1, false);
                    ghVar.vIq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    ab.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
                }
                geVar.vIg = hhVar;
                aVar.username = pVar;
                bVar.gcF = pVar;
            } else {
                d dVar = (d) fVar;
                bah bah = new bah();
                baf baf = new baf();
                dVar.vxS.wEb = bah;
                dVar.vxS.wEc = baf;
                baf.wEa = 2;
                baf.vIg = hhVar;
                bah.jBB = pVar;
                com.tencent.mm.kernel.g.RQ();
                nullAsNil = bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(3, null));
                com.tencent.mm.kernel.g.RQ();
                bah.vLJ = bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(19, null));
                bah.vLW = nullAsNil;
            }
            AppMethodBeat.o(58096);
            return this;
        }
        ab.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(58096);
        return null;
    }

    public final int ZP() {
        AppMethodBeat.i(58097);
        if (com.tencent.mm.kernel.g.RK()) {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RN();
            int QF = com.tencent.mm.kernel.a.QF();
            AppMethodBeat.o(58097);
            return QF;
        }
        ab.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", bo.dpG());
        AppMethodBeat.o(58097);
        return 0;
    }

    public final q cn(int i, int i2) {
        AppMethodBeat.i(58098);
        q kD = new ax(i).kD(i2);
        AppMethodBeat.o(58098);
        return kD;
    }

    public static void a(a aVar) {
        flT = aVar;
    }

    public final void a(f fVar, g gVar, int i, int i2, String str) {
        AppMethodBeat.i(58099);
        if (com.tencent.mm.kernel.g.RK()) {
            cjj cjj = gVar.vxV;
            if (cjj == null || cjj.xid == null) {
                ab.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", Integer.valueOf(gVar.vyl));
            } else {
                int i3 = gVar.vxV.xid.vHW;
                ab.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", Integer.valueOf(i3));
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().eJH.set(47, Integer.valueOf(i3));
                com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.RO().eJo.ftA;
                if (eVar != null) {
                    eVar.cI((i3 & 1) == 0);
                }
            }
            ab.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                if (flT != null) {
                    flT.a(fVar, gVar);
                }
                AppMethodBeat.o(58099);
                return;
            } else if (i == 4 && i2 == -301) {
                com.tencent.mm.plugin.report.e.pXa.a(148, 18, 1, false);
                ab.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
                if (cjj == null || cjj.xif == null) {
                    ab.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                    AppMethodBeat.o(58099);
                    return;
                }
                a(true, gVar.vxV.xif.vLL, gVar.vxV.xif.vLM, gVar.vxV.xif.vLK);
                AppMethodBeat.o(58099);
                return;
            } else {
                com.tencent.mm.plugin.report.e.pXa.a(148, com.tencent.mm.protocal.f.vxx ? 119 : 120, 1, false);
                com.tencent.mm.plugin.report.e.pXa.a(148, com.tencent.mm.protocal.f.vxy ? 121 : 122, 1, false);
                AppMethodBeat.o(58099);
                return;
            }
        }
        ab.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
        AppMethodBeat.o(58099);
    }

    public static void a(boolean z, lm lmVar, bdu bdu, ato ato) {
        AppMethodBeat.i(58100);
        String str = "MicroMsg.MMReqRespAuth";
        String str2 = "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(lmVar == null ? -1 : lmVar.vOZ);
        objArr[2] = Integer.valueOf(lmVar == null ? -1 : lmVar.vPa);
        objArr[3] = Integer.valueOf(ato == null ? -1 : ato.jBv);
        objArr[4] = Integer.valueOf(bdu == null ? -1 : bdu.wHy);
        objArr[5] = Integer.valueOf(bdu == null ? -1 : bdu.wHz);
        objArr[6] = Integer.valueOf(bdu == null ? -1 : bdu.wHA);
        objArr[7] = bdu == null ? BuildConfig.COMMAND : bdu.wHw;
        objArr[8] = bdu == null ? BuildConfig.COMMAND : bdu.wHx;
        ab.i(str, str2, objArr);
        if (ato == null || ato.jBw == null || ato.jBw.size() <= 0) {
            ab.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bo.dpG());
            AppMethodBeat.o(58100);
        } else if (ato == null || ato.jBw == null || ato.jBw.size() <= 0) {
            ab.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bo.dpG());
            AppMethodBeat.o(58100);
        } else {
            ll llVar;
            com.tencent.mm.protocal.o.a hN;
            LinkedList linkedList = new LinkedList();
            linkedList.clear();
            if (lmVar != null) {
                Iterator it = lmVar.vPd.iterator();
                while (it.hasNext()) {
                    llVar = (ll) it.next();
                    str = "";
                    if (llVar.vOY != null) {
                        str = llVar.vOY.dlY();
                    }
                    linkedList.add(new o(llVar.type, llVar.vOX.dlY(), llVar.port, str));
                    ab.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(llVar.type), Integer.valueOf(llVar.port), llVar.vOX.dlY());
                }
            }
            str2 = o.ei(linkedList);
            LinkedList linkedList2 = new LinkedList();
            if (lmVar != null) {
                Iterator it2 = lmVar.vPc.iterator();
                while (it2.hasNext()) {
                    llVar = (ll) it2.next();
                    str = "";
                    if (llVar.vOY != null) {
                        str = llVar.vOY.dlY();
                    }
                    linkedList2.add(new o(llVar.type, llVar.vOX.dlY(), llVar.port, str));
                    ab.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(llVar.type), Integer.valueOf(llVar.port), llVar.vOX.dlY());
                }
            }
            String ei = o.ei(linkedList2);
            ab.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", ei, str2);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().eJH.set(2, str2);
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", 0);
            sharedPreferences.edit().putString("builtin_short_ips", str2).commit();
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().eJH.set(3, ei);
            if (bdu != null) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().eJH.set(6, bdu.wHw);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().eJH.set(7, bdu.wHx);
                if (bdu.wHA != 0) {
                    int i;
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.storage.y yVar = com.tencent.mm.kernel.g.RP().eJH;
                    if (bdu.wHA > 60) {
                        i = 60;
                    } else {
                        i = bdu.wHA;
                    }
                    yVar.set(35, Integer.valueOf(i));
                }
                ad.y((long) bdu.wHy, (long) bdu.wHB);
                hN = o.hN(bdu.wHw, bdu.wHx);
            } else {
                hN = null;
            }
            String str3 = "";
            String str4 = "";
            String[] strArr = new String[ato.jBw.size()];
            String[] strArr2 = new String[ato.jBw.size()];
            int[] iArr = new int[ato.jBw.size()];
            ab.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(ato.jBv));
            Iterator it3 = ato.jBw.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                atn atn = (atn) it3.next();
                ab.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", atn.wxE, atn.wxF);
                strArr[i2] = atn.wxE;
                strArr2[i2] = atn.wxF;
                iArr[i2] = atn.wxG;
                i2++;
                if (!(bo.isNullOrNil(atn.wxE) || bo.isNullOrNil(atn.wxF))) {
                    if (atn.wxE.equals("short.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().eJH.set(24, atn.wxF);
                        str4 = atn.wxF;
                    } else if (atn.wxE.equals("long.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().eJH.set(25, atn.wxF);
                        str3 = atn.wxF;
                    } else if (atn.wxE.equals("support.weixin.qq.com") && !bo.isNullOrNil(atn.wxF)) {
                        sharedPreferences.edit().putString("support.weixin.qq.com", atn.wxF).commit();
                    }
                }
            }
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.RO().eJo.ftA;
            if (strArr.length > 0 && eVar != null) {
                eVar.setHostInfo(strArr, strArr2, iArr);
            }
            if (!bo.isNullOrNil(str3)) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().eJH.set(25, str3);
            }
            if (!bo.isNullOrNil(str4)) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().eJH.set(24, str4);
            }
            if (!(eVar == null || hN == null)) {
                eVar.a(z, str2, ei, hN.vys, hN.vyt, hN.vyu, hN.vyv, str4, str3);
            }
            AppMethodBeat.o(58100);
        }
    }

    public static SharedPreferences ZQ() {
        AppMethodBeat.i(139007);
        SharedPreferences ZQ = ay.ZQ();
        AppMethodBeat.o(139007);
        return ZQ;
    }

    public final l.d ZR() {
        return this.flR;
    }

    public final l.e ZS() {
        return this.flS;
    }

    public final int getType() {
        AppMethodBeat.i(58102);
        int ZU = this.flR.ZU();
        AppMethodBeat.o(58102);
        return ZU;
    }

    public final String getUri() {
        AppMethodBeat.i(58103);
        String uri = this.flR.getUri();
        AppMethodBeat.o(58103);
        return uri;
    }

    public static int a(q qVar) {
        AppMethodBeat.i(58104);
        g gVar = (g) qVar.ZS();
        ab.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(((f) qVar.acF()).ZU()), Integer.valueOf(qVar.hashCode()), Integer.valueOf(gVar.eCX), bo.dpG());
        int i;
        if (gVar.eCX != 0) {
            ab.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(gVar.eCX));
            i = gVar.eCX;
            AppMethodBeat.o(58104);
            return i;
        }
        cjj cjj = gVar.vxV;
        int i2 = cjj.xic;
        if ((i2 & 1) != 0) {
            byte[] bArr;
            fv fvVar = cjj.xid;
            ab.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(fvVar.vHV), Integer.valueOf(fvVar.vHU));
            byte[] a = aa.a(fvVar.vHY);
            byte[] a2 = aa.a(fvVar.vHZ);
            xu xuVar = fvVar.vHF;
            byte[] a3 = aa.a(fvVar.vHG);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(xuVar.vIn.getILen());
            objArr[1] = Integer.valueOf(xuVar.wdx);
            objArr[2] = Integer.valueOf(a3 == null ? -1 : a3.length);
            objArr[3] = bo.anv(bo.ca(a3));
            objArr[4] = bo.anv(bo.ca(a));
            objArr[5] = bo.anv(bo.ca(a2));
            ab.d(str, str2, objArr);
            byte[] a4 = aa.a(xuVar.vIn);
            byte[] bArr2 = r0.vxU;
            if (bo.cb(a4)) {
                com.tencent.mm.plugin.report.e.pXa.a(148, 24, 1, false);
                ab.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                a4 = null;
            } else {
                str2 = "MicroMsg.MMReqRespAuth";
                String str3 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a4.length);
                objArr2[1] = bo.anv(bo.ca(a4));
                objArr2[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                objArr2[3] = bo.anv(bo.ca(bArr2));
                ab.d(str2, str3, objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(xuVar.wdx, a4, bArr2, pByteArray, 0);
                a4 = pByteArray.value;
                str = "MicroMsg.MMReqRespAuth";
                str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                if (a4 == null) {
                    i = -1;
                } else {
                    i = a4.length;
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = bo.anv(bo.ca(a4));
                ab.i(str, str2, objArr);
            }
            if (a4 != null) {
                bArr = a4;
            } else {
                bArr = new byte[0];
            }
            gVar.vxW = bArr;
            if ((r12 & 4) != 0) {
                ab.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (bo.cb(a4)) {
                    com.tencent.mm.plugin.report.e.pXa.a(148, 26, 1, false);
                    ab.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    gVar.b(new byte[0], a, a2);
                    gVar.eCX = 2;
                } else {
                    a4 = MMProtocalJni.aesDecrypt(a3, a4);
                    String str4 = "MicroMsg.MMReqRespAuth";
                    str = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = Integer.valueOf(a3 == null ? -1 : a3.length);
                    objArr3[1] = bo.anv(bo.ca(a3));
                    objArr3[2] = Integer.valueOf(a4 == null ? -1 : a4.length);
                    objArr3[3] = bo.anv(bo.ca(a4));
                    ab.d(str4, str, objArr3);
                    if (bo.cb(a4)) {
                        com.tencent.mm.plugin.report.e.pXa.a(148, 25, 1, false);
                        ab.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        gVar.b(new byte[0], a, a2);
                        gVar.eCX = 2;
                    } else {
                        ab.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", bo.anv(bo.ca(a4)));
                        gVar.b(a4, a, a2);
                        gVar.eCX = 1;
                    }
                }
            } else {
                com.tencent.mm.plugin.report.e.pXa.a(148, 27, 1, false);
                ab.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                gVar.b(a3, a, a2);
                gVar.eCX = 1;
            }
        } else {
            ab.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", cjj.xid);
            gVar.b(new byte[0], new byte[0], new byte[0]);
            gVar.eCX = 2;
        }
        if ((i2 & 2) != 0) {
            gVar.gcF = cjj.xie.jBB;
        } else {
            ab.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        i = gVar.eCX;
        AppMethodBeat.o(58104);
        return i;
    }
}

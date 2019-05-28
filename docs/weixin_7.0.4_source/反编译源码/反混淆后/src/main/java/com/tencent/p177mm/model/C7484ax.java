package com.tencent.p177mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1894ad;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1231y;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4824j.C4823c;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4824j.C4827a;
import com.tencent.p177mm.protocal.C4824j.C4828b;
import com.tencent.p177mm.protocal.C4824j.C4829d;
import com.tencent.p177mm.protocal.C4824j.C4830e;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4838o;
import com.tencent.p177mm.protocal.C4838o.C4837a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.C7259fv;
import com.tencent.p177mm.protocal.protobuf.C7260gf;
import com.tencent.p177mm.protocal.protobuf.C7262gh;
import com.tencent.p177mm.protocal.protobuf.C7266hh;
import com.tencent.p177mm.protocal.protobuf.C7269ll;
import com.tencent.p177mm.protocal.protobuf.C7270lm;
import com.tencent.p177mm.protocal.protobuf.C7287xu;
import com.tencent.p177mm.protocal.protobuf.C7540ge;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.atn;
import com.tencent.p177mm.protocal.protobuf.ato;
import com.tencent.p177mm.protocal.protobuf.baf;
import com.tencent.p177mm.protocal.protobuf.bah;
import com.tencent.p177mm.protocal.protobuf.bdu;
import com.tencent.p177mm.protocal.protobuf.cjj;
import com.tencent.p177mm.protocal.protobuf.csd;
import com.tencent.p177mm.protocal.protobuf.cwd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5144y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.ax */
public final class C7484ax extends C6297k implements C4823c {
    private static C1817a flT = null;
    private final int flQ;
    private final C4825f flR;
    private final C4826g flS;

    /* renamed from: com.tencent.mm.model.ax$a */
    public interface C1817a {
        /* renamed from: a */
        void mo5396a(C4825f c4825f, C4826g c4826g);
    }

    public C7484ax(int i) {
        AppMethodBeat.m2504i(58095);
        boolean z = i == 702 || i == 701 || i == 252 || i == 763;
        Assert.assertTrue(z);
        this.flQ = i;
        if (i == 702 || i == 763) {
            this.flR = new C4827a();
            this.flS = new C4828b();
            AppMethodBeat.m2505o(58095);
            return;
        }
        this.flR = new C4829d();
        this.flS = new C4830e();
        AppMethodBeat.m2505o(58095);
    }

    /* renamed from: kD */
    private C1929q m12919kD(int i) {
        AppMethodBeat.m2504i(58096);
        C4990ab.m7417i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i), Integer.valueOf(hashCode()), C5046bo.dpG());
        C4825f c4825f = (C4825f) acF();
        C4826g c4826g = this.flS;
        SharedPreferences ZQ = C1818ay.m3737ZQ();
        C4990ab.m7411d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(ZQ.getInt("key_auth_update_version", 0)), Integer.valueOf(C7243d.vxo));
        int i2;
        if (ZQ.getInt("key_auth_update_version", 0) < C7243d.vxo) {
            if (this.flQ == 702 || this.flQ == 763) {
                i2 = 12;
            } else {
                i2 = 16;
            }
            c4825f.vyf = i2;
            C7053e.pXa.mo8378a(148, this.flQ == 702 ? 14 : 13, 1, false);
        } else {
            if (this.flQ == 702 || this.flQ == 763) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            c4825f.vyf = i2;
        }
        C7266hh c7266hh = new C7266hh();
        c7266hh.vJW = i;
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
        if (C1720g.m3531RK()) {
            String c1183p;
            byte[] bArr;
            C1720g.m3537RQ();
            String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(2, null));
            C1720g.m3537RQ();
            C1183p c1183p2 = new C1183p(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(9, null), 0));
            if (C5046bo.isNullOrNil(nullAsNil)) {
                c1183p = c1183p2.toString();
            } else {
                c1183p = nullAsNil;
            }
            C1720g.m3537RQ();
            C1231y QR = C1720g.m3534RN().mo5158QR();
            long longValue = c1183p2.longValue();
            String str = "";
            boolean z = this.flQ == 252 || this.flQ == 701;
            byte[] a = QR.mo4503a(longValue, str, z);
            String str2 = "MicroMsg.MMReqRespAuth";
            String str3 = "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]";
            Object[] objArr = new Object[4];
            objArr[0] = c1183p;
            objArr[1] = c1183p2;
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = a == null ? BuildConfig.COMMAND : C5046bo.anv(C5046bo.m7539ca(a));
            C4990ab.m7417i(str2, str3, objArr);
            SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
            if (C5046bo.m7540cb(a)) {
                bArr = new byte[0];
            } else {
                bArr = a;
            }
            c7266hh.vJT = sKBuiltinBuffer_t.setBuffer(bArr);
            if (this.flQ == 702 || this.flQ == 763) {
                C4827a c4827a = (C4827a) c4825f;
                C4828b c4828b = (C4828b) c4826g;
                C7540ge c7540ge = new C7540ge();
                C7262gh c7262gh = new C7262gh();
                c4827a.vxQ.vIo = c7262gh;
                c4827a.vxQ.vIp = c7540ge;
                nullAsNil = ZQ.getString("_auth_key", "");
                String str4 = "MicroMsg.MMReqRespAuth";
                str2 = "summerauths KEY_SP_SUFFIX keyStr[%s]";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Integer.valueOf(nullAsNil == null ? -1 : nullAsNil.length());
                C4990ab.m7417i(str4, str2, objArr2);
                bArr = C5046bo.anf(nullAsNil);
                C7260gf c7260gf = new C7260gf();
                if (C5046bo.m7540cb(bArr)) {
                    C7053e.pXa.mo8378a(148, 16, 1, false);
                    c7540ge.vHH = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                } else {
                    c7540ge.vHH = new SKBuiltinBuffer_t().setBuffer(bArr);
                    C4990ab.m7417i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", Integer.valueOf(c7540ge.vHH.getBuffer().f1226wR.length), Integer.valueOf(bArr.length));
                    try {
                        c7260gf.parseFrom(bArr);
                    } catch (IOException e) {
                        C7053e.pXa.mo8378a(148, 15, 1, false);
                        C4990ab.printErrStackTrace("MicroMsg.MMReqRespAuth", e, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                    }
                }
                if (c7260gf.vIm != null) {
                    c7262gh.vIq = c7260gf.vIm;
                    C4990ab.m7421w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", Integer.valueOf(c7260gf.vIm.getBuffer().f1226wR.length), C5046bo.m7539ca(c7260gf.vIm.getBuffer().f1226wR));
                } else {
                    C7053e.pXa.mo8378a(148, 17, 1, false);
                    c7262gh.vIq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    C4990ab.m7420w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
                }
                c7540ge.vIg = c7266hh;
                c4827a.username = c1183p;
                c4828b.gcF = c1183p;
            } else {
                C4829d c4829d = (C4829d) c4825f;
                bah bah = new bah();
                baf baf = new baf();
                c4829d.vxS.wEb = bah;
                c4829d.vxS.wEc = baf;
                baf.wEa = 2;
                baf.vIg = c7266hh;
                bah.jBB = c1183p;
                C1720g.m3537RQ();
                nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(3, null));
                C1720g.m3537RQ();
                bah.vLJ = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(19, null));
                bah.vLW = nullAsNil;
            }
            AppMethodBeat.m2505o(58096);
            return this;
        }
        C4990ab.m7412e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.m2505o(58096);
        return null;
    }

    /* renamed from: ZP */
    public final int mo9983ZP() {
        AppMethodBeat.m2504i(58097);
        if (C1720g.m3531RK()) {
            C1720g.m3537RQ();
            C1720g.m3534RN();
            int QF = C1668a.m3383QF();
            AppMethodBeat.m2505o(58097);
            return QF;
        }
        C4990ab.m7413e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", C5046bo.dpG());
        AppMethodBeat.m2505o(58097);
        return 0;
    }

    /* renamed from: cn */
    public final C1929q mo9985cn(int i, int i2) {
        AppMethodBeat.m2504i(58098);
        C1929q kD = new C7484ax(i).m12919kD(i2);
        AppMethodBeat.m2505o(58098);
        return kD;
    }

    /* renamed from: a */
    public static void m12917a(C1817a c1817a) {
        flT = c1817a;
    }

    /* renamed from: a */
    public final void mo9984a(C4825f c4825f, C4826g c4826g, int i, int i2, String str) {
        AppMethodBeat.m2504i(58099);
        if (C1720g.m3531RK()) {
            cjj cjj = c4826g.vxV;
            if (cjj == null || cjj.xid == null) {
                C4990ab.m7417i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", Integer.valueOf(c4826g.vyl));
            } else {
                int i3 = c4826g.vxV.xid.vHW;
                C4990ab.m7417i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", Integer.valueOf(i3));
                C1720g.m3537RQ();
                C1720g.m3536RP().eJH.set(47, Integer.valueOf(i3));
                C1902e c1902e = C1720g.m3535RO().eJo.ftA;
                if (c1902e != null) {
                    c1902e.mo5534cI((i3 & 1) == 0);
                }
            }
            C4990ab.m7417i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                if (flT != null) {
                    flT.mo5396a(c4825f, c4826g);
                }
                AppMethodBeat.m2505o(58099);
                return;
            } else if (i == 4 && i2 == -301) {
                C7053e.pXa.mo8378a(148, 18, 1, false);
                C4990ab.m7416i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
                if (cjj == null || cjj.xif == null) {
                    C4990ab.m7420w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                    AppMethodBeat.m2505o(58099);
                    return;
                }
                C7484ax.m12918a(true, c4826g.vxV.xif.vLL, c4826g.vxV.xif.vLM, c4826g.vxV.xif.vLK);
                AppMethodBeat.m2505o(58099);
                return;
            } else {
                C7053e.pXa.mo8378a(148, C4815f.vxx ? 119 : 120, 1, false);
                C7053e.pXa.mo8378a(148, C4815f.vxy ? 121 : 122, 1, false);
                AppMethodBeat.m2505o(58099);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
        AppMethodBeat.m2505o(58099);
    }

    /* renamed from: a */
    public static void m12918a(boolean z, C7270lm c7270lm, bdu bdu, ato ato) {
        AppMethodBeat.m2504i(58100);
        String str = "MicroMsg.MMReqRespAuth";
        String str2 = "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(c7270lm == null ? -1 : c7270lm.vOZ);
        objArr[2] = Integer.valueOf(c7270lm == null ? -1 : c7270lm.vPa);
        objArr[3] = Integer.valueOf(ato == null ? -1 : ato.jBv);
        objArr[4] = Integer.valueOf(bdu == null ? -1 : bdu.wHy);
        objArr[5] = Integer.valueOf(bdu == null ? -1 : bdu.wHz);
        objArr[6] = Integer.valueOf(bdu == null ? -1 : bdu.wHA);
        objArr[7] = bdu == null ? BuildConfig.COMMAND : bdu.wHw;
        objArr[8] = bdu == null ? BuildConfig.COMMAND : bdu.wHx;
        C4990ab.m7417i(str, str2, objArr);
        if (ato == null || ato.jBw == null || ato.jBw.size() <= 0) {
            C4990ab.m7415f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", C5046bo.dpG());
            AppMethodBeat.m2505o(58100);
        } else if (ato == null || ato.jBw == null || ato.jBw.size() <= 0) {
            C4990ab.m7415f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", C5046bo.dpG());
            AppMethodBeat.m2505o(58100);
        } else {
            C7269ll c7269ll;
            C4837a hN;
            LinkedList linkedList = new LinkedList();
            linkedList.clear();
            if (c7270lm != null) {
                Iterator it = c7270lm.vPd.iterator();
                while (it.hasNext()) {
                    c7269ll = (C7269ll) it.next();
                    str = "";
                    if (c7269ll.vOY != null) {
                        str = c7269ll.vOY.dlY();
                    }
                    linkedList.add(new C4838o(c7269ll.type, c7269ll.vOX.dlY(), c7269ll.port, str));
                    C4990ab.m7411d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(c7269ll.type), Integer.valueOf(c7269ll.port), c7269ll.vOX.dlY());
                }
            }
            str2 = C4838o.m7196ei(linkedList);
            LinkedList linkedList2 = new LinkedList();
            if (c7270lm != null) {
                Iterator it2 = c7270lm.vPc.iterator();
                while (it2.hasNext()) {
                    c7269ll = (C7269ll) it2.next();
                    str = "";
                    if (c7269ll.vOY != null) {
                        str = c7269ll.vOY.dlY();
                    }
                    linkedList2.add(new C4838o(c7269ll.type, c7269ll.vOX.dlY(), c7269ll.port, str));
                    C4990ab.m7411d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(c7269ll.type), Integer.valueOf(c7269ll.port), c7269ll.vOX.dlY());
                }
            }
            String ei = C4838o.m7196ei(linkedList2);
            C4990ab.m7411d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", ei, str2);
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(2, str2);
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0);
            sharedPreferences.edit().putString("builtin_short_ips", str2).commit();
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(3, ei);
            if (bdu != null) {
                C1720g.m3537RQ();
                C1720g.m3536RP().eJH.set(6, bdu.wHw);
                C1720g.m3537RQ();
                C1720g.m3536RP().eJH.set(7, bdu.wHx);
                if (bdu.wHA != 0) {
                    int i;
                    C1720g.m3537RQ();
                    C5144y c5144y = C1720g.m3536RP().eJH;
                    if (bdu.wHA > 60) {
                        i = 60;
                    } else {
                        i = bdu.wHA;
                    }
                    c5144y.set(35, Integer.valueOf(i));
                }
                C1894ad.m4015y((long) bdu.wHy, (long) bdu.wHB);
                hN = C4838o.m7197hN(bdu.wHw, bdu.wHx);
            } else {
                hN = null;
            }
            String str3 = "";
            String str4 = "";
            String[] strArr = new String[ato.jBw.size()];
            String[] strArr2 = new String[ato.jBw.size()];
            int[] iArr = new int[ato.jBw.size()];
            C4990ab.m7411d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(ato.jBv));
            Iterator it3 = ato.jBw.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                atn atn = (atn) it3.next();
                C4990ab.m7411d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", atn.wxE, atn.wxF);
                strArr[i2] = atn.wxE;
                strArr2[i2] = atn.wxF;
                iArr[i2] = atn.wxG;
                i2++;
                if (!(C5046bo.isNullOrNil(atn.wxE) || C5046bo.isNullOrNil(atn.wxF))) {
                    if (atn.wxE.equals("short.weixin.qq.com")) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().eJH.set(24, atn.wxF);
                        str4 = atn.wxF;
                    } else if (atn.wxE.equals("long.weixin.qq.com")) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().eJH.set(25, atn.wxF);
                        str3 = atn.wxF;
                    } else if (atn.wxE.equals("support.weixin.qq.com") && !C5046bo.isNullOrNil(atn.wxF)) {
                        sharedPreferences.edit().putString("support.weixin.qq.com", atn.wxF).commit();
                    }
                }
            }
            C1720g.m3537RQ();
            C1902e c1902e = C1720g.m3535RO().eJo.ftA;
            if (strArr.length > 0 && c1902e != null) {
                c1902e.setHostInfo(strArr, strArr2, iArr);
            }
            if (!C5046bo.isNullOrNil(str3)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().eJH.set(25, str3);
            }
            if (!C5046bo.isNullOrNil(str4)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().eJH.set(24, str4);
            }
            if (!(c1902e == null || hN == null)) {
                c1902e.mo5525a(z, str2, ei, hN.vys, hN.vyt, hN.vyu, hN.vyv, str4, str3);
            }
            AppMethodBeat.m2505o(58100);
        }
    }

    /* renamed from: ZQ */
    public static SharedPreferences m12915ZQ() {
        AppMethodBeat.m2504i(139007);
        SharedPreferences ZQ = C1818ay.m3737ZQ();
        AppMethodBeat.m2505o(139007);
        return ZQ;
    }

    /* renamed from: ZR */
    public final C4834d mo14537ZR() {
        return this.flR;
    }

    /* renamed from: ZS */
    public final C4835e mo5618ZS() {
        return this.flS;
    }

    public final int getType() {
        AppMethodBeat.m2504i(58102);
        int ZU = this.flR.mo5743ZU();
        AppMethodBeat.m2505o(58102);
        return ZU;
    }

    public final String getUri() {
        AppMethodBeat.m2504i(58103);
        String uri = this.flR.getUri();
        AppMethodBeat.m2505o(58103);
        return uri;
    }

    /* renamed from: a */
    public static int m12916a(C1929q c1929q) {
        AppMethodBeat.m2504i(58104);
        C4826g c4826g = (C4826g) c1929q.mo5618ZS();
        C4990ab.m7417i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(((C4825f) c1929q.acF()).mo5743ZU()), Integer.valueOf(c1929q.hashCode()), Integer.valueOf(c4826g.eCX), C5046bo.dpG());
        int i;
        if (c4826g.eCX != 0) {
            C4990ab.m7411d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(c4826g.eCX));
            i = c4826g.eCX;
            AppMethodBeat.m2505o(58104);
            return i;
        }
        cjj cjj = c4826g.vxV;
        int i2 = cjj.xic;
        if ((i2 & 1) != 0) {
            byte[] bArr;
            C7259fv c7259fv = cjj.xid;
            C4990ab.m7417i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(c7259fv.vHV), Integer.valueOf(c7259fv.vHU));
            byte[] a = C1946aa.m4150a(c7259fv.vHY);
            byte[] a2 = C1946aa.m4150a(c7259fv.vHZ);
            C7287xu c7287xu = c7259fv.vHF;
            byte[] a3 = C1946aa.m4150a(c7259fv.vHG);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(c7287xu.vIn.getILen());
            objArr[1] = Integer.valueOf(c7287xu.wdx);
            objArr[2] = Integer.valueOf(a3 == null ? -1 : a3.length);
            objArr[3] = C5046bo.anv(C5046bo.m7539ca(a3));
            objArr[4] = C5046bo.anv(C5046bo.m7539ca(a));
            objArr[5] = C5046bo.anv(C5046bo.m7539ca(a2));
            C4990ab.m7411d(str, str2, objArr);
            byte[] a4 = C1946aa.m4150a(c7287xu.vIn);
            byte[] bArr2 = r0.vxU;
            if (C5046bo.m7540cb(a4)) {
                C7053e.pXa.mo8378a(148, 24, 1, false);
                C4990ab.m7420w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                a4 = null;
            } else {
                str2 = "MicroMsg.MMReqRespAuth";
                String str3 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a4.length);
                objArr2[1] = C5046bo.anv(C5046bo.m7539ca(a4));
                objArr2[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                objArr2[3] = C5046bo.anv(C5046bo.m7539ca(bArr2));
                C4990ab.m7411d(str2, str3, objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(c7287xu.wdx, a4, bArr2, pByteArray, 0);
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
                objArr[2] = C5046bo.anv(C5046bo.m7539ca(a4));
                C4990ab.m7417i(str, str2, objArr);
            }
            if (a4 != null) {
                bArr = a4;
            } else {
                bArr = new byte[0];
            }
            c4826g.vxW = bArr;
            if ((r12 & 4) != 0) {
                C4990ab.m7410d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (C5046bo.m7540cb(a4)) {
                    C7053e.pXa.mo8378a(148, 26, 1, false);
                    C4990ab.m7410d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    c4826g.mo9989b(new byte[0], a, a2);
                    c4826g.eCX = 2;
                } else {
                    a4 = MMProtocalJni.aesDecrypt(a3, a4);
                    String str4 = "MicroMsg.MMReqRespAuth";
                    str = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = Integer.valueOf(a3 == null ? -1 : a3.length);
                    objArr3[1] = C5046bo.anv(C5046bo.m7539ca(a3));
                    objArr3[2] = Integer.valueOf(a4 == null ? -1 : a4.length);
                    objArr3[3] = C5046bo.anv(C5046bo.m7539ca(a4));
                    C4990ab.m7411d(str4, str, objArr3);
                    if (C5046bo.m7540cb(a4)) {
                        C7053e.pXa.mo8378a(148, 25, 1, false);
                        C4990ab.m7410d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        c4826g.mo9989b(new byte[0], a, a2);
                        c4826g.eCX = 2;
                    } else {
                        C4990ab.m7411d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", C5046bo.anv(C5046bo.m7539ca(a4)));
                        c4826g.mo9989b(a4, a, a2);
                        c4826g.eCX = 1;
                    }
                }
            } else {
                C7053e.pXa.mo8378a(148, 27, 1, false);
                C4990ab.m7410d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                c4826g.mo9989b(a3, a, a2);
                c4826g.eCX = 1;
            }
        } else {
            C4990ab.m7411d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", cjj.xid);
            c4826g.mo9989b(new byte[0], new byte[0], new byte[0]);
            c4826g.eCX = 2;
        }
        if ((i2 & 2) != 0) {
            c4826g.gcF = cjj.xie.jBB;
        } else {
            C4990ab.m7410d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        i = c4826g.eCX;
        AppMethodBeat.m2505o(58104);
        return i;
    }
}

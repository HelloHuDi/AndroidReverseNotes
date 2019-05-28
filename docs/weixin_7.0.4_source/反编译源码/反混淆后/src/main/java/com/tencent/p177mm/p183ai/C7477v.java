package com.tencent.p177mm.p183ai;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.p230g.p231a.C6488hm;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4819i.C4820a;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4839r.C4841b;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.bov;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.bvv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ai.v */
public final class C7477v extends C4820a {
    private static C1221a fun;
    private static char[] fuo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private byte[] cPB;
    private C4835e fum;
    private int type;

    /* renamed from: com.tencent.mm.ai.v$a */
    public interface C1221a {
        /* renamed from: dm */
        void mo4492dm(String str);
    }

    /* renamed from: a */
    public static void m12891a(C1221a c1221a) {
        fun = c1221a;
    }

    public C7477v(C4835e c4835e, int i) {
        this.fum = c4835e;
        this.type = i;
    }

    /* renamed from: a */
    public final boolean mo9965a(int i, byte[] bArr, byte[] bArr2, long j) {
        AppMethodBeat.m2504i(58288);
        PByteArray pByteArray = new PByteArray();
        if (this.fum instanceof C4833c) {
            PByteArray pByteArray2 = new PByteArray();
            PInt pInt = new PInt(0);
            C4833c c4833c = (C4833c) this.fum;
            PInt pInt2 = new PInt(0);
            PInt pInt3 = new PInt(0);
            PInt pInt4 = new PInt(255);
            try {
                if (c4833c.dms()) {
                    int P = c4833c.mo5744P(bArr);
                    C4990ab.m7410d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                    this.fum.vyl = P;
                    if (!C5046bo.isNullOrNil(C1947ae.giC)) {
                        this.fum.vyn = C1947ae.giC;
                    }
                    AppMethodBeat.m2505o(58288);
                    return true;
                }
                int i2;
                String str = "MicroMsg.RemoteResp";
                String str2 = "summerauths jType[%s] jBuf[%s] jSession[%s], jCookieBuf[%s]";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                objArr[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                objArr[3] = pByteArray.value;
                C4990ab.m7417i(str, str2, objArr);
                boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
                str2 = "MicroMsg.RemoteResp";
                String str3 = "bufToResp unpack ret[%b], jType[%d], enType[%s], noticeid[%d], headExtFlags[%d] pr len[%s, %s]";
                Object[] objArr2 = new Object[7];
                objArr2[0] = Boolean.valueOf(unpack);
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = Integer.valueOf(pInt2.value);
                objArr2[3] = Integer.valueOf(pInt3.value);
                objArr2[4] = Integer.valueOf(pInt4.value);
                objArr2[5] = pByteArray2.value;
                if (pByteArray2.value == null) {
                    i2 = -1;
                } else {
                    i2 = pByteArray2.value.length;
                }
                objArr2[6] = Integer.valueOf(i2);
                C4990ab.m7417i(str2, str3, objArr2);
                C6488hm c6488hm;
                boolean m;
                if (unpack) {
                    this.fum.vym = pInt4.value;
                    if (!(i == 701 || i == 702 || i == 252 || i == 763 || 10001 != C1947ae.giz || C1947ae.giA <= 0)) {
                        if (C1947ae.giA == 2) {
                            C4851z.m7216O("", "", 0);
                        }
                        C1947ae.giA = 0;
                        pInt.value = -13;
                        C4990ab.m7420w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                    }
                    String str4;
                    Object[] objArr3;
                    if (pInt.value == -306) {
                        C4990ab.m7417i("MicroMsg.RemoteResp", "summerauths MM_ERR_ECDHFAIL_ROLLBACK USE_ECDH old[%s]", Boolean.valueOf(C4815f.vxx));
                        C4815f.vxx = false;
                    } else if (pInt2.value == 13) {
                        pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(bArr2, pByteArray2.value);
                        str = "MicroMsg.RemoteResp";
                        str4 = "bufToResp AES_GCM_ENCRYPT jType[%s] new pr[%s, %s]";
                        objArr3 = new Object[3];
                        objArr3[0] = Integer.valueOf(i);
                        objArr3[1] = pByteArray2.value;
                        if (pByteArray2.value == null) {
                            i2 = -1;
                        } else {
                            i2 = pByteArray2.value.length;
                        }
                        objArr3[2] = Integer.valueOf(i2);
                        C4990ab.m7417i(str, str4, objArr3);
                    } else if (pInt2.value == 12) {
                        i2 = pByteArray2.value == null ? -1 : pByteArray2.value.length;
                        if (j == 0) {
                            C4990ab.m7413e("MicroMsg.RemoteResp", "summerauths HYBRID_ECDH_ENCRYPT but req engine is 0 jType[%s]", Integer.valueOf(i));
                        }
                        pByteArray2.value = UtilsJni.HybridEcdhDecrypt(j, pByteArray2.value);
                        C4815f.m7145me(j);
                        str = "MicroMsg.RemoteResp";
                        str4 = "bufToResp HYBRID_ECDH_ENCRYPT type[%s] ret.value[%s] engine[%s] new pr[%s, %s -> %s]";
                        objArr3 = new Object[6];
                        objArr3[0] = Integer.valueOf(i);
                        objArr3[1] = Integer.valueOf(pInt.value);
                        objArr3[2] = Long.valueOf(j);
                        objArr3[3] = pByteArray2.value;
                        objArr3[4] = Integer.valueOf(i2);
                        if (pByteArray2.value == null) {
                            i2 = -1;
                        } else {
                            i2 = pByteArray2.value.length;
                        }
                        objArr3[5] = Integer.valueOf(i2);
                        C4990ab.m7417i(str, str4, objArr3);
                    }
                    if (pInt.value == -13 || pInt.value == ZipJNI.UNZ_PARAMERROR || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003 || pInt.value == -306) {
                        this.fum.vyl = pInt.value;
                        if (pInt.value == -3002) {
                            try {
                                this.fum.vyn = new String(pByteArray2.value);
                            } catch (Exception e) {
                                C4990ab.m7412e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                            }
                            C4990ab.m7417i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", Integer.valueOf(i), Integer.valueOf(pInt.value), pInt3, this.fum.vyn);
                        }
                    } else {
                        try {
                            i2 = c4833c.mo5744P(pByteArray2.value);
                            C4990ab.m7417i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d, headExtFlags:%d", Integer.valueOf(i), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(this.fum.vym));
                            this.fum.vyl = i2;
                            if (i2 == -305) {
                                C4990ab.m7417i("MicroMsg.RemoteResp", "summerauths  MM_ERR_CERT_SWITCH  old ver:%d cgi[%s]", Integer.valueOf(C4815f.vxC), Integer.valueOf(i));
                                C4815f.dmh();
                            }
                        } catch (OutOfMemoryError e2) {
                            C4990ab.m7412e("MicroMsg.RemoteResp", "fromprotobuf oom error, msg:" + e2.getMessage() + ", dump:\n" + C7477v.m12890V(pByteArray2.value));
                            this.fum.vyl = -1;
                            AppMethodBeat.m2505o(58288);
                            return true;
                        }
                    }
                    this.fum.bufferSize = (long) bArr.length;
                    this.cPB = pByteArray.value;
                    if (!C5046bo.isNullOrNil(C1947ae.giC)) {
                        this.fum.vyn = C1947ae.giC;
                    }
                    if (pInt3.value != 0) {
                        c6488hm = new C6488hm();
                        c6488hm.cCo.cCp = pInt3.value;
                        if ((i == 252 || i == 701) && this.fum.vyl == 0) {
                            C4990ab.m7417i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d] jType[%d]", Integer.valueOf(pInt3.value), Integer.valueOf(i));
                            c6488hm.cCo.cCq = true;
                        }
                        m = C4879a.xxA.mo10055m(c6488hm);
                        C4990ab.m7417i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                        pInt3.value = 0;
                    }
                    AppMethodBeat.m2505o(58288);
                    return true;
                }
                C4990ab.m7413e("MicroMsg.RemoteResp", "unpack return false jType[%d]", Integer.valueOf(i));
                if (pInt3.value != 0) {
                    c6488hm = new C6488hm();
                    c6488hm.cCo.cCp = pInt3.value;
                    m = C4879a.xxA.mo10055m(c6488hm);
                    C4990ab.m7417i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                    pInt3.value = 0;
                }
                AppMethodBeat.m2505o(58288);
                return false;
            } catch (Exception e3) {
                C4990ab.printErrStackTrace("MicroMsg.RemoteResp", e3, "from Protobuf unbuild exception, check now!", new Object[0]);
                C4990ab.m7413e("MicroMsg.RemoteResp", "exception:%s", C5046bo.m7574l(e3));
            }
        } else {
            C4990ab.m7414f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            AppMethodBeat.m2505o(58288);
            return false;
        }
    }

    /* renamed from: a */
    public static byte[] m12892a(byte[] bArr, byte[] bArr2, PInt pInt, btd btd) {
        AppMethodBeat.m2504i(58289);
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        try {
            C4990ab.m7417i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, new PInt(255))), Integer.valueOf(pInt3.value), Integer.valueOf(r7.value));
            if (pInt3.value != 0) {
                C6488hm c6488hm = new C6488hm();
                c6488hm.cCo.cCp = pInt3.value;
                boolean m = C4879a.xxA.mo10055m(c6488hm);
                C4990ab.m7417i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
            }
            if (!r1) {
                C4990ab.m7412e("MicroMsg.RemoteResp", "unpack failed.");
                AppMethodBeat.m2505o(58289);
                return null;
            } else if (pInt.value == -13 || pInt.value == ZipJNI.UNZ_PARAMERROR || pInt.value == -3001) {
                C4990ab.m7413e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                AppMethodBeat.m2505o(58289);
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    C4990ab.m7417i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(58287);
                            if (!(C5046bo.isNullOrNil(str) || C7477v.fun == null)) {
                                C7477v.fun.mo4492dm(str);
                            }
                            AppMethodBeat.m2505o(58287);
                        }
                    });
                    AppMethodBeat.m2505o(58289);
                    return null;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                C4990ab.m7417i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", Integer.valueOf(110), Integer.valueOf(pInt2.value));
                btd.parseFrom(pByteArray2.value);
                byte[] bArr3 = pByteArray2.value;
                AppMethodBeat.m2505o(58289);
                return bArr3;
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.RemoteResp", e2, "parseFrom unbuild exception, check now!", new Object[0]);
            C4990ab.m7413e("MicroMsg.RemoteResp", "exception:%s", C5046bo.m7574l(e2));
        }
    }

    public final byte[] ada() {
        return this.cPB;
    }

    public final int adw() {
        return this.fum.vym;
    }

    public final String adx() {
        return this.fum.vyn;
    }

    /* renamed from: qx */
    public final void mo9979qx(String str) {
        this.fum.vyn = str;
    }

    public final int ady() {
        return this.fum.vyl;
    }

    /* renamed from: la */
    public final void mo9978la(int i) {
        this.fum.vyl = i;
    }

    /* renamed from: jQ */
    public final byte[] mo9977jQ(int i) {
        AppMethodBeat.m2504i(58290);
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case 877:
                bArr = ((C4844b) this.fum).mo10004LA(i);
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                bArr = ((C4826g) this.fum).mo9988LA(i);
                break;
        }
        String str = "MicroMsg.RemoteResp";
        String str2 = "summerauths getSessionKey seesionKeyType[%s] [%s] [%s]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[2] = C5046bo.dpG();
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(58290);
        return bArr;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] adz() {
        byte[] toByteArray;
        AppMethodBeat.m2504i(58291);
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case 877:
                bvv bvv = ((C4844b) this.fum).vyJ.wIp;
                if (bvv != null && bvv.vHH != null) {
                    toByteArray = bvv.vHH.getBuffer().toByteArray();
                    break;
                }
                C4990ab.m7411d("MicroMsg.RemoteResp", "summerauth reg[%s] SecAuthRegKeySect is null", Integer.valueOf(this.type));
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                if (((C4826g) this.fum).vxV.xid.vHH != null) {
                    toByteArray = ((C4826g) this.fum).vxV.xid.vHH.getBuffer().toByteArray();
                    break;
                }
            default:
                toByteArray = bArr;
                break;
        }
        C4990ab.m7417i("MicroMsg.RemoteResp", "summerauths getAutoAuthKey type[%s] key[%s]", Integer.valueOf(this.type), Integer.valueOf(toByteArray.length));
        AppMethodBeat.m2505o(58291);
        return toByteArray;
    }

    public final byte[] adc() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case 877:
                return ((C4844b) this.fum).vxW;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((C4826g) this.fum).vxW;
            default:
                return bArr;
        }
    }

    public final String adA() {
        String nullAsNil;
        AppMethodBeat.m2504i(58292);
        if (this.type == 381) {
            bov bov = ((C4841b) this.fum).vyD.wnt;
            if (bov != null) {
                nullAsNil = C5046bo.nullAsNil(bov.wRs);
                AppMethodBeat.m2505o(58292);
                return nullAsNil;
            }
        }
        nullAsNil = "";
        AppMethodBeat.m2505o(58292);
        return nullAsNil;
    }

    public final String adB() {
        String nullAsNil;
        AppMethodBeat.m2504i(58293);
        if (this.type == 381) {
            bov bov = ((C4841b) this.fum).vyD.wnt;
            if (bov != null) {
                nullAsNil = C5046bo.nullAsNil(bov.wRr);
                AppMethodBeat.m2505o(58293);
                return nullAsNil;
            }
        }
        nullAsNil = "";
        AppMethodBeat.m2505o(58293);
        return nullAsNil;
    }

    public final int adC() {
        if (this.type == 381) {
            return ((C4841b) this.fum).vyD.wmw;
        }
        return 0;
    }

    /* renamed from: QF */
    public final int mo9964QF() {
        switch (this.type) {
            case 126:
            case 877:
                return ((C4844b) this.fum).vyJ.luF;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((C4826g) this.fum).vxV.xid.luF;
            default:
                return 0;
        }
    }

    public final String adD() {
        switch (this.type) {
            case 126:
            case 877:
                return ((C4844b) this.fum).vyJ.jBB;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((C4826g) this.fum).gcF;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        AppMethodBeat.m2504i(58294);
        int cmdId = this.fum.getCmdId();
        AppMethodBeat.m2505o(58294);
        return cmdId;
    }

    /* renamed from: V */
    private static String m12890V(byte[] bArr) {
        AppMethodBeat.m2504i(58295);
        if (bArr == null) {
            AppMethodBeat.m2505o(58295);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(fuo[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(fuo[bArr[i] & 15]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(58295);
        return stringBuilder2;
    }
}

package com.tencent.mm.ai;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.r;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class v extends com.tencent.mm.protocal.i.a {
    private static a fun;
    private static char[] fuo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private byte[] cPB;
    private e fum;
    private int type;

    public interface a {
        void dm(String str);
    }

    public static void a(a aVar) {
        fun = aVar;
    }

    public v(e eVar, int i) {
        this.fum = eVar;
        this.type = i;
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2, long j) {
        AppMethodBeat.i(58288);
        PByteArray pByteArray = new PByteArray();
        if (this.fum instanceof c) {
            PByteArray pByteArray2 = new PByteArray();
            PInt pInt = new PInt(0);
            c cVar = (c) this.fum;
            PInt pInt2 = new PInt(0);
            PInt pInt3 = new PInt(0);
            PInt pInt4 = new PInt(255);
            try {
                if (cVar.dms()) {
                    int P = cVar.P(bArr);
                    ab.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                    this.fum.vyl = P;
                    if (!bo.isNullOrNil(ae.giC)) {
                        this.fum.vyn = ae.giC;
                    }
                    AppMethodBeat.o(58288);
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
                ab.i(str, str2, objArr);
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
                ab.i(str2, str3, objArr2);
                hm hmVar;
                boolean m;
                if (unpack) {
                    this.fum.vym = pInt4.value;
                    if (!(i == 701 || i == 702 || i == 252 || i == 763 || 10001 != ae.giz || ae.giA <= 0)) {
                        if (ae.giA == 2) {
                            z.O("", "", 0);
                        }
                        ae.giA = 0;
                        pInt.value = -13;
                        ab.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                    }
                    String str4;
                    Object[] objArr3;
                    if (pInt.value == -306) {
                        ab.i("MicroMsg.RemoteResp", "summerauths MM_ERR_ECDHFAIL_ROLLBACK USE_ECDH old[%s]", Boolean.valueOf(f.vxx));
                        f.vxx = false;
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
                        ab.i(str, str4, objArr3);
                    } else if (pInt2.value == 12) {
                        i2 = pByteArray2.value == null ? -1 : pByteArray2.value.length;
                        if (j == 0) {
                            ab.e("MicroMsg.RemoteResp", "summerauths HYBRID_ECDH_ENCRYPT but req engine is 0 jType[%s]", Integer.valueOf(i));
                        }
                        pByteArray2.value = UtilsJni.HybridEcdhDecrypt(j, pByteArray2.value);
                        f.me(j);
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
                        ab.i(str, str4, objArr3);
                    }
                    if (pInt.value == -13 || pInt.value == ZipJNI.UNZ_PARAMERROR || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003 || pInt.value == -306) {
                        this.fum.vyl = pInt.value;
                        if (pInt.value == -3002) {
                            try {
                                this.fum.vyn = new String(pByteArray2.value);
                            } catch (Exception e) {
                                ab.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                            }
                            ab.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", Integer.valueOf(i), Integer.valueOf(pInt.value), pInt3, this.fum.vyn);
                        }
                    } else {
                        try {
                            i2 = cVar.P(pByteArray2.value);
                            ab.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d, headExtFlags:%d", Integer.valueOf(i), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(this.fum.vym));
                            this.fum.vyl = i2;
                            if (i2 == -305) {
                                ab.i("MicroMsg.RemoteResp", "summerauths  MM_ERR_CERT_SWITCH  old ver:%d cgi[%s]", Integer.valueOf(f.vxC), Integer.valueOf(i));
                                f.dmh();
                            }
                        } catch (OutOfMemoryError e2) {
                            ab.e("MicroMsg.RemoteResp", "fromprotobuf oom error, msg:" + e2.getMessage() + ", dump:\n" + V(pByteArray2.value));
                            this.fum.vyl = -1;
                            AppMethodBeat.o(58288);
                            return true;
                        }
                    }
                    this.fum.bufferSize = (long) bArr.length;
                    this.cPB = pByteArray.value;
                    if (!bo.isNullOrNil(ae.giC)) {
                        this.fum.vyn = ae.giC;
                    }
                    if (pInt3.value != 0) {
                        hmVar = new hm();
                        hmVar.cCo.cCp = pInt3.value;
                        if ((i == 252 || i == 701) && this.fum.vyl == 0) {
                            ab.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d] jType[%d]", Integer.valueOf(pInt3.value), Integer.valueOf(i));
                            hmVar.cCo.cCq = true;
                        }
                        m = com.tencent.mm.sdk.b.a.xxA.m(hmVar);
                        ab.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                        pInt3.value = 0;
                    }
                    AppMethodBeat.o(58288);
                    return true;
                }
                ab.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", Integer.valueOf(i));
                if (pInt3.value != 0) {
                    hmVar = new hm();
                    hmVar.cCo.cCp = pInt3.value;
                    m = com.tencent.mm.sdk.b.a.xxA.m(hmVar);
                    ab.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                    pInt3.value = 0;
                }
                AppMethodBeat.o(58288);
                return false;
            } catch (Exception e3) {
                ab.printErrStackTrace("MicroMsg.RemoteResp", e3, "from Protobuf unbuild exception, check now!", new Object[0]);
                ab.e("MicroMsg.RemoteResp", "exception:%s", bo.l(e3));
            }
        } else {
            ab.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            AppMethodBeat.o(58288);
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, PInt pInt, btd btd) {
        AppMethodBeat.i(58289);
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        try {
            ab.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, new PInt(255))), Integer.valueOf(pInt3.value), Integer.valueOf(r7.value));
            if (pInt3.value != 0) {
                hm hmVar = new hm();
                hmVar.cCo.cCp = pInt3.value;
                boolean m = com.tencent.mm.sdk.b.a.xxA.m(hmVar);
                ab.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
            }
            if (!r1) {
                ab.e("MicroMsg.RemoteResp", "unpack failed.");
                AppMethodBeat.o(58289);
                return null;
            } else if (pInt.value == -13 || pInt.value == ZipJNI.UNZ_PARAMERROR || pInt.value == -3001) {
                ab.e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                AppMethodBeat.o(58289);
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    ab.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(58287);
                            if (!(bo.isNullOrNil(str) || v.fun == null)) {
                                v.fun.dm(str);
                            }
                            AppMethodBeat.o(58287);
                        }
                    });
                    AppMethodBeat.o(58289);
                    return null;
                } catch (Exception e) {
                    ab.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                ab.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", Integer.valueOf(110), Integer.valueOf(pInt2.value));
                btd.parseFrom(pByteArray2.value);
                byte[] bArr3 = pByteArray2.value;
                AppMethodBeat.o(58289);
                return bArr3;
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.RemoteResp", e2, "parseFrom unbuild exception, check now!", new Object[0]);
            ab.e("MicroMsg.RemoteResp", "exception:%s", bo.l(e2));
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

    public final void qx(String str) {
        this.fum.vyn = str;
    }

    public final int ady() {
        return this.fum.vyl;
    }

    public final void la(int i) {
        this.fum.vyl = i;
    }

    public final byte[] jQ(int i) {
        AppMethodBeat.i(58290);
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case 877:
                bArr = ((b) this.fum).LA(i);
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                bArr = ((g) this.fum).LA(i);
                break;
        }
        String str = "MicroMsg.RemoteResp";
        String str2 = "summerauths getSessionKey seesionKeyType[%s] [%s] [%s]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[2] = bo.dpG();
        ab.i(str, str2, objArr);
        AppMethodBeat.o(58290);
        return bArr;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] adz() {
        byte[] toByteArray;
        AppMethodBeat.i(58291);
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case 877:
                bvv bvv = ((b) this.fum).vyJ.wIp;
                if (bvv != null && bvv.vHH != null) {
                    toByteArray = bvv.vHH.getBuffer().toByteArray();
                    break;
                }
                ab.d("MicroMsg.RemoteResp", "summerauth reg[%s] SecAuthRegKeySect is null", Integer.valueOf(this.type));
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                if (((g) this.fum).vxV.xid.vHH != null) {
                    toByteArray = ((g) this.fum).vxV.xid.vHH.getBuffer().toByteArray();
                    break;
                }
            default:
                toByteArray = bArr;
                break;
        }
        ab.i("MicroMsg.RemoteResp", "summerauths getAutoAuthKey type[%s] key[%s]", Integer.valueOf(this.type), Integer.valueOf(toByteArray.length));
        AppMethodBeat.o(58291);
        return toByteArray;
    }

    public final byte[] adc() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case 877:
                return ((b) this.fum).vxW;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((g) this.fum).vxW;
            default:
                return bArr;
        }
    }

    public final String adA() {
        String nullAsNil;
        AppMethodBeat.i(58292);
        if (this.type == 381) {
            bov bov = ((r.b) this.fum).vyD.wnt;
            if (bov != null) {
                nullAsNil = bo.nullAsNil(bov.wRs);
                AppMethodBeat.o(58292);
                return nullAsNil;
            }
        }
        nullAsNil = "";
        AppMethodBeat.o(58292);
        return nullAsNil;
    }

    public final String adB() {
        String nullAsNil;
        AppMethodBeat.i(58293);
        if (this.type == 381) {
            bov bov = ((r.b) this.fum).vyD.wnt;
            if (bov != null) {
                nullAsNil = bo.nullAsNil(bov.wRr);
                AppMethodBeat.o(58293);
                return nullAsNil;
            }
        }
        nullAsNil = "";
        AppMethodBeat.o(58293);
        return nullAsNil;
    }

    public final int adC() {
        if (this.type == 381) {
            return ((r.b) this.fum).vyD.wmw;
        }
        return 0;
    }

    public final int QF() {
        switch (this.type) {
            case 126:
            case 877:
                return ((b) this.fum).vyJ.luF;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((g) this.fum).vxV.xid.luF;
            default:
                return 0;
        }
    }

    public final String adD() {
        switch (this.type) {
            case 126:
            case 877:
                return ((b) this.fum).vyJ.jBB;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((g) this.fum).gcF;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        AppMethodBeat.i(58294);
        int cmdId = this.fum.getCmdId();
        AppMethodBeat.o(58294);
        return cmdId;
    }

    private static String V(byte[] bArr) {
        AppMethodBeat.i(58295);
        if (bArr == null) {
            AppMethodBeat.o(58295);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(fuo[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(fuo[bArr[i] & 15]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(58295);
        return stringBuilder2;
    }
}

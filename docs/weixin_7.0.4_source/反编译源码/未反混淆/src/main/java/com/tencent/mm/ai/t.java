package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.h.a;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.r;
import com.tencent.mm.protocal.v;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class t extends a {
    private static e fue;
    private d fta;
    private byte[] fuf;
    private int type;

    public static void a(e eVar) {
        fue = eVar;
    }

    public t(d dVar, int i) {
        this.fta = dVar;
        this.type = i;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, d dVar, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        AppMethodBeat.i(58264);
        if (bo.cb(bArr)) {
            String str = "MicroMsg.RemoteReq";
            String str2 = "reqToBufNoRSA session is null :%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(58264);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            b bVar = (b) dVar;
            byte[] ZT = bVar.ZT();
            if (ZT == null) {
                AppMethodBeat.o(58264);
                return false;
            } else if (bVar.dms()) {
                byteArrayOutputStream.write(ZT);
                AppMethodBeat.o(58264);
                return true;
            } else {
                z dmv = z.dmv();
                int i = 6;
                if (z) {
                    i = 7;
                }
                int i2 = 0;
                if (!(bo.cb(bArr3) || bo.cb(ZT))) {
                    i2 = MMProtocalJni.genSignature(dVar.vyb, bArr3, ZT);
                }
                if (MMProtocalJni.pack(ZT, pByteArray, bArr, 0, bArr2, dVar.vye, dVar.vyb, bVar.ZU(), dmv.ver, dmv.vyO.getBytes(), dmv.vyP.getBytes(), i2, i, bVar.dmr())) {
                    ab.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i));
                    byteArrayOutputStream.write(pByteArray.value);
                    AppMethodBeat.o(58264);
                    return true;
                }
                AppMethodBeat.o(58264);
                return false;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e.getMessage());
            ab.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
            AppMethodBeat.o(58264);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0503 A:{SYNTHETIC, Splitter:B:138:0x0503} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0345 A:{Catch:{ Exception -> 0x04d3 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int i, byte[] bArr, int i2, byte[] bArr2, byte[] bArr3, int i3, boolean z) {
        AppMethodBeat.i(58265);
        PByteArray pByteArray = new PByteArray();
        ab.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i), bo.dpG());
        if (i == 268369922) {
            try {
                this.fuf = ((b) this.fta).ZT();
                this.fta.bufferSize = (long) this.fuf.length;
                AppMethodBeat.o(58265);
                return true;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
                AppMethodBeat.o(58265);
                return false;
            }
        } else if (this.fta instanceof b) {
            try {
                b bVar = (b) this.fta;
                byte[] ZT = bVar.ZT();
                if (ZT == null) {
                    ab.f("MicroMsg.RemoteReq", "protobuf is null");
                    AppMethodBeat.o(58265);
                    return false;
                } else if (bVar.dms()) {
                    this.fuf = ZT;
                    this.fta.bufferSize = (long) this.fuf.length;
                    AppMethodBeat.o(58265);
                    return true;
                } else {
                    long j;
                    long j2 = (long) this.fta.vyb;
                    if (com.tencent.mm.sdk.a.b.dnO() && j2 == 0) {
                        j = com.tencent.mm.protocal.d.vxn;
                    } else {
                        j = j2;
                    }
                    int i4 = 6;
                    if (i == 775) {
                        i4 = 0;
                    }
                    if (z) {
                        i4 |= 1;
                    }
                    z zVar = this.fta.vyj;
                    if (i != 775 && this.fta.vyh == null && zVar.dmy() && bo.cb(bArr)) {
                        ab.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                        AppMethodBeat.o(58265);
                        return false;
                    }
                    byte[] bArr4;
                    if (zVar.dmy()) {
                        bArr4 = bArr;
                    } else {
                        bArr4 = new byte[0];
                    }
                    int i5;
                    int i6;
                    String str;
                    String str2;
                    Object[] objArr;
                    if (this.type == 381 || !f.vxx) {
                        Object obj;
                        byte[][] bArr5 = null;
                        int obj2;
                        switch (i) {
                            case 701:
                                bag bag = ((j.d) this.fta).vxS;
                                bArr5 = a(j, bag.wEb, bag.wEc);
                                obj2 = 1;
                            case 702:
                                ab.d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", Long.valueOf(j));
                                if (j == 0) {
                                    obj2 = c.a.vxR == null ? -1 : c.a.vxR.ZP();
                                    g.RQ();
                                    g.RN();
                                    ab.w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", Long.valueOf(j), Integer.valueOf(obj2), Integer.valueOf(com.tencent.mm.kernel.a.QF()));
                                    com.tencent.mm.plugin.report.e.pXa.a(148, 54, 1, true);
                                    if (obj2 != 0) {
                                        com.tencent.mm.plugin.report.e.pXa.a(148, 55, 1, true);
                                    }
                                    if (r6 != 0) {
                                        com.tencent.mm.plugin.report.e.pXa.a(148, 56, 1, true);
                                    }
                                }
                                gg ggVar = ((j.a) this.fta).vxQ;
                                bArr5 = a(j, ggVar.vIo, ggVar.vIp);
                                obj2 = 1;
                                if (obj2 == null) {
                                    if (zVar.dmy() && bo.cb(bArr4)) {
                                        AppMethodBeat.o(58265);
                                        return false;
                                    } else if (bArr5 == null) {
                                        AppMethodBeat.o(58265);
                                        return false;
                                    } else {
                                        if (i == 702) {
                                            if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.fta.vye, (int) j, bVar.ZU(), zVar.ver, bArr5[0], bArr5[1], zVar.vyO.getBytes(), zVar.vyP.getBytes(), adp(), i4, bVar.dmr())) {
                                                ab.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                                                this.fuf = pByteArray.value;
                                            }
                                        } else {
                                            if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.fta.vye, (int) j, bVar.ZU(), zVar.ver, bArr5[0], bArr5[1], zVar.vyO.getBytes(), zVar.vyP.getBytes(), adp(), i4, bVar.dmr())) {
                                                ab.d("MicroMsg.RemoteReq", "summer reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                                                this.fuf = pByteArray.value;
                                            }
                                        }
                                        this.fta.bufferSize = (long) this.fuf.length;
                                    }
                                } else if (this.fta.vyh != null) {
                                    i5 = 6;
                                    if (z) {
                                        i5 = 7;
                                    }
                                    if (this.fta.vyh.a(pByteArray, i, bArr2, bArr3, i5)) {
                                        this.fuf = pByteArray.value;
                                        this.fta.bufferSize = (long) this.fuf.length;
                                        ab.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                                    }
                                    AppMethodBeat.o(58265);
                                    return true;
                                } else {
                                    int i7;
                                    if (i != 775) {
                                        if (zVar.dmy() && bo.cb(bArr4)) {
                                            ab.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                                            AppMethodBeat.o(58265);
                                            return false;
                                        }
                                    }
                                    if (i == 775) {
                                        i7 = (i4 & -3) & -5;
                                    } else {
                                        i7 = i4;
                                    }
                                    i6 = 0;
                                    if (!(bo.cb(bArr3) || bo.cb(ZT))) {
                                        i6 = MMProtocalJni.genSignature((int) j, bArr3, ZT);
                                    }
                                    str = "MicroMsg.RemoteReq";
                                    str2 = "summerauths dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s] signature[%s]";
                                    objArr = new Object[5];
                                    objArr[0] = bArr4;
                                    objArr[1] = Integer.valueOf(i);
                                    objArr[2] = Integer.valueOf(i7);
                                    if (bArr3 == null) {
                                        obj2 = -1;
                                    } else {
                                        obj2 = bArr3.length;
                                    }
                                    objArr[3] = Integer.valueOf(obj2);
                                    objArr[4] = Integer.valueOf(i6);
                                    ab.i(str, str2, objArr);
                                    if (MMProtocalJni.pack(ZT, pByteArray, bArr4, 0, bArr2, this.fta.vye, (int) j, bVar.ZU(), zVar.ver, zVar.vyO.getBytes(), zVar.vyP.getBytes(), i6, i7, bVar.dmr())) {
                                        ab.d("MicroMsg.RemoteReq", "summerauths reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i7));
                                        this.fuf = pByteArray.value;
                                    }
                                    this.fta.bufferSize = (long) this.fuf.length;
                                }
                                AppMethodBeat.o(58265);
                                return true;
                            default:
                                obj2 = null;
                        }
                        if (obj2 == null) {
                        }
                        AppMethodBeat.o(58265);
                        return true;
                    } else if (!zVar.dmy()) {
                        ab.i("MicroMsg.RemoteReq", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", Integer.valueOf(zVar.ver), Boolean.valueOf(f.vxx), Long.valueOf(((b) this.fta).ads()));
                        ((b) this.fta).ZU();
                        j2 = f.bK(i == 763 ? ((j.a) this.fta).vxQ.vIo.vIq.getBufferToBytes() : null);
                        this.fta.vyk = j2;
                        ab.d("MicroMsg.RemoteReq", "summerauths reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", Integer.valueOf(i), Integer.valueOf(f.vxC), Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4), Boolean.valueOf(MMProtocalJni.packHybridEcdh(pByteArray, bArr2, this.fta.vye, (int) j, bVar.ZU(), f.vxC, UtilsJni.HybridEcdhEncrypt(j2, ZT), i4, bVar.dmr())));
                        this.fuf = pByteArray.value;
                        this.fta.bufferSize = (long) this.fuf.length;
                        AppMethodBeat.o(58265);
                        return r3;
                    } else if (this.fta.vyh != null) {
                        i5 = 6;
                        if (z) {
                            i5 = 7;
                        }
                        if (this.fta.vyh.a(pByteArray, i, bArr2, bArr3, i5)) {
                            this.fuf = pByteArray.value;
                            this.fta.bufferSize = (long) this.fuf.length;
                            ab.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                        }
                        AppMethodBeat.o(58265);
                        return true;
                    } else {
                        i6 = 0;
                        if (!(bo.cb(bArr3) || bo.cb(ZT))) {
                            i6 = MMProtocalJni.genSignature((int) j, bArr3, ZT);
                        }
                        str = "MicroMsg.RemoteReq";
                        str2 = "summerauths dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s] signature[%d]";
                        objArr = new Object[5];
                        objArr[0] = bArr4;
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(i4);
                        objArr[3] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                        objArr[4] = Integer.valueOf(i6);
                        ab.i(str, str2, objArr);
                        if (i2 == 13) {
                            int i8;
                            byte[] AesGcmEncryptWithCompress = UtilsJni.AesGcmEncryptWithCompress(bArr4, ZT);
                            str2 = "MicroMsg.RemoteReq";
                            String str3 = "summerauths AesGcmEncryptWithCompress jType[%s] key[%s] message[%s] buf[%s]";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(i);
                            objArr2[1] = Integer.valueOf(bArr4 == null ? -1 : bArr4.length);
                            if (ZT == null) {
                                i8 = -1;
                            } else {
                                i8 = ZT.length;
                            }
                            objArr2[2] = Integer.valueOf(i8);
                            if (AesGcmEncryptWithCompress == null) {
                                i8 = -1;
                            } else {
                                i8 = AesGcmEncryptWithCompress.length;
                            }
                            objArr2[3] = Integer.valueOf(i8);
                            ab.i(str2, str3, objArr2);
                            ZT = AesGcmEncryptWithCompress;
                        }
                        if (MMProtocalJni.pack(ZT, pByteArray, bArr4, i2, bArr2, this.fta.vye, (int) j, bVar.ZU(), zVar.ver, zVar.vyO.getBytes(), zVar.vyP.getBytes(), i6, i4, bVar.dmr())) {
                            ab.d("MicroMsg.RemoteReq", "summerauths reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                            this.fuf = pByteArray.value;
                        }
                        this.fta.bufferSize = (long) this.fuf.length;
                        AppMethodBeat.o(58265);
                        return true;
                    }
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
                ab.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
                AppMethodBeat.o(58265);
                return false;
            }
        } else {
            ab.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
            AppMethodBeat.o(58265);
            return false;
        }
    }

    public static byte[][] a(long j, com.tencent.mm.bt.a aVar, com.tencent.mm.bt.a aVar2) {
        byte[] toByteArray;
        AppMethodBeat.i(58266);
        if (j == 0) {
            ab.w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            toByteArray = aVar.toByteArray();
        } catch (IOException e) {
            ab.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", bo.l(e));
            toByteArray = null;
        }
        if (bo.cb(toByteArray)) {
            ab.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            AppMethodBeat.o(58266);
            return null;
        }
        byte[] toByteArray2;
        try {
            toByteArray2 = aVar2.toByteArray();
        } catch (IOException e2) {
            ab.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", bo.l(e2));
            toByteArray2 = null;
        }
        if (bo.cb(toByteArray2)) {
            ab.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            AppMethodBeat.o(58266);
            return null;
        }
        byte[][] bArr = new byte[][]{toByteArray, toByteArray2};
        AppMethodBeat.o(58266);
        return bArr;
    }

    public final byte[] adk() {
        return this.fuf;
    }

    public final void T(byte[] bArr) {
        d dVar = this.fta;
        if (bArr == null) {
            bArr = new byte[0];
        }
        dVar.bFT = bArr;
    }

    public final byte[] adl() {
        return this.fta.bFT;
    }

    public final void hB(int i) {
        AppMethodBeat.i(58267);
        this.fta.hB(i);
        AppMethodBeat.o(58267);
    }

    public final int QF() {
        return this.fta.vyb;
    }

    public final void kY(int i) {
        this.fta.vyc = i;
    }

    public final int getClientVersion() {
        return this.fta.vyc;
    }

    public final void qu(String str) {
        this.fta.vyd = str;
    }

    public final String adm() {
        return this.fta.vyd;
    }

    public final String adn() {
        return this.fta.vye;
    }

    public final void qv(String str) {
        this.fta.vye = str;
    }

    public final void kZ(int i) {
        this.fta.vyf = i;
    }

    public final int ado() {
        return this.fta.vyf;
    }

    public final byte[] adp() {
        AppMethodBeat.i(58268);
        ab.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        byte[] toByteArray;
        switch (this.type) {
            case 126:
                toByteArray = ((v.a) this.fta).vyI.vLz.getBuffer().toByteArray();
                AppMethodBeat.o(58268);
                return toByteArray;
            case 381:
                toByteArray = ((r.a) this.fta).vyC.vLz.getBuffer().toByteArray();
                AppMethodBeat.o(58268);
                return toByteArray;
            case 701:
                toByteArray = ((j.d) this.fta).vxS.wEb.vLz.getBuffer().toByteArray();
                AppMethodBeat.o(58268);
                return toByteArray;
            case 702:
                toByteArray = ((j.a) this.fta).vxQ.vIo.vIq.getBuffer().toByteArray();
                AppMethodBeat.o(58268);
                return toByteArray;
            default:
                if (fue != null) {
                    toByteArray = fue.a(this.fta, this.type);
                    if (toByteArray != null) {
                        AppMethodBeat.o(58268);
                        return toByteArray;
                    }
                }
                if (this.fta.vyi != null) {
                    String str = "MicroMsg.RemoteReq";
                    String str2 = "summerauths getPassKey[%s]";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.fta.vyi == null ? -1 : this.fta.vyi.length);
                    ab.d(str, str2, objArr);
                    toByteArray = this.fta.vyi;
                    AppMethodBeat.o(58268);
                    return toByteArray;
                }
                toByteArray = adl();
                AppMethodBeat.o(58268);
                return toByteArray;
        }
    }

    public final void U(byte[] bArr) {
        this.fta.vyi = bArr;
    }

    public final String getPassword() {
        switch (this.type) {
            case 126:
            case 877:
                return ((v.a) this.fta).vyI.vLJ;
            case 252:
            case 701:
                return ((j.d) this.fta).vxS.wEb.vLJ;
            default:
                return "";
        }
    }

    public final String adq() {
        switch (this.type) {
            case 252:
            case 701:
                return ((j.d) this.fta).vxS.wEb.vLW;
            default:
                return "";
        }
    }

    public final String getUserName() {
        switch (this.type) {
            case 126:
            case 877:
                return ((v.a) this.fta).vyI.jBB;
            case 252:
            case 701:
                return ((j.d) this.fta).vxS.wEb.jBB;
            case 702:
            case 763:
                return ((j.a) this.fta).username;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        AppMethodBeat.i(58269);
        int cmdId = this.fta.getCmdId();
        AppMethodBeat.o(58269);
        return cmdId;
    }

    public final boolean adr() {
        AppMethodBeat.i(58270);
        boolean adr = this.fta.adr();
        AppMethodBeat.o(58270);
        return adr;
    }

    public final long ads() {
        return this.fta.vyk;
    }
}

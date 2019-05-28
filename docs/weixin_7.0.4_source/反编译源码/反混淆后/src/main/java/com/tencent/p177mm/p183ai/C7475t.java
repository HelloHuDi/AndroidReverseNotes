package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.p591a.C4709e;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4816h.C4817a;
import com.tencent.p177mm.protocal.C4824j.C4823c.C4822a;
import com.tencent.p177mm.protocal.C4824j.C4827a;
import com.tencent.p177mm.protocal.C4824j.C4829d;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4839r.C4840a;
import com.tencent.p177mm.protocal.C4842v.C4843a;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.C7253bag;
import com.tencent.p177mm.protocal.protobuf.C7261gg;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.ai.t */
public final class C7475t extends C4817a {
    private static C4709e fue;
    private C4834d fta;
    private byte[] fuf;
    private int type;

    /* renamed from: a */
    public static void m12873a(C4709e c4709e) {
        fue = c4709e;
    }

    public C7475t(C4834d c4834d, int i) {
        this.fta = c4834d;
        this.type = i;
    }

    /* renamed from: a */
    public static boolean m12874a(byte[] bArr, byte[] bArr2, byte[] bArr3, C4834d c4834d, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        AppMethodBeat.m2504i(58264);
        if (C5046bo.m7540cb(bArr)) {
            String str = "MicroMsg.RemoteReq";
            String str2 = "reqToBufNoRSA session is null :%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(58264);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            C4832b c4832b = (C4832b) c4834d;
            byte[] ZT = c4832b.mo5742ZT();
            if (ZT == null) {
                AppMethodBeat.m2505o(58264);
                return false;
            } else if (c4832b.dms()) {
                byteArrayOutputStream.write(ZT);
                AppMethodBeat.m2505o(58264);
                return true;
            } else {
                C4851z dmv = C4851z.dmv();
                int i = 6;
                if (z) {
                    i = 7;
                }
                int i2 = 0;
                if (!(C5046bo.m7540cb(bArr3) || C5046bo.m7540cb(ZT))) {
                    i2 = MMProtocalJni.genSignature(c4834d.vyb, bArr3, ZT);
                }
                if (MMProtocalJni.pack(ZT, pByteArray, bArr, 0, bArr2, c4834d.vye, c4834d.vyb, c4832b.mo5743ZU(), dmv.ver, dmv.vyO.getBytes(), dmv.vyP.getBytes(), i2, i, c4832b.dmr())) {
                    C4990ab.m7411d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i));
                    byteArrayOutputStream.write(pByteArray.value);
                    AppMethodBeat.m2505o(58264);
                    return true;
                }
                AppMethodBeat.m2505o(58264);
                return false;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
            AppMethodBeat.m2505o(58264);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0503 A:{SYNTHETIC, Splitter:B:138:0x0503} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0345 A:{Catch:{ Exception -> 0x04d3 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo9942a(int i, byte[] bArr, int i2, byte[] bArr2, byte[] bArr3, int i3, boolean z) {
        AppMethodBeat.m2504i(58265);
        PByteArray pByteArray = new PByteArray();
        C4990ab.m7411d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i), C5046bo.dpG());
        if (i == 268369922) {
            try {
                this.fuf = ((C4832b) this.fta).mo5742ZT();
                this.fta.bufferSize = (long) this.fuf.length;
                AppMethodBeat.m2505o(58265);
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
                AppMethodBeat.m2505o(58265);
                return false;
            }
        } else if (this.fta instanceof C4832b) {
            try {
                C4832b c4832b = (C4832b) this.fta;
                byte[] ZT = c4832b.mo5742ZT();
                if (ZT == null) {
                    C4990ab.m7414f("MicroMsg.RemoteReq", "protobuf is null");
                    AppMethodBeat.m2505o(58265);
                    return false;
                } else if (c4832b.dms()) {
                    this.fuf = ZT;
                    this.fta.bufferSize = (long) this.fuf.length;
                    AppMethodBeat.m2505o(58265);
                    return true;
                } else {
                    long j;
                    long j2 = (long) this.fta.vyb;
                    if (C4872b.dnO() && j2 == 0) {
                        j = C7243d.vxn;
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
                    C4851z c4851z = this.fta.vyj;
                    if (i != 775 && this.fta.vyh == null && c4851z.dmy() && C5046bo.m7540cb(bArr)) {
                        C4990ab.m7413e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                        AppMethodBeat.m2505o(58265);
                        return false;
                    }
                    byte[] bArr4;
                    if (c4851z.dmy()) {
                        bArr4 = bArr;
                    } else {
                        bArr4 = new byte[0];
                    }
                    int i5;
                    int i6;
                    String str;
                    String str2;
                    Object[] objArr;
                    if (this.type == 381 || !C4815f.vxx) {
                        Object obj;
                        byte[][] bArr5 = null;
                        int obj2;
                        switch (i) {
                            case 701:
                                C7253bag c7253bag = ((C4829d) this.fta).vxS;
                                bArr5 = C7475t.m12875a(j, c7253bag.wEb, c7253bag.wEc);
                                obj2 = 1;
                            case 702:
                                C4990ab.m7411d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", Long.valueOf(j));
                                if (j == 0) {
                                    obj2 = C4822a.vxR == null ? -1 : C4822a.vxR.mo9983ZP();
                                    C1720g.m3537RQ();
                                    C1720g.m3534RN();
                                    C4990ab.m7421w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", Long.valueOf(j), Integer.valueOf(obj2), Integer.valueOf(C1668a.m3383QF()));
                                    C7053e.pXa.mo8378a(148, 54, 1, true);
                                    if (obj2 != 0) {
                                        C7053e.pXa.mo8378a(148, 55, 1, true);
                                    }
                                    if (r6 != 0) {
                                        C7053e.pXa.mo8378a(148, 56, 1, true);
                                    }
                                }
                                C7261gg c7261gg = ((C4827a) this.fta).vxQ;
                                bArr5 = C7475t.m12875a(j, c7261gg.vIo, c7261gg.vIp);
                                obj2 = 1;
                                if (obj2 == null) {
                                    if (c4851z.dmy() && C5046bo.m7540cb(bArr4)) {
                                        AppMethodBeat.m2505o(58265);
                                        return false;
                                    } else if (bArr5 == null) {
                                        AppMethodBeat.m2505o(58265);
                                        return false;
                                    } else {
                                        if (i == 702) {
                                            if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.fta.vye, (int) j, c4832b.mo5743ZU(), c4851z.ver, bArr5[0], bArr5[1], c4851z.vyO.getBytes(), c4851z.vyP.getBytes(), adp(), i4, c4832b.dmr())) {
                                                C4990ab.m7411d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                                                this.fuf = pByteArray.value;
                                            }
                                        } else {
                                            if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.fta.vye, (int) j, c4832b.mo5743ZU(), c4851z.ver, bArr5[0], bArr5[1], c4851z.vyO.getBytes(), c4851z.vyP.getBytes(), adp(), i4, c4832b.dmr())) {
                                                C4990ab.m7411d("MicroMsg.RemoteReq", "summer reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
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
                                    if (this.fta.vyh.mo9990a(pByteArray, i, bArr2, bArr3, i5)) {
                                        this.fuf = pByteArray.value;
                                        this.fta.bufferSize = (long) this.fuf.length;
                                        C4990ab.m7411d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                                    }
                                    AppMethodBeat.m2505o(58265);
                                    return true;
                                } else {
                                    int i7;
                                    if (i != 775) {
                                        if (c4851z.dmy() && C5046bo.m7540cb(bArr4)) {
                                            C4990ab.m7413e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                                            AppMethodBeat.m2505o(58265);
                                            return false;
                                        }
                                    }
                                    if (i == 775) {
                                        i7 = (i4 & -3) & -5;
                                    } else {
                                        i7 = i4;
                                    }
                                    i6 = 0;
                                    if (!(C5046bo.m7540cb(bArr3) || C5046bo.m7540cb(ZT))) {
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
                                    C4990ab.m7417i(str, str2, objArr);
                                    if (MMProtocalJni.pack(ZT, pByteArray, bArr4, 0, bArr2, this.fta.vye, (int) j, c4832b.mo5743ZU(), c4851z.ver, c4851z.vyO.getBytes(), c4851z.vyP.getBytes(), i6, i7, c4832b.dmr())) {
                                        C4990ab.m7411d("MicroMsg.RemoteReq", "summerauths reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i7));
                                        this.fuf = pByteArray.value;
                                    }
                                    this.fta.bufferSize = (long) this.fuf.length;
                                }
                                AppMethodBeat.m2505o(58265);
                                return true;
                            default:
                                obj2 = null;
                        }
                        if (obj2 == null) {
                        }
                        AppMethodBeat.m2505o(58265);
                        return true;
                    } else if (!c4851z.dmy()) {
                        C4990ab.m7417i("MicroMsg.RemoteReq", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", Integer.valueOf(c4851z.ver), Boolean.valueOf(C4815f.vxx), Long.valueOf(((C4832b) this.fta).ads()));
                        ((C4832b) this.fta).mo5743ZU();
                        j2 = C4815f.m7144bK(i == 763 ? ((C4827a) this.fta).vxQ.vIo.vIq.getBufferToBytes() : null);
                        this.fta.vyk = j2;
                        C4990ab.m7411d("MicroMsg.RemoteReq", "summerauths reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", Integer.valueOf(i), Integer.valueOf(C4815f.vxC), Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4), Boolean.valueOf(MMProtocalJni.packHybridEcdh(pByteArray, bArr2, this.fta.vye, (int) j, c4832b.mo5743ZU(), C4815f.vxC, UtilsJni.HybridEcdhEncrypt(j2, ZT), i4, c4832b.dmr())));
                        this.fuf = pByteArray.value;
                        this.fta.bufferSize = (long) this.fuf.length;
                        AppMethodBeat.m2505o(58265);
                        return r3;
                    } else if (this.fta.vyh != null) {
                        i5 = 6;
                        if (z) {
                            i5 = 7;
                        }
                        if (this.fta.vyh.mo9990a(pByteArray, i, bArr2, bArr3, i5)) {
                            this.fuf = pByteArray.value;
                            this.fta.bufferSize = (long) this.fuf.length;
                            C4990ab.m7411d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                        }
                        AppMethodBeat.m2505o(58265);
                        return true;
                    } else {
                        i6 = 0;
                        if (!(C5046bo.m7540cb(bArr3) || C5046bo.m7540cb(ZT))) {
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
                        C4990ab.m7417i(str, str2, objArr);
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
                            C4990ab.m7417i(str2, str3, objArr2);
                            ZT = AesGcmEncryptWithCompress;
                        }
                        if (MMProtocalJni.pack(ZT, pByteArray, bArr4, i2, bArr2, this.fta.vye, (int) j, c4832b.mo5743ZU(), c4851z.ver, c4851z.vyO.getBytes(), c4851z.vyP.getBytes(), i6, i4, c4832b.dmr())) {
                            C4990ab.m7411d("MicroMsg.RemoteReq", "summerauths reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                            this.fuf = pByteArray.value;
                        }
                        this.fta.bufferSize = (long) this.fuf.length;
                        AppMethodBeat.m2505o(58265);
                        return true;
                    }
                }
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
                AppMethodBeat.m2505o(58265);
                return false;
            }
        } else {
            C4990ab.m7414f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
            AppMethodBeat.m2505o(58265);
            return false;
        }
    }

    /* renamed from: a */
    public static byte[][] m12875a(long j, C1331a c1331a, C1331a c1331a2) {
        byte[] toByteArray;
        AppMethodBeat.m2504i(58266);
        if (j == 0) {
            C4990ab.m7420w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            toByteArray = c1331a.toByteArray();
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", C5046bo.m7574l(e));
            toByteArray = null;
        }
        if (C5046bo.m7540cb(toByteArray)) {
            C4990ab.m7412e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            AppMethodBeat.m2505o(58266);
            return null;
        }
        byte[] toByteArray2;
        try {
            toByteArray2 = c1331a2.toByteArray();
        } catch (IOException e2) {
            C4990ab.m7413e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", C5046bo.m7574l(e2));
            toByteArray2 = null;
        }
        if (C5046bo.m7540cb(toByteArray2)) {
            C4990ab.m7412e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            AppMethodBeat.m2505o(58266);
            return null;
        }
        byte[][] bArr = new byte[][]{toByteArray, toByteArray2};
        AppMethodBeat.m2505o(58266);
        return bArr;
    }

    public final byte[] adk() {
        return this.fuf;
    }

    /* renamed from: T */
    public final void mo9940T(byte[] bArr) {
        C4834d c4834d = this.fta;
        if (bArr == null) {
            bArr = new byte[0];
        }
        c4834d.bFT = bArr;
    }

    public final byte[] adl() {
        return this.fta.bFT;
    }

    /* renamed from: hB */
    public final void mo9956hB(int i) {
        AppMethodBeat.m2504i(58267);
        this.fta.mo10000hB(i);
        AppMethodBeat.m2505o(58267);
    }

    /* renamed from: QF */
    public final int mo9939QF() {
        return this.fta.vyb;
    }

    /* renamed from: kY */
    public final void mo9957kY(int i) {
        this.fta.vyc = i;
    }

    public final int getClientVersion() {
        return this.fta.vyc;
    }

    /* renamed from: qu */
    public final void mo9959qu(String str) {
        this.fta.vyd = str;
    }

    public final String adm() {
        return this.fta.vyd;
    }

    public final String adn() {
        return this.fta.vye;
    }

    /* renamed from: qv */
    public final void mo9960qv(String str) {
        this.fta.vye = str;
    }

    /* renamed from: kZ */
    public final void mo9958kZ(int i) {
        this.fta.vyf = i;
    }

    public final int ado() {
        return this.fta.vyf;
    }

    public final byte[] adp() {
        AppMethodBeat.m2504i(58268);
        C4990ab.m7411d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        byte[] toByteArray;
        switch (this.type) {
            case 126:
                toByteArray = ((C4843a) this.fta).vyI.vLz.getBuffer().toByteArray();
                AppMethodBeat.m2505o(58268);
                return toByteArray;
            case 381:
                toByteArray = ((C4840a) this.fta).vyC.vLz.getBuffer().toByteArray();
                AppMethodBeat.m2505o(58268);
                return toByteArray;
            case 701:
                toByteArray = ((C4829d) this.fta).vxS.wEb.vLz.getBuffer().toByteArray();
                AppMethodBeat.m2505o(58268);
                return toByteArray;
            case 702:
                toByteArray = ((C4827a) this.fta).vxQ.vIo.vIq.getBuffer().toByteArray();
                AppMethodBeat.m2505o(58268);
                return toByteArray;
            default:
                if (fue != null) {
                    toByteArray = fue.mo9830a(this.fta, this.type);
                    if (toByteArray != null) {
                        AppMethodBeat.m2505o(58268);
                        return toByteArray;
                    }
                }
                if (this.fta.vyi != null) {
                    String str = "MicroMsg.RemoteReq";
                    String str2 = "summerauths getPassKey[%s]";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.fta.vyi == null ? -1 : this.fta.vyi.length);
                    C4990ab.m7411d(str, str2, objArr);
                    toByteArray = this.fta.vyi;
                    AppMethodBeat.m2505o(58268);
                    return toByteArray;
                }
                toByteArray = adl();
                AppMethodBeat.m2505o(58268);
                return toByteArray;
        }
    }

    /* renamed from: U */
    public final void mo9941U(byte[] bArr) {
        this.fta.vyi = bArr;
    }

    public final String getPassword() {
        switch (this.type) {
            case 126:
            case 877:
                return ((C4843a) this.fta).vyI.vLJ;
            case 252:
            case 701:
                return ((C4829d) this.fta).vxS.wEb.vLJ;
            default:
                return "";
        }
    }

    public final String adq() {
        switch (this.type) {
            case 252:
            case 701:
                return ((C4829d) this.fta).vxS.wEb.vLW;
            default:
                return "";
        }
    }

    public final String getUserName() {
        switch (this.type) {
            case 126:
            case 877:
                return ((C4843a) this.fta).vyI.jBB;
            case 252:
            case 701:
                return ((C4829d) this.fta).vxS.wEb.jBB;
            case 702:
            case 763:
                return ((C4827a) this.fta).username;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        AppMethodBeat.m2504i(58269);
        int cmdId = this.fta.getCmdId();
        AppMethodBeat.m2505o(58269);
        return cmdId;
    }

    public final boolean adr() {
        AppMethodBeat.m2504i(58270);
        boolean adr = this.fta.adr();
        AppMethodBeat.m2505o(58270);
        return adr;
    }

    public final long ads() {
        return this.fta.vyk;
    }
}

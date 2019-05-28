package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.p183ai.C7475t;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4836l.C4831a;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C30246yl;
import com.tencent.p177mm.protocal.protobuf.C40567rr;
import com.tencent.p177mm.protocal.protobuf.C40591yk;
import com.tencent.p177mm.protocal.protobuf.C46583rq;
import com.tencent.p177mm.protocal.protobuf.C46601yj;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.protocal.q */
public final class C40596q {

    /* renamed from: com.tencent.mm.protocal.q$a */
    public static class C40597a extends C4834d implements C4832b {
        public final C40591yk vyy = new C40591yk();

        public C40597a() {
            AppMethodBeat.m2504i(79996);
            mo10000hB(0);
            this.vyy.wek = new C46601yj();
            this.vyy.wek.wei = new C46583rq();
            this.vyy.wej = new C30246yl();
            AppMethodBeat.m2505o(79996);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(79997);
            mo9995a(C4851z.dmv());
            this.vyy.wek.setBaseRequest(C4836l.m7194a(this));
            this.vyy.wej.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.vyi = this.vyy.wej.vLz.getBuffer().toByteArray();
            this.vyh = new C4831a() {
                /* renamed from: a */
                public final boolean mo9990a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                    long j;
                    AppMethodBeat.m2504i(79995);
                    C4832b c4832b = (C4832b) this;
                    long j2 = (long) this.vyb;
                    if (C4872b.dnO() && j2 == 0) {
                        j = C7243d.vxn;
                    } else {
                        j = j2;
                    }
                    C4851z c4851z = this.vyj;
                    byte[] bArr3;
                    if (i == 722) {
                        C4990ab.m7412e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
                        C40591yk c40591yk = ((C40597a) this).vyy;
                        byte[][] a = C7475t.m12875a(j, c40591yk.wej, c40591yk.wek);
                        if (a == null) {
                            AppMethodBeat.m2505o(79995);
                            return false;
                        }
                        bArr3 = a[0];
                        byte[] bArr4 = a[1];
                        if (MMProtocalJni.packHybrid(pByteArray, bArr, this.vye, (int) j, c4832b.mo5743ZU(), c4851z.ver, bArr3, bArr4, c4851z.vyO.getBytes(), c4851z.vyP.getBytes(), this.vyi, i2, ((C40597a) this).fsO)) {
                            C4990ab.m7411d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                            AppMethodBeat.m2505o(79995);
                            return true;
                        }
                    } else if (i == 784) {
                        C4990ab.m7417i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", Integer.valueOf(c4851z.ver), Boolean.valueOf(C4815f.vxx), Long.valueOf(((C4832b) this).ads()));
                        ((C4832b) this).mo5743ZU();
                        PByteArray pByteArray2 = new PByteArray();
                        byte[] ZT = ((C4832b) this).mo5742ZT();
                        if (ZT == null) {
                            C4990ab.m7414f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
                            AppMethodBeat.m2505o(79995);
                            return false;
                        }
                        long bK = C4815f.m7144bK(null);
                        this.vyk = bK;
                        bArr3 = UtilsJni.HybridEcdhEncrypt(bK, ZT);
                        C4990ab.m7411d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", Integer.valueOf(i), Integer.valueOf(C4815f.vxC), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(i2), Boolean.valueOf(MMProtocalJni.packHybridEcdh(pByteArray2, bArr, this.vye, (int) j, c4832b.mo5743ZU(), C4815f.vxC, bArr3, i2, c4832b.dmr())));
                        AppMethodBeat.m2505o(79995);
                        return MMProtocalJni.packHybridEcdh(pByteArray2, bArr, this.vye, (int) j, c4832b.mo5743ZU(), C4815f.vxC, bArr3, i2, c4832b.dmr());
                    }
                    AppMethodBeat.m2505o(79995);
                    return false;
                }
            };
            byte[] toByteArray = this.vyy.toByteArray();
            AppMethodBeat.m2505o(79997);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C4815f.vxx ? 784 : 722;
        }
    }

    /* renamed from: com.tencent.mm.protocal.q$b */
    public static class C40599b extends C4835e implements C4833c {
        public final C40567rr vyB = new C40567rr();

        public C40599b() {
            AppMethodBeat.m2504i(79998);
            AppMethodBeat.m2505o(79998);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(79999);
            this.vyB.parseFrom(bArr);
            int i = this.vyB.BaseResponse.Ret;
            AppMethodBeat.m2505o(79999);
            return i;
        }
    }
}

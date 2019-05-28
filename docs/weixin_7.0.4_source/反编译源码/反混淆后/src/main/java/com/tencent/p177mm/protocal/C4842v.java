package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C7287xu;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.beg;
import com.tencent.p177mm.protocal.protobuf.beh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.protocal.v */
public final class C4842v {

    /* renamed from: com.tencent.mm.protocal.v$a */
    public static class C4843a extends C4834d implements C4832b {
        public byte[] vxU;
        public beg vyI = new beg();

        public C4843a() {
            AppMethodBeat.m2504i(58861);
            AppMethodBeat.m2505o(58861);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            byte[] bArr;
            int i = -1;
            AppMethodBeat.m2504i(58862);
            mo9995a(C4851z.dmv());
            this.vyI.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.vyI.setBaseRequest(C4836l.m7194a(this));
            this.vyI.wHV = C5059g.xya;
            C7287xu c7287xu = new C7287xu();
            c7287xu.wdx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(c7287xu.wdx, pByteArray, pByteArray2);
            byte[] bArr2 = pByteArray.value;
            byte[] bArr3 = pByteArray2.value;
            if (bArr3 != null) {
                bArr = bArr3;
            } else {
                bArr = new byte[0];
            }
            this.vxU = bArr;
            String str = "MicroMsg.MMReg2.Req";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(c7287xu.wdx);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
            if (bArr3 != null) {
                i = bArr3.length;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = C5046bo.m7539ca(bArr2);
            objArr[5] = C5046bo.m7539ca(bArr3);
            C4990ab.m7411d(str, str2, objArr);
            c7287xu.vIn = new SKBuiltinBuffer_t().setBuffer(bArr2);
            this.vyI.vIr = c7287xu;
            bArr = this.vyI.toByteArray();
            AppMethodBeat.m2505o(58862);
            return bArr;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 126;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.protocal.v$b */
    public static class C4844b extends C4835e implements C4833c {
        public int eCX = 0;
        private byte[] gcB;
        private byte[] gcC;
        public byte[] vxW;
        private byte[] vxX;
        public beh vyJ = new beh();

        public C4844b() {
            AppMethodBeat.m2504i(58863);
            AppMethodBeat.m2505o(58863);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58864);
            this.eCX = 0;
            this.vyJ = (beh) new beh().parseFrom(bArr);
            C4836l.m7195a(this, this.vyJ.getBaseResponse());
            this.eCX = 0;
            int i = this.vyJ.getBaseResponse().Ret;
            AppMethodBeat.m2505o(58864);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }

        /* renamed from: b */
        public final void mo10005b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            AppMethodBeat.m2504i(58865);
            this.vxX = bArr;
            this.gcB = bArr2;
            this.gcC = bArr3;
            C4990ab.m7417i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", C5046bo.anv(C5046bo.m7539ca(this.vxX)), C5046bo.anv(C5046bo.m7539ca(this.gcB)), C5046bo.anv(C5046bo.m7539ca(this.gcC)));
            AppMethodBeat.m2505o(58865);
        }

        /* renamed from: LA */
        public final byte[] mo10004LA(int i) {
            byte[] bArr = new byte[0];
            switch (i) {
                case 1:
                    return this.vxX;
                case 2:
                    return this.gcB;
                case 3:
                    return this.gcC;
                default:
                    return bArr;
            }
        }
    }
}

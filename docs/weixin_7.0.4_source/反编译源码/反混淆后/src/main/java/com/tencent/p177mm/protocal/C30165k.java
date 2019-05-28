package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C15344gq;
import com.tencent.p177mm.protocal.protobuf.C23394gs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.protocal.k */
public final class C30165k {

    /* renamed from: com.tencent.mm.protocal.k$a */
    public static class C30164a extends C4834d implements C4832b {
        public C15344gq vxY = new C15344gq();
        public byte[] vxZ;

        public C30164a() {
            AppMethodBeat.m2504i(28276);
            AppMethodBeat.m2505o(28276);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(28277);
            this.vxY.setBaseRequest(C4836l.m7194a(this));
            C4990ab.m7411d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", this.vxZ, Integer.valueOf(this.vxY.vIN), this.vxY.vIO, this.vxY.vIP, this.vxY.vIQ, Integer.valueOf(this.vxY.Scene), Long.valueOf(this.vxY.jBP), this.vxY.vIR, this.vxY.vIS);
            byte[] toByteArray = this.vxY.toByteArray();
            AppMethodBeat.m2505o(28277);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 1000;
        }

        public final int getCmdId() {
            return 1000;
        }
    }

    /* renamed from: com.tencent.mm.protocal.k$b */
    public static class C30166b extends C4835e implements C4833c {
        public C23394gs vya = new C23394gs();

        public C30166b() {
            AppMethodBeat.m2504i(28278);
            AppMethodBeat.m2505o(28278);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(28279);
            this.vya = (C23394gs) new C23394gs().parseFrom(bArr);
            C4990ab.m7411d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", Integer.valueOf(this.vya.Ret), this.vya.vIT, this.vya.vIU);
            int i = this.vya.Ret;
            AppMethodBeat.m2505o(28279);
            return i;
        }

        public final int getCmdId() {
            return 1000;
        }
    }
}

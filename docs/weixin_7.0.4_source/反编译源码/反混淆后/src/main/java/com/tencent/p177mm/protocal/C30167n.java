package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C35927jp;
import com.tencent.p177mm.protocal.protobuf.C40535jo;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.protocal.n */
public final class C30167n {

    /* renamed from: com.tencent.mm.protocal.n$a */
    public static class C7244a extends C4834d implements C4832b {
        public C40535jo vyq = new C40535jo();

        public C7244a() {
            AppMethodBeat.m2504i(123502);
            AppMethodBeat.m2505o(123502);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(123503);
            mo9995a(C4851z.dmv());
            this.vyq.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.vyq.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.vyq.toByteArray();
            AppMethodBeat.m2505o(123503);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 145;
        }
    }

    /* renamed from: com.tencent.mm.protocal.n$b */
    public static class C7245b extends C4835e implements C4833c {
        public C35927jp vyr = new C35927jp();

        public C7245b() {
            AppMethodBeat.m2504i(123504);
            AppMethodBeat.m2505o(123504);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(123505);
            this.vyr = (C35927jp) new C35927jp().parseFrom(bArr);
            C4836l.m7195a(this, this.vyr.getBaseResponse());
            int i = this.vyr.getBaseResponse().Ret;
            AppMethodBeat.m2505o(123505);
            return i;
        }
    }
}

package com.tencent.p177mm.plugin.soter.p527b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42466ag;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ckb;
import com.tencent.p177mm.protocal.protobuf.ckc;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.soter.b.c */
public final class C4101c {

    /* renamed from: com.tencent.mm.plugin.soter.b.c$a */
    public static class C4102a extends C4834d implements C4832b {
        public ckb rNE = new ckb();

        public C4102a() {
            AppMethodBeat.m2504i(59298);
            AppMethodBeat.m2505o(59298);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(59299);
            mo9995a(C4851z.dmv());
            this.rNE.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.rNE.setBaseRequest(C4836l.m7194a(this));
            this.vyi = this.rNE.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.rNE.toByteArray();
            AppMethodBeat.m2505o(59299);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C42466ag.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.b.c$b */
    public static class C4103b extends C4835e implements C4833c {
        public ckc rNF = new ckc();

        public C4103b() {
            AppMethodBeat.m2504i(59300);
            AppMethodBeat.m2505o(59300);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(59301);
            this.rNF = (ckc) new ckc().parseFrom(bArr);
            C4836l.m7195a(this, this.rNF.getBaseResponse());
            int i = this.rNF.getBaseResponse().Ret;
            AppMethodBeat.m2505o(59301);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

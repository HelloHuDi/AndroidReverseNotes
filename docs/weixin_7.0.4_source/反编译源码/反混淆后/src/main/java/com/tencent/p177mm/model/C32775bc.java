package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cnm;
import com.tencent.p177mm.protocal.protobuf.cnn;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.model.bc */
public final class C32775bc {

    /* renamed from: com.tencent.mm.model.bc$b */
    public static class C6666b extends C4835e implements C4833c {
        public cnn fmb = new cnn();

        public C6666b() {
            AppMethodBeat.m2504i(16325);
            AppMethodBeat.m2505o(16325);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(16326);
            this.fmb = (cnn) new cnn().parseFrom(bArr);
            C4836l.m7195a(this, this.fmb.getBaseResponse());
            int i = this.fmb.getBaseResponse().Ret;
            AppMethodBeat.m2505o(16326);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.model.bc$a */
    public static class C18618a extends C4834d implements C4832b {
        public cnm fma = new cnm();

        public C18618a() {
            AppMethodBeat.m2504i(16323);
            AppMethodBeat.m2505o(16323);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(16324);
            mo9995a(C4851z.dmv());
            this.fma.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.fma.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.fma.toByteArray();
            AppMethodBeat.m2505o(16324);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C38271be.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

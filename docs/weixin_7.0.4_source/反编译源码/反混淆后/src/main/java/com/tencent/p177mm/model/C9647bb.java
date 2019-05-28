package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.aqf;
import com.tencent.p177mm.protocal.protobuf.aqg;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.model.bb */
public final class C9647bb {

    /* renamed from: com.tencent.mm.model.bb$a */
    public static class C9648a extends C4834d implements C4832b {
        public aqf flY = new aqf();

        public C9648a() {
            AppMethodBeat.m2504i(16319);
            AppMethodBeat.m2505o(16319);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(16320);
            mo9995a(C4851z.dmv());
            this.flY.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.flY.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.flY.toByteArray();
            AppMethodBeat.m2505o(16320);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C45579bb.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.model.bb$b */
    public static class C9649b extends C4835e implements C4833c {
        public aqg flZ = new aqg();

        public C9649b() {
            AppMethodBeat.m2504i(16321);
            AppMethodBeat.m2505o(16321);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(16322);
            this.flZ = (aqg) new aqg().parseFrom(bArr);
            C4836l.m7195a(this, this.flZ.getBaseResponse());
            int i = this.flZ.getBaseResponse().Ret;
            AppMethodBeat.m2505o(16322);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

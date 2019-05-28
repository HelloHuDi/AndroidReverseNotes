package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.aqb;
import com.tencent.p177mm.protocal.protobuf.aqc;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.model.ba */
public final class C18615ba {

    /* renamed from: com.tencent.mm.model.ba$a */
    public static class C18616a extends C4834d implements C4832b {
        public aqb flW = new aqb();

        public C18616a() {
            AppMethodBeat.m2504i(16315);
            AppMethodBeat.m2505o(16315);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(16316);
            mo9995a(C4851z.dmv());
            this.flW.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.flW.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.flW.toByteArray();
            AppMethodBeat.m2505o(16316);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C45580bd.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.model.ba$b */
    public static class C18617b extends C4835e implements C4833c {
        public aqc flX = new aqc();

        public C18617b() {
            AppMethodBeat.m2504i(16317);
            AppMethodBeat.m2505o(16317);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(16318);
            this.flX = (aqc) new aqc().parseFrom(bArr);
            C4836l.m7195a(this, this.flX.getBaseResponse());
            int i = this.flX.getBaseResponse().Ret;
            AppMethodBeat.m2505o(16318);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

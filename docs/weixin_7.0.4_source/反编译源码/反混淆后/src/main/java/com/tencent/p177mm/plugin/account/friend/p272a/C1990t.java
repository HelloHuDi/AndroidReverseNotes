package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.aoq;
import com.tencent.p177mm.protocal.protobuf.aor;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.plugin.account.friend.a.t */
public final class C1990t {

    /* renamed from: com.tencent.mm.plugin.account.friend.a.t$a */
    public static class C1991a extends C4834d implements C4832b {
        public aoq gvI = new aoq();

        public C1991a() {
            AppMethodBeat.m2504i(108412);
            AppMethodBeat.m2505o(108412);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(108413);
            mo9995a(C4851z.dmv());
            this.gvI.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.gvI.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.gvI.toByteArray();
            AppMethodBeat.m2505o(108413);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return v2helper.EMethodSetIosMicAbCheckOff;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.a.t$b */
    public static class C1992b extends C4835e implements C4833c {
        public aor gvJ = new aor();

        public C1992b() {
            AppMethodBeat.m2504i(108414);
            AppMethodBeat.m2505o(108414);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(108415);
            this.gvJ = (aor) new aor().parseFrom(bArr);
            C4836l.m7195a(this, this.gvJ.getBaseResponse());
            int i = this.gvJ.getBaseResponse().Ret;
            AppMethodBeat.m2505o(108415);
            return i;
        }
    }
}

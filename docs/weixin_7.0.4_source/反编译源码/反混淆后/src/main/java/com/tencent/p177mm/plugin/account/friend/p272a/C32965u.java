package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.apy;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.a.u */
public final class C32965u {

    /* renamed from: com.tencent.mm.plugin.account.friend.a.u$a */
    public static class C32966a extends C4834d implements C4832b {
        public apy gvK = new apy();

        public C32966a() {
            AppMethodBeat.m2504i(108416);
            AppMethodBeat.m2505o(108416);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(108417);
            mo9995a(C4851z.dmx());
            this.gvK.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.gvK.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.gvK.toByteArray();
            AppMethodBeat.m2505o(108417);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 107;
        }

        public final int getCmdId() {
            return 48;
        }
    }
}

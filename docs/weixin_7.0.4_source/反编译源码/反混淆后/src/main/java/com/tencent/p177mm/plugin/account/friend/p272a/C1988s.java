package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ano;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.a.s */
public final class C1988s {

    /* renamed from: com.tencent.mm.plugin.account.friend.a.s$a */
    public static class C1989a extends C4834d implements C4832b {
        public ano gvH = new ano();

        public C1989a() {
            AppMethodBeat.m2504i(108410);
            AppMethodBeat.m2505o(108410);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(108411);
            mo9995a(C4851z.dmx());
            this.gvH.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.gvH.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.gvH.toByteArray();
            AppMethodBeat.m2505o(108411);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 572;
        }
    }
}

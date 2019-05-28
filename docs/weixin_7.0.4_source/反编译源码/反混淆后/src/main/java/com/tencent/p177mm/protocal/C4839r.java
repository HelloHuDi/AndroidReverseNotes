package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.agx;
import com.tencent.p177mm.protocal.protobuf.agy;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.protocal.r */
public final class C4839r {

    /* renamed from: com.tencent.mm.protocal.r$a */
    public static class C4840a extends C4834d implements C4832b {
        public agx vyC = new agx();

        public C4840a() {
            AppMethodBeat.m2504i(58848);
            AppMethodBeat.m2505o(58848);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(58849);
            mo9995a(C4851z.dmx());
            this.vyC.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.vyC.wns = C4851z.dmv().ver;
            this.vyC.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.vyC.toByteArray();
            AppMethodBeat.m2505o(58849);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 381;
        }

        public final int getCmdId() {
            return 179;
        }
    }

    /* renamed from: com.tencent.mm.protocal.r$b */
    public static class C4841b extends C4835e implements C4833c {
        public agy vyD = new agy();

        public C4841b() {
            AppMethodBeat.m2504i(58850);
            AppMethodBeat.m2505o(58850);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58851);
            this.vyD = (agy) new agy().parseFrom(bArr);
            C4836l.m7195a(this, this.vyD.getBaseResponse());
            int i = this.vyD.getBaseResponse().Ret;
            AppMethodBeat.m2505o(58851);
            return i;
        }

        public final int getCmdId() {
            return 1000000179;
        }
    }
}

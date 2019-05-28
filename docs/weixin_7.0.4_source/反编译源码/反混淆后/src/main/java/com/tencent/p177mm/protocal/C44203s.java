package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.beb;
import com.tencent.p177mm.protocal.protobuf.bec;

/* renamed from: com.tencent.mm.protocal.s */
public final class C44203s {

    /* renamed from: com.tencent.mm.protocal.s$a */
    public static class C15405a extends C4834d implements C4832b {
        public beb vyE = new beb();

        public C15405a() {
            AppMethodBeat.m2504i(58852);
            AppMethodBeat.m2505o(58852);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(58853);
            this.vyE.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.vyE.toByteArray();
            AppMethodBeat.m2505o(58853);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C33333a.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 27;
        }
    }

    /* renamed from: com.tencent.mm.protocal.s$b */
    public static class C30255b extends C4835e implements C4833c {
        public bec vyF = new bec();

        public C30255b() {
            AppMethodBeat.m2504i(58854);
            AppMethodBeat.m2505o(58854);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58855);
            this.vyF = (bec) new bec().parseFrom(bArr);
            C4836l.m7195a(this, this.vyF.getBaseResponse());
            int i = this.vyF.getBaseResponse().Ret;
            AppMethodBeat.m2505o(58855);
            return i;
        }

        public final int getCmdId() {
            return 1000000027;
        }
    }
}

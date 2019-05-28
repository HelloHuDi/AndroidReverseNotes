package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42475m;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.C40587xv;
import com.tencent.p177mm.protocal.protobuf.C46598xw;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.a.r */
public final class C1985r {

    /* renamed from: com.tencent.mm.plugin.account.friend.a.r$a */
    public static class C1986a extends C4834d implements C4832b {
        public C40587xv gvF = new C40587xv();

        public C1986a() {
            AppMethodBeat.m2504i(108406);
            AppMethodBeat.m2505o(108406);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(108407);
            mo9995a(C4851z.dmx());
            this.gvF.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.gvF.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.gvF.toByteArray();
            AppMethodBeat.m2505o(108407);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C42475m.CTRL_INDEX;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.a.r$b */
    public static class C1987b extends C4835e implements C4833c {
        public C46598xw gvG = new C46598xw();

        public C1987b() {
            AppMethodBeat.m2504i(108408);
            AppMethodBeat.m2505o(108408);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(108409);
            this.gvG = (C46598xw) new C46598xw().parseFrom(bArr);
            C4836l.m7195a(this, this.gvG.getBaseResponse());
            int i = this.gvG.getBaseResponse().Ret;
            AppMethodBeat.m2505o(108409);
            return i;
        }
    }
}

package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cms;
import com.tencent.p177mm.protocal.protobuf.cmt;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.b.k */
public final class C43029k {

    /* renamed from: com.tencent.mm.plugin.facedetect.b.k$b */
    public static class C27917b extends C4835e implements C4833c {
        public cmt lSE = new cmt();

        public C27917b() {
            AppMethodBeat.m2504i(76);
            AppMethodBeat.m2505o(76);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(77);
            this.lSE = (cmt) new cmt().parseFrom(bArr);
            C4836l.m7195a(this, this.lSE.getBaseResponse());
            int i = this.lSE.getBaseResponse().Ret;
            AppMethodBeat.m2505o(77);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.b.k$a */
    public static class C39008a extends C4834d implements C4832b {
        public cms lSD = new cms();

        public C39008a() {
            AppMethodBeat.m2504i(74);
            AppMethodBeat.m2505o(74);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(75);
            mo9995a(C4851z.dmv());
            this.lSD.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.lSD.setBaseRequest(C4836l.m7194a(this));
            this.vyi = this.lSD.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.lSD.toByteArray();
            AppMethodBeat.m2505o(75);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 930;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

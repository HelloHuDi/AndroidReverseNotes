package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bqx;
import com.tencent.p177mm.protocal.protobuf.bqy;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.b.j */
public final class C43028j {

    /* renamed from: com.tencent.mm.plugin.facedetect.b.j$a */
    public static class C43026a extends C4834d implements C4832b {
        public bqx lSB = new bqx();

        public C43026a() {
            AppMethodBeat.m2504i(70);
            AppMethodBeat.m2505o(70);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(71);
            mo9995a(C4851z.dmv());
            this.lSB.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.lSB.setBaseRequest(C4836l.m7194a(this));
            this.vyi = this.lSB.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.lSB.toByteArray();
            AppMethodBeat.m2505o(71);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 931;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.b.j$b */
    public static class C43027b extends C4835e implements C4833c {
        public bqy lSC = new bqy();

        public C43027b() {
            AppMethodBeat.m2504i(72);
            AppMethodBeat.m2505o(72);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(73);
            this.lSC = (bqy) new bqy().parseFrom(bArr);
            C4836l.m7195a(this, this.lSC.getBaseResponse());
            int i = this.lSC.getBaseResponse().Ret;
            AppMethodBeat.m2505o(73);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

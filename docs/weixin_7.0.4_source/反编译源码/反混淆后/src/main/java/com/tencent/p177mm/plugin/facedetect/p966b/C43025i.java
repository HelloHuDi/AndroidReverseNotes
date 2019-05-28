package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.afj;
import com.tencent.p177mm.protocal.protobuf.afk;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.b.i */
public final class C43025i {

    /* renamed from: com.tencent.mm.plugin.facedetect.b.i$a */
    public static class C20626a extends C4834d implements C4832b {
        public afj lSz = new afj();

        public C20626a() {
            AppMethodBeat.m2504i(66);
            AppMethodBeat.m2505o(66);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(67);
            mo9995a(C4851z.dmv());
            this.lSz.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.lSz.setBaseRequest(C4836l.m7194a(this));
            this.vyi = this.lSz.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.lSz.toByteArray();
            AppMethodBeat.m2505o(67);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 733;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.b.i$b */
    public static class C43024b extends C4835e implements C4833c {
        public afk lSA = new afk();

        public C43024b() {
            AppMethodBeat.m2504i(68);
            AppMethodBeat.m2505o(68);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(69);
            this.lSA = (afk) new afk().parseFrom(bArr);
            C4836l.m7195a(this, this.lSA.getBaseResponse());
            int i = this.lSA.getBaseResponse().Ret;
            AppMethodBeat.m2505o(69);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

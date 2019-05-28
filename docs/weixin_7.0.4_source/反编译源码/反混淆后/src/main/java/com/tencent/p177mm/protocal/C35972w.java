package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.bwd;
import com.tencent.p177mm.protocal.protobuf.bwe;
import org.xwalk.core.XWalkCoreWrapper;

/* renamed from: com.tencent.mm.protocal.w */
public final class C35972w {

    /* renamed from: com.tencent.mm.protocal.w$a */
    public static class C23477a extends C4834d implements C4832b {
        public bwd vyK = new bwd();

        public C23477a() {
            AppMethodBeat.m2504i(80000);
            AppMethodBeat.m2505o(80000);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED);
            this.vyK.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.vyK.toByteArray();
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED);
            return toByteArray;
        }

        public final int getCmdId() {
            return 42;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 131;
        }
    }

    /* renamed from: com.tencent.mm.protocal.w$b */
    public static class C30257b extends C4835e implements C4833c {
        public bwe vyL = new bwe();

        public C30257b() {
            AppMethodBeat.m2504i(80002);
            AppMethodBeat.m2505o(80002);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_HAS_FEATURE);
            this.vyL = (bwe) new bwe().parseFrom(bArr);
            C4836l.m7195a(this, this.vyL.getBaseResponse());
            int i = this.vyL.getBaseResponse().Ret;
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_HAS_FEATURE);
            return i;
        }
    }
}

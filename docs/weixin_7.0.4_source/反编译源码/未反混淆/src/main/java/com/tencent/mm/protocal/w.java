package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.bwe;
import org.xwalk.core.XWalkCoreWrapper;

public final class w {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public bwd vyK = new bwd();

        public a() {
            AppMethodBeat.i(80000);
            AppMethodBeat.o(80000);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED);
            this.vyK.setBaseRequest(l.a(this));
            byte[] toByteArray = this.vyK.toByteArray();
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED);
            return toByteArray;
        }

        public final int getCmdId() {
            return 42;
        }

        public final int ZU() {
            return 131;
        }
    }

    public static class b extends e implements c {
        public bwe vyL = new bwe();

        public b() {
            AppMethodBeat.i(80002);
            AppMethodBeat.o(80002);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_HAS_FEATURE);
            this.vyL = (bwe) new bwe().parseFrom(bArr);
            l.a(this, this.vyL.getBaseResponse());
            int i = this.vyL.getBaseResponse().Ret;
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_HAS_FEATURE);
            return i;
        }
    }
}

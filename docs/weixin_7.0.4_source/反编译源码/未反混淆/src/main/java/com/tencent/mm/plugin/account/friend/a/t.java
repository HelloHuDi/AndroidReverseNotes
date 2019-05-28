package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;

public final class t {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public aoq gvI = new aoq();

        public a() {
            AppMethodBeat.i(108412);
            AppMethodBeat.o(108412);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(108413);
            a(z.dmv());
            this.gvI.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.gvI.setBaseRequest(l.a(this));
            byte[] toByteArray = this.gvI.toByteArray();
            AppMethodBeat.o(108413);
            return toByteArray;
        }

        public final int ZU() {
            return v2helper.EMethodSetIosMicAbCheckOff;
        }
    }

    public static class b extends e implements c {
        public aor gvJ = new aor();

        public b() {
            AppMethodBeat.i(108414);
            AppMethodBeat.o(108414);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(108415);
            this.gvJ = (aor) new aor().parseFrom(bArr);
            l.a(this, this.gvJ.getBaseResponse());
            int i = this.gvJ.getBaseResponse().Ret;
            AppMethodBeat.o(108415);
            return i;
        }
    }
}

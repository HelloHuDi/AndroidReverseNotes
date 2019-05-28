package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public ckb rNE = new ckb();

        public a() {
            AppMethodBeat.i(59298);
            AppMethodBeat.o(59298);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(59299);
            a(z.dmv());
            this.rNE.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.rNE.setBaseRequest(l.a(this));
            this.vyi = this.rNE.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.rNE.toByteArray();
            AppMethodBeat.o(59299);
            return toByteArray;
        }

        public final int ZU() {
            return ag.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements com.tencent.mm.protocal.l.c {
        public ckc rNF = new ckc();

        public b() {
            AppMethodBeat.i(59300);
            AppMethodBeat.o(59300);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(59301);
            this.rNF = (ckc) new ckc().parseFrom(bArr);
            l.a(this, this.rNF.getBaseResponse());
            int i = this.rNF.getBaseResponse().Ret;
            AppMethodBeat.o(59301);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

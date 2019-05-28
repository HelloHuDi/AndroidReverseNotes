package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class bc {

    public static class b extends e implements c {
        public cnn fmb = new cnn();

        public b() {
            AppMethodBeat.i(16325);
            AppMethodBeat.o(16325);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(16326);
            this.fmb = (cnn) new cnn().parseFrom(bArr);
            l.a(this, this.fmb.getBaseResponse());
            int i = this.fmb.getBaseResponse().Ret;
            AppMethodBeat.o(16326);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public cnm fma = new cnm();

        public a() {
            AppMethodBeat.i(16323);
            AppMethodBeat.o(16323);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(16324);
            a(z.dmv());
            this.fma.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.fma.setBaseRequest(l.a(this));
            byte[] toByteArray = this.fma.toByteArray();
            AppMethodBeat.o(16324);
            return toByteArray;
        }

        public final int ZU() {
            return be.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

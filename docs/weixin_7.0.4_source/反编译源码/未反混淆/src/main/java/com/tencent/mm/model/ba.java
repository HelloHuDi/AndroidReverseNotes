package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class ba {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public aqb flW = new aqb();

        public a() {
            AppMethodBeat.i(16315);
            AppMethodBeat.o(16315);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(16316);
            a(z.dmv());
            this.flW.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.flW.setBaseRequest(l.a(this));
            byte[] toByteArray = this.flW.toByteArray();
            AppMethodBeat.o(16316);
            return toByteArray;
        }

        public final int ZU() {
            return bd.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public aqc flX = new aqc();

        public b() {
            AppMethodBeat.i(16317);
            AppMethodBeat.o(16317);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(16318);
            this.flX = (aqc) new aqc().parseFrom(bArr);
            l.a(this, this.flX.getBaseResponse());
            int i = this.flX.getBaseResponse().Ret;
            AppMethodBeat.o(16318);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

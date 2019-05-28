package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class bb {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public aqf flY = new aqf();

        public a() {
            AppMethodBeat.i(16319);
            AppMethodBeat.o(16319);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(16320);
            a(z.dmv());
            this.flY.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.flY.setBaseRequest(l.a(this));
            byte[] toByteArray = this.flY.toByteArray();
            AppMethodBeat.o(16320);
            return toByteArray;
        }

        public final int ZU() {
            return com.tencent.mm.plugin.appbrand.jsapi.bb.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public aqg flZ = new aqg();

        public b() {
            AppMethodBeat.i(16321);
            AppMethodBeat.o(16321);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(16322);
            this.flZ = (aqg) new aqg().parseFrom(bArr);
            l.a(this, this.flZ.getBaseResponse());
            int i = this.flZ.getBaseResponse().Ret;
            AppMethodBeat.o(16322);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

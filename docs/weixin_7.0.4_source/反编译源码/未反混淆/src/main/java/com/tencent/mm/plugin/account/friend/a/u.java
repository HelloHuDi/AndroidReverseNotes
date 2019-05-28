package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class u {

    public static class a extends d implements b {
        public apy gvK = new apy();

        public a() {
            AppMethodBeat.i(108416);
            AppMethodBeat.o(108416);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(108417);
            a(z.dmx());
            this.gvK.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.gvK.setBaseRequest(l.a(this));
            byte[] toByteArray = this.gvK.toByteArray();
            AppMethodBeat.o(108417);
            return toByteArray;
        }

        public final int ZU() {
            return 107;
        }

        public final int getCmdId() {
            return 48;
        }
    }
}

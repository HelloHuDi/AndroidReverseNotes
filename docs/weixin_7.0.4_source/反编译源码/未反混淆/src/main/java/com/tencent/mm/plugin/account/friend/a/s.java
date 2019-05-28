package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class s {

    public static class a extends d implements b {
        public ano gvH = new ano();

        public a() {
            AppMethodBeat.i(108410);
            AppMethodBeat.o(108410);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(108411);
            a(z.dmx());
            this.gvH.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.gvH.setBaseRequest(l.a(this));
            byte[] toByteArray = this.gvH.toByteArray();
            AppMethodBeat.o(108411);
            return toByteArray;
        }

        public final int ZU() {
            return 572;
        }
    }
}

package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class r {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public xv gvF = new xv();

        public a() {
            AppMethodBeat.i(108406);
            AppMethodBeat.o(108406);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(108407);
            a(z.dmx());
            this.gvF.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.gvF.setBaseRequest(l.a(this));
            byte[] toByteArray = this.gvF.toByteArray();
            AppMethodBeat.o(108407);
            return toByteArray;
        }

        public final int ZU() {
            return m.CTRL_INDEX;
        }
    }

    public static class b extends e implements c {
        public xw gvG = new xw();

        public b() {
            AppMethodBeat.i(108408);
            AppMethodBeat.o(108408);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(108409);
            this.gvG = (xw) new xw().parseFrom(bArr);
            l.a(this, this.gvG.getBaseResponse());
            int i = this.gvG.getBaseResponse().Ret;
            AppMethodBeat.o(108409);
            return i;
        }
    }
}

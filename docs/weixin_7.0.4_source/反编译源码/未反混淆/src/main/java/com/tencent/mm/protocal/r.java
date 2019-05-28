package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.sdk.platformtools.bo;

public final class r {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public agx vyC = new agx();

        public a() {
            AppMethodBeat.i(58848);
            AppMethodBeat.o(58848);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(58849);
            a(z.dmx());
            this.vyC.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.vyC.wns = z.dmv().ver;
            this.vyC.setBaseRequest(l.a(this));
            byte[] toByteArray = this.vyC.toByteArray();
            AppMethodBeat.o(58849);
            return toByteArray;
        }

        public final int ZU() {
            return 381;
        }

        public final int getCmdId() {
            return 179;
        }
    }

    public static class b extends e implements c {
        public agy vyD = new agy();

        public b() {
            AppMethodBeat.i(58850);
            AppMethodBeat.o(58850);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(58851);
            this.vyD = (agy) new agy().parseFrom(bArr);
            l.a(this, this.vyD.getBaseResponse());
            int i = this.vyD.getBaseResponse().Ret;
            AppMethodBeat.o(58851);
            return i;
        }

        public final int getCmdId() {
            return 1000000179;
        }
    }
}

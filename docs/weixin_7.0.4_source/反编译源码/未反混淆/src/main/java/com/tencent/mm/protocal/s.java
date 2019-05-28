package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bec;

public final class s {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public beb vyE = new beb();

        public a() {
            AppMethodBeat.i(58852);
            AppMethodBeat.o(58852);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(58853);
            this.vyE.setBaseRequest(l.a(this));
            byte[] toByteArray = this.vyE.toByteArray();
            AppMethodBeat.o(58853);
            return toByteArray;
        }

        public final int ZU() {
            return com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 27;
        }
    }

    public static class b extends e implements c {
        public bec vyF = new bec();

        public b() {
            AppMethodBeat.i(58854);
            AppMethodBeat.o(58854);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(58855);
            this.vyF = (bec) new bec().parseFrom(bArr);
            l.a(this, this.vyF.getBaseResponse());
            int i = this.vyF.getBaseResponse().Ret;
            AppMethodBeat.o(58855);
            return i;
        }

        public final int getCmdId() {
            return 1000000027;
        }
    }
}

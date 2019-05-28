package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.bo;

public final class n {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public jo vyq = new jo();

        public a() {
            AppMethodBeat.i(123502);
            AppMethodBeat.o(123502);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(123503);
            a(z.dmv());
            this.vyq.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.vyq.setBaseRequest(l.a(this));
            byte[] toByteArray = this.vyq.toByteArray();
            AppMethodBeat.o(123503);
            return toByteArray;
        }

        public final int ZU() {
            return 145;
        }
    }

    public static class b extends e implements c {
        public jp vyr = new jp();

        public b() {
            AppMethodBeat.i(123504);
            AppMethodBeat.o(123504);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(123505);
            this.vyr = (jp) new jp().parseFrom(bArr);
            l.a(this, this.vyr.getBaseResponse());
            int i = this.vyr.getBaseResponse().Ret;
            AppMethodBeat.o(123505);
            return i;
        }
    }
}

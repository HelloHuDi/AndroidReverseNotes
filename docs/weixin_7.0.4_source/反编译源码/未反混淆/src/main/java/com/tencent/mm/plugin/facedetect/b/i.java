package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class i {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public afj lSz = new afj();

        public a() {
            AppMethodBeat.i(66);
            AppMethodBeat.o(66);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(67);
            a(z.dmv());
            this.lSz.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.lSz.setBaseRequest(l.a(this));
            this.vyi = this.lSz.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.lSz.toByteArray();
            AppMethodBeat.o(67);
            return toByteArray;
        }

        public final int ZU() {
            return 733;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public afk lSA = new afk();

        public b() {
            AppMethodBeat.i(68);
            AppMethodBeat.o(68);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(69);
            this.lSA = (afk) new afk().parseFrom(bArr);
            l.a(this, this.lSA.getBaseResponse());
            int i = this.lSA.getBaseResponse().Ret;
            AppMethodBeat.o(69);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

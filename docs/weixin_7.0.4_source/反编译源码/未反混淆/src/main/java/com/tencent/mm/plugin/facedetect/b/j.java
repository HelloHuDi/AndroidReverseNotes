package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class j {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public bqx lSB = new bqx();

        public a() {
            AppMethodBeat.i(70);
            AppMethodBeat.o(70);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(71);
            a(z.dmv());
            this.lSB.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.lSB.setBaseRequest(l.a(this));
            this.vyi = this.lSB.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.lSB.toByteArray();
            AppMethodBeat.o(71);
            return toByteArray;
        }

        public final int ZU() {
            return 931;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public bqy lSC = new bqy();

        public b() {
            AppMethodBeat.i(72);
            AppMethodBeat.o(72);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(73);
            this.lSC = (bqy) new bqy().parseFrom(bArr);
            l.a(this, this.lSC.getBaseResponse());
            int i = this.lSC.getBaseResponse().Ret;
            AppMethodBeat.o(73);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class k {

    public static class b extends e implements c {
        public cmt lSE = new cmt();

        public b() {
            AppMethodBeat.i(76);
            AppMethodBeat.o(76);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(77);
            this.lSE = (cmt) new cmt().parseFrom(bArr);
            l.a(this, this.lSE.getBaseResponse());
            int i = this.lSE.getBaseResponse().Ret;
            AppMethodBeat.o(77);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public cms lSD = new cms();

        public a() {
            AppMethodBeat.i(74);
            AppMethodBeat.o(74);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(75);
            a(z.dmv());
            this.lSD.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.lSD.setBaseRequest(l.a(this));
            this.vyi = this.lSD.vLz.getBuffer().toByteArray();
            byte[] toByteArray = this.lSD.toByteArray();
            AppMethodBeat.o(75);
            return toByteArray;
        }

        public final int ZU() {
            return 930;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

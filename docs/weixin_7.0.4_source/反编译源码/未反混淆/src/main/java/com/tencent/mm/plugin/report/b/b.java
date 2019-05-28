package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public awz pXm = new awz();

        public a() {
            AppMethodBeat.i(72669);
            AppMethodBeat.o(72669);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(72670);
            a(z.dmw());
            this.pXm.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.pXm.setBaseRequest(l.a(this));
            byte[] toByteArray = this.pXm.toByteArray();
            AppMethodBeat.o(72670);
            return toByteArray;
        }

        public final int ZU() {
            return 694;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

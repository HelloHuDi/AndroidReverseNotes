package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.storage.j;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {

    public static class a extends d implements b {
        public awz pXm = new awz();

        public a() {
            AppMethodBeat.i(72671);
            AppMethodBeat.o(72671);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(72672);
            a(z.dmw());
            this.pXm.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.pXm.setBaseRequest(l.a(this));
            byte[] toByteArray = this.pXm.toByteArray();
            AppMethodBeat.o(72672);
            return toByteArray;
        }

        public final int ZU() {
            return j.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.sdk.platformtools.ab;

public final class k {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public gq vxY = new gq();
        public byte[] vxZ;

        public a() {
            AppMethodBeat.i(28276);
            AppMethodBeat.o(28276);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(28277);
            this.vxY.setBaseRequest(l.a(this));
            ab.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", this.vxZ, Integer.valueOf(this.vxY.vIN), this.vxY.vIO, this.vxY.vIP, this.vxY.vIQ, Integer.valueOf(this.vxY.Scene), Long.valueOf(this.vxY.jBP), this.vxY.vIR, this.vxY.vIS);
            byte[] toByteArray = this.vxY.toByteArray();
            AppMethodBeat.o(28277);
            return toByteArray;
        }

        public final int ZU() {
            return 1000;
        }

        public final int getCmdId() {
            return 1000;
        }
    }

    public static class b extends e implements c {
        public gs vya = new gs();

        public b() {
            AppMethodBeat.i(28278);
            AppMethodBeat.o(28278);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(28279);
            this.vya = (gs) new gs().parseFrom(bArr);
            ab.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", Integer.valueOf(this.vya.Ret), this.vya.vIT, this.vya.vIU);
            int i = this.vya.Ret;
            AppMethodBeat.o(28279);
            return i;
        }

        public final int getCmdId() {
            return 1000;
        }
    }
}

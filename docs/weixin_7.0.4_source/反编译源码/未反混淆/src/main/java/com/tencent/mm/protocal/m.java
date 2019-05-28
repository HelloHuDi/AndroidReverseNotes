package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class m extends a {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public int netType;
        public int vyo = 0;

        public final byte[] ZT() {
            AppMethodBeat.i(28280);
            iz izVar = new iz();
            izVar.vKd = d.vxo;
            izVar.vKR = 2;
            izVar.vKS = this.netType;
            izVar.vKT = this.vyo;
            ab.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", Integer.valueOf(izVar.vKT), Integer.valueOf(izVar.vKS), Integer.valueOf(izVar.vKd), Integer.valueOf(izVar.vKR));
            byte[] bArr = null;
            try {
                bArr = izVar.toByteArray();
            } catch (IOException e) {
                ab.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", bo.l(e));
            }
            AppMethodBeat.o(28280);
            return bArr;
        }

        public final int ZU() {
            return 0;
        }

        public final int getCmdId() {
            return 312;
        }

        public final boolean dms() {
            return true;
        }

        public final boolean adr() {
            return false;
        }
    }

    public static class b extends e implements c {
        public ja vyp = new ja();

        public b() {
            AppMethodBeat.i(28281);
            AppMethodBeat.o(28281);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(28282);
            this.vyp = (ja) new ja().parseFrom(bArr);
            ab.d("MicroMsg.MMBgFg", "retcode:" + this.vyp.kCl);
            int i = this.vyp.kCl;
            AppMethodBeat.o(28282);
            return i;
        }

        public final int getCmdId() {
            return 1000000312;
        }

        public final boolean dms() {
            return true;
        }
    }
}

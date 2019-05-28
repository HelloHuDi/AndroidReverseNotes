package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bek;

public final class t {

    public static class b extends e implements c {
        public bek vyH = new bek();

        public b() {
            AppMethodBeat.i(58858);
            AppMethodBeat.o(58858);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(58859);
            this.vyH = (bek) new bek().parseFrom(bArr);
            int i = this.vyH.Ret;
            AppMethodBeat.o(58859);
            return i;
        }

        public final int getCmdId() {
            return 1000000121;
        }
    }

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public bej vyG = new bej();

        public a() {
            AppMethodBeat.i(58856);
            AppMethodBeat.o(58856);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(58857);
            byte[] toByteArray = this.vyG.toByteArray();
            AppMethodBeat.o(58857);
            return toByteArray;
        }

        public final int ZU() {
            return 138;
        }

        public final int getCmdId() {
            return 121;
        }
    }
}

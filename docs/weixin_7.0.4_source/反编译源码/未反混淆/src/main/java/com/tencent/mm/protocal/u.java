package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.bo;

public final class u {

    public static class b extends e implements c {
        public final int P(byte[] bArr) {
            return 0;
        }

        public final int getCmdId() {
            return -1;
        }
    }

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public byte[] cAG = null;
        public long fJB = -1;

        public final byte[] ZT() {
            AppMethodBeat.i(58860);
            byte[] bArr = new byte[(this.cAG.length + 8)];
            int anU = (int) (bo.anU() - this.fJB);
            bArr[0] = (byte) ((anU >> 24) & 255);
            bArr[1] = (byte) ((anU >> 16) & 255);
            bArr[2] = (byte) ((anU >> 8) & 255);
            bArr[3] = (byte) (anU & 255);
            bArr[4] = (byte) ((this.cAG.length >> 24) & 255);
            bArr[5] = (byte) ((this.cAG.length >> 16) & 255);
            bArr[6] = (byte) ((this.cAG.length >> 8) & 255);
            bArr[7] = (byte) (this.cAG.length & 255);
            System.arraycopy(this.cAG, 0, bArr, 8, this.cAG.length);
            bo.ca(bArr);
            AppMethodBeat.o(58860);
            return bArr;
        }

        public final int getCmdId() {
            return 1000000190;
        }

        public final int ZU() {
            return 268369922;
        }

        public final boolean adr() {
            return false;
        }
    }
}

package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.protocal.u */
public final class C23474u {

    /* renamed from: com.tencent.mm.protocal.u$b */
    public static class C23475b extends C4835e implements C4833c {
        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            return 0;
        }

        public final int getCmdId() {
            return -1;
        }
    }

    /* renamed from: com.tencent.mm.protocal.u$a */
    public static class C23476a extends C4834d implements C4832b {
        public byte[] cAG = null;
        public long fJB = -1;

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(58860);
            byte[] bArr = new byte[(this.cAG.length + 8)];
            int anU = (int) (C5046bo.anU() - this.fJB);
            bArr[0] = (byte) ((anU >> 24) & 255);
            bArr[1] = (byte) ((anU >> 16) & 255);
            bArr[2] = (byte) ((anU >> 8) & 255);
            bArr[3] = (byte) (anU & 255);
            bArr[4] = (byte) ((this.cAG.length >> 24) & 255);
            bArr[5] = (byte) ((this.cAG.length >> 16) & 255);
            bArr[6] = (byte) ((this.cAG.length >> 8) & 255);
            bArr[7] = (byte) (this.cAG.length & 255);
            System.arraycopy(this.cAG, 0, bArr, 8, this.cAG.length);
            C5046bo.m7539ca(bArr);
            AppMethodBeat.m2505o(58860);
            return bArr;
        }

        public final int getCmdId() {
            return 1000000190;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 268369922;
        }

        public final boolean adr() {
            return false;
        }
    }
}

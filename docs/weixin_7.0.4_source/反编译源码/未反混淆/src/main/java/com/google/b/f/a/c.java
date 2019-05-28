package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;

public final class c {
    private static final int[] bBy = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final c[] bBz = vK();
    public final int bBA;
    private final int[] bBB;
    private final b[] bBC;
    public final int bBD;

    public static final class b {
        final int bBF;
        final a[] bBG;

        b(int i, a... aVarArr) {
            this.bBF = i;
            this.bBG = aVarArr;
        }

        public final int vL() {
            a[] aVarArr = this.bBG;
            int i = 0;
            int i2 = 0;
            while (i < aVarArr.length) {
                i++;
                i2 = aVarArr[i].count + i2;
            }
            return i2;
        }

        public final int vM() {
            AppMethodBeat.i(57176);
            int vL = this.bBF * vL();
            AppMethodBeat.o(57176);
            return vL;
        }
    }

    public static final class a {
        final int bBE;
        final int count;

        a(int i, int i2) {
            this.count = i;
            this.bBE = i2;
        }
    }

    static {
        AppMethodBeat.i(57248);
        AppMethodBeat.o(57248);
    }

    private c(int i, int[] iArr, b... bVarArr) {
        AppMethodBeat.i(57243);
        this.bBA = i;
        this.bBB = iArr;
        this.bBC = bVarArr;
        int i2 = bVarArr[0].bBF;
        a[] aVarArr = bVarArr[0].bBG;
        int length = aVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            a aVar = aVarArr[i3];
            i3++;
            i4 = ((aVar.bBE + i2) * aVar.count) + i4;
        }
        this.bBD = i4;
        AppMethodBeat.o(57243);
    }

    public final b a(a aVar) {
        AppMethodBeat.i(57244);
        b bVar = this.bBC[aVar.ordinal()];
        AppMethodBeat.o(57244);
        return bVar;
    }

    public static c fH(int i) {
        AppMethodBeat.i(57245);
        if (i <= 0 || i > 40) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(57245);
            throw illegalArgumentException;
        }
        c cVar = bBz[i - 1];
        AppMethodBeat.o(57245);
        return cVar;
    }

    public final String toString() {
        AppMethodBeat.i(57246);
        String valueOf = String.valueOf(this.bBA);
        AppMethodBeat.o(57246);
        return valueOf;
    }

    private static c[] vK() {
        AppMethodBeat.i(57247);
        r0 = new c[40];
        int[] iArr = new int[0];
        b[] bVarArr = new b[4];
        bVarArr[0] = new b(7, new a(1, 19));
        bVarArr[1] = new b(10, new a(1, 16));
        bVarArr[2] = new b(13, new a(1, 13));
        bVarArr[3] = new b(17, new a(1, 9));
        r0[0] = new c(1, iArr, bVarArr);
        iArr = new int[]{6, 18};
        bVarArr = new b[4];
        bVarArr[0] = new b(10, new a(1, 34));
        bVarArr[1] = new b(16, new a(1, 28));
        bVarArr[2] = new b(22, new a(1, 22));
        bVarArr[3] = new b(28, new a(1, 16));
        r0[1] = new c(2, iArr, bVarArr);
        iArr = new int[]{6, 22};
        bVarArr = new b[4];
        bVarArr[0] = new b(15, new a(1, 55));
        bVarArr[1] = new b(26, new a(1, 44));
        bVarArr[2] = new b(18, new a(2, 17));
        bVarArr[3] = new b(22, new a(2, 13));
        r0[2] = new c(3, iArr, bVarArr);
        iArr = new int[]{6, 26};
        bVarArr = new b[4];
        bVarArr[0] = new b(20, new a(1, 80));
        bVarArr[1] = new b(18, new a(2, 32));
        bVarArr[2] = new b(26, new a(2, 24));
        bVarArr[3] = new b(16, new a(4, 9));
        r0[3] = new c(4, iArr, bVarArr);
        iArr = new int[]{6, 30};
        bVarArr = new b[4];
        bVarArr[0] = new b(26, new a(1, 108));
        bVarArr[1] = new b(24, new a(2, 43));
        bVarArr[2] = new b(18, new a(2, 15), new a(2, 16));
        bVarArr[3] = new b(22, new a(2, 11), new a(2, 12));
        r0[4] = new c(5, iArr, bVarArr);
        iArr = new int[]{6, 34};
        bVarArr = new b[4];
        bVarArr[0] = new b(18, new a(2, 68));
        bVarArr[1] = new b(16, new a(4, 27));
        bVarArr[2] = new b(24, new a(4, 19));
        bVarArr[3] = new b(28, new a(4, 15));
        r0[5] = new c(6, iArr, bVarArr);
        iArr = new int[]{6, 22, 38};
        bVarArr = new b[4];
        bVarArr[0] = new b(20, new a(2, 78));
        bVarArr[1] = new b(18, new a(4, 31));
        bVarArr[2] = new b(18, new a(2, 14), new a(4, 15));
        bVarArr[3] = new b(26, new a(4, 13), new a(1, 14));
        r0[6] = new c(7, iArr, bVarArr);
        iArr = new int[]{6, 24, 42};
        bVarArr = new b[4];
        bVarArr[0] = new b(24, new a(2, 97));
        bVarArr[1] = new b(22, new a(2, 38), new a(2, 39));
        bVarArr[2] = new b(22, new a(4, 18), new a(2, 19));
        bVarArr[3] = new b(26, new a(4, 14), new a(2, 15));
        r0[7] = new c(8, iArr, bVarArr);
        iArr = new int[]{6, 26, 46};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(2, 116));
        bVarArr[1] = new b(22, new a(3, 36), new a(2, 37));
        bVarArr[2] = new b(20, new a(4, 16), new a(4, 17));
        bVarArr[3] = new b(24, new a(4, 12), new a(4, 13));
        r0[8] = new c(9, iArr, bVarArr);
        iArr = new int[]{6, 28, 50};
        bVarArr = new b[4];
        bVarArr[0] = new b(18, new a(2, 68), new a(2, 69));
        bVarArr[1] = new b(26, new a(4, 43), new a(1, 44));
        bVarArr[2] = new b(24, new a(6, 19), new a(2, 20));
        bVarArr[3] = new b(28, new a(6, 15), new a(2, 16));
        r0[9] = new c(10, iArr, bVarArr);
        iArr = new int[]{6, 30, 54};
        bVarArr = new b[4];
        bVarArr[0] = new b(20, new a(4, 81));
        bVarArr[1] = new b(30, new a(1, 50), new a(4, 51));
        bVarArr[2] = new b(28, new a(4, 22), new a(4, 23));
        bVarArr[3] = new b(24, new a(3, 12), new a(8, 13));
        r0[10] = new c(11, iArr, bVarArr);
        iArr = new int[]{6, 32, 58};
        bVarArr = new b[4];
        bVarArr[0] = new b(24, new a(2, 92), new a(2, 93));
        bVarArr[1] = new b(22, new a(6, 36), new a(2, 37));
        bVarArr[2] = new b(26, new a(4, 20), new a(6, 21));
        bVarArr[3] = new b(28, new a(7, 14), new a(4, 15));
        r0[11] = new c(12, iArr, bVarArr);
        iArr = new int[]{6, 34, 62};
        bVarArr = new b[4];
        bVarArr[0] = new b(26, new a(4, 107));
        bVarArr[1] = new b(22, new a(8, 37), new a(1, 38));
        bVarArr[2] = new b(24, new a(8, 20), new a(4, 21));
        bVarArr[3] = new b(22, new a(12, 11), new a(4, 12));
        r0[12] = new c(13, iArr, bVarArr);
        iArr = new int[]{6, 26, 46, 66};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(3, 115), new a(1, 116));
        bVarArr[1] = new b(24, new a(4, 40), new a(5, 41));
        bVarArr[2] = new b(20, new a(11, 16), new a(5, 17));
        bVarArr[3] = new b(24, new a(11, 12), new a(5, 13));
        r0[13] = new c(14, iArr, bVarArr);
        iArr = new int[]{6, 26, 48, 70};
        bVarArr = new b[4];
        bVarArr[0] = new b(22, new a(5, 87), new a(1, 88));
        bVarArr[1] = new b(24, new a(5, 41), new a(5, 42));
        bVarArr[2] = new b(30, new a(5, 24), new a(7, 25));
        bVarArr[3] = new b(24, new a(11, 12), new a(7, 13));
        r0[14] = new c(15, iArr, bVarArr);
        iArr = new int[]{6, 26, 50, 74};
        bVarArr = new b[4];
        bVarArr[0] = new b(24, new a(5, 98), new a(1, 99));
        bVarArr[1] = new b(28, new a(7, 45), new a(3, 46));
        bVarArr[2] = new b(24, new a(15, 19), new a(2, 20));
        bVarArr[3] = new b(30, new a(3, 15), new a(13, 16));
        r0[15] = new c(16, iArr, bVarArr);
        iArr = new int[]{6, 30, 54, 78};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(1, 107), new a(5, 108));
        bVarArr[1] = new b(28, new a(10, 46), new a(1, 47));
        bVarArr[2] = new b(28, new a(1, 22), new a(15, 23));
        bVarArr[3] = new b(28, new a(2, 14), new a(17, 15));
        r0[16] = new c(17, iArr, bVarArr);
        iArr = new int[]{6, 30, 56, 82};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(5, 120), new a(1, 121));
        bVarArr[1] = new b(26, new a(9, 43), new a(4, 44));
        bVarArr[2] = new b(28, new a(17, 22), new a(1, 23));
        bVarArr[3] = new b(28, new a(2, 14), new a(19, 15));
        r0[17] = new c(18, iArr, bVarArr);
        iArr = new int[]{6, 30, 58, 86};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(3, 113), new a(4, 114));
        bVarArr[1] = new b(26, new a(3, 44), new a(11, 45));
        bVarArr[2] = new b(26, new a(17, 21), new a(4, 22));
        bVarArr[3] = new b(26, new a(9, 13), new a(16, 14));
        r0[18] = new c(19, iArr, bVarArr);
        iArr = new int[]{6, 34, 62, 90};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(3, 107), new a(5, 108));
        bVarArr[1] = new b(26, new a(3, 41), new a(13, 42));
        bVarArr[2] = new b(30, new a(15, 24), new a(5, 25));
        bVarArr[3] = new b(28, new a(15, 15), new a(10, 16));
        r0[19] = new c(20, iArr, bVarArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(4, 116), new a(4, d.MIC_ALPHA_ADJUST_REAL));
        bVarArr[1] = new b(26, new a(17, 42));
        bVarArr[2] = new b(28, new a(17, 22), new a(6, 23));
        bVarArr[3] = new b(30, new a(19, 16), new a(6, 17));
        r0[20] = new c(21, iArr, bVarArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(2, 111), new a(7, 112));
        bVarArr[1] = new b(28, new a(17, 46));
        bVarArr[2] = new b(30, new a(7, 24), new a(16, 25));
        bVarArr[3] = new b(24, new a(34, 13));
        r0[21] = new c(22, iArr, bVarArr);
        iArr = new int[]{6, 30, 54, 78, 102};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(4, 121), new a(5, 122));
        bVarArr[1] = new b(28, new a(4, 47), new a(14, 48));
        bVarArr[2] = new b(30, new a(11, 24), new a(14, 25));
        bVarArr[3] = new b(30, new a(16, 15), new a(14, 16));
        r0[22] = new c(23, iArr, bVarArr);
        iArr = new int[]{6, 28, 54, 80, 106};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(6, d.MIC_ALPHA_ADJUST_REAL), new a(4, 118));
        bVarArr[1] = new b(28, new a(6, 45), new a(14, 46));
        bVarArr[2] = new b(30, new a(11, 24), new a(16, 25));
        bVarArr[3] = new b(30, new a(30, 16), new a(2, 17));
        r0[23] = new c(24, iArr, bVarArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        bVarArr = new b[4];
        bVarArr[0] = new b(26, new a(8, 106), new a(4, 107));
        bVarArr[1] = new b(28, new a(8, 47), new a(13, 48));
        bVarArr[2] = new b(30, new a(7, 24), new a(22, 25));
        bVarArr[3] = new b(30, new a(22, 15), new a(13, 16));
        r0[24] = new c(25, iArr, bVarArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(10, 114), new a(2, 115));
        bVarArr[1] = new b(28, new a(19, 46), new a(4, 47));
        bVarArr[2] = new b(28, new a(28, 22), new a(6, 23));
        bVarArr[3] = new b(30, new a(33, 16), new a(4, 17));
        r0[25] = new c(26, iArr, bVarArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(8, 122), new a(4, 123));
        bVarArr[1] = new b(28, new a(22, 45), new a(3, 46));
        bVarArr[2] = new b(30, new a(8, 23), new a(26, 24));
        bVarArr[3] = new b(30, new a(12, 15), new a(28, 16));
        r0[26] = new c(27, iArr, bVarArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(3, d.MIC_ALPHA_ADJUST_REAL), new a(10, 118));
        bVarArr[1] = new b(28, new a(3, 45), new a(23, 46));
        bVarArr[2] = new b(30, new a(4, 24), new a(31, 25));
        bVarArr[3] = new b(30, new a(11, 15), new a(31, 16));
        r0[27] = new c(28, iArr, bVarArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(7, 116), new a(7, d.MIC_ALPHA_ADJUST_REAL));
        bVarArr[1] = new b(28, new a(21, 45), new a(7, 46));
        bVarArr[2] = new b(30, new a(1, 23), new a(37, 24));
        bVarArr[3] = new b(30, new a(19, 15), new a(26, 16));
        r0[28] = new c(29, iArr, bVarArr);
        iArr = new int[]{6, 26, 52, 78, 104, 130};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(5, 115), new a(10, 116));
        bVarArr[1] = new b(28, new a(19, 47), new a(10, 48));
        bVarArr[2] = new b(30, new a(15, 24), new a(25, 25));
        bVarArr[3] = new b(30, new a(23, 15), new a(25, 16));
        r0[29] = new c(30, iArr, bVarArr);
        iArr = new int[]{6, 30, 56, 82, 108, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(13, 115), new a(3, 116));
        bVarArr[1] = new b(28, new a(2, 46), new a(29, 47));
        bVarArr[2] = new b(30, new a(42, 24), new a(1, 25));
        bVarArr[3] = new b(30, new a(23, 15), new a(28, 16));
        r0[30] = new c(31, iArr, bVarArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(17, 115));
        bVarArr[1] = new b(28, new a(10, 46), new a(23, 47));
        bVarArr[2] = new b(30, new a(10, 24), new a(35, 25));
        bVarArr[3] = new b(30, new a(19, 15), new a(35, 16));
        r0[31] = new c(32, iArr, bVarArr);
        iArr = new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(17, 115), new a(1, 116));
        bVarArr[1] = new b(28, new a(14, 46), new a(21, 47));
        bVarArr[2] = new b(30, new a(29, 24), new a(19, 25));
        bVarArr[3] = new b(30, new a(11, 15), new a(46, 16));
        r0[32] = new c(33, iArr, bVarArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(13, 115), new a(6, 116));
        bVarArr[1] = new b(28, new a(14, 46), new a(23, 47));
        bVarArr[2] = new b(30, new a(44, 24), new a(7, 25));
        bVarArr[3] = new b(30, new a(59, 16), new a(1, 17));
        r0[33] = new c(34, iArr, bVarArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126, 150};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(12, 121), new a(7, 122));
        bVarArr[1] = new b(28, new a(12, 47), new a(26, 48));
        bVarArr[2] = new b(30, new a(39, 24), new a(14, 25));
        bVarArr[3] = new b(30, new a(22, 15), new a(41, 16));
        r0[34] = new c(35, iArr, bVarArr);
        iArr = new int[]{6, 24, 50, 76, 102, 128, JsApiMakeVoIPCall.CTRL_INDEX};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(6, 121), new a(14, 122));
        bVarArr[1] = new b(28, new a(6, 47), new a(34, 48));
        bVarArr[2] = new b(30, new a(46, 24), new a(10, 25));
        bVarArr[3] = new b(30, new a(2, 15), new a(64, 16));
        r0[35] = new c(36, iArr, bVarArr);
        iArr = new int[]{6, 28, 54, 80, 106, 132, 158};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(17, 122), new a(4, 123));
        bVarArr[1] = new b(28, new a(29, 46), new a(14, 47));
        bVarArr[2] = new b(30, new a(49, 24), new a(10, 25));
        bVarArr[3] = new b(30, new a(24, 15), new a(46, 16));
        r0[36] = new c(37, iArr, bVarArr);
        iArr = new int[]{6, 32, 58, 84, 110, n.CTRL_INDEX, ErrorCode.STARTDOWNLOAD_3};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(4, 122), new a(18, 123));
        bVarArr[1] = new b(28, new a(13, 46), new a(32, 47));
        bVarArr[2] = new b(30, new a(48, 24), new a(14, 25));
        bVarArr[3] = new b(30, new a(42, 15), new a(32, 16));
        r0[37] = new c(38, iArr, bVarArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(20, d.MIC_ALPHA_ADJUST_REAL), new a(4, 118));
        bVarArr[1] = new b(28, new a(40, 47), new a(7, 48));
        bVarArr[2] = new b(30, new a(43, 24), new a(22, 25));
        bVarArr[3] = new b(30, new a(10, 15), new a(67, 16));
        r0[38] = new c(39, iArr, bVarArr);
        iArr = new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_TRUE};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(19, 118), new a(6, d.MIC_AVROUND_BLUR));
        bVarArr[1] = new b(28, new a(18, 47), new a(31, 48));
        bVarArr[2] = new b(30, new a(34, 24), new a(34, 25));
        bVarArr[3] = new b(30, new a(20, 15), new a(61, 16));
        r0[39] = new c(40, iArr, bVarArr);
        AppMethodBeat.o(57247);
        return r0;
    }
}

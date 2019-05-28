package com.google.p114b.p120f.p121a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.google.b.f.a.c */
public final class C0902c {
    private static final int[] bBy = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final C0902c[] bBz = C0902c.m2051vK();
    public final int bBA;
    private final int[] bBB;
    private final C0903b[] bBC;
    public final int bBD;

    /* renamed from: com.google.b.f.a.c$b */
    public static final class C0903b {
        final int bBF;
        final C0904a[] bBG;

        C0903b(int i, C0904a... c0904aArr) {
            this.bBF = i;
            this.bBG = c0904aArr;
        }

        /* renamed from: vL */
        public final int mo3691vL() {
            C0904a[] c0904aArr = this.bBG;
            int i = 0;
            int i2 = 0;
            while (i < c0904aArr.length) {
                i++;
                i2 = c0904aArr[i].count + i2;
            }
            return i2;
        }

        /* renamed from: vM */
        public final int mo3692vM() {
            AppMethodBeat.m2504i(57176);
            int vL = this.bBF * mo3691vL();
            AppMethodBeat.m2505o(57176);
            return vL;
        }
    }

    /* renamed from: com.google.b.f.a.c$a */
    public static final class C0904a {
        final int bBE;
        final int count;

        C0904a(int i, int i2) {
            this.count = i;
            this.bBE = i2;
        }
    }

    static {
        AppMethodBeat.m2504i(57248);
        AppMethodBeat.m2505o(57248);
    }

    private C0902c(int i, int[] iArr, C0903b... c0903bArr) {
        AppMethodBeat.m2504i(57243);
        this.bBA = i;
        this.bBB = iArr;
        this.bBC = c0903bArr;
        int i2 = c0903bArr[0].bBF;
        C0904a[] c0904aArr = c0903bArr[0].bBG;
        int length = c0904aArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            C0904a c0904a = c0904aArr[i3];
            i3++;
            i4 = ((c0904a.bBE + i2) * c0904a.count) + i4;
        }
        this.bBD = i4;
        AppMethodBeat.m2505o(57243);
    }

    /* renamed from: a */
    public final C0903b mo3689a(C32089a c32089a) {
        AppMethodBeat.m2504i(57244);
        C0903b c0903b = this.bBC[c32089a.ordinal()];
        AppMethodBeat.m2505o(57244);
        return c0903b;
    }

    /* renamed from: fH */
    public static C0902c m2050fH(int i) {
        AppMethodBeat.m2504i(57245);
        if (i <= 0 || i > 40) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(57245);
            throw illegalArgumentException;
        }
        C0902c c0902c = bBz[i - 1];
        AppMethodBeat.m2505o(57245);
        return c0902c;
    }

    public final String toString() {
        AppMethodBeat.m2504i(57246);
        String valueOf = String.valueOf(this.bBA);
        AppMethodBeat.m2505o(57246);
        return valueOf;
    }

    /* renamed from: vK */
    private static C0902c[] m2051vK() {
        AppMethodBeat.m2504i(57247);
        r0 = new C0902c[40];
        int[] iArr = new int[0];
        C0903b[] c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(7, new C0904a(1, 19));
        c0903bArr[1] = new C0903b(10, new C0904a(1, 16));
        c0903bArr[2] = new C0903b(13, new C0904a(1, 13));
        c0903bArr[3] = new C0903b(17, new C0904a(1, 9));
        r0[0] = new C0902c(1, iArr, c0903bArr);
        iArr = new int[]{6, 18};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(10, new C0904a(1, 34));
        c0903bArr[1] = new C0903b(16, new C0904a(1, 28));
        c0903bArr[2] = new C0903b(22, new C0904a(1, 22));
        c0903bArr[3] = new C0903b(28, new C0904a(1, 16));
        r0[1] = new C0902c(2, iArr, c0903bArr);
        iArr = new int[]{6, 22};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(15, new C0904a(1, 55));
        c0903bArr[1] = new C0903b(26, new C0904a(1, 44));
        c0903bArr[2] = new C0903b(18, new C0904a(2, 17));
        c0903bArr[3] = new C0903b(22, new C0904a(2, 13));
        r0[2] = new C0902c(3, iArr, c0903bArr);
        iArr = new int[]{6, 26};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(20, new C0904a(1, 80));
        c0903bArr[1] = new C0903b(18, new C0904a(2, 32));
        c0903bArr[2] = new C0903b(26, new C0904a(2, 24));
        c0903bArr[3] = new C0903b(16, new C0904a(4, 9));
        r0[3] = new C0902c(4, iArr, c0903bArr);
        iArr = new int[]{6, 30};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(26, new C0904a(1, 108));
        c0903bArr[1] = new C0903b(24, new C0904a(2, 43));
        c0903bArr[2] = new C0903b(18, new C0904a(2, 15), new C0904a(2, 16));
        c0903bArr[3] = new C0903b(22, new C0904a(2, 11), new C0904a(2, 12));
        r0[4] = new C0902c(5, iArr, c0903bArr);
        iArr = new int[]{6, 34};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(18, new C0904a(2, 68));
        c0903bArr[1] = new C0903b(16, new C0904a(4, 27));
        c0903bArr[2] = new C0903b(24, new C0904a(4, 19));
        c0903bArr[3] = new C0903b(28, new C0904a(4, 15));
        r0[5] = new C0902c(6, iArr, c0903bArr);
        iArr = new int[]{6, 22, 38};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(20, new C0904a(2, 78));
        c0903bArr[1] = new C0903b(18, new C0904a(4, 31));
        c0903bArr[2] = new C0903b(18, new C0904a(2, 14), new C0904a(4, 15));
        c0903bArr[3] = new C0903b(26, new C0904a(4, 13), new C0904a(1, 14));
        r0[6] = new C0902c(7, iArr, c0903bArr);
        iArr = new int[]{6, 24, 42};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(24, new C0904a(2, 97));
        c0903bArr[1] = new C0903b(22, new C0904a(2, 38), new C0904a(2, 39));
        c0903bArr[2] = new C0903b(22, new C0904a(4, 18), new C0904a(2, 19));
        c0903bArr[3] = new C0903b(26, new C0904a(4, 14), new C0904a(2, 15));
        r0[7] = new C0902c(8, iArr, c0903bArr);
        iArr = new int[]{6, 26, 46};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(2, 116));
        c0903bArr[1] = new C0903b(22, new C0904a(3, 36), new C0904a(2, 37));
        c0903bArr[2] = new C0903b(20, new C0904a(4, 16), new C0904a(4, 17));
        c0903bArr[3] = new C0903b(24, new C0904a(4, 12), new C0904a(4, 13));
        r0[8] = new C0902c(9, iArr, c0903bArr);
        iArr = new int[]{6, 28, 50};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(18, new C0904a(2, 68), new C0904a(2, 69));
        c0903bArr[1] = new C0903b(26, new C0904a(4, 43), new C0904a(1, 44));
        c0903bArr[2] = new C0903b(24, new C0904a(6, 19), new C0904a(2, 20));
        c0903bArr[3] = new C0903b(28, new C0904a(6, 15), new C0904a(2, 16));
        r0[9] = new C0902c(10, iArr, c0903bArr);
        iArr = new int[]{6, 30, 54};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(20, new C0904a(4, 81));
        c0903bArr[1] = new C0903b(30, new C0904a(1, 50), new C0904a(4, 51));
        c0903bArr[2] = new C0903b(28, new C0904a(4, 22), new C0904a(4, 23));
        c0903bArr[3] = new C0903b(24, new C0904a(3, 12), new C0904a(8, 13));
        r0[10] = new C0902c(11, iArr, c0903bArr);
        iArr = new int[]{6, 32, 58};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(24, new C0904a(2, 92), new C0904a(2, 93));
        c0903bArr[1] = new C0903b(22, new C0904a(6, 36), new C0904a(2, 37));
        c0903bArr[2] = new C0903b(26, new C0904a(4, 20), new C0904a(6, 21));
        c0903bArr[3] = new C0903b(28, new C0904a(7, 14), new C0904a(4, 15));
        r0[11] = new C0902c(12, iArr, c0903bArr);
        iArr = new int[]{6, 34, 62};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(26, new C0904a(4, 107));
        c0903bArr[1] = new C0903b(22, new C0904a(8, 37), new C0904a(1, 38));
        c0903bArr[2] = new C0903b(24, new C0904a(8, 20), new C0904a(4, 21));
        c0903bArr[3] = new C0903b(22, new C0904a(12, 11), new C0904a(4, 12));
        r0[12] = new C0902c(13, iArr, c0903bArr);
        iArr = new int[]{6, 26, 46, 66};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(3, 115), new C0904a(1, 116));
        c0903bArr[1] = new C0903b(24, new C0904a(4, 40), new C0904a(5, 41));
        c0903bArr[2] = new C0903b(20, new C0904a(11, 16), new C0904a(5, 17));
        c0903bArr[3] = new C0903b(24, new C0904a(11, 12), new C0904a(5, 13));
        r0[13] = new C0902c(14, iArr, c0903bArr);
        iArr = new int[]{6, 26, 48, 70};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(22, new C0904a(5, 87), new C0904a(1, 88));
        c0903bArr[1] = new C0903b(24, new C0904a(5, 41), new C0904a(5, 42));
        c0903bArr[2] = new C0903b(30, new C0904a(5, 24), new C0904a(7, 25));
        c0903bArr[3] = new C0903b(24, new C0904a(11, 12), new C0904a(7, 13));
        r0[14] = new C0902c(15, iArr, c0903bArr);
        iArr = new int[]{6, 26, 50, 74};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(24, new C0904a(5, 98), new C0904a(1, 99));
        c0903bArr[1] = new C0903b(28, new C0904a(7, 45), new C0904a(3, 46));
        c0903bArr[2] = new C0903b(24, new C0904a(15, 19), new C0904a(2, 20));
        c0903bArr[3] = new C0903b(30, new C0904a(3, 15), new C0904a(13, 16));
        r0[15] = new C0902c(16, iArr, c0903bArr);
        iArr = new int[]{6, 30, 54, 78};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(28, new C0904a(1, 107), new C0904a(5, 108));
        c0903bArr[1] = new C0903b(28, new C0904a(10, 46), new C0904a(1, 47));
        c0903bArr[2] = new C0903b(28, new C0904a(1, 22), new C0904a(15, 23));
        c0903bArr[3] = new C0903b(28, new C0904a(2, 14), new C0904a(17, 15));
        r0[16] = new C0902c(17, iArr, c0903bArr);
        iArr = new int[]{6, 30, 56, 82};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(5, 120), new C0904a(1, 121));
        c0903bArr[1] = new C0903b(26, new C0904a(9, 43), new C0904a(4, 44));
        c0903bArr[2] = new C0903b(28, new C0904a(17, 22), new C0904a(1, 23));
        c0903bArr[3] = new C0903b(28, new C0904a(2, 14), new C0904a(19, 15));
        r0[17] = new C0902c(18, iArr, c0903bArr);
        iArr = new int[]{6, 30, 58, 86};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(28, new C0904a(3, 113), new C0904a(4, 114));
        c0903bArr[1] = new C0903b(26, new C0904a(3, 44), new C0904a(11, 45));
        c0903bArr[2] = new C0903b(26, new C0904a(17, 21), new C0904a(4, 22));
        c0903bArr[3] = new C0903b(26, new C0904a(9, 13), new C0904a(16, 14));
        r0[18] = new C0902c(19, iArr, c0903bArr);
        iArr = new int[]{6, 34, 62, 90};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(28, new C0904a(3, 107), new C0904a(5, 108));
        c0903bArr[1] = new C0903b(26, new C0904a(3, 41), new C0904a(13, 42));
        c0903bArr[2] = new C0903b(30, new C0904a(15, 24), new C0904a(5, 25));
        c0903bArr[3] = new C0903b(28, new C0904a(15, 15), new C0904a(10, 16));
        r0[19] = new C0902c(20, iArr, c0903bArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(28, new C0904a(4, 116), new C0904a(4, C31128d.MIC_ALPHA_ADJUST_REAL));
        c0903bArr[1] = new C0903b(26, new C0904a(17, 42));
        c0903bArr[2] = new C0903b(28, new C0904a(17, 22), new C0904a(6, 23));
        c0903bArr[3] = new C0903b(30, new C0904a(19, 16), new C0904a(6, 17));
        r0[20] = new C0902c(21, iArr, c0903bArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(28, new C0904a(2, 111), new C0904a(7, 112));
        c0903bArr[1] = new C0903b(28, new C0904a(17, 46));
        c0903bArr[2] = new C0903b(30, new C0904a(7, 24), new C0904a(16, 25));
        c0903bArr[3] = new C0903b(24, new C0904a(34, 13));
        r0[21] = new C0902c(22, iArr, c0903bArr);
        iArr = new int[]{6, 30, 54, 78, 102};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(4, 121), new C0904a(5, 122));
        c0903bArr[1] = new C0903b(28, new C0904a(4, 47), new C0904a(14, 48));
        c0903bArr[2] = new C0903b(30, new C0904a(11, 24), new C0904a(14, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(16, 15), new C0904a(14, 16));
        r0[22] = new C0902c(23, iArr, c0903bArr);
        iArr = new int[]{6, 28, 54, 80, 106};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(6, C31128d.MIC_ALPHA_ADJUST_REAL), new C0904a(4, 118));
        c0903bArr[1] = new C0903b(28, new C0904a(6, 45), new C0904a(14, 46));
        c0903bArr[2] = new C0903b(30, new C0904a(11, 24), new C0904a(16, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(30, 16), new C0904a(2, 17));
        r0[23] = new C0902c(24, iArr, c0903bArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(26, new C0904a(8, 106), new C0904a(4, 107));
        c0903bArr[1] = new C0903b(28, new C0904a(8, 47), new C0904a(13, 48));
        c0903bArr[2] = new C0903b(30, new C0904a(7, 24), new C0904a(22, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(22, 15), new C0904a(13, 16));
        r0[24] = new C0902c(25, iArr, c0903bArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(28, new C0904a(10, 114), new C0904a(2, 115));
        c0903bArr[1] = new C0903b(28, new C0904a(19, 46), new C0904a(4, 47));
        c0903bArr[2] = new C0903b(28, new C0904a(28, 22), new C0904a(6, 23));
        c0903bArr[3] = new C0903b(30, new C0904a(33, 16), new C0904a(4, 17));
        r0[25] = new C0902c(26, iArr, c0903bArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(8, 122), new C0904a(4, 123));
        c0903bArr[1] = new C0903b(28, new C0904a(22, 45), new C0904a(3, 46));
        c0903bArr[2] = new C0903b(30, new C0904a(8, 23), new C0904a(26, 24));
        c0903bArr[3] = new C0903b(30, new C0904a(12, 15), new C0904a(28, 16));
        r0[26] = new C0902c(27, iArr, c0903bArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(3, C31128d.MIC_ALPHA_ADJUST_REAL), new C0904a(10, 118));
        c0903bArr[1] = new C0903b(28, new C0904a(3, 45), new C0904a(23, 46));
        c0903bArr[2] = new C0903b(30, new C0904a(4, 24), new C0904a(31, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(11, 15), new C0904a(31, 16));
        r0[27] = new C0902c(28, iArr, c0903bArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(7, 116), new C0904a(7, C31128d.MIC_ALPHA_ADJUST_REAL));
        c0903bArr[1] = new C0903b(28, new C0904a(21, 45), new C0904a(7, 46));
        c0903bArr[2] = new C0903b(30, new C0904a(1, 23), new C0904a(37, 24));
        c0903bArr[3] = new C0903b(30, new C0904a(19, 15), new C0904a(26, 16));
        r0[28] = new C0902c(29, iArr, c0903bArr);
        iArr = new int[]{6, 26, 52, 78, 104, 130};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(5, 115), new C0904a(10, 116));
        c0903bArr[1] = new C0903b(28, new C0904a(19, 47), new C0904a(10, 48));
        c0903bArr[2] = new C0903b(30, new C0904a(15, 24), new C0904a(25, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(23, 15), new C0904a(25, 16));
        r0[29] = new C0902c(30, iArr, c0903bArr);
        iArr = new int[]{6, 30, 56, 82, 108, C19392d.CTRL_INDEX};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(13, 115), new C0904a(3, 116));
        c0903bArr[1] = new C0903b(28, new C0904a(2, 46), new C0904a(29, 47));
        c0903bArr[2] = new C0903b(30, new C0904a(42, 24), new C0904a(1, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(23, 15), new C0904a(28, 16));
        r0[30] = new C0902c(31, iArr, c0903bArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(17, 115));
        c0903bArr[1] = new C0903b(28, new C0904a(10, 46), new C0904a(23, 47));
        c0903bArr[2] = new C0903b(30, new C0904a(10, 24), new C0904a(35, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(19, 15), new C0904a(35, 16));
        r0[31] = new C0902c(32, iArr, c0903bArr);
        iArr = new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(17, 115), new C0904a(1, 116));
        c0903bArr[1] = new C0903b(28, new C0904a(14, 46), new C0904a(21, 47));
        c0903bArr[2] = new C0903b(30, new C0904a(29, 24), new C0904a(19, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(11, 15), new C0904a(46, 16));
        r0[32] = new C0902c(33, iArr, c0903bArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(13, 115), new C0904a(6, 116));
        c0903bArr[1] = new C0903b(28, new C0904a(14, 46), new C0904a(23, 47));
        c0903bArr[2] = new C0903b(30, new C0904a(44, 24), new C0904a(7, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(59, 16), new C0904a(1, 17));
        r0[33] = new C0902c(34, iArr, c0903bArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126, 150};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(12, 121), new C0904a(7, 122));
        c0903bArr[1] = new C0903b(28, new C0904a(12, 47), new C0904a(26, 48));
        c0903bArr[2] = new C0903b(30, new C0904a(39, 24), new C0904a(14, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(22, 15), new C0904a(41, 16));
        r0[34] = new C0902c(35, iArr, c0903bArr);
        iArr = new int[]{6, 24, 50, 76, 102, 128, JsApiMakeVoIPCall.CTRL_INDEX};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(6, 121), new C0904a(14, 122));
        c0903bArr[1] = new C0903b(28, new C0904a(6, 47), new C0904a(34, 48));
        c0903bArr[2] = new C0903b(30, new C0904a(46, 24), new C0904a(10, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(2, 15), new C0904a(64, 16));
        r0[35] = new C0902c(36, iArr, c0903bArr);
        iArr = new int[]{6, 28, 54, 80, 106, 132, 158};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(17, 122), new C0904a(4, 123));
        c0903bArr[1] = new C0903b(28, new C0904a(29, 46), new C0904a(14, 47));
        c0903bArr[2] = new C0903b(30, new C0904a(49, 24), new C0904a(10, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(24, 15), new C0904a(46, 16));
        r0[36] = new C0902c(37, iArr, c0903bArr);
        iArr = new int[]{6, 32, 58, 84, 110, C19395n.CTRL_INDEX, ErrorCode.STARTDOWNLOAD_3};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(4, 122), new C0904a(18, 123));
        c0903bArr[1] = new C0903b(28, new C0904a(13, 46), new C0904a(32, 47));
        c0903bArr[2] = new C0903b(30, new C0904a(48, 24), new C0904a(14, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(42, 15), new C0904a(32, 16));
        r0[37] = new C0902c(38, iArr, c0903bArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(20, C31128d.MIC_ALPHA_ADJUST_REAL), new C0904a(4, 118));
        c0903bArr[1] = new C0903b(28, new C0904a(40, 47), new C0904a(7, 48));
        c0903bArr[2] = new C0903b(30, new C0904a(43, 24), new C0904a(22, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(10, 15), new C0904a(67, 16));
        r0[38] = new C0902c(39, iArr, c0903bArr);
        iArr = new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_TRUE};
        c0903bArr = new C0903b[4];
        c0903bArr[0] = new C0903b(30, new C0904a(19, 118), new C0904a(6, C31128d.MIC_AVROUND_BLUR));
        c0903bArr[1] = new C0903b(28, new C0904a(18, 47), new C0904a(31, 48));
        c0903bArr[2] = new C0903b(30, new C0904a(34, 24), new C0904a(34, 25));
        c0903bArr[3] = new C0903b(30, new C0904a(20, 15), new C0904a(61, 16));
        r0[39] = new C0902c(40, iArr, c0903bArr);
        AppMethodBeat.m2505o(57247);
        return r0;
    }
}

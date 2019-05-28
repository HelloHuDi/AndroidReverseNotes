package com.google.p114b.p117d;

import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.b.d.d */
public final class C0900d extends C45065o {

    /* renamed from: com.google.b.d.d$a */
    enum C0899a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1;

        static {
            AppMethodBeat.m2505o(57154);
        }
    }

    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57313);
        if (c37292a != C37292a.CODE_128) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57313);
            throw illegalArgumentException;
        }
        C45061b a = super.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57313);
        return a;
    }

    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        int i = 0;
        AppMethodBeat.m2504i(57314);
        int length = str.length();
        IllegalArgumentException illegalArgumentException;
        if (length <= 0 || length > 80) {
            illegalArgumentException = new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
            AppMethodBeat.m2505o(57314);
            throw illegalArgumentException;
        }
        int i2;
        for (i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case C31128d.MIC_PTU_QINGCONG /*241*/:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        illegalArgumentException = new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                        AppMethodBeat.m2505o(57314);
                        throw illegalArgumentException;
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i3 < length) {
            int c = C0900d.m2035c(str, i3, i4);
            if (c == i4) {
                switch (str.charAt(i3)) {
                    case C31128d.MIC_PTU_QINGCONG /*241*/:
                        i2 = 102;
                        break;
                    case 242:
                        i2 = 97;
                        break;
                    case 243:
                        i2 = 96;
                        break;
                    case 244:
                        i2 = 100;
                        break;
                    default:
                        if (i4 != 100) {
                            i2 = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3++;
                            break;
                        }
                        i2 = str.charAt(i3) - 32;
                        break;
                }
                i3++;
                c = i4;
            } else {
                i2 = i4 == 0 ? c == 100 ? 104 : 105 : c;
            }
            arrayList.add(C0898c.bAo[i2]);
            i6 += i2 * i5;
            if (i3 != 0) {
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            i4 = c;
            i5 = i2;
        }
        arrayList.add(C0898c.bAo[i6 % 103]);
        arrayList.add(C0898c.bAo[106]);
        int i7 = 0;
        for (int[] iArr : arrayList) {
            for (int i52 : (int[]) r3.next()) {
                i7 += i52;
            }
        }
        boolean[] zArr = new boolean[i7];
        for (int[] a : arrayList) {
            i += C45065o.m82688a(zArr, i, a, true);
        }
        AppMethodBeat.m2505o(57314);
        return zArr;
    }

    /* renamed from: d */
    private static C0899a m2036d(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(57315);
        int length = charSequence.length();
        C0899a c0899a;
        if (i >= length) {
            c0899a = C0899a.UNCODABLE;
            AppMethodBeat.m2505o(57315);
            return c0899a;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            c0899a = C0899a.FNC_1;
            AppMethodBeat.m2505o(57315);
            return c0899a;
        } else if (charAt < '0' || charAt > '9') {
            c0899a = C0899a.UNCODABLE;
            AppMethodBeat.m2505o(57315);
            return c0899a;
        } else if (i + 1 >= length) {
            c0899a = C0899a.ONE_DIGIT;
            AppMethodBeat.m2505o(57315);
            return c0899a;
        } else {
            char charAt2 = charSequence.charAt(i + 1);
            if (charAt2 < '0' || charAt2 > '9') {
                c0899a = C0899a.ONE_DIGIT;
                AppMethodBeat.m2505o(57315);
                return c0899a;
            }
            c0899a = C0899a.TWO_DIGITS;
            AppMethodBeat.m2505o(57315);
            return c0899a;
        }
    }

    /* renamed from: c */
    private static int m2035c(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.m2504i(57316);
        C0899a d = C0900d.m2036d(charSequence, i);
        if (d == C0899a.UNCODABLE || d == C0899a.ONE_DIGIT) {
            AppMethodBeat.m2505o(57316);
            return 100;
        } else if (i2 == 99) {
            AppMethodBeat.m2505o(57316);
            return i2;
        } else if (i2 != 100) {
            if (d == C0899a.FNC_1) {
                d = C0900d.m2036d(charSequence, i + 1);
            }
            if (d == C0899a.TWO_DIGITS) {
                AppMethodBeat.m2505o(57316);
                return 99;
            }
            AppMethodBeat.m2505o(57316);
            return 100;
        } else if (d == C0899a.FNC_1) {
            AppMethodBeat.m2505o(57316);
            return i2;
        } else {
            d = C0900d.m2036d(charSequence, i + 2);
            if (d == C0899a.UNCODABLE || d == C0899a.ONE_DIGIT) {
                AppMethodBeat.m2505o(57316);
                return i2;
            } else if (d != C0899a.FNC_1) {
                C0899a d2;
                int i3 = i + 4;
                while (true) {
                    d2 = C0900d.m2036d(charSequence, i3);
                    if (d2 != C0899a.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                if (d2 == C0899a.ONE_DIGIT) {
                    AppMethodBeat.m2505o(57316);
                    return 100;
                }
                AppMethodBeat.m2505o(57316);
                return 99;
            } else if (C0900d.m2036d(charSequence, i + 3) == C0899a.TWO_DIGITS) {
                AppMethodBeat.m2505o(57316);
                return 99;
            } else {
                AppMethodBeat.m2505o(57316);
                return 100;
            }
        }
    }
}

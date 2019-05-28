package com.google.b.d;

import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public final class d extends o {

    enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1;

        static {
            AppMethodBeat.o(57154);
        }
    }

    public final b a(String str, com.google.b.a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57313);
        if (aVar != com.google.b.a.CODE_128) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57313);
            throw illegalArgumentException;
        }
        b a = super.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57313);
        return a;
    }

    public final boolean[] bj(String str) {
        int i = 0;
        AppMethodBeat.i(57314);
        int length = str.length();
        IllegalArgumentException illegalArgumentException;
        if (length <= 0 || length > 80) {
            illegalArgumentException = new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(57314);
            throw illegalArgumentException;
        }
        int i2;
        for (i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case com.tencent.view.d.MIC_PTU_QINGCONG /*241*/:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        illegalArgumentException = new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                        AppMethodBeat.o(57314);
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
            int c = c(str, i3, i4);
            if (c == i4) {
                switch (str.charAt(i3)) {
                    case com.tencent.view.d.MIC_PTU_QINGCONG /*241*/:
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
            arrayList.add(c.bAo[i2]);
            i6 += i2 * i5;
            if (i3 != 0) {
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            i4 = c;
            i5 = i2;
        }
        arrayList.add(c.bAo[i6 % 103]);
        arrayList.add(c.bAo[106]);
        int i7 = 0;
        for (int[] iArr : arrayList) {
            for (int i52 : (int[]) r3.next()) {
                i7 += i52;
            }
        }
        boolean[] zArr = new boolean[i7];
        for (int[] a : arrayList) {
            i += o.a(zArr, i, a, true);
        }
        AppMethodBeat.o(57314);
        return zArr;
    }

    private static a d(CharSequence charSequence, int i) {
        AppMethodBeat.i(57315);
        int length = charSequence.length();
        a aVar;
        if (i >= length) {
            aVar = a.UNCODABLE;
            AppMethodBeat.o(57315);
            return aVar;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            aVar = a.FNC_1;
            AppMethodBeat.o(57315);
            return aVar;
        } else if (charAt < '0' || charAt > '9') {
            aVar = a.UNCODABLE;
            AppMethodBeat.o(57315);
            return aVar;
        } else if (i + 1 >= length) {
            aVar = a.ONE_DIGIT;
            AppMethodBeat.o(57315);
            return aVar;
        } else {
            char charAt2 = charSequence.charAt(i + 1);
            if (charAt2 < '0' || charAt2 > '9') {
                aVar = a.ONE_DIGIT;
                AppMethodBeat.o(57315);
                return aVar;
            }
            aVar = a.TWO_DIGITS;
            AppMethodBeat.o(57315);
            return aVar;
        }
    }

    private static int c(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.i(57316);
        a d = d(charSequence, i);
        if (d == a.UNCODABLE || d == a.ONE_DIGIT) {
            AppMethodBeat.o(57316);
            return 100;
        } else if (i2 == 99) {
            AppMethodBeat.o(57316);
            return i2;
        } else if (i2 != 100) {
            if (d == a.FNC_1) {
                d = d(charSequence, i + 1);
            }
            if (d == a.TWO_DIGITS) {
                AppMethodBeat.o(57316);
                return 99;
            }
            AppMethodBeat.o(57316);
            return 100;
        } else if (d == a.FNC_1) {
            AppMethodBeat.o(57316);
            return i2;
        } else {
            d = d(charSequence, i + 2);
            if (d == a.UNCODABLE || d == a.ONE_DIGIT) {
                AppMethodBeat.o(57316);
                return i2;
            } else if (d != a.FNC_1) {
                a d2;
                int i3 = i + 4;
                while (true) {
                    d2 = d(charSequence, i3);
                    if (d2 != a.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                if (d2 == a.ONE_DIGIT) {
                    AppMethodBeat.o(57316);
                    return 100;
                }
                AppMethodBeat.o(57316);
                return 99;
            } else if (d(charSequence, i + 3) == a.TWO_DIGITS) {
                AppMethodBeat.o(57316);
                return 99;
            } else {
                AppMethodBeat.o(57316);
                return 100;
            }
        }
    }
}

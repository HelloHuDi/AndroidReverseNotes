package com.google.p114b.p117d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p303d.C33289h.C33294a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C38339e;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.google.b.d.b */
public final class C0897b extends C45065o {
    private static final char[] bAk = new char[]{'A', 'B', 'C', 'D'};
    private static final char[] bAl = new char[]{'T', 'N', '*', 'E'};
    private static final char[] bAm = new char[]{IOUtils.DIR_SEPARATOR_UNIX, ':', '+', '.'};
    private static final char bAn = bAk[0];

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        AppMethodBeat.m2504i(57172);
        if (str.length() < 2) {
            str = bAn + str + bAn;
        } else {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            char toUpperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a = C37298a.m62702a(bAk, toUpperCase);
            boolean a2 = C37298a.m62702a(bAk, toUpperCase2);
            boolean a3 = C37298a.m62702a(bAl, toUpperCase);
            boolean a4 = C37298a.m62702a(bAl, toUpperCase2);
            IllegalArgumentException illegalArgumentException;
            if (a) {
                if (!a2) {
                    illegalArgumentException = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(57172);
                    throw illegalArgumentException;
                }
            } else if (a3) {
                if (!a4) {
                    illegalArgumentException = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(57172);
                    throw illegalArgumentException;
                }
            } else if (a2 || a4) {
                illegalArgumentException = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(57172);
                throw illegalArgumentException;
            } else {
                str = bAn + str + bAn;
            }
        }
        int i = 20;
        int i2 = 1;
        while (i2 < str.length() - 1) {
            if (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-' || str.charAt(i2) == '$') {
                i += 9;
            } else if (C37298a.m62702a(bAm, str.charAt(i2))) {
                i += 10;
            } else {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Cannot encode : '" + str.charAt(i2) + '\'');
                AppMethodBeat.m2505o(57172);
                throw illegalArgumentException2;
            }
            i2++;
        }
        boolean[] zArr = new boolean[((str.length() - 1) + i)];
        i2 = 0;
        i = 0;
        while (i2 < str.length()) {
            int i3;
            int i4;
            boolean z;
            int i5;
            char toUpperCase3 = Character.toUpperCase(str.charAt(i2));
            if (i2 == 0 || i2 == str.length() - 1) {
                switch (toUpperCase3) {
                    case '*':
                        toUpperCase3 = 'C';
                        break;
                    case 'E':
                        toUpperCase3 = 'D';
                        break;
                    case C33294a.CTRL_INDEX /*78*/:
                        toUpperCase3 = 'B';
                        break;
                    case C38339e.CTRL_INDEX /*84*/:
                        toUpperCase3 = 'A';
                        break;
                }
            }
            int i6 = 0;
            while (i6 < C37298a.bAh.length) {
                if (toUpperCase3 == C37298a.bAh[i6]) {
                    i3 = C37298a.bAi[i6];
                    i4 = 0;
                    z = true;
                    i6 = i;
                    i5 = 0;
                    while (i4 < 7) {
                        zArr[i6] = z;
                        i6++;
                        if (((i3 >> (6 - i4)) & 1) == 0 || i5 == 1) {
                            i4++;
                            z = !z;
                            i5 = 0;
                        } else {
                            i5++;
                        }
                    }
                    if (i2 >= str.length() - 1) {
                        zArr[i6] = false;
                        i = i6 + 1;
                    } else {
                        i = i6;
                    }
                    i2++;
                } else {
                    i6++;
                }
            }
            i3 = 0;
            i4 = 0;
            z = true;
            i6 = i;
            i5 = 0;
            while (i4 < 7) {
            }
            if (i2 >= str.length() - 1) {
            }
            i2++;
        }
        AppMethodBeat.m2505o(57172);
        return zArr;
    }
}

package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.util.d */
public final class C46823d {
    /* renamed from: cs */
    public static int m89056cs(byte[] bArr) {
        AppMethodBeat.m2504i(86578);
        if (bArr == null) {
            AppMethodBeat.m2505o(86578);
            return 0;
        }
        int i;
        int i2;
        int c;
        int i3 = 0;
        while (i3 + 3 < bArr.length) {
            i = i3 + 1;
            if ((bArr[i3] & 255) != 255) {
                i2 = 0;
                break;
            }
            i2 = bArr[i] & 255;
            if (i2 != 255) {
                i3 = i + 1;
                if (!(i2 == 216 || i2 == 1)) {
                    if (i2 != 217 && i2 != 218) {
                        c = C46823d.m89055c(bArr, i3, 2, false);
                        if (c >= 2 && i3 + c <= bArr.length) {
                            if (i2 == 225 && c >= 8 && C46823d.m89055c(bArr, i3 + 2, 4, false) == 1165519206 && C46823d.m89055c(bArr, i3 + 6, 2, false) == 0) {
                                i = i3 + 8;
                                i2 = c - 8;
                                break;
                            }
                            i3 += c;
                        } else {
                            C16371i.m25188m("CameraExif", "Invalid length");
                            AppMethodBeat.m2505o(86578);
                            return 0;
                        }
                    }
                    break;
                }
            }
            i3 = i;
        }
        i2 = 0;
        i = i3;
        if (i2 > 8) {
            i3 = C46823d.m89055c(bArr, i, 4, false);
            if (i3 == 1229531648 || i3 == 1296891946) {
                boolean z = i3 == 1229531648;
                int c2 = C46823d.m89055c(bArr, i + 4, 4, z) + 2;
                if (c2 >= 10 && c2 <= i2) {
                    c = i + c2;
                    c2 = i2 - c2;
                    i = C46823d.m89055c(bArr, c - 2, 2, z);
                    i2 = c2;
                    while (true) {
                        c2 = i - 1;
                        if (i <= 0 || i2 < 12) {
                            break;
                        } else if (C46823d.m89055c(bArr, c, 2, z) == 274) {
                            switch (C46823d.m89055c(bArr, c + 8, 2, z)) {
                                case 1:
                                    AppMethodBeat.m2505o(86578);
                                    return 0;
                                case 3:
                                    AppMethodBeat.m2505o(86578);
                                    return 180;
                                case 6:
                                    AppMethodBeat.m2505o(86578);
                                    return 90;
                                case 8:
                                    AppMethodBeat.m2505o(86578);
                                    return 270;
                                default:
                                    C16371i.m25185j("CameraExif", "Unsupported orientation");
                                    AppMethodBeat.m2505o(86578);
                                    return 0;
                            }
                        } else {
                            c += 12;
                            i2 -= 12;
                            i = c2;
                        }
                    }
                } else {
                    C16371i.m25188m("CameraExif", "Invalid offset");
                    AppMethodBeat.m2505o(86578);
                    return 0;
                }
            }
            C16371i.m25188m("CameraExif", "Invalid byte order");
            AppMethodBeat.m2505o(86578);
            return 0;
        }
        C16371i.m25185j("CameraExif", "Orientation not found");
        AppMethodBeat.m2505o(86578);
        return 0;
    }

    /* renamed from: c */
    private static int m89055c(byte[] bArr, int i, int i2, boolean z) {
        int i3 = 1;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (i4 << 8) | (bArr[i] & 255);
            i += i3;
            i2 = i5;
        }
    }
}

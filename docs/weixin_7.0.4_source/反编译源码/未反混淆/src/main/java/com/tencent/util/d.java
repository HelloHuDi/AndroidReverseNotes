package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static int cs(byte[] bArr) {
        AppMethodBeat.i(86578);
        if (bArr == null) {
            AppMethodBeat.o(86578);
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
                        c = c(bArr, i3, 2, false);
                        if (c >= 2 && i3 + c <= bArr.length) {
                            if (i2 == 225 && c >= 8 && c(bArr, i3 + 2, 4, false) == 1165519206 && c(bArr, i3 + 6, 2, false) == 0) {
                                i = i3 + 8;
                                i2 = c - 8;
                                break;
                            }
                            i3 += c;
                        } else {
                            i.m("CameraExif", "Invalid length");
                            AppMethodBeat.o(86578);
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
            i3 = c(bArr, i, 4, false);
            if (i3 == 1229531648 || i3 == 1296891946) {
                boolean z = i3 == 1229531648;
                int c2 = c(bArr, i + 4, 4, z) + 2;
                if (c2 >= 10 && c2 <= i2) {
                    c = i + c2;
                    c2 = i2 - c2;
                    i = c(bArr, c - 2, 2, z);
                    i2 = c2;
                    while (true) {
                        c2 = i - 1;
                        if (i <= 0 || i2 < 12) {
                            break;
                        } else if (c(bArr, c, 2, z) == 274) {
                            switch (c(bArr, c + 8, 2, z)) {
                                case 1:
                                    AppMethodBeat.o(86578);
                                    return 0;
                                case 3:
                                    AppMethodBeat.o(86578);
                                    return 180;
                                case 6:
                                    AppMethodBeat.o(86578);
                                    return 90;
                                case 8:
                                    AppMethodBeat.o(86578);
                                    return 270;
                                default:
                                    i.j("CameraExif", "Unsupported orientation");
                                    AppMethodBeat.o(86578);
                                    return 0;
                            }
                        } else {
                            c += 12;
                            i2 -= 12;
                            i = c2;
                        }
                    }
                } else {
                    i.m("CameraExif", "Invalid offset");
                    AppMethodBeat.o(86578);
                    return 0;
                }
            }
            i.m("CameraExif", "Invalid byte order");
            AppMethodBeat.o(86578);
            return 0;
        }
        i.j("CameraExif", "Orientation not found");
        AppMethodBeat.o(86578);
        return 0;
    }

    private static int c(byte[] bArr, int i, int i2, boolean z) {
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

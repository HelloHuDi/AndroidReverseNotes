package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class b {
    public static boolean ckT = false;

    public static void Dq() {
        AppMethodBeat.i(137008);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            ckT = true;
            AppMethodBeat.o(137008);
            return;
        }
        ckT = false;
        AppMethodBeat.o(137008);
    }

    public static byte[] b(int i, int i2, byte[] bArr) {
        int i3 = 0;
        AppMethodBeat.i(137009);
        if (i == i2) {
            AppMethodBeat.o(137009);
            return bArr;
        }
        int length = bArr.length;
        byte[] bArr2;
        int i4;
        switch (i) {
            case 1:
            case 3:
                switch (i2) {
                    case 2:
                        bArr2 = new byte[(length * 2)];
                        for (i4 = 0; i4 < length; i4++) {
                            byte[] bytes = a.getBytes((short) (bArr[i4] * 256), ckT);
                            bArr2[i4 * 2] = bytes[0];
                            bArr2[(i4 * 2) + 1] = bytes[1];
                        }
                        AppMethodBeat.o(137009);
                        return bArr2;
                }
                break;
            case 2:
                switch (i2) {
                    case 1:
                    case 3:
                        i4 = length / 2;
                        bArr2 = new byte[i4];
                        while (i3 < i4) {
                            bArr2[i3] = (byte) (a.a(bArr[i3 * 2], bArr[(i3 * 2) + 1], ckT) / 256);
                            i3++;
                        }
                        AppMethodBeat.o(137009);
                        return bArr2;
                }
                break;
        }
        AppMethodBeat.o(137009);
        return bArr;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(int i, int i2, int i3, byte[] bArr) {
        int i4 = 0;
        AppMethodBeat.i(137010);
        if (bArr == null) {
            AppMethodBeat.o(137010);
            return bArr;
        } else if (i == i2) {
            AppMethodBeat.o(137010);
            return bArr;
        } else {
            switch (i3) {
                case 1:
                case 2:
                case 3:
                    int length = bArr.length;
                    byte[] bArr2;
                    byte b;
                    switch (i) {
                        case 1:
                            switch (i2) {
                                case 2:
                                    bArr2 = new byte[(length * 2)];
                                    byte b2;
                                    switch (i3) {
                                        case 1:
                                        case 3:
                                            while (i4 < length) {
                                                b2 = bArr[i4];
                                                bArr2[i4 * 2] = b2;
                                                bArr2[(i4 * 2) + 1] = b2;
                                                i4++;
                                            }
                                            break;
                                        case 2:
                                            while (i4 < length) {
                                                b2 = bArr[i4];
                                                b = bArr[i4 + 1];
                                                bArr2[i4 * 2] = b2;
                                                bArr2[(i4 * 2) + 1] = b;
                                                bArr2[(i4 * 2) + 2] = b2;
                                                bArr2[(i4 * 2) + 3] = b;
                                                i4 += 2;
                                            }
                                            break;
                                    }
                                    AppMethodBeat.o(137010);
                                    return bArr2;
                            }
                            break;
                        case 2:
                            switch (i2) {
                                case 1:
                                    int i5 = length / 2;
                                    bArr2 = new byte[i5];
                                    switch (i3) {
                                        case 1:
                                        case 3:
                                            while (i4 < i5) {
                                                bArr2[i4] = (byte) (((short) (((short) bArr[i4 * 2]) + ((short) bArr[(i4 * 2) + 1]))) >> 1);
                                                i4 += 2;
                                            }
                                            break;
                                        case 2:
                                            for (length = 0; length < i5; length += 2) {
                                                b = bArr[length * 2];
                                                byte b3 = bArr[(length * 2) + 1];
                                                byte b4 = bArr[(length * 2) + 2];
                                                byte b5 = bArr[(length * 2) + 3];
                                                boolean z = ckT;
                                                byte[] bytes = a.getBytes((short) ((a.a(b, b3, z) / 2) + (a.a(b4, b5, z) / 2)), z);
                                                bArr2[length] = bytes[0];
                                                bArr2[length + 1] = bytes[1];
                                            }
                                            break;
                                    }
                                    AppMethodBeat.o(137010);
                                    return bArr2;
                            }
                            break;
                    }
                    AppMethodBeat.o(137010);
                    return bArr;
                default:
                    AppMethodBeat.o(137010);
                    return bArr;
            }
        }
    }

    public static void a(int i, byte[] bArr, byte[][] bArr2) {
        AppMethodBeat.i(137011);
        if (bArr2.length <= 1) {
            AppMethodBeat.o(137011);
            return;
        }
        int length = bArr.length / 2;
        Arrays.fill(bArr2[0], 0, bArr2[0].length, (byte) 0);
        Arrays.fill(bArr2[1], 0, bArr2[1].length, (byte) 0);
        int i2;
        switch (i) {
            case 1:
            case 3:
                i2 = 0;
                for (int i3 = 0; i3 < length; i3 += 2) {
                    bArr2[0][i2] = bArr[i3];
                    bArr2[1][i2] = bArr[i3 + 1];
                    i2++;
                }
                AppMethodBeat.o(137011);
                return;
            case 2:
                for (i2 = 0; i2 < length; i2 += 2) {
                    bArr2[0][i2] = bArr[i2 * 2];
                    bArr2[0][i2 + 1] = bArr[(i2 * 2) + 1];
                    bArr2[1][i2] = bArr[(i2 * 2) + 2];
                    bArr2[1][i2 + 1] = bArr[(i2 * 2) + 3];
                }
                break;
        }
        AppMethodBeat.o(137011);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(int i, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        int i2 = 0;
        AppMethodBeat.i(137012);
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray or sourceSecondByteArray is null");
            AppMethodBeat.o(137012);
        } else if (bArr.length != bArr2.length) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray and sourceSecondByteArray length is not same");
            AppMethodBeat.o(137012);
        } else {
            int length = bArr.length;
            bArr3 = new byte[(length * 2)];
            switch (i) {
                case 1:
                case 3:
                    while (i2 < length) {
                        bArr3[i2] = bArr[i2];
                        bArr3[i2 + 1] = bArr2[i2];
                        i2 += 2;
                    }
                    break;
                case 2:
                    while (i2 < length) {
                        bArr3[i2 * 2] = bArr[i2];
                        bArr3[(i2 * 2) + 1] = bArr[i2 + 1];
                        bArr3[(i2 * 2) + 2] = bArr2[i2];
                        bArr3[(i2 * 2) + 3] = bArr2[i2 + 1];
                        i2 += 2;
                    }
                    break;
            }
            AppMethodBeat.o(137012);
        }
        return bArr3;
    }
}

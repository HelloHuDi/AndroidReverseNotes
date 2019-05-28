package com.tencent.p177mm.audio.mix.p1183c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.tencent.mm.audio.mix.c.b */
public final class C41774b {
    public static boolean ckT = false;

    /* renamed from: Dq */
    public static void m73738Dq() {
        AppMethodBeat.m2504i(137008);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            ckT = true;
            AppMethodBeat.m2505o(137008);
            return;
        }
        ckT = false;
        AppMethodBeat.m2505o(137008);
    }

    /* renamed from: b */
    public static byte[] m73741b(int i, int i2, byte[] bArr) {
        int i3 = 0;
        AppMethodBeat.m2504i(137009);
        if (i == i2) {
            AppMethodBeat.m2505o(137009);
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
                            byte[] bytes = C41773a.getBytes((short) (bArr[i4] * 256), ckT);
                            bArr2[i4 * 2] = bytes[0];
                            bArr2[(i4 * 2) + 1] = bytes[1];
                        }
                        AppMethodBeat.m2505o(137009);
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
                            bArr2[i3] = (byte) (C41773a.m73736a(bArr[i3 * 2], bArr[(i3 * 2) + 1], ckT) / 256);
                            i3++;
                        }
                        AppMethodBeat.m2505o(137009);
                        return bArr2;
                }
                break;
        }
        AppMethodBeat.m2505o(137009);
        return bArr;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static byte[] m73742c(int i, int i2, int i3, byte[] bArr) {
        int i4 = 0;
        AppMethodBeat.m2504i(137010);
        if (bArr == null) {
            AppMethodBeat.m2505o(137010);
            return bArr;
        } else if (i == i2) {
            AppMethodBeat.m2505o(137010);
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
                                    AppMethodBeat.m2505o(137010);
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
                                                byte[] bytes = C41773a.getBytes((short) ((C41773a.m73736a(b, b3, z) / 2) + (C41773a.m73736a(b4, b5, z) / 2)), z);
                                                bArr2[length] = bytes[0];
                                                bArr2[length + 1] = bytes[1];
                                            }
                                            break;
                                    }
                                    AppMethodBeat.m2505o(137010);
                                    return bArr2;
                            }
                            break;
                    }
                    AppMethodBeat.m2505o(137010);
                    return bArr;
                default:
                    AppMethodBeat.m2505o(137010);
                    return bArr;
            }
        }
    }

    /* renamed from: a */
    public static void m73739a(int i, byte[] bArr, byte[][] bArr2) {
        AppMethodBeat.m2504i(137011);
        if (bArr2.length <= 1) {
            AppMethodBeat.m2505o(137011);
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
                AppMethodBeat.m2505o(137011);
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
        AppMethodBeat.m2505o(137011);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static byte[] m73740a(int i, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        int i2 = 0;
        AppMethodBeat.m2504i(137012);
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            C45174b.m83207e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray or sourceSecondByteArray is null");
            AppMethodBeat.m2505o(137012);
        } else if (bArr.length != bArr2.length) {
            C45174b.m83207e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray and sourceSecondByteArray length is not same");
            AppMethodBeat.m2505o(137012);
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
            AppMethodBeat.m2505o(137012);
        }
        return bArr3;
    }
}

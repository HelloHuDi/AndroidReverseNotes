package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class y {
    public static boolean C(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(121685);
        if (D(bArr, i, i2) == 0) {
            AppMethodBeat.o(121685);
            return true;
        }
        AppMethodBeat.o(121685);
        return false;
    }

    public static int D(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(121686);
        while (i < i2 && bArr[i] >= (byte) 0) {
            i++;
        }
        if (i >= i2) {
            AppMethodBeat.o(121686);
            return 0;
        }
        int E = E(bArr, i, i2);
        AppMethodBeat.o(121686);
        return E;
    }

    private static int E(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(121687);
        while (i < i2) {
            int i3 = i + 1;
            int i4 = bArr[i];
            if (i4 < 0) {
                int i5;
                byte b;
                if (i4 < -32) {
                    if (i3 >= i2) {
                        AppMethodBeat.o(121687);
                        return i4;
                    }
                    if (i4 >= -62) {
                        i4 = i3 + 1;
                        if (bArr[i3] > (byte) -65) {
                        }
                    }
                    AppMethodBeat.o(121687);
                    return -1;
                } else if (i4 < -16) {
                    if (i3 >= i2 - 1) {
                        i4 = F(bArr, i3, i2);
                        AppMethodBeat.o(121687);
                        return i4;
                    }
                    i5 = i3 + 1;
                    b = bArr[i3];
                    if (b <= (byte) -65 && ((i4 != -32 || b >= (byte) -96) && (i4 != -19 || b < (byte) -96))) {
                        i4 = i5 + 1;
                        if (bArr[i5] > (byte) -65) {
                        }
                    }
                    AppMethodBeat.o(121687);
                    return -1;
                } else if (i3 >= i2 - 2) {
                    i4 = F(bArr, i3, i2);
                    AppMethodBeat.o(121687);
                    return i4;
                } else {
                    i5 = i3 + 1;
                    b = bArr[i3];
                    if (b <= (byte) -65 && (((i4 << 28) + (b + 112)) >> 30) == 0) {
                        i3 = i5 + 1;
                        if (bArr[i5] <= (byte) -65) {
                            i4 = i3 + 1;
                            if (bArr[i3] > (byte) -65) {
                            }
                        }
                    }
                    AppMethodBeat.o(121687);
                    return -1;
                }
                i = i4;
            } else {
                i = i3;
            }
        }
        AppMethodBeat.o(121687);
        return 0;
    }

    private static int UH(int i) {
        return i > -12 ? -1 : i;
    }

    static int iq(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : (i2 << 8) ^ i;
    }

    static int aT(int i, int i2, int i3) {
        return (i > -12 || i2 > -65 || i3 > -65) ? -1 : ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    private static int F(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(121688);
        byte b = bArr[i - 1];
        int UH;
        switch (i2 - i) {
            case 0:
                UH = UH(b);
                AppMethodBeat.o(121688);
                return UH;
            case 1:
                UH = iq(b, bArr[i]);
                AppMethodBeat.o(121688);
                return UH;
            case 2:
                UH = aT(b, bArr[i], bArr[i + 1]);
                AppMethodBeat.o(121688);
                return UH;
            default:
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(121688);
                throw assertionError;
        }
    }
}

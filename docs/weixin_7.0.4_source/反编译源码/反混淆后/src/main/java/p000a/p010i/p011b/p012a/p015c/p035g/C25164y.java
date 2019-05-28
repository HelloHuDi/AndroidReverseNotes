package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: a.i.b.a.c.g.y */
final class C25164y {
    /* renamed from: C */
    public static boolean m39648C(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(121685);
        if (C25164y.m39649D(bArr, i, i2) == 0) {
            AppMethodBeat.m2505o(121685);
            return true;
        }
        AppMethodBeat.m2505o(121685);
        return false;
    }

    /* renamed from: D */
    public static int m39649D(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(121686);
        while (i < i2 && bArr[i] >= (byte) 0) {
            i++;
        }
        if (i >= i2) {
            AppMethodBeat.m2505o(121686);
            return 0;
        }
        int E = C25164y.m39650E(bArr, i, i2);
        AppMethodBeat.m2505o(121686);
        return E;
    }

    /* renamed from: E */
    private static int m39650E(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(121687);
        while (i < i2) {
            int i3 = i + 1;
            int i4 = bArr[i];
            if (i4 < 0) {
                int i5;
                byte b;
                if (i4 < -32) {
                    if (i3 >= i2) {
                        AppMethodBeat.m2505o(121687);
                        return i4;
                    }
                    if (i4 >= -62) {
                        i4 = i3 + 1;
                        if (bArr[i3] > (byte) -65) {
                        }
                    }
                    AppMethodBeat.m2505o(121687);
                    return -1;
                } else if (i4 < -16) {
                    if (i3 >= i2 - 1) {
                        i4 = C25164y.m39651F(bArr, i3, i2);
                        AppMethodBeat.m2505o(121687);
                        return i4;
                    }
                    i5 = i3 + 1;
                    b = bArr[i3];
                    if (b <= (byte) -65 && ((i4 != -32 || b >= (byte) -96) && (i4 != -19 || b < (byte) -96))) {
                        i4 = i5 + 1;
                        if (bArr[i5] > (byte) -65) {
                        }
                    }
                    AppMethodBeat.m2505o(121687);
                    return -1;
                } else if (i3 >= i2 - 2) {
                    i4 = C25164y.m39651F(bArr, i3, i2);
                    AppMethodBeat.m2505o(121687);
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
                    AppMethodBeat.m2505o(121687);
                    return -1;
                }
                i = i4;
            } else {
                i = i3;
            }
        }
        AppMethodBeat.m2505o(121687);
        return 0;
    }

    /* renamed from: UH */
    private static int m39652UH(int i) {
        return i > -12 ? -1 : i;
    }

    /* renamed from: iq */
    static int m39654iq(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : (i2 << 8) ^ i;
    }

    /* renamed from: aT */
    static int m39653aT(int i, int i2, int i3) {
        return (i > -12 || i2 > -65 || i3 > -65) ? -1 : ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    /* renamed from: F */
    private static int m39651F(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(121688);
        byte b = bArr[i - 1];
        int UH;
        switch (i2 - i) {
            case 0:
                UH = C25164y.m39652UH(b);
                AppMethodBeat.m2505o(121688);
                return UH;
            case 1:
                UH = C25164y.m39654iq(b, bArr[i]);
                AppMethodBeat.m2505o(121688);
                return UH;
            case 2:
                UH = C25164y.m39653aT(b, bArr[i], bArr[i + 1]);
                AppMethodBeat.m2505o(121688);
                return UH;
            default:
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(121688);
                throw assertionError;
        }
    }
}

package com.google.p114b.p115c.p116a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.p114b.C45062b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.util.Arrays;

/* renamed from: com.google.b.c.a.j */
public final class C32081j {
    /* renamed from: a */
    public static String m52191a(String str, C0895l c0895l, C45062b c45062b, C45062b c45062b2) {
        int i = 0;
        AppMethodBeat.m2504i(57320);
        C37295g[] c37295gArr = new C37295g[]{new C45063a(), new C25572c(), new C8731m(), new C0896n(), new C32080f(), new C8728b()};
        C45064h c45064h = new C45064h(str);
        c45064h.bzI = c0895l;
        c45064h.bzJ = c45062b;
        c45064h.bzK = c45062b2;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            c45064h.mo72829d(236);
            c45064h.bzO = 2;
            c45064h.pos += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            c45064h.mo72829d(237);
            c45064h.bzO = 2;
            c45064h.pos += 7;
        }
        while (c45064h.mo72834vy()) {
            c37295gArr[i].mo3684a(c45064h);
            if (c45064h.bzM >= 0) {
                i = c45064h.bzM;
                c45064h.bzM = -1;
            }
        }
        int length = c45064h.bzL.length();
        c45064h.mo72832vB();
        int i2 = c45064h.bzN.bzW;
        if (!(length >= i2 || i == 0 || i == 5)) {
            c45064h.mo72829d(254);
        }
        StringBuilder stringBuilder = c45064h.bzL;
        if (stringBuilder.length() < i2) {
            stringBuilder.append(129);
        }
        while (stringBuilder.length() < i2) {
            i = ((((stringBuilder.length() + 1) * 149) % C31128d.MIC_PTU_ZIPAI_OKINAWA) + 1) + GmsClientSupervisor.DEFAULT_BIND_FLAGS;
            if (i > C31128d.MIC_PTU_ZIPAI_LIGHTRED) {
                i -= 254;
            }
            stringBuilder.append((char) i);
        }
        String stringBuilder2 = c45064h.bzL.toString();
        AppMethodBeat.m2505o(57320);
        return stringBuilder2;
    }

    /* renamed from: b */
    static int m52192b(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.m2504i(57321);
        if (i >= charSequence.length()) {
            AppMethodBeat.m2505o(57321);
            return i2;
        }
        float[] fArr;
        int[] iArr;
        int i3;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i4 = 0;
        while (i + i4 != charSequence.length()) {
            int i5;
            char charAt = charSequence.charAt(i + i4);
            i4++;
            if (C32081j.isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (C32081j.m52193e(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (charAt == ' ' || ((charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z'))) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (C32081j.m52193e(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (charAt == ' ' || ((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z'))) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (C32081j.m52193e(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (C32081j.m52194f(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (C32081j.m52193e(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (charAt < ' ' || charAt > '^') {
                i5 = 0;
            } else {
                i5 = 1;
            }
            if (i5 != 0) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (C32081j.m52193e(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i4 >= 4) {
                iArr = new int[6];
                byte[] bArr = new byte[6];
                C32081j.m52190a(fArr, iArr, (int) BaseClientBuilder.API_PRIORITY_OTHER, bArr);
                int s = C32081j.m52197s(bArr);
                if (iArr[0] < iArr[5] && iArr[0] < iArr[1] && iArr[0] < iArr[2] && iArr[0] < iArr[3] && iArr[0] < iArr[4]) {
                    AppMethodBeat.m2505o(57321);
                    return 0;
                } else if (iArr[5] < iArr[0] || ((bArr[1] + bArr[2]) + bArr[3]) + bArr[4] == 0) {
                    AppMethodBeat.m2505o(57321);
                    return 5;
                } else if (s == 1 && bArr[4] > (byte) 0) {
                    AppMethodBeat.m2505o(57321);
                    return 4;
                } else if (s == 1 && bArr[2] > (byte) 0) {
                    AppMethodBeat.m2505o(57321);
                    return 2;
                } else if (s == 1 && bArr[3] > (byte) 0) {
                    AppMethodBeat.m2505o(57321);
                    return 3;
                } else if (iArr[1] + 1 < iArr[0] && iArr[1] + 1 < iArr[5] && iArr[1] + 1 < iArr[4] && iArr[1] + 1 < iArr[2]) {
                    if (iArr[1] < iArr[3]) {
                        AppMethodBeat.m2505o(57321);
                        return 1;
                    } else if (iArr[1] == iArr[3]) {
                        i3 = i + i4;
                        while (true) {
                            i3++;
                            if (i3 >= charSequence.length()) {
                                break;
                            }
                            char charAt2 = charSequence.charAt(i3);
                            if (!C32081j.m52195g(charAt2)) {
                                if (!C32081j.m52194f(charAt2)) {
                                    break;
                                }
                            } else {
                                AppMethodBeat.m2505o(57321);
                                return 3;
                            }
                        }
                        AppMethodBeat.m2505o(57321);
                        return 1;
                    }
                }
            }
        }
        byte[] bArr2 = new byte[6];
        iArr = new int[6];
        i3 = C32081j.m52190a(fArr, iArr, (int) BaseClientBuilder.API_PRIORITY_OTHER, bArr2);
        int s2 = C32081j.m52197s(bArr2);
        if (iArr[0] == i3) {
            AppMethodBeat.m2505o(57321);
            return 0;
        } else if (s2 == 1 && bArr2[5] > (byte) 0) {
            AppMethodBeat.m2505o(57321);
            return 5;
        } else if (s2 == 1 && bArr2[4] > (byte) 0) {
            AppMethodBeat.m2505o(57321);
            return 4;
        } else if (s2 == 1 && bArr2[2] > (byte) 0) {
            AppMethodBeat.m2505o(57321);
            return 2;
        } else if (s2 != 1 || bArr2[3] <= (byte) 0) {
            AppMethodBeat.m2505o(57321);
            return 1;
        } else {
            AppMethodBeat.m2505o(57321);
            return 3;
        }
    }

    /* renamed from: a */
    private static int m52190a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        AppMethodBeat.m2504i(57322);
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil((double) fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        AppMethodBeat.m2505o(57322);
        return i2;
    }

    /* renamed from: s */
    private static int m52197s(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 6) {
                return i3;
            }
            i = bArr[i2] + i3;
            i2++;
        }
    }

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: e */
    static boolean m52193e(char c) {
        return c >= 128 && c <= 255;
    }

    /* renamed from: f */
    private static boolean m52194f(char c) {
        AppMethodBeat.m2504i(57323);
        if (C32081j.m52195g(c) || c == ' ' || ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'))) {
            AppMethodBeat.m2505o(57323);
            return true;
        }
        AppMethodBeat.m2505o(57323);
        return false;
    }

    /* renamed from: g */
    private static boolean m52195g(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    /* renamed from: h */
    static void m52196h(char c) {
        AppMethodBeat.m2504i(57324);
        String toHexString = Integer.toHexString(c);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - toHexString.length()) + toHexString) + ')');
        AppMethodBeat.m2505o(57324);
        throw illegalArgumentException;
    }
}

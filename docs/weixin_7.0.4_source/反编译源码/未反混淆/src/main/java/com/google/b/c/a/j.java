package com.google.b.c.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.util.Arrays;

public final class j {
    public static String a(String str, l lVar, b bVar, b bVar2) {
        int i = 0;
        AppMethodBeat.i(57320);
        g[] gVarArr = new g[]{new a(), new c(), new m(), new n(), new f(), new b()};
        h hVar = new h(str);
        hVar.bzI = lVar;
        hVar.bzJ = bVar;
        hVar.bzK = bVar2;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.d(236);
            hVar.bzO = 2;
            hVar.pos += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.d(237);
            hVar.bzO = 2;
            hVar.pos += 7;
        }
        while (hVar.vy()) {
            gVarArr[i].a(hVar);
            if (hVar.bzM >= 0) {
                i = hVar.bzM;
                hVar.bzM = -1;
            }
        }
        int length = hVar.bzL.length();
        hVar.vB();
        int i2 = hVar.bzN.bzW;
        if (!(length >= i2 || i == 0 || i == 5)) {
            hVar.d(254);
        }
        StringBuilder stringBuilder = hVar.bzL;
        if (stringBuilder.length() < i2) {
            stringBuilder.append(129);
        }
        while (stringBuilder.length() < i2) {
            i = ((((stringBuilder.length() + 1) * 149) % d.MIC_PTU_ZIPAI_OKINAWA) + 1) + GmsClientSupervisor.DEFAULT_BIND_FLAGS;
            if (i > d.MIC_PTU_ZIPAI_LIGHTRED) {
                i -= 254;
            }
            stringBuilder.append((char) i);
        }
        String stringBuilder2 = hVar.bzL.toString();
        AppMethodBeat.o(57320);
        return stringBuilder2;
    }

    static int b(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.i(57321);
        if (i >= charSequence.length()) {
            AppMethodBeat.o(57321);
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
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (e(charAt)) {
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
            } else if (e(charAt)) {
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
            } else if (e(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (f(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (e(charAt)) {
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
            } else if (e(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i4 >= 4) {
                iArr = new int[6];
                byte[] bArr = new byte[6];
                a(fArr, iArr, (int) BaseClientBuilder.API_PRIORITY_OTHER, bArr);
                int s = s(bArr);
                if (iArr[0] < iArr[5] && iArr[0] < iArr[1] && iArr[0] < iArr[2] && iArr[0] < iArr[3] && iArr[0] < iArr[4]) {
                    AppMethodBeat.o(57321);
                    return 0;
                } else if (iArr[5] < iArr[0] || ((bArr[1] + bArr[2]) + bArr[3]) + bArr[4] == 0) {
                    AppMethodBeat.o(57321);
                    return 5;
                } else if (s == 1 && bArr[4] > (byte) 0) {
                    AppMethodBeat.o(57321);
                    return 4;
                } else if (s == 1 && bArr[2] > (byte) 0) {
                    AppMethodBeat.o(57321);
                    return 2;
                } else if (s == 1 && bArr[3] > (byte) 0) {
                    AppMethodBeat.o(57321);
                    return 3;
                } else if (iArr[1] + 1 < iArr[0] && iArr[1] + 1 < iArr[5] && iArr[1] + 1 < iArr[4] && iArr[1] + 1 < iArr[2]) {
                    if (iArr[1] < iArr[3]) {
                        AppMethodBeat.o(57321);
                        return 1;
                    } else if (iArr[1] == iArr[3]) {
                        i3 = i + i4;
                        while (true) {
                            i3++;
                            if (i3 >= charSequence.length()) {
                                break;
                            }
                            char charAt2 = charSequence.charAt(i3);
                            if (!g(charAt2)) {
                                if (!f(charAt2)) {
                                    break;
                                }
                            } else {
                                AppMethodBeat.o(57321);
                                return 3;
                            }
                        }
                        AppMethodBeat.o(57321);
                        return 1;
                    }
                }
            }
        }
        byte[] bArr2 = new byte[6];
        iArr = new int[6];
        i3 = a(fArr, iArr, (int) BaseClientBuilder.API_PRIORITY_OTHER, bArr2);
        int s2 = s(bArr2);
        if (iArr[0] == i3) {
            AppMethodBeat.o(57321);
            return 0;
        } else if (s2 == 1 && bArr2[5] > (byte) 0) {
            AppMethodBeat.o(57321);
            return 5;
        } else if (s2 == 1 && bArr2[4] > (byte) 0) {
            AppMethodBeat.o(57321);
            return 4;
        } else if (s2 == 1 && bArr2[2] > (byte) 0) {
            AppMethodBeat.o(57321);
            return 2;
        } else if (s2 != 1 || bArr2[3] <= (byte) 0) {
            AppMethodBeat.o(57321);
            return 1;
        } else {
            AppMethodBeat.o(57321);
            return 3;
        }
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        AppMethodBeat.i(57322);
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
        AppMethodBeat.o(57322);
        return i2;
    }

    private static int s(byte[] bArr) {
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

    static boolean e(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean f(char c) {
        AppMethodBeat.i(57323);
        if (g(c) || c == ' ' || ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'))) {
            AppMethodBeat.o(57323);
            return true;
        }
        AppMethodBeat.o(57323);
        return false;
    }

    private static boolean g(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    static void h(char c) {
        AppMethodBeat.i(57324);
        String toHexString = Integer.toHexString(c);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - toHexString.length()) + toHexString) + ')');
        AppMethodBeat.o(57324);
        throw illegalArgumentException;
    }
}

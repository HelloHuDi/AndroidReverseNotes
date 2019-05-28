package com.google.p114b.p118e.p119a;

import com.google.p114b.C37300h;
import com.google.p114b.p801b.C37294c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

/* renamed from: com.google.b.e.a.g */
final class C0901g {
    private static final byte[] bBa = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 38, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 35, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 43, (byte) 37, (byte) 42, (byte) 61, (byte) 94, (byte) 0, (byte) 32, (byte) 0, (byte) 0, (byte) 0};
    private static final byte[] bBb = new byte[]{(byte) 59, (byte) 60, (byte) 62, (byte) 64, (byte) 91, (byte) 92, (byte) 93, (byte) 95, (byte) 96, (byte) 126, (byte) 33, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 10, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 34, (byte) 124, (byte) 42, (byte) 40, (byte) 41, (byte) 63, (byte) 123, (byte) 125, (byte) 39, (byte) 0};
    private static final byte[] bBc = new byte[128];
    private static final byte[] bBd = new byte[128];
    private static final Charset bBe = Charset.forName("ISO-8859-1");

    static {
        int i = 0;
        AppMethodBeat.m2504i(57338);
        Arrays.fill(bBc, (byte) -1);
        for (int i2 = 0; i2 < bBa.length; i2++) {
            byte b = bBa[i2];
            if (b > (byte) 0) {
                bBc[b] = (byte) i2;
            }
        }
        Arrays.fill(bBd, (byte) -1);
        while (i < bBb.length) {
            byte b2 = bBb[i];
            if (b2 > (byte) 0) {
                bBd[b2] = (byte) i;
            }
            i++;
        }
        AppMethodBeat.m2505o(57338);
    }

    /* renamed from: a */
    static String m2041a(String str, C32087c c32087c, Charset charset) {
        int i;
        AppMethodBeat.m2504i(57331);
        StringBuilder stringBuilder = new StringBuilder(str.length());
        if (charset == null) {
            charset = bBe;
        } else if (!bBe.equals(charset)) {
            C37294c bh = C37294c.m62695bh(charset.name());
            if (bh != null) {
                i = bh.bzj[0];
                if (i >= 0 && i < TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR) {
                    stringBuilder.append(927);
                    stringBuilder.append((char) i);
                } else if (i < 810900) {
                    stringBuilder.append(926);
                    stringBuilder.append((char) ((i / TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR) - 1));
                    stringBuilder.append((char) (i % TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR));
                } else if (i < 811800) {
                    stringBuilder.append(925);
                    stringBuilder.append((char) (810900 - i));
                } else {
                    C37300h c37300h = new C37300h("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(57331);
                    throw c37300h;
                }
            }
        }
        int length = str.length();
        if (c32087c == C32087c.TEXT) {
            C0901g.m2039a(str, 0, length, stringBuilder, 0);
        } else if (c32087c == C32087c.BYTE) {
            byte[] bytes = str.getBytes(charset);
            C0901g.m2043a(bytes, bytes.length, 1, stringBuilder);
        } else if (c32087c == C32087c.NUMERIC) {
            stringBuilder.append(902);
            C0901g.m2042a(str, 0, length, stringBuilder);
        } else {
            i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int f = C0901g.m2044f(str, i2);
                if (f >= 13) {
                    stringBuilder.append(902);
                    i3 = 2;
                    C0901g.m2042a(str, i2, f, stringBuilder);
                    i = 0;
                    i2 = f + i2;
                } else {
                    int g = C0901g.m2045g(str, i2);
                    if (g >= 5 || f == length) {
                        if (i3 != 0) {
                            stringBuilder.append(900);
                            i = 0;
                            i3 = 0;
                        }
                        i = C0901g.m2039a(str, i2, g, stringBuilder, i);
                        i2 += g;
                    } else {
                        f = C0901g.m2040a(str, i2, charset);
                        if (f == 0) {
                            f = 1;
                        }
                        byte[] bytes2 = str.substring(i2, i2 + f).getBytes(charset);
                        if (bytes2.length == 1 && i3 == 0) {
                            C0901g.m2043a(bytes2, 1, 0, stringBuilder);
                        } else {
                            C0901g.m2043a(bytes2, bytes2.length, i3, stringBuilder);
                            i = 0;
                            i3 = 1;
                        }
                        i2 = f + i2;
                    }
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(57331);
        return stringBuilder2;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static int m2039a(CharSequence charSequence, int i, int i2, StringBuilder stringBuilder, int i3) {
        AppMethodBeat.m2504i(57332);
        StringBuilder stringBuilder2 = new StringBuilder(i2);
        int i4 = 0;
        while (true) {
            char charAt = charSequence.charAt(i + i4);
            switch (i3) {
                case 0:
                    if (C0901g.m2046i(charAt)) {
                        if (charAt == ' ') {
                            stringBuilder2.append(26);
                        } else {
                            stringBuilder2.append((char) (charAt - 65));
                        }
                    } else if (C0901g.m2047j(charAt)) {
                        stringBuilder2.append(27);
                        i3 = 1;
                        break;
                    } else if (C0901g.m2048k(charAt)) {
                        i3 = 2;
                        stringBuilder2.append(28);
                        break;
                    } else {
                        stringBuilder2.append(29);
                        stringBuilder2.append((char) bBd[charAt]);
                    }
                case 1:
                    if (C0901g.m2047j(charAt)) {
                        if (charAt == ' ') {
                            stringBuilder2.append(26);
                        } else {
                            stringBuilder2.append((char) (charAt - 97));
                        }
                    } else if (C0901g.m2046i(charAt)) {
                        stringBuilder2.append(27);
                        stringBuilder2.append((char) (charAt - 65));
                    } else if (C0901g.m2048k(charAt)) {
                        i3 = 2;
                        stringBuilder2.append(28);
                        break;
                    } else {
                        stringBuilder2.append(29);
                        stringBuilder2.append((char) bBd[charAt]);
                    }
                case 2:
                    if (!C0901g.m2048k(charAt)) {
                        if (!C0901g.m2046i(charAt)) {
                            if (!C0901g.m2047j(charAt)) {
                                if ((i + i4) + 1 < i2 && C0901g.m2049l(charSequence.charAt((i + i4) + 1))) {
                                    i3 = 3;
                                    stringBuilder2.append(25);
                                    break;
                                }
                                stringBuilder2.append(29);
                                stringBuilder2.append((char) bBd[charAt]);
                            } else {
                                stringBuilder2.append(27);
                                i3 = 1;
                                break;
                            }
                        }
                        stringBuilder2.append(28);
                        i3 = 0;
                        break;
                    }
                    stringBuilder2.append((char) bBc[charAt]);
                    break;
                default:
                    if (!C0901g.m2049l(charAt)) {
                        stringBuilder2.append(29);
                        i3 = 0;
                        break;
                    }
                    stringBuilder2.append((char) bBd[charAt]);
                    i4++;
                    if (i4 < i2) {
                        break;
                    }
                    int length = stringBuilder2.length();
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < length) {
                        char charAt2;
                        if ((i6 % 2 != 0 ? 1 : null) != null) {
                            charAt2 = (char) ((i5 * 30) + stringBuilder2.charAt(i6));
                            stringBuilder.append(charAt2);
                        } else {
                            charAt2 = stringBuilder2.charAt(i6);
                        }
                        i6++;
                        charAt = charAt2;
                    }
                    if (length % 2 != 0) {
                        stringBuilder.append((char) ((i5 * 30) + 29));
                    }
                    AppMethodBeat.m2505o(57332);
                    return i3;
            }
        }
    }

    /* renamed from: a */
    private static void m2043a(byte[] bArr, int i, int i2, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57333);
        if (i == 1 && i2 == 0) {
            stringBuilder.append(913);
        } else if (i % 6 == 0) {
            stringBuilder.append(924);
        } else {
            stringBuilder.append(901);
        }
        int i3 = 0;
        if (i >= 6) {
            char[] cArr = new char[5];
            while ((i + 0) - i3 >= 6) {
                int i4;
                long j = 0;
                for (i4 = 0; i4 < 6; i4++) {
                    j = (j << 8) + ((long) (bArr[i3 + i4] & 255));
                }
                for (i4 = 0; i4 < 5; i4++) {
                    cArr[i4] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (i4 = 4; i4 >= 0; i4--) {
                    stringBuilder.append(cArr[i4]);
                }
                i3 += 6;
            }
        }
        while (i3 < i + 0) {
            stringBuilder.append((char) (bArr[i3] & 255));
            i3++;
        }
        AppMethodBeat.m2505o(57333);
    }

    /* renamed from: a */
    private static void m2042a(String str, int i, int i2, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57334);
        StringBuilder stringBuilder2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            stringBuilder2.setLength(0);
            int min = Math.min(44, i2 - i3);
            BigInteger bigInteger = new BigInteger("1" + str.substring(i + i3, (i + i3) + min));
            do {
                stringBuilder2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = stringBuilder2.length() - 1; length >= 0; length--) {
                stringBuilder.append(stringBuilder2.charAt(length));
            }
            i3 += min;
        }
        AppMethodBeat.m2505o(57334);
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: i */
    private static boolean m2046i(char c) {
        return c == ' ' || (c >= 'A' && c <= 'Z');
    }

    /* renamed from: j */
    private static boolean m2047j(char c) {
        return c == ' ' || (c >= 'a' && c <= 'z');
    }

    /* renamed from: k */
    private static boolean m2048k(char c) {
        return bBc[c] != (byte) -1;
    }

    /* renamed from: l */
    private static boolean m2049l(char c) {
        return bBd[c] != (byte) -1;
    }

    /* renamed from: f */
    private static int m2044f(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(57335);
        int i2 = 0;
        int length = charSequence.length();
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (C0901g.isDigit(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        AppMethodBeat.m2505o(57335);
        return i2;
    }

    /* renamed from: g */
    private static int m2045g(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(57336);
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && C0901g.isDigit(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
            if (i3 >= 13) {
                i2 = (i2 - i) - i3;
                AppMethodBeat.m2505o(57336);
                return i2;
            } else if (i3 <= 0) {
                Object obj;
                char charAt2 = charSequence.charAt(i2);
                if (charAt2 == 9 || charAt2 == 10 || charAt2 == 13 || (charAt2 >= ' ' && charAt2 <= '~')) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    break;
                }
                i2++;
            }
        }
        i2 -= i;
        AppMethodBeat.m2505o(57336);
        return i2;
    }

    /* renamed from: a */
    private static int m2040a(String str, int i, Charset charset) {
        int i2;
        AppMethodBeat.m2504i(57337);
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = i;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            i2 = 0;
            while (i2 < 13 && C0901g.isDigit(charAt)) {
                i2++;
                int i4 = i3 + i2;
                if (i4 >= length) {
                    break;
                }
                charAt = str.charAt(i4);
            }
            if (i2 >= 13) {
                i2 = i3 - i;
                AppMethodBeat.m2505o(57337);
                return i2;
            }
            char charAt2 = str.charAt(i3);
            if (newEncoder.canEncode(charAt2)) {
                i3++;
            } else {
                C37300h c37300h = new C37300h("Non-encodable character detected: " + charAt2 + " (Unicode: " + charAt2 + ')');
                AppMethodBeat.m2505o(57337);
                throw c37300h;
            }
        }
        i2 = i3 - i;
        AppMethodBeat.m2505o(57337);
        return i2;
    }
}

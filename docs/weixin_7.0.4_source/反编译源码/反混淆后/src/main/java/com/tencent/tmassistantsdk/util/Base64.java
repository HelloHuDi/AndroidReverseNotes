package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = (!Base64.class.desiredAssertionStatus());
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static class Decoder extends Coder {
        private static final int[] DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i, byte[] bArr) {
            AppMethodBeat.m2504i(76213);
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
            AppMethodBeat.m2505o(76213);
        }

        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x0106 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0112  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0109  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            if (this.state == 6) {
                return false;
            }
            int i3 = i2 + i;
            int i4 = this.state;
            int i5 = this.value;
            int i6 = 0;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i7 = i;
            int i8 = i4;
            while (i7 < i3) {
                if (i8 == 0) {
                    while (i7 + 4 <= i3) {
                        i5 = (((iArr[bArr[i7] & 255] << 18) | (iArr[bArr[i7 + 1] & 255] << 12)) | (iArr[bArr[i7 + 2] & 255] << 6)) | iArr[bArr[i7 + 3] & 255];
                        if (i5 >= 0) {
                            bArr2[i6 + 2] = (byte) i5;
                            bArr2[i6 + 1] = (byte) (i5 >> 8);
                            bArr2[i6] = (byte) (i5 >> 16);
                            i6 += 3;
                            i7 += 4;
                        } else if (i7 >= i3) {
                            i7 = i5;
                            if (z) {
                                this.state = i8;
                                this.value = i7;
                                this.f3489op = i6;
                                return true;
                            }
                            switch (i8) {
                                case 1:
                                    this.state = 6;
                                    return false;
                                case 2:
                                    i5 = i6 + 1;
                                    bArr2[i6] = (byte) (i7 >> 4);
                                    i6 = i5;
                                    break;
                                case 3:
                                    i5 = i6 + 1;
                                    bArr2[i6] = (byte) (i7 >> 10);
                                    i6 = i5 + 1;
                                    bArr2[i5] = (byte) (i7 >> 2);
                                    break;
                                case 4:
                                    this.state = 6;
                                    return false;
                            }
                            this.state = i8;
                            this.f3489op = i6;
                            return true;
                        }
                    }
                    if (i7 >= i3) {
                    }
                }
                i = i7 + 1;
                i4 = iArr[bArr[i7] & 255];
                switch (i8) {
                    case 0:
                        if (i4 >= 0) {
                            i8++;
                            i5 = i4;
                            i7 = i;
                            continue;
                        } else if (i4 != -1) {
                            this.state = 6;
                            return false;
                        }
                    case 1:
                        if (i4 >= 0) {
                            i5 = (i5 << 6) | i4;
                            i7 = i;
                            i8++;
                            continue;
                        } else if (i4 != -1) {
                            this.state = 6;
                            return false;
                        }
                    case 2:
                        if (i4 >= 0) {
                            i5 = (i5 << 6) | i4;
                            i7 = i;
                            i8++;
                            continue;
                        } else if (i4 == -2) {
                            i4 = i6 + 1;
                            bArr2[i6] = (byte) (i5 >> 4);
                            i8 = 4;
                            i6 = i4;
                            i7 = i;
                            break;
                        } else if (i4 != -1) {
                            this.state = 6;
                            return false;
                        }
                    case 3:
                        if (i4 >= 0) {
                            i5 = (i5 << 6) | i4;
                            bArr2[i6 + 2] = (byte) i5;
                            bArr2[i6 + 1] = (byte) (i5 >> 8);
                            bArr2[i6] = (byte) (i5 >> 16);
                            i6 += 3;
                            i7 = i;
                            i8 = 0;
                            continue;
                        } else if (i4 == -2) {
                            bArr2[i6 + 1] = (byte) (i5 >> 2);
                            bArr2[i6] = (byte) (i5 >> 10);
                            i6 += 2;
                            i7 = i;
                            i8 = 5;
                            break;
                        } else if (i4 != -1) {
                            this.state = 6;
                            return false;
                        }
                    case 4:
                        if (i4 == -2) {
                            i7 = i;
                            i8++;
                            continue;
                        } else if (i4 != -1) {
                            this.state = 6;
                            return false;
                        }
                    case 5:
                        if (i4 != -1) {
                            this.state = 6;
                            return false;
                        }
                        i7 = i;
                        break;
                }
                i7 = i;
            }
            i7 = i5;
            if (z) {
            }
        }
    }

    static abstract class Coder {
        /* renamed from: op */
        public int f3489op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

        Coder() {
        }
    }

    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final byte[] ENCODE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] ENCODE_WEBSAFE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            boolean z;
            AppMethodBeat.m2504i(76216);
            if (Base64.class.desiredAssertionStatus()) {
                z = false;
            } else {
                z = true;
            }
            $assertionsDisabled = z;
            AppMethodBeat.m2505o(76216);
        }

        public Encoder(int i, byte[] bArr) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(76214);
            this.output = bArr;
            this.do_padding = (i & 1) == 0;
            if ((i & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.do_newline = z;
            if ((i & 4) == 0) {
                z2 = false;
            }
            this.do_cr = z2;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
            AppMethodBeat.m2505o(76214);
        }

        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            int i5;
            int i6;
            AppMethodBeat.m2504i(76215);
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i7 = 0;
            int i8 = this.count;
            int i9 = i2 + i;
            switch (this.tailLen) {
                case 0:
                    i3 = -1;
                    i4 = i;
                    break;
                case 1:
                    if (i + 2 <= i9) {
                        i4 = i + 1;
                        i = i4 + 1;
                        i5 = (((this.tail[0] & 255) << 16) | ((bArr[i] & 255) << 8)) | (bArr[i4] & 255);
                        this.tailLen = 0;
                        i3 = i5;
                        i4 = i;
                        break;
                    }
                case 2:
                    if (i + 1 <= i9) {
                        i4 = i + 1;
                        i5 = (((this.tail[0] & 255) << 16) | ((this.tail[1] & 255) << 8)) | (bArr[i] & 255);
                        this.tailLen = 0;
                        i3 = i5;
                        break;
                    }
                default:
                    i3 = -1;
                    i4 = i;
                    break;
            }
            if (i3 != -1) {
                bArr3[0] = bArr2[(i3 >> 18) & 63];
                bArr3[1] = bArr2[(i3 >> 12) & 63];
                bArr3[2] = bArr2[(i3 >> 6) & 63];
                i5 = 4;
                bArr3[3] = bArr2[i3 & 63];
                i8--;
                if (i8 == 0) {
                    if (this.do_cr) {
                        i5 = 5;
                        bArr3[4] = (byte) 13;
                    }
                    i7 = i5 + 1;
                    bArr3[i5] = (byte) 10;
                    i6 = 19;
                } else {
                    i6 = i8;
                    i7 = 4;
                }
            } else {
                i6 = i8;
            }
            while (i4 + 3 <= i9) {
                i5 = (((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8)) | (bArr[i4 + 2] & 255);
                bArr3[i7] = bArr2[(i5 >> 18) & 63];
                bArr3[i7 + 1] = bArr2[(i5 >> 12) & 63];
                bArr3[i7 + 2] = bArr2[(i5 >> 6) & 63];
                bArr3[i7 + 3] = bArr2[i5 & 63];
                i4 += 3;
                i8 = i7 + 4;
                i5 = i6 - 1;
                if (i5 == 0) {
                    if (this.do_cr) {
                        i5 = i8 + 1;
                        bArr3[i8] = (byte) 13;
                    } else {
                        i5 = i8;
                    }
                    i7 = i5 + 1;
                    bArr3[i5] = (byte) 10;
                    i6 = 19;
                } else {
                    i6 = i5;
                    i7 = i8;
                }
            }
            byte[] bArr4;
            if (z) {
                if (i4 - this.tailLen == i9 - 1) {
                    i3 = 0;
                    if (this.tailLen > 0) {
                        i3 = 1;
                        i5 = this.tail[0];
                        i8 = i4;
                    } else {
                        i8 = i4 + 1;
                        i5 = bArr[i4];
                    }
                    i4 = (i5 & 255) << 4;
                    this.tailLen -= i3;
                    i3 = i7 + 1;
                    bArr3[i7] = bArr2[(i4 >> 6) & 63];
                    i5 = i3 + 1;
                    bArr3[i3] = bArr2[i4 & 63];
                    if (this.do_padding) {
                        i4 = i5 + 1;
                        bArr3[i5] = (byte) 61;
                        i5 = i4 + 1;
                        bArr3[i4] = (byte) 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            i4 = i5 + 1;
                            bArr3[i5] = (byte) 13;
                            i5 = i4;
                        }
                        i4 = i5 + 1;
                        bArr3[i5] = (byte) 10;
                        i5 = i4;
                    }
                    i4 = i8;
                    i7 = i5;
                } else if (i4 - this.tailLen == i9 - 2) {
                    i3 = 0;
                    if (this.tailLen > 1) {
                        i5 = this.tail[0];
                        i3 = 1;
                    } else {
                        i8 = i4 + 1;
                        i5 = bArr[i4];
                        i4 = i8;
                    }
                    int i10 = (i5 & 255) << 10;
                    if (this.tailLen > 0) {
                        i8 = i3 + 1;
                        i5 = this.tail[i3];
                        i3 = i8;
                    } else {
                        i8 = i4 + 1;
                        i5 = bArr[i4];
                        i4 = i8;
                    }
                    i5 = ((i5 & 255) << 2) | i10;
                    this.tailLen -= i3;
                    i8 = i7 + 1;
                    bArr3[i7] = bArr2[(i5 >> 12) & 63];
                    i3 = i8 + 1;
                    bArr3[i8] = bArr2[(i5 >> 6) & 63];
                    i8 = i3 + 1;
                    bArr3[i3] = bArr2[i5 & 63];
                    if (this.do_padding) {
                        i5 = i8 + 1;
                        bArr3[i8] = (byte) 61;
                    } else {
                        i5 = i8;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            i8 = i5 + 1;
                            bArr3[i5] = (byte) 13;
                            i5 = i8;
                        }
                        i8 = i5 + 1;
                        bArr3[i5] = (byte) 10;
                        i5 = i8;
                    }
                    i7 = i5;
                } else if (this.do_newline && i7 > 0 && i6 != 19) {
                    if (this.do_cr) {
                        i5 = i7 + 1;
                        bArr3[i7] = (byte) 13;
                    } else {
                        i5 = i7;
                    }
                    i7 = i5 + 1;
                    bArr3[i5] = (byte) 10;
                }
                AssertionError assertionError;
                if (!$assertionsDisabled && this.tailLen != 0) {
                    assertionError = new AssertionError();
                    AppMethodBeat.m2505o(76215);
                    throw assertionError;
                } else if (!($assertionsDisabled || r2 == i9)) {
                    assertionError = new AssertionError();
                    AppMethodBeat.m2505o(76215);
                    throw assertionError;
                }
            } else if (i4 == i9 - 1) {
                bArr4 = this.tail;
                i8 = this.tailLen;
                this.tailLen = i8 + 1;
                bArr4[i8] = bArr[i4];
            } else if (i4 == i9 - 2) {
                bArr4 = this.tail;
                i8 = this.tailLen;
                this.tailLen = i8 + 1;
                bArr4[i8] = bArr[i4];
                bArr4 = this.tail;
                i8 = this.tailLen;
                this.tailLen = i8 + 1;
                bArr4[i8] = bArr[i4 + 1];
            }
            this.f3489op = i7;
            this.count = i6;
            AppMethodBeat.m2505o(76215);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(76223);
        AppMethodBeat.m2505o(76223);
    }

    public static byte[] decode(String str, int i) {
        AppMethodBeat.m2504i(76217);
        byte[] decode = decode(str.getBytes(), i);
        AppMethodBeat.m2505o(76217);
        return decode;
    }

    public static byte[] decode(byte[] bArr, int i) {
        AppMethodBeat.m2504i(76218);
        byte[] decode = decode(bArr, 0, bArr.length, i);
        AppMethodBeat.m2505o(76218);
        return decode;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(76219);
        Decoder decoder = new Decoder(i3, new byte[((i2 * 3) / 4)]);
        byte[] bArr2;
        if (!decoder.process(bArr, i, i2, true)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bad base-64");
            AppMethodBeat.m2505o(76219);
            throw illegalArgumentException;
        } else if (decoder.f3489op == decoder.output.length) {
            bArr2 = decoder.output;
            AppMethodBeat.m2505o(76219);
            return bArr2;
        } else {
            bArr2 = new byte[decoder.f3489op];
            System.arraycopy(decoder.output, 0, bArr2, 0, decoder.f3489op);
            AppMethodBeat.m2505o(76219);
            return bArr2;
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        AppMethodBeat.m2504i(76220);
        try {
            String str = new String(encode(bArr, i), "US-ASCII");
            AppMethodBeat.m2505o(76220);
            return str;
        } catch (UnsupportedEncodingException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.m2505o(76220);
            throw assertionError;
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        AppMethodBeat.m2504i(76221);
        byte[] encode = encode(bArr, 0, bArr.length, i);
        AppMethodBeat.m2505o(76221);
        return encode;
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(76222);
        Encoder encoder = new Encoder(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!encoder.do_padding) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            int i5;
            int i6 = ((i2 - 1) / 57) + 1;
            if (encoder.do_cr) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            i4 += i5 * i6;
        }
        encoder.output = new byte[i4];
        encoder.process(bArr, i, i2, true);
        if ($assertionsDisabled || encoder.f3489op == i4) {
            byte[] bArr2 = encoder.output;
            AppMethodBeat.m2505o(76222);
            return bArr2;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(76222);
        throw assertionError;
    }

    private Base64() {
    }
}

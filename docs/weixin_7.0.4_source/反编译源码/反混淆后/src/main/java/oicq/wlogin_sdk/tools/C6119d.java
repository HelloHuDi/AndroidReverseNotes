package oicq.wlogin_sdk.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

/* renamed from: oicq.wlogin_sdk.tools.d */
public final class C6119d {
    /* renamed from: a */
    public static byte[] m9652a(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        byte[] bArr3;
        int i3;
        AppMethodBeat.m2504i(96557);
        byte[] bArr4 = new byte[i];
        System.arraycopy(bArr, 0, bArr4, 0, i);
        C6116a c6116a = new C6116a();
        int length = bArr4.length;
        c6116a.plain = new byte[8];
        c6116a.prePlain = new byte[8];
        c6116a.pos = 1;
        c6116a.padding = 0;
        c6116a.preCrypt = 0;
        c6116a.crypt = 0;
        c6116a.key = bArr2;
        c6116a.header = true;
        c6116a.pos = (length + 10) % 8;
        if (c6116a.pos != 0) {
            c6116a.pos = 8 - c6116a.pos;
        }
        c6116a.out = new byte[((c6116a.pos + length) + 10)];
        c6116a.plain[0] = (byte) ((c6116a.random.nextInt() & C31128d.MIC_PTU_ZIPAI_THURSDAY) | c6116a.pos);
        for (i2 = 1; i2 <= c6116a.pos; i2++) {
            c6116a.plain[i2] = (byte) (c6116a.random.nextInt() & 255);
        }
        c6116a.pos++;
        for (i2 = 0; i2 < 8; i2++) {
            c6116a.prePlain[i2] = (byte) 0;
        }
        c6116a.padding = 1;
        while (c6116a.padding <= 2) {
            if (c6116a.pos < 8) {
                bArr3 = c6116a.plain;
                i3 = c6116a.pos;
                c6116a.pos = i3 + 1;
                bArr3[i3] = (byte) (c6116a.random.nextInt() & 255);
                c6116a.padding++;
            }
            if (c6116a.pos == 8) {
                c6116a.encrypt8Bytes();
            }
        }
        i3 = 0;
        while (length > 0) {
            if (c6116a.pos < 8) {
                byte[] bArr5 = c6116a.plain;
                int i4 = c6116a.pos;
                c6116a.pos = i4 + 1;
                i2 = i3 + 1;
                bArr5[i4] = bArr4[i3];
                length--;
            } else {
                i2 = i3;
            }
            if (c6116a.pos == 8) {
                c6116a.encrypt8Bytes();
            }
            i3 = i2;
        }
        c6116a.padding = 1;
        while (c6116a.padding <= 7) {
            if (c6116a.pos < 8) {
                bArr3 = c6116a.plain;
                int i5 = c6116a.pos;
                c6116a.pos = i5 + 1;
                bArr3[i5] = (byte) 0;
                c6116a.padding++;
            }
            if (c6116a.pos == 8) {
                c6116a.encrypt8Bytes();
            }
        }
        bArr3 = c6116a.out;
        AppMethodBeat.m2505o(96557);
        return bArr3;
    }

    public static byte[] decrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        AppMethodBeat.m2504i(96558);
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, i, bArr3, 0, i2);
        C6116a c6116a = new C6116a();
        int length = bArr3.length;
        c6116a.preCrypt = 0;
        c6116a.crypt = 0;
        c6116a.key = bArr2;
        byte[] bArr4 = new byte[8];
        if (length % 8 != 0 || length < 16) {
            AppMethodBeat.m2505o(96558);
            return null;
        }
        c6116a.prePlain = c6116a.mo13554am(bArr3);
        c6116a.pos = c6116a.prePlain[0] & 7;
        int i3 = (length - c6116a.pos) - 10;
        if (i3 < 0) {
            AppMethodBeat.m2505o(96558);
            return null;
        }
        int i4;
        for (i4 = 0; i4 < 8; i4++) {
            bArr4[i4] = (byte) 0;
        }
        c6116a.out = new byte[i3];
        c6116a.preCrypt = 0;
        c6116a.crypt = 8;
        c6116a.contextStart = 8;
        c6116a.pos++;
        c6116a.padding = 1;
        while (c6116a.padding <= 2) {
            if (c6116a.pos < 8) {
                c6116a.pos++;
                c6116a.padding++;
            }
            if (c6116a.pos == 8) {
                if (c6116a.mo13553F(bArr3, length)) {
                    bArr4 = bArr3;
                } else {
                    AppMethodBeat.m2505o(96558);
                    return null;
                }
            }
        }
        i4 = 0;
        byte[] bArr5 = bArr4;
        while (i3 != 0) {
            int i5;
            if (c6116a.pos < 8) {
                c6116a.out[i4] = (byte) (bArr5[(c6116a.preCrypt + 0) + c6116a.pos] ^ c6116a.prePlain[c6116a.pos]);
                i5 = i4 + 1;
                i4 = i3 - 1;
                c6116a.pos++;
                i3 = i4;
            } else {
                i5 = i4;
            }
            if (c6116a.pos == 8) {
                c6116a.preCrypt = c6116a.crypt - 8;
                if (c6116a.mo13553F(bArr3, length)) {
                    i4 = i5;
                    bArr5 = bArr3;
                } else {
                    AppMethodBeat.m2505o(96558);
                    return null;
                }
            }
            i4 = i5;
        }
        c6116a.padding = 1;
        bArr4 = bArr5;
        while (c6116a.padding < 8) {
            if (c6116a.pos < 8) {
                if ((bArr4[(c6116a.preCrypt + 0) + c6116a.pos] ^ c6116a.prePlain[c6116a.pos]) != 0) {
                    AppMethodBeat.m2505o(96558);
                    return null;
                }
                c6116a.pos++;
            }
            if (c6116a.pos == 8) {
                c6116a.preCrypt = c6116a.crypt;
                if (c6116a.mo13553F(bArr3, length)) {
                    bArr4 = bArr3;
                } else {
                    AppMethodBeat.m2505o(96558);
                    return null;
                }
            }
            c6116a.padding++;
        }
        bArr4 = c6116a.out;
        AppMethodBeat.m2505o(96558);
        return bArr4;
    }
}

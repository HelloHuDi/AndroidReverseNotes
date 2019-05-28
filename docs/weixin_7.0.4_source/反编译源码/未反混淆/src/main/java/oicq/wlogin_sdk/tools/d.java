package oicq.wlogin_sdk.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static byte[] a(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        byte[] bArr3;
        int i3;
        AppMethodBeat.i(96557);
        byte[] bArr4 = new byte[i];
        System.arraycopy(bArr, 0, bArr4, 0, i);
        a aVar = new a();
        int length = bArr4.length;
        aVar.plain = new byte[8];
        aVar.prePlain = new byte[8];
        aVar.pos = 1;
        aVar.padding = 0;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        aVar.header = true;
        aVar.pos = (length + 10) % 8;
        if (aVar.pos != 0) {
            aVar.pos = 8 - aVar.pos;
        }
        aVar.out = new byte[((aVar.pos + length) + 10)];
        aVar.plain[0] = (byte) ((aVar.random.nextInt() & com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY) | aVar.pos);
        for (i2 = 1; i2 <= aVar.pos; i2++) {
            aVar.plain[i2] = (byte) (aVar.random.nextInt() & 255);
        }
        aVar.pos++;
        for (i2 = 0; i2 < 8; i2++) {
            aVar.prePlain[i2] = (byte) 0;
        }
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                bArr3 = aVar.plain;
                i3 = aVar.pos;
                aVar.pos = i3 + 1;
                bArr3[i3] = (byte) (aVar.random.nextInt() & 255);
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        i3 = 0;
        while (length > 0) {
            if (aVar.pos < 8) {
                byte[] bArr5 = aVar.plain;
                int i4 = aVar.pos;
                aVar.pos = i4 + 1;
                i2 = i3 + 1;
                bArr5[i4] = bArr4[i3];
                length--;
            } else {
                i2 = i3;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
            i3 = i2;
        }
        aVar.padding = 1;
        while (aVar.padding <= 7) {
            if (aVar.pos < 8) {
                bArr3 = aVar.plain;
                int i5 = aVar.pos;
                aVar.pos = i5 + 1;
                bArr3[i5] = (byte) 0;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        bArr3 = aVar.out;
        AppMethodBeat.o(96557);
        return bArr3;
    }

    public static byte[] decrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        AppMethodBeat.i(96558);
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, i, bArr3, 0, i2);
        a aVar = new a();
        int length = bArr3.length;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        byte[] bArr4 = new byte[8];
        if (length % 8 != 0 || length < 16) {
            AppMethodBeat.o(96558);
            return null;
        }
        aVar.prePlain = aVar.am(bArr3);
        aVar.pos = aVar.prePlain[0] & 7;
        int i3 = (length - aVar.pos) - 10;
        if (i3 < 0) {
            AppMethodBeat.o(96558);
            return null;
        }
        int i4;
        for (i4 = 0; i4 < 8; i4++) {
            bArr4[i4] = (byte) 0;
        }
        aVar.out = new byte[i3];
        aVar.preCrypt = 0;
        aVar.crypt = 8;
        aVar.contextStart = 8;
        aVar.pos++;
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                aVar.pos++;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                if (aVar.F(bArr3, length)) {
                    bArr4 = bArr3;
                } else {
                    AppMethodBeat.o(96558);
                    return null;
                }
            }
        }
        i4 = 0;
        byte[] bArr5 = bArr4;
        while (i3 != 0) {
            int i5;
            if (aVar.pos < 8) {
                aVar.out[i4] = (byte) (bArr5[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]);
                i5 = i4 + 1;
                i4 = i3 - 1;
                aVar.pos++;
                i3 = i4;
            } else {
                i5 = i4;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt - 8;
                if (aVar.F(bArr3, length)) {
                    i4 = i5;
                    bArr5 = bArr3;
                } else {
                    AppMethodBeat.o(96558);
                    return null;
                }
            }
            i4 = i5;
        }
        aVar.padding = 1;
        bArr4 = bArr5;
        while (aVar.padding < 8) {
            if (aVar.pos < 8) {
                if ((bArr4[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]) != 0) {
                    AppMethodBeat.o(96558);
                    return null;
                }
                aVar.pos++;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt;
                if (aVar.F(bArr3, length)) {
                    bArr4 = bArr3;
                } else {
                    AppMethodBeat.o(96558);
                    return null;
                }
            }
            aVar.padding++;
        }
        bArr4 = aVar.out;
        AppMethodBeat.o(96558);
        return bArr4;
    }
}

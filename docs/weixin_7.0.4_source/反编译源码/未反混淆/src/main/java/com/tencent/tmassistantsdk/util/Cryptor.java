package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Cryptor {
    protected int contextStart;
    protected int crypt;
    protected boolean header = true;
    protected byte[] key;
    protected byte[] out;
    protected int padding;
    protected byte[] plain;
    protected int pos;
    protected int preCrypt;
    protected byte[] prePlain;
    protected Random random = new Random();

    public Cryptor() {
        AppMethodBeat.i(76224);
        AppMethodBeat.o(76224);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(76225);
        byte[] decrypt = decrypt(bArr, 0, bArr.length, bArr2);
        AppMethodBeat.o(76225);
        return decrypt;
    }

    public byte[] decrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        AppMethodBeat.i(76226);
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        byte[] bArr3 = new byte[(i + 8)];
        if (i2 % 8 != 0 || i2 < 16) {
            AppMethodBeat.o(76226);
            return null;
        }
        this.prePlain = decipher(bArr, i);
        this.pos = this.prePlain[0] & 7;
        int i3 = (i2 - this.pos) - 10;
        if (i3 < 0) {
            AppMethodBeat.o(76226);
            return null;
        }
        int i4;
        for (i4 = i; i4 < bArr3.length; i4++) {
            bArr3[i4] = (byte) 0;
        }
        this.out = new byte[i3];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        byte[] bArr4 = bArr3;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                this.pos++;
                this.padding++;
            }
            if (this.pos == 8) {
                if (decrypt8Bytes(bArr, i, i2)) {
                    bArr4 = bArr;
                } else {
                    AppMethodBeat.o(76226);
                    return null;
                }
            }
        }
        int i5 = 0;
        byte[] bArr5 = bArr4;
        while (i3 != 0) {
            if (this.pos < 8) {
                this.out[i5] = (byte) (bArr5[(this.preCrypt + i) + this.pos] ^ this.prePlain[this.pos]);
                i4 = i5 + 1;
                i5 = i3 - 1;
                this.pos++;
                i3 = i5;
            } else {
                i4 = i5;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt - 8;
                if (decrypt8Bytes(bArr, i, i2)) {
                    i5 = i4;
                    bArr5 = bArr;
                } else {
                    AppMethodBeat.o(76226);
                    return null;
                }
            }
            i5 = i4;
        }
        this.padding = 1;
        bArr4 = bArr5;
        while (this.padding < 8) {
            if (this.pos < 8) {
                if ((bArr4[(this.preCrypt + i) + this.pos] ^ this.prePlain[this.pos]) != 0) {
                    AppMethodBeat.o(76226);
                    return null;
                }
                this.pos++;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt;
                if (decrypt8Bytes(bArr, i, i2)) {
                    bArr4 = bArr;
                } else {
                    AppMethodBeat.o(76226);
                    return null;
                }
            }
            this.padding++;
        }
        bArr4 = this.out;
        AppMethodBeat.o(76226);
        return bArr4;
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(76227);
        byte[] encrypt = encrypt(bArr, 0, bArr.length, bArr2);
        AppMethodBeat.o(76227);
        return encrypt;
    }

    public byte[] encrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        byte[] bArr3;
        int i4;
        AppMethodBeat.i(76228);
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        this.header = true;
        this.pos = (i2 + 10) % 8;
        if (this.pos != 0) {
            this.pos = 8 - this.pos;
        }
        this.out = new byte[((this.pos + i2) + 10)];
        this.plain[0] = (byte) ((rand() & d.MIC_PTU_ZIPAI_THURSDAY) | this.pos);
        for (i3 = 1; i3 <= this.pos; i3++) {
            this.plain[i3] = (byte) (rand() & 255);
        }
        this.pos++;
        for (i3 = 0; i3 < 8; i3++) {
            this.prePlain[i3] = (byte) 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                bArr3 = this.plain;
                i4 = this.pos;
                this.pos = i4 + 1;
                bArr3[i4] = (byte) (rand() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        i4 = i;
        int i5 = i2;
        while (i5 > 0) {
            if (this.pos < 8) {
                byte[] bArr4 = this.plain;
                int i6 = this.pos;
                this.pos = i6 + 1;
                i3 = i4 + 1;
                bArr4[i6] = bArr[i4];
                i5--;
            } else {
                i3 = i4;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
                i4 = i3;
            } else {
                i4 = i3;
            }
        }
        this.padding = 1;
        while (this.padding <= 7) {
            if (this.pos < 8) {
                bArr3 = this.plain;
                int i7 = this.pos;
                this.pos = i7 + 1;
                bArr3[i7] = (byte) 0;
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        bArr3 = this.out;
        AppMethodBeat.o(76228);
        return bArr3;
    }

    private byte[] encipher(byte[] bArr) {
        AppMethodBeat.i(76229);
        int i = 16;
        try {
            long unsignedInt = getUnsignedInt(bArr, 0, 4);
            long unsignedInt2 = getUnsignedInt(bArr, 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j = 0;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    j = (j + 2654435769L) & 4294967295L;
                    unsignedInt = (unsignedInt + ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                    unsignedInt2 = (unsignedInt2 + ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                    i = i2;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(76229);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.o(76229);
            return null;
        }
    }

    private byte[] decipher(byte[] bArr, int i) {
        AppMethodBeat.i(76230);
        int i2 = 16;
        try {
            long unsignedInt = getUnsignedInt(bArr, i, 4);
            long unsignedInt2 = getUnsignedInt(bArr, i + 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j = 3816266640L;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    unsignedInt2 = (unsignedInt2 - ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                    unsignedInt = (unsignedInt - ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                    j = (j - 2654435769L) & 4294967295L;
                    i2 = i3;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(76230);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.o(76230);
            return null;
        }
    }

    private byte[] decipher(byte[] bArr) {
        AppMethodBeat.i(76231);
        byte[] decipher = decipher(bArr, 0);
        AppMethodBeat.o(76231);
        return decipher;
    }

    private void encrypt8Bytes() {
        byte[] bArr;
        int i;
        AppMethodBeat.i(76232);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.header) {
                bArr = this.plain;
                i = this.pos;
                bArr[i] = (byte) (bArr[i] ^ this.prePlain[this.pos]);
            } else {
                bArr = this.plain;
                i = this.pos;
                bArr[i] = (byte) (bArr[i] ^ this.out[this.preCrypt + this.pos]);
            }
            this.pos++;
        }
        System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (this.pos < 8) {
            bArr = this.out;
            i = this.crypt + this.pos;
            bArr[i] = (byte) (bArr[i] ^ this.prePlain[this.pos]);
            this.pos++;
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
        AppMethodBeat.o(76232);
    }

    private boolean decrypt8Bytes(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(76233);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i2) {
                AppMethodBeat.o(76233);
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i3 = this.pos;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.crypt + i) + this.pos]);
            this.pos++;
        }
        this.prePlain = decipher(this.prePlain);
        if (this.prePlain == null) {
            AppMethodBeat.o(76233);
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        AppMethodBeat.o(76233);
        return true;
    }

    private int rand() {
        AppMethodBeat.i(76234);
        int nextInt = this.random.nextInt();
        AppMethodBeat.o(76234);
        return nextInt;
    }

    private static long getUnsignedInt(byte[] bArr, int i, int i2) {
        int i3;
        long j = 0;
        if (i2 > 8) {
            i3 = i + 8;
        } else {
            i3 = i + i2;
        }
        while (i < i3) {
            j = (j << 8) | ((long) (bArr[i] & 255));
            i++;
        }
        return (j >>> 32) | (4294967295L & j);
    }
}

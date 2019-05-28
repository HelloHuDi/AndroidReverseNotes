package oicq.wlogin_sdk.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

final class a {
    int contextStart;
    int crypt;
    boolean header = true;
    byte[] key;
    byte[] out;
    int padding;
    byte[] plain;
    int pos;
    int preCrypt;
    byte[] prePlain;
    Random random = new Random();

    a() {
        AppMethodBeat.i(96513);
        AppMethodBeat.o(96513);
    }

    private static long A(byte[] bArr, int i) {
        long j = 0;
        int i2 = i + 4;
        while (i < i2) {
            j = (j << 8) | ((long) (bArr[i] & 255));
            i++;
        }
        return (j >>> 32) | (4294967295L & j);
    }

    private byte[] encipher(byte[] bArr) {
        AppMethodBeat.i(96514);
        int i = 16;
        try {
            long A = A(bArr, 0);
            long A2 = A(bArr, 4);
            long A3 = A(this.key, 0);
            long A4 = A(this.key, 4);
            long A5 = A(this.key, 8);
            long A6 = A(this.key, 12);
            long j = 0;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) A);
                    dataOutputStream.writeInt((int) A2);
                    dataOutputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(96514);
                    return toByteArray;
                }
                j = (j + 2654435769L) & 4294967295L;
                A = (A + ((((A2 << 4) + A3) ^ (A2 + j)) ^ ((A2 >>> 5) + A4))) & 4294967295L;
                A2 = (A2 + ((((A << 4) + A5) ^ (A + j)) ^ ((A >>> 5) + A6))) & 4294967295L;
                i = i2;
            }
        } catch (IOException e) {
            AppMethodBeat.o(96514);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    public final byte[] am(byte[] bArr) {
        AppMethodBeat.i(96515);
        int i = 16;
        try {
            long A = A(bArr, 0);
            long A2 = A(bArr, 4);
            long A3 = A(this.key, 0);
            long A4 = A(this.key, 4);
            long A5 = A(this.key, 8);
            long A6 = A(this.key, 12);
            long j = 3816266640L;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) A);
                    dataOutputStream.writeInt((int) A2);
                    dataOutputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(96515);
                    return toByteArray;
                }
                A2 = (A2 - ((((A << 4) + A5) ^ (A + j)) ^ ((A >>> 5) + A6))) & 4294967295L;
                A = (A - ((((A2 << 4) + A3) ^ (A2 + j)) ^ ((A2 >>> 5) + A4))) & 4294967295L;
                j = (j - 2654435769L) & 4294967295L;
                i = i2;
            }
        } catch (IOException e) {
            AppMethodBeat.o(96515);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void encrypt8Bytes() {
        byte[] bArr;
        int i;
        AppMethodBeat.i(96516);
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
        AppMethodBeat.o(96516);
    }

    /* Access modifiers changed, original: final */
    public final boolean F(byte[] bArr, int i) {
        AppMethodBeat.i(96517);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i) {
                AppMethodBeat.o(96517);
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i2 = this.pos;
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr[(this.crypt + 0) + this.pos]);
            this.pos++;
        }
        this.prePlain = am(this.prePlain);
        if (this.prePlain == null) {
            AppMethodBeat.o(96517);
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        AppMethodBeat.o(96517);
        return true;
    }
}

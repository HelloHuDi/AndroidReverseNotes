package com.tencent.p177mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* renamed from: com.tencent.mm.platformtools.af */
public final class C37984af {
    private int crypt;
    private boolean header = true;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;
    private Random random = new Random();

    public C37984af() {
        AppMethodBeat.m2504i(79042);
        AppMethodBeat.m2505o(79042);
    }

    /* renamed from: A */
    private static long m64273A(byte[] bArr, int i) {
        long j = 0;
        int i2 = i + 4;
        while (i < i2) {
            j = (j << 8) | ((long) (bArr[i] & 255));
            i++;
        }
        return j & 4294967295L;
    }

    /* renamed from: a */
    public final byte[] mo60758a(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        byte[] bArr3;
        int i3;
        AppMethodBeat.m2504i(79043);
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        this.header = true;
        this.pos = (i + 10) % 8;
        if (this.pos != 0) {
            this.pos = 8 - this.pos;
        }
        this.out = new byte[((this.pos + i) + 10)];
        this.plain[0] = (byte) ((this.random.nextInt() & C31128d.MIC_PTU_ZIPAI_THURSDAY) | this.pos);
        for (i2 = 1; i2 <= this.pos; i2++) {
            this.plain[i2] = (byte) (this.random.nextInt() & 255);
        }
        this.pos++;
        for (i2 = 0; i2 < 8; i2++) {
            this.prePlain[i2] = (byte) 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                bArr3 = this.plain;
                i3 = this.pos;
                this.pos = i3 + 1;
                bArr3[i3] = (byte) (this.random.nextInt() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        i3 = 0;
        int i4 = i;
        while (i4 > 0) {
            if (this.pos < 8) {
                byte[] bArr4 = this.plain;
                int i5 = this.pos;
                this.pos = i5 + 1;
                i2 = i3 + 1;
                bArr4[i5] = bArr[i3];
                i4--;
            } else {
                i2 = i3;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
                i3 = i2;
            } else {
                i3 = i2;
            }
        }
        this.padding = 1;
        while (this.padding <= 7) {
            if (this.pos < 8) {
                bArr3 = this.plain;
                int i6 = this.pos;
                this.pos = i6 + 1;
                bArr3[i6] = (byte) 0;
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        bArr3 = this.out;
        AppMethodBeat.m2505o(79043);
        return bArr3;
    }

    private byte[] encipher(byte[] bArr) {
        AppMethodBeat.m2504i(79044);
        int i = 16;
        try {
            long A = C37984af.m64273A(bArr, 0);
            long A2 = C37984af.m64273A(bArr, 4);
            long A3 = C37984af.m64273A(this.key, 0);
            long A4 = C37984af.m64273A(this.key, 4);
            long A5 = C37984af.m64273A(this.key, 8);
            long A6 = C37984af.m64273A(this.key, 12);
            long j = 0;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    j = (j + 2654435769L) & 4294967295L;
                    A = (A + ((((A2 << 4) + A3) ^ (A2 + j)) ^ ((A2 >>> 5) + A4))) & 4294967295L;
                    A2 = (A2 + ((((A << 4) + A5) ^ (A + j)) ^ ((A >>> 5) + A6))) & 4294967295L;
                    i = i2;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) A);
                    dataOutputStream.writeInt((int) A2);
                    dataOutputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.m2505o(79044);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.m2505o(79044);
            return null;
        }
    }

    private void encrypt8Bytes() {
        byte[] bArr;
        int i;
        AppMethodBeat.m2504i(79045);
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
        AppMethodBeat.m2505o(79045);
    }
}

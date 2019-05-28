package com.tencent.p177mm.plugin.appbrand.p329s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.appbrand.s.v */
public final class C45689v {
    private int contextStart;
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

    public C45689v() {
        AppMethodBeat.m2504i(91187);
        AppMethodBeat.m2505o(91187);
    }

    /* renamed from: A */
    private static long m84389A(byte[] bArr, int i) {
        long j = 0;
        int i2 = i + 4;
        while (i < i2) {
            j = (j << 8) | ((long) (bArr[i] & 255));
            i++;
        }
        return j & 4294967295L;
    }

    /* renamed from: b */
    private byte[] m84393b(byte[] bArr, int i, byte[] bArr2) {
        int i2 = 0;
        AppMethodBeat.m2504i(91188);
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        byte[] bArr3 = new byte[8];
        if (i % 8 != 0 || i < 16) {
            AppMethodBeat.m2505o(91188);
            return null;
        }
        this.prePlain = m84392am(bArr);
        if (this.prePlain == null) {
            AppMethodBeat.m2505o(91188);
            return null;
        }
        this.pos = this.prePlain[0] & 7;
        int i3 = (i - this.pos) - 10;
        if (i3 < 0) {
            AppMethodBeat.m2505o(91188);
            return null;
        }
        for (int i4 = 0; i4 < 8; i4++) {
            bArr3[i4] = (byte) 0;
        }
        this.out = new byte[i3];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                this.pos++;
                this.padding++;
            }
            if (this.pos == 8) {
                if (m84390F(bArr, i)) {
                    bArr3 = bArr;
                } else {
                    AppMethodBeat.m2505o(91188);
                    return null;
                }
            }
        }
        byte[] bArr4 = bArr3;
        while (i3 != 0) {
            int i5;
            if (this.pos < 8) {
                this.out[i2] = (byte) (bArr4[(this.preCrypt + 0) + this.pos] ^ this.prePlain[this.pos]);
                i5 = i2 + 1;
                i2 = i3 - 1;
                this.pos++;
                i3 = i2;
            } else {
                i5 = i2;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt - 8;
                if (m84390F(bArr, i)) {
                    i2 = i5;
                    bArr4 = bArr;
                } else {
                    AppMethodBeat.m2505o(91188);
                    return null;
                }
            }
            i2 = i5;
        }
        this.padding = 1;
        bArr3 = bArr4;
        while (this.padding < 8) {
            if (this.pos < 8) {
                if ((bArr3[(this.preCrypt + 0) + this.pos] ^ this.prePlain[this.pos]) != 0) {
                    AppMethodBeat.m2505o(91188);
                    return null;
                }
                this.pos++;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt;
                if (m84390F(bArr, i)) {
                    bArr3 = bArr;
                } else {
                    AppMethodBeat.m2505o(91188);
                    return null;
                }
            }
            this.padding++;
        }
        bArr3 = this.out;
        AppMethodBeat.m2505o(91188);
        return bArr3;
    }

    public final byte[] decrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(91189);
        byte[] b = m84393b(bArr, bArr.length, bArr2);
        AppMethodBeat.m2505o(91189);
        return b;
    }

    /* renamed from: a */
    private byte[] m84391a(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        byte[] bArr3;
        int i3;
        AppMethodBeat.m2504i(91190);
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
        AppMethodBeat.m2505o(91190);
        return bArr3;
    }

    public final byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(91191);
        byte[] a = m84391a(bArr, bArr.length, bArr2);
        AppMethodBeat.m2505o(91191);
        return a;
    }

    private byte[] encipher(byte[] bArr) {
        AppMethodBeat.m2504i(91192);
        int i = 16;
        try {
            long A = C45689v.m84389A(bArr, 0);
            long A2 = C45689v.m84389A(bArr, 4);
            long A3 = C45689v.m84389A(this.key, 0);
            long A4 = C45689v.m84389A(this.key, 4);
            long A5 = C45689v.m84389A(this.key, 8);
            long A6 = C45689v.m84389A(this.key, 12);
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
                    AppMethodBeat.m2505o(91192);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.m2505o(91192);
            return null;
        }
    }

    /* renamed from: am */
    private byte[] m84392am(byte[] bArr) {
        AppMethodBeat.m2504i(91193);
        int i = 16;
        try {
            long A = C45689v.m84389A(bArr, 0);
            long A2 = C45689v.m84389A(bArr, 4);
            long A3 = C45689v.m84389A(this.key, 0);
            long A4 = C45689v.m84389A(this.key, 4);
            long A5 = C45689v.m84389A(this.key, 8);
            long A6 = C45689v.m84389A(this.key, 12);
            long j = 3816266640L;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    A2 = (A2 - ((((A << 4) + A5) ^ (A + j)) ^ ((A >>> 5) + A6))) & 4294967295L;
                    A = (A - ((((A2 << 4) + A3) ^ (A2 + j)) ^ ((A2 >>> 5) + A4))) & 4294967295L;
                    j = (j - 2654435769L) & 4294967295L;
                    i = i2;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) A);
                    dataOutputStream.writeInt((int) A2);
                    dataOutputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.m2505o(91193);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.m2505o(91193);
            return null;
        }
    }

    private void encrypt8Bytes() {
        byte[] bArr;
        int i;
        AppMethodBeat.m2504i(91194);
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
        AppMethodBeat.m2505o(91194);
    }

    /* renamed from: F */
    private boolean m84390F(byte[] bArr, int i) {
        AppMethodBeat.m2504i(91195);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i) {
                AppMethodBeat.m2505o(91195);
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i2 = this.pos;
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr[(this.crypt + 0) + this.pos]);
            this.pos++;
        }
        this.prePlain = m84392am(this.prePlain);
        if (this.prePlain == null) {
            AppMethodBeat.m2505o(91195);
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        AppMethodBeat.m2505o(91195);
        return true;
    }
}

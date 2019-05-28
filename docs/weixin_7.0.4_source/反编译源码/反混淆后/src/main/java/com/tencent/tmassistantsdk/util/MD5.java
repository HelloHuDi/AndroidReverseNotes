package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5 {
    static final byte[] PADDING = new byte[]{Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    static final int S11 = 7;
    static final int S12 = 12;
    static final int S13 = 17;
    static final int S14 = 22;
    static final int S21 = 5;
    static final int S22 = 9;
    static final int S23 = 14;
    static final int S24 = 20;
    static final int S31 = 4;
    static final int S32 = 11;
    static final int S33 = 16;
    static final int S34 = 23;
    static final int S41 = 6;
    static final int S42 = 10;
    static final int S43 = 15;
    static final int S44 = 21;
    protected final byte[] buffer = new byte[64];
    protected final long[] count = new long[2];
    protected final byte[] digest = new byte[16];
    protected final long[] state = new long[4];

    public byte[] getMD5(byte[] bArr) {
        AppMethodBeat.m2504i(76257);
        md5Init();
        md5Update(new ByteArrayInputStream(bArr), (long) bArr.length);
        md5Final();
        byte[] bArr2 = this.digest;
        AppMethodBeat.m2505o(76257);
        return bArr2;
    }

    public MD5() {
        AppMethodBeat.m2504i(76258);
        md5Init();
        AppMethodBeat.m2505o(76258);
    }

    private void md5Init() {
        this.count[0] = 0;
        this.count[1] = 0;
        this.state[0] = 1732584193;
        this.state[1] = 4023233417L;
        this.state[2] = 2562383102L;
        this.state[3] = 271733878;
    }

    /* renamed from: F */
    private long m9429F(long j, long j2, long j3) {
        return (j & j2) | ((-1 ^ j) & j3);
    }

    /* renamed from: G */
    private long m9431G(long j, long j2, long j3) {
        return (j & j3) | ((-1 ^ j3) & j2);
    }

    /* renamed from: H */
    private long m9433H(long j, long j2, long j3) {
        return (j ^ j2) ^ j3;
    }

    /* renamed from: I */
    private long m9435I(long j, long j2, long j3) {
        return ((-1 ^ j3) | j) ^ j2;
    }

    /* renamed from: FF */
    private long m9430FF(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        AppMethodBeat.m2504i(76259);
        long F = ((m9429F(j2, j3, j4) + j5) + j7) + j;
        F = ((long) ((((int) F) >>> ((int) (32 - j6))) | (((int) F) << ((int) j6)))) + j2;
        AppMethodBeat.m2505o(76259);
        return F;
    }

    /* renamed from: GG */
    private long m9432GG(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        AppMethodBeat.m2504i(76260);
        long G = ((m9431G(j2, j3, j4) + j5) + j7) + j;
        G = ((long) ((((int) G) >>> ((int) (32 - j6))) | (((int) G) << ((int) j6)))) + j2;
        AppMethodBeat.m2505o(76260);
        return G;
    }

    /* renamed from: HH */
    private long m9434HH(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        AppMethodBeat.m2504i(76261);
        long H = ((m9433H(j2, j3, j4) + j5) + j7) + j;
        H = ((long) ((((int) H) >>> ((int) (32 - j6))) | (((int) H) << ((int) j6)))) + j2;
        AppMethodBeat.m2505o(76261);
        return H;
    }

    /* renamed from: II */
    private long m9436II(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        AppMethodBeat.m2504i(76262);
        long I = ((m9435I(j2, j3, j4) + j5) + j7) + j;
        I = ((long) ((((int) I) >>> ((int) (32 - j6))) | (((int) I) << ((int) j6)))) + j2;
        AppMethodBeat.m2505o(76262);
        return I;
    }

    private boolean md5Update(InputStream inputStream, long j) {
        byte[] bArr;
        int i;
        AppMethodBeat.m2504i(76263);
        byte[] bArr2 = new byte[64];
        int i2 = ((int) (this.count[0] >>> 3)) & 63;
        long[] jArr = this.count;
        long j2 = jArr[0] + (j << 3);
        jArr[0] = j2;
        if (j2 < (j << 3)) {
            jArr = this.count;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.count;
        jArr[1] = jArr[1] + (j >>> 29);
        int i3 = 64 - i2;
        if (j >= ((long) i3)) {
            bArr = new byte[i3];
            try {
                inputStream.read(bArr, 0, i3);
                md5Memcpy(this.buffer, bArr, i2, 0, i3);
                md5Transform(this.buffer);
                i = i3;
                while (((long) (i + 63)) < j) {
                    try {
                        inputStream.read(bArr2);
                        md5Transform(bArr2);
                        i += 64;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(76263);
                        return false;
                    }
                }
                i2 = 0;
            } catch (Exception e2) {
                AppMethodBeat.m2505o(76263);
                return false;
            }
        }
        i = 0;
        bArr = new byte[((int) (j - ((long) i)))];
        try {
            inputStream.read(bArr);
            md5Memcpy(this.buffer, bArr, i2, 0, bArr.length);
            AppMethodBeat.m2505o(76263);
            return true;
        } catch (Exception e3) {
            AppMethodBeat.m2505o(76263);
            return false;
        }
    }

    private void md5Update(byte[] bArr, int i) {
        int i2;
        AppMethodBeat.m2504i(76264);
        byte[] bArr2 = new byte[64];
        int i3 = ((int) (this.count[0] >>> 3)) & 63;
        long[] jArr = this.count;
        long j = jArr[0] + ((long) (i << 3));
        jArr[0] = j;
        if (j < ((long) (i << 3))) {
            jArr = this.count;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.count;
        jArr[1] = jArr[1] + ((long) (i >>> 29));
        int i4 = 64 - i3;
        if (i >= i4) {
            md5Memcpy(this.buffer, bArr, i3, 0, i4);
            md5Transform(this.buffer);
            while (i4 + 63 < i) {
                md5Memcpy(bArr2, bArr, 0, i4, 64);
                md5Transform(bArr2);
                i4 += 64;
            }
            i2 = i4;
            i3 = 0;
        } else {
            i2 = 0;
        }
        md5Memcpy(this.buffer, bArr, i3, i2, i - i2);
        AppMethodBeat.m2505o(76264);
    }

    private void md5Final() {
        AppMethodBeat.m2504i(76265);
        byte[] bArr = new byte[8];
        Encode(bArr, this.count, 8);
        int i = ((int) (this.count[0] >>> 3)) & 63;
        md5Update(PADDING, i < 56 ? 56 - i : 120 - i);
        md5Update(bArr, 8);
        Encode(this.digest, this.state, 16);
        AppMethodBeat.m2505o(76265);
    }

    private void md5Memcpy(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i + i4] = bArr2[i2 + i4];
        }
    }

    private void md5Transform(byte[] bArr) {
        AppMethodBeat.m2504i(76266);
        long j = this.state[0];
        long j2 = this.state[1];
        long j3 = this.state[2];
        long j4 = this.state[3];
        long[] jArr = new long[16];
        Decode(jArr, bArr, 64);
        long FF = m9430FF(j, j2, j3, j4, jArr[0], 7, 3614090360L);
        long FF2 = m9430FF(j4, FF, j2, j3, jArr[1], 12, 3905402710L);
        long FF3 = m9430FF(j3, FF2, FF, j2, jArr[2], 17, 606105819);
        long FF4 = m9430FF(j2, FF3, FF2, FF, jArr[3], 22, 3250441966L);
        long FF5 = m9430FF(FF, FF4, FF3, FF2, jArr[4], 7, 4118548399L);
        long FF6 = m9430FF(FF2, FF5, FF4, FF3, jArr[5], 12, 1200080426);
        j2 = m9430FF(FF3, FF6, FF5, FF4, jArr[6], 17, 2821735955L);
        long FF7 = m9430FF(FF4, j2, FF6, FF5, jArr[7], 22, 4249261313L);
        long FF8 = m9430FF(FF5, FF7, j2, FF6, jArr[8], 7, 1770035416);
        FF4 = m9430FF(FF6, FF8, FF7, j2, jArr[9], 12, 2336552879L);
        j2 = m9430FF(j2, FF4, FF8, FF7, jArr[10], 17, 4294925233L);
        long FF9 = m9430FF(FF7, j2, FF4, FF8, jArr[11], 22, 2304563134L);
        long FF10 = m9430FF(FF8, FF9, j2, FF4, jArr[12], 7, 1804603682);
        FF7 = m9430FF(FF4, FF10, FF9, j2, jArr[13], 12, 4254626195L);
        j2 = m9430FF(j2, FF7, FF10, FF9, jArr[14], 17, 2792965006L);
        FF3 = m9430FF(FF9, j2, FF7, FF10, jArr[15], 22, 1236535329);
        FF10 = m9432GG(FF10, FF3, j2, FF7, jArr[1], 5, 4129170786L);
        j3 = m9432GG(FF7, FF10, FF3, j2, jArr[6], 9, 3225465664L);
        FF2 = m9432GG(j2, j3, FF10, FF3, jArr[11], 14, 643717713);
        FF9 = m9432GG(FF3, FF2, j3, FF10, jArr[0], 20, 3921069994L);
        j4 = m9432GG(FF10, FF9, FF2, j3, jArr[5], 5, 3593408605L);
        FF = m9432GG(j3, j4, FF9, FF2, jArr[10], 9, 38016083);
        long GG = m9432GG(FF2, FF, j4, FF9, jArr[15], 14, 3634488961L);
        FF3 = m9432GG(FF9, GG, FF, j4, jArr[4], 20, 3889429448L);
        FF6 = m9432GG(j4, FF3, GG, FF, jArr[9], 5, 568446438);
        long GG2 = m9432GG(FF, FF6, FF3, GG, jArr[14], 9, 3275163606L);
        FF2 = m9432GG(GG, GG2, FF6, FF3, jArr[3], 14, 4107603335L);
        FF5 = m9432GG(FF3, FF2, GG2, FF6, jArr[8], 20, 1163531501);
        long GG3 = m9432GG(FF6, FF5, FF2, GG2, jArr[13], 5, 2850285829L);
        FF = m9432GG(GG2, GG3, FF5, FF2, jArr[2], 9, 4243563512L);
        FF4 = m9432GG(FF2, FF, GG3, FF5, jArr[7], 14, 1735328473);
        long GG4 = m9432GG(FF5, FF4, FF, GG3, jArr[12], 20, 2368359562L);
        FF6 = m9434HH(GG3, GG4, FF4, FF, jArr[5], 4, 4294588738L);
        FF8 = m9434HH(FF, FF6, GG4, FF4, jArr[8], 11, 2272392833L);
        long HH = m9434HH(FF4, FF8, FF6, GG4, jArr[11], 16, 1839030562);
        FF5 = m9434HH(GG4, HH, FF8, FF6, jArr[14], 23, 4259657740L);
        FF7 = m9434HH(FF6, FF5, HH, FF8, jArr[1], 4, 2763975236L);
        long HH2 = m9434HH(FF8, FF7, FF5, HH, jArr[4], 11, 1272893353);
        FF4 = m9434HH(HH, HH2, FF7, FF5, jArr[7], 16, 4139469664L);
        FF10 = m9434HH(FF5, FF4, HH2, FF7, jArr[10], 23, 3200236656L);
        long HH3 = m9434HH(FF7, FF10, FF4, HH2, jArr[13], 4, 681279174);
        FF8 = m9434HH(HH2, HH3, FF10, FF4, jArr[0], 11, 3936430074L);
        FF9 = m9434HH(FF4, FF8, HH3, FF10, jArr[3], 16, 3572445317L);
        long HH4 = m9434HH(FF10, FF9, FF8, HH3, jArr[6], 23, 76029189);
        FF7 = m9434HH(HH3, HH4, FF9, FF8, jArr[9], 4, 3654602809L);
        GG = m9434HH(FF8, FF7, HH4, FF9, jArr[12], 11, 3873151461L);
        long HH5 = m9434HH(FF9, GG, FF7, HH4, jArr[15], 16, 530742520);
        FF10 = m9434HH(HH4, HH5, GG, FF7, jArr[2], 23, 3299628645L);
        GG2 = m9436II(FF7, FF10, HH5, GG, jArr[0], 6, 4096336452L);
        long II = m9436II(GG, GG2, FF10, HH5, jArr[7], 10, 1126891415);
        FF9 = m9436II(HH5, II, GG2, FF10, jArr[14], 15, 2878612391L);
        GG3 = m9436II(FF10, FF9, II, GG2, jArr[5], 21, 4237533241L);
        long II2 = m9436II(GG2, GG3, FF9, II, jArr[12], 6, 1700485571);
        GG = m9436II(II, II2, GG3, FF9, jArr[3], 10, 2399980690L);
        GG4 = m9436II(FF9, GG, II2, GG3, jArr[10], 15, 4293915773L);
        long II3 = m9436II(GG3, GG4, GG, II2, jArr[1], 21, 2240044497L);
        GG2 = m9436II(II2, II3, GG4, GG, jArr[8], 6, 1873313359);
        HH = m9436II(GG, GG2, II3, GG4, jArr[15], 10, 4264355552L);
        long II4 = m9436II(GG4, HH, GG2, II3, jArr[6], 15, 2734768916L);
        GG3 = m9436II(II3, II4, HH, GG2, jArr[13], 21, 1309151649);
        HH2 = m9436II(GG2, GG3, II4, HH, jArr[4], 6, 4149444226L);
        long II5 = m9436II(HH, HH2, GG3, II4, jArr[11], 10, 3174756917L);
        GG4 = m9436II(II4, II5, HH2, GG3, jArr[2], 15, 718787259);
        long II6 = m9436II(GG3, GG4, II5, HH2, jArr[9], 21, 3951481745L);
        long[] jArr2 = this.state;
        jArr2[0] = jArr2[0] + HH2;
        jArr2 = this.state;
        jArr2[1] = II6 + jArr2[1];
        jArr = this.state;
        jArr[2] = jArr[2] + GG4;
        jArr = this.state;
        jArr[3] = jArr[3] + II5;
        AppMethodBeat.m2505o(76266);
    }

    private void Encode(byte[] bArr, long[] jArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            bArr[i2] = (byte) ((int) (jArr[i3] & 255));
            bArr[i2 + 1] = (byte) ((int) ((jArr[i3] >>> 8) & 255));
            bArr[i2 + 2] = (byte) ((int) ((jArr[i3] >>> 16) & 255));
            bArr[i2 + 3] = (byte) ((int) ((jArr[i3] >>> 24) & 255));
            i2 += 4;
            i3++;
        }
    }

    private void Decode(long[] jArr, byte[] bArr, int i) {
        AppMethodBeat.m2504i(76267);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            jArr[i3] = ((b2iu(bArr[i2]) | (b2iu(bArr[i2 + 1]) << 8)) | (b2iu(bArr[i2 + 2]) << 16)) | (b2iu(bArr[i2 + 3]) << 24);
            i2 += 4;
            i3++;
        }
        AppMethodBeat.m2505o(76267);
    }

    public static long b2iu(byte b) {
        return b < (byte) 0 ? (long) (b & 255) : (long) b;
    }

    public static String byteHEX(byte b) {
        AppMethodBeat.m2504i(76268);
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String str = new String(new char[]{cArr[(b >>> 4) & 15], cArr[b & 15]});
        AppMethodBeat.m2505o(76268);
        return str;
    }

    public static String toMD5(String str) {
        byte[] bytes;
        AppMethodBeat.m2504i(76269);
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        byte[] md5 = new MD5().getMD5(bytes);
        String str2 = "";
        for (int i = 0; i < 16; i++) {
            str2 = str2 + byteHEX(md5[i]);
        }
        AppMethodBeat.m2505o(76269);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044 A:{SYNTHETIC, Splitter:B:26:0x0044} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String fileToMD5(String str) {
        Throwable th;
        InputStream inputStream;
        String str2 = null;
        int i = 0;
        AppMethodBeat.m2504i(76270);
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                MessageDigest instance = MessageDigest.getInstance("MD5");
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        instance.update(bArr, 0, i);
                    }
                }
                str2 = convertHashToString(instance.digest());
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(76270);
            } catch (Exception e2) {
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                AppMethodBeat.m2505o(76270);
                throw th;
            }
        } catch (Exception e4) {
            Object fileInputStream2 = str2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.m2505o(76270);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            inputStream = str2;
            if (inputStream != null) {
            }
            AppMethodBeat.m2505o(76270);
            throw th;
        }
        return str2;
    }

    public static String convertHashToString(byte[] bArr) {
        AppMethodBeat.m2504i(76271);
        String str;
        if (bArr == null) {
            str = "";
            AppMethodBeat.m2505o(76271);
            return str;
        }
        String str2 = "";
        for (byte b : bArr) {
            str2 = str2 + Integer.toString((b & 255) + 256, 16).substring(1);
        }
        str = str2.toUpperCase();
        AppMethodBeat.m2505o(76271);
        return str;
    }
}

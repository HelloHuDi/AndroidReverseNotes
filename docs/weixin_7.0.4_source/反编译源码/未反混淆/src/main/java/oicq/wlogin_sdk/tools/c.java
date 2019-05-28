package oicq.wlogin_sdk.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class c {
    static final byte[] PADDING;
    private byte[] buffer = new byte[64];
    private long[] count = new long[2];
    private byte[] digest = new byte[16];
    private long[] state = new long[4];

    static {
        byte[] bArr = new byte[64];
        bArr[0] = Byte.MIN_VALUE;
        PADDING = bArr;
    }

    private byte[] getMD5(byte[] bArr) {
        AppMethodBeat.i(96505);
        md5Init();
        md5Update(new ByteArrayInputStream(bArr), (long) bArr.length);
        byte[] bArr2 = new byte[8];
        Encode(bArr2, this.count, 8);
        int i = ((int) (this.count[0] >>> 3)) & 63;
        md5Update(PADDING, i < 56 ? 56 - i : 120 - i);
        md5Update(bArr2, 8);
        Encode(this.digest, this.state, 16);
        byte[] bArr3 = this.digest;
        AppMethodBeat.o(96505);
        return bArr3;
    }

    public c() {
        AppMethodBeat.i(96506);
        md5Init();
        AppMethodBeat.o(96506);
    }

    private void md5Init() {
        this.count[0] = 0;
        this.count[1] = 0;
        this.state[0] = 1732584193;
        this.state[1] = 4023233417L;
        this.state[2] = 2562383102L;
        this.state[3] = 271733878;
    }

    private boolean md5Update(InputStream inputStream, long j) {
        AppMethodBeat.i(96507);
        byte[] bArr = new byte[64];
        int i = ((int) (this.count[0] >>> 3)) & 63;
        long[] jArr = this.count;
        long j2 = jArr[0] + (j << 3);
        jArr[0] = j2;
        if (j2 < (j << 3)) {
            jArr = this.count;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.count;
        jArr[1] = jArr[1] + (j >>> 29);
        int i2 = 64 - i;
        if (j >= ((long) i2)) {
            byte[] bArr2 = new byte[i2];
            try {
                inputStream.read(bArr2, 0, i2);
                md5Memcpy(this.buffer, bArr2, i, 0, i2);
                md5Transform(this.buffer);
                while (((long) (i2 + 63)) < j) {
                    try {
                        inputStream.read(bArr);
                        md5Transform(bArr);
                        i2 += 64;
                    } catch (Exception e) {
                        AppMethodBeat.o(96507);
                        return false;
                    }
                }
                i = 0;
            } catch (Exception e2) {
                AppMethodBeat.o(96507);
                return false;
            }
        }
        i2 = 0;
        byte[] bArr3 = new byte[((int) (j - ((long) i2)))];
        try {
            inputStream.read(bArr3);
            md5Memcpy(this.buffer, bArr3, i, 0, bArr3.length);
            AppMethodBeat.o(96507);
            return true;
        } catch (Exception e3) {
            AppMethodBeat.o(96507);
            return false;
        }
    }

    private void md5Update(byte[] bArr, int i) {
        AppMethodBeat.i(96508);
        byte[] bArr2 = new byte[64];
        int i2 = ((int) (this.count[0] >>> 3)) & 63;
        long[] jArr = this.count;
        long j = jArr[0] + ((long) (i << 3));
        jArr[0] = j;
        if (j < ((long) (i << 3))) {
            jArr = this.count;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.count;
        jArr[1] = jArr[1] + ((long) (i >>> 29));
        int i3 = 64 - i2;
        if (i >= i3) {
            md5Memcpy(this.buffer, bArr, i2, 0, i3);
            md5Transform(this.buffer);
            while (i3 + 63 < i) {
                md5Memcpy(bArr2, bArr, 0, i3, 64);
                md5Transform(bArr2);
                i3 += 64;
            }
            i2 = 0;
        } else {
            i3 = 0;
        }
        md5Memcpy(this.buffer, bArr, i2, i3, i - i3);
        AppMethodBeat.o(96508);
    }

    private static void md5Memcpy(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i + i4] = bArr2[i2 + i4];
        }
    }

    private void md5Transform(byte[] bArr) {
        AppMethodBeat.i(96509);
        long j = this.state[0];
        long j2 = this.state[1];
        long j3 = this.state[2];
        long j4 = this.state[3];
        long[] jArr = new long[16];
        a(jArr, bArr);
        long FF = FF(j, j2, j3, j4, jArr[0], 7, 3614090360L);
        j4 = FF(j4, FF, j2, j3, jArr[1], 12, 3905402710L);
        j3 = FF(j3, j4, FF, j2, jArr[2], 17, 606105819);
        long FF2 = FF(j2, j3, j4, FF, jArr[3], 22, 3250441966L);
        FF = FF(FF, FF2, j3, j4, jArr[4], 7, 4118548399L);
        j4 = FF(j4, FF, FF2, j3, jArr[5], 12, 1200080426);
        long FF3 = FF(j3, j4, FF, FF2, jArr[6], 17, 2821735955L);
        FF2 = FF(FF2, FF3, j4, FF, jArr[7], 22, 4249261313L);
        FF = FF(FF, FF2, FF3, j4, jArr[8], 7, 1770035416);
        long FF4 = FF(j4, FF, FF2, FF3, jArr[9], 12, 2336552879L);
        FF3 = FF(FF3, FF4, FF, FF2, jArr[10], 17, 4294925233L);
        FF2 = FF(FF2, FF3, FF4, FF, jArr[11], 22, 2304563134L);
        long FF5 = FF(FF, FF2, FF3, FF4, jArr[12], 7, 1804603682);
        FF4 = FF(FF4, FF5, FF2, FF3, jArr[13], 12, 4254626195L);
        FF3 = FF(FF3, FF4, FF5, FF2, jArr[14], 17, 2792965006L);
        long FF6 = FF(FF2, FF3, FF4, FF5, jArr[15], 22, 1236535329);
        FF5 = GG(FF5, FF6, FF3, FF4, jArr[1], 5, 4129170786L);
        FF4 = GG(FF4, FF5, FF6, FF3, jArr[6], 9, 3225465664L);
        long GG = GG(FF3, FF4, FF5, FF6, jArr[11], 14, 643717713);
        FF6 = GG(FF6, GG, FF4, FF5, jArr[0], 20, 3921069994L);
        FF5 = GG(FF5, FF6, GG, FF4, jArr[5], 5, 3593408605L);
        long GG2 = GG(FF4, FF5, FF6, GG, jArr[10], 9, 38016083);
        GG = GG(GG, GG2, FF5, FF6, jArr[15], 14, 3634488961L);
        FF6 = GG(FF6, GG, GG2, FF5, jArr[4], 20, 3889429448L);
        long GG3 = GG(FF5, FF6, GG, GG2, jArr[9], 5, 568446438);
        GG2 = GG(GG2, GG3, FF6, GG, jArr[14], 9, 3275163606L);
        GG = GG(GG, GG2, GG3, FF6, jArr[3], 14, 4107603335L);
        long GG4 = GG(FF6, GG, GG2, GG3, jArr[8], 20, 1163531501);
        GG3 = GG(GG3, GG4, GG, GG2, jArr[13], 5, 2850285829L);
        GG2 = GG(GG2, GG3, GG4, GG, jArr[2], 9, 4243563512L);
        long GG5 = GG(GG, GG2, GG3, GG4, jArr[7], 14, 1735328473);
        GG4 = GG(GG4, GG5, GG2, GG3, jArr[12], 20, 2368359562L);
        GG3 = HH(GG3, GG4, GG5, GG2, jArr[5], 4, 4294588738L);
        long HH = HH(GG2, GG3, GG4, GG5, jArr[8], 11, 2272392833L);
        GG5 = HH(GG5, HH, GG3, GG4, jArr[11], 16, 1839030562);
        GG4 = HH(GG4, GG5, HH, GG3, jArr[14], 23, 4259657740L);
        long HH2 = HH(GG3, GG4, GG5, HH, jArr[1], 4, 2763975236L);
        HH = HH(HH, HH2, GG4, GG5, jArr[4], 11, 1272893353);
        GG5 = HH(GG5, HH, HH2, GG4, jArr[7], 16, 4139469664L);
        long HH3 = HH(GG4, GG5, HH, HH2, jArr[10], 23, 3200236656L);
        HH2 = HH(HH2, HH3, GG5, HH, jArr[13], 4, 681279174);
        HH = HH(HH, HH2, HH3, GG5, jArr[0], 11, 3936430074L);
        long HH4 = HH(GG5, HH, HH2, HH3, jArr[3], 16, 3572445317L);
        HH3 = HH(HH3, HH4, HH, HH2, jArr[6], 23, 76029189);
        HH2 = HH(HH2, HH3, HH4, HH, jArr[9], 4, 3654602809L);
        long HH5 = HH(HH, HH2, HH3, HH4, jArr[12], 11, 3873151461L);
        HH4 = HH(HH4, HH5, HH2, HH3, jArr[15], 16, 530742520);
        HH3 = HH(HH3, HH4, HH5, HH2, jArr[2], 23, 3299628645L);
        long II = II(HH2, HH3, HH4, HH5, jArr[0], 6, 4096336452L);
        HH5 = II(HH5, II, HH3, HH4, jArr[7], 10, 1126891415);
        HH4 = II(HH4, HH5, II, HH3, jArr[14], 15, 2878612391L);
        long II2 = II(HH3, HH4, HH5, II, jArr[5], 21, 4237533241L);
        II = II(II, II2, HH4, HH5, jArr[12], 6, 1700485571);
        HH5 = II(HH5, II, II2, HH4, jArr[3], 10, 2399980690L);
        long II3 = II(HH4, HH5, II, II2, jArr[10], 15, 4293915773L);
        II2 = II(II2, II3, HH5, II, jArr[1], 21, 2240044497L);
        II = II(II, II2, II3, HH5, jArr[8], 6, 1873313359);
        long II4 = II(HH5, II, II2, II3, jArr[15], 10, 4264355552L);
        II3 = II(II3, II4, II, II2, jArr[6], 15, 2734768916L);
        II2 = II(II2, II3, II4, II, jArr[13], 21, 1309151649);
        long II5 = II(II, II2, II3, II4, jArr[4], 6, 4149444226L);
        II4 = II(II4, II5, II2, II3, jArr[11], 10, 3174756917L);
        II3 = II(II3, II4, II5, II2, jArr[2], 15, 718787259);
        j = II(II2, II3, II4, II5, jArr[9], 21, 3951481745L);
        long[] jArr2 = this.state;
        jArr2[0] = jArr2[0] + II5;
        jArr2 = this.state;
        jArr2[1] = j + jArr2[1];
        long[] jArr3 = this.state;
        jArr3[2] = jArr3[2] + II3;
        jArr3 = this.state;
        jArr3[3] = jArr3[3] + II4;
        AppMethodBeat.o(96509);
    }

    private static void Encode(byte[] bArr, long[] jArr, int i) {
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

    private static void a(long[] jArr, byte[] bArr) {
        int i = 0;
        AppMethodBeat.i(96510);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 64) {
                AppMethodBeat.o(96510);
                return;
            }
            jArr[i3] = ((b2iu(bArr[i2]) | (b2iu(bArr[i2 + 1]) << 8)) | (b2iu(bArr[i2 + 2]) << 16)) | (b2iu(bArr[i2 + 3]) << 24);
            i = i3 + 1;
            i2 += 4;
        }
    }

    private static long b2iu(byte b) {
        int b2;
        if (b2 < (byte) 0) {
            b2 = b2 & 255;
        }
        return (long) b2;
    }

    public static byte[] cM(byte[] bArr) {
        AppMethodBeat.i(96511);
        byte[] md5 = new c().getMD5(bArr);
        AppMethodBeat.o(96511);
        return md5;
    }

    public static byte[] awD(String str) {
        byte[] bytes;
        AppMethodBeat.i(96512);
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        bytes = new c().getMD5(bytes);
        AppMethodBeat.o(96512);
        return bytes;
    }

    private static long FF(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 & j3) | ((-1 ^ j2) & j4)) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    private static long GG(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 & j4) | ((-1 ^ j4) & j3)) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    private static long HH(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 ^ j3) ^ j4) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    private static long II(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = (((((-1 ^ j4) | j2) ^ j3) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }
}

package com.tencent.matrix.resource.p164c.p166b;

import com.tencent.matrix.resource.p164c.p165a.C1101b;
import com.tencent.matrix.resource.p164c.p165a.C1102c;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* renamed from: com.tencent.matrix.resource.c.b.a */
public final class C1111a {
    /* renamed from: l */
    public static short m2439l(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) | read2);
        }
        throw new EOFException();
    }

    /* renamed from: m */
    public static int m2440m(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((((read | read2) | read3) | read4) >= 0) {
            return (((read << 24) + (read2 << 16)) + (read3 << 8)) + read4;
        }
        throw new EOFException();
    }

    /* renamed from: n */
    public static long m2441n(InputStream inputStream) {
        byte[] bArr = new byte[8];
        C1111a.m2430a(inputStream, bArr, 8);
        return ((long) (bArr[7] & 255)) + (((((((((long) bArr[0]) << 56) + (((long) (bArr[1] & 255)) << 48)) + (((long) (bArr[2] & 255)) << 40)) + (((long) (bArr[3] & 255)) << 32)) + (((long) (bArr[4] & 255)) << 24)) + ((long) ((bArr[5] & 255) << 16))) + ((long) ((bArr[6] & 255) << 8)));
    }

    /* renamed from: a */
    public static void m2430a(InputStream inputStream, byte[] bArr, long j) {
        int i = 0;
        while (((long) i) < j) {
            int read = inputStream.read(bArr, i, (int) (j - ((long) i)));
            if (read < 0) {
                throw new EOFException();
            }
            i += read;
        }
    }

    /* renamed from: o */
    public static String m2442o(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        int read = inputStream.read();
        while (read != 0) {
            stringBuilder.append((char) read);
            read = inputStream.read();
        }
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public static String m2437c(InputStream inputStream, long j) {
        byte[] bArr = new byte[((int) j)];
        C1111a.m2430a(inputStream, bArr, j);
        return new String(bArr, Charset.forName("UTF-8"));
    }

    /* renamed from: a */
    public static C1101b m2428a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        C1111a.m2430a(inputStream, bArr, (long) i);
        return new C1101b(bArr);
    }

    /* renamed from: a */
    public static Object m2429a(InputStream inputStream, C1102c c1102c, int i) {
        switch (c1102c) {
            case OBJECT:
                return C1111a.m2428a(inputStream, i);
            case BOOLEAN:
                return Boolean.valueOf(inputStream.read() != 0);
            case CHAR:
                return Character.valueOf((char) C1111a.m2439l(inputStream));
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(C1111a.m2440m(inputStream)));
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(C1111a.m2441n(inputStream)));
            case BYTE:
                return Byte.valueOf((byte) inputStream.read());
            case SHORT:
                return Short.valueOf(C1111a.m2439l(inputStream));
            case INT:
                return Integer.valueOf(C1111a.m2440m(inputStream));
            case LONG:
                return Long.valueOf(C1111a.m2441n(inputStream));
            default:
                return null;
        }
    }

    /* renamed from: d */
    public static void m2438d(InputStream inputStream, long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = inputStream.skip(j - j2);
            if (skip < 0) {
                throw new EOFException();
            }
            j2 += skip;
        }
    }

    /* renamed from: b */
    public static int m2434b(InputStream inputStream, C1102c c1102c, int i) {
        int size = c1102c.getSize(i);
        C1111a.m2438d(inputStream, (long) size);
        return size;
    }

    /* renamed from: a */
    public static void m2431a(OutputStream outputStream, int i) {
        outputStream.write((i >>> 8) & 255);
        outputStream.write(i & 255);
    }

    /* renamed from: b */
    public static void m2435b(OutputStream outputStream, int i) {
        outputStream.write((i >>> 24) & 255);
        outputStream.write((i >>> 16) & 255);
        outputStream.write((i >>> 8) & 255);
        outputStream.write(i & 255);
    }

    /* renamed from: a */
    public static void m2432a(OutputStream outputStream, long j) {
        outputStream.write(new byte[]{(byte) ((int) (j >>> 56)), (byte) ((int) (j >>> 48)), (byte) ((int) (j >>> 40)), (byte) ((int) (j >>> 32)), (byte) ((int) (j >>> 24)), (byte) ((int) (j >>> 16)), (byte) ((int) (j >>> 8)), (byte) ((int) j)}, 0, 8);
    }

    /* renamed from: b */
    public static void m2436b(OutputStream outputStream, long j) {
        byte[] bArr = new byte[4096];
        for (int i = 0; ((long) i) < (j >> 12); i++) {
            outputStream.write(bArr);
        }
        outputStream.write(bArr, 0, (int) (4095 & j));
    }

    /* renamed from: a */
    public static void m2433a(OutputStream outputStream, C1101b c1101b) {
        outputStream.write(c1101b.bXC);
    }
}

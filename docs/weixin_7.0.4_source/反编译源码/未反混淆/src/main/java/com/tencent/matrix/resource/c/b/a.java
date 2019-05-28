package com.tencent.matrix.resource.c.b;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.a.c;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class a {
    public static short l(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) | read2);
        }
        throw new EOFException();
    }

    public static int m(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((((read | read2) | read3) | read4) >= 0) {
            return (((read << 24) + (read2 << 16)) + (read3 << 8)) + read4;
        }
        throw new EOFException();
    }

    public static long n(InputStream inputStream) {
        byte[] bArr = new byte[8];
        a(inputStream, bArr, 8);
        return ((long) (bArr[7] & 255)) + (((((((((long) bArr[0]) << 56) + (((long) (bArr[1] & 255)) << 48)) + (((long) (bArr[2] & 255)) << 40)) + (((long) (bArr[3] & 255)) << 32)) + (((long) (bArr[4] & 255)) << 24)) + ((long) ((bArr[5] & 255) << 16))) + ((long) ((bArr[6] & 255) << 8)));
    }

    public static void a(InputStream inputStream, byte[] bArr, long j) {
        int i = 0;
        while (((long) i) < j) {
            int read = inputStream.read(bArr, i, (int) (j - ((long) i)));
            if (read < 0) {
                throw new EOFException();
            }
            i += read;
        }
    }

    public static String o(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        int read = inputStream.read();
        while (read != 0) {
            stringBuilder.append((char) read);
            read = inputStream.read();
        }
        return stringBuilder.toString();
    }

    public static String c(InputStream inputStream, long j) {
        byte[] bArr = new byte[((int) j)];
        a(inputStream, bArr, j);
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static b a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        a(inputStream, bArr, (long) i);
        return new b(bArr);
    }

    public static Object a(InputStream inputStream, c cVar, int i) {
        switch (cVar) {
            case OBJECT:
                return a(inputStream, i);
            case BOOLEAN:
                return Boolean.valueOf(inputStream.read() != 0);
            case CHAR:
                return Character.valueOf((char) l(inputStream));
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(m(inputStream)));
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(n(inputStream)));
            case BYTE:
                return Byte.valueOf((byte) inputStream.read());
            case SHORT:
                return Short.valueOf(l(inputStream));
            case INT:
                return Integer.valueOf(m(inputStream));
            case LONG:
                return Long.valueOf(n(inputStream));
            default:
                return null;
        }
    }

    public static void d(InputStream inputStream, long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = inputStream.skip(j - j2);
            if (skip < 0) {
                throw new EOFException();
            }
            j2 += skip;
        }
    }

    public static int b(InputStream inputStream, c cVar, int i) {
        int size = cVar.getSize(i);
        d(inputStream, (long) size);
        return size;
    }

    public static void a(OutputStream outputStream, int i) {
        outputStream.write((i >>> 8) & 255);
        outputStream.write(i & 255);
    }

    public static void b(OutputStream outputStream, int i) {
        outputStream.write((i >>> 24) & 255);
        outputStream.write((i >>> 16) & 255);
        outputStream.write((i >>> 8) & 255);
        outputStream.write(i & 255);
    }

    public static void a(OutputStream outputStream, long j) {
        outputStream.write(new byte[]{(byte) ((int) (j >>> 56)), (byte) ((int) (j >>> 48)), (byte) ((int) (j >>> 40)), (byte) ((int) (j >>> 32)), (byte) ((int) (j >>> 24)), (byte) ((int) (j >>> 16)), (byte) ((int) (j >>> 8)), (byte) ((int) j)}, 0, 8);
    }

    public static void b(OutputStream outputStream, long j) {
        byte[] bArr = new byte[4096];
        for (int i = 0; ((long) i) < (j >> 12); i++) {
            outputStream.write(bArr);
        }
        outputStream.write(bArr, 0, (int) (4095 & j));
    }

    public static void a(OutputStream outputStream, b bVar) {
        outputStream.write(bVar.bXC);
    }
}

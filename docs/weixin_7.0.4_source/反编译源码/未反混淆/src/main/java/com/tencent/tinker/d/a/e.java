package com.tencent.tinker.d.a;

import java.io.EOFException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

public final class e {
    private static AtomicReference<byte[]> AFo = new AtomicReference();

    public static int N(InputStream inputStream) {
        byte[] bArr = new byte[1];
        if (inputStream.read(bArr, 0, 1) != -1) {
            return bArr[0] & 255;
        }
        return -1;
    }

    public static void b(InputStream inputStream, byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            if (inputStream == null) {
                throw new NullPointerException("in == null");
            } else if (bArr == null) {
                throw new NullPointerException("dst == null");
            } else {
                a.aH(bArr.length, 0, i2);
                while (i2 > 0) {
                    int read = inputStream.read(bArr, i, i2);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i += read;
                    i2 -= read;
                }
            }
        }
    }
}

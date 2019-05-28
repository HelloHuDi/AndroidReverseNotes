package com.tencent.tinker.p676d.p677a;

import java.io.EOFException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.tencent.tinker.d.a.e */
public final class C5930e {
    private static AtomicReference<byte[]> AFo = new AtomicReference();

    /* renamed from: N */
    public static int m9236N(InputStream inputStream) {
        byte[] bArr = new byte[1];
        if (inputStream.read(bArr, 0, 1) != -1) {
            return bArr[0] & 255;
        }
        return -1;
    }

    /* renamed from: b */
    public static void m9237b(InputStream inputStream, byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            if (inputStream == null) {
                throw new NullPointerException("in == null");
            } else if (bArr == null) {
                throw new NullPointerException("dst == null");
            } else {
                C5927a.m9235aH(bArr.length, 0, i2);
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

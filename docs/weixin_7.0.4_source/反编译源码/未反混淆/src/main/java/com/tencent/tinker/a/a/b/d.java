package com.tencent.tinker.a.a.b;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d {
    public static byte[] y(InputStream inputStream) {
        return c(inputStream, 32768);
    }

    public static byte[] c(InputStream inputStream, int i) {
        if (i <= 0) {
            i = 32768;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}

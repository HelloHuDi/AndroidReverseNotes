package com.tencent.tinker.b;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class b {
    public static final boolean a(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                return false;
            }
            i3 += read;
        }
        return true;
    }

    public static byte[] K(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}

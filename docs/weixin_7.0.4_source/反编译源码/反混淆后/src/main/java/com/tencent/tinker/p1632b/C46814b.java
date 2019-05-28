package com.tencent.tinker.p1632b;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.tencent.tinker.b.b */
public final class C46814b {
    /* renamed from: a */
    public static final boolean m89031a(InputStream inputStream, byte[] bArr, int i, int i2) {
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

    /* renamed from: K */
    public static byte[] m89030K(InputStream inputStream) {
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

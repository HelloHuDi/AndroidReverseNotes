package com.tencent.tinker.p668a.p669a.p670b;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.tencent.tinker.a.a.b.d */
public final class C5911d {
    /* renamed from: y */
    public static byte[] m9198y(InputStream inputStream) {
        return C5911d.m9197c(inputStream, 32768);
    }

    /* renamed from: c */
    public static byte[] m9197c(InputStream inputStream, int i) {
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

package com.tencent.matrix.resource.p161a.p162a;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.matrix.resource.a.a.c */
public final class C1095c {
    /* renamed from: ah */
    public static void m2411ah(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof ZipFile) {
                    ((ZipFile) obj).close();
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public static void m2410a(File file, OutputStream outputStream) {
        Throwable th;
        byte[] bArr = new byte[4096];
        Object bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        C1095c.m2411ah(bufferedInputStream);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C1095c.m2411ah(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            C1095c.m2411ah(bufferedInputStream);
            throw th;
        }
    }
}

package com.tencent.matrix.resource.a.a;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public final class c {
    public static void ah(Object obj) {
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

    public static void a(File file, OutputStream outputStream) {
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
                        ah(bufferedInputStream);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ah(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            ah(bufferedInputStream);
            throw th;
        }
    }
}

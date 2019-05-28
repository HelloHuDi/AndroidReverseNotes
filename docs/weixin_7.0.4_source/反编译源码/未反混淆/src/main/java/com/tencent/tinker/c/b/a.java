package com.tencent.tinker.c.b;

import java.io.Closeable;
import java.util.zip.ZipFile;

public final class a {
    public static void ah(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof AutoCloseable) {
                    ((AutoCloseable) obj).close();
                } else if (obj instanceof ZipFile) {
                    ((ZipFile) obj).close();
                }
            } catch (Throwable th) {
            }
        }
    }
}

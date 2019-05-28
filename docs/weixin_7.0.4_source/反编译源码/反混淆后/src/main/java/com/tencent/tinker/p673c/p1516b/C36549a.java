package com.tencent.tinker.p673c.p1516b;

import java.io.Closeable;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.tinker.c.b.a */
public final class C36549a {
    /* renamed from: ah */
    public static void m60575ah(Object obj) {
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

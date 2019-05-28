package com.tencent.tinker.p676d.p677a;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* renamed from: com.tencent.tinker.d.a.i */
public final class C5936i {
    /* renamed from: a */
    public static void m9251a(C5934g c5934g, C5931f c5931f, C5935h c5935h) {
        InputStream inputStream = null;
        try {
            inputStream = c5934g.mo12614a(c5931f);
            c5935h.mo12619b(new C5931f(c5931f));
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                c5935h.write(bArr, 0, read);
            }
            c5935h.closeEntry();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /* renamed from: a */
    public static void m9250a(C5931f c5931f, InputStream inputStream, C5935h c5935h) {
        c5935h.mo12619b(c5931f);
        byte[] bArr = new byte[16384];
        int read = inputStream.read(bArr);
        while (read != -1) {
            c5935h.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        c5935h.closeEntry();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m9249a(C5931f c5931f, File file, long j, C5935h c5935h) {
        Throwable th;
        C5931f c5931f2 = new C5931f(c5931f);
        c5931f2.setMethod(0);
        c5931f2.setSize(file.length());
        c5931f2.AFp = file.length();
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Bad CRC32: ".concat(String.valueOf(j)));
        }
        c5931f2.AFe = j;
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                c5935h.mo12619b(new C5931f(c5931f2));
                byte[] bArr = new byte[16384];
                for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                    c5935h.write(bArr, 0, read);
                }
                c5935h.closeEntry();
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }
}

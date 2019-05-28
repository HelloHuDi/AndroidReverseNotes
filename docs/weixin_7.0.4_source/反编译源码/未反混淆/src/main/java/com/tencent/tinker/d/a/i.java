package com.tencent.tinker.d.a;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class i {
    public static void a(g gVar, f fVar, h hVar) {
        InputStream inputStream = null;
        try {
            inputStream = gVar.a(fVar);
            hVar.b(new f(fVar));
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                hVar.write(bArr, 0, read);
            }
            hVar.closeEntry();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void a(f fVar, InputStream inputStream, h hVar) {
        hVar.b(fVar);
        byte[] bArr = new byte[16384];
        int read = inputStream.read(bArr);
        while (read != -1) {
            hVar.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        hVar.closeEntry();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(f fVar, File file, long j, h hVar) {
        Throwable th;
        f fVar2 = new f(fVar);
        fVar2.setMethod(0);
        fVar2.setSize(file.length());
        fVar2.AFp = file.length();
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Bad CRC32: ".concat(String.valueOf(j)));
        }
        fVar2.AFe = j;
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                hVar.b(new f(fVar2));
                byte[] bArr = new byte[16384];
                for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                    hVar.write(bArr, 0, read);
                }
                hVar.closeEntry();
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

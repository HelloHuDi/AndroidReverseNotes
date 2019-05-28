package com.tencent.tinker.lib.c;

import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class b {
    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str, boolean z) {
        Object bufferedInputStream;
        Throwable th;
        Object obj;
        boolean z2 = false;
        int i = 0;
        while (i < 2 && !z2) {
            int i2 = i + 1;
            a.i("Tinker.BasePatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                BufferedOutputStream bufferedOutputStream;
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th2) {
                    th = th2;
                    obj = null;
                    com.tencent.tinker.c.b.a.ah(obj);
                    com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    com.tencent.tinker.c.b.a.ah(bufferedOutputStream);
                    com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                    z2 = str != null ? z ? SharePatchFileUtil.h(file, str) : SharePatchFileUtil.g(file, str) : true;
                    a.i("Tinker.BasePatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z2));
                    if (!z2 && (!file.delete() || file.exists())) {
                        a.e("Tinker.BasePatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                    }
                    i = i2;
                } catch (Throwable th3) {
                    th = th3;
                    obj = bufferedOutputStream;
                    com.tencent.tinker.c.b.a.ah(obj);
                    com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = null;
                bufferedInputStream = null;
                com.tencent.tinker.c.b.a.ah(obj);
                com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                throw th;
            }
        }
        return z2;
    }

    public static int RZ(int i) {
        if (i == 3) {
            return -3;
        }
        if (i == 5) {
            return -4;
        }
        if (i == 6) {
            return -8;
        }
        return 0;
    }
}

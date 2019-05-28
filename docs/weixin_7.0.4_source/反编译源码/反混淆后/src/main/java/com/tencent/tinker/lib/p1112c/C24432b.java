package com.tencent.tinker.lib.p1112c;

import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.p673c.p1516b.C36549a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.tinker.lib.c.b */
public class C24432b {
    /* renamed from: a */
    public static boolean m38049a(ZipFile zipFile, ZipEntry zipEntry, File file, String str, boolean z) {
        Object bufferedInputStream;
        Throwable th;
        Object obj;
        boolean z2 = false;
        int i = 0;
        while (i < 2 && !z2) {
            int i2 = i + 1;
            C5952a.m9284i("Tinker.BasePatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                BufferedOutputStream bufferedOutputStream;
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th2) {
                    th = th2;
                    obj = null;
                    C36549a.m60575ah(obj);
                    C36549a.m60575ah(bufferedInputStream);
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
                    C36549a.m60575ah(bufferedOutputStream);
                    C36549a.m60575ah(bufferedInputStream);
                    z2 = str != null ? z ? SharePatchFileUtil.m9380h(file, str) : SharePatchFileUtil.m9379g(file, str) : true;
                    C5952a.m9284i("Tinker.BasePatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z2));
                    if (!z2 && (!file.delete() || file.exists())) {
                        C5952a.m9283e("Tinker.BasePatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                    }
                    i = i2;
                } catch (Throwable th3) {
                    th = th3;
                    obj = bufferedOutputStream;
                    C36549a.m60575ah(obj);
                    C36549a.m60575ah(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = null;
                bufferedInputStream = null;
                C36549a.m60575ah(obj);
                C36549a.m60575ah(bufferedInputStream);
                throw th;
            }
        }
        return z2;
    }

    /* renamed from: RZ */
    public static int m38048RZ(int i) {
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

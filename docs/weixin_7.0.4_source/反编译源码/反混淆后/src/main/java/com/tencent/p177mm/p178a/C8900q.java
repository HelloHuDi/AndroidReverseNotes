package com.tencent.p177mm.p178a;

import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: com.tencent.mm.a.q */
public final class C8900q {
    /* renamed from: a */
    public static void m16037a(Collection<File> collection, File file) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        for (File file2 : collection) {
            if (file2.exists()) {
                C8900q.m16036a(file2, zipOutputStream, "");
            }
        }
        zipOutputStream.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m16036a(File file, ZipOutputStream zipOutputStream, String str) {
        Throwable e;
        String str2 = str + (str.trim().length() == 0 ? "" : File.separator) + file.getName();
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                C8900q.m16036a(a, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file), WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            try {
                zipOutputStream.putNextEntry(new ZipEntry(str2));
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.ZipUtil", e, "", new Object[0]);
                    if (bufferedInputStream != null) {
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                } catch (Throwable th) {
                    e = th;
                    if (bufferedInputStream != null) {
                    }
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.ZipUtil", e, "", new Object[0]);
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            zipOutputStream.flush();
            zipOutputStream.closeEntry();
        } catch (Throwable th2) {
            e = th2;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw e;
        }
        zipOutputStream.flush();
        zipOutputStream.closeEntry();
    }

    /* renamed from: b */
    public static String m16038b(File file, boolean z, String str) {
        int i = 0;
        if (str != null) {
            File parentFile = new File(str).getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
        }
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
            if (str == null) {
                str = file.getAbsolutePath() + File.separator + file.getName() + ".zip";
            }
        } else {
            arrayList.add(file);
            if (str == null) {
                str = file.getAbsoluteFile().getParentFile().getAbsolutePath() + File.separator + file.getName() + ".zip";
            }
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            C8900q.m16037a(arrayList, file2);
            if (z) {
                while (i < arrayList.size()) {
                    ((File) arrayList.get(i)).delete();
                    i++;
                }
            }
            return file2.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }
}

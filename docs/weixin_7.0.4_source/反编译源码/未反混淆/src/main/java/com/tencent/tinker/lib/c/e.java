package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.d.a.d;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class e extends b {
    static boolean c(Context context, String str, String str2, File file) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.a(str2, shareResPatchInfo);
        a.i("Tinker.ResDiffPatchInternal", "res dir: %s, meta: %s", str, shareResPatchInfo.toString());
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(context);
        if (SharePatchFileUtil.aus(shareResPatchInfo.AEW)) {
            File file2 = new File(str);
            File file3 = new File(file2, "res_temp");
            File file4 = new File(file2, "resources.apk");
            if (!file4.exists()) {
                file4.getParentFile().mkdirs();
            } else if (SharePatchFileUtil.i(file4, shareResPatchInfo.AEW)) {
                a.w("Tinker.ResDiffPatchInternal", "resource file %s is already exist, and md5 match, just return true", file4.getPath());
                return true;
            } else {
                a.w("Tinker.ResDiffPatchInternal", "have a mismatch corrupted resource " + file4.getPath(), new Object[0]);
                file4.delete();
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo == null) {
                    a.w("Tinker.ResDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                    return false;
                }
                String str3 = applicationInfo.sourceDir;
                if (!a(context, str3, file2, file3, file, shareResPatchInfo)) {
                    return false;
                }
                try {
                    g gVar;
                    h obj32 = new h(new BufferedOutputStream(new FileOutputStream(file4)));
                    try {
                        gVar = new g(str3);
                    } catch (Throwable th2) {
                        th = th2;
                        obj = null;
                        obj2 = null;
                        com.tencent.tinker.c.b.a.ah(obj32);
                        com.tencent.tinker.c.b.a.ah(obj2);
                        com.tencent.tinker.c.b.a.ah(obj);
                        SharePatchFileUtil.t(file3);
                        throw th;
                    }
                    try {
                        g gVar2 = new g(file);
                        try {
                            f fVar;
                            Enumeration entries = gVar.entries();
                            int i = 0;
                            while (entries.hasMoreElements()) {
                                fVar = (f) entries.nextElement();
                                if (fVar == null) {
                                    throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                                }
                                String str4 = fVar.name;
                                if (!str4.contains("../")) {
                                    int i2;
                                    if (!ShareResPatchInfo.a(shareResPatchInfo.AFd, str4) || shareResPatchInfo.AEY.contains(str4) || shareResPatchInfo.AEZ.contains(str4) || shareResPatchInfo.AFb.contains(str4) || str4.equals("AndroidManifest.xml")) {
                                        i2 = i;
                                    } else {
                                        i.a(gVar, fVar, obj32);
                                        i2 = i + 1;
                                    }
                                    i = i2;
                                }
                            }
                            fVar = gVar.auw("AndroidManifest.xml");
                            if (fVar == null) {
                                a.w("Tinker.ResDiffPatchInternal", "manifest patch entry is null. path:AndroidManifest.xml", new Object[0]);
                                iX.ABF.a(file, file4, "AndroidManifest.xml", 6);
                                com.tencent.tinker.c.b.a.ah(obj32);
                                com.tencent.tinker.c.b.a.ah(gVar);
                                com.tencent.tinker.c.b.a.ah(gVar2);
                                SharePatchFileUtil.t(file3);
                                return false;
                            }
                            String str5;
                            f auw;
                            i.a(gVar, fVar, obj32);
                            i++;
                            Iterator it = shareResPatchInfo.AFb.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                auw = gVar.auw(str5);
                                if (auw == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "large patch entry is null. path:".concat(String.valueOf(str5)), new Object[0]);
                                    iX.ABF.a(file, file4, str5, 6);
                                    com.tencent.tinker.c.b.a.ah(obj32);
                                    com.tencent.tinker.c.b.a.ah(gVar);
                                    com.tencent.tinker.c.b.a.ah(gVar2);
                                    SharePatchFileUtil.t(file3);
                                    return false;
                                }
                                LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.AFc.get(str5);
                                i.a(auw, largeModeInfo.file, largeModeInfo.AFe, obj32);
                                i++;
                            }
                            it = shareResPatchInfo.AEX.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                auw = gVar2.auw(str5);
                                if (auw == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "add patch entry is null. path:".concat(String.valueOf(str5)), new Object[0]);
                                    iX.ABF.a(file, file4, str5, 6);
                                    com.tencent.tinker.c.b.a.ah(obj32);
                                    com.tencent.tinker.c.b.a.ah(gVar);
                                    com.tencent.tinker.c.b.a.ah(gVar2);
                                    SharePatchFileUtil.t(file3);
                                    return false;
                                }
                                if (shareResPatchInfo.AFa.containsKey(str5)) {
                                    i.a(auw, (File) shareResPatchInfo.AFa.get(str5), auw.AFe, obj32);
                                } else {
                                    i.a(gVar2, auw, obj32);
                                }
                                i++;
                            }
                            it = shareResPatchInfo.AEZ.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                auw = gVar2.auw(str5);
                                if (auw == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "mod patch entry is null. path:".concat(String.valueOf(str5)), new Object[0]);
                                    iX.ABF.a(file, file4, str5, 6);
                                    com.tencent.tinker.c.b.a.ah(obj32);
                                    com.tencent.tinker.c.b.a.ah(gVar);
                                    com.tencent.tinker.c.b.a.ah(gVar2);
                                    SharePatchFileUtil.t(file3);
                                    return false;
                                }
                                if (shareResPatchInfo.AFa.containsKey(str5)) {
                                    i.a(auw, (File) shareResPatchInfo.AFa.get(str5), auw.AFe, obj32);
                                } else {
                                    i.a(gVar2, auw, obj32);
                                }
                                i++;
                            }
                            gVar.lO();
                            str5 = gVar.vGv;
                            if (str5 == null) {
                                obj32.AFE = h.AFA;
                            } else {
                                byte[] bytes = str5.getBytes(d.UTF_8);
                                h.G("Comment", bytes);
                                obj32.AFE = bytes;
                            }
                            com.tencent.tinker.c.b.a.ah(obj32);
                            com.tencent.tinker.c.b.a.ah(gVar);
                            com.tencent.tinker.c.b.a.ah(gVar2);
                            SharePatchFileUtil.t(file3);
                            if (SharePatchFileUtil.i(file4, shareResPatchInfo.AEW)) {
                                a.i("Tinker.ResDiffPatchInternal", "final new resource file:%s, entry count:%d, size:%d", file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length()));
                                return true;
                            }
                            a.i("Tinker.ResDiffPatchInternal", "check final new resource file fail path:%s, entry count:%d, size:%d", file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length()));
                            SharePatchFileUtil.as(file4);
                            iX.ABF.a(file, file4, "resources.apk", 6);
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            obj = gVar2;
                            obj2 = gVar;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = null;
                        g obj22 = gVar;
                        com.tencent.tinker.c.b.a.ah(obj32);
                        com.tencent.tinker.c.b.a.ah(obj22);
                        com.tencent.tinker.c.b.a.ah(obj);
                        SharePatchFileUtil.t(file3);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    obj = null;
                    obj22 = null;
                    obj32 = null;
                    com.tencent.tinker.c.b.a.ah(obj32);
                    com.tencent.tinker.c.b.a.ah(obj22);
                    com.tencent.tinker.c.b.a.ah(obj);
                    SharePatchFileUtil.t(file3);
                    throw th;
                }
            } catch (Throwable th6) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("patch " + ShareTinkerInternals.Sd(6) + " extract failed (" + th6.getMessage() + ").", th6);
            }
        } else {
            a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, md5: %s", ShareTinkerInternals.Sd(6), shareResPatchInfo.AEW);
            iX.ABF.e(file, b.RZ(6));
            return false;
        }
    }

    private static boolean a(Context context, String str, File file, File file2, File file3, ShareResPatchInfo shareResPatchInfo) {
        Throwable th;
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(context);
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3;
        ZipFile zipFile4;
        try {
            zipFile3 = new ZipFile(str);
            try {
                ZipEntry entry = zipFile3.getEntry("resources.arsc");
                File file4 = new File(file, "resources.arsc");
                if (entry == null) {
                    a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:resources.arsc", new Object[0]);
                    iX.ABF.a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                }
                if (!String.valueOf(entry.getCrc()).equals(shareResPatchInfo.AEV)) {
                    a.e("Tinker.ResDiffPatchInternal", "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", shareResPatchInfo.AEV, String.valueOf(entry.getCrc()));
                    iX.ABF.a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                } else if (shareResPatchInfo.AFb.isEmpty() && shareResPatchInfo.AFa.isEmpty()) {
                    a.i("Tinker.ResDiffPatchInternal", "no large modify or store resources, just return", new Object[0]);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return true;
                } else {
                    zipFile4 = new ZipFile(file3);
                    try {
                        String str2;
                        for (String str22 : shareResPatchInfo.AFa.keySet()) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            File file5 = new File(file2, str22);
                            SharePatchFileUtil.au(file5);
                            ZipEntry entry2 = zipFile4.getEntry(str22);
                            if (entry2 == null) {
                                a.w("Tinker.ResDiffPatchInternal", "store patch entry is null. path:".concat(String.valueOf(str22)), new Object[0]);
                                iX.ABF.a(file3, file5, str22, 6);
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            b.a(zipFile4, entry2, file5, null, false);
                            if (entry2.getSize() != file5.length()) {
                                a.w("Tinker.ResDiffPatchInternal", "resource meta file size mismatch, type:%s, name: %s, patch size: %d, file size; %d", ShareTinkerInternals.Sd(6), str22, Long.valueOf(entry2.getSize()), Long.valueOf(file5.length()));
                                iX.ABF.e(file3, b.RZ(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            shareResPatchInfo.AFa.put(str22, file5);
                            a.w("Tinker.ResDiffPatchInternal", "success recover store file:%s, file size:%d, use time:%d", file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        }
                        Iterator it = shareResPatchInfo.AFb.iterator();
                        while (it.hasNext()) {
                            str22 = (String) it.next();
                            long currentTimeMillis3 = System.currentTimeMillis();
                            LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.AFc.get(str22);
                            if (largeModeInfo == null) {
                                a.w("Tinker.ResDiffPatchInternal", "resource not found largeModeInfo, type:%s, name: %s", ShareTinkerInternals.Sd(6), str22);
                                iX.ABF.e(file3, b.RZ(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            largeModeInfo.file = new File(file2, str22);
                            SharePatchFileUtil.au(largeModeInfo.file);
                            if (SharePatchFileUtil.aus(largeModeInfo.cvZ)) {
                                ZipEntry entry3 = zipFile4.getEntry(str22);
                                if (entry3 == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "large mod patch entry is null. path:".concat(String.valueOf(str22)), new Object[0]);
                                    iX.ABF.a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                                ZipEntry entry4 = zipFile3.getEntry(str22);
                                if (entry4 == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:".concat(String.valueOf(str22)), new Object[0]);
                                    iX.ABF.a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                                Object obj2 = null;
                                Object obj3 = null;
                                try {
                                    obj2 = zipFile3.getInputStream(entry4);
                                    InputStream inputStream = zipFile4.getInputStream(entry3);
                                    try {
                                        com.tencent.tinker.b.a.a(obj2, inputStream, largeModeInfo.file);
                                        com.tencent.tinker.c.b.a.ah(obj2);
                                        com.tencent.tinker.c.b.a.ah(inputStream);
                                        if (SharePatchFileUtil.g(largeModeInfo.file, largeModeInfo.cvZ)) {
                                            a.w("Tinker.ResDiffPatchInternal", "success recover large modify file:%s, file size:%d, use time:%d", largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                        } else {
                                            a.w("Tinker.ResDiffPatchInternal", "Failed to recover large modify file:%s", largeModeInfo.file.getPath());
                                            SharePatchFileUtil.as(largeModeInfo.file);
                                            iX.ABF.a(file3, largeModeInfo.file, str22, 6);
                                            SharePatchFileUtil.a(zipFile3);
                                            SharePatchFileUtil.a(zipFile4);
                                            return false;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        InputStream obj4 = inputStream;
                                        com.tencent.tinker.c.b.a.ah(obj2);
                                        com.tencent.tinker.c.b.a.ah(obj4);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj4 = obj3;
                                }
                            } else {
                                a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.Sd(6), str22, largeModeInfo.cvZ);
                                iX.ABF.e(file3, b.RZ(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                        }
                        a.w("Tinker.ResDiffPatchInternal", "success recover all large modify and store resources use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        SharePatchFileUtil.a(zipFile3);
                        SharePatchFileUtil.a(zipFile4);
                        return true;
                    } catch (Throwable th4) {
                        th = th4;
                        SharePatchFileUtil.a(zipFile3);
                        SharePatchFileUtil.a(zipFile4);
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                zipFile4 = null;
                SharePatchFileUtil.a(zipFile3);
                SharePatchFileUtil.a(zipFile4);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.a(zipFile3);
            SharePatchFileUtil.a(zipFile4);
            throw th;
        }
    }
}

package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class c extends b {
    static boolean a(Context context, String str, String str2, File file) {
        ZipFile zipFile;
        ZipFile zipFile2;
        Throwable th;
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.n(str2, arrayList);
        if (arrayList.isEmpty()) {
            a.w("Tinker.BsDiffPatchInternal", "extract patch list is empty! type:%s:", ShareTinkerInternals.Sd(5));
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(context);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            a.w("Tinker.BsDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
            return false;
        }
        ZipFile zipFile3 = null;
        ZipFile zipFile4 = null;
        try {
            zipFile = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile2 = new ZipFile(file);
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = null;
                SharePatchFileUtil.a(zipFile);
                SharePatchFileUtil.a(zipFile2);
                throw th;
            }
            Object obj;
            Object obj2;
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str3;
                    ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (shareBsDiffPatchInfo.path.equals("")) {
                        str3 = shareBsDiffPatchInfo.name;
                    } else {
                        str3 = shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name;
                    }
                    String str4 = shareBsDiffPatchInfo.cvZ;
                    if (SharePatchFileUtil.aus(str4)) {
                        File file3 = new File(str + (shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name));
                        if (!file3.exists()) {
                            file3.getParentFile().mkdirs();
                        } else if (str4.equals(SharePatchFileUtil.at(file3))) {
                            a.w("Tinker.BsDiffPatchInternal", "bsdiff file %s is already exist, and md5 match, just continue", file3.getPath());
                        } else {
                            a.w("Tinker.BsDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                            file3.delete();
                        }
                        String str5 = shareBsDiffPatchInfo.cdy;
                        ZipEntry entry = zipFile2.getEntry(str3);
                        if (entry == null) {
                            a.w("Tinker.BsDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                            iX.ABF.a(file, file3, shareBsDiffPatchInfo.name, 5);
                            SharePatchFileUtil.a(zipFile);
                            SharePatchFileUtil.a(zipFile2);
                            return false;
                        } else if (str5.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            if (!b.a(zipFile2, entry, file3, str4, false)) {
                                a.w("Tinker.BsDiffPatchInternal", "Failed to extract file " + file3.getPath(), new Object[0]);
                                iX.ABF.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                SharePatchFileUtil.a(zipFile);
                                SharePatchFileUtil.a(zipFile2);
                                return false;
                            }
                        } else if (SharePatchFileUtil.aus(str5)) {
                            ZipEntry entry2 = zipFile.getEntry(str3);
                            if (entry2 == null) {
                                a.w("Tinker.BsDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                iX.ABF.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                SharePatchFileUtil.a(zipFile);
                                SharePatchFileUtil.a(zipFile2);
                                return false;
                            }
                            str5 = shareBsDiffPatchInfo.ADL;
                            if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                obj = null;
                                obj2 = null;
                                obj = zipFile.getInputStream(entry2);
                                obj2 = zipFile2.getInputStream(entry);
                                com.tencent.tinker.b.a.a(obj, obj2, file3);
                                com.tencent.tinker.c.b.a.ah(obj);
                                com.tencent.tinker.c.b.a.ah(obj2);
                                if (SharePatchFileUtil.g(file3, str4)) {
                                    a.w("Tinker.BsDiffPatchInternal", "success recover bsdiff file: %s, use time: %d", file3.getPath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                } else {
                                    a.w("Tinker.BsDiffPatchInternal", "Failed to recover diff file " + file3.getPath(), new Object[0]);
                                    iX.ABF.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                    SharePatchFileUtil.as(file3);
                                    SharePatchFileUtil.a(zipFile);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                }
                            }
                            a.e("Tinker.BsDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, String.valueOf(entry2.getCrc()));
                            iX.ABF.a(file, file3, shareBsDiffPatchInfo.name, 5);
                            SharePatchFileUtil.a(zipFile);
                            SharePatchFileUtil.a(zipFile2);
                            return false;
                        } else {
                            a.w("Tinker.BsDiffPatchInternal", "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.Sd(5), shareBsDiffPatchInfo.name, str5);
                            iX.ABF.e(file, b.RZ(5));
                            SharePatchFileUtil.a(zipFile);
                            SharePatchFileUtil.a(zipFile2);
                            return false;
                        }
                    }
                    a.w("Tinker.BsDiffPatchInternal", "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.Sd(5), shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.cvZ);
                    iX.ABF.e(file, b.RZ(5));
                    SharePatchFileUtil.a(zipFile);
                    SharePatchFileUtil.a(zipFile2);
                    return false;
                }
                SharePatchFileUtil.a(zipFile);
                SharePatchFileUtil.a(zipFile2);
                return true;
            } catch (Throwable th3) {
                th = th3;
                SharePatchFileUtil.a(zipFile);
                SharePatchFileUtil.a(zipFile2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile2 = null;
            zipFile = null;
            SharePatchFileUtil.a(zipFile);
            SharePatchFileUtil.a(zipFile2);
            throw th;
        }
    }
}

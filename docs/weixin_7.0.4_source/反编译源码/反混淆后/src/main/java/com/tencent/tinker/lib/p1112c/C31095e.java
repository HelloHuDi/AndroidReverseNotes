package com.tencent.tinker.lib.p1112c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.p1632b.C44549a;
import com.tencent.tinker.p673c.p1516b.C36549a;
import com.tencent.tinker.p676d.p677a.C5929d;
import com.tencent.tinker.p676d.p677a.C5931f;
import com.tencent.tinker.p676d.p677a.C5934g;
import com.tencent.tinker.p676d.p677a.C5935h;
import com.tencent.tinker.p676d.p677a.C5936i;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.tinker.lib.c.e */
public final class C31095e extends C24432b {
    /* renamed from: c */
    static boolean m50178c(Context context, String str, String str2, File file) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.m9402a(str2, shareResPatchInfo);
        C5952a.m9284i("Tinker.ResDiffPatchInternal", "res dir: %s, meta: %s", str, shareResPatchInfo.toString());
        C31097a iX = C31097a.m50180iX(context);
        if (SharePatchFileUtil.aus(shareResPatchInfo.AEW)) {
            File file2 = new File(str);
            File file3 = new File(file2, "res_temp");
            File file4 = new File(file2, "resources.apk");
            if (!file4.exists()) {
                file4.getParentFile().mkdirs();
            } else if (SharePatchFileUtil.m9381i(file4, shareResPatchInfo.AEW)) {
                C5952a.m9285w("Tinker.ResDiffPatchInternal", "resource file %s is already exist, and md5 match, just return true", file4.getPath());
                return true;
            } else {
                C5952a.m9285w("Tinker.ResDiffPatchInternal", "have a mismatch corrupted resource " + file4.getPath(), new Object[0]);
                file4.delete();
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo == null) {
                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                    return false;
                }
                String str3 = applicationInfo.sourceDir;
                if (!C31095e.m50177a(context, str3, file2, file3, file, shareResPatchInfo)) {
                    return false;
                }
                try {
                    C5934g c5934g;
                    C5935h obj32 = new C5935h(new BufferedOutputStream(new FileOutputStream(file4)));
                    try {
                        c5934g = new C5934g(str3);
                    } catch (Throwable th2) {
                        th = th2;
                        obj = null;
                        obj2 = null;
                        C36549a.m60575ah(obj32);
                        C36549a.m60575ah(obj2);
                        C36549a.m60575ah(obj);
                        SharePatchFileUtil.m9388t(file3);
                        throw th;
                    }
                    try {
                        C5934g c5934g2 = new C5934g(file);
                        try {
                            C5931f c5931f;
                            Enumeration entries = c5934g.entries();
                            int i = 0;
                            while (entries.hasMoreElements()) {
                                c5931f = (C5931f) entries.nextElement();
                                if (c5931f == null) {
                                    throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                                }
                                String str4 = c5931f.name;
                                if (!str4.contains("../")) {
                                    int i2;
                                    if (!ShareResPatchInfo.m9404a(shareResPatchInfo.AFd, str4) || shareResPatchInfo.AEY.contains(str4) || shareResPatchInfo.AEZ.contains(str4) || shareResPatchInfo.AFb.contains(str4) || str4.equals("AndroidManifest.xml")) {
                                        i2 = i;
                                    } else {
                                        C5936i.m9251a(c5934g, c5931f, obj32);
                                        i2 = i + 1;
                                    }
                                    i = i2;
                                }
                            }
                            c5931f = c5934g.auw("AndroidManifest.xml");
                            if (c5931f == null) {
                                C5952a.m9285w("Tinker.ResDiffPatchInternal", "manifest patch entry is null. path:AndroidManifest.xml", new Object[0]);
                                iX.ABF.mo40778a(file, file4, "AndroidManifest.xml", 6);
                                C36549a.m60575ah(obj32);
                                C36549a.m60575ah(c5934g);
                                C36549a.m60575ah(c5934g2);
                                SharePatchFileUtil.m9388t(file3);
                                return false;
                            }
                            String str5;
                            C5931f auw;
                            C5936i.m9251a(c5934g, c5931f, obj32);
                            i++;
                            Iterator it = shareResPatchInfo.AFb.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                auw = c5934g.auw(str5);
                                if (auw == null) {
                                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "large patch entry is null. path:".concat(String.valueOf(str5)), new Object[0]);
                                    iX.ABF.mo40778a(file, file4, str5, 6);
                                    C36549a.m60575ah(obj32);
                                    C36549a.m60575ah(c5934g);
                                    C36549a.m60575ah(c5934g2);
                                    SharePatchFileUtil.m9388t(file3);
                                    return false;
                                }
                                LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.AFc.get(str5);
                                C5936i.m9249a(auw, largeModeInfo.file, largeModeInfo.AFe, obj32);
                                i++;
                            }
                            it = shareResPatchInfo.AEX.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                auw = c5934g2.auw(str5);
                                if (auw == null) {
                                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "add patch entry is null. path:".concat(String.valueOf(str5)), new Object[0]);
                                    iX.ABF.mo40778a(file, file4, str5, 6);
                                    C36549a.m60575ah(obj32);
                                    C36549a.m60575ah(c5934g);
                                    C36549a.m60575ah(c5934g2);
                                    SharePatchFileUtil.m9388t(file3);
                                    return false;
                                }
                                if (shareResPatchInfo.AFa.containsKey(str5)) {
                                    C5936i.m9249a(auw, (File) shareResPatchInfo.AFa.get(str5), auw.AFe, obj32);
                                } else {
                                    C5936i.m9251a(c5934g2, auw, obj32);
                                }
                                i++;
                            }
                            it = shareResPatchInfo.AEZ.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                auw = c5934g2.auw(str5);
                                if (auw == null) {
                                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "mod patch entry is null. path:".concat(String.valueOf(str5)), new Object[0]);
                                    iX.ABF.mo40778a(file, file4, str5, 6);
                                    C36549a.m60575ah(obj32);
                                    C36549a.m60575ah(c5934g);
                                    C36549a.m60575ah(c5934g2);
                                    SharePatchFileUtil.m9388t(file3);
                                    return false;
                                }
                                if (shareResPatchInfo.AFa.containsKey(str5)) {
                                    C5936i.m9249a(auw, (File) shareResPatchInfo.AFa.get(str5), auw.AFe, obj32);
                                } else {
                                    C5936i.m9251a(c5934g2, auw, obj32);
                                }
                                i++;
                            }
                            c5934g.mo12618lO();
                            str5 = c5934g.vGv;
                            if (str5 == null) {
                                obj32.AFE = C5935h.AFA;
                            } else {
                                byte[] bytes = str5.getBytes(C5929d.UTF_8);
                                C5935h.m9245G("Comment", bytes);
                                obj32.AFE = bytes;
                            }
                            C36549a.m60575ah(obj32);
                            C36549a.m60575ah(c5934g);
                            C36549a.m60575ah(c5934g2);
                            SharePatchFileUtil.m9388t(file3);
                            if (SharePatchFileUtil.m9381i(file4, shareResPatchInfo.AEW)) {
                                C5952a.m9284i("Tinker.ResDiffPatchInternal", "final new resource file:%s, entry count:%d, size:%d", file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length()));
                                return true;
                            }
                            C5952a.m9284i("Tinker.ResDiffPatchInternal", "check final new resource file fail path:%s, entry count:%d, size:%d", file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length()));
                            SharePatchFileUtil.m9373as(file4);
                            iX.ABF.mo40778a(file, file4, "resources.apk", 6);
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            obj = c5934g2;
                            obj2 = c5934g;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = null;
                        C5934g obj22 = c5934g;
                        C36549a.m60575ah(obj32);
                        C36549a.m60575ah(obj22);
                        C36549a.m60575ah(obj);
                        SharePatchFileUtil.m9388t(file3);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    obj = null;
                    obj22 = null;
                    obj32 = null;
                    C36549a.m60575ah(obj32);
                    C36549a.m60575ah(obj22);
                    C36549a.m60575ah(obj);
                    SharePatchFileUtil.m9388t(file3);
                    throw th;
                }
            } catch (Throwable th6) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("patch " + ShareTinkerInternals.m9412Sd(6) + " extract failed (" + th6.getMessage() + ").", th6);
            }
        } else {
            C5952a.m9285w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, md5: %s", ShareTinkerInternals.m9412Sd(6), shareResPatchInfo.AEW);
            iX.ABF.mo40784e(file, C24432b.m38048RZ(6));
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m50177a(Context context, String str, File file, File file2, File file3, ShareResPatchInfo shareResPatchInfo) {
        Throwable th;
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        C31097a iX = C31097a.m50180iX(context);
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
                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:resources.arsc", new Object[0]);
                    iX.ABF.mo40778a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.m9368a(zipFile3);
                    SharePatchFileUtil.m9368a(null);
                    return false;
                }
                if (!String.valueOf(entry.getCrc()).equals(shareResPatchInfo.AEV)) {
                    C5952a.m9283e("Tinker.ResDiffPatchInternal", "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", shareResPatchInfo.AEV, String.valueOf(entry.getCrc()));
                    iX.ABF.mo40778a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.m9368a(zipFile3);
                    SharePatchFileUtil.m9368a(null);
                    return false;
                } else if (shareResPatchInfo.AFb.isEmpty() && shareResPatchInfo.AFa.isEmpty()) {
                    C5952a.m9284i("Tinker.ResDiffPatchInternal", "no large modify or store resources, just return", new Object[0]);
                    SharePatchFileUtil.m9368a(zipFile3);
                    SharePatchFileUtil.m9368a(null);
                    return true;
                } else {
                    zipFile4 = new ZipFile(file3);
                    try {
                        String str2;
                        for (String str22 : shareResPatchInfo.AFa.keySet()) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            File file5 = new File(file2, str22);
                            SharePatchFileUtil.m9375au(file5);
                            ZipEntry entry2 = zipFile4.getEntry(str22);
                            if (entry2 == null) {
                                C5952a.m9285w("Tinker.ResDiffPatchInternal", "store patch entry is null. path:".concat(String.valueOf(str22)), new Object[0]);
                                iX.ABF.mo40778a(file3, file5, str22, 6);
                                SharePatchFileUtil.m9368a(zipFile3);
                                SharePatchFileUtil.m9368a(zipFile4);
                                return false;
                            }
                            C24432b.m38049a(zipFile4, entry2, file5, null, false);
                            if (entry2.getSize() != file5.length()) {
                                C5952a.m9285w("Tinker.ResDiffPatchInternal", "resource meta file size mismatch, type:%s, name: %s, patch size: %d, file size; %d", ShareTinkerInternals.m9412Sd(6), str22, Long.valueOf(entry2.getSize()), Long.valueOf(file5.length()));
                                iX.ABF.mo40784e(file3, C24432b.m38048RZ(6));
                                SharePatchFileUtil.m9368a(zipFile3);
                                SharePatchFileUtil.m9368a(zipFile4);
                                return false;
                            }
                            shareResPatchInfo.AFa.put(str22, file5);
                            C5952a.m9285w("Tinker.ResDiffPatchInternal", "success recover store file:%s, file size:%d, use time:%d", file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        }
                        Iterator it = shareResPatchInfo.AFb.iterator();
                        while (it.hasNext()) {
                            str22 = (String) it.next();
                            long currentTimeMillis3 = System.currentTimeMillis();
                            LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.AFc.get(str22);
                            if (largeModeInfo == null) {
                                C5952a.m9285w("Tinker.ResDiffPatchInternal", "resource not found largeModeInfo, type:%s, name: %s", ShareTinkerInternals.m9412Sd(6), str22);
                                iX.ABF.mo40784e(file3, C24432b.m38048RZ(6));
                                SharePatchFileUtil.m9368a(zipFile3);
                                SharePatchFileUtil.m9368a(zipFile4);
                                return false;
                            }
                            largeModeInfo.file = new File(file2, str22);
                            SharePatchFileUtil.m9375au(largeModeInfo.file);
                            if (SharePatchFileUtil.aus(largeModeInfo.cvZ)) {
                                ZipEntry entry3 = zipFile4.getEntry(str22);
                                if (entry3 == null) {
                                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "large mod patch entry is null. path:".concat(String.valueOf(str22)), new Object[0]);
                                    iX.ABF.mo40778a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.m9368a(zipFile3);
                                    SharePatchFileUtil.m9368a(zipFile4);
                                    return false;
                                }
                                ZipEntry entry4 = zipFile3.getEntry(str22);
                                if (entry4 == null) {
                                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:".concat(String.valueOf(str22)), new Object[0]);
                                    iX.ABF.mo40778a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.m9368a(zipFile3);
                                    SharePatchFileUtil.m9368a(zipFile4);
                                    return false;
                                }
                                Object obj2 = null;
                                Object obj3 = null;
                                try {
                                    obj2 = zipFile3.getInputStream(entry4);
                                    InputStream inputStream = zipFile4.getInputStream(entry3);
                                    try {
                                        C44549a.m80913a(obj2, inputStream, largeModeInfo.file);
                                        C36549a.m60575ah(obj2);
                                        C36549a.m60575ah(inputStream);
                                        if (SharePatchFileUtil.m9379g(largeModeInfo.file, largeModeInfo.cvZ)) {
                                            C5952a.m9285w("Tinker.ResDiffPatchInternal", "success recover large modify file:%s, file size:%d, use time:%d", largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                        } else {
                                            C5952a.m9285w("Tinker.ResDiffPatchInternal", "Failed to recover large modify file:%s", largeModeInfo.file.getPath());
                                            SharePatchFileUtil.m9373as(largeModeInfo.file);
                                            iX.ABF.mo40778a(file3, largeModeInfo.file, str22, 6);
                                            SharePatchFileUtil.m9368a(zipFile3);
                                            SharePatchFileUtil.m9368a(zipFile4);
                                            return false;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        InputStream obj4 = inputStream;
                                        C36549a.m60575ah(obj2);
                                        C36549a.m60575ah(obj4);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj4 = obj3;
                                }
                            } else {
                                C5952a.m9285w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.m9412Sd(6), str22, largeModeInfo.cvZ);
                                iX.ABF.mo40784e(file3, C24432b.m38048RZ(6));
                                SharePatchFileUtil.m9368a(zipFile3);
                                SharePatchFileUtil.m9368a(zipFile4);
                                return false;
                            }
                        }
                        C5952a.m9285w("Tinker.ResDiffPatchInternal", "success recover all large modify and store resources use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        SharePatchFileUtil.m9368a(zipFile3);
                        SharePatchFileUtil.m9368a(zipFile4);
                        return true;
                    } catch (Throwable th4) {
                        th = th4;
                        SharePatchFileUtil.m9368a(zipFile3);
                        SharePatchFileUtil.m9368a(zipFile4);
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                zipFile4 = null;
                SharePatchFileUtil.m9368a(zipFile3);
                SharePatchFileUtil.m9368a(zipFile4);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.m9368a(zipFile3);
            SharePatchFileUtil.m9368a(zipFile4);
            throw th;
        }
    }
}

package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.xwalk.core.XWalkEnvironment;

public final class d extends b {
    private static ArrayList<File> ABo = new ArrayList();
    private static ArrayList<ShareDexDiffPatchInfo> ABp = new ArrayList();
    private static HashMap<ShareDexDiffPatchInfo, File> ABq = new HashMap();
    private static boolean ABr = ShareTinkerInternals.dSp();

    protected static boolean a(a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (ShareTinkerInternals.Sa(aVar.tinkerFlags)) {
            String str2 = (String) shareSecurityCheck.AFg.get("assets/dex_meta.txt");
            if (str2 == null) {
                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
                return true;
            }
            boolean a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = str + "/dex/";
            if (b(context, str3, str2, file)) {
                File[] listFiles = new File(str3).listFiles();
                List arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (file2.isFile() && (name.endsWith(".dex") || name.endsWith(".jar") || name.endsWith(".apk"))) {
                            arrayList.add(file2);
                        }
                    }
                }
                com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "legal files to do dexopt: ".concat(String.valueOf(arrayList)), new Object[0]);
                a = a(context, arrayList, str + "/odex/", file);
            } else {
                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                a = false;
            }
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", Boolean.valueOf(a), Long.valueOf(elapsedRealtime));
            return a;
        }
        com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
        return true;
    }

    protected static boolean a(File file, a aVar) {
        Object shareElfFile;
        Object obj = null;
        if (ABo.isEmpty()) {
            return true;
        }
        File file2;
        int size = ABp.size() * 30;
        if (size > 120) {
            size = 120;
        }
        com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", Integer.valueOf(ABp.size()), Integer.valueOf(ABo.size()), Integer.valueOf(size));
        for (int i = 0; i < size; i++) {
            int i2;
            int i3 = i + 1;
            Iterator it = ABo.iterator();
            while (it.hasNext()) {
                file2 = (File) it.next();
                if (!SharePatchFileUtil.ap(file2) && !SharePatchFileUtil.aq(file2)) {
                    com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", file2.getName(), Integer.valueOf(i3));
                    i2 = 0;
                    break;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:".concat(String.valueOf(e)), new Object[0]);
                }
            }
        }
        List arrayList = new ArrayList();
        Iterator it2 = ABo.iterator();
        while (it2.hasNext()) {
            file2 = (File) it2.next();
            com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", file2.getPath(), Long.valueOf(file2.length()));
            if (!(SharePatchFileUtil.ap(file2) || SharePatchFileUtil.aq(file2))) {
                com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", file2.getName());
                arrayList.add(file2);
            }
        }
        if (arrayList.isEmpty()) {
            if (VERSION.SDK_INT >= 21) {
                Iterator it3 = ABo.iterator();
                Throwable th = null;
                while (it3.hasNext()) {
                    file2 = (File) it3.next();
                    if (!SharePatchFileUtil.aq(file2)) {
                        com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", file2.getName(), Long.valueOf(file2.length()));
                        try {
                            if (ShareElfFile.an(file2) == 1) {
                                try {
                                    shareElfFile = new ShareElfFile(file2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    shareElfFile = "Tinker.DexDiffPatchInternal";
                                    com.tencent.tinker.lib.util.a.e(shareElfFile, "final parallel dex optimizer file %s is not elf format, return false", file2.getName());
                                    arrayList.add(file2);
                                } finally {
                                    obj = 
/*
Method generation error in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r2_3 'obj' java.lang.Object) = (r2_2 'obj' java.lang.Object), (r7_20 'shareElfFile' java.lang.Object) in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:120)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:280)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:120)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:120)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:120)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 56 more

*/

    private static boolean aui(String str) {
        if (ABp.isEmpty() || !ABr) {
            return false;
        }
        ShareDexDiffPatchInfo shareDexDiffPatchInfo;
        boolean z;
        Iterator it = ABp.iterator();
        File file = null;
        ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = null;
        while (it.hasNext()) {
            shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
            File file2 = new File(str + shareDexDiffPatchInfo.eBb);
            if (ShareConstants.ADM.matcher(file2.getName()).matches()) {
                ABq.put(shareDexDiffPatchInfo, file2);
            }
            if (!shareDexDiffPatchInfo.ADN.startsWith("test.dex")) {
                file2 = file;
                shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
            }
            file = file2;
            shareDexDiffPatchInfo2 = shareDexDiffPatchInfo;
        }
        if (shareDexDiffPatchInfo2 != null) {
            ABq.put(ShareTinkerInternals.a(shareDexDiffPatchInfo2, ABq.size() + 1), file);
        }
        file = new File(str, "tinker_classN.apk");
        if (file.exists()) {
            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo3 : ABq.keySet()) {
                if (!SharePatchFileUtil.b(file, shareDexDiffPatchInfo3.ADN, shareDexDiffPatchInfo3.ADP)) {
                    com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo3.ADN, Long.valueOf(file.length()));
                    z = false;
                    break;
                }
            }
            z = true;
            if (!z) {
                SharePatchFileUtil.as(file);
            }
        } else {
            z = false;
        }
        if (z) {
            for (File as : ABq.values()) {
                SharePatchFileUtil.as(as);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(Context context, File file, String str) {
        Throwable th;
        boolean z;
        if (ABp.isEmpty() || !ABr) {
            return true;
        }
        File file2 = new File(str, "tinker_classN.apk");
        if (ABq.isEmpty()) {
            com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "classNDexInfo size: %d, no need to merge classN dex files", Integer.valueOf(ABq.size()));
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = null;
        Object hVar;
        try {
            hVar = new h(new BufferedOutputStream(new FileOutputStream(file2)));
            try {
                for (ShareDexDiffPatchInfo shareDexDiffPatchInfo : ABq.keySet()) {
                    File file3 = (File) ABq.get(shareDexDiffPatchInfo);
                    if (shareDexDiffPatchInfo.ADU) {
                        Object gVar;
                        try {
                            gVar = new g(file3);
                            try {
                                f auw = gVar.auw(XWalkEnvironment.XWALK_CORE_CLASSES_DEX);
                                f fVar = new f(auw, shareDexDiffPatchInfo.ADN);
                                obj = gVar.a(auw);
                                try {
                                    i.a(fVar, (InputStream) obj, (h) hVar);
                                    com.tencent.tinker.c.b.a.ah(obj);
                                    com.tencent.tinker.c.b.a.ah(gVar);
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.tencent.tinker.c.b.a.ah(obj);
                                    com.tencent.tinker.c.b.a.ah(gVar);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            obj = null;
                            gVar = null;
                            com.tencent.tinker.c.b.a.ah(obj);
                            com.tencent.tinker.c.b.a.ah(gVar);
                            throw th;
                        }
                    }
                    i.a(new f(shareDexDiffPatchInfo.ADN), file3, Long.parseLong(shareDexDiffPatchInfo.ADR), hVar);
                }
                com.tencent.tinker.c.b.a.ah(hVar);
                z = true;
            } catch (Throwable th5) {
                th = th5;
                com.tencent.tinker.c.b.a.ah(hVar);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            hVar = null;
            com.tencent.tinker.c.b.a.ah(hVar);
            throw th;
        }
        if (z) {
            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo2 : ABq.keySet()) {
                if (!SharePatchFileUtil.b(file2, shareDexDiffPatchInfo2.ADN, shareDexDiffPatchInfo2.ADP)) {
                    z = false;
                    com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo2.ADN, Long.valueOf(file2.length()));
                    break;
                }
            }
        }
        if (z) {
            for (File as : ABq.values()) {
                SharePatchFileUtil.as(as);
            }
        } else {
            com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "merge classN dex error, try delete temp file", new Object[0]);
            SharePatchFileUtil.as(file2);
            a.iX(context).ABF.a(file, file2, file2.getName(), 7);
        }
        com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "merge classN dex file %s, result: %b, size: %d, use: %dms", file2.getPath(), Boolean.valueOf(z), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    private static boolean a(Context context, List<File> list, String str, File file) {
        a iX = a.iX(context);
        ABo.clear();
        File file2 = new File(str);
        if (file2.exists() || file2.mkdirs()) {
            for (File k : list) {
                ABo.add(new File(SharePatchFileUtil.k(k, file2)));
            }
            com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", Integer.valueOf(list.size()), str);
            final List vector = new Vector();
            final Throwable[] thArr = new Throwable[1];
            TinkerDexOptimizer.a(list, file2, new ResultCallback() {
                long startTime;

                public final void ai(File file) {
                    this.startTime = System.currentTimeMillis();
                    com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", file.getPath(), Long.valueOf(file.length()));
                }

                public final void i(File file, File file2) {
                    com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", file.getPath(), file2.getPath(), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - this.startTime));
                }

                public final void b(File file, Throwable th) {
                    com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime));
                    vector.add(file);
                    thArr[0] = th;
                }
            });
            if (vector.isEmpty()) {
                return true;
            }
            iX.ABF.a(file, vector, thArr[0]);
            return false;
        }
        com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
        return false;
    }

    private static boolean b(Context context, String str, String str2, File file) {
        Throwable th;
        ZipFile zipFile;
        ABp.clear();
        ShareDexDiffPatchInfo.o(str2, ABp);
        if (ABp.isEmpty()) {
            com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", ShareTinkerInternals.Sd(3));
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        a iX = a.iX(context);
        ZipFile zipFile2 = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                SharePatchFileUtil.a(null);
                SharePatchFileUtil.a(null);
                return false;
            }
            ZipFile zipFile3;
            ZipFile zipFile4 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile3 = new ZipFile(file);
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile4;
                SharePatchFileUtil.a(zipFile);
                SharePatchFileUtil.a(zipFile2);
                throw th;
            }
            try {
                if (aui(str)) {
                    com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "class n dex file %s is already exist, and md5 match, just continue", "tinker_classN.apk");
                    SharePatchFileUtil.a(zipFile4);
                    SharePatchFileUtil.a(zipFile3);
                    return true;
                }
                Iterator it = ABp.iterator();
                while (it.hasNext()) {
                    String str3;
                    ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (shareDexDiffPatchInfo.path.equals("")) {
                        str3 = shareDexDiffPatchInfo.ADN;
                    } else {
                        str3 = shareDexDiffPatchInfo.path + "/" + shareDexDiffPatchInfo.ADN;
                    }
                    String str4 = shareDexDiffPatchInfo.ADS;
                    String str5 = shareDexDiffPatchInfo.ADQ;
                    if (ABr || !shareDexDiffPatchInfo.ADO.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        String str6 = ABr ? shareDexDiffPatchInfo.ADP : shareDexDiffPatchInfo.ADO;
                        if (SharePatchFileUtil.aus(str6)) {
                            File file3 = new File(str + shareDexDiffPatchInfo.eBb);
                            if (!file3.exists()) {
                                file3.getParentFile().mkdirs();
                            } else if (SharePatchFileUtil.h(file3, str6)) {
                                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", file3.getPath());
                            } else {
                                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                file3.delete();
                            }
                            ZipEntry entry = zipFile3.getEntry(str3);
                            ZipEntry entry2 = zipFile4.getEntry(str3);
                            if (str5.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                if (entry == null) {
                                    com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                    iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                    SharePatchFileUtil.a(zipFile4);
                                    SharePatchFileUtil.a(zipFile3);
                                    return false;
                                } else if (!a(zipFile3, entry, file3, shareDexDiffPatchInfo)) {
                                    com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                    iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                    SharePatchFileUtil.a(zipFile4);
                                    SharePatchFileUtil.a(zipFile3);
                                    return false;
                                }
                            } else if (str4.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                if (!ABr) {
                                    continue;
                                } else if (entry2 == null) {
                                    com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                    iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                    SharePatchFileUtil.a(zipFile4);
                                    SharePatchFileUtil.a(zipFile3);
                                    return false;
                                } else {
                                    if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                        a(zipFile4, entry2, file3, shareDexDiffPatchInfo);
                                        if (!SharePatchFileUtil.h(file3, str6)) {
                                            com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                            iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                            SharePatchFileUtil.as(file3);
                                            SharePatchFileUtil.a(zipFile4);
                                            SharePatchFileUtil.a(zipFile3);
                                            return false;
                                        }
                                    } else {
                                        com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, String.valueOf(entry2.getCrc()));
                                        iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                        SharePatchFileUtil.a(zipFile4);
                                        SharePatchFileUtil.a(zipFile3);
                                        return false;
                                    }
                                }
                            } else if (entry == null) {
                                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                SharePatchFileUtil.a(zipFile4);
                                SharePatchFileUtil.a(zipFile3);
                                return false;
                            } else if (!SharePatchFileUtil.aus(str4)) {
                                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.Sd(3), shareDexDiffPatchInfo.ADN, str4);
                                iX.ABF.e(file, b.RZ(3));
                                SharePatchFileUtil.a(zipFile4);
                                SharePatchFileUtil.a(zipFile3);
                                return false;
                            } else if (entry2 == null) {
                                com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                SharePatchFileUtil.a(zipFile4);
                                SharePatchFileUtil.a(zipFile3);
                                return false;
                            } else {
                                if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                    a(zipFile4, zipFile3, entry2, entry, shareDexDiffPatchInfo, file3);
                                    if (SharePatchFileUtil.h(file3, str6)) {
                                        com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, size: %d, use time: %d", file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    } else {
                                        com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                        iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                        SharePatchFileUtil.as(file3);
                                        SharePatchFileUtil.a(zipFile4);
                                        SharePatchFileUtil.a(zipFile3);
                                        return false;
                                    }
                                }
                                com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, String.valueOf(entry2.getCrc()));
                                iX.ABF.a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                SharePatchFileUtil.a(zipFile4);
                                SharePatchFileUtil.a(zipFile3);
                                return false;
                            }
                        }
                        com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.Sd(3), shareDexDiffPatchInfo.ADN, str6);
                        iX.ABF.e(file, b.RZ(3));
                        SharePatchFileUtil.a(zipFile4);
                        SharePatchFileUtil.a(zipFile3);
                        return false;
                    }
                    com.tencent.tinker.lib.util.a.w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", str3);
                }
                if (a(context, file, str)) {
                    SharePatchFileUtil.a(zipFile4);
                    SharePatchFileUtil.a(zipFile3);
                    return true;
                }
                SharePatchFileUtil.a(zipFile4);
                SharePatchFileUtil.a(zipFile3);
                return false;
            } catch (Throwable th3) {
                th = th3;
                zipFile2 = zipFile3;
                zipFile = zipFile4;
                SharePatchFileUtil.a(zipFile);
                SharePatchFileUtil.a(zipFile2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            SharePatchFileUtil.a(zipFile);
            SharePatchFileUtil.a(zipFile2);
            throw th;
        }
    }

    private static boolean b(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Object zipOutputStream;
        Object bufferedInputStream;
        Throwable th;
        boolean z = false;
        int i = 0;
        while (i < 2 && !z) {
            int i2 = i + 1;
            com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                    com.tencent.tinker.c.b.a.ah(zipOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    zipOutputStream.putNextEntry(new ZipEntry(XWalkEnvironment.XWALK_CORE_CLASSES_DEX));
                    for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                    com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                    com.tencent.tinker.c.b.a.ah(zipOutputStream);
                    z = SharePatchFileUtil.h(file, str);
                    com.tencent.tinker.lib.util.a.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z));
                    if (!z && (!file.delete() || file.exists())) {
                        com.tencent.tinker.lib.util.a.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                    }
                    i = i2;
                } catch (Throwable th3) {
                    th = th3;
                    com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                    com.tencent.tinker.c.b.a.ah(zipOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                zipOutputStream = null;
                com.tencent.tinker.c.b.a.ah(bufferedInputStream);
                com.tencent.tinker.c.b.a.ah(zipOutputStream);
                throw th;
            }
        }
        return z;
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        String str = ABr ? shareDexDiffPatchInfo.ADP : shareDexDiffPatchInfo.ADO;
        String str2 = shareDexDiffPatchInfo.ADN;
        boolean z = shareDexDiffPatchInfo.ADU;
        if (SharePatchFileUtil.aut(str2) && z) {
            return b(zipFile, zipEntry, file, str);
        }
        return b.a(zipFile, zipEntry, file, str, true);
    }

    private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3 = null;
        try {
            InputStream bufferedInputStream;
            InputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            if (zipEntry2 != null) {
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                } catch (Throwable th2) {
                    th = th2;
                    obj = null;
                    InputStream obj22 = bufferedInputStream2;
                    com.tencent.tinker.c.b.a.ah(obj22);
                    com.tencent.tinker.c.b.a.ah(obj);
                    throw th;
                }
            }
            bufferedInputStream = null;
            try {
                boolean aut = SharePatchFileUtil.aut(shareDexDiffPatchInfo.ADN);
                if (!aut || shareDexDiffPatchInfo.ADU) {
                    try {
                        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(XWalkEnvironment.XWALK_CORE_CLASSES_DEX));
                            if (aut) {
                                new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream).b(zipOutputStream);
                            } else {
                                try {
                                    ZipEntry nextEntry;
                                    InputStream zipInputStream = new ZipInputStream(bufferedInputStream2);
                                    do {
                                        try {
                                            nextEntry = zipInputStream.getNextEntry();
                                            if (nextEntry == null) {
                                                break;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            com.tencent.tinker.c.b.a.ah(obj);
                                            throw th;
                                        }
                                    } while (!XWalkEnvironment.XWALK_CORE_CLASSES_DEX.equals(nextEntry.getName()));
                                    if (nextEntry == null) {
                                        throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                    }
                                    new com.tencent.tinker.c.a.a(zipInputStream, bufferedInputStream).b(zipOutputStream);
                                    com.tencent.tinker.c.b.a.ah(zipInputStream);
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj = null;
                                    com.tencent.tinker.c.b.a.ah(obj);
                                    throw th;
                                }
                            }
                            zipOutputStream.closeEntry();
                            com.tencent.tinker.c.b.a.ah(zipOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            obj3 = zipOutputStream;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        com.tencent.tinker.c.b.a.ah(obj3);
                        throw th;
                    }
                }
                com.tencent.tinker.c.a.a aVar = new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    aVar.b(bufferedOutputStream);
                    com.tencent.tinker.c.b.a.ah(bufferedOutputStream);
                } catch (Throwable th7) {
                    th = th7;
                    BufferedOutputStream obj32 = bufferedOutputStream;
                    com.tencent.tinker.c.b.a.ah(obj32);
                    throw th;
                }
                com.tencent.tinker.c.b.a.ah(bufferedInputStream2);
                com.tencent.tinker.c.b.a.ah(bufferedInputStream);
            } catch (Throwable th8) {
                th = th8;
                obj = bufferedInputStream;
                obj22 = bufferedInputStream2;
                com.tencent.tinker.c.b.a.ah(obj22);
                com.tencent.tinker.c.b.a.ah(obj);
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            obj = null;
            obj22 = null;
            com.tencent.tinker.c.b.a.ah(obj22);
            com.tencent.tinker.c.b.a.ah(obj);
            throw th;
        }
    }
}

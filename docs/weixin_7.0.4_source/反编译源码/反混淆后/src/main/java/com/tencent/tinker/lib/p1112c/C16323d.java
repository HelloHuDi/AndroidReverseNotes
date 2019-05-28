package com.tencent.tinker.lib.p1112c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.p673c.p1516b.C36549a;
import com.tencent.tinker.p673c.p674a.C5918a;
import com.tencent.tinker.p676d.p677a.C5931f;
import com.tencent.tinker.p676d.p677a.C5934g;
import com.tencent.tinker.p676d.p677a.C5935h;
import com.tencent.tinker.p676d.p677a.C5936i;
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

/* renamed from: com.tencent.tinker.lib.c.d */
public final class C16323d extends C24432b {
    private static ArrayList<File> ABo = new ArrayList();
    private static ArrayList<ShareDexDiffPatchInfo> ABp = new ArrayList();
    private static HashMap<ShareDexDiffPatchInfo, File> ABq = new HashMap();
    private static boolean ABr = ShareTinkerInternals.dSp();

    /* renamed from: a */
    protected static boolean m25172a(C31097a c31097a, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (ShareTinkerInternals.m9409Sa(c31097a.tinkerFlags)) {
            String str2 = (String) shareSecurityCheck.AFg.get("assets/dex_meta.txt");
            if (str2 == null) {
                C5952a.m9285w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
                return true;
            }
            boolean a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = str + "/dex/";
            if (C16323d.m25175b(context, str3, str2, file)) {
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
                C5952a.m9284i("Tinker.DexDiffPatchInternal", "legal files to do dexopt: ".concat(String.valueOf(arrayList)), new Object[0]);
                a = C16323d.m25171a(context, arrayList, str + "/odex/", file);
            } else {
                C5952a.m9285w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                a = false;
            }
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            C5952a.m9284i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", Boolean.valueOf(a), Long.valueOf(elapsedRealtime));
            return a;
        }
        C5952a.m9285w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
        return true;
    }

    /* renamed from: a */
    protected static boolean m25173a(File file, C31097a c31097a) {
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
        C5952a.m9284i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", Integer.valueOf(ABp.size()), Integer.valueOf(ABo.size()), Integer.valueOf(size));
        for (int i = 0; i < size; i++) {
            int i2;
            int i3 = i + 1;
            Iterator it = ABo.iterator();
            while (it.hasNext()) {
                file2 = (File) it.next();
                if (!SharePatchFileUtil.m9370ap(file2) && !SharePatchFileUtil.m9371aq(file2)) {
                    C5952a.m9283e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", file2.getName(), Integer.valueOf(i3));
                    i2 = 0;
                    break;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    C5952a.m9283e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:".concat(String.valueOf(e)), new Object[0]);
                }
            }
        }
        List arrayList = new ArrayList();
        Iterator it2 = ABo.iterator();
        while (it2.hasNext()) {
            file2 = (File) it2.next();
            C5952a.m9284i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", file2.getPath(), Long.valueOf(file2.length()));
            if (!(SharePatchFileUtil.m9370ap(file2) || SharePatchFileUtil.m9371aq(file2))) {
                C5952a.m9283e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", file2.getName());
                arrayList.add(file2);
            }
        }
        if (arrayList.isEmpty()) {
            if (VERSION.SDK_INT >= 21) {
                Iterator it3 = ABo.iterator();
                Throwable th = null;
                while (it3.hasNext()) {
                    file2 = (File) it3.next();
                    if (!SharePatchFileUtil.m9371aq(file2)) {
                        C5952a.m9284i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", file2.getName(), Long.valueOf(file2.length()));
                        try {
                            if (ShareElfFile.m9350an(file2) == 1) {
                                try {
                                    shareElfFile = new ShareElfFile(file2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    shareElfFile = "Tinker.DexDiffPatchInternal";
                                    C5952a.m9283e(shareElfFile, "final parallel dex optimizer file %s is not elf format, return false", file2.getName());
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
            ABq.put(ShareTinkerInternals.m9415a(shareDexDiffPatchInfo2, ABq.size() + 1), file);
        }
        file = new File(str, "tinker_classN.apk");
        if (file.exists()) {
            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo3 : ABq.keySet()) {
                if (!SharePatchFileUtil.m9376b(file, shareDexDiffPatchInfo3.ADN, shareDexDiffPatchInfo3.ADP)) {
                    C5952a.m9283e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo3.ADN, Long.valueOf(file.length()));
                    z = false;
                    break;
                }
            }
            z = true;
            if (!z) {
                SharePatchFileUtil.m9373as(file);
            }
        } else {
            z = false;
        }
        if (z) {
            for (File as : ABq.values()) {
                SharePatchFileUtil.m9373as(as);
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
    /* renamed from: a */
    private static boolean m25170a(Context context, File file, String str) {
        Throwable th;
        boolean z;
        if (ABp.isEmpty() || !ABr) {
            return true;
        }
        File file2 = new File(str, "tinker_classN.apk");
        if (ABq.isEmpty()) {
            C5952a.m9285w("Tinker.DexDiffPatchInternal", "classNDexInfo size: %d, no need to merge classN dex files", Integer.valueOf(ABq.size()));
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = null;
        Object c5935h;
        try {
            c5935h = new C5935h(new BufferedOutputStream(new FileOutputStream(file2)));
            try {
                for (ShareDexDiffPatchInfo shareDexDiffPatchInfo : ABq.keySet()) {
                    File file3 = (File) ABq.get(shareDexDiffPatchInfo);
                    if (shareDexDiffPatchInfo.ADU) {
                        Object c5934g;
                        try {
                            c5934g = new C5934g(file3);
                            try {
                                C5931f auw = c5934g.auw(XWalkEnvironment.XWALK_CORE_CLASSES_DEX);
                                C5931f c5931f = new C5931f(auw, shareDexDiffPatchInfo.ADN);
                                obj = c5934g.mo12614a(auw);
                                try {
                                    C5936i.m9250a(c5931f, (InputStream) obj, (C5935h) c5935h);
                                    C36549a.m60575ah(obj);
                                    C36549a.m60575ah(c5934g);
                                } catch (Throwable th2) {
                                    th = th2;
                                    C36549a.m60575ah(obj);
                                    C36549a.m60575ah(c5934g);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            obj = null;
                            c5934g = null;
                            C36549a.m60575ah(obj);
                            C36549a.m60575ah(c5934g);
                            throw th;
                        }
                    }
                    C5936i.m9249a(new C5931f(shareDexDiffPatchInfo.ADN), file3, Long.parseLong(shareDexDiffPatchInfo.ADR), c5935h);
                }
                C36549a.m60575ah(c5935h);
                z = true;
            } catch (Throwable th5) {
                th = th5;
                C36549a.m60575ah(c5935h);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            c5935h = null;
            C36549a.m60575ah(c5935h);
            throw th;
        }
        if (z) {
            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo2 : ABq.keySet()) {
                if (!SharePatchFileUtil.m9376b(file2, shareDexDiffPatchInfo2.ADN, shareDexDiffPatchInfo2.ADP)) {
                    z = false;
                    C5952a.m9283e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo2.ADN, Long.valueOf(file2.length()));
                    break;
                }
            }
        }
        if (z) {
            for (File as : ABq.values()) {
                SharePatchFileUtil.m9373as(as);
            }
        } else {
            C5952a.m9283e("Tinker.DexDiffPatchInternal", "merge classN dex error, try delete temp file", new Object[0]);
            SharePatchFileUtil.m9373as(file2);
            C31097a.m50180iX(context).ABF.mo40778a(file, file2, file2.getName(), 7);
        }
        C5952a.m9284i("Tinker.DexDiffPatchInternal", "merge classN dex file %s, result: %b, size: %d, use: %dms", file2.getPath(), Boolean.valueOf(z), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    /* renamed from: a */
    private static boolean m25171a(Context context, List<File> list, String str, File file) {
        C31097a iX = C31097a.m50180iX(context);
        ABo.clear();
        File file2 = new File(str);
        if (file2.exists() || file2.mkdirs()) {
            for (File k : list) {
                ABo.add(new File(SharePatchFileUtil.m9387k(k, file2)));
            }
            C5952a.m9284i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", Integer.valueOf(list.size()), str);
            final List vector = new Vector();
            final Throwable[] thArr = new Throwable[1];
            TinkerDexOptimizer.m9314a(list, file2, new ResultCallback() {
                long startTime;

                /* renamed from: ai */
                public final void mo12659ai(File file) {
                    this.startTime = System.currentTimeMillis();
                    C5952a.m9284i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", file.getPath(), Long.valueOf(file.length()));
                }

                /* renamed from: i */
                public final void mo12661i(File file, File file2) {
                    C5952a.m9284i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", file.getPath(), file2.getPath(), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - this.startTime));
                }

                /* renamed from: b */
                public final void mo12660b(File file, Throwable th) {
                    C5952a.m9284i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime));
                    vector.add(file);
                    thArr[0] = th;
                }
            });
            if (vector.isEmpty()) {
                return true;
            }
            iX.ABF.mo40781a(file, vector, thArr[0]);
            return false;
        }
        C5952a.m9285w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
        return false;
    }

    /* renamed from: b */
    private static boolean m25175b(Context context, String str, String str2, File file) {
        Throwable th;
        ZipFile zipFile;
        ABp.clear();
        ShareDexDiffPatchInfo.m9346o(str2, ABp);
        if (ABp.isEmpty()) {
            C5952a.m9285w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", ShareTinkerInternals.m9412Sd(3));
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        C31097a iX = C31097a.m50180iX(context);
        ZipFile zipFile2 = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                C5952a.m9285w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                SharePatchFileUtil.m9368a(null);
                SharePatchFileUtil.m9368a(null);
                return false;
            }
            ZipFile zipFile3;
            ZipFile zipFile4 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile3 = new ZipFile(file);
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile4;
                SharePatchFileUtil.m9368a(zipFile);
                SharePatchFileUtil.m9368a(zipFile2);
                throw th;
            }
            try {
                if (C16323d.aui(str)) {
                    C5952a.m9285w("Tinker.DexDiffPatchInternal", "class n dex file %s is already exist, and md5 match, just continue", "tinker_classN.apk");
                    SharePatchFileUtil.m9368a(zipFile4);
                    SharePatchFileUtil.m9368a(zipFile3);
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
                            } else if (SharePatchFileUtil.m9380h(file3, str6)) {
                                C5952a.m9285w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", file3.getPath());
                            } else {
                                C5952a.m9285w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                file3.delete();
                            }
                            ZipEntry entry = zipFile3.getEntry(str3);
                            ZipEntry entry2 = zipFile4.getEntry(str3);
                            if (str5.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                if (entry == null) {
                                    C5952a.m9285w("Tinker.DexDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                    iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                    SharePatchFileUtil.m9368a(zipFile4);
                                    SharePatchFileUtil.m9368a(zipFile3);
                                    return false;
                                } else if (!C16323d.m25174a(zipFile3, entry, file3, shareDexDiffPatchInfo)) {
                                    C5952a.m9285w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                    iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                    SharePatchFileUtil.m9368a(zipFile4);
                                    SharePatchFileUtil.m9368a(zipFile3);
                                    return false;
                                }
                            } else if (str4.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                if (!ABr) {
                                    continue;
                                } else if (entry2 == null) {
                                    C5952a.m9285w("Tinker.DexDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                    iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                    SharePatchFileUtil.m9368a(zipFile4);
                                    SharePatchFileUtil.m9368a(zipFile3);
                                    return false;
                                } else {
                                    if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                        C16323d.m25174a(zipFile4, entry2, file3, shareDexDiffPatchInfo);
                                        if (!SharePatchFileUtil.m9380h(file3, str6)) {
                                            C5952a.m9285w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                            iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                            SharePatchFileUtil.m9373as(file3);
                                            SharePatchFileUtil.m9368a(zipFile4);
                                            SharePatchFileUtil.m9368a(zipFile3);
                                            return false;
                                        }
                                    } else {
                                        C5952a.m9283e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, String.valueOf(entry2.getCrc()));
                                        iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                        SharePatchFileUtil.m9368a(zipFile4);
                                        SharePatchFileUtil.m9368a(zipFile3);
                                        return false;
                                    }
                                }
                            } else if (entry == null) {
                                C5952a.m9285w("Tinker.DexDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                SharePatchFileUtil.m9368a(zipFile4);
                                SharePatchFileUtil.m9368a(zipFile3);
                                return false;
                            } else if (!SharePatchFileUtil.aus(str4)) {
                                C5952a.m9285w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.m9412Sd(3), shareDexDiffPatchInfo.ADN, str4);
                                iX.ABF.mo40784e(file, C24432b.m38048RZ(3));
                                SharePatchFileUtil.m9368a(zipFile4);
                                SharePatchFileUtil.m9368a(zipFile3);
                                return false;
                            } else if (entry2 == null) {
                                C5952a.m9285w("Tinker.DexDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                SharePatchFileUtil.m9368a(zipFile4);
                                SharePatchFileUtil.m9368a(zipFile3);
                                return false;
                            } else {
                                if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                    C16323d.m25169a(zipFile4, zipFile3, entry2, entry, shareDexDiffPatchInfo, file3);
                                    if (SharePatchFileUtil.m9380h(file3, str6)) {
                                        C5952a.m9285w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, size: %d, use time: %d", file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    } else {
                                        C5952a.m9285w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                        iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                        SharePatchFileUtil.m9373as(file3);
                                        SharePatchFileUtil.m9368a(zipFile4);
                                        SharePatchFileUtil.m9368a(zipFile3);
                                        return false;
                                    }
                                }
                                C5952a.m9283e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, String.valueOf(entry2.getCrc()));
                                iX.ABF.mo40778a(file, file3, shareDexDiffPatchInfo.ADN, 3);
                                SharePatchFileUtil.m9368a(zipFile4);
                                SharePatchFileUtil.m9368a(zipFile3);
                                return false;
                            }
                        }
                        C5952a.m9285w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.m9412Sd(3), shareDexDiffPatchInfo.ADN, str6);
                        iX.ABF.mo40784e(file, C24432b.m38048RZ(3));
                        SharePatchFileUtil.m9368a(zipFile4);
                        SharePatchFileUtil.m9368a(zipFile3);
                        return false;
                    }
                    C5952a.m9285w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", str3);
                }
                if (C16323d.m25170a(context, file, str)) {
                    SharePatchFileUtil.m9368a(zipFile4);
                    SharePatchFileUtil.m9368a(zipFile3);
                    return true;
                }
                SharePatchFileUtil.m9368a(zipFile4);
                SharePatchFileUtil.m9368a(zipFile3);
                return false;
            } catch (Throwable th3) {
                th = th3;
                zipFile2 = zipFile3;
                zipFile = zipFile4;
                SharePatchFileUtil.m9368a(zipFile);
                SharePatchFileUtil.m9368a(zipFile2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            SharePatchFileUtil.m9368a(zipFile);
            SharePatchFileUtil.m9368a(zipFile2);
            throw th;
        }
    }

    /* renamed from: b */
    private static boolean m25176b(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Object zipOutputStream;
        Object bufferedInputStream;
        Throwable th;
        boolean z = false;
        int i = 0;
        while (i < 2 && !z) {
            int i2 = i + 1;
            C5952a.m9284i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    C36549a.m60575ah(bufferedInputStream);
                    C36549a.m60575ah(zipOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    zipOutputStream.putNextEntry(new ZipEntry(XWalkEnvironment.XWALK_CORE_CLASSES_DEX));
                    for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                    C36549a.m60575ah(bufferedInputStream);
                    C36549a.m60575ah(zipOutputStream);
                    z = SharePatchFileUtil.m9380h(file, str);
                    C5952a.m9284i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z));
                    if (!z && (!file.delete() || file.exists())) {
                        C5952a.m9283e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                    }
                    i = i2;
                } catch (Throwable th3) {
                    th = th3;
                    C36549a.m60575ah(bufferedInputStream);
                    C36549a.m60575ah(zipOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                zipOutputStream = null;
                C36549a.m60575ah(bufferedInputStream);
                C36549a.m60575ah(zipOutputStream);
                throw th;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m25174a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        String str = ABr ? shareDexDiffPatchInfo.ADP : shareDexDiffPatchInfo.ADO;
        String str2 = shareDexDiffPatchInfo.ADN;
        boolean z = shareDexDiffPatchInfo.ADU;
        if (SharePatchFileUtil.aut(str2) && z) {
            return C16323d.m25176b(zipFile, zipEntry, file, str);
        }
        return C24432b.m38049a(zipFile, zipEntry, file, str, true);
    }

    /* renamed from: a */
    private static void m25169a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
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
                    C36549a.m60575ah(obj22);
                    C36549a.m60575ah(obj);
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
                                new C5918a(bufferedInputStream2, bufferedInputStream).mo12570b(zipOutputStream);
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
                                            C36549a.m60575ah(obj);
                                            throw th;
                                        }
                                    } while (!XWalkEnvironment.XWALK_CORE_CLASSES_DEX.equals(nextEntry.getName()));
                                    if (nextEntry == null) {
                                        throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                    }
                                    new C5918a(zipInputStream, bufferedInputStream).mo12570b(zipOutputStream);
                                    C36549a.m60575ah(zipInputStream);
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj = null;
                                    C36549a.m60575ah(obj);
                                    throw th;
                                }
                            }
                            zipOutputStream.closeEntry();
                            C36549a.m60575ah(zipOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            obj3 = zipOutputStream;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        C36549a.m60575ah(obj3);
                        throw th;
                    }
                }
                C5918a c5918a = new C5918a(bufferedInputStream2, bufferedInputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    c5918a.mo12570b(bufferedOutputStream);
                    C36549a.m60575ah(bufferedOutputStream);
                } catch (Throwable th7) {
                    th = th7;
                    BufferedOutputStream obj32 = bufferedOutputStream;
                    C36549a.m60575ah(obj32);
                    throw th;
                }
                C36549a.m60575ah(bufferedInputStream2);
                C36549a.m60575ah(bufferedInputStream);
            } catch (Throwable th8) {
                th = th8;
                obj = bufferedInputStream;
                obj22 = bufferedInputStream2;
                C36549a.m60575ah(obj22);
                C36549a.m60575ah(obj);
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            obj = null;
            obj22 = null;
            C36549a.m60575ah(obj22);
            C36549a.m60575ah(obj);
            throw th;
        }
    }
}

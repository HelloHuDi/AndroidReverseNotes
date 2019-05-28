package com.tencent.p177mm.p229f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.ttpic.baseutils.IOUtils;
import dalvik.system.PathClassLoader;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.mm.f.a */
public final class C1523a {
    private static boolean crE = false;
    private static String crF;
    private static String crG;
    private static String crH;
    private static Set<C1521a> crI;
    /* renamed from: wY */
    public static final boolean f1229wY = C1523a.m3154F(System.getProperty("java.vm.version"));

    /* renamed from: com.tencent.mm.f.a$1 */
    static class C15201 implements Comparator<File> {
        C15201() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(115045);
            File file = (File) obj;
            File file2 = (File) obj2;
            if (file == null || file2 == null) {
                AppMethodBeat.m2505o(115045);
                return 0;
            }
            String name = file.getName();
            String name2 = file2.getName();
            if (name.contains("classes") && name2.contains("classes")) {
                int charAt = name.charAt(7) - name2.charAt(7);
                AppMethodBeat.m2505o(115045);
                return charAt;
            }
            AppMethodBeat.m2505o(115045);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.f.a$a */
    static class C1521a {
        String crJ;
        String crK;
        String crL;

        public C1521a(String str, String str2, String str3) {
            this.crJ = str;
            this.crK = str2;
            this.crL = str3;
        }
    }

    /* renamed from: com.tencent.mm.f.a$b */
    static final class C1522b {
        /* renamed from: a */
        static Object[] m3153a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method e;
            AppMethodBeat.m2504i(115046);
            try {
                e = C1523a.m3166e(obj, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class});
            } catch (NoSuchMethodException e2) {
                C4990ab.m7412e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    e = C1523a.m3166e(obj, "makeDexElements", new Class[]{List.class, File.class, List.class});
                } catch (NoSuchMethodException e3) {
                    C4990ab.m7412e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    try {
                        e = C1523a.m3166e(obj, "makePathElements", new Class[]{List.class, File.class, List.class});
                    } catch (NoSuchMethodException e4) {
                        C4990ab.m7412e("MicroMsg.MultiDex", "NoSuchMethodException: makePathElements(List,File,List) failure");
                        AppMethodBeat.m2505o(115046);
                        throw e4;
                    }
                }
            }
            Object[] objArr = (Object[]) e.invoke(obj, new Object[]{arrayList, file, arrayList2});
            AppMethodBeat.m2505o(115046);
            return objArr;
        }
    }

    /* renamed from: e */
    static /* synthetic */ Method m3166e(Object obj, String str, Class[] clsArr) {
        AppMethodBeat.m2504i(139082);
        Method b = C1523a.m3159b(obj, str, clsArr);
        AppMethodBeat.m2505o(139082);
        return b;
    }

    static {
        AppMethodBeat.m2504i(115061);
        AppMethodBeat.m2505o(115061);
    }

    private C1523a() {
    }

    /* renamed from: bb */
    public static void m3163bb(Context context) {
        long availableBlocks;
        long blockSize;
        String aw;
        Intent intent;
        AppMethodBeat.m2504i(115047);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MultiDex", "get db spare space error");
                blockSize = 0;
                C4990ab.m7417i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(availableBlocks), Long.valueOf(blockSize));
                aw = C5046bo.m7524aw(context, Process.myPid());
                C4990ab.m7417i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", aw, Long.valueOf(availableBlocks), Long.valueOf(31457280));
                intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent.setFlags(268435456);
                context.startActivity(intent);
                Process.killProcess(Process.myPid());
                AppMethodBeat.m2505o(115047);
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            C4990ab.m7412e("MicroMsg.MultiDex", "get db spare space error");
            blockSize = 0;
            C4990ab.m7417i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(availableBlocks), Long.valueOf(blockSize));
            aw = C5046bo.m7524aw(context, Process.myPid());
            C4990ab.m7417i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", aw, Long.valueOf(availableBlocks), Long.valueOf(31457280));
            intent = new Intent();
            intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
            intent.setFlags(268435456);
            context.startActivity(intent);
            Process.killProcess(Process.myPid());
            AppMethodBeat.m2505o(115047);
        }
        C4990ab.m7417i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(availableBlocks), Long.valueOf(blockSize));
        if (blockSize != 0 && availableBlocks < 31457280) {
            aw = C5046bo.m7524aw(context, Process.myPid());
            C4990ab.m7417i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", aw, Long.valueOf(availableBlocks), Long.valueOf(31457280));
            if (!(aw.equals("") || aw.endsWith(":nospace"))) {
                intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent.setFlags(268435456);
                context.startActivity(intent);
                Process.killProcess(Process.myPid());
            }
        }
        AppMethodBeat.m2505o(115047);
    }

    /* renamed from: ba */
    public static boolean m3162ba(Context context) {
        AppMethodBeat.m2504i(115048);
        if (f1229wY) {
            C4990ab.m7416i("MultiDex", "if need dexopt: VM has multidex support, MultiDex support library is disabled.");
            AppMethodBeat.m2505o(115048);
            return false;
        } else if (crE) {
            C4990ab.m7416i("MultiDex", "if need dexopt: has inited.");
            AppMethodBeat.m2505o(115048);
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            C1523a.m3165bl(context);
            if (crI == null || crI.size() <= 0) {
                AppMethodBeat.m2505o(115048);
                return true;
            }
            crF = context.getDir("cache", 0).getAbsolutePath();
            crG = context.getDir("dex", 0).getAbsolutePath();
            crH = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
            File file = new File(crG);
            if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                int size = crI.size();
                File file2 = new File(crF);
                if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                    C4990ab.m7417i("MicroMsg.MultiDex", "if need dexopt: install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                    if (file.list() == null || file.list().length < size || file2.list() == null || file2.list().length < size) {
                        String str = "MicroMsg.MultiDex";
                        String str2 = "if need dexopt: dex file count not equal, install path: %s vs %s, opt path: %s vs %s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(file.list() == null ? -1 : file.list().length);
                        objArr[1] = Integer.valueOf(size);
                        objArr[2] = Integer.valueOf(file2.list() == null ? -1 : file2.list().length);
                        objArr[3] = Integer.valueOf(size);
                        C4990ab.m7417i(str, str2, objArr);
                        AppMethodBeat.m2505o(115048);
                        return true;
                    } else if (context.getApplicationInfo() == null) {
                        AppMethodBeat.m2505o(115048);
                        return false;
                    } else {
                        for (C1521a c1521a : crI) {
                            synchronized (C1523a.class) {
                                try {
                                    C4990ab.m7417i("MicroMsg.MultiDex", "if need dexopt: prepare dex to load, file: %s, md5: %s, loadClass: %s", c1521a.crJ, c1521a.crK, c1521a.crL);
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.m2505o(115048);
                                }
                            }
                            if (C1523a.m3156a(c1521a)) {
                                C4990ab.m7417i("MicroMsg.MultiDex", "if need dexopt: verify dex for check md5: targetFilePath: [%s] time: %d", c1521a.crJ, Long.valueOf(C5046bo.m7566gb(currentTimeMillis)));
                            } else {
                                Object[] objArr2 = new Object[1];
                                boolean z = c1521a.crJ;
                                objArr2[0] = z;
                                C4990ab.m7413e("MicroMsg.MultiDex", "if need dexopt: targetDexFile md5 mismatch or not exists: %s", objArr2);
                                return z;
                            }
                        }
                        AppMethodBeat.m2505o(115048);
                        return false;
                    }
                }
                C4990ab.m7414f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dexopt directory failed");
                AppMethodBeat.m2505o(115048);
                return true;
            }
            C4990ab.m7414f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dex directory failed");
            AppMethodBeat.m2505o(115048);
            return true;
        }
    }

    /* renamed from: bk */
    public static synchronized boolean m3164bk(Context context) {
        boolean z;
        synchronized (C1523a.class) {
            AppMethodBeat.m2504i(115049);
            C4990ab.m7417i("MicroMsg.MultiDex", "install multidex hasinit: %b, force: %b", Boolean.valueOf(crE), Boolean.TRUE);
            if (f1229wY) {
                C4990ab.m7416i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
                z = true;
                AppMethodBeat.m2505o(115049);
            } else if (crE) {
                z = true;
                AppMethodBeat.m2505o(115049);
            } else {
                if (context.getClassLoader() != null) {
                    C4990ab.m7416i("MicroMsg.MultiDex", "classloader: " + context.getClassLoader().toString());
                } else {
                    C4990ab.m7412e("MicroMsg.MultiDex", "classloader is null");
                }
                long currentTimeMillis = System.currentTimeMillis();
                C1523a.m3165bl(context);
                if (crI == null || crI.size() <= 0) {
                    z = false;
                    AppMethodBeat.m2505o(115049);
                } else {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    if (applicationInfo == null) {
                        z = false;
                        AppMethodBeat.m2505o(115049);
                    } else {
                        crF = context.getDir("cache", 0).getAbsolutePath();
                        crG = context.getDir("dex", 0).getAbsolutePath();
                        crH = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
                        File file = new File(crG);
                        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                            try {
                                int size = crI.size();
                                File file2 = new File(crF);
                                if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                                    C4990ab.m7417i("MicroMsg.MultiDex", "install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                                    ArrayList arrayList = new ArrayList(crI.size());
                                    Object obj = null;
                                    for (int i = 0; i < 5 && r2 == null; i++) {
                                        arrayList.clear();
                                        for (C1521a c1521a : crI) {
                                            C4990ab.m7417i("MicroMsg.MultiDex", "prepare dex to load, file: %s, md5: %s, loadClass: %s", c1521a.crJ, c1521a.crK, c1521a.crL);
                                            if (C1523a.m3156a(c1521a)) {
                                                C4990ab.m7417i("MicroMsg.MultiDex", "verify dex for check md5: targetFilePath: [%s] time: %d", c1521a.crJ, Long.valueOf(C5046bo.m7566gb(currentTimeMillis)));
                                                if (C1523a.m3161b(context, c1521a.crL, false)) {
                                                    C4990ab.m7417i("MicroMsg.MultiDex", "dex has been loaded, skip. targetFilePath: [%s]", c1521a.crJ);
                                                } else {
                                                    C4990ab.m7421w("MicroMsg.MultiDex", "dex [%s] is not load, it should be reload in further steps.", c1521a.crJ);
                                                }
                                            } else {
                                                C4990ab.m7413e("MicroMsg.MultiDex", "targetDexFile md5 mismatch or not exists: %s, force: %b", c1521a.crJ, Boolean.TRUE);
                                                ZipFile zipFile = new ZipFile(applicationInfo.sourceDir);
                                                boolean a = C1523a.m3157a(zipFile, c1521a);
                                                try {
                                                    zipFile.close();
                                                } catch (Exception e) {
                                                    C4990ab.m7420w("MicroMsg.MultiDex", "base apk file close quietly failed");
                                                }
                                                if (!a) {
                                                    Exception exception = new Exception("overwriteLocalSecondaryDexFromApk fail");
                                                    AppMethodBeat.m2505o(115049);
                                                    throw exception;
                                                }
                                            }
                                            arrayList.add(new File(crG + "/" + c1521a.crJ));
                                        }
                                        if (arrayList.isEmpty()) {
                                            C4990ab.m7416i("MicroMsg.MultiDex", "Nothing needs to be installed.");
                                            obj = 1;
                                            break;
                                        }
                                        C1523a.m3155a(context, crF, arrayList);
                                        for (C1521a c1521a2 : crI) {
                                            if (!C1523a.m3161b(context, c1521a2.crL, true)) {
                                                C4990ab.m7421w("MicroMsg.MultiDex", "Failed to load dex [%s] in %d round, retry.", c1521a2.crJ, Integer.valueOf(i + 1));
                                                String name = new File(crG + "/" + c1521a2.crJ).getName();
                                                if (!name.endsWith(".dex")) {
                                                    size = name.lastIndexOf(".");
                                                    if (size < 0) {
                                                        name = name + ".dex";
                                                    } else {
                                                        StringBuilder stringBuilder = new StringBuilder(size + 4);
                                                        stringBuilder.append(name, 0, size);
                                                        stringBuilder.append(".dex");
                                                        name = stringBuilder.toString();
                                                    }
                                                }
                                                File file3 = new File(file2, name);
                                                if (file3.exists()) {
                                                    C4990ab.m7420w("MicroMsg.MultiDex", "Remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    if (!file3.delete()) {
                                                        C4990ab.m7420w("MicroMsg.MultiDex", "Failed to remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    }
                                                }
                                                obj = null;
                                            }
                                        }
                                        int obj2 = 1;
                                    }
                                    if (obj2 == null) {
                                        RuntimeException runtimeException = new RuntimeException("Some dex is not installed successfully after 5 times retry !!");
                                        AppMethodBeat.m2505o(115049);
                                        throw runtimeException;
                                    }
                                    crE = true;
                                    C4990ab.m7416i("MicroMsg.MultiDex", "install done");
                                    z = true;
                                    AppMethodBeat.m2505o(115049);
                                } else {
                                    C4990ab.m7414f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dexopt directory failed");
                                    z = false;
                                    AppMethodBeat.m2505o(115049);
                                }
                            } catch (Throwable th) {
                                C4990ab.m7413e("MicroMsg.MultiDex", "Multidex installation failure", th);
                                C4990ab.printErrStackTrace("MicroMsg.MultiDex", th, "Multidex installation failure", new Object[0]);
                                C1523a.m3163bb(context);
                                RuntimeException runtimeException2 = new RuntimeException("Multi dex installation failed (" + th.getMessage() + ").", th);
                                AppMethodBeat.m2505o(115049);
                            }
                        } else {
                            C4990ab.m7414f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dex directory failed");
                            z = false;
                            AppMethodBeat.m2505o(115049);
                        }
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m3161b(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(115050);
        try {
            if (Class.forName(str, false, context.getClassLoader()) != null) {
                AppMethodBeat.m2505o(115050);
                return true;
            }
        } catch (ClassNotFoundException e) {
            if (z) {
                C4990ab.printErrStackTrace("MicroMsg.MultiDex", e, "Failed to load a dex.", new Object[0]);
            }
        }
        if (z) {
            C4990ab.m7420w("MicroMsg.MultiDex", "checkDexLoaded fail.... ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(115050);
        return false;
    }

    /* renamed from: a */
    private static boolean m3157a(ZipFile zipFile, C1521a c1521a) {
        AppMethodBeat.m2504i(115051);
        C4990ab.m7416i("MicroMsg.MultiDex", "enter overwriteLocalSecondaryDexFromApk, please keep concerned at which process calls it.");
        File file = new File(crH);
        String str = crG + "/" + c1521a.crJ;
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            shareFileLockHelper = ShareFileLockHelper.m9351ao(file);
            C4990ab.m7417i("MicroMsg.MultiDex", "extract dex waiting for write lock cost %dms on file: %s", Long.valueOf(C5046bo.m7566gb(currentTimeMillis)), crH);
            InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(c1521a.crJ));
            BufferedOutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.close();
                C1523a.closeQuietly(inputStream);
                C4990ab.m7417i("MicroMsg.MultiDex", "extract dex from apk done: %s", crH);
                try {
                    shareFileLockHelper.close();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(115051);
                return true;
            } catch (Throwable th) {
                C1523a.closeQuietly(inputStream);
                AppMethodBeat.m2505o(115051);
            }
        } catch (IOException e2) {
            try {
                C4990ab.printErrStackTrace("MicroMsg.MultiDex", e2, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.MultiDex", "overwrite local secondary dex failed, cannot lock file: %s", file.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Exception e3) {
                        C4990ab.printErrStackTrace("MicroMsg.MultiDex", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(115051);
                return false;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Exception e4) {
                        C4990ab.printErrStackTrace("MicroMsg.MultiDex", e4, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(115051);
            }
        }
    }

    /* renamed from: F */
    private static boolean m3154F(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(115052);
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        C4990ab.m7416i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        AppMethodBeat.m2505o(115052);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107 A:{SYNTHETIC, Splitter:B:40:0x0107} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8 A:{SYNTHETIC, Splitter:B:32:0x00e8} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107 A:{SYNTHETIC, Splitter:B:40:0x0107} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m3156a(C1521a c1521a) {
        Throwable e;
        AppMethodBeat.m2504i(115053);
        String str = crG + "/" + c1521a.crJ;
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            File file2 = new File(crH);
            ShareFileLockHelper ao;
            Closeable fileInputStream;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ao = ShareFileLockHelper.m9351ao(file2);
                try {
                    C4990ab.m7417i("MicroMsg.MultiDex", "extract dex waiting for verify lock cost %dms on file: %s", Long.valueOf(C5046bo.m7566gb(currentTimeMillis)), crH);
                    fileInputStream = new FileInputStream(str);
                    try {
                        str = C1178g.m2585b(fileInputStream, 102400);
                        if (str == null || !str.equalsIgnoreCase(c1521a.crK)) {
                            try {
                                ao.close();
                            } catch (Exception e2) {
                                C4990ab.m7413e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                            C1523a.closeQuietly(fileInputStream);
                            AppMethodBeat.m2505o(115053);
                            return false;
                        }
                        try {
                            ao.close();
                        } catch (Exception e3) {
                            C4990ab.m7413e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                        C1523a.closeQuietly(fileInputStream);
                        AppMethodBeat.m2505o(115053);
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                            C4990ab.m7413e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                            if (ao != null) {
                                try {
                                    ao.close();
                                } catch (Exception e5) {
                                    C4990ab.m7413e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                                }
                            }
                            C1523a.closeQuietly(fileInputStream);
                            AppMethodBeat.m2505o(115053);
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (ao != null) {
                                try {
                                    ao.close();
                                } catch (Exception e6) {
                                    C4990ab.m7413e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                                }
                            }
                            C1523a.closeQuietly(fileInputStream);
                            AppMethodBeat.m2505o(115053);
                            throw e;
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    fileInputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    C4990ab.m7413e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                    if (ao != null) {
                    }
                    C1523a.closeQuietly(fileInputStream);
                    AppMethodBeat.m2505o(115053);
                    return false;
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (ao != null) {
                    }
                    C1523a.closeQuietly(fileInputStream);
                    AppMethodBeat.m2505o(115053);
                    throw e;
                }
            } catch (IOException e8) {
                e = e8;
                fileInputStream = null;
                ao = null;
            } catch (Throwable th3) {
                e = th3;
                fileInputStream = null;
                ao = null;
                if (ao != null) {
                }
                C1523a.closeQuietly(fileInputStream);
                AppMethodBeat.m2505o(115053);
                throw e;
            }
        }
        C4990ab.m7417i("MicroMsg.MultiDex", "dex file not exist: %s", str);
        AppMethodBeat.m2505o(115053);
        return false;
    }

    /* renamed from: a */
    private static void m3155a(Context context, String str, List<File> list) {
        AppMethodBeat.m2504i(115054);
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        C4990ab.m7416i("MicroMsg.MultiDex", "before reflectPathClassLoader for debug: ClassLoader ".concat(String.valueOf(pathClassLoader)));
        Collections.sort(list, new C15201());
        for (File name : list) {
            C4990ab.m7416i("MicroMsg.MultiDex", "real reflectPathClassLoader dexname: " + name.getName());
        }
        File name2 = new File(str);
        if (!list.isEmpty()) {
            Object obj;
            if (VERSION.SDK_INT >= 19) {
                obj = C1523a.m3158b(pathClassLoader, "pathList").get(pathClassLoader);
                ArrayList arrayList = new ArrayList();
                C1523a.m3160b(obj, "dexElements", C1522b.m3153a(obj, new ArrayList(list), name2, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        C4990ab.m7421w("MicroMsg.MultiDex", "Exception in makeDexElement", (IOException) it.next());
                        AppMethodBeat.m2505o(115054);
                        throw ((IOException) it.next());
                    }
                }
            }
            obj = C1523a.m3158b(pathClassLoader, "pathList").get(pathClassLoader);
            ArrayList arrayList2 = new ArrayList(list);
            C1523a.m3160b(obj, "dexElements", (Object[]) C1523a.m3159b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList2, name2}));
        }
        C4990ab.m7416i("MicroMsg.MultiDex", "after reflectPathClassloader for debug: ClassLoader ".concat(String.valueOf(pathClassLoader)));
        AppMethodBeat.m2505o(115054);
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.m2504i(115055);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C4990ab.m7421w("MicroMsg.MultiDex", "Failed to close resource", e);
                AppMethodBeat.m2505o(115055);
                return;
            }
        }
        AppMethodBeat.m2505o(115055);
    }

    /* renamed from: bl */
    private static int m3165bl(Context context) {
        AppMethodBeat.m2504i(115056);
        if (crI != null) {
            C4990ab.m7420w("MicroMsg.MultiDex", "preloaded dex files not empty, skipped preloading");
            AppMethodBeat.m2505o(115056);
            return 1;
        }
        try {
            Set set;
            String convertStreamToString = C5046bo.convertStreamToString(context.getAssets().open("secondary-program-dex-jars/metadata.txt"));
            if (convertStreamToString == null || convertStreamToString.length() <= 0) {
                set = null;
            } else {
                set = new HashSet();
                for (String str : convertStreamToString.split(IOUtils.LINE_SEPARATOR_UNIX)) {
                    if (str != null && str.length() > 0) {
                        String[] split = str.split(" ", 3);
                        if (split != null && split.length >= 3) {
                            String trim = split[0].trim();
                            C4990ab.m7417i("MicroMsg.MultiDex", "try parse dexname: %s, dexmd5:%s, classname:%s", trim, split[1].trim(), split[2].trim());
                            if (trim != null && trim.length() > 0) {
                                set.add(new C1521a(trim, r7, str));
                            }
                        }
                    }
                }
            }
            crI = set;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MultiDex", "load preload libraries failed");
            C4990ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(115056);
        return 0;
    }

    /* renamed from: b */
    private static Field m3158b(Object obj, String str) {
        AppMethodBeat.m2504i(115057);
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                AppMethodBeat.m2505o(115057);
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        NoSuchFieldException noSuchFieldException = new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
        AppMethodBeat.m2505o(115057);
        throw noSuchFieldException;
    }

    /* renamed from: b */
    private static Method m3159b(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.m2504i(115058);
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                AppMethodBeat.m2505o(115058);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
        AppMethodBeat.m2505o(115058);
        throw noSuchMethodException;
    }

    /* renamed from: b */
    private static void m3160b(Object obj, String str, Object[] objArr) {
        AppMethodBeat.m2504i(115059);
        Field b = C1523a.m3158b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b.set(obj, objArr3);
        AppMethodBeat.m2505o(115059);
    }
}

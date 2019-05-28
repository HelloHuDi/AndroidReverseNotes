package com.tencent.mm.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class a {
    private static boolean crE = false;
    private static String crF;
    private static String crG;
    private static String crH;
    private static Set<a> crI;
    public static final boolean wY = F(System.getProperty("java.vm.version"));

    static class a {
        String crJ;
        String crK;
        String crL;

        public a(String str, String str2, String str3) {
            this.crJ = str;
            this.crK = str2;
            this.crL = str3;
        }
    }

    static final class b {
        static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method e;
            AppMethodBeat.i(115046);
            try {
                e = a.e(obj, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class});
            } catch (NoSuchMethodException e2) {
                ab.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    e = a.e(obj, "makeDexElements", new Class[]{List.class, File.class, List.class});
                } catch (NoSuchMethodException e3) {
                    ab.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    try {
                        e = a.e(obj, "makePathElements", new Class[]{List.class, File.class, List.class});
                    } catch (NoSuchMethodException e4) {
                        ab.e("MicroMsg.MultiDex", "NoSuchMethodException: makePathElements(List,File,List) failure");
                        AppMethodBeat.o(115046);
                        throw e4;
                    }
                }
            }
            Object[] objArr = (Object[]) e.invoke(obj, new Object[]{arrayList, file, arrayList2});
            AppMethodBeat.o(115046);
            return objArr;
        }
    }

    static /* synthetic */ Method e(Object obj, String str, Class[] clsArr) {
        AppMethodBeat.i(139082);
        Method b = b(obj, str, clsArr);
        AppMethodBeat.o(139082);
        return b;
    }

    static {
        AppMethodBeat.i(115061);
        AppMethodBeat.o(115061);
    }

    private a() {
    }

    public static void bb(Context context) {
        long availableBlocks;
        long blockSize;
        String aw;
        Intent intent;
        AppMethodBeat.i(115047);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            } catch (Exception e) {
                ab.e("MicroMsg.MultiDex", "get db spare space error");
                blockSize = 0;
                ab.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(availableBlocks), Long.valueOf(blockSize));
                aw = bo.aw(context, Process.myPid());
                ab.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", aw, Long.valueOf(availableBlocks), Long.valueOf(31457280));
                intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent.setFlags(268435456);
                context.startActivity(intent);
                Process.killProcess(Process.myPid());
                AppMethodBeat.o(115047);
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            ab.e("MicroMsg.MultiDex", "get db spare space error");
            blockSize = 0;
            ab.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(availableBlocks), Long.valueOf(blockSize));
            aw = bo.aw(context, Process.myPid());
            ab.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", aw, Long.valueOf(availableBlocks), Long.valueOf(31457280));
            intent = new Intent();
            intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
            intent.setFlags(268435456);
            context.startActivity(intent);
            Process.killProcess(Process.myPid());
            AppMethodBeat.o(115047);
        }
        ab.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(availableBlocks), Long.valueOf(blockSize));
        if (blockSize != 0 && availableBlocks < 31457280) {
            aw = bo.aw(context, Process.myPid());
            ab.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", aw, Long.valueOf(availableBlocks), Long.valueOf(31457280));
            if (!(aw.equals("") || aw.endsWith(":nospace"))) {
                intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent.setFlags(268435456);
                context.startActivity(intent);
                Process.killProcess(Process.myPid());
            }
        }
        AppMethodBeat.o(115047);
    }

    public static boolean ba(Context context) {
        AppMethodBeat.i(115048);
        if (wY) {
            ab.i("MultiDex", "if need dexopt: VM has multidex support, MultiDex support library is disabled.");
            AppMethodBeat.o(115048);
            return false;
        } else if (crE) {
            ab.i("MultiDex", "if need dexopt: has inited.");
            AppMethodBeat.o(115048);
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            bl(context);
            if (crI == null || crI.size() <= 0) {
                AppMethodBeat.o(115048);
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
                    ab.i("MicroMsg.MultiDex", "if need dexopt: install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                    if (file.list() == null || file.list().length < size || file2.list() == null || file2.list().length < size) {
                        String str = "MicroMsg.MultiDex";
                        String str2 = "if need dexopt: dex file count not equal, install path: %s vs %s, opt path: %s vs %s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(file.list() == null ? -1 : file.list().length);
                        objArr[1] = Integer.valueOf(size);
                        objArr[2] = Integer.valueOf(file2.list() == null ? -1 : file2.list().length);
                        objArr[3] = Integer.valueOf(size);
                        ab.i(str, str2, objArr);
                        AppMethodBeat.o(115048);
                        return true;
                    } else if (context.getApplicationInfo() == null) {
                        AppMethodBeat.o(115048);
                        return false;
                    } else {
                        for (a aVar : crI) {
                            synchronized (a.class) {
                                try {
                                    ab.i("MicroMsg.MultiDex", "if need dexopt: prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.crJ, aVar.crK, aVar.crL);
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.o(115048);
                                }
                            }
                            if (a(aVar)) {
                                ab.i("MicroMsg.MultiDex", "if need dexopt: verify dex for check md5: targetFilePath: [%s] time: %d", aVar.crJ, Long.valueOf(bo.gb(currentTimeMillis)));
                            } else {
                                Object[] objArr2 = new Object[1];
                                boolean z = aVar.crJ;
                                objArr2[0] = z;
                                ab.e("MicroMsg.MultiDex", "if need dexopt: targetDexFile md5 mismatch or not exists: %s", objArr2);
                                return z;
                            }
                        }
                        AppMethodBeat.o(115048);
                        return false;
                    }
                }
                ab.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dexopt directory failed");
                AppMethodBeat.o(115048);
                return true;
            }
            ab.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dex directory failed");
            AppMethodBeat.o(115048);
            return true;
        }
    }

    public static synchronized boolean bk(Context context) {
        boolean z;
        synchronized (a.class) {
            AppMethodBeat.i(115049);
            ab.i("MicroMsg.MultiDex", "install multidex hasinit: %b, force: %b", Boolean.valueOf(crE), Boolean.TRUE);
            if (wY) {
                ab.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
                z = true;
                AppMethodBeat.o(115049);
            } else if (crE) {
                z = true;
                AppMethodBeat.o(115049);
            } else {
                if (context.getClassLoader() != null) {
                    ab.i("MicroMsg.MultiDex", "classloader: " + context.getClassLoader().toString());
                } else {
                    ab.e("MicroMsg.MultiDex", "classloader is null");
                }
                long currentTimeMillis = System.currentTimeMillis();
                bl(context);
                if (crI == null || crI.size() <= 0) {
                    z = false;
                    AppMethodBeat.o(115049);
                } else {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    if (applicationInfo == null) {
                        z = false;
                        AppMethodBeat.o(115049);
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
                                    ab.i("MicroMsg.MultiDex", "install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                                    ArrayList arrayList = new ArrayList(crI.size());
                                    Object obj = null;
                                    for (int i = 0; i < 5 && r2 == null; i++) {
                                        arrayList.clear();
                                        for (a aVar : crI) {
                                            ab.i("MicroMsg.MultiDex", "prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.crJ, aVar.crK, aVar.crL);
                                            if (a(aVar)) {
                                                ab.i("MicroMsg.MultiDex", "verify dex for check md5: targetFilePath: [%s] time: %d", aVar.crJ, Long.valueOf(bo.gb(currentTimeMillis)));
                                                if (b(context, aVar.crL, false)) {
                                                    ab.i("MicroMsg.MultiDex", "dex has been loaded, skip. targetFilePath: [%s]", aVar.crJ);
                                                } else {
                                                    ab.w("MicroMsg.MultiDex", "dex [%s] is not load, it should be reload in further steps.", aVar.crJ);
                                                }
                                            } else {
                                                ab.e("MicroMsg.MultiDex", "targetDexFile md5 mismatch or not exists: %s, force: %b", aVar.crJ, Boolean.TRUE);
                                                ZipFile zipFile = new ZipFile(applicationInfo.sourceDir);
                                                boolean a = a(zipFile, aVar);
                                                try {
                                                    zipFile.close();
                                                } catch (Exception e) {
                                                    ab.w("MicroMsg.MultiDex", "base apk file close quietly failed");
                                                }
                                                if (!a) {
                                                    Exception exception = new Exception("overwriteLocalSecondaryDexFromApk fail");
                                                    AppMethodBeat.o(115049);
                                                    throw exception;
                                                }
                                            }
                                            arrayList.add(new File(crG + "/" + aVar.crJ));
                                        }
                                        if (arrayList.isEmpty()) {
                                            ab.i("MicroMsg.MultiDex", "Nothing needs to be installed.");
                                            obj = 1;
                                            break;
                                        }
                                        a(context, crF, arrayList);
                                        for (a aVar2 : crI) {
                                            if (!b(context, aVar2.crL, true)) {
                                                ab.w("MicroMsg.MultiDex", "Failed to load dex [%s] in %d round, retry.", aVar2.crJ, Integer.valueOf(i + 1));
                                                String name = new File(crG + "/" + aVar2.crJ).getName();
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
                                                    ab.w("MicroMsg.MultiDex", "Remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    if (!file3.delete()) {
                                                        ab.w("MicroMsg.MultiDex", "Failed to remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    }
                                                }
                                                obj = null;
                                            }
                                        }
                                        int obj2 = 1;
                                    }
                                    if (obj2 == null) {
                                        RuntimeException runtimeException = new RuntimeException("Some dex is not installed successfully after 5 times retry !!");
                                        AppMethodBeat.o(115049);
                                        throw runtimeException;
                                    }
                                    crE = true;
                                    ab.i("MicroMsg.MultiDex", "install done");
                                    z = true;
                                    AppMethodBeat.o(115049);
                                } else {
                                    ab.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dexopt directory failed");
                                    z = false;
                                    AppMethodBeat.o(115049);
                                }
                            } catch (Throwable th) {
                                ab.e("MicroMsg.MultiDex", "Multidex installation failure", th);
                                ab.printErrStackTrace("MicroMsg.MultiDex", th, "Multidex installation failure", new Object[0]);
                                bb(context);
                                RuntimeException runtimeException2 = new RuntimeException("Multi dex installation failed (" + th.getMessage() + ").", th);
                                AppMethodBeat.o(115049);
                            }
                        } else {
                            ab.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dex directory failed");
                            z = false;
                            AppMethodBeat.o(115049);
                        }
                    }
                }
            }
        }
        return z;
    }

    private static boolean b(Context context, String str, boolean z) {
        AppMethodBeat.i(115050);
        try {
            if (Class.forName(str, false, context.getClassLoader()) != null) {
                AppMethodBeat.o(115050);
                return true;
            }
        } catch (ClassNotFoundException e) {
            if (z) {
                ab.printErrStackTrace("MicroMsg.MultiDex", e, "Failed to load a dex.", new Object[0]);
            }
        }
        if (z) {
            ab.w("MicroMsg.MultiDex", "checkDexLoaded fail.... ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(115050);
        return false;
    }

    private static boolean a(ZipFile zipFile, a aVar) {
        AppMethodBeat.i(115051);
        ab.i("MicroMsg.MultiDex", "enter overwriteLocalSecondaryDexFromApk, please keep concerned at which process calls it.");
        File file = new File(crH);
        String str = crG + "/" + aVar.crJ;
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            shareFileLockHelper = ShareFileLockHelper.ao(file);
            ab.i("MicroMsg.MultiDex", "extract dex waiting for write lock cost %dms on file: %s", Long.valueOf(bo.gb(currentTimeMillis)), crH);
            InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(aVar.crJ));
            BufferedOutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.close();
                closeQuietly(inputStream);
                ab.i("MicroMsg.MultiDex", "extract dex from apk done: %s", crH);
                try {
                    shareFileLockHelper.close();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                }
                AppMethodBeat.o(115051);
                return true;
            } catch (Throwable th) {
                closeQuietly(inputStream);
                AppMethodBeat.o(115051);
            }
        } catch (IOException e2) {
            try {
                ab.printErrStackTrace("MicroMsg.MultiDex", e2, "", new Object[0]);
                ab.e("MicroMsg.MultiDex", "overwrite local secondary dex failed, cannot lock file: %s", file.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.MultiDex", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(115051);
                return false;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Exception e4) {
                        ab.printErrStackTrace("MicroMsg.MultiDex", e4, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(115051);
            }
        }
    }

    private static boolean F(String str) {
        boolean z = false;
        AppMethodBeat.i(115052);
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
        ab.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        AppMethodBeat.o(115052);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107 A:{SYNTHETIC, Splitter:B:40:0x0107} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8 A:{SYNTHETIC, Splitter:B:32:0x00e8} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107 A:{SYNTHETIC, Splitter:B:40:0x0107} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(a aVar) {
        Throwable e;
        AppMethodBeat.i(115053);
        String str = crG + "/" + aVar.crJ;
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            File file2 = new File(crH);
            ShareFileLockHelper ao;
            Closeable fileInputStream;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ao = ShareFileLockHelper.ao(file2);
                try {
                    ab.i("MicroMsg.MultiDex", "extract dex waiting for verify lock cost %dms on file: %s", Long.valueOf(bo.gb(currentTimeMillis)), crH);
                    fileInputStream = new FileInputStream(str);
                    try {
                        str = g.b(fileInputStream, 102400);
                        if (str == null || !str.equalsIgnoreCase(aVar.crK)) {
                            try {
                                ao.close();
                            } catch (Exception e2) {
                                ab.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                            closeQuietly(fileInputStream);
                            AppMethodBeat.o(115053);
                            return false;
                        }
                        try {
                            ao.close();
                        } catch (Exception e3) {
                            ab.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                        closeQuietly(fileInputStream);
                        AppMethodBeat.o(115053);
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                            ab.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                            if (ao != null) {
                                try {
                                    ao.close();
                                } catch (Exception e5) {
                                    ab.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                                }
                            }
                            closeQuietly(fileInputStream);
                            AppMethodBeat.o(115053);
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (ao != null) {
                                try {
                                    ao.close();
                                } catch (Exception e6) {
                                    ab.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                                }
                            }
                            closeQuietly(fileInputStream);
                            AppMethodBeat.o(115053);
                            throw e;
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    fileInputStream = null;
                    ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    ab.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                    if (ao != null) {
                    }
                    closeQuietly(fileInputStream);
                    AppMethodBeat.o(115053);
                    return false;
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (ao != null) {
                    }
                    closeQuietly(fileInputStream);
                    AppMethodBeat.o(115053);
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
                closeQuietly(fileInputStream);
                AppMethodBeat.o(115053);
                throw e;
            }
        }
        ab.i("MicroMsg.MultiDex", "dex file not exist: %s", str);
        AppMethodBeat.o(115053);
        return false;
    }

    private static void a(Context context, String str, List<File> list) {
        AppMethodBeat.i(115054);
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        ab.i("MicroMsg.MultiDex", "before reflectPathClassLoader for debug: ClassLoader ".concat(String.valueOf(pathClassLoader)));
        Collections.sort(list, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(115045);
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file == null || file2 == null) {
                    AppMethodBeat.o(115045);
                    return 0;
                }
                String name = file.getName();
                String name2 = file2.getName();
                if (name.contains("classes") && name2.contains("classes")) {
                    int charAt = name.charAt(7) - name2.charAt(7);
                    AppMethodBeat.o(115045);
                    return charAt;
                }
                AppMethodBeat.o(115045);
                return 0;
            }
        });
        for (File name : list) {
            ab.i("MicroMsg.MultiDex", "real reflectPathClassLoader dexname: " + name.getName());
        }
        File name2 = new File(str);
        if (!list.isEmpty()) {
            Object obj;
            if (VERSION.SDK_INT >= 19) {
                obj = b(pathClassLoader, "pathList").get(pathClassLoader);
                ArrayList arrayList = new ArrayList();
                b(obj, "dexElements", b.a(obj, new ArrayList(list), name2, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        ab.w("MicroMsg.MultiDex", "Exception in makeDexElement", (IOException) it.next());
                        AppMethodBeat.o(115054);
                        throw ((IOException) it.next());
                    }
                }
            }
            obj = b(pathClassLoader, "pathList").get(pathClassLoader);
            ArrayList arrayList2 = new ArrayList(list);
            b(obj, "dexElements", (Object[]) b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList2, name2}));
        }
        ab.i("MicroMsg.MultiDex", "after reflectPathClassloader for debug: ClassLoader ".concat(String.valueOf(pathClassLoader)));
        AppMethodBeat.o(115054);
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(115055);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                ab.w("MicroMsg.MultiDex", "Failed to close resource", e);
                AppMethodBeat.o(115055);
                return;
            }
        }
        AppMethodBeat.o(115055);
    }

    private static int bl(Context context) {
        AppMethodBeat.i(115056);
        if (crI != null) {
            ab.w("MicroMsg.MultiDex", "preloaded dex files not empty, skipped preloading");
            AppMethodBeat.o(115056);
            return 1;
        }
        try {
            Set set;
            String convertStreamToString = bo.convertStreamToString(context.getAssets().open("secondary-program-dex-jars/metadata.txt"));
            if (convertStreamToString == null || convertStreamToString.length() <= 0) {
                set = null;
            } else {
                set = new HashSet();
                for (String str : convertStreamToString.split(IOUtils.LINE_SEPARATOR_UNIX)) {
                    if (str != null && str.length() > 0) {
                        String[] split = str.split(" ", 3);
                        if (split != null && split.length >= 3) {
                            String trim = split[0].trim();
                            ab.i("MicroMsg.MultiDex", "try parse dexname: %s, dexmd5:%s, classname:%s", trim, split[1].trim(), split[2].trim());
                            if (trim != null && trim.length() > 0) {
                                set.add(new a(trim, r7, str));
                            }
                        }
                    }
                }
            }
            crI = set;
        } catch (Exception e) {
            ab.e("MicroMsg.MultiDex", "load preload libraries failed");
            ab.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
        }
        AppMethodBeat.o(115056);
        return 0;
    }

    private static Field b(Object obj, String str) {
        AppMethodBeat.i(115057);
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                AppMethodBeat.o(115057);
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        NoSuchFieldException noSuchFieldException = new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
        AppMethodBeat.o(115057);
        throw noSuchFieldException;
    }

    private static Method b(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.i(115058);
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                AppMethodBeat.o(115058);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
        AppMethodBeat.o(115058);
        throw noSuchMethodException;
    }

    private static void b(Object obj, String str, Object[] objArr) {
        AppMethodBeat.i(115059);
        Field b = b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b.set(obj, objArr3);
        AppMethodBeat.o(115059);
    }
}

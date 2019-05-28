package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* renamed from: android.support.multidex.a */
public final class C31843a {
    /* renamed from: wW */
    private static final String f14594wW = ("code_cache" + File.separator + "secondary-dexes");
    /* renamed from: wX */
    private static final Set<String> f14595wX = new HashSet();
    /* renamed from: wY */
    private static final boolean f14596wY = C31843a.m51590F(System.getProperty("java.vm.version"));

    /* renamed from: android.support.multidex.a$b */
    static final class C17398b {
        /* renamed from: a */
        static void m27020a(ClassLoader classLoader, List<File> list, File file) {
            Object obj = C31843a.m51596b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(list);
            C31843a.m51595a(obj, "dexElements", (Object[]) C31843a.m51597b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList2, file, arrayList}));
            if (arrayList.size() > 0) {
                Object obj2;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                Field c = C31843a.m51596b(classLoader, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr = (IOException[]) c.get(classLoader);
                if (iOExceptionArr == null) {
                    obj2 = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    obj = new IOException[(arrayList.size() + iOExceptionArr.length)];
                    arrayList.toArray(obj);
                    System.arraycopy(iOExceptionArr, 0, obj, arrayList.size(), iOExceptionArr.length);
                    obj2 = obj;
                }
                c.set(classLoader, obj2);
            }
        }
    }

    /* renamed from: android.support.multidex.a$a */
    static final class C25315a {
        /* renamed from: a */
        static void m39918a(ClassLoader classLoader, List<File> list, File file) {
            Object obj = C31843a.m51596b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList(list);
            C31843a.m51595a(obj, "dexElements", (Object[]) C31843a.m51597b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file}));
        }
    }

    /* renamed from: android.support.multidex.a$c */
    static final class C31844c {
        /* renamed from: a */
        static void m51601a(ClassLoader classLoader, List<File> list) {
            int size = list.size();
            Field c = C31843a.m51596b(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) c.get(classLoader));
            Object[] objArr = new String[size];
            Object[] objArr2 = new File[size];
            Object[] objArr3 = new ZipFile[size];
            Object[] objArr4 = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                objArr[previousIndex] = absolutePath;
                objArr2[previousIndex] = file;
                objArr3[previousIndex] = new ZipFile(file);
                objArr4[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            c.set(classLoader, stringBuilder.toString());
            C31843a.m51595a((Object) classLoader, "mPaths", objArr);
            C31843a.m51595a((Object) classLoader, "mFiles", objArr2);
            C31843a.m51595a((Object) classLoader, "mZips", objArr3);
            C31843a.m51595a((Object) classLoader, "mDexs", objArr4);
        }
    }

    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: H */
    public static void m51591H(Context context) {
        if (!f14596wY) {
            if (VERSION.SDK_INT < 4) {
                throw new RuntimeException("Multi dex installation failed. SDK " + VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
            }
            try {
                ApplicationInfo I = C31843a.m51592I(context);
                if (I != null) {
                    synchronized (f14595wX) {
                        String str = I.sourceDir;
                        if (f14595wX.contains(str)) {
                            return;
                        }
                        f14595wX.add(str);
                        if (VERSION.SDK_INT > 20) {
                            new StringBuilder("MultiDex is not guaranteed to work in SDK version ").append(VERSION.SDK_INT).append(": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"").append(System.getProperty("java.vm.version")).append("\"");
                        }
                        try {
                            ClassLoader classLoader = context.getClassLoader();
                            if (classLoader == null) {
                                return;
                            }
                            try {
                                C31843a.m51593J(context);
                            } catch (Throwable th) {
                            }
                            File file = new File(I.dataDir, f14594wW);
                            List a = C8351b.m14743a(context, I, file, false);
                            if (C31843a.m51600g(a)) {
                                C31843a.m51594a(classLoader, file, a);
                            } else {
                                List a2 = C8351b.m14743a(context, I, file, true);
                                if (C31843a.m51600g(a2)) {
                                    C31843a.m51594a(classLoader, file, a2);
                                } else {
                                    throw new RuntimeException("Zip files were not valid.");
                                }
                            }
                        } catch (RuntimeException e) {
                        }
                    }
                }
            } catch (Exception e2) {
                throw new RuntimeException("Multi dex installation failed (" + e2.getMessage() + ").");
            }
        }
    }

    /* renamed from: I */
    private static ApplicationInfo m51592I(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, 128);
        } catch (RuntimeException e) {
            return null;
        }
    }

    /* renamed from: F */
    private static boolean m51590F(String str) {
        boolean z = false;
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
        new StringBuilder("VM with version ").append(str).append(z ? " has multidex support" : " does not have multidex support");
        return z;
    }

    /* renamed from: a */
    private static void m51594a(ClassLoader classLoader, File file, List<File> list) {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                C17398b.m27020a(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                C25315a.m39918a(classLoader, list, file);
            } else {
                C31844c.m51601a(classLoader, list);
            }
        }
    }

    /* renamed from: g */
    private static boolean m51600g(List<File> list) {
        for (File f : list) {
            if (!C8351b.m14749f(f)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static Field m51596b(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* renamed from: b */
    private static Method m51597b(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* renamed from: J */
    private static void m51593J(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            new StringBuilder("Clearing old secondary dex dir (").append(file.getPath()).append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
                return;
            }
            for (File file2 : listFiles) {
                new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
                if (file2.delete()) {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                }
            }
            if (file.delete()) {
                new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
            } else {
                new StringBuilder("Failed to delete secondary dex dir ").append(file.getPath());
            }
        }
    }
}

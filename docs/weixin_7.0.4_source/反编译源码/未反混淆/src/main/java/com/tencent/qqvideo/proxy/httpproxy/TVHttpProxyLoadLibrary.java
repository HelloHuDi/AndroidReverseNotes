package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class TVHttpProxyLoadLibrary {
    public static final String ASSETS_LIBRARY_SRC_DIR = "libs/";
    private static Context mContext = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    static class LibraryBrokenHandler implements UncaughtExceptionHandler {
        private UncaughtExceptionHandler mParent;

        public LibraryBrokenHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void uncaughtException(Thread thread, Throwable th) {
            Object obj;
            Object obj2 = 1;
            AppMethodBeat.i(124391);
            if ((th instanceof UnsatisfiedLinkError) || ((th instanceof NoSuchMethodError) && th.getMessage().matches(".*sig(nature)?[=:].*"))) {
                int obj3 = 1;
            } else {
                obj3 = null;
            }
            if (obj3 != null) {
                try {
                    TVHttpProxyLoadLibrary.access$1(TVHttpProxyLoadLibrary.mContext);
                } catch (Exception e) {
                }
                if (obj2 != null) {
                    th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
                }
                this.mParent.uncaughtException(thread, th);
                AppMethodBeat.o(124391);
            }
            obj2 = null;
            if (obj2 != null) {
            }
            this.mParent.uncaughtException(thread, th);
            AppMethodBeat.o(124391);
        }
    }

    static {
        AppMethodBeat.i(124392);
        AppMethodBeat.o(124392);
    }

    private TVHttpProxyLoadLibrary() {
    }

    public static String find(String str, Context context) {
        AppMethodBeat.i(124393);
        if (context == null) {
            AppMethodBeat.o(124393);
            return null;
        }
        String str2;
        try {
            ClassLoader classLoader = TVHttpProxyLoadLibrary.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        if (str2 == null) {
            File file = new File(context.getDir("recover_lib", 0), "lib" + str + ".so");
            if (file.canRead()) {
                str2 = file.getAbsolutePath();
            }
        }
        AppMethodBeat.o(124393);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0216 A:{SYNTHETIC, Splitter:B:117:0x0216} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0137 A:{Catch:{ Exception -> 0x014e }} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0167 A:{SYNTHETIC, Splitter:B:82:0x0167} */
    /* JADX WARNING: Missing block: B:22:0x005d, code skipped:
            if (r9 != null) goto L_0x00ba;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            reflectSystemLoadlibrary(r7, r8);
            r1 = mLoadedLibs;
     */
    /* JADX WARNING: Missing block: B:25:0x0064, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            mLoadedLibs.put(r7, new java.lang.ref.WeakReference(r8));
     */
    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:32:0x0077, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:33:0x0078, code skipped:
            r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(java.lang.String.valueOf(r7))).initCause(r0.getCause());
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:34:0x0095, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:40:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:42:0x009f, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:43:0x00a0, code skipped:
            r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(java.lang.String.valueOf(r7))).initCause(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:44:0x00b9, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:45:0x00ba, code skipped:
            r3 = new java.io.File(r9.getDir("recover_lib", 0), "lib" + r7 + ".so");
     */
    /* JADX WARNING: Missing block: B:46:0x00e2, code skipped:
            if (r3.isFile() == false) goto L_0x028d;
     */
    /* JADX WARNING: Missing block: B:48:?, code skipped:
            reflectSystemLoad(r3.getAbsolutePath(), r8);
            r1 = mLoadedLibs;
     */
    /* JADX WARNING: Missing block: B:49:0x00ed, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:51:?, code skipped:
            mLoadedLibs.put(r7, new java.lang.ref.WeakReference(r8));
     */
    /* JADX WARNING: Missing block: B:52:0x00f8, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:56:0x0101, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:68:0x0120, code skipped:
            if (r1 != null) goto L_0x028a;
     */
    /* JADX WARNING: Missing block: B:91:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:93:0x0177, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:95:0x017e, code skipped:
            if ((r0.getCause() instanceof java.lang.UnsatisfiedLinkError) != false) goto L_0x0180;
     */
    /* JADX WARNING: Missing block: B:96:0x0180, code skipped:
            r0 = (java.lang.UnsatisfiedLinkError) r0.getCause();
     */
    /* JADX WARNING: Missing block: B:97:0x0188, code skipped:
            r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library: ".concat(java.lang.String.valueOf(r7))).initCause(r0.getCause());
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:98:0x01a5, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:99:0x01a6, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:100:0x01a7, code skipped:
            r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library: ".concat(java.lang.String.valueOf(r7))).initCause(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(124394);
     */
    /* JADX WARNING: Missing block: B:154:0x028d, code skipped:
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:170:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:171:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void load(String str, ClassLoader classLoader, Context context) {
        UnsatisfiedLinkError unsatisfiedLinkError;
        Throwable e;
        AppMethodBeat.i(124394);
        if (str == null || str.length() == 0 || classLoader == null) {
            AppMethodBeat.o(124394);
            return;
        }
        mContext = context;
        synchronized (mLoadedLibs) {
            try {
                ClassLoader classLoader2;
                WeakReference weakReference = (WeakReference) mLoadedLibs.get(str);
                if (weakReference != null) {
                    classLoader2 = (ClassLoader) weakReference.get();
                } else {
                    classLoader2 = null;
                }
                if (classLoader2 != null) {
                    if (classLoader2 == classLoader) {
                    } else {
                        unsatisfiedLinkError = new UnsatisfiedLinkError("Library '" + str + "' was loaded by a different ClassLoader.");
                        AppMethodBeat.o(124394);
                        throw unsatisfiedLinkError;
                    }
                }
            } finally {
                AppMethodBeat.o(124394);
            }
        }
        return;
        r3.delete();
        UnsatisfiedLinkError unsatisfiedLinkError2 = unsatisfiedLinkError;
        try {
            reflectSystemLoadlibrary(str, classLoader);
            synchronized (mLoadedLibs) {
                mLoadedLibs.put(str, new WeakReference(classLoader));
            }
            AppMethodBeat.o(124394);
        } catch (UnsatisfiedLinkError e2) {
            unsatisfiedLinkError = e2;
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof UnsatisfiedLinkError) {
                ZipFile zipFile;
                if (unsatisfiedLinkError2 == null) {
                    unsatisfiedLinkError = (UnsatisfiedLinkError) e3.getCause();
                    zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                    try {
                        if (extractLibrary(zipFile, str, generateAbiList(), r3)) {
                            RuntimeException runtimeException = new RuntimeException("Can't find recover library: ".concat(String.valueOf(str)));
                            AppMethodBeat.o(124394);
                            throw runtimeException;
                        }
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                        }
                        try {
                            reflectSystemLoad(r3.getAbsolutePath(), classLoader);
                            synchronized (mLoadedLibs) {
                                mLoadedLibs.put(str, new WeakReference(classLoader));
                            }
                            AppMethodBeat.o(124394);
                            return;
                        } catch (InvocationTargetException e5) {
                            if (unsatisfiedLinkError == null) {
                                unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: ".concat(String.valueOf(str))).initCause(e5.getCause());
                                AppMethodBeat.o(124394);
                                throw unsatisfiedLinkError;
                            }
                            AppMethodBeat.o(124394);
                            throw unsatisfiedLinkError;
                        } catch (Exception e6) {
                            if (unsatisfiedLinkError == null) {
                                unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e6);
                                AppMethodBeat.o(124394);
                                throw unsatisfiedLinkError;
                            }
                            AppMethodBeat.o(124394);
                            throw unsatisfiedLinkError;
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(124394);
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        try {
                            unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e);
                            AppMethodBeat.o(124394);
                            throw unsatisfiedLinkError;
                        } catch (Throwable th2) {
                            e = th2;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e8) {
                                }
                            }
                            AppMethodBeat.o(124394);
                            throw e;
                        }
                    }
                }
                unsatisfiedLinkError = unsatisfiedLinkError2;
                try {
                    zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                    if (extractLibrary(zipFile, str, generateAbiList(), r3)) {
                    }
                } catch (Exception e9) {
                    e = e9;
                    zipFile = null;
                    unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e);
                    AppMethodBeat.o(124394);
                    throw unsatisfiedLinkError;
                } catch (Throwable th3) {
                    e = th3;
                    zipFile = null;
                    if (zipFile != null) {
                    }
                    AppMethodBeat.o(124394);
                    throw e;
                }
            }
            unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: ".concat(String.valueOf(str))).initCause(e3.getCause());
            AppMethodBeat.o(124394);
            throw unsatisfiedLinkError;
        } catch (Throwable e10) {
            unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: ".concat(String.valueOf(str))).initCause(e10);
            AppMethodBeat.o(124394);
        }
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        AppMethodBeat.i(124395);
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
        AppMethodBeat.o(124395);
    }

    private static void reflectSystemLoadlibrary(String str, ClassLoader classLoader) {
        AppMethodBeat.i(124396);
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
        AppMethodBeat.o(124396);
    }

    private static List<String> generateAbiList() {
        AppMethodBeat.i(124397);
        ArrayList arrayList = new ArrayList(3);
        Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
        String str = (String) method.invoke(null, new Object[]{"ro.product.cpu.abi"});
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        str = (String) method.invoke(null, new Object[]{"ro.product.cpu.abi2"});
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        arrayList.add("armeabi");
        AppMethodBeat.o(124397);
        return arrayList;
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        AppMethodBeat.i(124398);
        if (file.isFile()) {
            AppMethodBeat.o(124398);
            return true;
        }
        for (String str2 : list) {
            ZipEntry entry = zipFile.getEntry("lib/" + str2 + "/lib" + str + ".so");
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            inputStream.close();
                            fileOutputStream.close();
                            file.setReadOnly();
                            AppMethodBeat.o(124398);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        inputStream.close();
                        fileOutputStream.close();
                        AppMethodBeat.o(124398);
                    }
                }
            }
        }
        AppMethodBeat.o(124398);
        return false;
    }

    static /* synthetic */ void access$1(Context context) {
        AppMethodBeat.i(124401);
        extractAllLibraries(context);
        AppMethodBeat.o(124401);
    }

    private static void extractAllLibraries(Context context) {
        AppMethodBeat.i(124399);
        if (context == null) {
            AppMethodBeat.o(124399);
            return;
        }
        List generateAbiList = generateAbiList();
        File dir = context.getDir("recover_lib", 0);
        ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
        try {
            HashSet hashSet = new HashSet();
            Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                Matcher matcher = compile.matcher(((ZipEntry) entries.nextElement()).getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (!hashSet.contains(group)) {
                        extractLibrary(zipFile, group, generateAbiList, new File(dir, "lib" + group + ".so"));
                        hashSet.add(group);
                    }
                }
            }
        } finally {
            zipFile.close();
            AppMethodBeat.o(124399);
        }
    }

    public static void setupBrokenLibraryHandler() {
        AppMethodBeat.i(124400);
        Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
        AppMethodBeat.o(124400);
    }
}

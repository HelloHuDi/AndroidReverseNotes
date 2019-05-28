package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import junit.framework.Assert;

public final class k {
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    static {
        AppMethodBeat.i(93104);
        AppMethodBeat.o(93104);
    }

    private k() {
    }

    public static boolean kx(String str) {
        boolean containsKey;
        AppMethodBeat.i(93101);
        synchronized (mLoadedLibs) {
            try {
                containsKey = mLoadedLibs.containsKey(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93101);
            }
        }
        return containsKey;
    }

    public static String ky(String str) {
        String str2;
        AppMethodBeat.i(93102);
        try {
            ClassLoader classLoader = k.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        AppMethodBeat.o(93102);
        return str2;
    }

    public static void a(String str, ClassLoader classLoader) {
        UnsatisfiedLinkError unsatisfiedLinkError;
        AppMethodBeat.i(93103);
        String str2 = "libName or callerClassLoader is null";
        boolean z = bo.isNullOrNil(str) || classLoader == null;
        Assert.assertFalse(str2, z);
        synchronized (mLoadedLibs) {
            try {
                ClassLoader classLoader2;
                ab.i("MicroMsg.LoadLibrary", "initial try load library:" + str + ", cl: " + classLoader);
                WeakReference weakReference = (WeakReference) mLoadedLibs.get(str);
                if (weakReference != null) {
                    classLoader2 = (ClassLoader) weakReference.get();
                } else {
                    classLoader2 = null;
                }
                if (classLoader2 == null) {
                    ab.i("MicroMsg.LoadLibrary", "try load library:".concat(String.valueOf(str)));
                    try {
                        System.loadLibrary(str);
                        synchronized (mLoadedLibs) {
                            mLoadedLibs.put(str, new WeakReference(classLoader));
                        }
                        AppMethodBeat.o(93103);
                    } catch (Exception e) {
                        unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: ".concat(String.valueOf(str))).initCause(e);
                        AppMethodBeat.o(93103);
                        throw unsatisfiedLinkError;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(93103);
                        }
                    }
                } else if (classLoader2 == classLoader) {
                    ab.i("MicroMsg.LoadLibrary", "already loaded library");
                } else {
                    unsatisfiedLinkError = new UnsatisfiedLinkError("Library '" + str + "' was loaded by a different ClassLoader.");
                    AppMethodBeat.o(93103);
                    throw unsatisfiedLinkError;
                }
            } finally {
                AppMethodBeat.o(93103);
            }
        }
    }
}

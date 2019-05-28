package com.tencent.p177mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.compatible.util.k */
public final class C1449k {
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    static {
        AppMethodBeat.m2504i(93104);
        AppMethodBeat.m2505o(93104);
    }

    private C1449k() {
    }

    /* renamed from: kx */
    public static boolean m3080kx(String str) {
        boolean containsKey;
        AppMethodBeat.m2504i(93101);
        synchronized (mLoadedLibs) {
            try {
                containsKey = mLoadedLibs.containsKey(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93101);
            }
        }
        return containsKey;
    }

    /* renamed from: ky */
    public static String m3081ky(String str) {
        String str2;
        AppMethodBeat.m2504i(93102);
        try {
            ClassLoader classLoader = C1449k.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        AppMethodBeat.m2505o(93102);
        return str2;
    }

    /* renamed from: a */
    public static void m3079a(String str, ClassLoader classLoader) {
        UnsatisfiedLinkError unsatisfiedLinkError;
        AppMethodBeat.m2504i(93103);
        String str2 = "libName or callerClassLoader is null";
        boolean z = C5046bo.isNullOrNil(str) || classLoader == null;
        Assert.assertFalse(str2, z);
        synchronized (mLoadedLibs) {
            try {
                ClassLoader classLoader2;
                C4990ab.m7416i("MicroMsg.LoadLibrary", "initial try load library:" + str + ", cl: " + classLoader);
                WeakReference weakReference = (WeakReference) mLoadedLibs.get(str);
                if (weakReference != null) {
                    classLoader2 = (ClassLoader) weakReference.get();
                } else {
                    classLoader2 = null;
                }
                if (classLoader2 == null) {
                    C4990ab.m7416i("MicroMsg.LoadLibrary", "try load library:".concat(String.valueOf(str)));
                    try {
                        System.loadLibrary(str);
                        synchronized (mLoadedLibs) {
                            mLoadedLibs.put(str, new WeakReference(classLoader));
                        }
                        AppMethodBeat.m2505o(93103);
                    } catch (Exception e) {
                        unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: ".concat(String.valueOf(str))).initCause(e);
                        AppMethodBeat.m2505o(93103);
                        throw unsatisfiedLinkError;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(93103);
                        }
                    }
                } else if (classLoader2 == classLoader) {
                    C4990ab.m7416i("MicroMsg.LoadLibrary", "already loaded library");
                } else {
                    unsatisfiedLinkError = new UnsatisfiedLinkError("Library '" + str + "' was loaded by a different ClassLoader.");
                    AppMethodBeat.m2505o(93103);
                    throw unsatisfiedLinkError;
                }
            } finally {
                AppMethodBeat.m2505o(93103);
            }
        }
    }
}

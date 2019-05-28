package com.google.android.gms.dynamite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.PathClassLoader;

final class zzh extends PathClassLoader {
    zzh(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    /* Access modifiers changed, original: protected|final */
    public final Class<?> loadClass(String str, boolean z) {
        Class findClass;
        AppMethodBeat.m2504i(90456);
        if (!(str.startsWith("java.") || str.startsWith("android."))) {
            try {
                findClass = findClass(str);
                AppMethodBeat.m2505o(90456);
                return findClass;
            } catch (ClassNotFoundException e) {
            }
        }
        findClass = super.loadClass(str, z);
        AppMethodBeat.m2505o(90456);
        return findClass;
    }
}

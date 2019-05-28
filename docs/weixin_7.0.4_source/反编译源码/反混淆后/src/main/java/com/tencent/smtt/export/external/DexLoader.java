package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DexLoader {
    private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;

    static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        /* Access modifiers changed, original: protected */
        public Class<?> loadClass(String str, boolean z) {
            AppMethodBeat.m2504i(63755);
            if (str == null || !str.startsWith(DexLoader.JAVACORE_PACKAGE_PREFIX)) {
                Class loadClass = super.loadClass(str, z);
                AppMethodBeat.m2505o(63755);
                return loadClass;
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass == null) {
                try {
                    findLoadedClass = findClass(str);
                } catch (ClassNotFoundException e) {
                }
                if (findLoadedClass == null) {
                    ClassLoader parent = getParent();
                    if (parent != null) {
                        findLoadedClass = parent.loadClass(str);
                    }
                }
            }
            AppMethodBeat.m2505o(63755);
            return findLoadedClass;
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
        AppMethodBeat.m2504i(63761);
        AppMethodBeat.m2505o(63761);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this(null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        AppMethodBeat.m2504i(63760);
        ClassLoader classLoader = dexLoader.getClassLoader();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                classLoader = createDexClassLoader(strArr[i2], str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
                this.mClassLoader = classLoader;
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(63760);
                return;
            }
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        AppMethodBeat.m2504i(63759);
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + File.pathSeparator + str2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                classLoader = createDexClassLoader(strArr[i2], str, str3, classLoader, context);
                this.mClassLoader = classLoader;
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(63759);
                return;
            }
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        AppMethodBeat.m2504i(63758);
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        if (callingClassLoader == null) {
            callingClassLoader = context.getClassLoader();
        }
        ClassLoader classLoader = callingClassLoader;
        for (String createDexClassLoader : strArr) {
            classLoader = createDexClassLoader(createDexClassLoader, str2, str, classLoader, context);
            this.mClassLoader = classLoader;
        }
        AppMethodBeat.m2505o(63758);
    }

    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        DexClassLoader tbsCorePrivateClassLoader;
        AppMethodBeat.m2504i(63762);
        if (shouldUseTbsCorePrivateClassLoader(str)) {
            tbsCorePrivateClassLoader = new TbsCorePrivateClassLoader(str, str2, str3, classLoader);
        } else if (VERSION.SDK_INT < 21 || VERSION.SDK_INT > 25 || !mUseSpeedyClassLoader) {
            tbsCorePrivateClassLoader = new DexClassLoader(str, str2, str3, classLoader);
        } else {
            try {
                tbsCorePrivateClassLoader = DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context);
            } catch (Throwable th) {
                new StringBuilder("createDexClassLoader exception: ").append(th);
                tbsCorePrivateClassLoader = new DexClassLoader(str, str2, str3, classLoader);
            }
        }
        AppMethodBeat.m2505o(63762);
        return tbsCorePrivateClassLoader;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.m2504i(63756);
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj).booleanValue();
                }
                obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj).booleanValue();
                }
                AppMethodBeat.m2505o(63756);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.m2505o(63756);
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        AppMethodBeat.m2504i(63757);
        if (!mUseTbsCorePrivateClassLoader) {
            AppMethodBeat.m2505o(63757);
            return false;
        } else if (str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX)) {
            AppMethodBeat.m2505o(63757);
            return true;
        } else {
            AppMethodBeat.m2505o(63757);
            return false;
        }
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        Object obj = null;
        AppMethodBeat.m2504i(63768);
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            obj = field.get(null);
            AppMethodBeat.m2505o(63768);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' get field '").append(str2).append("' failed");
            AppMethodBeat.m2505o(63768);
        }
        return obj;
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(63767);
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            Object invoke = method.invoke(obj, objArr);
            AppMethodBeat.m2505o(63767);
            return invoke;
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke method '").append(str2).append("' failed");
            AppMethodBeat.m2505o(63767);
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(63766);
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            Object invoke = method.invoke(null, objArr);
            AppMethodBeat.m2505o(63766);
            return invoke;
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                getClass().getSimpleName();
                new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
                AppMethodBeat.m2505o(63766);
                return null;
            }
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
            AppMethodBeat.m2505o(63766);
            return th;
        }
    }

    public Class<?> loadClass(String str) {
        AppMethodBeat.m2504i(63765);
        try {
            Class loadClass = this.mClassLoader.loadClass(str);
            AppMethodBeat.m2505o(63765);
            return loadClass;
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("loadClass '").append(str).append("' failed");
            AppMethodBeat.m2505o(63765);
            return null;
        }
    }

    public Object newInstance(String str) {
        AppMethodBeat.m2504i(63763);
        try {
            Object newInstance = this.mClassLoader.loadClass(str).newInstance();
            AppMethodBeat.m2505o(63763);
            return newInstance;
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("create ").append(str).append(" instance failed");
            AppMethodBeat.m2505o(63763);
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(63764);
        try {
            Object newInstance = this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
            AppMethodBeat.m2505o(63764);
            return newInstance;
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                getClass().getSimpleName();
                new StringBuilder("'newInstance ").append(str).append(" failed");
                AppMethodBeat.m2505o(63764);
                return th;
            }
            getClass().getSimpleName();
            new StringBuilder("create '").append(str).append("' instance failed");
            AppMethodBeat.m2505o(63764);
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        AppMethodBeat.m2504i(63769);
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
            AppMethodBeat.m2505o(63769);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' set field '").append(str2).append("' failed");
            AppMethodBeat.m2505o(63769);
        }
    }
}

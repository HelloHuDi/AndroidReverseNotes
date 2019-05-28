package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

@TargetApi(14)
class AndroidNClassLoader extends PathClassLoader {
    private static Object ACs = null;
    private static String ACt = null;
    private final PathClassLoader ACu;
    private String ACv;

    private AndroidNClassLoader(String str, PathClassLoader pathClassLoader, Application application) {
        super(str, pathClassLoader.getParent());
        this.ACu = pathClassLoader;
        String name = application.getClass().getName();
        if (!(name == null || name.equals("android.app.Application"))) {
            this.ACv = name;
        }
        ACt = application.getPackageCodePath();
    }

    public Class<?> findClass(String str) {
        if (this.ACv != null && this.ACv.equals(str)) {
            return this.ACu.loadClass(str);
        }
        if (str != null && str.startsWith("com.tencent.tinker.loader.") && !str.equals("com.tencent.tinker.loader.TinkerTestDexLoad")) {
            return this.ACu.loadClass(str);
        }
        if (str != null && str.startsWith("org.apache.http.")) {
            return this.ACu.loadClass(str);
        }
        try {
            return super.findClass(str);
        } catch (ClassNotFoundException e) {
            return this.ACu.loadClass(str);
        }
    }

    public String findLibrary(String str) {
        return super.findLibrary(str);
    }

    public static AndroidNClassLoader a(PathClassLoader pathClassLoader, Application application) {
        AndroidNClassLoader androidNClassLoader = new AndroidNClassLoader("", pathClassLoader, application);
        Field b = ShareReflectUtil.b(pathClassLoader, "pathList");
        Object obj = b.get(pathClassLoader);
        Constructor a = ShareReflectUtil.a(obj, ClassLoader.class, String.class, String.class, File.class);
        Object[] objArr = (Object[]) ShareReflectUtil.b(obj, "dexElements").get(obj);
        List<File> list = (List) ShareReflectUtil.b(obj, "nativeLibraryDirectories").get(obj);
        StringBuilder stringBuilder = new StringBuilder();
        Field d = ShareReflectUtil.d(objArr.getClass().getComponentType(), "dexFile");
        Object obj2 = 1;
        for (Object obj3 : objArr) {
            DexFile dexFile = (DexFile) d.get(obj3);
            if (!(dexFile == null || dexFile.getName() == null || !dexFile.getName().equals(ACt))) {
                if (obj2 != null) {
                    obj2 = null;
                } else {
                    stringBuilder.append(File.pathSeparator);
                }
                stringBuilder.append(dexFile.getName());
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        Object obj4 = 1;
        for (File file : list) {
            if (file != null) {
                if (obj4 != null) {
                    obj4 = null;
                } else {
                    stringBuilder3.append(File.pathSeparator);
                }
                stringBuilder3.append(file.getAbsolutePath());
            }
        }
        String stringBuilder4 = stringBuilder3.toString();
        b.set(androidNClassLoader, a.newInstance(new Object[]{androidNClassLoader, stringBuilder2, stringBuilder4, null}));
        ShareReflectUtil.b(obj, "definingContext").set(obj, androidNClassLoader);
        ACs = obj;
        Context context = (Context) ShareReflectUtil.b(application, "mBase").get(application);
        Object obj5 = ShareReflectUtil.b(context, "mPackageInfo").get(context);
        ShareReflectUtil.b(obj5, "mClassLoader").set(obj5, androidNClassLoader);
        if (VERSION.SDK_INT < 27) {
            Resources resources = application.getResources();
            ShareReflectUtil.b(resources, "mClassLoader").set(resources, androidNClassLoader);
            obj5 = ShareReflectUtil.b(resources, "mDrawableInflater").get(resources);
            if (obj5 != null) {
                ShareReflectUtil.b(obj5, "mClassLoader").set(obj5, androidNClassLoader);
            }
        }
        Thread.currentThread().setContextClassLoader(androidNClassLoader);
        return androidNClassLoader;
    }
}

package com.tencent.tinker.lib.p678a;

import android.os.Build.VERSION;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.p679e.C5941b;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.tinker.lib.a.a */
public class C5940a {

    /* renamed from: com.tencent.tinker.lib.a.a$a */
    static final class C5937a {
        /* renamed from: b */
        private static void m9252b(ClassLoader classLoader, File file) {
            Object obj = ShareReflectUtil.m9395b(classLoader, "pathList").get(classLoader);
            Field b = ShareReflectUtil.m9395b(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) b.get(obj);
            ArrayList arrayList = new ArrayList(fileArr.length + 1);
            arrayList.add(file);
            for (Object obj2 : fileArr) {
                if (!file.equals(obj2)) {
                    arrayList.add(obj2);
                }
            }
            b.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* renamed from: com.tencent.tinker.lib.a.a$b */
    static final class C5938b {
        /* renamed from: b */
        private static void m9254b(ClassLoader classLoader, File file) {
            List arrayList;
            Object obj = ShareReflectUtil.m9395b(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.m9395b(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                arrayList = new ArrayList(2);
            } else {
                arrayList = list;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            arrayList.add(0, file);
            list = (List) ShareReflectUtil.m9395b(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList((arrayList.size() + list.size()) + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Method b = ShareReflectUtil.m9396b(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList3 = new ArrayList();
            ShareReflectUtil.m9395b(obj, "nativeLibraryPathElements").set(obj, (Object[]) b.invoke(obj, new Object[]{arrayList2, null, arrayList3}));
        }
    }

    /* renamed from: com.tencent.tinker.lib.a.a$c */
    static final class C5939c {
        /* renamed from: b */
        static void m9256b(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field b = ShareReflectUtil.m9395b(classLoader, "libPath");
            String[] split = ((String) b.get(classLoader)).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            StringBuilder stringBuilder = new StringBuilder(path);
            for (Object obj : split) {
                if (!(obj == null || path.equals(obj))) {
                    stringBuilder.append(':').append(obj);
                }
            }
            b.set(classLoader, stringBuilder.toString());
            Field b2 = ShareReflectUtil.m9395b(classLoader, "libraryPathElements");
            List list = (List) b2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    it.remove();
                    break;
                }
            }
            list.add(0, path);
            b2.set(classLoader, list);
        }
    }

    /* renamed from: a */
    public static boolean m9258a(ApplicationLike applicationLike, String str) {
        String d = C5941b.m9260d(applicationLike);
        if (ShareTinkerInternals.isNullOrNil(d)) {
            C5952a.m9283e("Tinker.LoadLibrary", "failed to get current patch version.", new Object[0]);
            return false;
        }
        File jh = SharePatchFileUtil.m9383jh(applicationLike.getApplication());
        if (jh == null) {
            C5952a.m9283e("Tinker.LoadLibrary", "failed to get current patch directory.", new Object[0]);
            return false;
        }
        File file = new File(new File(jh.getAbsolutePath() + "/" + SharePatchFileUtil.auq(d)).getAbsolutePath() + "/lib/lib/" + str);
        if (file.exists()) {
            ClassLoader classLoader = applicationLike.getApplication().getClassLoader();
            if (classLoader == null) {
                C5952a.m9283e("Tinker.LoadLibrary", "classloader is null", new Object[0]);
                return false;
            }
            C5952a.m9284i("Tinker.LoadLibrary", "before hack classloader:" + classLoader.toString(), new Object[0]);
            try {
                Method declaredMethod = C5940a.class.getDeclaredMethod("a", new Class[]{ClassLoader.class, File.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[]{classLoader, file});
                C5952a.m9284i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
                return true;
            } catch (Throwable th) {
                C5952a.m9284i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
            }
        } else {
            C5952a.m9283e("Tinker.LoadLibrary", "tinker lib path [%s] is not exists.", file);
            return false;
        }
    }

    /* renamed from: a */
    private static void m9257a(ClassLoader classLoader, File file) {
        if (file == null || !file.exists()) {
            C5952a.m9283e("Tinker.LoadLibrary", "installNativeLibraryPath, folder %s is illegal", file);
        } else if ((VERSION.SDK_INT == 25 && VERSION.PREVIEW_SDK_INT != 0) || VERSION.SDK_INT > 25) {
            try {
                List arrayList;
                Object obj = ShareReflectUtil.m9395b(classLoader, "pathList").get(classLoader);
                List list = (List) ShareReflectUtil.m9395b(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    arrayList = new ArrayList(2);
                } else {
                    arrayList = list;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (file.equals((File) it.next())) {
                        it.remove();
                        break;
                    }
                }
                arrayList.add(0, file);
                list = (List) ShareReflectUtil.m9395b(obj, "systemNativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList((arrayList.size() + list.size()) + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list);
                ShareReflectUtil.m9395b(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.m9396b(obj, "makePathElements", List.class).invoke(obj, new Object[]{arrayList2}));
            } catch (Throwable th) {
                C5952a.m9283e("Tinker.LoadLibrary", "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(VERSION.SDK_INT), th.getMessage());
                C5938b.m9254b(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 23) {
            try {
                C5938b.m9254b(classLoader, file);
            } catch (Throwable th2) {
                C5952a.m9283e("Tinker.LoadLibrary", "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(VERSION.SDK_INT), th2.getMessage());
                C5937a.m9252b(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 14) {
            C5937a.m9252b(classLoader, file);
        } else {
            C5939c.m9256b(classLoader, file);
        }
    }
}

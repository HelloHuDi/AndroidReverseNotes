package com.tencent.tinker.lib.a;

import android.os.Build.VERSION;
import com.tencent.tinker.entry.ApplicationLike;
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

public class a {

    static final class a {
        private static void b(ClassLoader classLoader, File file) {
            Object obj = ShareReflectUtil.b(classLoader, "pathList").get(classLoader);
            Field b = ShareReflectUtil.b(obj, "nativeLibraryDirectories");
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

    static final class b {
        private static void b(ClassLoader classLoader, File file) {
            List arrayList;
            Object obj = ShareReflectUtil.b(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.b(obj, "nativeLibraryDirectories").get(obj);
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
            list = (List) ShareReflectUtil.b(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList((arrayList.size() + list.size()) + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Method b = ShareReflectUtil.b(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList3 = new ArrayList();
            ShareReflectUtil.b(obj, "nativeLibraryPathElements").set(obj, (Object[]) b.invoke(obj, new Object[]{arrayList2, null, arrayList3}));
        }
    }

    static final class c {
        static void b(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field b = ShareReflectUtil.b(classLoader, "libPath");
            String[] split = ((String) b.get(classLoader)).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            StringBuilder stringBuilder = new StringBuilder(path);
            for (Object obj : split) {
                if (!(obj == null || path.equals(obj))) {
                    stringBuilder.append(':').append(obj);
                }
            }
            b.set(classLoader, stringBuilder.toString());
            Field b2 = ShareReflectUtil.b(classLoader, "libraryPathElements");
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

    public static boolean a(ApplicationLike applicationLike, String str) {
        String d = com.tencent.tinker.lib.e.b.d(applicationLike);
        if (ShareTinkerInternals.isNullOrNil(d)) {
            com.tencent.tinker.lib.util.a.e("Tinker.LoadLibrary", "failed to get current patch version.", new Object[0]);
            return false;
        }
        File jh = SharePatchFileUtil.jh(applicationLike.getApplication());
        if (jh == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.LoadLibrary", "failed to get current patch directory.", new Object[0]);
            return false;
        }
        File file = new File(new File(jh.getAbsolutePath() + "/" + SharePatchFileUtil.auq(d)).getAbsolutePath() + "/lib/lib/" + str);
        if (file.exists()) {
            ClassLoader classLoader = applicationLike.getApplication().getClassLoader();
            if (classLoader == null) {
                com.tencent.tinker.lib.util.a.e("Tinker.LoadLibrary", "classloader is null", new Object[0]);
                return false;
            }
            com.tencent.tinker.lib.util.a.i("Tinker.LoadLibrary", "before hack classloader:" + classLoader.toString(), new Object[0]);
            try {
                Method declaredMethod = a.class.getDeclaredMethod("a", new Class[]{ClassLoader.class, File.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[]{classLoader, file});
                com.tencent.tinker.lib.util.a.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
                return true;
            } catch (Throwable th) {
                com.tencent.tinker.lib.util.a.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
            }
        } else {
            com.tencent.tinker.lib.util.a.e("Tinker.LoadLibrary", "tinker lib path [%s] is not exists.", file);
            return false;
        }
    }

    private static void a(ClassLoader classLoader, File file) {
        if (file == null || !file.exists()) {
            com.tencent.tinker.lib.util.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, folder %s is illegal", file);
        } else if ((VERSION.SDK_INT == 25 && VERSION.PREVIEW_SDK_INT != 0) || VERSION.SDK_INT > 25) {
            try {
                List arrayList;
                Object obj = ShareReflectUtil.b(classLoader, "pathList").get(classLoader);
                List list = (List) ShareReflectUtil.b(obj, "nativeLibraryDirectories").get(obj);
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
                list = (List) ShareReflectUtil.b(obj, "systemNativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList((arrayList.size() + list.size()) + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list);
                ShareReflectUtil.b(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.b(obj, "makePathElements", List.class).invoke(obj, new Object[]{arrayList2}));
            } catch (Throwable th) {
                com.tencent.tinker.lib.util.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(VERSION.SDK_INT), th.getMessage());
                b.b(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 23) {
            try {
                b.b(classLoader, file);
            } catch (Throwable th2) {
                com.tencent.tinker.lib.util.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(VERSION.SDK_INT), th2.getMessage());
                a.b(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 14) {
            a.b(classLoader, file);
        } else {
            c.b(classLoader, file);
        }
    }
}

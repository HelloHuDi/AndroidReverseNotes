package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b {

    public interface a {
        void iH(boolean z);
    }

    static class b implements InvocationHandler {
        WeakReference<a> ysj;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            AppMethodBeat.i(106243);
            if (this.ysj == null) {
                ab.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
                AppMethodBeat.o(106243);
            } else {
                a aVar = (a) this.ysj.get();
                if (aVar == null) {
                    ab.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                    AppMethodBeat.o(106243);
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    aVar.iH(z);
                    AppMethodBeat.o(106243);
                }
            }
            return null;
        }
    }

    public static String d(ComponentName componentName) {
        AppMethodBeat.i(106244);
        String className;
        if (componentName.getClassName().startsWith(componentName.getPackageName())) {
            className = componentName.getClassName();
            AppMethodBeat.o(106244);
            return className;
        }
        className = componentName.getPackageName() + componentName.getClassName();
        AppMethodBeat.o(106244);
        return className;
    }

    public static int aqL(String str) {
        AppMethodBeat.i(106245);
        Class aqM = aqM(str);
        if (aqM != null) {
            int aB = aB(aqM);
            AppMethodBeat.o(106245);
            return aB;
        }
        AppMethodBeat.o(106245);
        return 0;
    }

    public static int aB(Class<?> cls) {
        AppMethodBeat.i(106246);
        a aVar = (a) cls.getAnnotation(a.class);
        int value;
        if (aVar != null) {
            value = aVar.value();
            AppMethodBeat.o(106246);
            return value;
        }
        value = aC(cls);
        AppMethodBeat.o(106246);
        return value;
    }

    private static int aC(Class<?> cls) {
        AppMethodBeat.i(106247);
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            int aB = aB(superclass);
            AppMethodBeat.o(106247);
            return aB;
        }
        AppMethodBeat.o(106247);
        return 0;
    }

    private static Class<?> aqM(String str) {
        AppMethodBeat.i(106248);
        try {
            Class cls = Class.forName(str);
            AppMethodBeat.o(106248);
            return cls;
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.ActivityUtil", e, "", new Object[0]);
            ab.e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            AppMethodBeat.o(106248);
            return null;
        }
    }

    public static boolean aD(Class<?> cls) {
        AppMethodBeat.i(106249);
        if ((aB(cls) & 1) == 0) {
            AppMethodBeat.o(106249);
            return true;
        }
        AppMethodBeat.o(106249);
        return false;
    }

    public static boolean aE(Class<?> cls) {
        AppMethodBeat.i(106250);
        if ((aB(cls) & 2) == 0) {
            AppMethodBeat.o(106250);
            return true;
        }
        AppMethodBeat.o(106250);
        return false;
    }

    public static boolean aqN(String str) {
        AppMethodBeat.i(106251);
        if ((aqL(str) & 4) != 0) {
            AppMethodBeat.o(106251);
            return true;
        }
        AppMethodBeat.o(106251);
        return false;
    }

    public static void au(Activity activity) {
        AppMethodBeat.i(106252);
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            AppMethodBeat.o(106252);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
            AppMethodBeat.o(106252);
        }
    }

    @TargetApi(16)
    public static void a(Activity activity, a aVar) {
        AppMethodBeat.i(106253);
        if (d.fP(16)) {
            ab.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.o(106253);
            return;
        }
        try {
            Object newProxyInstance;
            Class[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            Class cls = null;
            while (i < length) {
                Class cls2 = declaredClasses[i];
                if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls2 = cls;
                }
                i++;
                cls = cls2;
            }
            if (aVar != null) {
                b bVar = new b();
                bVar.ysj = new WeakReference(aVar);
                newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
            } else {
                newProxyInstance = null;
            }
            Method declaredMethod;
            if (d.fP(21)) {
                declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[]{newProxyInstance});
                AppMethodBeat.o(106253);
                return;
            }
            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[]{newProxyInstance, null});
            AppMethodBeat.o(106253);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
            AppMethodBeat.o(106253);
        }
    }

    public static void hK(Context context) {
        AppMethodBeat.i(106254);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(106254);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.c4, R.anim.s);
        AppMethodBeat.o(106254);
    }

    public static void hL(Context context) {
        AppMethodBeat.i(106255);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(106255);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.c4, R.anim.c9);
        AppMethodBeat.o(106255);
    }

    public static void K(Context context, Intent intent) {
        AppMethodBeat.i(106256);
        if (intent == null || context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(106256);
            return;
        }
        if (intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(R.anim.c4, R.anim.s);
        }
        AppMethodBeat.o(106256);
    }

    public static void hM(Context context) {
        AppMethodBeat.i(106257);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(106257);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.s, R.anim.c9);
        AppMethodBeat.o(106257);
    }

    public static void hN(Context context) {
        AppMethodBeat.i(106258);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(106258);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(106258);
    }
}

package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.tencent.mm.ui.base.b */
public final class C5274b {

    /* renamed from: com.tencent.mm.ui.base.b$a */
    public interface C5272a {
        /* renamed from: iH */
        void mo10877iH(boolean z);
    }

    /* renamed from: com.tencent.mm.ui.base.b$b */
    static class C5273b implements InvocationHandler {
        WeakReference<C5272a> ysj;

        private C5273b() {
        }

        /* synthetic */ C5273b(byte b) {
            this();
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            AppMethodBeat.m2504i(106243);
            if (this.ysj == null) {
                C4990ab.m7416i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
                AppMethodBeat.m2505o(106243);
            } else {
                C5272a c5272a = (C5272a) this.ysj.get();
                if (c5272a == null) {
                    C4990ab.m7416i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                    AppMethodBeat.m2505o(106243);
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    c5272a.mo10877iH(z);
                    AppMethodBeat.m2505o(106243);
                }
            }
            return null;
        }
    }

    /* renamed from: d */
    public static String m8051d(ComponentName componentName) {
        AppMethodBeat.m2504i(106244);
        String className;
        if (componentName.getClassName().startsWith(componentName.getPackageName())) {
            className = componentName.getClassName();
            AppMethodBeat.m2505o(106244);
            return className;
        }
        className = componentName.getPackageName() + componentName.getClassName();
        AppMethodBeat.m2505o(106244);
        return className;
    }

    public static int aqL(String str) {
        AppMethodBeat.m2504i(106245);
        Class aqM = C5274b.aqM(str);
        if (aqM != null) {
            int aB = C5274b.m8046aB(aqM);
            AppMethodBeat.m2505o(106245);
            return aB;
        }
        AppMethodBeat.m2505o(106245);
        return 0;
    }

    /* renamed from: aB */
    public static int m8046aB(Class<?> cls) {
        AppMethodBeat.m2504i(106246);
        C5271a c5271a = (C5271a) cls.getAnnotation(C5271a.class);
        int value;
        if (c5271a != null) {
            value = c5271a.value();
            AppMethodBeat.m2505o(106246);
            return value;
        }
        value = C5274b.m8047aC(cls);
        AppMethodBeat.m2505o(106246);
        return value;
    }

    /* renamed from: aC */
    private static int m8047aC(Class<?> cls) {
        AppMethodBeat.m2504i(106247);
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            int aB = C5274b.m8046aB(superclass);
            AppMethodBeat.m2505o(106247);
            return aB;
        }
        AppMethodBeat.m2505o(106247);
        return 0;
    }

    private static Class<?> aqM(String str) {
        AppMethodBeat.m2504i(106248);
        try {
            Class cls = Class.forName(str);
            AppMethodBeat.m2505o(106248);
            return cls;
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.ActivityUtil", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            AppMethodBeat.m2505o(106248);
            return null;
        }
    }

    /* renamed from: aD */
    public static boolean m8048aD(Class<?> cls) {
        AppMethodBeat.m2504i(106249);
        if ((C5274b.m8046aB(cls) & 1) == 0) {
            AppMethodBeat.m2505o(106249);
            return true;
        }
        AppMethodBeat.m2505o(106249);
        return false;
    }

    /* renamed from: aE */
    public static boolean m8049aE(Class<?> cls) {
        AppMethodBeat.m2504i(106250);
        if ((C5274b.m8046aB(cls) & 2) == 0) {
            AppMethodBeat.m2505o(106250);
            return true;
        }
        AppMethodBeat.m2505o(106250);
        return false;
    }

    public static boolean aqN(String str) {
        AppMethodBeat.m2504i(106251);
        if ((C5274b.aqL(str) & 4) != 0) {
            AppMethodBeat.m2505o(106251);
            return true;
        }
        AppMethodBeat.m2505o(106251);
        return false;
    }

    /* renamed from: au */
    public static void m8050au(Activity activity) {
        AppMethodBeat.m2504i(106252);
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            AppMethodBeat.m2505o(106252);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
            AppMethodBeat.m2505o(106252);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public static void m8045a(Activity activity, C5272a c5272a) {
        AppMethodBeat.m2504i(106253);
        if (C1443d.m3067fP(16)) {
            C4990ab.m7421w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.m2505o(106253);
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
            if (c5272a != null) {
                C5273b c5273b = new C5273b();
                c5273b.ysj = new WeakReference(c5272a);
                newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, c5273b);
            } else {
                newProxyInstance = null;
            }
            Method declaredMethod;
            if (C1443d.m3067fP(21)) {
                declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[]{newProxyInstance});
                AppMethodBeat.m2505o(106253);
                return;
            }
            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[]{newProxyInstance, null});
            AppMethodBeat.m2505o(106253);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
            AppMethodBeat.m2505o(106253);
        }
    }

    /* renamed from: hK */
    public static void m8052hK(Context context) {
        AppMethodBeat.m2504i(106254);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.m2505o(106254);
            return;
        }
        ((Activity) context).overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8293s);
        AppMethodBeat.m2505o(106254);
    }

    /* renamed from: hL */
    public static void m8053hL(Context context) {
        AppMethodBeat.m2504i(106255);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.m2505o(106255);
            return;
        }
        ((Activity) context).overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8367c9);
        AppMethodBeat.m2505o(106255);
    }

    /* renamed from: K */
    public static void m8044K(Context context, Intent intent) {
        AppMethodBeat.m2504i(106256);
        if (intent == null || context == null || !(context instanceof Activity)) {
            AppMethodBeat.m2505o(106256);
            return;
        }
        if (intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8293s);
        }
        AppMethodBeat.m2505o(106256);
    }

    /* renamed from: hM */
    public static void m8054hM(Context context) {
        AppMethodBeat.m2504i(106257);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.m2505o(106257);
            return;
        }
        ((Activity) context).overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8367c9);
        AppMethodBeat.m2505o(106257);
    }

    /* renamed from: hN */
    public static void m8055hN(Context context) {
        AppMethodBeat.m2504i(106258);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.m2505o(106258);
            return;
        }
        ((Activity) context).overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
        AppMethodBeat.m2505o(106258);
    }
}

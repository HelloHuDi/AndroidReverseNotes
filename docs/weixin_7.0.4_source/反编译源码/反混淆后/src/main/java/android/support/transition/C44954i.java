package android.support.transition;

import android.graphics.Matrix;
import android.support.transition.C37109j.C17420a;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.i */
final class C44954i implements C37109j {
    /* renamed from: yN */
    static Class<?> f17666yN;
    /* renamed from: yO */
    private static boolean f17667yO;
    /* renamed from: yP */
    static Method f17668yP;
    /* renamed from: yQ */
    static boolean f17669yQ;
    /* renamed from: yR */
    static Method f17670yR;
    /* renamed from: yS */
    static boolean f17671yS;
    /* renamed from: yT */
    private final View f17672yT;

    /* renamed from: android.support.transition.i$a */
    static class C44953a implements C17420a {
        C44953a() {
        }

        /* renamed from: a */
        public final C37109j mo31654a(View view, ViewGroup viewGroup, Matrix matrix) {
            if (!C44954i.f17669yQ) {
                try {
                    C44954i.m82243cU();
                    Method declaredMethod = C44954i.f17666yN.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                    C44954i.f17668yP = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                C44954i.f17669yQ = true;
            }
            if (C44954i.f17668yP != null) {
                try {
                    return new C44954i((View) C44954i.f17668yP.invoke(null, new Object[]{view, viewGroup, matrix}), (byte) 0);
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3.getCause());
                }
            }
            return null;
        }

        /* renamed from: A */
        public final void mo31653A(View view) {
            if (!C44954i.f17671yS) {
                try {
                    C44954i.m82243cU();
                    Method declaredMethod = C44954i.f17666yN.getDeclaredMethod("removeGhost", new Class[]{View.class});
                    C44954i.f17670yR = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                C44954i.f17671yS = true;
            }
            if (C44954i.f17670yR != null) {
                try {
                    C44954i.f17670yR.invoke(null, new Object[]{view});
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3.getCause());
                }
            }
        }
    }

    /* synthetic */ C44954i(View view, byte b) {
        this(view);
    }

    private C44954i(View view) {
        this.f17672yT = view;
    }

    public final void setVisibility(int i) {
        this.f17672yT.setVisibility(i);
    }

    /* renamed from: a */
    public final void mo31647a(ViewGroup viewGroup, View view) {
    }

    /* renamed from: cU */
    static void m82243cU() {
        if (!f17667yO) {
            try {
                f17666yN = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e) {
            }
            f17667yO = true;
        }
    }
}

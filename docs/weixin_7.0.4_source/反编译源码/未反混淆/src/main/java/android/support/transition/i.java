package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class i implements j {
    static Class<?> yN;
    private static boolean yO;
    static Method yP;
    static boolean yQ;
    static Method yR;
    static boolean yS;
    private final View yT;

    static class a implements android.support.transition.j.a {
        a() {
        }

        public final j a(View view, ViewGroup viewGroup, Matrix matrix) {
            if (!i.yQ) {
                try {
                    i.cU();
                    Method declaredMethod = i.yN.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                    i.yP = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                i.yQ = true;
            }
            if (i.yP != null) {
                try {
                    return new i((View) i.yP.invoke(null, new Object[]{view, viewGroup, matrix}), (byte) 0);
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3.getCause());
                }
            }
            return null;
        }

        public final void A(View view) {
            if (!i.yS) {
                try {
                    i.cU();
                    Method declaredMethod = i.yN.getDeclaredMethod("removeGhost", new Class[]{View.class});
                    i.yR = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                i.yS = true;
            }
            if (i.yR != null) {
                try {
                    i.yR.invoke(null, new Object[]{view});
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3.getCause());
                }
            }
        }
    }

    /* synthetic */ i(View view, byte b) {
        this(view);
    }

    private i(View view) {
        this.yT = view;
    }

    public final void setVisibility(int i) {
        this.yT.setVisibility(i);
    }

    public final void a(ViewGroup viewGroup, View view) {
    }

    static void cU() {
        if (!yO) {
            try {
                yN = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e) {
            }
            yO = true;
        }
    }
}

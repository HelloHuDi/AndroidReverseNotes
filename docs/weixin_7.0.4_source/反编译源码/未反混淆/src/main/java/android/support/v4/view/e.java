package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class e {
    private static Field Mi;
    private static boolean Mj;
    static final b Mk;

    static class b {
        b() {
        }

        public void b(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                e.a(layoutInflater, (Factory2) factory);
            } else {
                e.a(layoutInflater, factory2);
            }
        }
    }

    static class a extends b {
        a() {
        }

        public final void b(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static void a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!Mj) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                Mi = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.");
            }
            Mj = true;
        }
        if (Mi != null) {
            try {
                Mi.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(layoutInflater).append("; inflation may have unexpected results.");
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            Mk = new a();
        } else {
            Mk = new b();
        }
    }

    public static void b(LayoutInflater layoutInflater, Factory2 factory2) {
        Mk.b(layoutInflater, factory2);
    }
}

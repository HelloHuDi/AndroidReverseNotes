package android.support.p057v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.view.e */
public final class C0458e {
    /* renamed from: Mi */
    private static Field f555Mi;
    /* renamed from: Mj */
    private static boolean f556Mj;
    /* renamed from: Mk */
    static final C0457b f557Mk;

    /* renamed from: android.support.v4.view.e$b */
    static class C0457b {
        C0457b() {
        }

        /* renamed from: b */
        public void mo1053b(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                C0458e.m788a(layoutInflater, (Factory2) factory);
            } else {
                C0458e.m788a(layoutInflater, factory2);
            }
        }
    }

    /* renamed from: android.support.v4.view.e$a */
    static class C0459a extends C0457b {
        C0459a() {
        }

        /* renamed from: b */
        public final void mo1053b(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    /* renamed from: a */
    static void m788a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f556Mj) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f555Mi = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.");
            }
            f556Mj = true;
        }
        if (f555Mi != null) {
            try {
                f555Mi.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(layoutInflater).append("; inflation may have unexpected results.");
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f557Mk = new C0459a();
        } else {
            f557Mk = new C0457b();
        }
    }

    /* renamed from: b */
    public static void m789b(LayoutInflater layoutInflater, Factory2 factory2) {
        f557Mk.mo1053b(layoutInflater, factory2);
    }
}

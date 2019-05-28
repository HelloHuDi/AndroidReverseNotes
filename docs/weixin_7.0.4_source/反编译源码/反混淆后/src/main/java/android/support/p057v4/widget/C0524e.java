package android.support.p057v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.e */
public final class C0524e {
    /* renamed from: Py */
    private static final C0523c f702Py;

    /* renamed from: android.support.v4.widget.e$c */
    static class C0523c {
        /* renamed from: PA */
        private static boolean f700PA;
        /* renamed from: Pz */
        private static Field f701Pz;

        C0523c() {
        }

        /* renamed from: a */
        public void mo1286a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof C0548r) {
                ((C0548r) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        /* renamed from: a */
        public void mo1287a(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof C0548r) {
                ((C0548r) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        /* renamed from: a */
        public Drawable mo1285a(CompoundButton compoundButton) {
            if (!f700PA) {
                try {
                    Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f701Pz = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f700PA = true;
            }
            if (f701Pz != null) {
                try {
                    return (Drawable) f701Pz.get(compoundButton);
                } catch (IllegalAccessException e2) {
                    f701Pz = null;
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.e$a */
    static class C0525a extends C0523c {
        C0525a() {
        }

        /* renamed from: a */
        public final void mo1286a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        /* renamed from: a */
        public final void mo1287a(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* renamed from: android.support.v4.widget.e$b */
    static class C0526b extends C0525a {
        C0526b() {
        }

        /* renamed from: a */
        public final Drawable mo1285a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f702Py = new C0526b();
        } else if (VERSION.SDK_INT >= 21) {
            f702Py = new C0525a();
        } else {
            f702Py = new C0523c();
        }
    }

    /* renamed from: a */
    public static void m1127a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f702Py.mo1286a(compoundButton, colorStateList);
    }

    /* renamed from: a */
    public static void m1128a(CompoundButton compoundButton, Mode mode) {
        f702Py.mo1287a(compoundButton, mode);
    }

    /* renamed from: a */
    public static Drawable m1126a(CompoundButton compoundButton) {
        return f702Py.mo1285a(compoundButton);
    }
}

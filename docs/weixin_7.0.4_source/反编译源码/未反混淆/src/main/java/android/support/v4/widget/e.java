package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class e {
    private static final c Py;

    static class c {
        private static boolean PA;
        private static Field Pz;

        c() {
        }

        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof r) {
                ((r) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        public void a(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof r) {
                ((r) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        public Drawable a(CompoundButton compoundButton) {
            if (!PA) {
                try {
                    Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    Pz = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                PA = true;
            }
            if (Pz != null) {
                try {
                    return (Drawable) Pz.get(compoundButton);
                } catch (IllegalAccessException e2) {
                    Pz = null;
                }
            }
            return null;
        }
    }

    static class a extends c {
        a() {
        }

        public final void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public final void a(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class b extends a {
        b() {
        }

        public final Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            Py = new b();
        } else if (VERSION.SDK_INT >= 21) {
            Py = new a();
        } else {
            Py = new c();
        }
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        Py.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, Mode mode) {
        Py.a(compoundButton, mode);
    }

    public static Drawable a(CompoundButton compoundButton) {
        return Py.a(compoundButton);
    }
}

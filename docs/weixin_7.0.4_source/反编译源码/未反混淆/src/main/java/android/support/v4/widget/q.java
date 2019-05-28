package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;
import java.lang.reflect.Field;

public final class q {
    static final g SB;

    static class g {
        private static Field SC;
        private static boolean SD;
        private static Field SE;
        private static boolean SF;

        g() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        private static Field O(String str) {
            Field field = null;
            try {
                field = TextView.class.getDeclaredField(str);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {
                new StringBuilder("Could not retrieve ").append(str).append(" field.");
                return field;
            }
        }

        private static int a(Field field, TextView textView) {
            try {
                return field.getInt(textView);
            } catch (IllegalAccessException e) {
                new StringBuilder("Could not retrieve value of ").append(field.getName()).append(" field.");
                return -1;
            }
        }

        public int b(TextView textView) {
            if (!SF) {
                SE = O("mMaxMode");
                SF = true;
            }
            if (SE != null && a(SE, textView) == 1) {
                if (!SD) {
                    SC = O("mMaximum");
                    SD = true;
                }
                if (SC != null) {
                    return a(SC, textView);
                }
            }
            return -1;
        }

        public void b(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        public Drawable[] c(TextView textView) {
            return textView.getCompoundDrawables();
        }

        public void d(TextView textView) {
            if (textView instanceof b) {
                ((b) textView).setAutoSizeTextTypeWithDefaults(1);
            }
        }
    }

    static class a extends g {
        a() {
        }

        public final int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    static class b extends a {
        b() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            Drawable drawable5;
            Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
            if (obj != null) {
                drawable5 = drawable3;
            } else {
                drawable5 = drawable;
            }
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }

        public Drawable[] c(TextView textView) {
            int i = 1;
            if (textView.getLayoutDirection() != 1) {
                i = 0;
            }
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (i != 0) {
                Drawable drawable = compoundDrawables[2];
                Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }
    }

    static class f extends e {
        f() {
        }

        public final void d(TextView textView) {
            textView.setAutoSizeTextTypeWithDefaults(1);
        }
    }

    static class c extends b {
        c() {
        }

        public final void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        public final Drawable[] c(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
    }

    static class e extends d {
        e() {
        }
    }

    static class d extends c {
        d() {
        }

        public final void b(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    static {
        if (android.support.v4.os.a.isAtLeastOMR1()) {
            SB = new f();
        } else if (VERSION.SDK_INT >= 26) {
            SB = new e();
        } else if (VERSION.SDK_INT >= 23) {
            SB = new d();
        } else if (VERSION.SDK_INT >= 18) {
            SB = new c();
        } else if (VERSION.SDK_INT >= 17) {
            SB = new b();
        } else if (VERSION.SDK_INT >= 16) {
            SB = new a();
        } else {
            SB = new g();
        }
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        SB.a(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static int b(TextView textView) {
        return SB.b(textView);
    }

    public static void b(TextView textView, int i) {
        SB.b(textView, i);
    }

    public static Drawable[] c(TextView textView) {
        return SB.c(textView);
    }

    public static void d(TextView textView) {
        SB.d(textView);
    }
}

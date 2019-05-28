package android.support.p057v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.p066os.C0429a;
import android.widget.TextView;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.q */
public final class C0540q {
    /* renamed from: SB */
    static final C0541g f711SB;

    /* renamed from: android.support.v4.widget.q$g */
    static class C0541g {
        /* renamed from: SC */
        private static Field f712SC;
        /* renamed from: SD */
        private static boolean f713SD;
        /* renamed from: SE */
        private static Field f714SE;
        /* renamed from: SF */
        private static boolean f715SF;

        C0541g() {
        }

        /* renamed from: a */
        public void mo1302a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: O */
        private static Field m1170O(String str) {
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

        /* renamed from: a */
        private static int m1171a(Field field, TextView textView) {
            try {
                return field.getInt(textView);
            } catch (IllegalAccessException e) {
                new StringBuilder("Could not retrieve value of ").append(field.getName()).append(" field.");
                return -1;
            }
        }

        /* renamed from: b */
        public int mo1303b(TextView textView) {
            if (!f715SF) {
                f714SE = C0541g.m1170O("mMaxMode");
                f715SF = true;
            }
            if (f714SE != null && C0541g.m1171a(f714SE, textView) == 1) {
                if (!f713SD) {
                    f712SC = C0541g.m1170O("mMaximum");
                    f713SD = true;
                }
                if (f712SC != null) {
                    return C0541g.m1171a(f712SC, textView);
                }
            }
            return -1;
        }

        /* renamed from: b */
        public void mo1304b(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        /* renamed from: c */
        public Drawable[] mo1305c(TextView textView) {
            return textView.getCompoundDrawables();
        }

        /* renamed from: d */
        public void mo1306d(TextView textView) {
            if (textView instanceof C0522b) {
                ((C0522b) textView).setAutoSizeTextTypeWithDefaults(1);
            }
        }
    }

    /* renamed from: android.support.v4.widget.q$a */
    static class C0542a extends C0541g {
        C0542a() {
        }

        /* renamed from: b */
        public final int mo1303b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    /* renamed from: android.support.v4.widget.q$b */
    static class C0543b extends C0542a {
        C0543b() {
        }

        /* renamed from: a */
        public void mo1302a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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

        /* renamed from: c */
        public Drawable[] mo1305c(TextView textView) {
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

    /* renamed from: android.support.v4.widget.q$f */
    static class C0544f extends C0546e {
        C0544f() {
        }

        /* renamed from: d */
        public final void mo1306d(TextView textView) {
            textView.setAutoSizeTextTypeWithDefaults(1);
        }
    }

    /* renamed from: android.support.v4.widget.q$c */
    static class C0545c extends C0543b {
        C0545c() {
        }

        /* renamed from: a */
        public final void mo1302a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: c */
        public final Drawable[] mo1305c(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
    }

    /* renamed from: android.support.v4.widget.q$e */
    static class C0546e extends C0547d {
        C0546e() {
        }
    }

    /* renamed from: android.support.v4.widget.q$d */
    static class C0547d extends C0545c {
        C0547d() {
        }

        /* renamed from: b */
        public final void mo1304b(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    static {
        if (C0429a.isAtLeastOMR1()) {
            f711SB = new C0544f();
        } else if (VERSION.SDK_INT >= 26) {
            f711SB = new C0546e();
        } else if (VERSION.SDK_INT >= 23) {
            f711SB = new C0547d();
        } else if (VERSION.SDK_INT >= 18) {
            f711SB = new C0545c();
        } else if (VERSION.SDK_INT >= 17) {
            f711SB = new C0543b();
        } else if (VERSION.SDK_INT >= 16) {
            f711SB = new C0542a();
        } else {
            f711SB = new C0541g();
        }
    }

    /* renamed from: a */
    public static void m1165a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f711SB.mo1302a(textView, drawable, drawable2, drawable3, drawable4);
    }

    /* renamed from: b */
    public static int m1166b(TextView textView) {
        return f711SB.mo1303b(textView);
    }

    /* renamed from: b */
    public static void m1167b(TextView textView, int i) {
        f711SB.mo1304b(textView, i);
    }

    /* renamed from: c */
    public static Drawable[] m1168c(TextView textView) {
        return f711SB.mo1305c(textView);
    }

    /* renamed from: d */
    public static void m1169d(TextView textView) {
        f711SB.mo1306d(textView);
    }
}

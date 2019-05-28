package android.support.p057v4.widget;

import android.os.Build.VERSION;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0477s;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.n */
public final class C0535n {
    /* renamed from: Rp */
    static final C0534d f708Rp;

    /* renamed from: android.support.v4.widget.n$d */
    static class C0534d {
        /* renamed from: Rr */
        private static Method f706Rr;
        /* renamed from: Rs */
        private static boolean f707Rs;

        C0534d() {
        }

        /* renamed from: a */
        public void mo1299a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0456d.getAbsoluteGravity(i3, C0477s.m893T(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        /* renamed from: a */
        public void mo1300a(PopupWindow popupWindow, boolean z) {
        }

        /* renamed from: a */
        public void mo1298a(PopupWindow popupWindow, int i) {
            if (!f707Rs) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    f706Rr = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e) {
                }
                f707Rs = true;
            }
            if (f706Rr != null) {
                try {
                    f706Rr.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }
    }

    /* renamed from: android.support.v4.widget.n$a */
    static class C0536a extends C0534d {
        C0536a() {
        }

        /* renamed from: a */
        public final void mo1299a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    /* renamed from: android.support.v4.widget.n$b */
    static class C0537b extends C0536a {
        /* renamed from: Rq */
        private static Field f709Rq;

        C0537b() {
        }

        static {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f709Rq = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
        }

        /* renamed from: a */
        public void mo1300a(PopupWindow popupWindow, boolean z) {
            if (f709Rq != null) {
                try {
                    f709Rq.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                }
            }
        }
    }

    /* renamed from: android.support.v4.widget.n$c */
    static class C0538c extends C0537b {
        C0538c() {
        }

        /* renamed from: a */
        public final void mo1300a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        /* renamed from: a */
        public final void mo1298a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f708Rp = new C0538c();
        } else if (VERSION.SDK_INT >= 21) {
            f708Rp = new C0537b();
        } else if (VERSION.SDK_INT >= 19) {
            f708Rp = new C0536a();
        } else {
            f708Rp = new C0534d();
        }
    }

    /* renamed from: a */
    public static void m1158a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f708Rp.mo1299a(popupWindow, view, i, i2, i3);
    }

    /* renamed from: a */
    public static void m1159a(PopupWindow popupWindow, boolean z) {
        f708Rp.mo1300a(popupWindow, z);
    }

    /* renamed from: a */
    public static void m1157a(PopupWindow popupWindow, int i) {
        f708Rp.mo1298a(popupWindow, i);
    }
}

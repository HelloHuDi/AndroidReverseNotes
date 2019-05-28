package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class n {
    static final d Rp;

    static class d {
        private static Method Rr;
        private static boolean Rs;

        d() {
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((android.support.v4.view.d.getAbsoluteGravity(i3, s.T(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void a(PopupWindow popupWindow, boolean z) {
        }

        public void a(PopupWindow popupWindow, int i) {
            if (!Rs) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    Rr = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e) {
                }
                Rs = true;
            }
            if (Rr != null) {
                try {
                    Rr.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }
    }

    static class a extends d {
        a() {
        }

        public final void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    static class b extends a {
        private static Field Rq;

        b() {
        }

        static {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                Rq = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
        }

        public void a(PopupWindow popupWindow, boolean z) {
            if (Rq != null) {
                try {
                    Rq.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                }
            }
        }
    }

    static class c extends b {
        c() {
        }

        public final void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        public final void a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            Rp = new c();
        } else if (VERSION.SDK_INT >= 21) {
            Rp = new b();
        } else if (VERSION.SDK_INT >= 19) {
            Rp = new a();
        } else {
            Rp = new d();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        Rp.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        Rp.a(popupWindow, z);
    }

    public static void a(PopupWindow popupWindow, int i) {
        Rp.a(popupWindow, i);
    }
}

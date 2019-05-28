package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class v {
    static final c Nv;

    static class c {
        c() {
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof l) {
                return ((l) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof l) {
                ((l) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof l) {
                ((l) viewParent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof l) {
                ((l) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof l) {
                ((l) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof l) {
                return ((l) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof l) {
                return ((l) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class a extends c {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        public final boolean a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStartNestedScroll");
                return false;
            }
        }

        public final void b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScrollAccepted");
            }
        }

        public final void a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStopNestedScroll");
            }
        }

        public final void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScroll");
            }
        }

        public final void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedPreScroll");
            }
        }

        public final boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedFling");
                return false;
            }
        }

        public final boolean a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedPreFling");
                return false;
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            Nv = new b();
        } else if (VERSION.SDK_INT >= 19) {
            Nv = new a();
        } else {
            Nv = new c();
        }
    }

    @Deprecated
    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof m) {
            return ((m) viewParent).e(view, i, i2);
        }
        if (i2 == 0) {
            return Nv.a(viewParent, view, view2, i);
        }
        return false;
    }

    public static void b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof m) {
            ((m) viewParent).i(view2, i);
        } else if (i2 == 0) {
            Nv.b(viewParent, view, view2, i);
        }
    }

    public static void a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof m) {
            ((m) viewParent).j(view, i);
        } else if (i == 0) {
            Nv.a(viewParent, view);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof m) {
            ((m) viewParent).m(i4, i5);
        } else if (i5 == 0) {
            Nv.a(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof m) {
            ((m) viewParent).a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            Nv.a(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return Nv.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return Nv.a(viewParent, view, f, f2);
    }
}

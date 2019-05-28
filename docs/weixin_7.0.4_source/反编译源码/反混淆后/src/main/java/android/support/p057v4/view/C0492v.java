package android.support.p057v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.v */
public final class C0492v {
    /* renamed from: Nv */
    static final C0491c f581Nv;

    /* renamed from: android.support.v4.view.v$c */
    static class C0491c {
        C0491c() {
        }

        /* renamed from: a */
        public boolean mo1146a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0470l) {
                return ((C0470l) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        /* renamed from: b */
        public void mo1147b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0470l) {
                ((C0470l) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        /* renamed from: a */
        public void mo1141a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0470l) {
                ((C0470l) viewParent).onStopNestedScroll(view);
            }
        }

        /* renamed from: a */
        public void mo1142a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0470l) {
                ((C0470l) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public void mo1143a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0470l) {
                ((C0470l) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        /* renamed from: a */
        public boolean mo1145a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof C0470l) {
                return ((C0470l) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo1144a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof C0470l) {
                return ((C0470l) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.view.v$a */
    static class C0493a extends C0491c {
        C0493a() {
        }
    }

    /* renamed from: android.support.v4.view.v$b */
    static class C0494b extends C0493a {
        C0494b() {
        }

        /* renamed from: a */
        public final boolean mo1146a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStartNestedScroll");
                return false;
            }
        }

        /* renamed from: b */
        public final void mo1147b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScrollAccepted");
            }
        }

        /* renamed from: a */
        public final void mo1141a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStopNestedScroll");
            }
        }

        /* renamed from: a */
        public final void mo1142a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScroll");
            }
        }

        /* renamed from: a */
        public final void mo1143a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedPreScroll");
            }
        }

        /* renamed from: a */
        public final boolean mo1145a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedFling");
                return false;
            }
        }

        /* renamed from: a */
        public final boolean mo1144a(ViewParent viewParent, View view, float f, float f2) {
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
            f581Nv = new C0494b();
        } else if (VERSION.SDK_INT >= 19) {
            f581Nv = new C0493a();
        } else {
            f581Nv = new C0491c();
        }
    }

    @Deprecated
    /* renamed from: a */
    public static boolean m1027a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: a */
    public static boolean m1026a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof C6202m) {
            return ((C6202m) viewParent).mo14024e(view, i, i2);
        }
        if (i2 == 0) {
            return f581Nv.mo1146a(viewParent, view, view2, i);
        }
        return false;
    }

    /* renamed from: b */
    public static void m1028b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof C6202m) {
            ((C6202m) viewParent).mo14025i(view2, i);
        } else if (i2 == 0) {
            f581Nv.mo1147b(viewParent, view, view2, i);
        }
    }

    /* renamed from: a */
    public static void m1021a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof C6202m) {
            ((C6202m) viewParent).mo14026j(view, i);
        } else if (i == 0) {
            f581Nv.mo1141a(viewParent, view);
        }
    }

    /* renamed from: a */
    public static void m1022a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof C6202m) {
            ((C6202m) viewParent).mo14027m(i4, i5);
        } else if (i5 == 0) {
            f581Nv.mo1142a(viewParent, view, i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m1023a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof C6202m) {
            ((C6202m) viewParent).mo14023a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            f581Nv.mo1143a(viewParent, view, i, i2, iArr);
        }
    }

    /* renamed from: a */
    public static boolean m1025a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f581Nv.mo1145a(viewParent, view, f, f2, z);
    }

    /* renamed from: a */
    public static boolean m1024a(ViewParent viewParent, View view, float f, float f2) {
        return f581Nv.mo1144a(viewParent, view, f, f2);
    }
}

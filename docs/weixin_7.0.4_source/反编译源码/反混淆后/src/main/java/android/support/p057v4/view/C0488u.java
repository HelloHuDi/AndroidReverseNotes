package android.support.p057v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.u */
public final class C0488u {
    /* renamed from: No */
    static final C0487c f580No;

    /* renamed from: android.support.v4.view.u$c */
    static class C0487c {
        C0487c() {
        }

        /* renamed from: d */
        public int mo1139d(ViewGroup viewGroup) {
            return 0;
        }

        /* renamed from: e */
        public boolean mo1140e(ViewGroup viewGroup) {
            Boolean bool = (Boolean) viewGroup.getTag(2131820673);
            return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && C0477s.m917ai(viewGroup) == null) ? false : true;
        }
    }

    /* renamed from: android.support.v4.view.u$a */
    static class C0489a extends C0487c {
        C0489a() {
        }

        /* renamed from: d */
        public final int mo1139d(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }
    }

    /* renamed from: android.support.v4.view.u$b */
    static class C0490b extends C0489a {
        C0490b() {
        }

        /* renamed from: e */
        public final boolean mo1140e(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f580No = new C0490b();
        } else if (VERSION.SDK_INT >= 18) {
            f580No = new C0489a();
        } else {
            f580No = new C0487c();
        }
    }

    /* renamed from: d */
    public static int m1010d(ViewGroup viewGroup) {
        return f580No.mo1139d(viewGroup);
    }

    /* renamed from: e */
    public static boolean m1011e(ViewGroup viewGroup) {
        return f580No.mo1140e(viewGroup);
    }
}

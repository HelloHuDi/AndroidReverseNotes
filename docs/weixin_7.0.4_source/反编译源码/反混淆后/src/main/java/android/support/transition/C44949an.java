package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* renamed from: android.support.transition.an */
final class C44949an {
    /* renamed from: AS */
    private static final C17413aq f17665AS;

    static {
        if (VERSION.SDK_INT >= 18) {
            f17665AS = new C17412ap();
        } else {
            f17665AS = new C37106ao();
        }
    }

    /* renamed from: c */
    static C37105am m82224c(ViewGroup viewGroup) {
        return f17665AS.mo31640c(viewGroup);
    }

    /* renamed from: c */
    static void m82225c(ViewGroup viewGroup, boolean z) {
        f17665AS.mo31641c(viewGroup, z);
    }
}

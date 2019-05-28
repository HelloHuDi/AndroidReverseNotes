package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.support.transition.C17417h.C17419a;
import android.support.transition.C37109j.C17420a;
import android.support.transition.C44954i.C44953a;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.k */
final class C41497k {
    /* renamed from: yU */
    private static final C17420a f16773yU;

    static {
        if (VERSION.SDK_INT >= 21) {
            f16773yU = new C44953a();
        } else {
            f16773yU = new C17419a();
        }
    }

    /* renamed from: a */
    static C37109j m72486a(View view, ViewGroup viewGroup, Matrix matrix) {
        return f16773yU.mo31654a(view, viewGroup, matrix);
    }

    /* renamed from: A */
    static void m72485A(View view) {
        f16773yU.mo31653A(view);
    }
}

package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;

/* renamed from: android.support.transition.l */
final class C41498l {
    /* renamed from: yV */
    private static final C17421o f16774yV;

    static {
        if (VERSION.SDK_INT >= 21) {
            f16774yV = new C24642n();
        } else {
            f16774yV = new C24641m();
        }
    }

    /* renamed from: a */
    static void m72487a(ImageView imageView) {
        f16774yV.mo31655a(imageView);
    }

    /* renamed from: a */
    static void m72489a(ImageView imageView, Matrix matrix) {
        f16774yV.mo31657a(imageView, matrix);
    }

    /* renamed from: a */
    static void m72488a(ImageView imageView, Animator animator) {
        f16774yV.mo31656a(imageView, animator);
    }
}

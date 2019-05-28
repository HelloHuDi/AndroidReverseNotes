package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;

final class l {
    private static final o yV;

    static {
        if (VERSION.SDK_INT >= 21) {
            yV = new n();
        } else {
            yV = new m();
        }
    }

    static void a(ImageView imageView) {
        yV.a(imageView);
    }

    static void a(ImageView imageView, Matrix matrix) {
        yV.a(imageView, matrix);
    }

    static void a(ImageView imageView, Animator animator) {
        yV.a(imageView, animator);
    }
}

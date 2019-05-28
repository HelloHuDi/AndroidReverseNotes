package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.support.transition.j.a;
import android.view.View;
import android.view.ViewGroup;

final class k {
    private static final a yU;

    static {
        if (VERSION.SDK_INT >= 21) {
            yU = new a();
        } else {
            yU = new a();
        }
    }

    static j a(View view, ViewGroup viewGroup, Matrix matrix) {
        return yU.a(view, viewGroup, matrix);
    }

    static void A(View view) {
        yU.A(view);
    }
}

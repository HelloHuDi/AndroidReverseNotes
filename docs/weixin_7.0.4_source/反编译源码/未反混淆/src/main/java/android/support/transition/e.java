package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public final class e extends bb {
    private float yo = 3.0f;

    public final long a(ViewGroup viewGroup, Transition transition, ah ahVar, ah ahVar2) {
        if (ahVar == null && ahVar2 == null) {
            return 0;
        }
        int i;
        int centerX;
        int centerY;
        if (ahVar2 == null || bb.e(ahVar) == 0) {
            i = -1;
            ahVar2 = ahVar;
        } else {
            i = 1;
        }
        int a = bb.a(ahVar2, 0);
        int a2 = bb.a(ahVar2, 1);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            centerY = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            centerX = round;
        }
        float b = b((float) a, (float) a2, (float) centerX, (float) centerY) / b(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long j = transition.mDuration;
        if (j < 0) {
            j = 300;
        }
        return (long) Math.round((((float) (j * ((long) i))) / this.yo) * b);
    }

    private static float b(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }
}

package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* renamed from: android.support.transition.e */
public final class C16504e extends C8372bb {
    /* renamed from: yo */
    private float f3508yo = 3.0f;

    /* renamed from: a */
    public final long mo30425a(ViewGroup viewGroup, Transition transition, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null && c8368ah2 == null) {
            return 0;
        }
        int i;
        int centerX;
        int centerY;
        if (c8368ah2 == null || C8372bb.m14779e(c8368ah) == 0) {
            i = -1;
            c8368ah2 = c8368ah;
        } else {
            i = 1;
        }
        int a = C8372bb.m14778a(c8368ah2, 0);
        int a2 = C8372bb.m14778a(c8368ah2, 1);
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
        float b = C16504e.m25330b((float) a, (float) a2, (float) centerX, (float) centerY) / C16504e.m25330b(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long j = transition.mDuration;
        if (j < 0) {
            j = 300;
        }
        return (long) Math.round((((float) (j * ((long) i))) / this.f3508yo) * b);
    }

    /* renamed from: b */
    private static float m25330b(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }
}

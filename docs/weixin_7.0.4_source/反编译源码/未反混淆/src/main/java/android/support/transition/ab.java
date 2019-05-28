package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.s;
import android.view.ViewGroup;

public final class ab extends bb {
    private float yo = 3.0f;
    int zm = 80;

    public final long a(ViewGroup viewGroup, Transition transition, ah ahVar, ah ahVar2) {
        if (ahVar == null && ahVar2 == null) {
            return 0;
        }
        int centerX;
        int centerY;
        int i;
        int i2 = 1;
        Rect epicenter = transition.getEpicenter();
        if (ahVar2 == null || bb.e(ahVar) == 0) {
            i2 = -1;
            ahVar2 = ahVar;
        }
        int a = bb.a(ahVar2, 0);
        int a2 = bb.a(ahVar2, 1);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        } else {
            centerX = (round + width) / 2;
            centerY = (round2 + height) / 2;
        }
        if (this.zm == 8388611) {
            i = (s.T(viewGroup) == 1 ? 1 : null) != null ? 5 : 3;
        } else if (this.zm == 8388613) {
            i = (s.T(viewGroup) == 1 ? 1 : null) != null ? 3 : 5;
        } else {
            i = this.zm;
        }
        switch (i) {
            case 3:
                centerX = (width - a) + Math.abs(centerY - a2);
                break;
            case 5:
                centerX = (a - round) + Math.abs(centerY - a2);
                break;
            case 48:
                centerX = Math.abs(centerX - a) + (height - a2);
                break;
            case 80:
                centerX = Math.abs(centerX - a) + (a2 - round2);
                break;
            default:
                centerX = 0;
                break;
        }
        float f = (float) centerX;
        switch (this.zm) {
            case 3:
            case 5:
            case 8388611:
            case 8388613:
                centerX = viewGroup.getWidth();
                break;
            default:
                centerX = viewGroup.getHeight();
                break;
        }
        float f2 = f / ((float) centerX);
        long j = transition.mDuration;
        if (j < 0) {
            j = 300;
        }
        return (long) Math.round((((float) (j * ((long) i2))) / this.yo) * f2);
    }
}

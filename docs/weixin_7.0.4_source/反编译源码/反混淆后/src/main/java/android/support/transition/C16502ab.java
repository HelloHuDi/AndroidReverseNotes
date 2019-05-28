package android.support.transition;

import android.graphics.Rect;
import android.support.p057v4.view.C0477s;
import android.view.ViewGroup;

/* renamed from: android.support.transition.ab */
public final class C16502ab extends C8372bb {
    /* renamed from: yo */
    private float f3505yo = 3.0f;
    /* renamed from: zm */
    int f3506zm = 80;

    /* renamed from: a */
    public final long mo30425a(ViewGroup viewGroup, Transition transition, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null && c8368ah2 == null) {
            return 0;
        }
        int centerX;
        int centerY;
        int i;
        int i2 = 1;
        Rect epicenter = transition.getEpicenter();
        if (c8368ah2 == null || C8372bb.m14779e(c8368ah) == 0) {
            i2 = -1;
            c8368ah2 = c8368ah;
        }
        int a = C8372bb.m14778a(c8368ah2, 0);
        int a2 = C8372bb.m14778a(c8368ah2, 1);
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
        if (this.f3506zm == 8388611) {
            i = (C0477s.m893T(viewGroup) == 1 ? 1 : null) != null ? 5 : 3;
        } else if (this.f3506zm == 8388613) {
            i = (C0477s.m893T(viewGroup) == 1 ? 1 : null) != null ? 3 : 5;
        } else {
            i = this.f3506zm;
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
        switch (this.f3506zm) {
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
        return (long) Math.round((((float) (j * ((long) i2))) / this.f3505yo) * f2);
    }
}

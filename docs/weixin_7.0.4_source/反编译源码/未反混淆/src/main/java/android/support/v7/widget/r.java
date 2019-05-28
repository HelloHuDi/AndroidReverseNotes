package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

final class r implements u {
    r() {
    }

    public final void a(t tVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        tVar.l(new aq(colorStateList, f));
        View hS = tVar.hS();
        hS.setClipToOutline(true);
        hS.setElevation(f2);
        b(tVar, f3);
    }

    public final void a(t tVar, float f) {
        aq j = j(tVar);
        if (f != j.aqc) {
            j.aqc = f;
            j.h(null);
            j.invalidateSelf();
        }
    }

    public final void hT() {
    }

    public final void b(t tVar, float f) {
        j(tVar).a(f, tVar.getUseCompatPadding(), tVar.getPreventCornerOverlap());
        f(tVar);
    }

    public final float a(t tVar) {
        return j(tVar).aqf;
    }

    public final float d(t tVar) {
        return j(tVar).aqc;
    }

    public final void c(t tVar, float f) {
        tVar.hS().setElevation(f);
    }

    public final float e(t tVar) {
        return tVar.hS().getElevation();
    }

    private static void f(t tVar) {
        if (tVar.getUseCompatPadding()) {
            float f = j(tVar).aqf;
            float f2 = j(tVar).aqc;
            int ceil = (int) Math.ceil((double) ar.d(f, f2, tVar.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) ar.c(f, f2, tVar.getPreventCornerOverlap()));
            tVar.e(ceil, ceil2, ceil, ceil2);
            return;
        }
        tVar.e(0, 0, 0, 0);
    }

    public final void a(t tVar, ColorStateList colorStateList) {
        aq j = j(tVar);
        j.e(colorStateList);
        j.invalidateSelf();
    }

    public final ColorStateList i(t tVar) {
        return j(tVar).aqi;
    }

    private static aq j(t tVar) {
        return (aq) tVar.hR();
    }

    public final float b(t tVar) {
        return j(tVar).aqc * 2.0f;
    }

    public final float c(t tVar) {
        return j(tVar).aqc * 2.0f;
    }

    public final void g(t tVar) {
        b(tVar, j(tVar).aqf);
    }

    public final void h(t tVar) {
        b(tVar, j(tVar).aqf);
    }
}

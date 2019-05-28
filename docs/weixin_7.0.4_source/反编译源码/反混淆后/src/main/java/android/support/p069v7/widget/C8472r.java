package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: android.support.v7.widget.r */
final class C8472r implements C0726u {
    C8472r() {
    }

    /* renamed from: a */
    public final void mo2119a(C8473t c8473t, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        c8473t.mo1690l(new C41536aq(colorStateList, f));
        View hS = c8473t.mo1689hS();
        hS.setClipToOutline(true);
        hS.setElevation(f2);
        mo2122b(c8473t, f3);
    }

    /* renamed from: a */
    public final void mo2118a(C8473t c8473t, float f) {
        C41536aq j = C8472r.m15015j(c8473t);
        if (f != j.aqc) {
            j.aqc = f;
            j.mo66531h(null);
            j.invalidateSelf();
        }
    }

    /* renamed from: hT */
    public final void mo2129hT() {
    }

    /* renamed from: b */
    public final void mo2122b(C8473t c8473t, float f) {
        C8472r.m15015j(c8473t).mo66526a(f, c8473t.getUseCompatPadding(), c8473t.getPreventCornerOverlap());
        C8472r.m15014f(c8473t);
    }

    /* renamed from: a */
    public final float mo2117a(C8473t c8473t) {
        return C8472r.m15015j(c8473t).aqf;
    }

    /* renamed from: d */
    public final float mo2125d(C8473t c8473t) {
        return C8472r.m15015j(c8473t).aqc;
    }

    /* renamed from: c */
    public final void mo2124c(C8473t c8473t, float f) {
        c8473t.mo1689hS().setElevation(f);
    }

    /* renamed from: e */
    public final float mo2126e(C8473t c8473t) {
        return c8473t.mo1689hS().getElevation();
    }

    /* renamed from: f */
    private static void m15014f(C8473t c8473t) {
        if (c8473t.getUseCompatPadding()) {
            float f = C8472r.m15015j(c8473t).aqf;
            float f2 = C8472r.m15015j(c8473t).aqc;
            int ceil = (int) Math.ceil((double) C41537ar.m72686d(f, f2, c8473t.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) C41537ar.m72685c(f, f2, c8473t.getPreventCornerOverlap()));
            c8473t.mo1685e(ceil, ceil2, ceil, ceil2);
            return;
        }
        c8473t.mo1685e(0, 0, 0, 0);
    }

    /* renamed from: a */
    public final void mo2120a(C8473t c8473t, ColorStateList colorStateList) {
        C41536aq j = C8472r.m15015j(c8473t);
        j.mo66528e(colorStateList);
        j.invalidateSelf();
    }

    /* renamed from: i */
    public final ColorStateList mo2130i(C8473t c8473t) {
        return C8472r.m15015j(c8473t).aqi;
    }

    /* renamed from: j */
    private static C41536aq m15015j(C8473t c8473t) {
        return (C41536aq) c8473t.mo1688hR();
    }

    /* renamed from: b */
    public final float mo2121b(C8473t c8473t) {
        return C8472r.m15015j(c8473t).aqc * 2.0f;
    }

    /* renamed from: c */
    public final float mo2123c(C8473t c8473t) {
        return C8472r.m15015j(c8473t).aqc * 2.0f;
    }

    /* renamed from: g */
    public final void mo2127g(C8473t c8473t) {
        mo2122b(c8473t, C8472r.m15015j(c8473t).aqf);
    }

    /* renamed from: h */
    public final void mo2128h(C8473t c8473t) {
        mo2122b(c8473t, C8472r.m15015j(c8473t).aqf);
    }
}

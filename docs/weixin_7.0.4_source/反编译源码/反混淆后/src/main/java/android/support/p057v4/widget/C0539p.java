package android.support.p057v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* renamed from: android.support.v4.widget.p */
public final class C0539p {
    /* renamed from: qN */
    public OverScroller f710qN;

    @Deprecated
    /* renamed from: a */
    public static C0539p m1164a(Context context, Interpolator interpolator) {
        return new C0539p(context, interpolator);
    }

    private C0539p(Context context, Interpolator interpolator) {
        this.f710qN = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f710qN.startScroll(i, i2, i3, i4, i5);
    }
}

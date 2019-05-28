package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class p {
    public OverScroller qN;

    @Deprecated
    public static p a(Context context, Interpolator interpolator) {
        return new p(context, interpolator);
    }

    private p(Context context, Interpolator interpolator) {
        this.qN = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.qN.startScroll(i, i2, i3, i4, i5);
    }
}

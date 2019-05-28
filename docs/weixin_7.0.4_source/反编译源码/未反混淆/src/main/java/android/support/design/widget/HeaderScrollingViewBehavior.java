package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.c.a;
import android.support.v4.view.aa;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect qS = new Rect();
    final Rect qT = new Rect();
    int qU = 0;
    int qV;

    public abstract View f(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View f = f(coordinatorLayout.p(view));
            if (f != null) {
                if (s.al(f) && !s.al(view)) {
                    s.e(view, true);
                    if (s.al(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.a(view, i, i2, MeasureSpec.makeMeasureSpec(g(f) + (size - f.getMeasuredHeight()), i5 == -1 ? ErrorDialogData.SUPPRESSED : j.INVALID_ID), i4);
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void d(CoordinatorLayout coordinatorLayout, View view, int i) {
        View f = f(coordinatorLayout.p(view));
        if (f != null) {
            d dVar = (d) view.getLayoutParams();
            Rect rect = this.qS;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, f.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + f.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            aa lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !s.al(coordinatorLayout) || s.al(view))) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.qT;
            int i2 = dVar.gravity;
            if (i2 == 0) {
                i2 = 8388659;
            }
            android.support.v4.view.d.apply(i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            i2 = r(f);
            view.layout(rect2.left, rect2.top - i2, rect2.right, rect2.bottom - i2);
            this.qU = rect2.top - f.getBottom();
            return;
        }
        super.d(coordinatorLayout, view, i);
        this.qU = 0;
    }

    /* Access modifiers changed, original: 0000 */
    public float f(View view) {
        return 1.0f;
    }

    /* Access modifiers changed, original: final */
    public final int r(View view) {
        return this.qV == 0 ? 0 : a.clamp((int) (f(view) * ((float) this.qV)), 0, this.qV);
    }

    /* Access modifiers changed, original: 0000 */
    public int g(View view) {
        return view.getMeasuredHeight();
    }
}

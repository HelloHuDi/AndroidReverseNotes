package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C31839d;
import android.support.p057v4.p1154c.C17435a;
import android.support.p057v4.view.C0451aa;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    /* renamed from: qS */
    final Rect f5101qS = new Rect();
    /* renamed from: qT */
    final Rect f5102qT = new Rect();
    /* renamed from: qU */
    int f5103qU = 0;
    /* renamed from: qV */
    int f5104qV;

    /* renamed from: f */
    public abstract View mo18162f(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo18125a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View f = mo18162f(coordinatorLayout.mo66198p(view));
            if (f != null) {
                if (C0477s.m920al(f) && !C0477s.m920al(view)) {
                    C0477s.m942e(view, true);
                    if (C0477s.m920al(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.mo66174a(view, i, i2, MeasureSpec.makeMeasureSpec(mo18163g(f) + (size - f.getMeasuredHeight()), i5 == -1 ? ErrorDialogData.SUPPRESSED : C8415j.INVALID_ID), i4);
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final void mo41473d(CoordinatorLayout coordinatorLayout, View view, int i) {
        View f = mo18162f(coordinatorLayout.mo66198p(view));
        if (f != null) {
            C31839d c31839d = (C31839d) view.getLayoutParams();
            Rect rect = this.f5101qS;
            rect.set(coordinatorLayout.getPaddingLeft() + c31839d.leftMargin, f.getBottom() + c31839d.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c31839d.rightMargin, ((coordinatorLayout.getHeight() + f.getBottom()) - coordinatorLayout.getPaddingBottom()) - c31839d.bottomMargin);
            C0451aa lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !C0477s.m920al(coordinatorLayout) || C0477s.m920al(view))) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f5102qT;
            int i2 = c31839d.gravity;
            if (i2 == 0) {
                i2 = 8388659;
            }
            C0456d.apply(i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            i2 = mo42244r(f);
            view.layout(rect2.left, rect2.top - i2, rect2.right, rect2.bottom - i2);
            this.f5103qU = rect2.top - f.getBottom();
            return;
        }
        super.mo41473d(coordinatorLayout, view, i);
        this.f5103qU = 0;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public float mo18161f(View view) {
        return 1.0f;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final int mo42244r(View view) {
        return this.f5104qV == 0 ? 0 : C17435a.clamp((int) (mo18161f(view) * ((float) this.f5104qV)), 0, this.f5104qV);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public int mo18163g(View view) {
        return view.getMeasuredHeight();
    }
}

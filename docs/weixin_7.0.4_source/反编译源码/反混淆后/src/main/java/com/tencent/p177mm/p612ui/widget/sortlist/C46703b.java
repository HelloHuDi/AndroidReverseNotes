package com.tencent.p177mm.p612ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.widget.sortlist.b */
public class C46703b extends ViewGroup {
    /* renamed from: Hu */
    private int f17925Hu = 48;

    public C46703b(Context context) {
        super(context);
        AppMethodBeat.m2504i(113018);
        setLayoutParams(new LayoutParams(-1, -2));
        AppMethodBeat.m2505o(113018);
    }

    public int getGravity() {
        return this.f17925Hu;
    }

    public void setGravity(int i) {
        this.f17925Hu = i;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(113019);
        View childAt = getChildAt(0);
        if (childAt == null) {
            AppMethodBeat.m2505o(113019);
        } else if (this.f17925Hu == 48) {
            childAt.layout(0, 0, getMeasuredWidth(), childAt.getMeasuredHeight());
            AppMethodBeat.m2505o(113019);
        } else {
            childAt.layout(0, getMeasuredHeight() - childAt.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            AppMethodBeat.m2505o(113019);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(113020);
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i2);
        View childAt = getChildAt(0);
        if (childAt == null) {
            setMeasuredDimension(0, size2);
            AppMethodBeat.m2505o(113020);
            return;
        }
        if (childAt.isLayoutRequested()) {
            measureChild(childAt, i, MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (mode == 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height > 0) {
                size = layoutParams.height;
            } else {
                size = childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size2, size);
        AppMethodBeat.m2505o(113020);
    }
}

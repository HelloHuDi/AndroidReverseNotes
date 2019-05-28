package com.tencent.p177mm.plugin.downloader_app.search;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.downloader_app.search.c */
public final class C45840c extends C25373h {
    private final Drawable ahS;
    private final Resources mRes;
    private int mSize;

    public C45840c(Resources resources) {
        AppMethodBeat.m2504i(136197);
        this.mRes = resources;
        this.ahS = new ColorDrawable(resources.getColor(C25738R.color.f11945mj));
        this.mSize = resources.getDimensionPixelSize(C25738R.dimen.a3f);
        AppMethodBeat.m2505o(136197);
    }

    /* renamed from: a */
    public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(136198);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < childCount - 1) {
                View childAt = recyclerView.getChildAt(i2);
                View findViewById = childAt.findViewById(2131827271);
                View findViewById2 = childAt.findViewById(2131827274);
                View findViewById3 = childAt.findViewById(2131827278);
                if (childAt.getVisibility() == 8) {
                    super.mo6920a(canvas, recyclerView, c31880s);
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    i = layoutParams.bottomMargin + childAt.getBottom();
                    int i3 = this.mSize + i;
                    if (findViewById.getVisibility() == 0) {
                        this.ahS.setBounds(paddingLeft, i, width, i3);
                        this.ahS.draw(canvas);
                    } else if (findViewById2.getVisibility() == 0) {
                        this.ahS.setBounds(this.mRes.getDimensionPixelSize(C25738R.dimen.a7w) + paddingLeft, i, width, i3);
                        this.ahS.draw(canvas);
                    } else if (findViewById3.getVisibility() == 0) {
                        this.ahS.setBounds(this.mRes.getDimensionPixelSize(C25738R.dimen.a7v) + paddingLeft, i, width, i3);
                        this.ahS.draw(canvas);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(136198);
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(136199);
        rect.set(0, 0, 0, this.mSize);
        AppMethodBeat.m2505o(136199);
    }
}

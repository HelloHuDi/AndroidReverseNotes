package com.tencent.p177mm.plugin.downloader_app.p380ui;

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
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.a */
public final class C42929a extends C25373h {
    private final Drawable ahS;
    private final Drawable kQu = new ColorDrawable(-1);
    private int mSize;

    public C42929a(Resources resources) {
        AppMethodBeat.m2504i(136257);
        this.ahS = new ColorDrawable(resources.getColor(C25738R.color.f11945mj));
        this.mSize = resources.getDimensionPixelSize(C25738R.dimen.a3f);
        AppMethodBeat.m2505o(136257);
    }

    /* renamed from: a */
    public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(136258);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            View childAt2 = ((ViewGroup) childAt).getChildAt(0);
            int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i2 = bottom + this.mSize;
            if (childAt.getVisibility() == 8 || childAt2.getVisibility() == 8) {
                if (childAt2 instanceof TaskItemView) {
                    this.kQu.setBounds(paddingLeft, bottom, width, i2);
                    this.kQu.draw(canvas);
                }
            } else if ((childAt2 instanceof TaskManagerHeaderView) || (childAt2 instanceof TaskHeaderView) || (childAt2 instanceof ExpandView)) {
                this.ahS.setBounds(paddingLeft, bottom, width, i2);
                this.ahS.draw(canvas);
            } else {
                if (childAt2 instanceof TaskItemView) {
                    View childAt3 = recyclerView.getChildAt(i + 1);
                    if (childAt3 != null) {
                        childAt3 = ((ViewGroup) childAt3).getChildAt(0);
                        if (!(childAt3 instanceof TaskHeaderView)) {
                            if ((childAt3 instanceof ExpandView) && childAt3.getVisibility() == 8) {
                                this.ahS.setBounds(paddingLeft, bottom, width, i2);
                                this.ahS.draw(canvas);
                            }
                        }
                    }
                    this.ahS.setBounds(((TaskItemView) childAt2).getNamePaddingLeft() + paddingLeft, bottom, width, i2);
                    this.ahS.draw(canvas);
                    this.kQu.setBounds(paddingLeft, bottom, ((TaskItemView) childAt2).getNamePaddingLeft() + paddingLeft, i2);
                    this.kQu.draw(canvas);
                }
                super.mo6920a(canvas, recyclerView, c31880s);
            }
        }
        AppMethodBeat.m2505o(136258);
    }

    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(136259);
        rect.set(0, 0, 0, this.mSize);
        AppMethodBeat.m2505o(136259);
    }
}

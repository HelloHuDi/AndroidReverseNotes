package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends h {
    private final Drawable ahS;
    private final Drawable kQu = new ColorDrawable(-1);
    private int mSize;

    public a(Resources resources) {
        AppMethodBeat.i(136257);
        this.ahS = new ColorDrawable(resources.getColor(R.color.mj));
        this.mSize = resources.getDimensionPixelSize(R.dimen.a3f);
        AppMethodBeat.o(136257);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
        AppMethodBeat.i(136258);
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
                super.a(canvas, recyclerView, sVar);
            }
        }
        AppMethodBeat.o(136258);
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        AppMethodBeat.i(136259);
        rect.set(0, 0, 0, this.mSize);
        AppMethodBeat.o(136259);
    }
}

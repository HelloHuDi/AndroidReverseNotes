package com.tencent.mm.plugin.downloader_app.search;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class c extends h {
    private final Drawable ahS;
    private final Resources mRes;
    private int mSize;

    public c(Resources resources) {
        AppMethodBeat.i(136197);
        this.mRes = resources;
        this.ahS = new ColorDrawable(resources.getColor(R.color.mj));
        this.mSize = resources.getDimensionPixelSize(R.dimen.a3f);
        AppMethodBeat.o(136197);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
        AppMethodBeat.i(136198);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < childCount - 1) {
                View childAt = recyclerView.getChildAt(i2);
                View findViewById = childAt.findViewById(R.id.e6u);
                View findViewById2 = childAt.findViewById(R.id.e6x);
                View findViewById3 = childAt.findViewById(R.id.e71);
                if (childAt.getVisibility() == 8) {
                    super.a(canvas, recyclerView, sVar);
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    i = layoutParams.bottomMargin + childAt.getBottom();
                    int i3 = this.mSize + i;
                    if (findViewById.getVisibility() == 0) {
                        this.ahS.setBounds(paddingLeft, i, width, i3);
                        this.ahS.draw(canvas);
                    } else if (findViewById2.getVisibility() == 0) {
                        this.ahS.setBounds(this.mRes.getDimensionPixelSize(R.dimen.a7w) + paddingLeft, i, width, i3);
                        this.ahS.draw(canvas);
                    } else if (findViewById3.getVisibility() == 0) {
                        this.ahS.setBounds(this.mRes.getDimensionPixelSize(R.dimen.a7v) + paddingLeft, i, width, i3);
                        this.ahS.draw(canvas);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(136198);
                return;
            }
        }
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        AppMethodBeat.i(136199);
        rect.set(0, 0, 0, this.mSize);
        AppMethodBeat.o(136199);
    }
}

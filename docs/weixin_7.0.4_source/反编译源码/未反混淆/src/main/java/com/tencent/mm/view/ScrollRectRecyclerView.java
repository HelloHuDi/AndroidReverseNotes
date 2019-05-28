package com.tencent.mm.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class ScrollRectRecyclerView extends RecyclerView {
    public int scrollX;
    public int scrollY;
    private int zZX;

    public ScrollRectRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollRectRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62895);
        this.zZX = getResources().getDimensionPixelSize(R.dimen.a15);
        AppMethodBeat.o(62895);
    }

    public final void ap(int i, int i2) {
        AppMethodBeat.i(62896);
        super.ap(i, i2);
        this.scrollX += i;
        this.scrollY += i2;
        AppMethodBeat.o(62896);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(62897);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.zZX, ErrorDialogData.SUPPRESSED));
        AppMethodBeat.o(62897);
    }
}

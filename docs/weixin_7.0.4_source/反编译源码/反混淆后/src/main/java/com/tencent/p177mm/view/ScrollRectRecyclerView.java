package com.tencent.p177mm.view;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.view.ScrollRectRecyclerView */
public class ScrollRectRecyclerView extends RecyclerView {
    public int scrollX;
    public int scrollY;
    private int zZX;

    public ScrollRectRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollRectRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62895);
        this.zZX = getResources().getDimensionPixelSize(C25738R.dimen.a15);
        AppMethodBeat.m2505o(62895);
    }

    /* renamed from: ap */
    public final void mo64552ap(int i, int i2) {
        AppMethodBeat.m2504i(62896);
        super.mo64552ap(i, i2);
        this.scrollX += i;
        this.scrollY += i2;
        AppMethodBeat.m2505o(62896);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(62897);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.zZX, ErrorDialogData.SUPPRESSED));
        AppMethodBeat.m2505o(62897);
    }
}

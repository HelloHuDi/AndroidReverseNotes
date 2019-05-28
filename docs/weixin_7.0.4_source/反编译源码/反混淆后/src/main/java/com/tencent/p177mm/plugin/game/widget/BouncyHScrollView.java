package com.tencent.p177mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.game.widget.BouncyHScrollView */
public class BouncyHScrollView extends HorizontalScrollView {
    private Context mContext;
    private int noe;

    public BouncyHScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public BouncyHScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112384);
        super.onFinishInflate();
        this.noe = (int) (this.mContext.getResources().getDisplayMetrics().density * 300.0f);
        setOverScrollMode(0);
        setSmoothScrollingEnabled(true);
        setHorizontalFadingEdgeEnabled(false);
        AppMethodBeat.m2505o(112384);
    }

    /* Access modifiers changed, original: protected */
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.m2504i(112385);
        boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, this.noe, i8, z);
        AppMethodBeat.m2505o(112385);
        return overScrollBy;
    }
}

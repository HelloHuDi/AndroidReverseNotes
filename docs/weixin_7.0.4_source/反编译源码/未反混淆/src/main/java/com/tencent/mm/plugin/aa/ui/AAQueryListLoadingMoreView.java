package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.v;

public class AAQueryListLoadingMoreView extends LinearLayout {
    public AAQueryListLoadingMoreView(Context context) {
        super(context);
        AppMethodBeat.i(40724);
        init(context);
        AppMethodBeat.o(40724);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40725);
        init(context);
        AppMethodBeat.o(40725);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40726);
        init(context);
        AppMethodBeat.o(40726);
    }

    private void init(Context context) {
        AppMethodBeat.i(40727);
        v.hu(context).inflate(R.layout.f, this, true);
        AppMethodBeat.o(40727);
    }
}

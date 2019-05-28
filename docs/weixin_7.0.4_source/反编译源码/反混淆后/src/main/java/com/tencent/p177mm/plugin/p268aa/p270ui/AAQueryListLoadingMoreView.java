package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListLoadingMoreView */
public class AAQueryListLoadingMoreView extends LinearLayout {
    public AAQueryListLoadingMoreView(Context context) {
        super(context);
        AppMethodBeat.m2504i(40724);
        init(context);
        AppMethodBeat.m2505o(40724);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40725);
        init(context);
        AppMethodBeat.m2505o(40725);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40726);
        init(context);
        AppMethodBeat.m2505o(40726);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(40727);
        C5616v.m8409hu(context).inflate(2130968581, this, true);
        AppMethodBeat.m2505o(40727);
    }
}

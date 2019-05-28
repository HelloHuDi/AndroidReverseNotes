package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListH5UrlFooterView */
public class AAQueryListH5UrlFooterView extends LinearLayout {
    private TextView gnj;

    public AAQueryListH5UrlFooterView(Context context) {
        super(context);
        AppMethodBeat.m2504i(40720);
        init(context);
        AppMethodBeat.m2505o(40720);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40721);
        init(context);
        AppMethodBeat.m2505o(40721);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40722);
        init(context);
        AppMethodBeat.m2505o(40722);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(40723);
        this.gnj = (TextView) C5616v.m8409hu(context).inflate(2130968580, this, true).findViewById(2131820895);
        AppMethodBeat.m2505o(40723);
    }

    public TextView getBottomLinkTv() {
        return this.gnj;
    }
}

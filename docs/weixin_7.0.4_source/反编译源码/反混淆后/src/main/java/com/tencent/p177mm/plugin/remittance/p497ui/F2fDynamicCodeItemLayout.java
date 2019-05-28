package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.remittance.ui.F2fDynamicCodeItemLayout */
public class F2fDynamicCodeItemLayout extends LinearLayout {
    TextView kRK;
    TextView pQF;

    public F2fDynamicCodeItemLayout(Context context) {
        super(context);
        AppMethodBeat.m2504i(44804);
        init();
        AppMethodBeat.m2505o(44804);
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(44805);
        init();
        AppMethodBeat.m2505o(44805);
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(44806);
        init();
        AppMethodBeat.m2505o(44806);
    }

    private void init() {
        AppMethodBeat.m2504i(44807);
        View inflate = LayoutInflater.from(getContext()).inflate(2130970511, this);
        this.pQF = (TextView) inflate.findViewById(2131827062);
        this.kRK = (TextView) inflate.findViewById(2131827063);
        AppMethodBeat.m2505o(44807);
    }
}

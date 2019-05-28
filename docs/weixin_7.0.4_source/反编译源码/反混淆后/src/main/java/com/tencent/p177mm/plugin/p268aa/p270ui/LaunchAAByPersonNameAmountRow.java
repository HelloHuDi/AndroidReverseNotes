package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonNameAmountRow */
public class LaunchAAByPersonNameAmountRow extends LinearLayout {
    TextView gng;
    TextView goa;
    private View goc;

    public LaunchAAByPersonNameAmountRow(Context context) {
        super(context);
        AppMethodBeat.m2504i(40814);
        init(context);
        AppMethodBeat.m2505o(40814);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40815);
        init(context);
        AppMethodBeat.m2505o(40815);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40816);
        init(context);
        AppMethodBeat.m2505o(40816);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(40817);
        C5616v.m8409hu(context).inflate(2130969919, this, true);
        this.goa = (TextView) findViewById(2131821556);
        this.gng = (TextView) findViewById(2131825213);
        this.goc = findViewById(2131821128);
        AppMethodBeat.m2505o(40817);
    }

    public void setDividerVisible(boolean z) {
        AppMethodBeat.m2504i(40818);
        this.goc.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(40818);
    }
}

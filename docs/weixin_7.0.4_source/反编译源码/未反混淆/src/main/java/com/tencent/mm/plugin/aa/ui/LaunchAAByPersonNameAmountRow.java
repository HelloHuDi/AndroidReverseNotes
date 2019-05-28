package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.v;

public class LaunchAAByPersonNameAmountRow extends LinearLayout {
    TextView gng;
    TextView goa;
    private View goc;

    public LaunchAAByPersonNameAmountRow(Context context) {
        super(context);
        AppMethodBeat.i(40814);
        init(context);
        AppMethodBeat.o(40814);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40815);
        init(context);
        AppMethodBeat.o(40815);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40816);
        init(context);
        AppMethodBeat.o(40816);
    }

    private void init(Context context) {
        AppMethodBeat.i(40817);
        v.hu(context).inflate(R.layout.a9h, this, true);
        this.goa = (TextView) findViewById(R.id.a0b);
        this.gng = (TextView) findViewById(R.id.co7);
        this.goc = findViewById(R.id.p3);
        AppMethodBeat.o(40817);
    }

    public void setDividerVisible(boolean z) {
        AppMethodBeat.i(40818);
        this.goc.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(40818);
    }
}

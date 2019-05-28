package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class F2fDynamicCodeItemLayout extends LinearLayout {
    TextView kRK;
    TextView pQF;

    public F2fDynamicCodeItemLayout(Context context) {
        super(context);
        AppMethodBeat.i(44804);
        init();
        AppMethodBeat.o(44804);
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(44805);
        init();
        AppMethodBeat.o(44805);
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(44806);
        init();
        AppMethodBeat.o(44806);
    }

    private void init() {
        AppMethodBeat.i(44807);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.aog, this);
        this.pQF = (TextView) inflate.findViewById(R.id.e17);
        this.kRK = (TextView) inflate.findViewById(R.id.e18);
        AppMethodBeat.o(44807);
    }
}

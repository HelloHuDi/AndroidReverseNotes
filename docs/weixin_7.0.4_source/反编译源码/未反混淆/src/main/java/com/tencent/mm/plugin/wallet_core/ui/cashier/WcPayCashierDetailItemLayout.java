package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class WcPayCashierDetailItemLayout extends LinearLayout {
    public TextView kRK;
    public TextView pQF;
    public CdnImageView tLM;
    public CdnImageView tLN;

    public WcPayCashierDetailItemLayout(Context context) {
        super(context);
        AppMethodBeat.i(47753);
        init();
        AppMethodBeat.o(47753);
    }

    public WcPayCashierDetailItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47754);
        init();
        AppMethodBeat.o(47754);
    }

    public WcPayCashierDetailItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47755);
        init();
        AppMethodBeat.o(47755);
    }

    private void init() {
        AppMethodBeat.i(47756);
        View.inflate(getContext(), R.layout.b6u, this);
        this.pQF = (TextView) findViewById(R.id.fie);
        this.tLM = (CdnImageView) findViewById(R.id.fif);
        this.kRK = (TextView) findViewById(R.id.fig);
        this.tLN = (CdnImageView) findViewById(R.id.fih);
        AppMethodBeat.o(47756);
    }
}

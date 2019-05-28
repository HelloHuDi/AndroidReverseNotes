package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class WcPayCashierBankcardItemLayout extends LinearLayout {
    public CdnImageView kqn;
    public FavourLayout tGP;
    public TextView tLJ;
    public TextView tLK;
    public RadioButton tLL;

    public WcPayCashierBankcardItemLayout(Context context) {
        super(context);
        AppMethodBeat.i(47749);
        init();
        AppMethodBeat.o(47749);
    }

    public WcPayCashierBankcardItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47750);
        init();
        AppMethodBeat.o(47750);
    }

    public WcPayCashierBankcardItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47751);
        init();
        AppMethodBeat.o(47751);
    }

    private void init() {
        AppMethodBeat.i(47752);
        View.inflate(getContext(), R.layout.b6t, this);
        this.kqn = (CdnImageView) findViewById(R.id.fi_);
        this.tLJ = (TextView) findViewById(R.id.fia);
        this.tLK = (TextView) findViewById(R.id.fic);
        this.tLL = (RadioButton) findViewById(R.id.fib);
        this.tGP = (FavourLayout) findViewById(R.id.fid);
        AppMethodBeat.o(47752);
    }
}

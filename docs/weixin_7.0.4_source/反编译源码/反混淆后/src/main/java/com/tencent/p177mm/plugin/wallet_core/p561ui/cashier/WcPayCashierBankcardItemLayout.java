package com.tencent.p177mm.plugin.wallet_core.p561ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.FavourLayout;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierBankcardItemLayout */
public class WcPayCashierBankcardItemLayout extends LinearLayout {
    public CdnImageView kqn;
    public FavourLayout tGP;
    public TextView tLJ;
    public TextView tLK;
    public RadioButton tLL;

    public WcPayCashierBankcardItemLayout(Context context) {
        super(context);
        AppMethodBeat.m2504i(47749);
        init();
        AppMethodBeat.m2505o(47749);
    }

    public WcPayCashierBankcardItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(47750);
        init();
        AppMethodBeat.m2505o(47750);
    }

    public WcPayCashierBankcardItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(47751);
        init();
        AppMethodBeat.m2505o(47751);
    }

    private void init() {
        AppMethodBeat.m2504i(47752);
        View.inflate(getContext(), 2130971193, this);
        this.kqn = (CdnImageView) findViewById(2131829100);
        this.tLJ = (TextView) findViewById(2131829101);
        this.tLK = (TextView) findViewById(2131829103);
        this.tLL = (RadioButton) findViewById(2131829102);
        this.tGP = (FavourLayout) findViewById(2131829104);
        AppMethodBeat.m2505o(47752);
    }
}

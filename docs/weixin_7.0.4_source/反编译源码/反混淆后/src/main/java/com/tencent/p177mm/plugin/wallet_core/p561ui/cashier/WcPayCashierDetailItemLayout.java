package com.tencent.p177mm.plugin.wallet_core.p561ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout */
public class WcPayCashierDetailItemLayout extends LinearLayout {
    public TextView kRK;
    public TextView pQF;
    public CdnImageView tLM;
    public CdnImageView tLN;

    public WcPayCashierDetailItemLayout(Context context) {
        super(context);
        AppMethodBeat.m2504i(47753);
        init();
        AppMethodBeat.m2505o(47753);
    }

    public WcPayCashierDetailItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(47754);
        init();
        AppMethodBeat.m2505o(47754);
    }

    public WcPayCashierDetailItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(47755);
        init();
        AppMethodBeat.m2505o(47755);
    }

    private void init() {
        AppMethodBeat.m2504i(47756);
        View.inflate(getContext(), 2130971194, this);
        this.pQF = (TextView) findViewById(2131829105);
        this.tLM = (CdnImageView) findViewById(2131829106);
        this.kRK = (TextView) findViewById(2131829107);
        this.tLN = (CdnImageView) findViewById(2131829108);
        AppMethodBeat.m2505o(47756);
    }
}

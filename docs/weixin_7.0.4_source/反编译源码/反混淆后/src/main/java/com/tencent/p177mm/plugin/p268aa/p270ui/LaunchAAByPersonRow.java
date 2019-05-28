package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonRow */
public class LaunchAAByPersonRow extends LinearLayout {
    private ImageView goC;
    private TextView goD;
    private TextView goE;
    private WalletFormView goF;
    private TextView goG;
    private String username;

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40819);
        init();
        AppMethodBeat.m2505o(40819);
    }

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40820);
        init();
        AppMethodBeat.m2505o(40820);
    }

    private void init() {
        AppMethodBeat.m2504i(40821);
        LaunchAAByPersonRow.inflate(getContext(), 2130969920, this);
        this.goC = (ImageView) findViewById(2131825214);
        this.goD = (TextView) findViewById(2131825215);
        this.goF = (WalletFormView) findViewById(2131825217);
        this.goE = (TextView) findViewById(2131825207);
        this.goG = (TextView) findViewById(2131825216);
        AppMethodBeat.m2505o(40821);
    }

    public double getMoneyAmount() {
        AppMethodBeat.m2504i(40822);
        String str = this.goF.getText().toString();
        if (C5046bo.isNullOrNil(str) || "".equals(str)) {
            AppMethodBeat.m2505o(40822);
            return 0.0d;
        }
        double d = C5046bo.getDouble(str, 0.0d);
        AppMethodBeat.m2505o(40822);
        return d;
    }

    public void setAmountTextChangeWatcher(TextWatcher textWatcher) {
        AppMethodBeat.m2504i(40823);
        if (textWatcher != null) {
            this.goF.mo64594a(textWatcher);
        }
        AppMethodBeat.m2505o(40823);
    }

    public WalletFormView getAmountEditView() {
        return this.goF;
    }

    public String getUsername() {
        return this.username;
    }
}

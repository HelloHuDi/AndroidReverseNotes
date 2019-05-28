package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow extends LinearLayout {
    private ImageView goC;
    private TextView goD;
    private TextView goE;
    private WalletFormView goF;
    private TextView goG;
    private String username;

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40819);
        init();
        AppMethodBeat.o(40819);
    }

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40820);
        init();
        AppMethodBeat.o(40820);
    }

    private void init() {
        AppMethodBeat.i(40821);
        inflate(getContext(), R.layout.a9i, this);
        this.goC = (ImageView) findViewById(R.id.co8);
        this.goD = (TextView) findViewById(R.id.co9);
        this.goF = (WalletFormView) findViewById(R.id.coa);
        this.goE = (TextView) findViewById(R.id.co1);
        this.goG = (TextView) findViewById(R.id.co_);
        AppMethodBeat.o(40821);
    }

    public double getMoneyAmount() {
        AppMethodBeat.i(40822);
        String str = this.goF.getText().toString();
        if (bo.isNullOrNil(str) || "".equals(str)) {
            AppMethodBeat.o(40822);
            return 0.0d;
        }
        double d = bo.getDouble(str, 0.0d);
        AppMethodBeat.o(40822);
        return d;
    }

    public void setAmountTextChangeWatcher(TextWatcher textWatcher) {
        AppMethodBeat.i(40823);
        if (textWatcher != null) {
            this.goF.a(textWatcher);
        }
        AppMethodBeat.o(40823);
    }

    public WalletFormView getAmountEditView() {
        return this.goF;
    }

    public String getUsername() {
        return this.username;
    }
}

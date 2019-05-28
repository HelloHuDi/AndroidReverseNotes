package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView eks;
    private TextView goa;
    private WalletFormView gob;
    private View goc;
    private TextWatcher god = null;
    private String username;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40780);
        init(context);
        AppMethodBeat.o(40780);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40781);
        init(context);
        AppMethodBeat.o(40781);
    }

    private void init(Context context) {
        AppMethodBeat.i(40782);
        v.hu(context).inflate(R.layout.a9f, this, true);
        this.eks = (ImageView) findViewById(R.id.bke);
        this.goa = (TextView) findViewById(R.id.a0b);
        this.gob = (WalletFormView) findViewById(R.id.co0);
        this.goc = findViewById(R.id.p3);
        AppMethodBeat.o(40782);
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        AppMethodBeat.i(40783);
        this.god = textWatcher;
        this.gob.a(textWatcher);
        AppMethodBeat.o(40783);
    }

    public WalletFormView getMoneyEdit() {
        return this.gob;
    }

    public String getUsername() {
        return this.username;
    }

    public double getAmount() {
        AppMethodBeat.i(40784);
        String str = this.gob.getText().toString();
        if (bo.isNullOrNil(str) || "".equals(str)) {
            AppMethodBeat.o(40784);
            return 0.0d;
        }
        double d = bo.getDouble(str, 0.0d);
        AppMethodBeat.o(40784);
        return d;
    }

    public void setDividerVisible(boolean z) {
        AppMethodBeat.i(40785);
        this.goc.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(40785);
    }
}

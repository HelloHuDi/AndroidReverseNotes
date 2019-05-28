package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectRow */
public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView eks;
    private TextView goa;
    private WalletFormView gob;
    private View goc;
    private TextWatcher god = null;
    private String username;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40780);
        init(context);
        AppMethodBeat.m2505o(40780);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40781);
        init(context);
        AppMethodBeat.m2505o(40781);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(40782);
        C5616v.m8409hu(context).inflate(2130969917, this, true);
        this.eks = (ImageView) findViewById(2131823704);
        this.goa = (TextView) findViewById(2131821556);
        this.gob = (WalletFormView) findViewById(2131825206);
        this.goc = findViewById(2131821128);
        AppMethodBeat.m2505o(40782);
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        AppMethodBeat.m2504i(40783);
        this.god = textWatcher;
        this.gob.mo64594a(textWatcher);
        AppMethodBeat.m2505o(40783);
    }

    public WalletFormView getMoneyEdit() {
        return this.gob;
    }

    public String getUsername() {
        return this.username;
    }

    public double getAmount() {
        AppMethodBeat.m2504i(40784);
        String str = this.gob.getText().toString();
        if (C5046bo.isNullOrNil(str) || "".equals(str)) {
            AppMethodBeat.m2505o(40784);
            return 0.0d;
        }
        double d = C5046bo.getDouble(str, 0.0d);
        AppMethodBeat.m2505o(40784);
        return d;
    }

    public void setDividerVisible(boolean z) {
        AppMethodBeat.m2504i(40785);
        this.goc.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(40785);
    }
}

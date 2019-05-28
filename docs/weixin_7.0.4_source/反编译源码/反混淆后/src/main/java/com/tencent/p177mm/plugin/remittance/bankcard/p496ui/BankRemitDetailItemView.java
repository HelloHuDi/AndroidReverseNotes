package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailItemView */
public class BankRemitDetailItemView extends LinearLayout {
    private TextView iDT;
    private TextView kEq;
    private boolean pNa;

    public BankRemitDetailItemView(Context context) {
        this(context, false);
    }

    public BankRemitDetailItemView(Context context, boolean z) {
        super(context);
        AppMethodBeat.m2504i(44588);
        this.pNa = false;
        this.pNa = z;
        init();
        AppMethodBeat.m2505o(44588);
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(44589);
        this.pNa = false;
        init();
        AppMethodBeat.m2505o(44589);
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(44590);
        this.pNa = false;
        init();
        AppMethodBeat.m2505o(44590);
    }

    private void init() {
        AppMethodBeat.m2504i(44591);
        if (this.pNa) {
            BankRemitDetailItemView.inflate(getContext(), 2130968815, this);
        } else {
            BankRemitDetailItemView.inflate(getContext(), 2130968814, this);
        }
        this.iDT = (TextView) findViewById(2131821640);
        this.kEq = (TextView) findViewById(2131821641);
        AppMethodBeat.m2505o(44591);
    }

    /* renamed from: a */
    public final void mo62557a(String str, CharSequence charSequence, boolean z) {
        AppMethodBeat.m2504i(44592);
        this.iDT.setText(str);
        if (z) {
            this.kEq.setText(C44089j.m79293b(getContext(), charSequence, this.kEq.getTextSize()));
            AppMethodBeat.m2505o(44592);
            return;
        }
        this.kEq.setText(charSequence);
        AppMethodBeat.m2505o(44592);
    }

    /* renamed from: b */
    public final void mo62558b(int i, CharSequence charSequence) {
        AppMethodBeat.m2504i(44593);
        mo62557a(getContext().getString(i), charSequence, false);
        AppMethodBeat.m2505o(44593);
    }
}

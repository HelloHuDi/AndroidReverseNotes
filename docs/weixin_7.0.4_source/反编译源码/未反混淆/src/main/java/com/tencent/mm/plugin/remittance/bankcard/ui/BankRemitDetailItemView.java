package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;

public class BankRemitDetailItemView extends LinearLayout {
    private TextView iDT;
    private TextView kEq;
    private boolean pNa;

    public BankRemitDetailItemView(Context context) {
        this(context, false);
    }

    public BankRemitDetailItemView(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(44588);
        this.pNa = false;
        this.pNa = z;
        init();
        AppMethodBeat.o(44588);
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(44589);
        this.pNa = false;
        init();
        AppMethodBeat.o(44589);
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(44590);
        this.pNa = false;
        init();
        AppMethodBeat.o(44590);
    }

    private void init() {
        AppMethodBeat.i(44591);
        if (this.pNa) {
            inflate(getContext(), R.layout.fr, this);
        } else {
            inflate(getContext(), R.layout.fq, this);
        }
        this.iDT = (TextView) findViewById(R.id.a2l);
        this.kEq = (TextView) findViewById(R.id.a2m);
        AppMethodBeat.o(44591);
    }

    public final void a(String str, CharSequence charSequence, boolean z) {
        AppMethodBeat.i(44592);
        this.iDT.setText(str);
        if (z) {
            this.kEq.setText(j.b(getContext(), charSequence, this.kEq.getTextSize()));
            AppMethodBeat.o(44592);
            return;
        }
        this.kEq.setText(charSequence);
        AppMethodBeat.o(44592);
    }

    public final void b(int i, CharSequence charSequence) {
        AppMethodBeat.i(44593);
        a(getContext().getString(i), charSequence, false);
        AppMethodBeat.o(44593);
    }
}

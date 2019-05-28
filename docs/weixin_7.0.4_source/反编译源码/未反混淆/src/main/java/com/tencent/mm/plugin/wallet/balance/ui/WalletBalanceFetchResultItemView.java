package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public class WalletBalanceFetchResultItemView extends LinearLayout {
    private TextView iDT;
    private TextView kEq;
    private boolean pNa;

    public WalletBalanceFetchResultItemView(Context context) {
        this(context, false);
    }

    public WalletBalanceFetchResultItemView(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(45341);
        this.pNa = false;
        this.pNa = z;
        init();
        AppMethodBeat.o(45341);
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(45342);
        this.pNa = false;
        init();
        AppMethodBeat.o(45342);
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(45343);
        this.pNa = false;
        init();
        AppMethodBeat.o(45343);
    }

    private void init() {
        AppMethodBeat.i(45344);
        if (this.pNa) {
            inflate(getContext(), R.layout.fr, this);
        } else {
            inflate(getContext(), R.layout.fq, this);
        }
        this.iDT = (TextView) findViewById(R.id.a2l);
        this.kEq = (TextView) findViewById(R.id.a2m);
        AppMethodBeat.o(45344);
    }

    public final void a(String str, CharSequence charSequence, String str2, String str3, boolean z) {
        AppMethodBeat.i(45345);
        this.iDT.setText(str);
        if (!bo.isNullOrNil(str2)) {
            this.iDT.setTextColor(Color.parseColor(str2));
        }
        if (z) {
            this.kEq.setText(j.b(getContext(), charSequence, this.kEq.getTextSize()));
        } else {
            this.kEq.setText(charSequence);
        }
        if (!bo.isNullOrNil(str3)) {
            this.kEq.setTextColor(Color.parseColor(str3));
        }
        AppMethodBeat.o(45345);
    }

    public final void b(int i, CharSequence charSequence) {
        AppMethodBeat.i(45346);
        a(getContext().getString(i), charSequence, "", "", false);
        AppMethodBeat.o(45346);
    }
}

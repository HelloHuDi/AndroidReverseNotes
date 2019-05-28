package com.tencent.p177mm.plugin.wallet.balance.p552ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView */
public class WalletBalanceFetchResultItemView extends LinearLayout {
    private TextView iDT;
    private TextView kEq;
    private boolean pNa;

    public WalletBalanceFetchResultItemView(Context context) {
        this(context, false);
    }

    public WalletBalanceFetchResultItemView(Context context, boolean z) {
        super(context);
        AppMethodBeat.m2504i(45341);
        this.pNa = false;
        this.pNa = z;
        init();
        AppMethodBeat.m2505o(45341);
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(45342);
        this.pNa = false;
        init();
        AppMethodBeat.m2505o(45342);
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(45343);
        this.pNa = false;
        init();
        AppMethodBeat.m2505o(45343);
    }

    private void init() {
        AppMethodBeat.m2504i(45344);
        if (this.pNa) {
            WalletBalanceFetchResultItemView.inflate(getContext(), 2130968815, this);
        } else {
            WalletBalanceFetchResultItemView.inflate(getContext(), 2130968814, this);
        }
        this.iDT = (TextView) findViewById(2131821640);
        this.kEq = (TextView) findViewById(2131821641);
        AppMethodBeat.m2505o(45344);
    }

    /* renamed from: a */
    public final void mo69467a(String str, CharSequence charSequence, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(45345);
        this.iDT.setText(str);
        if (!C5046bo.isNullOrNil(str2)) {
            this.iDT.setTextColor(Color.parseColor(str2));
        }
        if (z) {
            this.kEq.setText(C44089j.m79293b(getContext(), charSequence, this.kEq.getTextSize()));
        } else {
            this.kEq.setText(charSequence);
        }
        if (!C5046bo.isNullOrNil(str3)) {
            this.kEq.setTextColor(Color.parseColor(str3));
        }
        AppMethodBeat.m2505o(45345);
    }

    /* renamed from: b */
    public final void mo69468b(int i, CharSequence charSequence) {
        AppMethodBeat.m2504i(45346);
        mo69467a(getContext().getString(i), charSequence, "", "", false);
        AppMethodBeat.m2505o(45346);
    }
}

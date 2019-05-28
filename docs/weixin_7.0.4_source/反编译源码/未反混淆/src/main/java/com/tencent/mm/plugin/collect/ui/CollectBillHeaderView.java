package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView extends LinearLayout {
    private TextView kEq;
    private WalletTextView kFm;
    private TextView kFn;
    private TextView kvI;

    public CollectBillHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(41173);
        init(context);
        AppMethodBeat.o(41173);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41174);
        init(context);
        AppMethodBeat.o(41174);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(41175);
        init(context);
        AppMethodBeat.o(41175);
    }

    private void init(Context context) {
        AppMethodBeat.i(41176);
        View inflate = v.hu(context).inflate(R.layout.ot, this);
        this.kvI = (TextView) inflate.findViewById(R.id.axn);
        this.kFn = (TextView) inflate.findViewById(R.id.axo);
        this.kFm = (WalletTextView) inflate.findViewById(R.id.axp);
        this.kEq = (TextView) inflate.findViewById(R.id.axq);
        AppMethodBeat.o(41176);
    }

    public final void a(int i, int i2, long j, int i3) {
        AppMethodBeat.i(41177);
        this.kvI.setText(e.a(getContext(), j, i3));
        this.kFm.setText(e.tG(i2));
        this.kEq.setText(getContext().getString(R.string.arm, new Object[]{Integer.valueOf(i)}));
        AppMethodBeat.o(41177);
    }
}

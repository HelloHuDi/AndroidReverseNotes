package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.collect.model.C38804e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;

/* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillHeaderView */
public class CollectBillHeaderView extends LinearLayout {
    private TextView kEq;
    private WalletTextView kFm;
    private TextView kFn;
    private TextView kvI;

    public CollectBillHeaderView(Context context) {
        super(context);
        AppMethodBeat.m2504i(41173);
        init(context);
        AppMethodBeat.m2505o(41173);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(41174);
        init(context);
        AppMethodBeat.m2505o(41174);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(41175);
        init(context);
        AppMethodBeat.m2505o(41175);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(41176);
        View inflate = C5616v.m8409hu(context).inflate(2130969152, this);
        this.kvI = (TextView) inflate.findViewById(2131822825);
        this.kFn = (TextView) inflate.findViewById(2131822826);
        this.kFm = (WalletTextView) inflate.findViewById(2131822827);
        this.kEq = (TextView) inflate.findViewById(2131822828);
        AppMethodBeat.m2505o(41176);
    }

    /* renamed from: a */
    public final void mo54416a(int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(41177);
        this.kvI.setText(C38804e.m65843a(getContext(), j, i3));
        this.kFm.setText(C38804e.m65844tG(i2));
        this.kEq.setText(getContext().getString(C25738R.string.arm, new Object[]{Integer.valueOf(i)}));
        AppMethodBeat.m2505o(41177);
    }
}

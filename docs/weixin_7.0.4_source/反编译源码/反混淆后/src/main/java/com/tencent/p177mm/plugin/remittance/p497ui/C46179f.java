package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.remittance.ui.f */
public final class C46179f extends C15532i implements OnClickListener {
    private int gOW;
    protected View jcl;
    private OnClickListener pUs;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.f$1 */
    class C396221 implements OnClickListener {
        C396221() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44981);
            if (C46179f.this.pUs != null) {
                C46179f.this.pUs.onClick(view);
                C46179f.this.dismiss();
            }
            AppMethodBeat.m2505o(44981);
        }
    }

    private C46179f(Context context) {
        this(context, (byte) 0);
    }

    private C46179f(Context context, byte b) {
        super(context, C25738R.style.f11419zx);
        AppMethodBeat.m2504i(44982);
        this.gOW = 0;
        this.jcl = View.inflate(context, 2130970513, null);
        setContentView(this.jcl);
        ((Button) this.jcl.findViewById(2131822819)).setOnClickListener(this);
        ((Button) this.jcl.findViewById(2131827084)).setOnClickListener(this);
        AppMethodBeat.m2505o(44982);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(44983);
        if (view.getId() != 2131823196) {
            C4990ab.m7416i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() == 2131822819) {
            if (this.gOW == 1) {
                C7060h.pYm.mo8381e(12689, Integer.valueOf(11), Integer.valueOf(1));
                AppMethodBeat.m2505o(44983);
                return;
            }
            C7060h.pYm.mo8381e(12689, Integer.valueOf(2), Integer.valueOf(1));
        }
        AppMethodBeat.m2505o(44983);
    }

    /* renamed from: a */
    public static void m86308a(Context context, int i, String str, double d) {
        AppMethodBeat.m2504i(44984);
        C4990ab.m7416i("RemittanceChargeDialog", "showAlert");
        C46179f c46179f = new C46179f(context);
        c46179f.gOW = i;
        C4990ab.m7416i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) c46179f.findViewById(2131827074);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) c46179f.findViewById(2131827076)).setText(context.getResources().getString(C25738R.string.dpe, new Object[]{C36391e.m59972G(d)}));
        c46179f.findViewById(2131827083).setVisibility(0);
        c46179f.findViewById(2131827075).setVisibility(0);
        c46179f.show();
        C30379h.m48455a(context, c46179f);
        AppMethodBeat.m2505o(44984);
    }

    /* renamed from: a */
    public static C46179f m86307a(Context context, int i, double d, double d2, double d3, String str, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(44985);
        C4990ab.m7416i("RemittanceChargeDialog", "showCostDetail");
        C46179f c46179f = new C46179f(context);
        c46179f.gOW = i;
        if (d == 0.0d) {
            C4990ab.m7416i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) c46179f.findViewById(2131827080)).setText(C36391e.m59972G(d));
        ((TextView) c46179f.findViewById(2131827081)).setText(C36391e.m59972G(d2));
        if (d3 == 0.0d) {
            C4990ab.m7412e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) c46179f.findViewById(2131827078)).setText(C36391e.m59972G(d3));
        c46179f.findViewById(2131827077).setVisibility(0);
        if (!C5046bo.isNullOrNil(str)) {
            TextView textView = (TextView) c46179f.findViewById(2131827074);
            textView.setText(str);
            textView.setVisibility(0);
        }
        c46179f.findViewById(2131827082).setVisibility(0);
        c46179f.pUs = onClickListener;
        c46179f.findViewById(2131823196).setOnClickListener(new C396221());
        c46179f.show();
        C30379h.m48455a(context, c46179f);
        if (i == 1) {
            C7060h.pYm.mo8381e(12689, Integer.valueOf(10), Integer.valueOf(1));
        } else {
            C7060h.pYm.mo8381e(12689, Integer.valueOf(1), Integer.valueOf(1));
        }
        AppMethodBeat.m2505o(44985);
        return c46179f;
    }
}

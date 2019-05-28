package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class f extends i implements OnClickListener {
    private int gOW;
    protected View jcl;
    private OnClickListener pUs;

    private f(Context context) {
        this(context, (byte) 0);
    }

    private f(Context context, byte b) {
        super(context, R.style.zx);
        AppMethodBeat.i(44982);
        this.gOW = 0;
        this.jcl = View.inflate(context, R.layout.aoi, null);
        setContentView(this.jcl);
        ((Button) this.jcl.findViewById(R.id.axh)).setOnClickListener(this);
        ((Button) this.jcl.findViewById(R.id.e1s)).setOnClickListener(this);
        AppMethodBeat.o(44982);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(44983);
        if (view.getId() != R.id.b7o) {
            ab.i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() == R.id.axh) {
            if (this.gOW == 1) {
                h.pYm.e(12689, Integer.valueOf(11), Integer.valueOf(1));
                AppMethodBeat.o(44983);
                return;
            }
            h.pYm.e(12689, Integer.valueOf(2), Integer.valueOf(1));
        }
        AppMethodBeat.o(44983);
    }

    public static void a(Context context, int i, String str, double d) {
        AppMethodBeat.i(44984);
        ab.i("RemittanceChargeDialog", "showAlert");
        f fVar = new f(context);
        fVar.gOW = i;
        ab.i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) fVar.findViewById(R.id.e1i);
        if (bo.isNullOrNil(str)) {
            ab.e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) fVar.findViewById(R.id.e1k)).setText(context.getResources().getString(R.string.dpe, new Object[]{e.G(d)}));
        fVar.findViewById(R.id.e1r).setVisibility(0);
        fVar.findViewById(R.id.e1j).setVisibility(0);
        fVar.show();
        com.tencent.mm.ui.base.h.a(context, fVar);
        AppMethodBeat.o(44984);
    }

    public static f a(Context context, int i, double d, double d2, double d3, String str, OnClickListener onClickListener) {
        AppMethodBeat.i(44985);
        ab.i("RemittanceChargeDialog", "showCostDetail");
        f fVar = new f(context);
        fVar.gOW = i;
        if (d == 0.0d) {
            ab.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) fVar.findViewById(R.id.e1o)).setText(e.G(d));
        ((TextView) fVar.findViewById(R.id.e1p)).setText(e.G(d2));
        if (d3 == 0.0d) {
            ab.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) fVar.findViewById(R.id.e1m)).setText(e.G(d3));
        fVar.findViewById(R.id.e1l).setVisibility(0);
        if (!bo.isNullOrNil(str)) {
            TextView textView = (TextView) fVar.findViewById(R.id.e1i);
            textView.setText(str);
            textView.setVisibility(0);
        }
        fVar.findViewById(R.id.e1q).setVisibility(0);
        fVar.pUs = onClickListener;
        fVar.findViewById(R.id.b7o).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44981);
                if (f.this.pUs != null) {
                    f.this.pUs.onClick(view);
                    f.this.dismiss();
                }
                AppMethodBeat.o(44981);
            }
        });
        fVar.show();
        com.tencent.mm.ui.base.h.a(context, fVar);
        if (i == 1) {
            h.pYm.e(12689, Integer.valueOf(10), Integer.valueOf(1));
        } else {
            h.pYm.e(12689, Integer.valueOf(1), Integer.valueOf(1));
        }
        AppMethodBeat.o(44985);
        return fVar;
    }
}

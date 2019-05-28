package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.model.C21206r;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.f */
public final class C34505f extends C39343e {
    private Context mContext = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.f$a */
    class C34504a {
        /* renamed from: Lp */
        int f15059Lp;
        TextView iDT;
        TextView kEq;
        TextView nSC;
        TextView nSD;

        C34504a() {
        }
    }

    public C34505f(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C34504a c34504a;
        AppMethodBeat.m2504i(42782);
        if (view == null) {
            view = this.mInflater.inflate(2130969988, viewGroup, false);
            C34504a c34504a2 = new C34504a();
            c34504a2.iDT = (TextView) view.findViewById(2131825556);
            c34504a2.kEq = (TextView) view.findViewById(2131825559);
            c34504a2.nSC = (TextView) view.findViewById(2131825557);
            c34504a2.nSD = (TextView) view.findViewById(2131825558);
            c34504a2.f15059Lp = i;
            view.setTag(c34504a2);
            c34504a = c34504a2;
        } else {
            c34504a = (C34504a) view.getTag();
        }
        C21206r yb = getItem(i);
        c34504a.iDT.setText(yb.nXO);
        c34504a.nSC.setText(yb.nXP);
        c34504a.nSD.setText(this.mContext.getString(C25738R.string.cq4, new Object[]{C36391e.m59971F(((double) yb.nWW) / 100.0d)}));
        CharSequence string = this.mContext.getString(C25738R.string.ct8, new Object[]{Long.valueOf(yb.nWU), Long.valueOf(yb.nXQ)});
        if (yb.status == 5) {
            string = this.mContext.getString(C25738R.string.ct9) + " " + string;
        }
        c34504a.kEq.setText(string);
        AppMethodBeat.m2505o(42782);
        return view;
    }
}

package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.wallet_core.ui.e;

public final class f extends e {
    private Context mContext = null;

    class a {
        int Lp;
        TextView iDT;
        TextView kEq;
        TextView nSC;
        TextView nSD;

        a() {
        }
    }

    public f(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(42782);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.aac, viewGroup, false);
            a aVar2 = new a();
            aVar2.iDT = (TextView) view.findViewById(R.id.cxh);
            aVar2.kEq = (TextView) view.findViewById(R.id.cxk);
            aVar2.nSC = (TextView) view.findViewById(R.id.cxi);
            aVar2.nSD = (TextView) view.findViewById(R.id.cxj);
            aVar2.Lp = i;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        r yb = getItem(i);
        aVar.iDT.setText(yb.nXO);
        aVar.nSC.setText(yb.nXP);
        aVar.nSD.setText(this.mContext.getString(R.string.cq4, new Object[]{e.F(((double) yb.nWW) / 100.0d)}));
        CharSequence string = this.mContext.getString(R.string.ct8, new Object[]{Long.valueOf(yb.nWU), Long.valueOf(yb.nXQ)});
        if (yb.status == 5) {
            string = this.mContext.getString(R.string.ct9) + " " + string;
        }
        aVar.kEq.setText(string);
        AppMethodBeat.o(42782);
        return view;
    }
}

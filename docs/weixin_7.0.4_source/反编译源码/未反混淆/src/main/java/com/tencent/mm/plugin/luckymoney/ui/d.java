package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.wallet_core.ui.e;

public final class d extends e {
    private Context mContext;

    class a {
        TextView nSC;
        TextView nSD;
        ImageView nSO;
        TextView niS;

        a() {
        }
    }

    public d(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(42754);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.aaa, viewGroup, false);
            a aVar2 = new a();
            aVar2.niS = (TextView) view.findViewById(R.id.cxb);
            aVar2.nSC = (TextView) view.findViewById(R.id.cxd);
            aVar2.nSD = (TextView) view.findViewById(R.id.cxe);
            aVar2.nSO = (ImageView) view.findViewById(R.id.cxc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        r yb = getItem(i);
        x.a(this.mContext, aVar.niS, yb.nXL);
        aVar.nSC.setText(yb.nXN);
        aVar.nSD.setText(this.mContext.getString(R.string.csn, new Object[]{e.F(((double) yb.nXM) / 100.0d)}));
        if (yb.cRT == 1) {
            aVar.nSO.setImageResource(R.drawable.b9r);
            aVar.nSO.setVisibility(0);
        } else if (yb.cRT == 2) {
            aVar.nSO.setImageResource(R.drawable.b9j);
            aVar.nSO.setVisibility(0);
        } else {
            aVar.nSO.setVisibility(8);
        }
        AppMethodBeat.o(42754);
        return view;
    }
}

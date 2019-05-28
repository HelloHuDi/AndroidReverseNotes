package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.model.C21206r;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.d */
public final class C46065d extends C39343e {
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.d$a */
    class C43282a {
        TextView nSC;
        TextView nSD;
        ImageView nSO;
        TextView niS;

        C43282a() {
        }
    }

    public C46065d(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C43282a c43282a;
        AppMethodBeat.m2504i(42754);
        if (view == null) {
            view = this.mInflater.inflate(2130969986, viewGroup, false);
            C43282a c43282a2 = new C43282a();
            c43282a2.niS = (TextView) view.findViewById(2131825550);
            c43282a2.nSC = (TextView) view.findViewById(2131825552);
            c43282a2.nSD = (TextView) view.findViewById(2131825553);
            c43282a2.nSO = (ImageView) view.findViewById(2131825551);
            view.setTag(c43282a2);
            c43282a = c43282a2;
        } else {
            c43282a = (C43282a) view.getTag();
        }
        C21206r yb = getItem(i);
        C46063x.m85800a(this.mContext, c43282a.niS, yb.nXL);
        c43282a.nSC.setText(yb.nXN);
        c43282a.nSD.setText(this.mContext.getString(C25738R.string.csn, new Object[]{C36391e.m59971F(((double) yb.nXM) / 100.0d)}));
        if (yb.cRT == 1) {
            c43282a.nSO.setImageResource(C25738R.drawable.b9r);
            c43282a.nSO.setVisibility(0);
        } else if (yb.cRT == 2) {
            c43282a.nSO.setImageResource(C25738R.drawable.b9j);
            c43282a.nSO.setVisibility(0);
        } else {
            c43282a.nSO.setVisibility(8);
        }
        AppMethodBeat.m2505o(42754);
        return view;
    }
}

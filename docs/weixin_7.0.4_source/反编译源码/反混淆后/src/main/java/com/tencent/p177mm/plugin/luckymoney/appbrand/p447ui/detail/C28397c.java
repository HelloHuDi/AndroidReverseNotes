package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.protocal.protobuf.ash;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c */
public final class C28397c extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private int nSA = 1;
    private C28398a nSB = null;
    private List<ash> nSx = new LinkedList();
    private String nSy = null;
    boolean nSz = false;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c$a */
    interface C28398a {
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c$b */
    class C28399b {
        ImageView kEn;
        View kRR;
        TextView nSC;
        TextView nSD;
        TextView nSE;
        TextView nSF;
        ImageView nSG;
        TextView nSH;
        TextView niS;

        C28399b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(42022);
        ash xJ = m45041xJ(i);
        AppMethodBeat.m2505o(42022);
        return xJ;
    }

    public C28397c(Context context) {
        AppMethodBeat.m2504i(42017);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.m2505o(42017);
    }

    /* renamed from: ck */
    public final void mo46379ck(List<ash> list) {
        AppMethodBeat.m2504i(42018);
        if (list == null) {
            this.nSx = new LinkedList();
        } else {
            this.nSx = list;
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(42018);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(42019);
        int size = this.nSx.size();
        AppMethodBeat.m2505o(42019);
        return size;
    }

    /* renamed from: xJ */
    private ash m45041xJ(int i) {
        AppMethodBeat.m2504i(42020);
        ash ash = (ash) this.nSx.get(i);
        AppMethodBeat.m2505o(42020);
        return ash;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C28399b c28399b;
        AppMethodBeat.m2504i(42021);
        if (view == null) {
            view = this.mInflater.inflate(2130969996, viewGroup, false);
            C28399b c28399b2 = new C28399b();
            c28399b2.kRR = view.findViewById(2131820987);
            c28399b2.kEn = (ImageView) view.findViewById(2131825654);
            c28399b2.niS = (TextView) view.findViewById(2131825655);
            c28399b2.nSC = (TextView) view.findViewById(2131825659);
            c28399b2.nSD = (TextView) view.findViewById(2131825656);
            c28399b2.nSE = (TextView) view.findViewById(2131825658);
            c28399b2.nSF = (TextView) view.findViewById(2131825657);
            c28399b2.nSG = (ImageView) view.findViewById(2131825660);
            c28399b2.nSH = (TextView) view.findViewById(2131825661);
            view.setTag(c28399b2);
            c28399b = c28399b2;
        } else {
            c28399b = (C28399b) view.getTag();
        }
        ash xJ = m45041xJ(i);
        C46063x.m85811b(c28399b.kEn, xJ.nSa, xJ.username);
        c28399b.nSE.setVisibility(8);
        C46063x.m85800a(this.mContext, c28399b.niS, xJ.nickname);
        c28399b.nSD.setText(this.mContext.getString(C25738R.string.csn, new Object[]{C36391e.m59971F(((double) xJ.wvQ) / 100.0d)}));
        c28399b.nSC.setText(C46063x.m85820j(this.mContext, xJ.wvR * 1000));
        c28399b.nSC.setVisibility(0);
        c28399b.nSF.setVisibility(8);
        if (C5046bo.isNullOrNil(xJ.wvT)) {
            c28399b.nSG.setVisibility(8);
            c28399b.nSH.setVisibility(8);
        } else {
            c28399b.nSH.setText(xJ.wvT);
            if (this.nSA == 2) {
                c28399b.nSG.setImageResource(C25738R.drawable.b9k);
            } else {
                c28399b.nSG.setImageResource(C25738R.drawable.b8n);
            }
            c28399b.nSG.setVisibility(0);
            c28399b.nSH.setVisibility(0);
        }
        AppMethodBeat.m2505o(42021);
        return view;
    }
}

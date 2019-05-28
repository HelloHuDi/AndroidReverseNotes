package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.model.C39323w;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.i */
public final class C21256i extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    int nSA = 1;
    private List<C39323w> nSx = new LinkedList();
    String nSy;
    boolean nSz;
    OnClickListener ohU;
    C21259b ohV = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.i$a */
    final class C21257a implements C21259b {
        C21257a() {
        }

        /* renamed from: a */
        public final void mo36633a(C21258c c21258c, Context context) {
            AppMethodBeat.m2504i(43029);
            int color = context.getResources().getColor(C25738R.color.f12137to);
            int color2 = context.getResources().getColor(C25738R.color.f12138tp);
            int color3 = context.getResources().getColor(C25738R.color.f12149u3);
            c21258c.kRR.setBackgroundResource(C25738R.color.a3p);
            c21258c.kRR.setPadding(0, context.getResources().getDimensionPixelOffset(C25738R.dimen.f9966lo), 0, context.getResources().getDimensionPixelOffset(C25738R.dimen.f9966lo));
            c21258c.niS.setTextColor(color);
            c21258c.nSC.setTextColor(color2);
            c21258c.nSD.setTextColor(color);
            c21258c.nSE.setTextColor(color);
            c21258c.nSF.setTextColor(color3);
            AppMethodBeat.m2505o(43029);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.i$c */
    class C21258c {
        ImageView kEn;
        View kRR;
        TextView nSC;
        TextView nSD;
        TextView nSE;
        TextView nSF;
        ImageView nSG;
        TextView nSH;
        TextView niS;

        C21258c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.i$b */
    interface C21259b {
        /* renamed from: a */
        void mo36633a(C21258c c21258c, Context context);
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(43035);
        C39323w yk = m32625yk(i);
        AppMethodBeat.m2505o(43035);
        return yk;
    }

    public C21256i(Context context) {
        AppMethodBeat.m2504i(43030);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.m2505o(43030);
    }

    /* renamed from: ck */
    public final void mo36628ck(List<C39323w> list) {
        AppMethodBeat.m2504i(43031);
        if (list == null) {
            LinkedList linkedList = new LinkedList();
        } else {
            this.nSx = list;
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(43031);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(43032);
        int size = this.nSx.size();
        AppMethodBeat.m2505o(43032);
        return size;
    }

    /* renamed from: yk */
    private C39323w m32625yk(int i) {
        AppMethodBeat.m2504i(43033);
        C39323w c39323w = (C39323w) this.nSx.get(i);
        AppMethodBeat.m2505o(43033);
        return c39323w;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C21258c c21258c;
        AppMethodBeat.m2504i(43034);
        if (view == null) {
            view = this.mInflater.inflate(2130969996, viewGroup, false);
            C21258c c21258c2 = new C21258c();
            c21258c2.kRR = view.findViewById(2131820987);
            c21258c2.kEn = (ImageView) view.findViewById(2131825654);
            c21258c2.niS = (TextView) view.findViewById(2131825655);
            c21258c2.nSC = (TextView) view.findViewById(2131825659);
            c21258c2.nSD = (TextView) view.findViewById(2131825656);
            c21258c2.nSE = (TextView) view.findViewById(2131825658);
            c21258c2.nSF = (TextView) view.findViewById(2131825657);
            c21258c2.nSG = (ImageView) view.findViewById(2131825660);
            c21258c2.nSH = (TextView) view.findViewById(2131825661);
            if (this.ohV != null) {
                this.ohV.mo36633a(c21258c2, this.mContext);
            }
            view.setTag(c21258c2);
            c21258c = c21258c2;
        } else {
            c21258c = (C21258c) view.getTag();
        }
        C39323w yk = m32625yk(i);
        C46063x.m85811b(c21258c.kEn, yk.nYa, yk.userName);
        if (C5046bo.nullAsNil(yk.nWX).equals(this.nSy) && this.nSz) {
            c21258c.nSF.setOnClickListener(this.ohU);
            c21258c.nSF.setVisibility(0);
            c21258c.nSE.setVisibility(8);
            c21258c.nSC.setVisibility(8);
        } else {
            if (C5046bo.isNullOrNil(yk.nYb)) {
                c21258c.nSE.setVisibility(8);
            } else {
                C46063x.m85800a(this.mContext, c21258c.nSE, yk.nYb);
                c21258c.nSE.setVisibility(0);
            }
            c21258c.nSC.setText(C46063x.m85820j(this.mContext, C5046bo.getLong(yk.nXN, 0) * 1000));
            c21258c.nSC.setVisibility(0);
            c21258c.nSF.setVisibility(8);
        }
        C46063x.m85800a(this.mContext, c21258c.niS, yk.nXZ);
        c21258c.nSD.setText(this.mContext.getString(C25738R.string.csn, new Object[]{C36391e.m59971F(((double) yk.nXM) / 100.0d)}));
        if (C5046bo.isNullOrNil(yk.nYc)) {
            c21258c.nSG.setVisibility(8);
            c21258c.nSH.setVisibility(8);
        } else {
            c21258c.nSH.setText(yk.nYc);
            if (this.nSA == 2) {
                c21258c.nSG.setImageResource(C25738R.drawable.b9k);
            } else {
                c21258c.nSG.setImageResource(C25738R.drawable.b8n);
            }
            c21258c.nSG.setVisibility(0);
            c21258c.nSH.setVisibility(0);
        }
        AppMethodBeat.m2505o(43034);
        return view;
    }
}

package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    int nSA = 1;
    private List<w> nSx = new LinkedList();
    String nSy;
    boolean nSz;
    OnClickListener ohU;
    b ohV = null;

    final class a implements b {
        a() {
        }

        public final void a(c cVar, Context context) {
            AppMethodBeat.i(43029);
            int color = context.getResources().getColor(R.color.to);
            int color2 = context.getResources().getColor(R.color.tp);
            int color3 = context.getResources().getColor(R.color.u3);
            cVar.kRR.setBackgroundResource(R.color.a3p);
            cVar.kRR.setPadding(0, context.getResources().getDimensionPixelOffset(R.dimen.lo), 0, context.getResources().getDimensionPixelOffset(R.dimen.lo));
            cVar.niS.setTextColor(color);
            cVar.nSC.setTextColor(color2);
            cVar.nSD.setTextColor(color);
            cVar.nSE.setTextColor(color);
            cVar.nSF.setTextColor(color3);
            AppMethodBeat.o(43029);
        }
    }

    class c {
        ImageView kEn;
        View kRR;
        TextView nSC;
        TextView nSD;
        TextView nSE;
        TextView nSF;
        ImageView nSG;
        TextView nSH;
        TextView niS;

        c() {
        }
    }

    interface b {
        void a(c cVar, Context context);
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(43035);
        w yk = yk(i);
        AppMethodBeat.o(43035);
        return yk;
    }

    public i(Context context) {
        AppMethodBeat.i(43030);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(43030);
    }

    public final void ck(List<w> list) {
        AppMethodBeat.i(43031);
        if (list == null) {
            LinkedList linkedList = new LinkedList();
        } else {
            this.nSx = list;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(43031);
    }

    public final int getCount() {
        AppMethodBeat.i(43032);
        int size = this.nSx.size();
        AppMethodBeat.o(43032);
        return size;
    }

    private w yk(int i) {
        AppMethodBeat.i(43033);
        w wVar = (w) this.nSx.get(i);
        AppMethodBeat.o(43033);
        return wVar;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(43034);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.aak, viewGroup, false);
            c cVar2 = new c();
            cVar2.kRR = view.findViewById(R.id.l_);
            cVar2.kEn = (ImageView) view.findViewById(R.id.d05);
            cVar2.niS = (TextView) view.findViewById(R.id.d06);
            cVar2.nSC = (TextView) view.findViewById(R.id.d0_);
            cVar2.nSD = (TextView) view.findViewById(R.id.d07);
            cVar2.nSE = (TextView) view.findViewById(R.id.d09);
            cVar2.nSF = (TextView) view.findViewById(R.id.d08);
            cVar2.nSG = (ImageView) view.findViewById(R.id.d0a);
            cVar2.nSH = (TextView) view.findViewById(R.id.d0b);
            if (this.ohV != null) {
                this.ohV.a(cVar2, this.mContext);
            }
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        w yk = yk(i);
        x.b(cVar.kEn, yk.nYa, yk.userName);
        if (bo.nullAsNil(yk.nWX).equals(this.nSy) && this.nSz) {
            cVar.nSF.setOnClickListener(this.ohU);
            cVar.nSF.setVisibility(0);
            cVar.nSE.setVisibility(8);
            cVar.nSC.setVisibility(8);
        } else {
            if (bo.isNullOrNil(yk.nYb)) {
                cVar.nSE.setVisibility(8);
            } else {
                x.a(this.mContext, cVar.nSE, yk.nYb);
                cVar.nSE.setVisibility(0);
            }
            cVar.nSC.setText(x.j(this.mContext, bo.getLong(yk.nXN, 0) * 1000));
            cVar.nSC.setVisibility(0);
            cVar.nSF.setVisibility(8);
        }
        x.a(this.mContext, cVar.niS, yk.nXZ);
        cVar.nSD.setText(this.mContext.getString(R.string.csn, new Object[]{e.F(((double) yk.nXM) / 100.0d)}));
        if (bo.isNullOrNil(yk.nYc)) {
            cVar.nSG.setVisibility(8);
            cVar.nSH.setVisibility(8);
        } else {
            cVar.nSH.setText(yk.nYc);
            if (this.nSA == 2) {
                cVar.nSG.setImageResource(R.drawable.b9k);
            } else {
                cVar.nSG.setImageResource(R.drawable.b8n);
            }
            cVar.nSG.setVisibility(0);
            cVar.nSH.setVisibility(0);
        }
        AppMethodBeat.o(43034);
        return view;
    }
}

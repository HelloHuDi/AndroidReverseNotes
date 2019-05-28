package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class c extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private int nSA = 1;
    private a nSB = null;
    private List<ash> nSx = new LinkedList();
    private String nSy = null;
    boolean nSz = false;

    interface a {
    }

    class b {
        ImageView kEn;
        View kRR;
        TextView nSC;
        TextView nSD;
        TextView nSE;
        TextView nSF;
        ImageView nSG;
        TextView nSH;
        TextView niS;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(42022);
        ash xJ = xJ(i);
        AppMethodBeat.o(42022);
        return xJ;
    }

    public c(Context context) {
        AppMethodBeat.i(42017);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(42017);
    }

    public final void ck(List<ash> list) {
        AppMethodBeat.i(42018);
        if (list == null) {
            this.nSx = new LinkedList();
        } else {
            this.nSx = list;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(42018);
    }

    public final int getCount() {
        AppMethodBeat.i(42019);
        int size = this.nSx.size();
        AppMethodBeat.o(42019);
        return size;
    }

    private ash xJ(int i) {
        AppMethodBeat.i(42020);
        ash ash = (ash) this.nSx.get(i);
        AppMethodBeat.o(42020);
        return ash;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(42021);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.aak, viewGroup, false);
            b bVar2 = new b();
            bVar2.kRR = view.findViewById(R.id.l_);
            bVar2.kEn = (ImageView) view.findViewById(R.id.d05);
            bVar2.niS = (TextView) view.findViewById(R.id.d06);
            bVar2.nSC = (TextView) view.findViewById(R.id.d0_);
            bVar2.nSD = (TextView) view.findViewById(R.id.d07);
            bVar2.nSE = (TextView) view.findViewById(R.id.d09);
            bVar2.nSF = (TextView) view.findViewById(R.id.d08);
            bVar2.nSG = (ImageView) view.findViewById(R.id.d0a);
            bVar2.nSH = (TextView) view.findViewById(R.id.d0b);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        ash xJ = xJ(i);
        x.b(bVar.kEn, xJ.nSa, xJ.username);
        bVar.nSE.setVisibility(8);
        x.a(this.mContext, bVar.niS, xJ.nickname);
        bVar.nSD.setText(this.mContext.getString(R.string.csn, new Object[]{e.F(((double) xJ.wvQ) / 100.0d)}));
        bVar.nSC.setText(x.j(this.mContext, xJ.wvR * 1000));
        bVar.nSC.setVisibility(0);
        bVar.nSF.setVisibility(8);
        if (bo.isNullOrNil(xJ.wvT)) {
            bVar.nSG.setVisibility(8);
            bVar.nSH.setVisibility(8);
        } else {
            bVar.nSH.setText(xJ.wvT);
            if (this.nSA == 2) {
                bVar.nSG.setImageResource(R.drawable.b9k);
            } else {
                bVar.nSG.setImageResource(R.drawable.b8n);
            }
            bVar.nSG.setVisibility(0);
            bVar.nSH.setVisibility(0);
        }
        AppMethodBeat.o(42021);
        return view;
    }
}

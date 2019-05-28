package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b extends a {
    private String color;
    private boolean oRU = true;
    com.tencent.mm.plugin.nearlife.b.a oSb;
    private com.tencent.mm.plugin.nearlife.b.a oSc = new com.tencent.mm.plugin.nearlife.b.a("", new axw());
    String oSd;
    private HashMap<String, Integer> oSe = new HashMap();

    class a {
        TextView gne;
        TextView hrg;
        TextView nDW;
        String oQU;
        com.tencent.mm.plugin.nearlife.b.a oSf;
        LinearLayout oSg;
        WeImageView oSh;
        int position;
        int type;

        a() {
        }
    }

    public b(Context context, OnClickListener onClickListener, String str, boolean z, boolean z2, String str2) {
        super(context, onClickListener, str, z2);
        AppMethodBeat.i(22949);
        this.oSc.Title = context.getString(R.string.d4e);
        this.oRU = z;
        this.color = str2;
        this.oSe.put(this.oSc.oQU, Integer.valueOf(2));
        if (!z2 && z) {
            a(this.oSc, 0);
            notifyDataSetChanged();
        }
        AppMethodBeat.o(22949);
    }

    public final com.tencent.mm.plugin.nearlife.b.a fs(String str, String str2) {
        int i = 1;
        AppMethodBeat.i(22950);
        if (this.oSb == null) {
            this.oSb = new com.tencent.mm.plugin.nearlife.b.a("", new axw());
            this.oSb.oQU = "City";
            this.oSe.put(this.oSb.oQU, Integer.valueOf(1));
            com.tencent.mm.plugin.nearlife.b.a aVar = this.oSb;
            if (!this.oRU) {
                i = 0;
            }
            a(aVar, i);
        }
        this.oSb.Title = str;
        this.oSb.nQB = str2;
        notifyDataSetChanged();
        com.tencent.mm.plugin.nearlife.b.a aVar2 = this.oSb;
        AppMethodBeat.o(22950);
        return aVar2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int intValue;
        AppMethodBeat.i(22951);
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.mContext, R.layout.aic, null);
            aVar.gne = (TextView) view.findViewById(R.id.dfz);
            aVar.nDW = (TextView) view.findViewById(R.id.dga);
            aVar.hrg = (TextView) view.findViewById(R.id.dgb);
            aVar.oSg = (LinearLayout) view.findViewById(R.id.d9u);
            aVar.oSh = (WeImageView) view.findViewById(R.id.dgc);
            if (this.color != null) {
                aVar.oSh.setIconColor(Color.parseColor(this.color));
            }
            aVar.oSg.setOnClickListener(this.mjE);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.nearlife.b.a Ad = getItem(i);
        if (this.oSe.containsKey(Ad.oQU)) {
            intValue = ((Integer) this.oSe.get(Ad.oQU)).intValue();
        } else {
            intValue = 0;
        }
        aVar.oSh.setVisibility(8);
        aVar.type = intValue;
        aVar.oSf = Ad;
        if (!bo.isNullOrNil(this.oSd) && this.oSd.equals(Ad.oQU)) {
            aVar.oSh.setVisibility(0);
        }
        switch (intValue) {
            case 0:
                aVar.gne.setTextColor(this.mContext.getResources().getColor(R.color.h4));
                aVar.hrg.setVisibility(0);
                break;
            case 1:
                aVar.gne.setTextColor(this.mContext.getResources().getColor(R.color.h4));
                aVar.hrg.setVisibility(8);
                break;
            case 2:
                aVar.hrg.setVisibility(8);
                aVar.gne.setTextColor(this.mContext.getResources().getColor(R.color.a0k));
                if (bo.isNullOrNil(this.oSd)) {
                    aVar.oSh.setVisibility(0);
                    break;
                }
                break;
        }
        aVar.position = i;
        aVar.oQU = Ad.oQU;
        if (this.oRm) {
            aVar.gne.setText(Qc(Ad.Title));
            aVar.hrg.setText(Qc(a.cs(Ad.oQZ)));
        } else {
            aVar.gne.setText(Ad.Title);
            aVar.hrg.setText(a.cs(Ad.oQZ));
        }
        aVar.nDW.setVisibility(8);
        AppMethodBeat.o(22951);
        return view;
    }

    private Spannable Qc(String str) {
        AppMethodBeat.i(22952);
        Spannable a = f.a((CharSequence) str, this.oRh);
        AppMethodBeat.o(22952);
        return a;
    }
}

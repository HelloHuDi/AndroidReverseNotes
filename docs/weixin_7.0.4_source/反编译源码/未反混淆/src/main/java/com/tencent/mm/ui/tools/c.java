package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter {
    private Context context;
    private String gtX;
    private List<com.tencent.mm.au.b.a> list;
    private List<com.tencent.mm.au.b.a> nBI = new ArrayList();
    int[] nBK;
    boolean nBL = false;

    static class a {
        TextView emg;
        TextView nBN;
        TextView nBO;

        a() {
        }
    }

    public c(Context context, List<com.tencent.mm.au.b.a> list) {
        AppMethodBeat.i(34793);
        this.context = context;
        this.list = list;
        bIk();
        bIl();
        AppMethodBeat.o(34793);
    }

    private void bIk() {
        AppMethodBeat.i(34794);
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBI.add(this.list.get(i));
        }
        AppMethodBeat.o(34794);
    }

    private void bIl() {
        AppMethodBeat.i(34795);
        this.nBK = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBK[i] = ((com.tencent.mm.au.b.a) this.list.get(i)).fHG;
        }
        AppMethodBeat.o(34795);
    }

    public final int getCount() {
        AppMethodBeat.i(34796);
        int size = this.list.size();
        AppMethodBeat.o(34796);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(34797);
        Object obj = this.list.get(i);
        AppMethodBeat.o(34797);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void vM(String str) {
        AppMethodBeat.i(34798);
        if (str != null) {
            this.gtX = str.trim();
            this.list.clear();
            int size = this.nBI.size();
            int i = 0;
            while (i < size) {
                if (((com.tencent.mm.au.b.a) this.nBI.get(i)).fHE.toUpperCase().contains(this.gtX.toUpperCase()) || ((com.tencent.mm.au.b.a) this.nBI.get(i)).fHF.toUpperCase().contains(this.gtX.toUpperCase()) || ((com.tencent.mm.au.b.a) this.nBI.get(i)).fHD.contains(this.gtX)) {
                    this.list.add(this.nBI.get(i));
                }
                i++;
            }
            bIl();
            super.notifyDataSetChanged();
        }
        AppMethodBeat.o(34798);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        a aVar;
        AppMethodBeat.i(34799);
        com.tencent.mm.au.b.a aVar2 = (com.tencent.mm.au.b.a) getItem(i);
        if (view == null) {
            if (aa.dop()) {
                inflate = View.inflate(this.context, R.layout.re, null);
            } else {
                inflate = View.inflate(this.context, R.layout.rd, null);
            }
            aVar = new a();
            aVar.nBN = (TextView) inflate.findViewById(R.id.nh);
            aVar.emg = (TextView) inflate.findViewById(R.id.nr);
            aVar.nBO = (TextView) inflate.findViewById(R.id.nn);
            inflate.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            inflate = view;
        }
        int i2 = i > 0 ? this.nBK[i - 1] : -1;
        if (i == 0) {
            aVar.nBN.setVisibility(0);
            aVar.nBN.setText(xo(this.nBK[i]));
        } else if (i <= 0 || this.nBK[i] == i2) {
            aVar.nBN.setVisibility(8);
        } else {
            aVar.nBN.setVisibility(0);
            aVar.nBN.setText(xo(this.nBK[i]));
        }
        aVar.emg.setText(aVar2.fHE);
        aVar.nBO.setText(aVar2.fHD);
        if (this.nBL) {
            aVar.nBO.setVisibility(0);
        } else {
            aVar.nBO.setVisibility(4);
        }
        AppMethodBeat.o(34799);
        return inflate;
    }

    private static String xo(int i) {
        AppMethodBeat.i(34800);
        String str;
        if (aa.dop()) {
            str = Integer.toString(i) + "劃";
            AppMethodBeat.o(34800);
            return str;
        }
        str = String.valueOf((char) i);
        AppMethodBeat.o(34800);
        return str;
    }
}

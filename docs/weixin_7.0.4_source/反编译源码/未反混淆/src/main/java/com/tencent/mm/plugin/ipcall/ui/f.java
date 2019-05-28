package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class f extends BaseAdapter {
    private String gtX;
    private List<a> list;
    private List<a> nBI = new ArrayList();
    private IPCallCountryCodeSelectUI nBJ;
    int[] nBK;
    boolean nBL = false;
    boolean nBM = false;

    static class a {
        TextView emg;
        TextView nBN;
        TextView nBO;

        a() {
        }
    }

    public f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<a> list) {
        AppMethodBeat.i(22098);
        this.nBJ = iPCallCountryCodeSelectUI;
        this.list = list;
        bIk();
        bIl();
        AppMethodBeat.o(22098);
    }

    private void bIk() {
        AppMethodBeat.i(22099);
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBI.add(this.list.get(i));
        }
        this.nBJ.nBB.setVisibility(8);
        AppMethodBeat.o(22099);
    }

    private void bIl() {
        AppMethodBeat.i(22100);
        this.nBK = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBK[i] = ((a) this.list.get(i)).bIc();
        }
        AppMethodBeat.o(22100);
    }

    public final int getCount() {
        AppMethodBeat.i(22101);
        int size = this.list.size();
        AppMethodBeat.o(22101);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(22102);
        Object obj = this.list.get(i);
        AppMethodBeat.o(22102);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void vM(String str) {
        AppMethodBeat.i(22103);
        if (str != null) {
            this.gtX = str.trim();
            this.list.clear();
            int size = this.nBI.size();
            int i = 0;
            while (i < size) {
                if (((a) this.nBI.get(i)).fHE.toUpperCase().contains(this.gtX.toUpperCase()) || ((a) this.nBI.get(i)).fHF.toUpperCase().contains(this.gtX.toUpperCase()) || ((a) this.nBI.get(i)).countryCode.contains(this.gtX)) {
                    this.list.add(this.nBI.get(i));
                }
                i++;
            }
            bIl();
            if (this.list.size() == 0) {
                this.nBJ.nBB.setVisibility(0);
            } else {
                this.nBJ.nBB.setVisibility(8);
            }
            super.notifyDataSetChanged();
        }
        AppMethodBeat.o(22103);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(22104);
        a aVar2 = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.nBJ, R.layout.a8j, null);
            aVar = new a();
            aVar.nBN = (TextView) view.findViewById(R.id.nh);
            aVar.emg = (TextView) view.findViewById(R.id.nr);
            aVar.nBO = (TextView) view.findViewById(R.id.nn);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.nBK[i - 1] : -1;
        if (i == 0) {
            aVar.nBN.setVisibility(0);
            if (this.nBM) {
                aVar.nBN.setText(R.string.dea);
            } else {
                aVar.nBN.setText(xo(this.nBK[i]));
            }
        } else if (i <= 0 || this.nBK[i] == i2) {
            aVar.nBN.setVisibility(8);
        } else {
            aVar.nBN.setVisibility(0);
            aVar.nBN.setText(xo(this.nBK[i]));
        }
        if (bo.isNullOrNil(this.gtX)) {
            aVar.emg.setText(aVar2.fHE);
            aVar.nBO.setText(" (+" + aVar2.countryCode + ")");
        } else {
            aVar.emg.setText(com.tencent.mm.plugin.fts.a.f.a(aVar2.fHE, this.gtX));
            aVar.nBO.setText(com.tencent.mm.plugin.fts.a.f.a(" (+" + aVar2.countryCode + ")", this.gtX));
        }
        if (this.nBL) {
            aVar.nBO.setVisibility(0);
        } else {
            aVar.nBO.setVisibility(4);
        }
        AppMethodBeat.o(22104);
        return view;
    }

    private static String xo(int i) {
        AppMethodBeat.i(22105);
        String valueOf = String.valueOf((char) i);
        for (String equals : IPCallCountryCodeScrollbar.nBP) {
            if (equals.equals(String.valueOf((char) i))) {
                AppMethodBeat.o(22105);
                return valueOf;
            }
        }
        valueOf = "#";
        AppMethodBeat.o(22105);
        return valueOf;
    }
}

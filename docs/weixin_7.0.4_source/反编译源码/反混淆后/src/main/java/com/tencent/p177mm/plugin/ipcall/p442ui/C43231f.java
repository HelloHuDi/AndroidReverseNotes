package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.f */
public final class C43231f extends BaseAdapter {
    private String gtX;
    private List<C28349a> list;
    private List<C28349a> nBI = new ArrayList();
    private IPCallCountryCodeSelectUI nBJ;
    int[] nBK;
    boolean nBL = false;
    boolean nBM = false;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.f$a */
    static class C43230a {
        TextView emg;
        TextView nBN;
        TextView nBO;

        C43230a() {
        }
    }

    public C43231f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<C28349a> list) {
        AppMethodBeat.m2504i(22098);
        this.nBJ = iPCallCountryCodeSelectUI;
        this.list = list;
        bIk();
        bIl();
        AppMethodBeat.m2505o(22098);
    }

    private void bIk() {
        AppMethodBeat.m2504i(22099);
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBI.add(this.list.get(i));
        }
        this.nBJ.nBB.setVisibility(8);
        AppMethodBeat.m2505o(22099);
    }

    private void bIl() {
        AppMethodBeat.m2504i(22100);
        this.nBK = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBK[i] = ((C28349a) this.list.get(i)).bIc();
        }
        AppMethodBeat.m2505o(22100);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(22101);
        int size = this.list.size();
        AppMethodBeat.m2505o(22101);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(22102);
        Object obj = this.list.get(i);
        AppMethodBeat.m2505o(22102);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: vM */
    public final void mo68746vM(String str) {
        AppMethodBeat.m2504i(22103);
        if (str != null) {
            this.gtX = str.trim();
            this.list.clear();
            int size = this.nBI.size();
            int i = 0;
            while (i < size) {
                if (((C28349a) this.nBI.get(i)).fHE.toUpperCase().contains(this.gtX.toUpperCase()) || ((C28349a) this.nBI.get(i)).fHF.toUpperCase().contains(this.gtX.toUpperCase()) || ((C28349a) this.nBI.get(i)).countryCode.contains(this.gtX)) {
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
        AppMethodBeat.m2505o(22103);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C43230a c43230a;
        AppMethodBeat.m2504i(22104);
        C28349a c28349a = (C28349a) getItem(i);
        if (view == null) {
            view = View.inflate(this.nBJ, 2130969884, null);
            c43230a = new C43230a();
            c43230a.nBN = (TextView) view.findViewById(2131821069);
            c43230a.emg = (TextView) view.findViewById(2131821079);
            c43230a.nBO = (TextView) view.findViewById(2131821075);
            view.setTag(c43230a);
        } else {
            c43230a = (C43230a) view.getTag();
        }
        int i2 = i > 0 ? this.nBK[i - 1] : -1;
        if (i == 0) {
            c43230a.nBN.setVisibility(0);
            if (this.nBM) {
                c43230a.nBN.setText(C25738R.string.dea);
            } else {
                c43230a.nBN.setText(C43231f.m76876xo(this.nBK[i]));
            }
        } else if (i <= 0 || this.nBK[i] == i2) {
            c43230a.nBN.setVisibility(8);
        } else {
            c43230a.nBN.setVisibility(0);
            c43230a.nBN.setText(C43231f.m76876xo(this.nBK[i]));
        }
        if (C5046bo.isNullOrNil(this.gtX)) {
            c43230a.emg.setText(c28349a.fHE);
            c43230a.nBO.setText(" (+" + c28349a.countryCode + ")");
        } else {
            c43230a.emg.setText(C34204f.m56084a(c28349a.fHE, this.gtX));
            c43230a.nBO.setText(C34204f.m56084a(" (+" + c28349a.countryCode + ")", this.gtX));
        }
        if (this.nBL) {
            c43230a.nBO.setVisibility(0);
        } else {
            c43230a.nBO.setVisibility(4);
        }
        AppMethodBeat.m2505o(22104);
        return view;
    }

    /* renamed from: xo */
    private static String m76876xo(int i) {
        AppMethodBeat.m2504i(22105);
        String valueOf = String.valueOf((char) i);
        for (String equals : IPCallCountryCodeScrollbar.nBP) {
            if (equals.equals(String.valueOf((char) i))) {
                AppMethodBeat.m2505o(22105);
                return valueOf;
            }
        }
        valueOf = "#";
        AppMethodBeat.m2505o(22105);
        return valueOf;
    }
}

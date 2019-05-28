package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.tools.c */
public final class C46694c extends BaseAdapter {
    private Context context;
    private String gtX;
    private List<C17951a> list;
    private List<C17951a> nBI = new ArrayList();
    int[] nBK;
    boolean nBL = false;

    /* renamed from: com.tencent.mm.ui.tools.c$a */
    static class C46693a {
        TextView emg;
        TextView nBN;
        TextView nBO;

        C46693a() {
        }
    }

    public C46694c(Context context, List<C17951a> list) {
        AppMethodBeat.m2504i(34793);
        this.context = context;
        this.list = list;
        bIk();
        bIl();
        AppMethodBeat.m2505o(34793);
    }

    private void bIk() {
        AppMethodBeat.m2504i(34794);
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBI.add(this.list.get(i));
        }
        AppMethodBeat.m2505o(34794);
    }

    private void bIl() {
        AppMethodBeat.m2504i(34795);
        this.nBK = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nBK[i] = ((C17951a) this.list.get(i)).fHG;
        }
        AppMethodBeat.m2505o(34795);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(34796);
        int size = this.list.size();
        AppMethodBeat.m2505o(34796);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(34797);
        Object obj = this.list.get(i);
        AppMethodBeat.m2505o(34797);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: vM */
    public final void mo75002vM(String str) {
        AppMethodBeat.m2504i(34798);
        if (str != null) {
            this.gtX = str.trim();
            this.list.clear();
            int size = this.nBI.size();
            int i = 0;
            while (i < size) {
                if (((C17951a) this.nBI.get(i)).fHE.toUpperCase().contains(this.gtX.toUpperCase()) || ((C17951a) this.nBI.get(i)).fHF.toUpperCase().contains(this.gtX.toUpperCase()) || ((C17951a) this.nBI.get(i)).fHD.contains(this.gtX)) {
                    this.list.add(this.nBI.get(i));
                }
                i++;
            }
            bIl();
            super.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(34798);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C46693a c46693a;
        AppMethodBeat.m2504i(34799);
        C17951a c17951a = (C17951a) getItem(i);
        if (view == null) {
            if (C4988aa.dop()) {
                inflate = View.inflate(this.context, 2130969248, null);
            } else {
                inflate = View.inflate(this.context, 2130969247, null);
            }
            c46693a = new C46693a();
            c46693a.nBN = (TextView) inflate.findViewById(2131821069);
            c46693a.emg = (TextView) inflate.findViewById(2131821079);
            c46693a.nBO = (TextView) inflate.findViewById(2131821075);
            inflate.setTag(c46693a);
        } else {
            c46693a = (C46693a) view.getTag();
            inflate = view;
        }
        int i2 = i > 0 ? this.nBK[i - 1] : -1;
        if (i == 0) {
            c46693a.nBN.setVisibility(0);
            c46693a.nBN.setText(C46694c.m88454xo(this.nBK[i]));
        } else if (i <= 0 || this.nBK[i] == i2) {
            c46693a.nBN.setVisibility(8);
        } else {
            c46693a.nBN.setVisibility(0);
            c46693a.nBN.setText(C46694c.m88454xo(this.nBK[i]));
        }
        c46693a.emg.setText(c17951a.fHE);
        c46693a.nBO.setText(c17951a.fHD);
        if (this.nBL) {
            c46693a.nBO.setVisibility(0);
        } else {
            c46693a.nBO.setVisibility(4);
        }
        AppMethodBeat.m2505o(34799);
        return inflate;
    }

    /* renamed from: xo */
    private static String m88454xo(int i) {
        AppMethodBeat.m2504i(34800);
        String str;
        if (C4988aa.dop()) {
            str = Integer.toString(i) + "劃";
            AppMethodBeat.m2505o(34800);
            return str;
        }
        str = String.valueOf((char) i);
        AppMethodBeat.m2505o(34800);
        return str;
    }
}

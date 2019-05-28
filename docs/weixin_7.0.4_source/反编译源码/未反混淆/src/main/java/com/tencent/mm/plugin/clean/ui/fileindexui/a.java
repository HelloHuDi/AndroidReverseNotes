package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.List;

public final class a extends BaseAdapter {
    private List<c> dataList;
    HashSet<Integer> jur = new HashSet();
    CleanChattingUI kxj;

    class a {
        ImageView ejo;
        TextView gnB;
        TextView gnC;
        CheckBox gnD;
        RelativeLayout juu;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(18745);
        c tu = tu(i);
        AppMethodBeat.o(18745);
        return tu;
    }

    public a(CleanChattingUI cleanChattingUI, List<c> list) {
        AppMethodBeat.i(18740);
        this.kxj = cleanChattingUI;
        this.dataList = list;
        AppMethodBeat.o(18740);
    }

    public final int getCount() {
        AppMethodBeat.i(18741);
        int size = this.dataList.size();
        AppMethodBeat.o(18741);
        return size;
    }

    public final c tu(int i) {
        AppMethodBeat.i(18742);
        if (i < 0 || i >= this.dataList.size()) {
            AppMethodBeat.o(18742);
            return null;
        }
        c cVar = (c) this.dataList.get(i);
        AppMethodBeat.o(18742);
        return cVar;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(18743);
        if (view == null) {
            view = this.kxj.getLayoutInflater().inflate(R.layout.ok, viewGroup, false);
            a aVar2 = new a();
            aVar2.ejo = (ImageView) view.findViewById(R.id.qk);
            aVar2.gnB = (TextView) view.findViewById(R.id.qm);
            aVar2.gnC = (TextView) view.findViewById(R.id.ld);
            aVar2.gnD = (CheckBox) view.findViewById(R.id.a1b);
            aVar2.juu = (RelativeLayout) view.findViewById(R.id.a1a);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.juu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18739);
                if (a.this.jur.contains(Integer.valueOf(i))) {
                    a.this.jur.remove(Integer.valueOf(i));
                } else {
                    a.this.jur.add(Integer.valueOf(i));
                }
                a.this.notifyDataSetChanged();
                a.this.kxj.a(a.this.jur);
                AppMethodBeat.o(18739);
            }
        });
        c tu = tu(i);
        if (tu == null) {
            ab.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", Integer.valueOf(i));
            tu = new c();
            tu.size = 0;
            tu.username = "";
        }
        b.b(aVar.ejo, tu.username);
        aVar.gnB.setText(bo.ga(tu.size));
        if (t.kH(tu.username)) {
            aVar.gnC.setText(j.b(this.kxj, s.getDisplayName(tu.username, tu.username), aVar.gnC.getTextSize()));
        } else {
            aVar.gnC.setText(j.b(this.kxj, s.mJ(tu.username), aVar.gnC.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            aVar.gnD.setChecked(true);
        } else {
            aVar.gnD.setChecked(false);
        }
        AppMethodBeat.o(18743);
        return view;
    }

    public final void bgh() {
        AppMethodBeat.i(18744);
        this.jur.clear();
        this.kxj.a(this.jur);
        AppMethodBeat.o(18744);
    }
}

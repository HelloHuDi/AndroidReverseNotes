package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends j {
    private int nLh = 8;
    private ArrayList<String> nLi = new ArrayList();

    class a {
        ImageView gvq;
        TextView nLj;

        a() {
        }
    }

    public a() {
        AppMethodBeat.i(113418);
        AppMethodBeat.o(113418);
    }

    public final void F(ArrayList<String> arrayList) {
        boolean z;
        AppMethodBeat.i(113419);
        this.nLi.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.nLi.add((String) it.next());
        }
        String str = "MicroMsg.MMGridPaperAdapter";
        String str2 = "notifyDataSetChange, notifier is null ? %B";
        Object[] objArr = new Object[1];
        if (this.yvb == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.yvb == null) {
            AppMethodBeat.o(113419);
            return;
        }
        this.yvb.aWv();
        AppMethodBeat.o(113419);
    }

    public final int getCount() {
        AppMethodBeat.i(113420);
        int size = this.nLi.size();
        AppMethodBeat.o(113420);
        return size;
    }

    public final View d(int i, View view) {
        AppMethodBeat.i(113421);
        a aVar = new a();
        if (view == null) {
            view = View.inflate(ah.getContext(), R.layout.f4, null);
            aVar.gvq = (ImageView) view.findViewById(R.id.a0a);
            aVar.nLj = (TextView) view.findViewById(R.id.a0b);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = (String) this.nLi.get(i);
        b.b(aVar.gvq, str);
        CharSequence mJ = s.mJ(str);
        if (mJ.length() > this.nLh) {
            mJ = mJ.subSequence(0, this.nLh + 1) + "...";
        }
        aVar.nLj.setText(mJ);
        AppMethodBeat.o(113421);
        return view;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(113422);
        Object obj = this.nLi.get(i);
        AppMethodBeat.o(113422);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}

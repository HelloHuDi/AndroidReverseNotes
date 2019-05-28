package com.tencent.p177mm.plugin.location.p446ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p612ui.base.C30392j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.location.ui.a */
public final class C39290a extends C30392j {
    private int nLh = 8;
    private ArrayList<String> nLi = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.location.ui.a$a */
    class C39289a {
        ImageView gvq;
        TextView nLj;

        C39289a() {
        }
    }

    public C39290a() {
        AppMethodBeat.m2504i(113418);
        AppMethodBeat.m2505o(113418);
    }

    /* renamed from: F */
    public final void mo62192F(ArrayList<String> arrayList) {
        boolean z;
        AppMethodBeat.m2504i(113419);
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
        C4990ab.m7417i(str, str2, objArr);
        if (this.yvb == null) {
            AppMethodBeat.m2505o(113419);
            return;
        }
        this.yvb.aWv();
        AppMethodBeat.m2505o(113419);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(113420);
        int size = this.nLi.size();
        AppMethodBeat.m2505o(113420);
        return size;
    }

    /* renamed from: d */
    public final View mo48755d(int i, View view) {
        AppMethodBeat.m2504i(113421);
        C39289a c39289a = new C39289a();
        if (view == null) {
            view = View.inflate(C4996ah.getContext(), 2130968791, null);
            c39289a.gvq = (ImageView) view.findViewById(2131821555);
            c39289a.nLj = (TextView) view.findViewById(2131821556);
            view.setTag(c39289a);
        } else {
            c39289a = (C39289a) view.getTag();
        }
        String str = (String) this.nLi.get(i);
        C40460b.m69434b(c39289a.gvq, str);
        CharSequence mJ = C1854s.m3866mJ(str);
        if (mJ.length() > this.nLh) {
            mJ = mJ.subSequence(0, this.nLh + 1) + "...";
        }
        c39289a.nLj.setText(mJ);
        AppMethodBeat.m2505o(113421);
        return view;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(113422);
        Object obj = this.nLi.get(i);
        AppMethodBeat.m2505o(113422);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}

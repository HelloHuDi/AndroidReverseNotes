package com.tencent.p177mm.plugin.clean.p364ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.a */
public final class C33825a extends BaseAdapter {
    private List<C27654c> dataList;
    HashSet<Integer> jur = new HashSet();
    CleanChattingUI kxj;

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.a$a */
    class C33827a {
        ImageView ejo;
        TextView gnB;
        TextView gnC;
        CheckBox gnD;
        RelativeLayout juu;

        C33827a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(18745);
        C27654c tu = mo54384tu(i);
        AppMethodBeat.m2505o(18745);
        return tu;
    }

    public C33825a(CleanChattingUI cleanChattingUI, List<C27654c> list) {
        AppMethodBeat.m2504i(18740);
        this.kxj = cleanChattingUI;
        this.dataList = list;
        AppMethodBeat.m2505o(18740);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(18741);
        int size = this.dataList.size();
        AppMethodBeat.m2505o(18741);
        return size;
    }

    /* renamed from: tu */
    public final C27654c mo54384tu(int i) {
        AppMethodBeat.m2504i(18742);
        if (i < 0 || i >= this.dataList.size()) {
            AppMethodBeat.m2505o(18742);
            return null;
        }
        C27654c c27654c = (C27654c) this.dataList.get(i);
        AppMethodBeat.m2505o(18742);
        return c27654c;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C33827a c33827a;
        AppMethodBeat.m2504i(18743);
        if (view == null) {
            view = this.kxj.getLayoutInflater().inflate(2130969143, viewGroup, false);
            C33827a c33827a2 = new C33827a();
            c33827a2.ejo = (ImageView) view.findViewById(2131821183);
            c33827a2.gnB = (TextView) view.findViewById(2131821185);
            c33827a2.gnC = (TextView) view.findViewById(2131820991);
            c33827a2.gnD = (CheckBox) view.findViewById(2131821593);
            c33827a2.juu = (RelativeLayout) view.findViewById(2131821592);
            view.setTag(c33827a2);
            c33827a = c33827a2;
        } else {
            c33827a = (C33827a) view.getTag();
        }
        c33827a.juu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(18739);
                if (C33825a.this.jur.contains(Integer.valueOf(i))) {
                    C33825a.this.jur.remove(Integer.valueOf(i));
                } else {
                    C33825a.this.jur.add(Integer.valueOf(i));
                }
                C33825a.this.notifyDataSetChanged();
                C33825a.this.kxj.mo35479a(C33825a.this.jur);
                AppMethodBeat.m2505o(18739);
            }
        });
        C27654c tu = mo54384tu(i);
        if (tu == null) {
            C4990ab.m7413e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", Integer.valueOf(i));
            tu = new C27654c();
            tu.size = 0;
            tu.username = "";
        }
        C40460b.m69434b(c33827a.ejo, tu.username);
        c33827a.gnB.setText(C5046bo.m7565ga(tu.size));
        if (C1855t.m3896kH(tu.username)) {
            c33827a.gnC.setText(C44089j.m79293b(this.kxj, C1854s.getDisplayName(tu.username, tu.username), c33827a.gnC.getTextSize()));
        } else {
            c33827a.gnC.setText(C44089j.m79293b(this.kxj, C1854s.m3866mJ(tu.username), c33827a.gnC.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            c33827a.gnD.setChecked(true);
        } else {
            c33827a.gnD.setChecked(false);
        }
        AppMethodBeat.m2505o(18743);
        return view;
    }

    public final void bgh() {
        AppMethodBeat.m2504i(18744);
        this.jur.clear();
        this.kxj.mo35479a(this.jur);
        AppMethodBeat.m2505o(18744);
    }
}

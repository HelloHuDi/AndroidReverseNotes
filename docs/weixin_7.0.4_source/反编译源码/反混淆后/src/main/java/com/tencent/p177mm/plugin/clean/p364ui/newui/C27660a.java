package com.tencent.p177mm.plugin.clean.p364ui.newui;

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
import com.tencent.p177mm.plugin.clean.p362c.C27641b;
import com.tencent.p177mm.plugin.clean.p362c.C27642d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.clean.ui.newui.a */
public final class C27660a extends BaseAdapter {
    HashSet<Integer> jur = new HashSet();
    CleanChattingUI kyF;

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.a$a */
    class C11411a {
        ImageView ejo;
        TextView gnB;
        TextView gnC;
        CheckBox gnD;
        RelativeLayout juu;

        C11411a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(18846);
        C27641b ty = C27660a.m43956ty(i);
        AppMethodBeat.m2505o(18846);
        return ty;
    }

    public C27660a(CleanChattingUI cleanChattingUI) {
        AppMethodBeat.m2504i(18841);
        this.kyF = cleanChattingUI;
        AppMethodBeat.m2505o(18841);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(18842);
        ArrayList bfS = C27642d.bfS();
        if (bfS != null) {
            int size = bfS.size();
            AppMethodBeat.m2505o(18842);
            return size;
        }
        AppMethodBeat.m2505o(18842);
        return 0;
    }

    /* renamed from: ty */
    private static C27641b m43956ty(int i) {
        AppMethodBeat.m2504i(18843);
        C27641b c27641b = (C27641b) C27642d.bfS().get(i);
        AppMethodBeat.m2505o(18843);
        return c27641b;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C11411a c11411a;
        AppMethodBeat.m2504i(18844);
        if (view == null) {
            view = this.kyF.getLayoutInflater().inflate(2130969143, viewGroup, false);
            C11411a c11411a2 = new C11411a();
            c11411a2.ejo = (ImageView) view.findViewById(2131821183);
            c11411a2.gnB = (TextView) view.findViewById(2131821185);
            c11411a2.gnC = (TextView) view.findViewById(2131820991);
            c11411a2.gnD = (CheckBox) view.findViewById(2131821593);
            c11411a2.juu = (RelativeLayout) view.findViewById(2131821592);
            view.setTag(c11411a2);
            c11411a = c11411a2;
        } else {
            c11411a = (C11411a) view.getTag();
        }
        c11411a.juu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(18840);
                if (C27660a.this.jur.contains(Integer.valueOf(i))) {
                    C27660a.this.jur.remove(Integer.valueOf(i));
                } else {
                    C27660a.this.jur.add(Integer.valueOf(i));
                }
                C27660a.this.notifyDataSetChanged();
                C27660a.this.kyF.mo68427a(C27660a.this.jur);
                AppMethodBeat.m2505o(18840);
            }
        });
        C27641b ty = C27660a.m43956ty(i);
        C40460b.m69434b(c11411a.ejo, ty.username);
        c11411a.gnB.setText(C5046bo.m7565ga(ty.jrb));
        if (C1855t.m3896kH(ty.username)) {
            c11411a.gnC.setText(C44089j.m79293b(this.kyF, C1854s.getDisplayName(ty.username, ty.username), c11411a.gnC.getTextSize()));
        } else {
            c11411a.gnC.setText(C44089j.m79293b(this.kyF, C1854s.m3866mJ(ty.username), c11411a.gnC.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            c11411a.gnD.setChecked(true);
        } else {
            c11411a.gnD.setChecked(false);
        }
        AppMethodBeat.m2505o(18844);
        return view;
    }

    public final void bgh() {
        AppMethodBeat.m2504i(18845);
        this.jur.clear();
        this.kyF.mo68427a(this.jur);
        AppMethodBeat.m2505o(18845);
    }
}

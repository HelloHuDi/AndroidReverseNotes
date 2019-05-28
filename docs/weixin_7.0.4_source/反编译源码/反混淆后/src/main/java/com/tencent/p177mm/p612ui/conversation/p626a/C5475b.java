package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.pluginsdk.p1080h.p1081a.C14859a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.conversation.a.b */
public final class C5475b extends C46692p<C15860c> {
    private ArrayList<C15860c> gHf = new ArrayList();
    C14859a zvR = null;

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        return null;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(34642);
        C15860c Pz = mo11109Pz(i);
        AppMethodBeat.m2505o(34642);
        return Pz;
    }

    public C5475b(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(34636);
        mo6870KD();
        AppMethodBeat.m2505o(34636);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(34637);
        mo6869KC();
        AppMethodBeat.m2505o(34637);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(34638);
        this.gHf.clear();
        if (this.zvR == null) {
            AppMethodBeat.m2505o(34638);
            return;
        }
        this.gHf.add(new C15860c(this.zvR));
        notifyDataSetChanged();
        AppMethodBeat.m2505o(34638);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(34639);
        int size = this.gHf.size();
        AppMethodBeat.m2505o(34639);
        return size;
    }

    /* renamed from: Pz */
    public final C15860c mo11109Pz(int i) {
        AppMethodBeat.m2504i(34640);
        C15860c c15860c = (C15860c) this.gHf.get(i);
        AppMethodBeat.m2505o(34640);
        return c15860c;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C5476d c5476d;
        AppMethodBeat.m2504i(34641);
        C15860c c15860c = (C15860c) this.gHf.get(i);
        if (view == null) {
            view = View.inflate(this.context, 2130968644, null);
            C5476d c5476d2 = new C5476d();
            c5476d2.zvT = view;
            c5476d2.zvU = (Button) view.findViewById(2131821093);
            view.setTag(c5476d2);
            c5476d = c5476d2;
        } else {
            c5476d = (C5476d) view.getTag();
        }
        if (c15860c.mo28098a(c5476d) != 0) {
            AppMethodBeat.m2505o(34641);
            return null;
        }
        AppMethodBeat.m2505o(34641);
        return view;
    }
}

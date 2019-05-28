package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.e */
public final class C46052e extends BaseAdapter {
    byte[] buffer = null;
    private Context context = null;
    boolean eTf = false;
    boolean gxV = false;
    String kPJ = "";
    String key = "";
    int llU = 0;
    boolean nPV = false;
    List<C43245f> nQk = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.e$a */
    static class C39294a {
        TextView iKA;
        TextView nQl;
        ImageView nQm;
        View nQn;
        View nQo;
        TextView titleView;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(113666);
        C43245f xG = mo73961xG(i);
        AppMethodBeat.m2505o(113666);
        return xG;
    }

    public C46052e(Context context) {
        AppMethodBeat.m2504i(113656);
        this.context = context;
        AppMethodBeat.m2505o(113656);
    }

    public final void clean() {
        AppMethodBeat.m2504i(113657);
        this.buffer = null;
        this.eTf = false;
        this.key = "";
        this.nQk.clear();
        AppMethodBeat.m2505o(113657);
    }

    public final void bKy() {
        this.buffer = null;
        this.eTf = false;
        this.key = "";
    }

    /* renamed from: Qb */
    public final void mo73951Qb(String str) {
        AppMethodBeat.m2504i(113658);
        this.key = str;
        C4990ab.m7417i("MicroMsg.PoiAdapter", "initdata key %s", str);
        AppMethodBeat.m2505o(113658);
    }

    /* renamed from: b */
    public final void mo73953b(C43245f c43245f) {
        AppMethodBeat.m2504i(113659);
        if (this.nQk.size() >= 0) {
            this.nQk.add(0, c43245f);
            notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(113659);
    }

    /* renamed from: a */
    public final void mo73952a(List<C43245f> list, byte[] bArr, boolean z, String str) {
        AppMethodBeat.m2504i(113660);
        if (this.key == null || !this.key.equals(str)) {
            C4990ab.m7417i("MicroMsg.PoiAdapter", "old key come pass it %s %s", this.key, str);
            AppMethodBeat.m2505o(113660);
            return;
        }
        int size = this.nQk.size();
        int i = size;
        for (C43245f c43245f : list) {
            c43245f.nQC = i;
            i++;
            this.nQk.add(c43245f);
        }
        this.buffer = bArr;
        this.eTf = z;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(113660);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(113661);
        int size = this.nQk.size();
        AppMethodBeat.m2505o(113661);
        return size;
    }

    /* renamed from: xG */
    public final C43245f mo73961xG(int i) {
        AppMethodBeat.m2504i(113662);
        C43245f c43245f = (C43245f) this.nQk.get(i);
        AppMethodBeat.m2505o(113662);
        return c43245f;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C39294a c39294a;
        AppMethodBeat.m2504i(113663);
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(2130970368, null);
            c39294a = new C39294a();
            c39294a.titleView = (TextView) view.findViewById(2131820678);
            c39294a.nQl = (TextView) view.findViewById(2131821920);
            c39294a.nQm = (ImageView) view.findViewById(2131826557);
            c39294a.nQo = view.findViewById(2131826559);
            c39294a.nQn = view.findViewById(2131826558);
            c39294a.iKA = (TextView) view.findViewById(2131826560);
            view.setTag(c39294a);
        } else {
            c39294a = (C39294a) view.getTag();
        }
        if (((C43245f) this.nQk.get(i)).type == 1 || ((C43245f) this.nQk.get(i)).type == 2) {
            c39294a.nQo.setVisibility(0);
            c39294a.nQn.setVisibility(8);
            c39294a.iKA.setText(C5046bo.m7532bc(((C43245f) this.nQk.get(i)).nQp, ""));
        } else {
            c39294a.nQo.setVisibility(8);
            c39294a.nQn.setVisibility(0);
        }
        if (i != 0 || this.gxV) {
            CharSequence Qc;
            C43245f c43245f = (C43245f) this.nQk.get(i);
            String bc = C5046bo.m7532bc(c43245f.mName, "");
            CharSequence bc2 = C5046bo.m7532bc(c43245f.nQp, "");
            if (!this.gxV || C5046bo.isNullOrNil(this.kPJ)) {
                Object Qc2 = bc;
            } else {
                Qc2 = m85773Qc(bc);
                bc2 = m85773Qc(bc2);
            }
            c39294a.titleView.setText(Qc2);
            c39294a.nQl.setText(bc2);
            c39294a.nQl.setVisibility(0);
        } else if (this.nPV) {
            c39294a.titleView.setText(C5046bo.m7532bc(((C43245f) this.nQk.get(0)).mName, ""));
            c39294a.nQl.setVisibility(0);
            c39294a.nQl.setText(C5046bo.m7532bc(((C43245f) this.nQk.get(0)).nQp, ""));
        } else {
            c39294a.nQl.setVisibility(8);
            if (!C5046bo.isNullOrNil(((C43245f) this.nQk.get(0)).nQp)) {
                c39294a.titleView.setText(C5046bo.m7532bc(((C43245f) this.nQk.get(i)).nQp, ""));
            } else if (C5046bo.isNullOrNil(((C43245f) this.nQk.get(0)).nQy)) {
                c39294a.titleView.setText(C5046bo.m7532bc(((C43245f) this.nQk.get(i)).mName, ""));
            } else {
                c39294a.titleView.setText(C5046bo.m7532bc(((C43245f) this.nQk.get(i)).nQy, ""));
            }
        }
        if (i == this.llU) {
            c39294a.nQm.setVisibility(0);
        } else {
            c39294a.nQm.setVisibility(4);
        }
        AppMethodBeat.m2505o(113663);
        return view;
    }

    /* renamed from: Qc */
    private Spannable m85773Qc(String str) {
        AppMethodBeat.m2504i(113664);
        Spannable a = C34204f.m56084a((CharSequence) str, this.kPJ);
        AppMethodBeat.m2505o(113664);
        return a;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(113665);
        super.notifyDataSetChanged();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        C4990ab.m7416i("MicroMsg.PoiAdapter", "map notifyDataChange " + C5046bo.dpG().toString() + " threadId : " + Thread.currentThread().getId());
        AppMethodBeat.m2505o(113665);
    }
}

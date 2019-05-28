package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C45497g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.plugin.account.ui.d */
final class C33040d extends C46692p<C45497g> {
    C18961a gBa;
    private int[] gty;
    private String gtz;

    /* renamed from: com.tencent.mm.plugin.account.ui.d$a */
    public interface C18961a {
        /* renamed from: mT */
        void mo30539mT(int i);
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.d$b */
    static class C26653b {
        ImageView eks;
        TextView gBb;
        TextView gBc;
        ImageView gBd;
        TextView gtG;
        TextView gvr;

        C26653b() {
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(124806);
        C45497g c45497g = (C45497g) obj;
        if (c45497g == null) {
            c45497g = new C45497g();
        }
        c45497g.mo73290d(cursor);
        AppMethodBeat.m2505o(124806);
        return c45497g;
    }

    public C33040d(Context context, C30723a c30723a) {
        super(context, new C45497g());
        AppMethodBeat.m2504i(124801);
        super.mo74992a(c30723a);
        AppMethodBeat.m2505o(124801);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(124802);
        mo6869KC();
        AppMethodBeat.m2505o(124802);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(124803);
        setCursor(C32923a.getFacebookFrdStg().mo34098wa(this.gtz));
        this.gty = new int[getCount()];
        if (!(this.gBa == null || this.gtz == null)) {
            this.gBa.mo30539mT(getCursor().getCount());
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(124803);
    }

    /* renamed from: vM */
    public final void mo53600vM(String str) {
        AppMethodBeat.m2504i(124804);
        this.gtz = C5046bo.m7586vA(str.trim());
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(124804);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C26653b c26653b;
        AppMethodBeat.m2504i(124805);
        C45497g c45497g = (C45497g) getItem(i);
        if (view == null) {
            c26653b = new C26653b();
            view = View.inflate(this.context, 2130969483, null);
            c26653b.eks = (ImageView) view.findViewById(2131823840);
            c26653b.gtG = (TextView) view.findViewById(2131823841);
            c26653b.gvr = (TextView) view.findViewById(2131823844);
            c26653b.gBb = (TextView) view.findViewById(2131823842);
            c26653b.gBc = (TextView) view.findViewById(2131823843);
            c26653b.gBd = (ImageView) view.findViewById(2131823845);
            view.setTag(c26653b);
        } else {
            c26653b = (C26653b) view.getTag();
        }
        c26653b.gtG.setText(C44089j.m79293b(this.context, c45497g.apL(), c26653b.gtG.getTextSize()));
        c26653b.gBc.setVisibility(8);
        c26653b.gBd.setVisibility(0);
        switch (this.gty[i]) {
            case 0:
                if (c45497g.status == 102 || ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(c45497g.getUsername())) {
                    if (c45497g.status != 102) {
                        c26653b.gvr.setVisibility(0);
                        c26653b.gvr.setText(C25738R.string.c11);
                        c26653b.gvr.setTextColor(this.context.getResources().getColor(C25738R.color.f11709e_));
                        c26653b.gBb.setVisibility(8);
                        break;
                    }
                    c26653b.gvr.setVisibility(8);
                    c26653b.gBb.setVisibility(8);
                    c26653b.gBd.setVisibility(8);
                    break;
                }
                c26653b.gvr.setVisibility(8);
                c26653b.gBb.setVisibility(0);
                break;
                break;
            case 2:
                c26653b.gBb.setVisibility(8);
                c26653b.gvr.setVisibility(0);
                c26653b.gvr.setText(C25738R.string.c15);
                c26653b.gvr.setTextColor(this.context.getResources().getColor(C25738R.color.f11710ea));
                break;
        }
        Bitmap pS = C41730b.m73500pS(c45497g.dtU);
        if (pS == null) {
            c26653b.eks.setImageDrawable(C1338a.m2864g(this.context, C1318a.default_avatar));
        } else {
            c26653b.eks.setImageBitmap(pS);
        }
        AppMethodBeat.m2505o(124805);
        return view;
    }
}

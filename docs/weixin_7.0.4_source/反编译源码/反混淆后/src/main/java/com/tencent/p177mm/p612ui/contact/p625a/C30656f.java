package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.contact.a.f */
public class C30656f extends C5445a {
    public CharSequence gnx;
    public String username;
    public CharSequence zpU;
    public int zpV = 0;
    private C30658b zpW = new C30658b();
    C30657a zpX = new C30657a();

    /* renamed from: com.tencent.mm.ui.contact.a.f$a */
    public class C30657a extends C5446a {
        public ImageView ejo;
        public TextView ejp;
        public TextView gnC;
        public CheckBox gnD;

        public C30657a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.f$b */
    public class C30658b extends C5447b {
        public C30658b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.m2504i(105285);
            if (C1338a.m2865ga(context)) {
                inflate = LayoutInflater.from(context).inflate(2130970606, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(2130970605, viewGroup, false);
            }
            C30657a c30657a = C30656f.this.zpX;
            c30657a.ejo = (ImageView) inflate.findViewById(2131821183);
            c30657a.ejp = (TextView) inflate.findViewById(2131821185);
            c30657a.gnC = (TextView) inflate.findViewById(2131820991);
            c30657a.gnC.setVisibility(8);
            c30657a.gnD = (CheckBox) inflate.findViewById(2131821593);
            inflate.setTag(c30657a);
            AppMethodBeat.m2505o(105285);
            return inflate;
        }

        /* renamed from: a */
        public void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105286);
            C30656f c30656f = (C30656f) c5445a;
            C30657a c30657a = (C30657a) c5446a;
            c30657a.ejp.setCompoundDrawables(null, null, null, null);
            if (C30656f.this.zpV == 0 || C30656f.this.zpU == null) {
                C3201m.m5501a(c30656f.gnx, c30657a.ejp);
                if (C7616ad.aox(c30656f.username)) {
                    C1720g.m3537RQ();
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c30656f.username);
                    ((C32873b) C1720g.m3528K(C32873b.class)).mo44302a(context, c30657a.ejp, c30656f.gnx, aoO.field_openImAppid, aoO.field_descWordingId, (int) c30657a.ejp.getTextSize());
                }
                C40460b.m69434b(c30657a.ejo, c30656f.username);
                if (C1855t.m3903mP(c30656f.username)) {
                    Drawable drawable = context.getResources().getDrawable(C1318a.open_im_main_logo);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    c30657a.ejp.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                } else {
                    c30657a.ejp.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                }
                if (C30656f.this.zmW) {
                    if (z) {
                        c30657a.gnD.setChecked(true);
                        c30657a.gnD.setEnabled(false);
                    } else {
                        c30657a.gnD.setChecked(z2);
                        c30657a.gnD.setEnabled(true);
                    }
                    c30657a.gnD.setVisibility(0);
                    AppMethodBeat.m2505o(105286);
                    return;
                }
                c30657a.gnD.setVisibility(8);
                AppMethodBeat.m2505o(105286);
                return;
            }
            c30657a.ejo.setImageResource(C30656f.this.zpV);
            c30657a.ejp.setText(C30656f.this.zpU);
            AppMethodBeat.m2505o(105286);
        }

        public final boolean aov() {
            return false;
        }
    }

    public C30656f(int i) {
        super(4, i);
        AppMethodBeat.m2504i(105287);
        AppMethodBeat.m2505o(105287);
    }

    /* renamed from: a */
    public void mo11082a(Context context, C5446a c5446a) {
        AppMethodBeat.m2504i(105288);
        if (this.zpV != 0 && this.zpU != null) {
            AppMethodBeat.m2505o(105288);
        } else if (this.ehM == null) {
            this.gnx = "";
            this.username = "";
            AppMethodBeat.m2505o(105288);
        } else {
            this.gnx = C44089j.m79294b(context, ((C34530b) C1720g.m3528K(C34530b.class)).mo55063c(this.ehM), C1338a.m2856al(context, C25738R.dimen.f9980m5));
            this.username = this.ehM.field_username;
            AppMethodBeat.m2505o(105288);
        }
    }

    public C5447b aou() {
        return this.zpW;
    }
}

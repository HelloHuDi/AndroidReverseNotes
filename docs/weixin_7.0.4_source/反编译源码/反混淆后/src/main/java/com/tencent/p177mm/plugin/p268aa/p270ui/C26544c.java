package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.aa.ui.c */
public final class C26544c extends C5445a {
    private static final Pattern gnw = Pattern.compile(",");
    C9825a gnA = new C9825a();
    public CharSequence gnx;
    public CharSequence gny;
    private C26545b gnz = new C26545b();
    public String username;

    /* renamed from: com.tencent.mm.plugin.aa.ui.c$a */
    public class C9825a extends C5446a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        public CheckBox gnD;

        public C9825a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.c$b */
    public class C26545b extends C5447b {
        public C26545b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.m2504i(40743);
            if (C1338a.m2865ga(context)) {
                inflate = LayoutInflater.from(context).inflate(2130970606, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(2130970605, viewGroup, false);
            }
            C9825a c9825a = C26544c.this.gnA;
            c9825a.ejo = (ImageView) inflate.findViewById(2131821183);
            c9825a.gnB = (TextView) inflate.findViewById(2131821185);
            c9825a.gnC = (TextView) inflate.findViewById(2131820991);
            c9825a.contentView = inflate.findViewById(2131826213);
            c9825a.gnD = (CheckBox) inflate.findViewById(2131821593);
            LayoutParams layoutParams = (LayoutParams) c9825a.gnD.getLayoutParams();
            layoutParams.leftMargin = context.getResources().getDimensionPixelSize(C25738R.dimen.f10064oz);
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(C25738R.dimen.f10065p0);
            c9825a.gnD.setLayoutParams(layoutParams);
            inflate.setTag(c9825a);
            AppMethodBeat.m2505o(40743);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(40744);
            C9825a c9825a = (C9825a) c5446a;
            C26544c c26544c = (C26544c) c5445a;
            if (c26544c.username == null || c26544c.username.length() <= 0) {
                c9825a.ejo.setImageResource(C25738R.drawable.ad2);
            } else {
                C40460b.m69433a(c9825a.ejo, c26544c.username, 0.1f, false);
            }
            if (C5046bo.m7519ac(c26544c.gnx)) {
                c9825a.gnB.setVisibility(8);
            } else {
                c9825a.gnB.setText(c26544c.gnx);
                c9825a.gnB.setVisibility(0);
            }
            if (C5046bo.m7519ac(c26544c.gny)) {
                c9825a.gnC.setVisibility(8);
            } else {
                c9825a.gnC.setText(c26544c.gny);
                c9825a.gnC.setVisibility(0);
            }
            if (C26544c.this.zmW) {
                if (z) {
                    c9825a.gnD.setChecked(true);
                    c9825a.gnD.setEnabled(false);
                } else {
                    c9825a.gnD.setChecked(z2);
                    c9825a.gnD.setEnabled(true);
                }
                c9825a.gnD.setVisibility(0);
            } else {
                c9825a.gnD.setVisibility(8);
            }
            if (C26544c.this.jLx) {
                c9825a.contentView.setBackgroundResource(C25738R.drawable.f6625k7);
            } else {
                c9825a.contentView.setBackgroundResource(C25738R.drawable.f6623k5);
            }
            if (c26544c.ehM.field_deleteFlag == 1) {
                c9825a.gnC.setVisibility(0);
                c9825a.gnC.setText(context.getString(C25738R.string.f8640an));
            }
            AppMethodBeat.m2505o(40744);
        }

        public final boolean aov() {
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(40747);
        AppMethodBeat.m2505o(40747);
    }

    public C26544c(int i) {
        super(2, i);
        AppMethodBeat.m2504i(40745);
        AppMethodBeat.m2505o(40745);
    }

    public final C5447b aou() {
        return this.gnz;
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        AppMethodBeat.m2504i(40746);
        if (this.ehM == null) {
            C4990ab.m7417i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.m2505o(40746);
            return;
        }
        CharSequence c;
        this.username = this.ehM.field_username;
        if (C5046bo.isNullOrNil(this.cuP)) {
            c = ((C34530b) C1720g.m3528K(C34530b.class)).mo55063c(this.ehM);
        } else {
            c = ((C34530b) C1720g.m3528K(C34530b.class)).getDisplayName(this.ehM.field_username, this.cuP);
        }
        if (C1853r.m3846Yz().equals(this.username)) {
            c = c + context.getString(C25738R.string.f8671bl);
        }
        this.gnx = C44089j.m79294b(context, c, C1338a.m2856al(context, C25738R.dimen.f9980m5));
        AppMethodBeat.m2505o(40746);
    }
}

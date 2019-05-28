package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Pattern;

public final class c extends com.tencent.mm.ui.contact.a.a {
    private static final Pattern gnw = Pattern.compile(",");
    a gnA = new a();
    public CharSequence gnx;
    public CharSequence gny;
    private b gnz = new b();
    public String username;

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        public CheckBox gnD;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(40743);
            if (com.tencent.mm.bz.a.ga(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar1, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar0, viewGroup, false);
            }
            a aVar = c.this.gnA;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.contentView = inflate.findViewById(R.id.de9);
            aVar.gnD = (CheckBox) inflate.findViewById(R.id.a1b);
            LayoutParams layoutParams = (LayoutParams) aVar.gnD.getLayoutParams();
            layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.oz);
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.p0);
            aVar.gnD.setLayoutParams(layoutParams);
            inflate.setTag(aVar);
            AppMethodBeat.o(40743);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(40744);
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.ejo.setImageResource(R.drawable.ad2);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ejo, cVar.username, 0.1f, false);
            }
            if (bo.ac(cVar.gnx)) {
                aVar3.gnB.setVisibility(8);
            } else {
                aVar3.gnB.setText(cVar.gnx);
                aVar3.gnB.setVisibility(0);
            }
            if (bo.ac(cVar.gny)) {
                aVar3.gnC.setVisibility(8);
            } else {
                aVar3.gnC.setText(cVar.gny);
                aVar3.gnC.setVisibility(0);
            }
            if (c.this.zmW) {
                if (z) {
                    aVar3.gnD.setChecked(true);
                    aVar3.gnD.setEnabled(false);
                } else {
                    aVar3.gnD.setChecked(z2);
                    aVar3.gnD.setEnabled(true);
                }
                aVar3.gnD.setVisibility(0);
            } else {
                aVar3.gnD.setVisibility(8);
            }
            if (c.this.jLx) {
                aVar3.contentView.setBackgroundResource(R.drawable.k7);
            } else {
                aVar3.contentView.setBackgroundResource(R.drawable.k5);
            }
            if (cVar.ehM.field_deleteFlag == 1) {
                aVar3.gnC.setVisibility(0);
                aVar3.gnC.setText(context.getString(R.string.an));
            }
            AppMethodBeat.o(40744);
        }

        public final boolean aov() {
            return false;
        }
    }

    static {
        AppMethodBeat.i(40747);
        AppMethodBeat.o(40747);
    }

    public c(int i) {
        super(2, i);
        AppMethodBeat.i(40745);
        AppMethodBeat.o(40745);
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.gnz;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        AppMethodBeat.i(40746);
        if (this.ehM == null) {
            ab.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.o(40746);
            return;
        }
        CharSequence c;
        this.username = this.ehM.field_username;
        if (bo.isNullOrNil(this.cuP)) {
            c = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).c(this.ehM);
        } else {
            c = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.ehM.field_username, this.cuP);
        }
        if (r.Yz().equals(this.username)) {
            c = c + context.getString(R.string.bl);
        }
        this.gnx = j.b(context, c, com.tencent.mm.bz.a.al(context, R.dimen.m5));
        AppMethodBeat.o(40746);
    }
}

package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.se;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.bo;

public final class d extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence eoj;
    public l hpS;
    public AppBrandRecentTaskInfo hpT;
    private b hpU = new b();
    a hpV = new a();

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(129970);
            View inflate = LayoutInflater.from(context).inflate(R.layout.c5, viewGroup, false);
            a aVar = d.this.hpV;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.contentView = inflate.findViewById(R.id.qj);
            aVar.hpW = (TextView) inflate.findViewById(R.id.qn);
            aVar.hpX = (TextView) inflate.findViewById(R.id.pr);
            inflate.setTag(aVar);
            AppMethodBeat.o(129970);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(129971);
            d dVar = (d) aVar2;
            a aVar3 = (a) aVar;
            if (dVar.hpT == null) {
                aVar3.contentView.setVisibility(8);
                AppMethodBeat.o(129971);
                return;
            }
            aVar3.contentView.setVisibility(0);
            aVar3.gnB.setText(d.this.eoj);
            String no = com.tencent.mm.plugin.appbrand.appcache.b.no(d.this.hpT.gVs);
            if (bo.isNullOrNil(no)) {
                aVar3.hpX.setVisibility(8);
            } else {
                aVar3.hpX.setText(no);
                aVar3.hpX.setVisibility(0);
            }
            com.tencent.mm.modelappbrand.a.b.abR().a(aVar3.ejo, dVar.hpT.hac, com.tencent.mm.modelappbrand.a.a.abQ(), f.fqH);
            AppMethodBeat.o(129971);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(129972);
            d dVar = (d) aVar;
            se seVar = new se();
            seVar.cOf.userName = dVar.hpT.csl;
            seVar.cOf.cOi = dVar.hpT.gVs;
            seVar.cOf.cOl = true;
            seVar.cOf.scene = 1027;
            com.tencent.mm.sdk.b.a.xxA.m(seVar);
            AppMethodBeat.o(129972);
            return true;
        }
    }

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView hpW;
        public TextView hpX;

        public a() {
            super();
        }
    }

    public d(int i) {
        super(16, i);
        AppMethodBeat.i(129973);
        AppMethodBeat.o(129973);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(129974);
        this.hpT = i.An(this.hpS.mDx);
        if (this.hpT == null) {
            AppMethodBeat.o(129974);
            return;
        }
        boolean z3;
        switch (this.hpS.mDw) {
            case 2:
                break;
            case 3:
                z2 = true;
                break;
            default:
                z = false;
                z3 = false;
                break;
        }
        z3 = z2;
        this.eoj = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.hpT.appName, this.mDz, z, z3)).mDR;
        this.info = this.hpT.csl;
        AppMethodBeat.o(129974);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.hpU;
    }

    public final String aAp() {
        return this.hpT.appName;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}

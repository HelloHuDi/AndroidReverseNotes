package com.tencent.mm.plugin.appbrand.game.b;

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
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class c extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence eoj;
    public l hpS;
    public AppBrandRecentTaskInfo hrc;
    public com.tencent.mm.plugin.appbrand.game.b.a.b hrd;
    private b hre = new b();
    a hrf = new a();

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView hpW;
        public TextView hpX;
        public TextView hrg;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(130077);
            View inflate = LayoutInflater.from(context).inflate(R.layout.acz, viewGroup, false);
            a aVar = c.this.hrf;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.contentView = inflate.findViewById(R.id.qj);
            aVar.hpW = (TextView) inflate.findViewById(R.id.qn);
            aVar.hrg = (TextView) inflate.findViewById(R.id.ld);
            aVar.hpX = (TextView) inflate.findViewById(R.id.pr);
            inflate.setTag(aVar);
            AppMethodBeat.o(130077);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(130078);
            c cVar = (c) aVar2;
            a aVar3 = (a) aVar;
            if (cVar.hrd == null) {
                aVar3.contentView.setVisibility(8);
                AppMethodBeat.o(130078);
                return;
            }
            aVar3.contentView.setVisibility(0);
            aVar3.gnB.setText(c.this.eoj);
            aVar3.hpX.setVisibility(8);
            aVar3.hrg.setVisibility(8);
            aVar3.hpW.setVisibility(8);
            String no;
            if (cVar.hrc != null) {
                no = com.tencent.mm.plugin.appbrand.appcache.b.no(cVar.hrc.gVs);
                if (bo.isNullOrNil(no)) {
                    aVar3.hpX.setVisibility(8);
                } else {
                    aVar3.hpX.setText(no);
                    aVar3.hpX.setVisibility(0);
                }
            } else {
                no = cVar.hrd.field_BriefIntro;
                if (bo.isNullOrNil(no)) {
                    aVar3.hrg.setVisibility(8);
                } else {
                    aVar3.hrg.setText(no);
                    aVar3.hrg.setVisibility(0);
                }
            }
            com.tencent.mm.modelappbrand.a.b.abR().a(aVar3.ejo, cVar.hrd.field_IconUrl, com.tencent.mm.modelappbrand.a.a.abQ(), f.fqH);
            AppMethodBeat.o(130078);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(130079);
            c cVar = (c) aVar;
            se seVar = new se();
            seVar.cOf.userName = cVar.hrd.field_UserName;
            seVar.cOf.cOi = 0;
            if (cVar.hrc != null) {
                seVar.cOf.cOi = cVar.hrc.gVs;
            }
            seVar.cOf.cOl = true;
            seVar.cOf.scene = 1027;
            com.tencent.mm.sdk.b.a.xxA.m(seVar);
            AppMethodBeat.o(130079);
            return true;
        }
    }

    public c(int i) {
        super(20, i);
        AppMethodBeat.i(130080);
        AppMethodBeat.o(130080);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(130081);
        this.hrc = i.At(this.hpS.mDx);
        this.hrd = i.As(this.hpS.mDx);
        if (this.hrd == null) {
            AppMethodBeat.o(130081);
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
        this.eoj = com.tencent.mm.plugin.fts.a.f.a(d.a(this.hrd.field_AppName, this.mDz, z, z3)).mDR;
        this.info = this.hrd.field_AppId;
        AppMethodBeat.o(130081);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.hre;
    }

    public final String aAp() {
        AppMethodBeat.i(130082);
        String format;
        if (this.hrd != null) {
            format = String.format("%s:%s", new Object[]{this.hrd.field_AppId, this.hrd.field_AppName});
            AppMethodBeat.o(130082);
            return format;
        }
        format = VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
        AppMethodBeat.o(130082);
        return format;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}

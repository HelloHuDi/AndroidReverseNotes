package com.tencent.p177mm.plugin.appbrand.game.p292b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.plugin.appbrand.appcache.C38114b;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a.C19224b;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.c */
public final class C6744c extends C3154a {
    public CharSequence eoj;
    public C45966l hpS;
    public AppBrandRecentTaskInfo hrc;
    public C19224b hrd;
    private C6746b hre = new C6746b();
    C6745a hrf = new C6745a();

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.c$a */
    public class C6745a extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView hpW;
        public TextView hpX;
        public TextView hrg;

        public C6745a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.c$b */
    public class C6746b extends C3156b {
        public C6746b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(130077);
            View inflate = LayoutInflater.from(context).inflate(2130970085, viewGroup, false);
            C6745a c6745a = C6744c.this.hrf;
            c6745a.ejo = (ImageView) inflate.findViewById(2131821183);
            c6745a.gnB = (TextView) inflate.findViewById(2131821185);
            c6745a.contentView = inflate.findViewById(2131821182);
            c6745a.hpW = (TextView) inflate.findViewById(2131821186);
            c6745a.hrg = (TextView) inflate.findViewById(2131820991);
            c6745a.hpX = (TextView) inflate.findViewById(2131821153);
            inflate.setTag(c6745a);
            AppMethodBeat.m2505o(130077);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(130078);
            C6744c c6744c = (C6744c) c3154a;
            C6745a c6745a = (C6745a) c3155a;
            if (c6744c.hrd == null) {
                c6745a.contentView.setVisibility(8);
                AppMethodBeat.m2505o(130078);
                return;
            }
            c6745a.contentView.setVisibility(0);
            c6745a.gnB.setText(C6744c.this.eoj);
            c6745a.hpX.setVisibility(8);
            c6745a.hrg.setVisibility(8);
            c6745a.hpW.setVisibility(8);
            String no;
            if (c6744c.hrc != null) {
                no = C38114b.m64485no(c6744c.hrc.gVs);
                if (C5046bo.isNullOrNil(no)) {
                    c6745a.hpX.setVisibility(8);
                } else {
                    c6745a.hpX.setText(no);
                    c6745a.hpX.setVisibility(0);
                }
            } else {
                no = c6744c.hrd.field_BriefIntro;
                if (C5046bo.isNullOrNil(no)) {
                    c6745a.hrg.setVisibility(8);
                } else {
                    c6745a.hrg.setText(no);
                    c6745a.hrg.setVisibility(0);
                }
            }
            C37926b.abR().mo60683a(c6745a.ejo, c6744c.hrd.field_IconUrl, C32804a.abQ(), C42201f.fqH);
            AppMethodBeat.m2505o(130078);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(130079);
            C6744c c6744c = (C6744c) c3154a;
            C32628se c32628se = new C32628se();
            c32628se.cOf.userName = c6744c.hrd.field_UserName;
            c32628se.cOf.cOi = 0;
            if (c6744c.hrc != null) {
                c32628se.cOf.cOi = c6744c.hrc.gVs;
            }
            c32628se.cOf.cOl = true;
            c32628se.cOf.scene = 1027;
            C4879a.xxA.mo10055m(c32628se);
            AppMethodBeat.m2505o(130079);
            return true;
        }
    }

    public C6744c(int i) {
        super(20, i);
        AppMethodBeat.m2504i(130080);
        AppMethodBeat.m2505o(130080);
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(130081);
        this.hrc = C45557i.m84026At(this.hpS.mDx);
        this.hrd = C45557i.m84025As(this.hpS.mDx);
        if (this.hrd == null) {
            AppMethodBeat.m2505o(130081);
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
        this.eoj = C34204f.m56086a(C39127d.m66568a(this.hrd.field_AppName, this.mDz, z, z3)).mDR;
        this.info = this.hrd.field_AppId;
        AppMethodBeat.m2505o(130081);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.hre;
    }

    public final String aAp() {
        AppMethodBeat.m2504i(130082);
        String format;
        if (this.hrd != null) {
            format = String.format("%s:%s", new Object[]{this.hrd.field_AppId, this.hrd.field_AppName});
            AppMethodBeat.m2505o(130082);
            return format;
        }
        format = VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
        AppMethodBeat.m2505o(130082);
        return format;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}

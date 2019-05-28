package com.tencent.p177mm.plugin.appbrand.p894f;

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
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.f.d */
public final class C26877d extends C3154a {
    public CharSequence eoj;
    public C45966l hpS;
    public AppBrandRecentTaskInfo hpT;
    private C10225b hpU = new C10225b();
    C26878a hpV = new C26878a();

    /* renamed from: com.tencent.mm.plugin.appbrand.f.d$b */
    public class C10225b extends C3156b {
        public C10225b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(129970);
            View inflate = LayoutInflater.from(context).inflate(2130968681, viewGroup, false);
            C26878a c26878a = C26877d.this.hpV;
            c26878a.ejo = (ImageView) inflate.findViewById(2131821183);
            c26878a.gnB = (TextView) inflate.findViewById(2131821185);
            c26878a.contentView = inflate.findViewById(2131821182);
            c26878a.hpW = (TextView) inflate.findViewById(2131821186);
            c26878a.hpX = (TextView) inflate.findViewById(2131821153);
            inflate.setTag(c26878a);
            AppMethodBeat.m2505o(129970);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(129971);
            C26877d c26877d = (C26877d) c3154a;
            C26878a c26878a = (C26878a) c3155a;
            if (c26877d.hpT == null) {
                c26878a.contentView.setVisibility(8);
                AppMethodBeat.m2505o(129971);
                return;
            }
            c26878a.contentView.setVisibility(0);
            c26878a.gnB.setText(C26877d.this.eoj);
            String no = C38114b.m64485no(C26877d.this.hpT.gVs);
            if (C5046bo.isNullOrNil(no)) {
                c26878a.hpX.setVisibility(8);
            } else {
                c26878a.hpX.setText(no);
                c26878a.hpX.setVisibility(0);
            }
            C37926b.abR().mo60683a(c26878a.ejo, c26877d.hpT.hac, C32804a.abQ(), C42201f.fqH);
            AppMethodBeat.m2505o(129971);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(129972);
            C26877d c26877d = (C26877d) c3154a;
            C32628se c32628se = new C32628se();
            c32628se.cOf.userName = c26877d.hpT.csl;
            c32628se.cOf.cOi = c26877d.hpT.gVs;
            c32628se.cOf.cOl = true;
            c32628se.cOf.scene = 1027;
            C4879a.xxA.mo10055m(c32628se);
            AppMethodBeat.m2505o(129972);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.f.d$a */
    public class C26878a extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView hpW;
        public TextView hpX;

        public C26878a() {
            super();
        }
    }

    public C26877d(int i) {
        super(16, i);
        AppMethodBeat.m2504i(129973);
        AppMethodBeat.m2505o(129973);
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(129974);
        this.hpT = C45553i.m84010An(this.hpS.mDx);
        if (this.hpT == null) {
            AppMethodBeat.m2505o(129974);
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
        this.eoj = C34204f.m56086a(C39127d.m66568a(this.hpT.appName, this.mDz, z, z3)).mDR;
        this.info = this.hpT.csl;
        AppMethodBeat.m2505o(129974);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.hpU;
    }

    public final String aAp() {
        return this.hpT.appName;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}

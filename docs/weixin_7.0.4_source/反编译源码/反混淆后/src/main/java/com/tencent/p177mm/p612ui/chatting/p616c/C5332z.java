package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p230g.p231a.C32525bn;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p231a.C45335jj;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.chatting.C36121ak;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40723af;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46644u;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42477i;
import com.tencent.p177mm.plugin.multitalk.model.C39419a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;

@C15590a(dFp = C46644u.class)
/* renamed from: com.tencent.mm.ui.chatting.c.z */
public class C5332z extends C44291a implements C46644u {

    /* renamed from: com.tencent.mm.ui.chatting.c.z$2 */
    class C53332 implements OnClickListener {
        C53332() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31570);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(31570);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.z$1 */
    class C53341 implements C30391c {
        C53341() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(31569);
            switch (i) {
                case 0:
                    if (!C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                        C4990ab.m7411d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)));
                        if (!C35805b.m58707a(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)) {
                            AppMethodBeat.m2505o(31569);
                            return;
                        }
                    } else if (!C35805b.m58714o(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                            C35805b.m58709b(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67);
                            AppMethodBeat.m2505o(31569);
                            return;
                        }
                        C32921a.m53856b(C5332z.this.cgL.yTx.getContext(), C5332z.this.cgL.yTx.getMMResources().getString(C25738R.string.g7p, new Object[]{C4988aa.dor()}), 30763, true);
                        AppMethodBeat.m2505o(31569);
                        return;
                    }
                    C5332z.this.dEI();
                    AppMethodBeat.m2505o(31569);
                    return;
                case 1:
                    if (!C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                        C4990ab.m7411d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)));
                        if (!C35805b.m58707a(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)) {
                            AppMethodBeat.m2505o(31569);
                            return;
                        }
                    } else if (!C35805b.m58714o(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                            C35805b.m58709b(C5332z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68);
                            AppMethodBeat.m2505o(31569);
                            return;
                        }
                        C32921a.m53856b(C5332z.this.cgL.yTx.getContext(), C5332z.this.cgL.yTx.getMMResources().getString(C25738R.string.g7p, new Object[]{C4988aa.dor()}), 30762, true);
                        AppMethodBeat.m2505o(31569);
                        return;
                    }
                    C5332z.this.dEJ();
                    break;
            }
            AppMethodBeat.m2505o(31569);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.z$3 */
    class C53353 implements OnClickListener {
        C53353() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31571);
            C5332z.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(31571);
        }
    }

    /* renamed from: bb */
    public final boolean mo10961bb(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31572);
        if (c7620bi.bAC()) {
            C36121ak.m59480aV(c7620bi);
            this.cgL.mo74882qp(true);
            AppMethodBeat.m2505o(31572);
            return true;
        }
        AppMethodBeat.m2505o(31572);
        return false;
    }

    public final void dEH() {
        int i;
        int i2;
        AppMethodBeat.m2504i(31573);
        if (!C7616ad.aox(this.cgL.getTalkerUserName()) && !C1855t.m3903mP(this.cgL.sRl.field_username)) {
            i = 0;
        } else if ((((C32873b) C1720g.m3528K(C32873b.class)).mo44311vi(this.cgL.sRl.field_openImAppid) & 4096) == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.cgL.sRl.dsf() || C1855t.m3920nF(this.cgL.getTalkerUserName()) || C7616ad.aou(this.cgL.getTalkerUserName()) || C7616ad.aow(this.cgL.getTalkerUserName()) || C7616ad.m13548mR(this.cgL.getTalkerUserName()) || this.cgL.getTalkerUserName().equals(C1853r.m3846Yz())) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        String[] strArr = (i2 == 0 || i != 0) ? new String[]{this.cgL.yTx.getMMResources().getString(C25738R.string.cnq)} : new String[]{this.cgL.yTx.getMMResources().getString(C25738R.string.cnq), this.cgL.yTx.getMMResources().getString(C25738R.string.cnr)};
        C30379h.m48422a(this.cgL.yTx.getContext(), null, strArr, null, new C53341());
        AppMethodBeat.m2505o(31573);
    }

    public final void dEI() {
        AppMethodBeat.m2504i(31574);
        Intent intent = new Intent();
        C7060h.pYm.mo8381e(12809, Integer.valueOf(1), "");
        intent.putExtra("map_view_type", 0);
        intent.putExtra("map_sender_name", this.cgL.dFu());
        intent.putExtra("map_talker_name", this.cgL.getTalkerUserName());
        C25985d.m41467b(this.cgL.yTx.getContext(), C8741b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.m2505o(31574);
    }

    /* JADX WARNING: Missing block: B:21:0x00b1, code skipped:
            if (r3.contains(r6.cgL.dFu()) != false) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dEJ() {
        boolean z = true;
        AppMethodBeat.m2504i(31575);
        if (!(C35973a.m59179bJ(this.cgL.yTx.getContext()) || C35973a.m59177bH(this.cgL.yTx.getContext()))) {
            if (((C39419a) C1720g.m3528K(C39419a.class)).mo55110RV(this.cgL.getTalkerUserName())) {
                C4990ab.m7416i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
                C30379h.m48467g(this.cgL.yTx.getContext(), C25738R.string.d2l, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(31575);
                return;
            }
            String str = null;
            C42062sz c42062sz = new C42062sz();
            if (C32337g.fUs != null) {
                c42062sz.cPf.cPh = true;
                C4879a.xxA.mo10055m(c42062sz);
                if (!C5046bo.isNullOrNil(c42062sz.cPg.cPj)) {
                    str = this.cgL.yTx.getMMResources().getString(C25738R.string.bdc);
                } else if (C32337g.fUs.mo4625tN(this.cgL.getTalkerUserName())) {
                    str = this.cgL.yTx.getMMResources().getString(C25738R.string.bdd);
                }
            }
            if (!C5046bo.isNullOrNil(str)) {
                if (C25859d.fUu != null && C25859d.fUu.mo20565tQ(this.cgL.sRl.field_username)) {
                    LinkedList tP = C25859d.fUu.mo20564tP(this.cgL.sRl.field_username);
                    if (tP != null) {
                    }
                }
                z = false;
                if (!z) {
                    C5652a c5652a = new C5652a(this.cgL.yTx.getContext());
                    c5652a.asE(str);
                    c5652a.mo11453Qc(C25738R.string.cd_).mo11457a(new C53332());
                    c5652a.aMb().show();
                    AppMethodBeat.m2505o(31575);
                    return;
                }
            }
            ((C40723af) this.cgL.mo74857aF(C40723af.class)).arr("fromPluginLocation");
        }
        AppMethodBeat.m2505o(31575);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(31576);
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 67:
            case C42477i.CTRL_INDEX /*68*/:
                if (iArr[0] != 0) {
                    C30379h.m48445a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.dby), this.cgL.yTx.getMMResources().getString(C25738R.string.dc8), this.cgL.yTx.getMMResources().getString(C25738R.string.ckr), this.cgL.yTx.getMMResources().getString(C25738R.string.abx), false, new C53353(), null);
                    break;
                } else if (i == 67) {
                    dEI();
                    AppMethodBeat.m2505o(31576);
                    return;
                } else {
                    dEJ();
                    AppMethodBeat.m2505o(31576);
                    return;
                }
        }
        AppMethodBeat.m2505o(31576);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31577);
        super.dDh();
        C45335jj c45335jj = new C45335jj();
        c45335jj.cEF.cEA = 2;
        C4879a.xxA.mo10055m(c45335jj);
        AppMethodBeat.m2505o(31577);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31579);
        C4879a.xxA.mo10055m(new C32525bn());
        AppMethodBeat.m2505o(31579);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31578);
        C45335jj c45335jj = new C45335jj();
        c45335jj.cEF.cEA = 0;
        c45335jj.cEF.aOt = C4988aa.dor();
        if (C1855t.m3896kH(this.cgL.sRl.field_username)) {
            c45335jj.cEF.cEH = true;
        } else {
            c45335jj.cEF.cEH = false;
        }
        C4879a.xxA.mo10055m(c45335jj);
        AppMethodBeat.m2505o(31578);
    }
}

package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.b.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.u;
import java.util.LinkedList;

@a(dFp = u.class)
public class z extends a implements u {
    public final boolean bb(bi biVar) {
        AppMethodBeat.i(31572);
        if (biVar.bAC()) {
            ak.aV(biVar);
            this.cgL.qp(true);
            AppMethodBeat.o(31572);
            return true;
        }
        AppMethodBeat.o(31572);
        return false;
    }

    public final void dEH() {
        int i;
        int i2;
        AppMethodBeat.i(31573);
        if (!ad.aox(this.cgL.getTalkerUserName()) && !t.mP(this.cgL.sRl.field_username)) {
            i = 0;
        } else if ((((b) g.K(b.class)).vi(this.cgL.sRl.field_openImAppid) & 4096) == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.cgL.sRl.dsf() || t.nF(this.cgL.getTalkerUserName()) || ad.aou(this.cgL.getTalkerUserName()) || ad.aow(this.cgL.getTalkerUserName()) || ad.mR(this.cgL.getTalkerUserName()) || this.cgL.getTalkerUserName().equals(r.Yz())) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        String[] strArr = (i2 == 0 || i != 0) ? new String[]{this.cgL.yTx.getMMResources().getString(R.string.cnq)} : new String[]{this.cgL.yTx.getMMResources().getString(R.string.cnq), this.cgL.yTx.getMMResources().getString(R.string.cnr)};
        h.a(this.cgL.yTx.getContext(), null, strArr, null, new c() {
            public final void iE(int i) {
                AppMethodBeat.i(31569);
                switch (i) {
                    case 0:
                        if (!com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                            ab.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)));
                            if (!com.tencent.mm.pluginsdk.permission.b.a(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)) {
                                AppMethodBeat.o(31569);
                                return;
                            }
                        } else if (!com.tencent.mm.pluginsdk.permission.b.o(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                            if (((Boolean) g.RP().Ry().get(ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                com.tencent.mm.pluginsdk.permission.b.b(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67);
                                AppMethodBeat.o(31569);
                                return;
                            }
                            com.tencent.mm.plugin.account.a.b.a.b(z.this.cgL.yTx.getContext(), z.this.cgL.yTx.getMMResources().getString(R.string.g7p, new Object[]{aa.dor()}), 30763, true);
                            AppMethodBeat.o(31569);
                            return;
                        }
                        z.this.dEI();
                        AppMethodBeat.o(31569);
                        return;
                    case 1:
                        if (!com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                            ab.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)));
                            if (!com.tencent.mm.pluginsdk.permission.b.a(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)) {
                                AppMethodBeat.o(31569);
                                return;
                            }
                        } else if (!com.tencent.mm.pluginsdk.permission.b.o(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                            if (((Boolean) g.RP().Ry().get(ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                com.tencent.mm.pluginsdk.permission.b.b(z.this.cgL.yTx.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68);
                                AppMethodBeat.o(31569);
                                return;
                            }
                            com.tencent.mm.plugin.account.a.b.a.b(z.this.cgL.yTx.getContext(), z.this.cgL.yTx.getMMResources().getString(R.string.g7p, new Object[]{aa.dor()}), 30762, true);
                            AppMethodBeat.o(31569);
                            return;
                        }
                        z.this.dEJ();
                        break;
                }
                AppMethodBeat.o(31569);
            }
        });
        AppMethodBeat.o(31573);
    }

    public final void dEI() {
        AppMethodBeat.i(31574);
        Intent intent = new Intent();
        com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(1), "");
        intent.putExtra("map_view_type", 0);
        intent.putExtra("map_sender_name", this.cgL.dFu());
        intent.putExtra("map_talker_name", this.cgL.getTalkerUserName());
        d.b(this.cgL.yTx.getContext(), FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(31574);
    }

    /* JADX WARNING: Missing block: B:21:0x00b1, code skipped:
            if (r3.contains(r6.cgL.dFu()) != false) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dEJ() {
        boolean z = true;
        AppMethodBeat.i(31575);
        if (!(com.tencent.mm.r.a.bJ(this.cgL.yTx.getContext()) || com.tencent.mm.r.a.bH(this.cgL.yTx.getContext()))) {
            if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RV(this.cgL.getTalkerUserName())) {
                ab.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
                h.g(this.cgL.yTx.getContext(), R.string.d2l, R.string.tz);
                AppMethodBeat.o(31575);
                return;
            }
            String str = null;
            sz szVar = new sz();
            if (com.tencent.mm.bg.g.fUs != null) {
                szVar.cPf.cPh = true;
                com.tencent.mm.sdk.b.a.xxA.m(szVar);
                if (!bo.isNullOrNil(szVar.cPg.cPj)) {
                    str = this.cgL.yTx.getMMResources().getString(R.string.bdc);
                } else if (com.tencent.mm.bg.g.fUs.tN(this.cgL.getTalkerUserName())) {
                    str = this.cgL.yTx.getMMResources().getString(R.string.bdd);
                }
            }
            if (!bo.isNullOrNil(str)) {
                if (com.tencent.mm.bh.d.fUu != null && com.tencent.mm.bh.d.fUu.tQ(this.cgL.sRl.field_username)) {
                    LinkedList tP = com.tencent.mm.bh.d.fUu.tP(this.cgL.sRl.field_username);
                    if (tP != null) {
                    }
                }
                z = false;
                if (!z) {
                    com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.cgL.yTx.getContext());
                    aVar.asE(str);
                    aVar.Qc(R.string.cd_).a(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(31570);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(31570);
                        }
                    });
                    aVar.aMb().show();
                    AppMethodBeat.o(31575);
                    return;
                }
            }
            ((af) this.cgL.aF(af.class)).arr("fromPluginLocation");
        }
        AppMethodBeat.o(31575);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(31576);
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 67:
            case i.CTRL_INDEX /*68*/:
                if (iArr[0] != 0) {
                    h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.dby), this.cgL.yTx.getMMResources().getString(R.string.dc8), this.cgL.yTx.getMMResources().getString(R.string.ckr), this.cgL.yTx.getMMResources().getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(31571);
                            z.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(31571);
                        }
                    }, null);
                    break;
                } else if (i == 67) {
                    dEI();
                    AppMethodBeat.o(31576);
                    return;
                } else {
                    dEJ();
                    AppMethodBeat.o(31576);
                    return;
                }
        }
        AppMethodBeat.o(31576);
    }

    public final void dDh() {
        AppMethodBeat.i(31577);
        super.dDh();
        jj jjVar = new jj();
        jjVar.cEF.cEA = 2;
        com.tencent.mm.sdk.b.a.xxA.m(jjVar);
        AppMethodBeat.o(31577);
    }

    public final void dxC() {
        AppMethodBeat.i(31579);
        com.tencent.mm.sdk.b.a.xxA.m(new bn());
        AppMethodBeat.o(31579);
    }

    public final void dxy() {
        AppMethodBeat.i(31578);
        jj jjVar = new jj();
        jjVar.cEF.cEA = 0;
        jjVar.cEF.aOt = aa.dor();
        if (t.kH(this.cgL.sRl.field_username)) {
            jjVar.cEF.cEH = true;
        } else {
            jjVar.cEF.cEH = false;
        }
        com.tencent.mm.sdk.b.a.xxA.m(jjVar);
        AppMethodBeat.o(31578);
    }
}

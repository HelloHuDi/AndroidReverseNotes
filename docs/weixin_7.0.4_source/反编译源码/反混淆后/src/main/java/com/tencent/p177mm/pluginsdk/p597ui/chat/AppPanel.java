package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p249m.C1763c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMDotView;
import com.tencent.p177mm.p612ui.base.MMFlipper;
import com.tencent.p177mm.p612ui.base.MMFlipper.C5250a;
import com.tencent.p177mm.p612ui.base.MMFlipper.C5251b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.card.p1243c.C33762b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.chat.AppGrid.C40464b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel */
public class AppPanel extends LinearLayout {
    private static int qgy = 215;
    private static int qgz = 158;
    private static boolean vmg = false;
    private boolean bZi = false;
    Context context;
    private SharedPreferences ehZ;
    private List<C40439f> geU = new LinkedList();
    private boolean qgL = false;
    private int qgM;
    private int qgN;
    public MMFlipper qgO;
    private MMDotView qgP;
    private int vlA = 17;
    private final boolean[] vlJ = new boolean[17];
    private C14934a vlK;
    private C30118b vlL;
    private List<AppGrid> vlM;
    private int vlN = this.vlA;
    private int vlO;
    public C30123a vlP;
    private int vlQ = 0;
    private int vlR = 0;
    private int vlS = 0;
    private boolean vlT = false;
    private boolean vlU = false;
    private boolean vlV = false;
    private boolean vlW = false;
    boolean vlX = false;
    boolean vlY = false;
    boolean vlZ = false;
    public boolean vma = false;
    private Map<String, C40439f> vmb = null;
    private boolean vmc = true;
    private final int vmd = 2;
    private int vme = -1;
    private C40464b vmf = new C301154();
    private boolean vmh = true;
    private int vmi = -1;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$a */
    public interface C14934a {
        /* renamed from: b */
        void mo24413b(C40439f c40439f);

        void bNO();

        void bNP();

        void bNQ();

        void bNR();

        void bNS();

        void bNT();

        void bNU();

        void bNV();

        void bNW();

        void bNX();

        void bNY();

        void bNZ();

        void bOa();

        void bOb();

        /* renamed from: ys */
        void mo24428ys(int i);

        /* renamed from: yt */
        void mo24429yt(int i);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$4 */
    class C301154 implements C40464b {

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$4$1 */
        class C47441 implements OnClickListener {
            C47441() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27744);
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPi = true;
                C4879a.xxA.mo10055m(c42062sz);
                AppPanel.this.vlK.bNO();
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(27744);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$4$2 */
        class C47452 implements OnClickListener {
            C47452() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27745);
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(27745);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$4$3 */
        class C47463 implements OnClickListener {
            C47463() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27746);
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPi = true;
                C4879a.xxA.mo10055m(c42062sz);
                AppPanel.this.vlK.bNP();
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(27746);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$4$4 */
        class C301164 implements OnClickListener {
            C301164() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27747);
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(27747);
            }
        }

        C301154() {
        }

        /* renamed from: Lb */
        public final int mo48387Lb(int i) {
            AppMethodBeat.m2504i(27748);
            if (i < AppPanel.this.vlA) {
                int length = AppPanel.this.vlJ.length;
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (AppPanel.this.vlJ[i3]) {
                        if (i2 == i) {
                            AppMethodBeat.m2505o(27748);
                            return i3;
                        }
                        i2++;
                    }
                }
            } else if (i >= AppPanel.this.vlA && i < AppPanel.this.vlN) {
                AppMethodBeat.m2505o(27748);
                return C8415j.INVALID_ID;
            }
            AppMethodBeat.m2505o(27748);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        }

        /* renamed from: Lc */
        public final void mo48388Lc(int i) {
            AppMethodBeat.m2504i(27749);
            if (i != 0) {
                AppMethodBeat.m2505o(27749);
            } else if (AppPanel.this.vlP.vmn.value) {
                AppPanel.m69447a(AppPanel.this, true);
                AppMethodBeat.m2505o(27749);
            } else {
                Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                AppMethodBeat.m2505o(27749);
            }
        }

        /* renamed from: a */
        public final void mo48389a(int i, C40439f c40439f) {
            int i2 = 1;
            int i3 = 0;
            AppMethodBeat.m2504i(27750);
            String str = "MicroMsg.AppPanel";
            String str2 = "pos=%d, has appInfo = %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(c40439f != null);
            C4990ab.m7411d(str, str2, objArr);
            if (c40439f != null && C46494g.m87753l(c40439f)) {
                HashMap hashMap = new HashMap();
                C1853r.m3857m(hashMap);
                hashMap.put(c40439f.field_appId, "1");
                C1853r.m3856l(hashMap);
            }
            C42062sz c42062sz;
            String str3;
            C40439f c40439f2;
            boolean a;
            List P;
            switch (i) {
                case C8415j.INVALID_ID /*-2147483648*/:
                    if (!AppPanel.this.vlP.vmu.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                        AppMethodBeat.m2505o(27750);
                        return;
                    } else if (c40439f == null) {
                        C4990ab.m7412e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
                        AppMethodBeat.m2505o(27750);
                        return;
                    } else {
                        if (c40439f.dhx() || c40439f.dhA()) {
                            if (AppPanel.this.ehZ == null) {
                                AppPanel.this.ehZ = AppPanel.this.context.getSharedPreferences(C4996ah.doA(), 0);
                            }
                            if (AppPanel.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + c40439f.field_appId, true)) {
                                AppPanel.this.ehZ.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + c40439f.field_appId, false).commit();
                            }
                            if (c40439f.dhA()) {
                                C7060h.pYm.mo8381e(10923, Integer.valueOf(16), c40439f.field_appId, Integer.valueOf(0));
                            }
                            C7060h.pYm.mo8381e(10923, Integer.valueOf(13), c40439f.field_appId, Integer.valueOf(0));
                        } else {
                            C7060h.pYm.mo8381e(10923, Integer.valueOf(11), c40439f.field_appId);
                        }
                        AppPanel.this.vlK.mo24413b(c40439f);
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                case 0:
                    if (AppPanel.this.vlP.vmn.value) {
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(1));
                        AppPanel.m69447a(AppPanel.this, false);
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 1:
                    C7060h.pYm.mo8381e(10923, Integer.valueOf(14));
                    C14934a k = AppPanel.this.vlK;
                    if (!AppPanel.this.vlP.vmD.value) {
                        i3 = 2;
                    }
                    k.mo24429yt(i3);
                    AppMethodBeat.m2505o(27750);
                    return;
                case 2:
                    if (AppPanel.this.vlP.vmq.value) {
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(8));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(54, Boolean.FALSE);
                        if (AppPanel.this.vlK != null) {
                            c42062sz = new C42062sz();
                            c42062sz.cPf.cPh = true;
                            C4879a.xxA.mo10055m(c42062sz);
                            str3 = c42062sz.cPg.cPj;
                            if (C5046bo.isNullOrNil(str3)) {
                                AppPanel.this.vlK.bNO();
                                AppMethodBeat.m2505o(27750);
                                return;
                            }
                            C4990ab.m7418v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(str3)));
                            C30379h.m48466d(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.euf), "", AppPanel.this.context.getString(C25738R.string.f9187s6), AppPanel.this.context.getString(C25738R.string.f9076or), new C47441(), new C47452());
                            AppMethodBeat.m2505o(27750);
                            return;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                    break;
                case 3:
                    if (AppPanel.this.vlK != null) {
                        AppPanel.this.vlK.bNY();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    break;
                case 4:
                    if (AppPanel.this.vlP.vmw.value) {
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(7));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(62, Boolean.FALSE);
                        c42062sz = new C42062sz();
                        c42062sz.cPf.cPh = true;
                        C4879a.xxA.mo10055m(c42062sz);
                        str3 = c42062sz.cPg.cPj;
                        if (C5046bo.isNullOrNil(str3)) {
                            AppPanel.this.vlK.bNP();
                            AppMethodBeat.m2505o(27750);
                            return;
                        }
                        C4990ab.m7418v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(str3)));
                        C30379h.m48466d(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.euf), "", AppPanel.this.context.getString(C25738R.string.f9187s6), AppPanel.this.context.getString(C25738R.string.f9076or), new C47463(), new C301164());
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 5:
                    if (AppPanel.this.vlK != null) {
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(6));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(67, Boolean.FALSE);
                        AppPanel.this.vlK.bNQ();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    break;
                case 6:
                    if (AppPanel.this.vlP.vmA.value && AppPanel.this.vlP.vmB.value) {
                        C9638aw.m17190ZK();
                        if (((Boolean) C18628c.m29072Ry().get(290817, Boolean.TRUE)).booleanValue()) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(290817, Boolean.FALSE);
                            AppPanel.this.refresh();
                        }
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(3));
                        AppPanel.this.vlK.bNR();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 7:
                    if (AppPanel.this.vlP.vmE.value) {
                        if (c40439f == null) {
                            c40439f2 = (C40439f) AppPanel.this.vmb.get(C40439f.vbS);
                            if (c40439f2 == null) {
                                AppMethodBeat.m2505o(27750);
                                return;
                            }
                        }
                        c40439f2 = c40439f;
                        if (c40439f2.dhx() || c40439f2.dhA()) {
                            if (AppPanel.this.ehZ == null) {
                                AppPanel.this.ehZ = AppPanel.this.context.getSharedPreferences(C4996ah.doA(), 0);
                            }
                            if (AppPanel.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + c40439f2.field_appId, true)) {
                                AppPanel.this.ehZ.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + c40439f2.field_appId, false).commit();
                            }
                            C7060h.pYm.mo8381e(10923, Integer.valueOf(13), c40439f2.field_appId, Integer.valueOf(0));
                        } else {
                            C7060h.pYm.mo8381e(10923, Integer.valueOf(11), c40439f2.field_appId);
                        }
                        a = C16112c.m24429PK().mo28546a(C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_APP_PANEL_STRING_SYNC);
                        if (a) {
                            C16112c.m24429PK().mo28554c(C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_APP_PANEL_STRING_SYNC);
                        }
                        C9638aw.m17190ZK();
                        i3 = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                        C9638aw.m17190ZK();
                        P = C5046bo.m7508P(((String) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";"));
                        if (P.contains(String.valueOf(i3))) {
                            boolean i22 = a;
                        } else {
                            P.add(String.valueOf(i3));
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_WALLET_HONGBAO_STRING_SYNC, C5046bo.m7536c(P, ";"));
                        }
                        if (i22 != 0) {
                            AppPanel.this.refresh();
                        }
                        AppPanel.this.vlK.bNX();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 8:
                    if (c40439f == null) {
                        c40439f = (C40439f) AppPanel.this.vmb.get(C40439f.vbQ);
                    }
                    C9638aw.m17190ZK();
                    i22 = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                    C9638aw.m17190ZK();
                    P = C5046bo.m7508P(((String) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";"));
                    if (!P.contains(String.valueOf(i22))) {
                        P.add(String.valueOf(i22));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, C5046bo.m7536c(P, ";"));
                        AppPanel.this.refresh();
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(80, Boolean.FALSE);
                    AppPanel.this.vlK.mo24413b(c40439f);
                    AppMethodBeat.m2505o(27750);
                    return;
                case 9:
                    if (AppPanel.this.vlK != null) {
                        if (c40439f == null) {
                            c40439f2 = (C40439f) AppPanel.this.vmb.get(C40439f.vbT);
                            if (c40439f2 == null) {
                                C4990ab.m7416i("MicroMsg.AppPanel", "empty info");
                                AppMethodBeat.m2505o(27750);
                                return;
                            }
                        }
                        c40439f2 = c40439f;
                        if (c40439f2.dhx() || c40439f2.dhA()) {
                            if (AppPanel.this.ehZ == null) {
                                AppPanel.this.ehZ = AppPanel.this.context.getSharedPreferences(C4996ah.doA(), 0);
                            }
                            if (AppPanel.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + c40439f2.field_appId, true)) {
                                AppPanel.this.ehZ.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + c40439f2.field_appId, false).commit();
                            }
                        }
                        AppPanel.this.vlK.bOa();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    break;
                case 10:
                    C7060h.pYm.mo8381e(10923, Integer.valueOf(9));
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(73, Boolean.FALSE);
                    AppPanel.this.vlL.djW();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 11:
                    if (AppPanel.this.vlP.vmp.value) {
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(5));
                        if (AppPanel.this.vlK != null) {
                            AppPanel.this.vlK.bNU();
                            AppMethodBeat.m2505o(27750);
                            return;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                    break;
                case 12:
                    if (AppPanel.this.vlP.vmo.value) {
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(4));
                        AppPanel.this.vlK.bNS();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 13:
                    if (AppPanel.this.vlP.vmC.value) {
                        if (AppPanel.this.vlK != null) {
                            AppPanel.this.vlK.bNW();
                        }
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(15));
                        C9638aw.m17190ZK();
                        a = ((Boolean) C18628c.m29072Ry().get(208899, Boolean.FALSE)).booleanValue();
                        C9638aw.m17190ZK();
                        boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(208913, Boolean.FALSE)).booleanValue();
                        if (a) {
                            C7060h.pYm.mo8381e(11594, Integer.valueOf(3));
                            AppMethodBeat.m2505o(27750);
                            return;
                        } else if (booleanValue) {
                            C7060h.pYm.mo8381e(11594, Integer.valueOf(4));
                            AppMethodBeat.m2505o(27750);
                            return;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                    break;
                case 14:
                    if (AppPanel.this.vlP.vms.value) {
                        C9638aw.m17190ZK();
                        if (((Boolean) C18628c.m29072Ry().get(327744, Boolean.TRUE)).booleanValue()) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(327744, Boolean.FALSE);
                            AppPanel.this.refresh();
                        }
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(12));
                        AppPanel.this.vlK.bNV();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 15:
                    if (AppPanel.this.vlP.vmG.value) {
                        AppPanel.this.vlK.bNZ();
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                case 16:
                    if (AppPanel.this.vlP.vmI.value) {
                        C7060h.pYm.mo8381e(10923, Integer.valueOf(17));
                        if (AppPanel.this.vlK != null) {
                            AppPanel.this.vlK.bOb();
                            break;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(C25738R.string.an0), 0).show();
                    AppMethodBeat.m2505o(27750);
                    return;
                    break;
                case BaseClientBuilder.API_PRIORITY_OTHER /*2147483647*/:
                    if (AppPanel.this.geU == null) {
                        C4990ab.m7412e("MicroMsg.AppPanel", "infoList == null");
                        AppMethodBeat.m2505o(27750);
                        return;
                    }
                    C7060h.pYm.mo8374X(10305, String.valueOf(AppPanel.this.geU.size()));
                    C7060h.pYm.mo8381e(10923, Integer.valueOf(10));
                    C1720g.m3536RP().mo5239Ry().set(69121, (Object) "");
                    AppPanel.this.vlK.bNT();
                    AppMethodBeat.m2505o(27750);
                    return;
            }
            AppMethodBeat.m2505o(27750);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$5 */
    class C301175 implements Runnable {
        C301175() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27751);
            C37461f.afy();
            C4990ab.m7417i("MicroMsg.AppPanel", "preMakeConnection ret:%d", Integer.valueOf(0));
            AppPanel.vmg = false;
            AppMethodBeat.m2505o(27751);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$b */
    public interface C30118b {
        void djW();
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$1 */
    class C404651 implements C5250a {
        C404651() {
        }

        /* renamed from: fe */
        public final void mo10769fe(int i, int i2) {
            AppMethodBeat.m2504i(27741);
            C4990ab.m7416i("MicroMsg.AppPanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + AppPanel.this.qgL);
            if (AppPanel.this.qgL || i2 == 0 || i == 0) {
                if (i2 == 0 || i == 0) {
                    C4990ab.m7410d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
                }
                AppMethodBeat.m2505o(27741);
                return;
            }
            if (AppPanel.m69449b(AppPanel.this) == 2) {
                C4990ab.m7410d("MicroMsg.AppPanel", "landspace");
            } else {
                C4990ab.m7410d("MicroMsg.AppPanel", "portrait");
            }
            AppPanel.this.qgL = true;
            AppPanel.this.qgN = i2;
            AppPanel.this.qgM = i;
            AppPanel.m69452d(AppPanel.this);
            AppMethodBeat.m2505o(27741);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$2 */
    class C404662 implements C5251b {
        C404662() {
        }

        /* renamed from: BZ */
        public final void mo10770BZ(int i) {
            AppMethodBeat.m2504i(27742);
            AppPanel.this.qgP.setSelectedDot(i);
            AppMethodBeat.m2505o(27742);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppPanel$3 */
    class C404673 implements Runnable {
        C404673() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27743);
            C4990ab.m7412e("MicroMsg.AppPanel", "initAppGrid ANR!");
            C7060h.pYm.mo15419k(999, 2, 1);
            AppMethodBeat.m2505o(27743);
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m69449b(AppPanel appPanel) {
        AppMethodBeat.m2504i(27781);
        int screenOrientation = appPanel.getScreenOrientation();
        AppMethodBeat.m2505o(27781);
        return screenOrientation;
    }

    /* renamed from: d */
    static /* synthetic */ void m69452d(AppPanel appPanel) {
        AppMethodBeat.m2504i(27782);
        appPanel.chK();
        AppMethodBeat.m2505o(27782);
    }

    public AppPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27752);
        this.context = context;
        AppMethodBeat.m2505o(27752);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init(int i) {
        AppMethodBeat.m2504i(27753);
        C4990ab.m7417i("MicroMsg.AppPanel", "init: %s", Integer.valueOf(i));
        this.vlP = new C30123a();
        this.vlS = i;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.vlQ = defaultDisplay.getWidth();
            this.vlR = defaultDisplay.getHeight();
        } else {
            this.vlQ = defaultDisplay.getHeight();
            this.vlR = defaultDisplay.getWidth();
        }
        View.inflate(this.context, 2130968755, this);
        this.qgP = (MMDotView) findViewById(2131821455);
        this.qgO = (MMFlipper) findViewById(2131821454);
        try {
            String value = C26373g.m41964Nu().getValue("ShowAPPSuggestion");
            if (C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                this.geU = C46494g.m87722a(this.context, false, this.vlS);
                if (!djU()) {
                    AppPanel.m69455eh(this.geU);
                }
                m69454eg(this.geU);
                djR();
                djI();
                AppMethodBeat.m2505o(27753);
            }
            this.geU = C46494g.m87722a(this.context, true, this.vlS);
            if (djU()) {
            }
            m69454eg(this.geU);
            djR();
            djI();
            AppMethodBeat.m2505o(27753);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.geU = C46494g.m87722a(this.context, false, this.vlS);
        }
    }

    public void setServiceShowFlag(int i) {
        AppMethodBeat.m2504i(27754);
        C4990ab.m7417i("MicroMsg.AppPanel", "setServiceShowFlag: %s", Integer.valueOf(i));
        this.vlS = i;
        AppMethodBeat.m2505o(27754);
    }

    /* renamed from: eg */
    private void m69454eg(List<C40439f> list) {
        AppMethodBeat.m2504i(27755);
        boolean z = this.vlT;
        this.vlT = false;
        boolean z2 = this.vlU;
        boolean z3 = this.vlV;
        boolean z4 = this.vlW;
        this.vlU = false;
        this.vlV = false;
        this.vlW = false;
        int Kw = C46494g.m87720Kw(this.vlS);
        String str = "MicroMsg.AppPanel";
        String str2 = "serviceCount, %d, %s, %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(Kw);
        objArr[1] = Integer.valueOf(this.vlS);
        objArr[2] = Integer.valueOf(list != null ? list.size() : -1);
        C4990ab.m7417i(str, str2, objArr);
        this.vmb = new HashMap();
        if (Kw > 0) {
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    Kw = i;
                    if (Kw >= list.size()) {
                        break;
                    }
                    C40439f c40439f = (C40439f) list.get(Kw);
                    if (!(c40439f == null || c40439f.field_appId == null || !c40439f.dhx())) {
                        int i2;
                        if (!c40439f.dhz()) {
                            this.vlT = true;
                        }
                        if (C40439f.vbQ.equals(c40439f.field_appId)) {
                            this.vmb.put(C40439f.vbQ, c40439f);
                            C4990ab.m7417i("MicroMsg.AppPanel", "remittance: %s, %s", Boolean.valueOf(this.vlY), Boolean.valueOf(this.vlU));
                            if (!this.vlY) {
                                this.vlU = true;
                            }
                            i2 = Kw - 1;
                            list.remove(Kw);
                            Kw = i2;
                        }
                        if (C40439f.vbS.equals(c40439f.field_appId)) {
                            this.vmb.put(C40439f.vbS, c40439f);
                            C4990ab.m7417i("MicroMsg.AppPanel", "luckyMoney: %s, %s", Boolean.valueOf(this.vlX), Boolean.valueOf(this.vlV));
                            if (!this.vlX) {
                                this.vlV = true;
                            }
                            i2 = Kw - 1;
                            list.remove(Kw);
                            Kw = i2;
                        }
                        if (C40439f.vbT.equals(c40439f.field_appId)) {
                            this.vmb.put(C40439f.vbT, c40439f);
                            C4990ab.m7417i("MicroMsg.AppPanel", "aa: %s, %s", Boolean.valueOf(this.vlX), Boolean.valueOf(this.vlV));
                            if (!this.vlZ) {
                                this.vlW = true;
                            }
                            i = Kw - 1;
                            list.remove(Kw);
                            Kw = i;
                        }
                    }
                    i = Kw + 1;
                }
            } else {
                C7060h.pYm.mo15419k(965, 36, 1);
            }
        }
        C4990ab.m7417i("MicroMsg.AppPanel", "hasService %b", Boolean.valueOf(this.vlT));
        if (!(z == this.vlT && z2 == this.vlU && z3 == this.vlV && z4 == this.vlW)) {
            this.vlP.mo48399oJ(this.vlT);
            this.vlP.mo48400oK(this.vlU);
            this.vlP.mo48403oN(this.vlV);
            this.vlP.mo48404oO(this.vlW);
            djQ();
        }
        AppMethodBeat.m2505o(27755);
    }

    public final void djI() {
        AppMethodBeat.m2504i(27756);
        this.vlP.djX();
        this.vlX = false;
        this.vlY = false;
        this.vlZ = false;
        this.vma = false;
        djJ();
        this.vlP.mo48399oJ(this.vlT);
        this.vlP.mo48400oK(this.vlU);
        this.vlP.mo48403oN(this.vlV);
        this.vlP.mo48404oO(this.vlW);
        djQ();
        AppMethodBeat.m2505o(27756);
    }

    public final void djJ() {
        AppMethodBeat.m2504i(27757);
        C26373g.m41965Nv();
        boolean z = C1763c.m3627Ng() == 2;
        this.vlP.djY();
        this.vlP.mo48401oL(z);
        this.vlP.mo48402oM(C25985d.afj(C8741b.LOCATION));
        this.vlP.djZ();
        AppMethodBeat.m2505o(27757);
    }

    public final void djK() {
        AppMethodBeat.m2504i(27758);
        this.vlP.vmo.value = false;
        djQ();
        AppMethodBeat.m2505o(27758);
    }

    /* renamed from: oF */
    public final void mo63885oF(boolean z) {
        AppMethodBeat.m2504i(27759);
        boolean z2 = !z;
        this.vlP.vmq.value = z2;
        djQ();
        C4990ab.m7410d("MicroMsg.AppPanel", "enable " + z2 + " isVoipPluginEnable " + this.vlP.vmr.value);
        AppMethodBeat.m2505o(27759);
    }

    /* renamed from: oG */
    public final void mo63886oG(boolean z) {
        AppMethodBeat.m2504i(27760);
        boolean z2 = !z;
        this.vlP.vmw.value = z2;
        djQ();
        C4990ab.m7410d("MicroMsg.AppPanel", "enable " + this.vlP.vmx.value + " isVoipAudioEnable " + z2);
        AppMethodBeat.m2505o(27760);
    }

    /* renamed from: oH */
    public final void mo63887oH(boolean z) {
        AppMethodBeat.m2504i(27761);
        boolean z2 = !z;
        this.vlP.vmF.value = z2;
        djQ();
        C4990ab.m7410d("MicroMsg.AppPanel", "enable " + this.vlP.vmF.value + " isMultiTalkEnable " + z2);
        AppMethodBeat.m2505o(27761);
    }

    /* renamed from: oI */
    public final void mo63888oI(boolean z) {
        AppMethodBeat.m2504i(27762);
        this.vlP.vmy.value = !z;
        djQ();
        AppMethodBeat.m2505o(27762);
    }

    public final void djL() {
        AppMethodBeat.m2504i(27763);
        this.vlP.vmv.value = false;
        djQ();
        C4990ab.m7410d("MicroMsg.AppPanel", "disableTalkroom enable false");
        AppMethodBeat.m2505o(27763);
    }

    public final void djM() {
        AppMethodBeat.m2504i(27764);
        this.vlP.vmA.value = false;
        djQ();
        AppMethodBeat.m2505o(27764);
    }

    public final void djN() {
        AppMethodBeat.m2504i(27765);
        this.vlP.vmu.value = false;
        djQ();
        AppMethodBeat.m2505o(27765);
    }

    public final void djO() {
        AppMethodBeat.m2504i(27766);
        this.vlP.vmC.value = false;
        djQ();
        AppMethodBeat.m2505o(27766);
    }

    public final void djP() {
        AppMethodBeat.m2504i(27767);
        this.vlP.vmI.value = false;
        djQ();
        AppMethodBeat.m2505o(27767);
    }

    public final void djQ() {
        int i;
        AppMethodBeat.m2504i(27768);
        int length = this.vlJ.length;
        for (i = 0; i < length; i++) {
            this.vlJ[i] = true;
        }
        if (this.vlP.vmn.value) {
            i = 0;
        } else {
            this.vlJ[0] = false;
            i = 1;
        }
        if (!this.vlP.vmm.value) {
            this.vlJ[1] = false;
            i++;
        }
        if (!this.vlP.vmI.value) {
            this.vlJ[16] = false;
            i++;
        }
        if (!(this.vlP.vmA.value && this.vlP.vmB.value)) {
            this.vlJ[6] = false;
            i++;
        }
        if (!this.vlP.vms.value) {
            this.vlJ[14] = false;
            i++;
        }
        if (!this.vlP.vmt.value) {
            C4990ab.m7416i("MicroMsg.AppPanel", "disable remittance");
            this.vlJ[8] = false;
            i++;
        }
        if (!this.vlP.vmo.value) {
            this.vlJ[12] = false;
            i++;
        }
        if (!this.vlP.vmC.value) {
            this.vlJ[13] = false;
            i++;
        }
        if (!this.vlP.vmF.value) {
            this.vlJ[3] = false;
            i++;
        }
        if (!this.vlP.vmp.value) {
            this.vlJ[11] = false;
            i++;
        }
        if (!this.vlP.vmv.value) {
            this.vlJ[5] = false;
            i++;
        }
        if (!(this.vlP.vmx.value && this.vlP.vmw.value)) {
            this.vlJ[4] = false;
            i++;
        }
        if (!(this.vlP.vmr.value && this.vlP.vmq.value)) {
            this.vlJ[2] = false;
            i++;
        }
        if (!(this.vlP.vmz.value && this.vlP.vmy.value)) {
            this.vlJ[10] = false;
            i++;
        }
        if (!this.vlP.vmE.value) {
            C4990ab.m7416i("MicroMsg.AppPanel", "disable lucky money");
            this.vlJ[7] = false;
            i++;
        }
        if (!this.vlP.vmG.value) {
            this.vlJ[15] = false;
            i++;
        }
        this.vlJ[9] = false;
        this.vlA = 17 - (i + 1);
        AppMethodBeat.m2505o(27768);
    }

    private int getScreenOrientation() {
        int i;
        AppMethodBeat.m2504i(27769);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i = 1;
        } else {
            i = 2;
        }
        AppMethodBeat.m2505o(27769);
        return i;
    }

    private void djR() {
        AppMethodBeat.m2504i(27770);
        C4990ab.m7410d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.vme = -1;
        this.qgO.removeAllViews();
        this.qgO.setOnMeasureListener(new C404651());
        this.qgO.setOnScreenChangedListener(new C404662());
        djT();
        AppMethodBeat.m2505o(27770);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refresh() {
        AppMethodBeat.m2504i(27771);
        C4990ab.m7417i("MicroMsg.AppPanel", "app panel refleshed: %s", Integer.valueOf(this.vlS));
        try {
            String value = C26373g.m41964Nu().getValue("ShowAPPSuggestion");
            int curScreen;
            if (C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                this.geU = C46494g.m87722a(this.context, false, this.vlS);
                C4990ab.m7416i("MicroMsg.AppPanel", "jacks not show App Suggestion");
                if (!djU()) {
                    AppPanel.m69455eh(this.geU);
                }
                m69454eg(this.geU);
                if (this.vlP != null) {
                    this.vlP.mo48399oJ(this.vlT);
                    this.vlP.mo48400oK(this.vlU);
                    this.vlP.mo48403oN(this.vlV);
                    this.vlP.mo48404oO(this.vlW);
                }
                curScreen = this.qgO.getCurScreen();
                chK();
                this.qgO.setToScreen(curScreen);
                this.qgP.setSelectedDot(curScreen);
                AppMethodBeat.m2505o(27771);
            }
            C4990ab.m7416i("MicroMsg.AppPanel", "jacks show App Suggestion");
            this.geU = C46494g.m87722a(this.context, true, this.vlS);
            if (djU()) {
            }
            m69454eg(this.geU);
            if (this.vlP != null) {
            }
            curScreen = this.qgO.getCurScreen();
            chK();
            this.qgO.setToScreen(curScreen);
            this.qgP.setSelectedDot(curScreen);
            AppMethodBeat.m2505o(27771);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.geU = C46494g.m87722a(this.context, false, this.vlS);
        }
    }

    private void chK() {
        AppMethodBeat.m2504i(27772);
        C4990ab.m7417i("MicroMsg.AppPanel", "init app grid: %s, %s", Integer.valueOf(this.qgM), Integer.valueOf(this.qgN));
        if (this.qgM == 0 || this.qgN == 0) {
            AppMethodBeat.m2505o(27772);
            return;
        }
        int i;
        Object obj;
        AppGrid appGrid;
        int b = C4977b.m7371b(this.context, 82.0f);
        int b2 = C4977b.m7371b(this.context, 90.0f);
        djQ();
        int i2 = 4;
        if (!this.vmc) {
            i2 = this.qgM / b;
        }
        b = this.qgN / b2;
        if (b > 2) {
            b = 2;
        }
        C4990ab.m7411d("MicroMsg.AppPanel", "jacks spacing2 = %d", Integer.valueOf((this.qgN - (b2 * b)) / (b + 1)));
        C4990ab.m7411d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", Integer.valueOf(this.qgM), Integer.valueOf(this.qgN));
        if (i2 == 0) {
            i = 1;
        } else {
            i = i2;
        }
        if (b == 0) {
            b = 1;
        }
        this.vlO = b;
        int i3 = i * b;
        if (this.vlP.vmu.value) {
            this.vlN = this.vlA + this.geU.size();
        } else {
            this.vlN = this.vlA;
        }
        int ceil = (int) Math.ceil(((double) this.vlN) / ((double) i3));
        C4990ab.m7417i("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d visibleLocalAppCount = %d infoList = %d", Integer.valueOf(this.vlN), Integer.valueOf(i3), Integer.valueOf(ceil), Integer.valueOf(this.vlA), Integer.valueOf(this.geU.size()));
        if (this.vme == ceil) {
            C4990ab.m7417i("MicroMsg.AppPanel", "mLastPageCount == pageCount! [%s:%s]", Integer.valueOf(this.vme), Integer.valueOf(ceil));
            obj = null;
        } else {
            int obj2 = 1;
        }
        if (obj2 != null) {
            this.vlM = new ArrayList();
            this.qgO.removeAllViews();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (ceil > 10) {
            C7060h.pYm.mo8381e(16776, Integer.valueOf(0), Integer.valueOf(1));
            C7060h.pYm.mo15419k(999, 1, 1);
        }
        C404673 c404673 = new C404673();
        C7305d.xDG.mo10159p(c404673, 5000);
        b = 0;
        while (b < ceil) {
            if (b >= ceil) {
                C4990ab.m7413e("MicroMsg.AppPanel", "my god! you see a ghost! %s", Integer.valueOf(ceil));
                C7060h.pYm.mo15419k(999, 0, 1);
                C7060h.pYm.mo8381e(16776, Integer.valueOf(1), Integer.valueOf(0));
                break;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (obj2 != null || this.vlM.size() <= b || this.vlM.get(b) == null) {
                appGrid = (AppGrid) AppPanel.inflate(this.context, 2130968751, null);
            } else {
                appGrid = (AppGrid) this.vlM.get(b);
            }
            C4990ab.m7417i("MicroMsg.AppPanel", "[initAppGrid] i:%s cost:%sms", Integer.valueOf(b), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            j += System.currentTimeMillis() - currentTimeMillis2;
            appGrid.mo69783d(this.geU, this.vmb);
            appGrid.mo69782b(b, this.vlN, i3, ceil, i, this.vlA);
            appGrid.mo69781La(r14);
            if (obj2 != null) {
                this.qgO.addView(appGrid, new LayoutParams(-1, -2));
                this.vlM.add(appGrid);
            }
            b++;
        }
        C7305d.xDG.remove((Runnable) c404673);
        C4990ab.m7417i("MicroMsg.AppPanel", "[initAppGrid] cost:%sms inflateCost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j));
        for (AppGrid appGrid2 : this.vlM) {
            appGrid2.setOnAppSelectedListener(this.vmf);
        }
        chL();
        this.vme = ceil;
        requestLayout();
        AppMethodBeat.m2505o(27772);
    }

    public int getPageMaxRowCount() {
        if (this.vlO != 0) {
            return this.vlO;
        }
        int i = (this.vlN + 3) / 4;
        if (i > 2) {
            return 2;
        }
        return i;
    }

    private void chL() {
        AppMethodBeat.m2504i(27773);
        if (this.vlM.size() <= 1) {
            this.qgP.setVisibility(4);
            AppMethodBeat.m2505o(27773);
            return;
        }
        this.qgP.setVisibility(0);
        this.qgP.setDotCount(this.vlM.size());
        int curScreen = this.qgO.getCurScreen();
        this.qgO.setToScreen(curScreen);
        this.qgP.setSelectedDot(curScreen);
        AppMethodBeat.m2505o(27773);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(27774);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            C4990ab.m7410d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.vmc = true;
            } else {
                this.vmc = false;
            }
            setNeedRefreshHeight(true);
            djS();
        }
        AppMethodBeat.m2505o(27774);
    }

    public final void djS() {
        AppMethodBeat.m2504i(27775);
        C4990ab.m7416i("MicroMsg.AppPanel", "[dealOrientationChange]");
        this.qgL = false;
        this.qgO.setToScreen(0);
        djR();
        requestLayout();
        AppMethodBeat.m2505o(27775);
    }

    public void setOnSwitchPanelListener(C30118b c30118b) {
        this.vlL = c30118b;
    }

    public void setAppPanelListener(C14934a c14934a) {
        this.vlK = c14934a;
    }

    public void setPortHeighDP(int i) {
        if (qgy != i) {
            qgy = i;
            this.vmh = true;
        }
    }

    public void setPortHeighPx(int i) {
        if (this.vmi != i) {
            this.vmi = i;
            this.vmh = true;
        }
    }

    public void setNeedRefreshHeight(boolean z) {
        this.vmh = z;
    }

    /* renamed from: AG */
    public final void mo63871AG() {
        AppMethodBeat.m2504i(27776);
        C4990ab.m7416i("MicroMsg.AppPanel", "[forceRefreshSize]");
        djT();
        djS();
        AppMethodBeat.m2505o(27776);
    }

    public final void djT() {
        AppMethodBeat.m2504i(27777);
        if (this.vmh) {
            View findViewById;
            LayoutParams layoutParams;
            if (getScreenOrientation() == 2) {
                C4990ab.m7410d("MicroMsg.AppPanel", "initFlipper, landscape");
                findViewById = findViewById(2131821453);
                layoutParams = new LayoutParams(-1, 0);
                layoutParams.height = C4977b.m7371b(this.context, (float) qgz);
                findViewById.setLayoutParams(layoutParams);
            } else {
                C4990ab.m7411d("MicroMsg.AppPanel", "initFlipper, portrait: %d", Integer.valueOf(qgy));
                findViewById = findViewById(2131821453);
                layoutParams = new LayoutParams(-1, 0);
                layoutParams.height = getPortHeightPX();
                findViewById.setLayoutParams(layoutParams);
            }
            this.vmh = false;
        }
        AppMethodBeat.m2505o(27777);
    }

    private int getPortHeightPX() {
        AppMethodBeat.m2504i(27778);
        int i;
        if (this.vmi > 0) {
            i = this.vmi;
            AppMethodBeat.m2505o(27778);
            return i;
        }
        i = C4977b.m7371b(this.context, (float) qgy);
        AppMethodBeat.m2505o(27778);
        return i;
    }

    /* renamed from: eh */
    private static void m69455eh(List<C40439f> list) {
        AppMethodBeat.m2504i(27779);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(27779);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C40439f c40439f = (C40439f) list.get(i2);
                if (c40439f == null || !C40439f.vbR.equals(c40439f.field_appId)) {
                    i = i2 + 1;
                } else {
                    list.remove(c40439f);
                    C4990ab.m7416i("MicroMsg.AppPanel", "do remove card");
                    AppMethodBeat.m2505o(27779);
                    return;
                }
            }
            AppMethodBeat.m2505o(27779);
            return;
        }
    }

    private boolean djU() {
        AppMethodBeat.m2504i(27780);
        if (this.vma) {
            AppMethodBeat.m2505o(27780);
            return false;
        }
        C33762b c33762b = (C33762b) C1720g.m3528K(C33762b.class);
        if (c33762b == null) {
            AppMethodBeat.m2505o(27780);
            return false;
        } else if (!c33762b.bbn() || c33762b.bbq() <= 0) {
            AppMethodBeat.m2505o(27780);
            return false;
        } else {
            AppMethodBeat.m2505o(27780);
            return true;
        }
    }
}

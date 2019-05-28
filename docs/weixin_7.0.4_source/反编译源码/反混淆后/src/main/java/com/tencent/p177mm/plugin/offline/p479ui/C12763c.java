package com.tencent.p177mm.plugin.offline.p479ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.offline.C34645g;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p478a.C12736e;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21410g;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C7004b;
import com.tencent.p177mm.plugin.offline.p478a.C28627c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q.C29682c;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q.C40134a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C40933h;

/* renamed from: com.tencent.mm.plugin.offline.ui.c */
public final class C12763c {
    Vibrator kgA;
    Activity mActivity;
    C3566a oZn;
    C40131q oZo;
    float oZp = 0.0f;
    int oZq = C1625i.sHCENCODEVIDEOTIMEOUT;

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$8 */
    class C127628 implements OnClickListener {
        C127628() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43478);
            dialogInterface.dismiss();
            C28630a.bYo();
            C30379h.m48465bQ(C12763c.this.mActivity, C12763c.this.mActivity.getResources().getString(C25738R.string.fvj));
            C12763c.m20777a(C12763c.this);
            AppMethodBeat.m2505o(43478);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$11 */
    class C1276411 implements OnClickListener {
        final /* synthetic */ C21410g oZt;

        C1276411(C21410g c21410g) {
            this.oZt = c21410g;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43481);
            dialogInterface.dismiss();
            if (C12763c.this.oZn != null) {
                C12763c.this.oZn.mo8134e(1, this.oZt.f4389id, "", this.oZt.cBT);
            }
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
            AppMethodBeat.m2505o(43481);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$13 */
    class C1276513 implements C29682c {
        final /* synthetic */ C21410g oZt;

        C1276513(C21410g c21410g) {
            this.oZt = c21410g;
        }

        /* renamed from: a */
        public final void mo9392a(String str, FavorPayInfo favorPayInfo, boolean z) {
            AppMethodBeat.m2504i(43483);
            if (C12763c.this.mActivity instanceof MMActivity) {
                ((MMActivity) C12763c.this.mActivity).aqX();
            }
            if (C12763c.this.oZn != null) {
                C12763c.this.oZn.mo8134e(1, this.oZt.f4389id, str, this.oZt.cBT);
            }
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
            AppMethodBeat.m2505o(43483);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$14 */
    class C1276614 implements OnCancelListener {
        C1276614() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(43484);
            C12763c.this.bXv();
            AppMethodBeat.m2505o(43484);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$1 */
    class C127671 extends C4884c<C32652uv> {
        final /* synthetic */ PayInfo oZr;

        C127671(PayInfo payInfo) {
            this.oZr = payInfo;
            AppMethodBeat.m2504i(43472);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(43472);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43473);
            C32652uv c32652uv = (C32652uv) c4883b;
            C4879a.xxA.mo10053d(this);
            if (c32652uv.cRF.result == 0) {
                C1207m c28627c = new C28627c(this.oZr.czZ, this.oZr.cIf, this.oZr.cIb);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c28627c, 0);
                C34645g.bXc();
                C12763c.this.oZn.bXu();
            } else if (c32652uv.cRF.result == -1) {
                C34645g.bXc();
                C12763c.this.oZn.bXu();
            }
            AppMethodBeat.m2505o(43473);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$12 */
    class C1276812 implements OnClickListener {
        final /* synthetic */ C21410g oZt;

        C1276812(C21410g c21410g) {
            this.oZt = c21410g;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43482);
            dialogInterface.dismiss();
            if (C12763c.this.oZn != null) {
                C12763c.this.oZn.mo8134e(0, this.oZt.f4389id, "", this.oZt.cBT);
            }
            C34645g.m56847cM(this.oZt.cBT, C34645g.oXg);
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
            AppMethodBeat.m2505o(43482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$15 */
    class C1276915 implements C40134a {
        final /* synthetic */ C21410g oZt;

        C1276915(C21410g c21410g) {
            this.oZt = c21410g;
        }

        public final void bXx() {
            AppMethodBeat.m2504i(43485);
            if (C12763c.this.oZn != null) {
                C12763c.this.oZn.mo8134e(0, this.oZt.f4389id, "", this.oZt.cBT);
            }
            C34645g.m56847cM(this.oZt.cBT, C34645g.oXg);
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
            AppMethodBeat.m2505o(43485);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$2 */
    class C127702 implements OnClickListener {
        C127702() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$9 */
    class C127719 implements OnClickListener {
        C127719() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43479);
            dialogInterface.dismiss();
            C28630a.bYo();
            C30379h.m48465bQ(C12763c.this.mActivity, C12763c.this.mActivity.getResources().getString(C25738R.string.fvj));
            C12763c.m20777a(C12763c.this);
            AppMethodBeat.m2505o(43479);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$18 */
    class C1277218 implements OnClickListener {
        C1277218() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43487);
            C35899h.m58861aj(C12763c.this.mActivity, 0);
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
            AppMethodBeat.m2505o(43487);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$5 */
    class C127735 implements OnClickListener {
        C127735() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43475);
            dialogInterface.dismiss();
            C28630a.m45495U(C12763c.this.mActivity);
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
            AppMethodBeat.m2505o(43475);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$10 */
    class C1277410 implements OnClickListener {
        C1277410() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43480);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(43480);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$16 */
    class C1277516 implements OnClickListener {
        C1277516() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43486);
            C35899h.m58861aj(C12763c.this.mActivity, 0);
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
            AppMethodBeat.m2505o(43486);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$3 */
    class C127763 implements OnClickListener {
        C127763() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43474);
            C12763c.this.oZn.bXr();
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
            AppMethodBeat.m2505o(43474);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$6 */
    class C127776 implements OnClickListener {
        C127776() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43476);
            dialogInterface.dismiss();
            C12763c.this.mActivity.finish();
            AppMethodBeat.m2505o(43476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$7 */
    class C127787 implements OnClickListener {
        C127787() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43477);
            ((C40167b) C1720g.m3528K(C40167b.class)).mo38290b(C12763c.this.mActivity, new Intent());
            AppMethodBeat.m2505o(43477);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$17 */
    class C1277917 implements OnClickListener {
        C1277917() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$4 */
    class C127804 implements OnClickListener {
        C127804() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public C12763c(Activity activity, C3566a c3566a) {
        this.mActivity = activity;
        this.oZn = c3566a;
    }

    public final void init() {
        AppMethodBeat.m2504i(43488);
        this.kgA = (Vibrator) this.mActivity.getSystemService("vibrator");
        AppMethodBeat.m2505o(43488);
    }

    /* renamed from: a */
    public final void mo24765a(C1207m c1207m, int i, String str) {
        AppMethodBeat.m2504i(43489);
        mo24766a(c1207m, i, str, null);
        AppMethodBeat.m2505o(43489);
    }

    /* renamed from: a */
    public final void mo24766a(C1207m c1207m, int i, String str, String str2) {
        AppMethodBeat.m2504i(43490);
        C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i + " msg:" + str);
        bXv();
        if (i == 409) {
            m20775Ub(str);
            AppMethodBeat.m2505o(43490);
        } else if (i == 410) {
            m20774Ua(str);
            AppMethodBeat.m2505o(43490);
        } else if (i == 413) {
            m20776Uc(str);
            AppMethodBeat.m2505o(43490);
        } else if (i == 411) {
            if (C14241r.cPI().cQi() || C14241r.cPI().cQh()) {
                C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
                AppMethodBeat.m2505o(43490);
                return;
            }
            if (C7007k.oXK && (this.mActivity instanceof WalletOfflineCoinPurseUI)) {
                ((WalletOfflineCoinPurseUI) this.mActivity).bXT();
            } else {
                C28630a.m45518c(this.mActivity, str);
            }
            C7060h.pYm.mo8378a(135, 1, 1, true);
            AppMethodBeat.m2505o(43490);
        } else if (this.mActivity instanceof WalletBaseUI) {
            if (!C40933h.m70996a((WalletBaseUI) this.mActivity, c1207m, 1000, i, str)) {
                C12759b.m20773c(this.mActivity, str, str2);
            }
            AppMethodBeat.m2505o(43490);
        } else {
            C12759b.m20772b(this.mActivity, str);
            AppMethodBeat.m2505o(43490);
        }
    }

    /* renamed from: c */
    public final boolean mo24769c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(43491);
        C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " cgi type:" + c1207m.getType());
        C12736e c12736e;
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C12736e) {
                c12736e = (C12736e) c1207m;
                String str2 = c12736e.oXY;
                bXv();
                if (c12736e.oXZ != 0 || TextUtils.isEmpty(str2)) {
                    if (!(c12736e.oXZ == 0 || c12736e.kCl == 0 || c12736e.oYb != 1)) {
                        C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                        mo24765a(c12736e, c12736e.oXZ, c12736e.oYa);
                    }
                    z = true;
                } else {
                    C28630a.m45513a(this.mActivity, str2, c1207m);
                    this.mActivity.setResult(-1);
                    this.mActivity.finish();
                    z = true;
                }
            }
        } else if (c1207m instanceof C12736e) {
            c12736e = (C12736e) c1207m;
            bXv();
            if (c12736e.oYb == 1) {
                C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                mo24765a(c1207m, i2, str);
            }
            z = true;
        }
        AppMethodBeat.m2505o(43491);
        return z;
    }

    public final void bXv() {
        AppMethodBeat.m2504i(43492);
        if (this.oZo != null) {
            this.oZo.dismiss();
            this.oZo = null;
        }
        AppMethodBeat.m2505o(43492);
    }

    /* renamed from: Ua */
    private void m20774Ua(String str) {
        AppMethodBeat.m2504i(43493);
        C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(str)));
        C30379h.m48466d(this.mActivity, str, "", getString(C25738R.string.fnt), getString(C25738R.string.f9076or), new C1277516(), new C1277917());
        AppMethodBeat.m2505o(43493);
    }

    /* renamed from: Ub */
    private void m20775Ub(String str) {
        AppMethodBeat.m2504i(43494);
        C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(str)));
        C30379h.m48466d(this.mActivity, str, "", getString(C25738R.string.fvy), getString(C25738R.string.f9076or), new C1277218(), new C127702());
        AppMethodBeat.m2505o(43494);
    }

    /* renamed from: Uc */
    private void m20776Uc(String str) {
        AppMethodBeat.m2504i(43495);
        C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(str)));
        C30379h.m48466d(this.mActivity, str, "", getString(C25738R.string.fva), getString(C25738R.string.f9076or), new C127763(), new C127804());
        AppMethodBeat.m2505o(43495);
    }

    /* renamed from: a */
    public final void mo24767a(C7004b c7004b) {
        AppMethodBeat.m2504i(43496);
        if (c7004b == null) {
            AppMethodBeat.m2505o(43496);
            return;
        }
        C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
        if ("1".equals(c7004b.oYP)) {
            C30379h.m48453a(this.mActivity, false, c7004b.oYR, "", getString(C25738R.string.fvo), getString(C25738R.string.f9076or), new C127735(), new C127776());
        }
        AppMethodBeat.m2505o(43496);
    }

    public static boolean bXw() {
        AppMethodBeat.m2504i(43497);
        C7007k.bXg();
        if (C7007k.bXh().oYL != null) {
            AppMethodBeat.m2505o(43497);
            return true;
        }
        AppMethodBeat.m2505o(43497);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final String getString(int i) {
        AppMethodBeat.m2504i(43498);
        String string = this.mActivity.getString(i);
        AppMethodBeat.m2505o(43498);
        return string;
    }
}

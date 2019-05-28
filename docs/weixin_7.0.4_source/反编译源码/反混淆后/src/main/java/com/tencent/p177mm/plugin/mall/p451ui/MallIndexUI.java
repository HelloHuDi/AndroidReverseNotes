package com.tencent.p177mm.plugin.mall.p451ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p230g.p231a.C18416uq.C18417b;
import com.tencent.p177mm.p230g.p231a.C26260vc;
import com.tencent.p177mm.p230g.p231a.C26267vw;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p230g.p231a.C6517lu;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.mall.p1489b.C34508a;
import com.tencent.p177mm.plugin.mall.p450a.C28465e;
import com.tencent.p177mm.plugin.mall.p450a.C39350d;
import com.tencent.p177mm.plugin.mall.p450a.C43288j;
import com.tencent.p177mm.plugin.mall.p450a.C46067i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.plugin.wallet_core.model.C29629ai;
import com.tencent.p177mm.plugin.wallet_core.model.C40114n;
import com.tencent.p177mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7187a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7188b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C16077f;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.math.RoundingMode;

@C18524i
/* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI */
public class MallIndexUI extends MallIndexBaseUI {
    private String cRs;
    private boolean eTM = false;
    private View jNV = null;
    private TextView omQ = null;
    private boolean omR = false;
    C18417b onh;
    private RelativeLayout oni;
    private boolean onj;
    private boolean onk;
    C7186s onl = new C7186s();
    private boolean onm = false;
    private Dialog onn;
    private boolean ono = false;
    private C4884c<C6517lu> onp = new C345121();
    private boolean onq = false;
    private C4884c onr = new C345199();
    private C4884c<C26267vw> ons = new C3451610();
    private boolean ont = false;

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$11 */
    class C1248111 implements C7188b {
        C1248111() {
        }

        public final int bNq() {
            return 3;
        }

        public final Context getContext() {
            return MallIndexUI.this;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$5 */
    class C124825 implements OnMenuItemClickListener {
        C124825() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(43209);
            C7060h.pYm.mo8381e(14872, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0));
            C7060h.pYm.mo8381e(16500, Integer.valueOf(3));
            Context context = MallIndexUI.this;
            boolean z = MallIndexUI.this.onh.cRa;
            Intent intent = new Intent();
            intent.putExtra("key_default_show_currency", z);
            C25985d.m41467b(context, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
            AppMethodBeat.m2505o(43209);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$13 */
    class C2126613 implements Runnable {
        C2126613() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43218);
            int ge = C1338a.m2869ge(MallIndexUI.this.mController.ylL);
            int fromDPToPix = C1338a.fromDPToPix(MallIndexUI.this.mController.ylL, 53);
            int[] iArr = new int[2];
            MallIndexUI.this.omu.getLocationInWindow(iArr);
            int bottom = (MallIndexUI.this.omE.getBottom() + iArr[1]) - ge;
            int height = (MallIndexUI.this.omu.getHeight() - MallIndexUI.this.omE.getHeight()) + iArr[1];
            if (bottom > 0) {
                height += bottom;
            }
            fromDPToPix = (ge - height) - fromDPToPix;
            int fromDPToPix2 = C1338a.fromDPToPix(MallIndexUI.this.mController.ylL, 33);
            C4990ab.m7411d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", Integer.valueOf(ge), Integer.valueOf(height), Integer.valueOf(MallIndexUI.this.omE.getHeight()), Integer.valueOf(iArr[1]), Integer.valueOf(bottom), Integer.valueOf(fromDPToPix));
            if (fromDPToPix > fromDPToPix2) {
                MallIndexUI.this.omE.setPadding(0, fromDPToPix, 0, fromDPToPix2);
                AppMethodBeat.m2505o(43218);
                return;
            }
            MallIndexUI.this.omE.setPadding(0, fromDPToPix2, 0, fromDPToPix2);
            AppMethodBeat.m2505o(43218);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$12 */
    class C2847312 implements OnClickListener {
        C2847312() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43217);
            C4990ab.m7416i("MicorMsg.MallIndexUI", "click settings btn");
            C25985d.m41448H(MallIndexUI.this.mController.ylL, "mall", ".ui.MallFunctionSettingsUI");
            AppMethodBeat.m2505o(43217);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$14 */
    class C2847414 implements OnClickListener {
        C2847414() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43219);
            Intent intent = new Intent();
            intent.putExtra("key_from_scene", 1);
            C25985d.m41467b(MallIndexUI.this.mController.ylL, "offline", ".ui.WalletOfflineEntranceUI", intent);
            C36381z.m59954hL(9, 0);
            C7060h.pYm.mo8381e(11850, Integer.valueOf(5), Integer.valueOf(0));
            C7060h.pYm.mo8381e(14419, MallIndexUI.this.eCq, Integer.valueOf(1));
            AppMethodBeat.m2505o(43219);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$6 */
    class C284756 implements C16077f {
        C284756() {
        }

        public final void bMI() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$4 */
    class C313744 implements C7187a {
        C313744() {
        }

        public final void bNo() {
        }

        public final void cancel() {
            AppMethodBeat.m2504i(43208);
            MallIndexUI.this.finish();
            AppMethodBeat.m2505o(43208);
        }

        public final void bNp() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$1 */
    class C345121 extends C4884c<C6517lu> {
        C345121() {
            AppMethodBeat.m2504i(43204);
            this.xxI = C6517lu.class.getName().hashCode();
            AppMethodBeat.m2505o(43204);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43205);
            C4990ab.m7416i("MicorMsg.MallIndexUI", "open ecard finish");
            ECardInfo.m68756aw(null);
            AppMethodBeat.m2505o(43205);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$15 */
    class C3451315 implements OnClickListener {
        C3451315() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43220);
            MallIndexUI.m56585c(MallIndexUI.this);
            AppMethodBeat.m2505o(43220);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$10 */
    class C3451610 extends C4884c<C26267vw> {
        C3451610() {
            AppMethodBeat.m2504i(43214);
            this.xxI = C26267vw.class.getName().hashCode();
            AppMethodBeat.m2505o(43214);
        }

        /* renamed from: a */
        private static boolean m56594a(C26267vw c26267vw) {
            AppMethodBeat.m2504i(43215);
            C4990ab.m7417i("MicorMsg.MallIndexUI", "get result %s", c26267vw.cTd.cBp);
            if ("agree_privacy".equals(c26267vw.cTd.cBp)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.TRUE);
            }
            AppMethodBeat.m2505o(43215);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$2 */
    class C345182 implements OnDismissListener {
        C345182() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(43206);
            MallIndexUI.this.onn = null;
            AppMethodBeat.m2505o(43206);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$9 */
    class C345199 extends C4884c<C26260vc> {
        C345199() {
            AppMethodBeat.m2504i(43212);
            this.xxI = C26260vc.class.getName().hashCode();
            AppMethodBeat.m2505o(43212);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43213);
            C4990ab.m7417i("MicorMsg.MallIndexUI", "real name verify callback, result: %s, isDoRealNameForBalance: %s", Integer.valueOf(((C26260vc) c4883b).cRZ.result), Boolean.valueOf(MallIndexUI.this.onq));
            if (((C26260vc) c4883b).cRZ.result == -1 && MallIndexUI.this.onq) {
                MallIndexUI.this.onq = false;
                MallIndexUI.m56585c(MallIndexUI.this);
            }
            AppMethodBeat.m2505o(43213);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MallIndexUI() {
        AppMethodBeat.m2504i(43222);
        AppMethodBeat.m2505o(43222);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(43223);
        C4990ab.m7417i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        super.onActivityResult(i, i2, intent);
        if (i != 3) {
            if (i == 5) {
                C1720g.m3537RQ();
                if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    finish();
                }
            }
            AppMethodBeat.m2505o(43223);
        } else if (i2 == -1) {
            this.onl.bNo();
            AppMethodBeat.m2505o(43223);
        } else {
            this.onl.cancel();
            AppMethodBeat.m2505o(43223);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
        AppMethodBeat.m2504i(43225);
        int color = getResources().getColor(C25738R.color.f12164uk);
        mo17446xE(color);
        dyb();
        findViewById(2131825792).setBackgroundColor(color);
        AppMethodBeat.m2505o(43225);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bbC() {
        AppMethodBeat.m2504i(43226);
        setMMTitle((int) C25738R.string.cwn);
        AppMethodBeat.m2505o(43226);
    }

    public final void initView() {
        AppMethodBeat.m2504i(43227);
        super.initView();
        this.omu.setPadding(C43291a.olm, 0, C43291a.olm, 0);
        AppMethodBeat.m2505o(43227);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initHeaderView() {
        AppMethodBeat.m2504i(43228);
        this.omD = C5616v.m8409hu(this).inflate(2130970034, null);
        this.omu.addHeaderView(this.omD, null, false);
        LinearLayout linearLayout = (LinearLayout) this.omD.findViewById(2131825767);
        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.height = C43291a.bMX();
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(43228);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bGb() {
        AppMethodBeat.m2504i(43229);
        this.omC = C43288j.bMV().mo68836yl(this.okT).field_isShowSetting;
        if (this.omE == null) {
            this.omE = C5616v.m8409hu(this).inflate(2130970035, null);
            this.omu.addFooterView(this.omE, null, false);
            View view = (TextView) this.omE.findViewById(2131825772);
            C36391e.m59990aA(view, 100);
            view.setOnClickListener(new C2847312());
        }
        C4990ab.m7417i("MicorMsg.MallIndexUI", "is show setting: %s", Integer.valueOf(this.omC));
        if (this.omC == 0) {
            this.omE.setVisibility(8);
            this.omE.setPadding(0, 0, 0, 0);
            AppMethodBeat.m2505o(43229);
            return;
        }
        this.omE.setVisibility(0);
        getWindow().getDecorView().post(new C2126613());
        AppMethodBeat.m2505o(43229);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dp */
    public final void mo7886dp(View view) {
        int i;
        AppMethodBeat.m2504i(43230);
        C1720g.m3537RQ();
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (!booleanValue || longValue <= 0 || System.currentTimeMillis() < longValue) {
            boolean i2 = booleanValue;
        } else {
            C4990ab.m7416i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
            i2 = 0;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131825768);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131825769);
        this.omy = (TextView) linearLayout2.findViewById(2131825771);
        ImageView imageView = (ImageView) linearLayout2.findViewById(2131825770);
        if (i2 != 0) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        linearLayout.setOnClickListener(new C2847414());
        linearLayout2.setOnClickListener(new C3451315());
        AppMethodBeat.m2505o(43230);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNh() {
        AppMethodBeat.m2504i(43231);
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "1";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(43221);
                if (!C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C36391e.m59985a(MallIndexUI.this.omz, c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                }
                AppMethodBeat.m2505o(43221);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        AppMethodBeat.m2505o(43231);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bNm() {
        AppMethodBeat.m2504i(43233);
        if (this.omx == null) {
            AppMethodBeat.m2505o(43233);
            return;
        }
        if (!(C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC) || this.onh.cQV)) {
            int i;
            C40114n c40114n = C14241r.cPI().tCW;
            if (c40114n != null) {
                int i2 = c40114n.field_red_dot_index;
                C1720g.m3537RQ();
                if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(-1))).intValue() >= i2 || i2 <= 0) {
                    C4990ab.m7416i("MicorMsg.MallIndexUI", "bankcard do not need red point");
                } else {
                    C4990ab.m7416i("MicorMsg.MallIndexUI", "bankcard need red point");
                    i = 1;
                    if (i == 0) {
                        this.omx.setVisibility(8);
                        AppMethodBeat.m2505o(43233);
                        return;
                    }
                }
            }
            i = 0;
            if (i == 0) {
            }
        }
        this.omx.setVisibility(0);
        AppMethodBeat.m2505o(43233);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNi() {
        AppMethodBeat.m2504i(43234);
        C4990ab.m7416i("MicorMsg.MallIndexUI", "updateBalanceNum");
        C29629ai c29629ai = new C29629ai();
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", Boolean.valueOf((c29629ai.tCP & 16384) > 0), Integer.valueOf(c29629ai.tCP));
        if ((c29629ai.tCP & 16384) > 0) {
            C1720g.m3537RQ();
            this.omy.setText((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, getString(C25738R.string.dil)));
            this.omy.setVisibility(0);
            m56591iQ(c29629ai.cQf());
            AppMethodBeat.m2505o(43234);
            return;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", Boolean.valueOf((c29629ai.tCP & 4194304) > 0), Integer.valueOf(c29629ai.tCP));
        if ((c29629ai.tCP & 4194304) > 0) {
            long j;
            C4990ab.m7416i("MicorMsg.MallIndexUI", "show balance amount");
            C22587ak cPI = C14241r.cPI();
            if (cPI.tCT != null) {
                j = cPI.tCT.field_wallet_balance;
            } else {
                j = -1;
            }
            if (j < 0) {
                C4990ab.m7420w("MicorMsg.MallIndexUI", "wallet balance is null!");
            } else {
                this.omy.setText(C36391e.m59972G(C36391e.m59981a(String.valueOf(j), "100", 2, RoundingMode.HALF_UP).doubleValue()));
                this.omy.setVisibility(0);
                m56591iQ(c29629ai.cQf());
                AppMethodBeat.m2505o(43234);
                return;
            }
        }
        this.omy.setVisibility(8);
        AppMethodBeat.m2505o(43234);
    }

    /* renamed from: iQ */
    private void m56591iQ(boolean z) {
        AppMethodBeat.m2504i(43235);
        if (z) {
            this.omy.setText(getString(C25738R.string.ffw));
        }
        AppMethodBeat.m2505o(43235);
    }

    public void onResume() {
        AppMethodBeat.m2504i(43237);
        C4990ab.m7418v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
        this.onl.onResume();
        C40167b c40167b = (C40167b) C1720g.m3528K(C40167b.class);
        c40167b.mo38287a(this, c40167b.cTi(), null);
        super.onResume();
        AppMethodBeat.m2505o(43237);
    }

    public void onPause() {
        AppMethodBeat.m2504i(43238);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.m2505o(43238);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43239);
        super.onDestroy();
        this.onp.dead();
        this.ons.dead();
        mo39993ng(2713);
        mo39993ng(385);
        C4879a.xxA.mo10053d(this.onr);
        AppMethodBeat.m2505o(43239);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNa() {
        AppMethodBeat.m2504i(43240);
        C34508a.bNu();
        AppMethodBeat.m2505o(43240);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNb() {
        AppMethodBeat.m2504i(43241);
        C14241r.cPE().cRh();
        if ((C14241r.cPE().cRh().cQj() || C14241r.cPE().cRh().cQi()) && C1853r.m3831YM()) {
            C4990ab.m7412e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
            mo39970a(new C46358a("", false), true, false);
        }
        AppMethodBeat.m2505o(43241);
    }

    public void finish() {
        AppMethodBeat.m2504i(43242);
        this.eTM = true;
        super.finish();
        AppMethodBeat.m2505o(43242);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43243);
        super.mo7885c(i, i2, str, c1207m);
        if (c1207m instanceof C28465e) {
            m56579a(((C28465e) c1207m).okN);
        } else if (c1207m instanceof C35475y) {
            C35475y c35475y = (C35475y) c1207m;
            if (c35475y.bLD() && c35475y.nYe.mo39946a((Activity) this, new C284756())) {
                AppMethodBeat.m2505o(43243);
                return true;
            }
        }
        AppMethodBeat.m2505o(43243);
        return true;
    }

    /* renamed from: a */
    private void m56579a(final C39350d c39350d) {
        AppMethodBeat.m2504i(43244);
        if (c39350d == null || C5046bo.isNullOrNil(c39350d.okM)) {
            AppMethodBeat.m2505o(43244);
        } else if (this.omR) {
            if (this.omQ != null) {
                this.omQ.setText(C25738R.string.cwj);
                this.omQ.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(43210);
                        Intent intent = new Intent();
                        C36391e.m60000bV(MallIndexUI.this, c39350d.okM);
                        AppMethodBeat.m2505o(43210);
                    }
                });
            }
            AppMethodBeat.m2505o(43244);
        } else {
            this.jNV = View.inflate(this, 2130970032, null);
            this.jNV.setClickable(false);
            this.jNV.setEnabled(false);
            this.omQ = (TextView) this.jNV.findViewById(2131825757);
            this.omQ.setVisibility(0);
            this.omQ.setText(C25738R.string.cwj);
            this.omQ.setTextColor(getResources().getColor(C25738R.color.f12123t7));
            this.omQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(43211);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", c39350d.okM);
                    C25985d.m41467b(MallIndexUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(43211);
                }
            });
            this.omu.addFooterView(this.jNV);
            this.omR = true;
            AppMethodBeat.m2505o(43244);
        }
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43224);
        this.yll = true;
        ((C40167b) C1720g.m3528K(C40167b.class)).mo38286a(this, null);
        C22594k.m34292Hp(2);
        this.onh = new C18417b();
        this.onh.cQT = false;
        this.onh.cQU = true;
        this.onh.cQV = false;
        this.onp.dnU();
        this.ons.dnU();
        this.onl.tLw = new C1248111();
        C46068c.m85830iR(true);
        C43291a.m77161a(this, false, true);
        super.onCreate(bundle);
        C4879a.xxA.mo10052c(this.onr);
        mo39992nf(2713);
        mo39992nf(385);
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            C1720g.m3537RQ();
            m56579a(new C39350d((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_INDEX_GDPR_CACHE_STRING_SYNC, (Object) "")));
            C1720g.m3537RQ();
            ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            mo39970a(new C28465e(), false, false);
        }
        C7060h.pYm.mo8381e(16500, Integer.valueOf(1));
        AppMethodBeat.m2505o(43224);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bNd() {
        AppMethodBeat.m2504i(43232);
        C4990ab.m7416i("MicorMsg.MallIndexUI", "init BankcardList");
        final C4883b c18416uq = new C18416uq();
        c18416uq.cQP.scene = 1;
        c18416uq.cQP.cQR = true;
        c18416uq.cQP.cQS = true;
        c18416uq.cQQ.cQH = new Runnable() {
            boolean ftW = false;

            /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexUI$3$1 */
            class C345151 implements C16077f {
                C345151() {
                }

                public final void bMI() {
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(43207);
                C4990ab.m7410d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.this.onh.cQU + " hasNewTips : " + MallIndexUI.this.onh.cQV + " swipeOn : " + MallIndexUI.this.onh.cQW);
                if (MallIndexUI.this.eTM || MallIndexUI.this.mController.ylL.isFinishing()) {
                    C4990ab.m7412e("MicorMsg.MallIndexUI", "error for callback ac finish");
                    AppMethodBeat.m2505o(43207);
                    return;
                }
                C4990ab.m7417i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", Boolean.valueOf(c18416uq.cQQ.cRt), Boolean.valueOf(this.ftW));
                MallIndexUI.this.onh = c18416uq.cQQ;
                if (((MallIndexUI.this.onh.cRu != null ? 1 : 0) & (MallIndexUI.this.onh.cRu instanceof C5749m)) != 0) {
                    C5749m c5749m = (C5749m) MallIndexUI.this.onh.cRu;
                    if (c5749m.bLD()) {
                        c5749m.nYe.mo39946a(MallIndexUI.this, new C345151());
                    }
                }
                if (MallIndexUI.this.onh.errCode == 0) {
                    MallIndexUI.this.bNm();
                    MallIndexUI.this.bNi();
                    MallIndexUI mallIndexUI = MallIndexUI.this;
                    C4990ab.m7416i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
                    if (mallIndexUI.onh == null || !(mallIndexUI.onh.cQT || mallIndexUI.onh.cQZ)) {
                        C4990ab.m7412e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
                    } else {
                        boolean booleanValue;
                        boolean cQa = C14241r.cPI().cQo().cQa();
                        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
                        if (obj != null) {
                            booleanValue = ((Boolean) obj).booleanValue();
                        } else {
                            booleanValue = false;
                        }
                        C4990ab.m7416i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + booleanValue + ";isswc=" + cQa);
                        if (!booleanValue && cQa) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
                            C5652a c5652a = new C5652a(mallIndexUI);
                            View inflate = LayoutInflater.from(mallIndexUI).inflate(2130971175, null, false);
                            TextView textView = (TextView) inflate.findViewById(2131829071);
                            ((ImageView) inflate.findViewById(2131829070)).setImageResource(C25738R.drawable.blv);
                            textView.setText(C25738R.string.cwq);
                            c5652a.mo11483rd(true);
                            c5652a.mo11482rc(false);
                            c5652a.mo11479fn(inflate);
                            c5652a.mo11446PV(C25738R.string.ftt);
                            c5652a.mo11453Qc(C25738R.string.g0z);
                            c5652a.aMb().show();
                        }
                    }
                    if (!this.ftW) {
                        MallIndexUI.bNn();
                    }
                    MallIndexUI.m56583b(MallIndexUI.this, MallIndexUI.this.onh);
                    MallIndexUI.this.bNk();
                    C4990ab.m7417i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", Integer.valueOf(MallIndexUI.this.onh.cRq), Boolean.valueOf(MallIndexUI.this.onh.cRr), MallIndexUI.this.onh.cRs);
                    MallIndexUI.this.onj = MallIndexUI.this.onh.cRq == 1;
                    MallIndexUI.this.onk = MallIndexUI.this.onh.cRr;
                    MallIndexUI.this.cRs = MallIndexUI.this.onh.cRs;
                    if (MallIndexUI.this.oni != null) {
                        if (MallIndexUI.this.onj) {
                            MallIndexUI.this.oni.setVisibility(0);
                        } else {
                            MallIndexUI.this.oni.setVisibility(8);
                        }
                    }
                    MallIndexUI mallIndexUI2 = MallIndexUI.this;
                    mallIndexUI2.onl.mo15494a(new C313744(), new C29629ai().cQe());
                }
                if (c18416uq.cQQ.cRt && this.ftW) {
                    MallIndexUI.this.mo76125cu();
                }
                this.ftW = true;
                AppMethodBeat.m2505o(43207);
            }
        };
        C4879a.xxA.mo10048a(c18416uq, Looper.myLooper());
        AppMethodBeat.m2505o(43232);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNk() {
        AppMethodBeat.m2504i(43236);
        this.mController.removeAllOptionMenu();
        C4990ab.m7416i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
        this.mController.addIconOptionMenu(0, 0, (int) C25738R.drawable.f6899uu, false, new C124825());
        C7060h.pYm.mo8381e(14872, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1));
        AppMethodBeat.m2505o(43236);
    }

    /* renamed from: c */
    static /* synthetic */ void m56585c(MallIndexUI mallIndexUI) {
        AppMethodBeat.m2504i(43245);
        if (C1853r.m3831YM()) {
            Intent intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            C25985d.m41467b((Context) mallIndexUI, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            ImageView imageView = (ImageView) mallIndexUI.findViewById(2131825770);
            mallIndexUI.startActivity(new Intent(mallIndexUI.mController.ylL, MallWalletUI.class));
            imageView.setVisibility(8);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
            C7060h.pYm.mo8381e(16500, Integer.valueOf(2));
        }
        C36391e.m59978QS(11);
        C7060h.pYm.mo8381e(14419, mallIndexUI.eCq, Integer.valueOf(2));
        AppMethodBeat.m2505o(43245);
    }

    static /* synthetic */ void bNn() {
        AppMethodBeat.m2504i(43246);
        C4990ab.m7416i("MicorMsg.MallIndexUI", "query wechat wallet");
        C46067i.m85827a(null, false);
        AppMethodBeat.m2505o(43246);
    }
}

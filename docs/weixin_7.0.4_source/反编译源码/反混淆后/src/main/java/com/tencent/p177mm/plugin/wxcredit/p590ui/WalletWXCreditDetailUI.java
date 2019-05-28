package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.appbrand.weishi.C2509f;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wxcredit.C23213b;
import com.tencent.p177mm.plugin.wxcredit.C23216c;
import com.tencent.p177mm.plugin.wxcredit.C44031f;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C23211i;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C40408d;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C40409k;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletPreferenceUI;
import java.util.ArrayList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI */
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private C15541f ehK;
    private boolean hasInit = false;
    private OnClickListener qqV = new C232233();
    private Bankcard tmw;
    private C40931c uZv;
    private C40409k uZw;

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI$3 */
    class C232233 implements OnClickListener {
        C232233() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48722);
            if (view.getId() == 2131829090) {
                if (WalletWXCreditDetailUI.this.uZw != null) {
                    C36391e.m59992af(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.uZw.uYO.username);
                    AppMethodBeat.m2505o(48722);
                    return;
                }
            } else if (view.getId() == 2131829091 && WalletWXCreditDetailUI.this.uZw != null) {
                C36391e.m60016n(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.uZw.uYN, false);
            }
            AppMethodBeat.m2505o(48722);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI$4 */
    class C300264 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI$4$1 */
        class C300271 implements C30391c {
            C300271() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(48723);
                switch (i) {
                    case 0:
                        C14241r.cPI();
                        WalletWXCreditDetailUI.this.tmw;
                        WalletWXCreditDetailUI.dgJ();
                        AppMethodBeat.m2505o(48723);
                        return;
                    case 1:
                        WalletWXCreditDetailUI.m69316c(WalletWXCreditDetailUI.this);
                        break;
                }
                AppMethodBeat.m2505o(48723);
            }
        }

        C300264() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(48724);
            ArrayList arrayList = new ArrayList();
            C14241r.cPI();
            WalletWXCreditDetailUI.this.tmw;
            C30379h.m48424a(WalletWXCreditDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletWXCreditDetailUI.this.getString(C25738R.string.fgf), false, new C300271());
            AppMethodBeat.m2505o(48724);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI$2 */
    class C357712 implements OnMenuItemClickListener {
        C357712() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(48721);
            WalletWXCreditDetailUI.this.aqX();
            WalletWXCreditDetailUI.this.finish();
            AppMethodBeat.m2505o(48721);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI$1 */
    class C404121 implements DialogInterface.OnClickListener {
        C404121() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48720);
            WalletWXCreditDetailUI.this.dOM().mo49367a(new C23211i(WalletWXCreditDetailUI.this.tmw.field_bankcardType, WalletWXCreditDetailUI.this.tmw.twO), true, 1);
            AppMethodBeat.m2505o(48720);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletWXCreditDetailUI() {
        AppMethodBeat.m2504i(48725);
        AppMethodBeat.m2505o(48725);
    }

    static /* synthetic */ void dgJ() {
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8582cw;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48726);
        super.onCreate(bundle);
        dOM().mo49372nf(C2509f.CTRL_INDEX);
        dOM().mo49372nf(600);
        mo9439AM(4);
        this.uZv = C24143a.m37112aE(this);
        if (this.tmw == null) {
            this.tmw = (Bankcard) this.uZv.mqu.getParcelable("key_bankcard");
        }
        if (dgI()) {
            if (this.Ahs == null) {
                if (this.Ahq == null) {
                    this.Ahq = C24143a.m37112aE(this);
                }
                this.Ahs = this.Ahq.mo24745a((MMActivity) this, this.Ahr);
            }
            if (!this.Ahs.mo9367w(this.tmw)) {
                mo9439AM(0);
                initView();
            }
        }
        AppMethodBeat.m2505o(48726);
    }

    private boolean dgI() {
        AppMethodBeat.m2504i(48727);
        if (this.tmw == null) {
            AppMethodBeat.m2505o(48727);
            return false;
        } else if (this.tmw.field_bankcardState == 0) {
            AppMethodBeat.m2505o(48727);
            return true;
        } else {
            int i = this.tmw.field_wxcreditState;
            if (this.uZw != null) {
                i = this.uZw.uYA;
            }
            switch (i) {
                case 1:
                    if (C14241r.cPI().cQM()) {
                        AppMethodBeat.m2505o(48727);
                        return true;
                    }
                    AppMethodBeat.m2505o(48727);
                    return false;
                case 3:
                    C30379h.m48433a((Context) this, (int) C25738R.string.fws, -1, false, new C404121());
                    AppMethodBeat.m2505o(48727);
                    return false;
                case 4:
                    break;
                case 5:
                    this.uZv.mqu.putBoolean("key_can_unbind", false);
                    break;
                default:
                    AppMethodBeat.m2505o(48727);
                    return true;
            }
            if (this.uZw != null) {
                this.uZv.mqu.putString("key_repayment_url", this.uZw.uYI);
                this.uZv.mo8124a((Activity) this, 1, this.uZv.mqu);
                AppMethodBeat.m2505o(48727);
                return false;
            }
            AppMethodBeat.m2505o(48727);
            return true;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48728);
        dOM().mo49373ng(C2509f.CTRL_INDEX);
        dOM().mo49373ng(600);
        super.onDestroy();
        AppMethodBeat.m2505o(48728);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48729);
        this.hasInit = true;
        setMMTitle((int) C25738R.string.fwt);
        this.ehK = this.yCw;
        setBackBtn(new C357712());
        ceo();
        AppMethodBeat.m2505o(48729);
    }

    /* renamed from: cu */
    private void m69317cu() {
        AppMethodBeat.m2504i(48730);
        if (!this.hasInit) {
            initView();
        }
        if (this.uZw != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.ehK.aqO("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.gng.setText(C36391e.m59972G(this.uZw.uYB));
            String str = this.tmw.field_bankName;
            String str2 = this.uZw.uYM;
            walletWXCreditDetailHeaderPreference.uZu.setText(walletWXCreditDetailHeaderPreference.mContext.getString(C25738R.string.fxj, new Object[]{str2, str}));
        }
        if (this.uZw != null) {
            this.ehK.aqO("wallet_wxcredit_total_amount").setTitle(getString(C25738R.string.fwu, new Object[]{C36391e.m59972G(this.uZw.uYv)}));
            this.ehK.mo27715ce("wallet_wxcredit_change_amount", !this.uZw.uYG);
            Preference aqO = this.ehK.aqO("wallet_wxcredit_bill");
            if (this.uZw.uYC != 0.0d) {
                aqO.setSummary(C36391e.m59972G(this.uZw.uYC));
            }
            aqO = this.ehK.aqO("wallet_wxcredit_repayment");
            Preference aqO2 = this.ehK.aqO("wallet_wxcredit_repayment_tips");
            if (this.uZw.uYE > 0.0d) {
                aqO.setSummary(C36391e.m59972G(this.uZw.uYE));
                aqO2.setTitle(getString(C25738R.string.fxh, new Object[]{this.uZw.uYJ}));
                this.ehK.mo27715ce("wallet_wxcredit_repayment_tips", false);
            } else {
                this.ehK.mo27715ce("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.tmw != null) {
            this.ehK.aqO("wallet_wxcredit_bank_name").setTitle(this.tmw.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.ehK.aqO("wallet_wxcredit_footer")).qqV = this.qqV;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(48730);
    }

    /* renamed from: f */
    public final boolean mo24791f(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48732);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C40408d) {
                C14241r.cPI().tDc = System.currentTimeMillis() / 1000;
                this.uZw = ((C40408d) c1207m).uYw;
                if (this.uZw != null && this.uZw.uYA == 2) {
                    C1720g.m3537RQ();
                    if (((Boolean) C1720g.m3536RP().mo5239Ry().get(196658, Boolean.FALSE)).booleanValue()) {
                        C40931c aE = C24143a.m37112aE(this);
                        Bundle bundle = aE.mqu;
                        bundle.putDouble("key_total_amount", this.uZw.uYv);
                        bundle.putBoolean("key_can_upgrade_amount", this.uZw.uYG);
                        aE.mo64562a((Activity) this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        AppMethodBeat.m2505o(48732);
                        return true;
                    }
                }
                if (dgI()) {
                    mo9439AM(0);
                    m69317cu();
                }
                AppMethodBeat.m2505o(48732);
                return true;
            } else if (c1207m instanceof C23211i) {
                dOM().mo49367a(new C35475y(), true, 1);
            } else if (c1207m instanceof C35475y) {
                finish();
            }
        }
        AppMethodBeat.m2505o(48732);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48733);
        mo9439AM(0);
        m69317cu();
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(48733);
    }

    private void ceo() {
        AppMethodBeat.m2504i(48734);
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C300264());
        AppMethodBeat.m2505o(48734);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(48731);
        String str = preference.mKey;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_bankcard", this.tmw);
            C24143a.m37105a(this, C23213b.class, bundle);
            AppMethodBeat.m2505o(48731);
            return true;
        }
        Bundle bundle2;
        if ("wallet_wxcredit_bill".equals(str)) {
            if (this.uZw != null) {
                bundle2 = new Bundle();
                bundle2.putString("key_url", this.uZw.pPO);
                C24143a.m37105a(this, C23216c.class, bundle2);
            }
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.uZw != null) {
                bundle2 = new Bundle();
                bundle2.putString("key_url", this.uZw.uYK);
                C24143a.m37105a(this, C23216c.class, bundle2);
            }
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.uZw != null) {
                C36391e.m60016n(this, this.uZw.uYL, false);
            }
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.uZw != null) {
                C36391e.m60016n(this, this.uZw.uYI, false);
            }
        } else if ("wallet_wxcredit_bank_name".equals(str) && this.uZw != null) {
            C36391e.m59991ae(this, this.uZw.uYO.username);
        }
        AppMethodBeat.m2505o(48731);
        return false;
    }

    /* renamed from: c */
    static /* synthetic */ void m69316c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        AppMethodBeat.m2504i(48735);
        Bundle bundle = walletWXCreditDetailUI.uZv.mqu;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        C24143a.m37105a(walletWXCreditDetailUI, C44031f.class, bundle);
        AppMethodBeat.m2505o(48735);
    }
}

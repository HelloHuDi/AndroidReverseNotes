package com.tencent.p177mm.plugin.wallet.balance.p552ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.balance.C41322b;
import com.tencent.p177mm.plugin.wallet.balance.p550a.C7177c;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI */
public class WalletBalanceResultUI extends WalletBaseUI {
    protected Button gHn;
    protected TextView nSC;
    protected TextView pMc;
    protected Orders pWy;
    protected TextView rOI;
    protected TextView thG;
    protected TextView thH;
    protected CheckBox thI;
    protected Bankcard thJ;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI$2 */
    class C295502 implements OnMenuItemClickListener {
        C295502() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45458);
            WalletBalanceResultUI.m46898a(WalletBalanceResultUI.this);
            AppMethodBeat.m2505o(45458);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI$4 */
    class C295514 implements Runnable {
        C295514() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45460);
            C4990ab.m7416i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
            AppMethodBeat.m2505o(45460);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI$1 */
    class C295521 implements OnClickListener {
        C295521() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45457);
            WalletBalanceResultUI.m46898a(WalletBalanceResultUI.this);
            AppMethodBeat.m2505o(45457);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI$3 */
    class C295533 implements DialogInterface.OnClickListener {
        C295533() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45459);
            WalletBalanceResultUI.m46899b(WalletBalanceResultUI.this);
            AppMethodBeat.m2505o(45459);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m46899b(WalletBalanceResultUI walletBalanceResultUI) {
        AppMethodBeat.m2504i(45468);
        walletBalanceResultUI.cNc();
        AppMethodBeat.m2505o(45468);
    }

    public final int getLayoutId() {
        return 2130971052;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45461);
        super.onCreate(bundle);
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        initView();
        mo47805cu();
        AppMethodBeat.m2505o(45461);
    }

    public void initView() {
        AppMethodBeat.m2504i(45462);
        setMMTitle((String) dOE().mo9364Au(0));
        this.rOI = (TextView) findViewById(2131828632);
        this.rOI.setText(dOE().mo9364Au(1));
        this.thH = (TextView) findViewById(2131828633);
        this.nSC = (TextView) findViewById(2131828634);
        CharSequence Au = dOE().mo9364Au(2);
        if (C5046bo.m7519ac(Au)) {
            this.thH.setVisibility(8);
            this.nSC.setVisibility(8);
        } else {
            this.thH.setVisibility(0);
            this.nSC.setVisibility(0);
            this.nSC.setText(Au);
        }
        ImageView imageView = (ImageView) findViewById(2131828631);
        int i = this.mBundle.getInt("key_balance_result_logo", -1);
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageResource(C1318a.remittance_received);
        }
        this.pMc = (TextView) findViewById(2131828636);
        this.thG = (TextView) findViewById(2131828638);
        TextView textView = (TextView) findViewById(2131828637);
        if (dOD() instanceof C41322b) {
            textView.setText(getString(C25738R.string.f9o));
        }
        this.thI = (CheckBox) findViewById(2131828641);
        this.thJ = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (this.thJ != null) {
            this.thI.setVisibility(8);
        } else {
            this.thI.setVisibility(0);
        }
        this.gHn = (Button) findViewById(2131822846);
        this.gHn.setOnClickListener(new C295521());
        setBackBtn(new C295502());
        AppMethodBeat.m2505o(45462);
    }

    private void cNc() {
        AppMethodBeat.m2504i(45463);
        if (this.thI.getVisibility() == 0) {
            String str;
            if (this.thI.isChecked()) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                str = "1";
            }
            int i = this.mBundle.getInt("key_pay_flag", 0);
            String string = this.mBundle.getString("key_pwd1");
            String string2 = this.mBundle.getString("key_verify_code");
            PayInfo payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
            if (payInfo != null) {
                mo39970a(new C7177c(i, string, string2, payInfo.czZ, payInfo.cIf, str), true, true);
            }
            AppMethodBeat.m2505o(45463);
            return;
        }
        mo39988dY();
        AppMethodBeat.m2505o(45463);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cu */
    public void mo47805cu() {
        AppMethodBeat.m2504i(45464);
        if (this.pWy != null) {
            this.thG.setText(C36391e.m60006e(this.pWy.pTN, this.pWy.pcl));
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                Commodity commodity = (Commodity) this.pWy.tAq.get(0);
                if (C5046bo.isNullOrNil(commodity.tAT)) {
                    this.pMc.setText(commodity.pcj);
                } else {
                    this.pMc.setText(commodity.pcj + " " + getString(C25738R.string.foc) + commodity.tAT);
                }
            }
            if (dOD() instanceof C41322b) {
                if (this.pWy.pPp > 0.0d) {
                    findViewById(2131828639).setVisibility(0);
                    TextView textView = (TextView) findViewById(2131828640);
                    textView.setText(C36391e.m60006e(this.pWy.pPp, this.pWy.pcl));
                    textView.setVisibility(0);
                    AppMethodBeat.m2505o(45464);
                    return;
                }
                C4990ab.m7416i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
            }
        }
        AppMethodBeat.m2505o(45464);
    }

    /* renamed from: dY */
    public final void mo39988dY() {
        AppMethodBeat.m2504i(45465);
        if (!dOE().mo9366p(this.pWy)) {
            super.mo39988dY();
        }
        AppMethodBeat.m2505o(45465);
    }

    public void onBackPressed() {
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45466);
        if (c1207m instanceof C7177c) {
            if (i == 0 && i2 == 0) {
                C46332s.cNC();
                C46332s.cND().tDa = C5046bo.anT();
                C18416uq c18416uq = new C18416uq();
                c18416uq.cQP.scene = 15;
                c18416uq.callback = new C295514();
                C4879a.xxA.mo10055m(c18416uq);
            }
            mo39988dY();
            AppMethodBeat.m2505o(45466);
            return true;
        }
        AppMethodBeat.m2505o(45466);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m46898a(WalletBalanceResultUI walletBalanceResultUI) {
        AppMethodBeat.m2504i(45467);
        if (walletBalanceResultUI.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceResultUI.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.mo74574b(walletBalanceResultUI, bundle, new C295533());
                walletBalanceResultUI.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.m2505o(45467);
            return;
        }
        walletBalanceResultUI.cNc();
        AppMethodBeat.m2505o(45467);
    }
}

package com.tencent.mm.plugin.wallet.balance.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.c;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(WalletBalanceResultUI walletBalanceResultUI) {
        AppMethodBeat.i(45468);
        walletBalanceResultUI.cNc();
        AppMethodBeat.o(45468);
    }

    public final int getLayoutId() {
        return R.layout.b30;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45461);
        super.onCreate(bundle);
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        initView();
        cu();
        AppMethodBeat.o(45461);
    }

    public void initView() {
        AppMethodBeat.i(45462);
        setMMTitle((String) dOE().Au(0));
        this.rOI = (TextView) findViewById(R.id.f6m);
        this.rOI.setText(dOE().Au(1));
        this.thH = (TextView) findViewById(R.id.f6n);
        this.nSC = (TextView) findViewById(R.id.f6o);
        CharSequence Au = dOE().Au(2);
        if (bo.ac(Au)) {
            this.thH.setVisibility(8);
            this.nSC.setVisibility(8);
        } else {
            this.thH.setVisibility(0);
            this.nSC.setVisibility(0);
            this.nSC.setText(Au);
        }
        ImageView imageView = (ImageView) findViewById(R.id.f6l);
        int i = this.mBundle.getInt("key_balance_result_logo", -1);
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageResource(R.raw.remittance_received);
        }
        this.pMc = (TextView) findViewById(R.id.f6q);
        this.thG = (TextView) findViewById(R.id.f6s);
        TextView textView = (TextView) findViewById(R.id.f6r);
        if (dOD() instanceof b) {
            textView.setText(getString(R.string.f9o));
        }
        this.thI = (CheckBox) findViewById(R.id.f6v);
        this.thJ = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (this.thJ != null) {
            this.thI.setVisibility(8);
        } else {
            this.thI.setVisibility(0);
        }
        this.gHn = (Button) findViewById(R.id.ay8);
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45457);
                WalletBalanceResultUI.a(WalletBalanceResultUI.this);
                AppMethodBeat.o(45457);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45458);
                WalletBalanceResultUI.a(WalletBalanceResultUI.this);
                AppMethodBeat.o(45458);
                return false;
            }
        });
        AppMethodBeat.o(45462);
    }

    private void cNc() {
        AppMethodBeat.i(45463);
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
                a(new c(i, string, string2, payInfo.czZ, payInfo.cIf, str), true, true);
            }
            AppMethodBeat.o(45463);
            return;
        }
        dY();
        AppMethodBeat.o(45463);
    }

    /* Access modifiers changed, original: protected */
    public void cu() {
        AppMethodBeat.i(45464);
        if (this.pWy != null) {
            this.thG.setText(e.e(this.pWy.pTN, this.pWy.pcl));
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                Commodity commodity = (Commodity) this.pWy.tAq.get(0);
                if (bo.isNullOrNil(commodity.tAT)) {
                    this.pMc.setText(commodity.pcj);
                } else {
                    this.pMc.setText(commodity.pcj + " " + getString(R.string.foc) + commodity.tAT);
                }
            }
            if (dOD() instanceof b) {
                if (this.pWy.pPp > 0.0d) {
                    findViewById(R.id.f6t).setVisibility(0);
                    TextView textView = (TextView) findViewById(R.id.f6u);
                    textView.setText(e.e(this.pWy.pPp, this.pWy.pcl));
                    textView.setVisibility(0);
                    AppMethodBeat.o(45464);
                    return;
                }
                ab.i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
            }
        }
        AppMethodBeat.o(45464);
    }

    public final void dY() {
        AppMethodBeat.i(45465);
        if (!dOE().p(this.pWy)) {
            super.dY();
        }
        AppMethodBeat.o(45465);
    }

    public void onBackPressed() {
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45466);
        if (mVar instanceof c) {
            if (i == 0 && i2 == 0) {
                s.cNC();
                s.cND().tDa = bo.anT();
                uq uqVar = new uq();
                uqVar.cQP.scene = 15;
                uqVar.callback = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(45460);
                        ab.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
                        AppMethodBeat.o(45460);
                    }
                };
                com.tencent.mm.sdk.b.a.xxA.m(uqVar);
            }
            dY();
            AppMethodBeat.o(45466);
            return true;
        }
        AppMethodBeat.o(45466);
        return false;
    }

    static /* synthetic */ void a(WalletBalanceResultUI walletBalanceResultUI) {
        AppMethodBeat.i(45467);
        if (walletBalanceResultUI.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceResultUI.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceResultUI, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45459);
                        WalletBalanceResultUI.b(WalletBalanceResultUI.this);
                        AppMethodBeat.o(45459);
                    }
                });
                walletBalanceResultUI.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(45467);
            return;
        }
        walletBalanceResultUI.cNc();
        AppMethodBeat.o(45467);
    }
}

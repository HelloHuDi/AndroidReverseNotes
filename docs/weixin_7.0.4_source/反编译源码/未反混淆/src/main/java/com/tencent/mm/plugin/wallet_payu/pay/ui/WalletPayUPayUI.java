package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class WalletPayUPayUI extends WalletPayUI {
    private String tUa = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(WalletPayUPayUI walletPayUPayUI, String str) {
        AppMethodBeat.i(48495);
        walletPayUPayUI.c(false, 0, str);
        AppMethodBeat.o(48495);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48488);
        super.onCreate(bundle);
        AppMethodBeat.o(48488);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(48489);
        ab.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(48489);
    }

    public final void cNX() {
        AppMethodBeat.i(48490);
        a(new c(cOl().czZ), cOl().vwf, false);
        a(new com.tencent.mm.plugin.wallet_core.c.b.a(cOl().czZ), cOl().vwf, false);
        AppMethodBeat.o(48490);
    }

    public final void cNQ() {
        AppMethodBeat.i(48491);
        if (arW()) {
            ab.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
            this.tpP = b.a(this, this.pWy, this.toH, this.tgC, new b() {
                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    AppMethodBeat.i(48483);
                    WalletPayUPayUI.this.aqX();
                    WalletPayUPayUI.this.gHr = str;
                    WalletPayUPayUI.this.tUa = str2;
                    WalletPayUPayUI.this.na(false);
                    d.cSP();
                    AppMethodBeat.o(48483);
                }
            }, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(48484);
                    WalletPayUPayUI.this.toH = (FavorPayInfo) view.getTag();
                    if (WalletPayUPayUI.this.toH != null) {
                        WalletPayUPayUI.this.toH.tzf = "";
                    }
                    WalletPayUPayUI.c(WalletPayUPayUI.this, "");
                    WalletPayUPayUI.this.tpP.dismiss();
                    WalletPayUPayUI.this.gHr = null;
                    WalletPayUPayUI.this.tpP = null;
                    AppMethodBeat.o(48484);
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(48485);
                    WalletPayUPayUI.this.gHr = null;
                    WalletPayUPayUI.this.tpP = null;
                    if (WalletPayUPayUI.this.bwP()) {
                        WalletPayUPayUI.this.finish();
                    }
                    AppMethodBeat.o(48485);
                }
            }, "CREDITCARD_PAYU".equals(this.tgC.field_bankcardType));
            AppMethodBeat.o(48491);
            return;
        }
        AppMethodBeat.o(48491);
    }

    public final void Q(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(48492);
        this.tpx = true;
        if (this.pWy != null) {
            bundle.putInt("key_support_bankcard", this.pWy.tuo);
        }
        String str = "key_is_oversea";
        if (cOc()) {
            z = false;
        }
        bundle.putBoolean(str, z);
        com.tencent.mm.wallet_core.a.a(this, e.class, bundle);
        AppMethodBeat.o(48492);
    }

    public final void na(boolean z) {
        AppMethodBeat.i(48493);
        if (this.pVL.cIf == 32 || this.pVL.cIf == 31) {
            int i;
            if (this.pVL.cIf == 32) {
                ab.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            a(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.pVL.czZ, this.gHr, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), i, this.pVL.vwh.getString("extinfo_key_1"), this.tgC.field_bindSerial, this.pVL.vwh.getString("extinfo_key_4")), true, false);
            AppMethodBeat.o(48493);
        } else if (this.pVL.cIf == 11) {
            String str = this.gHr;
            String str2 = this.tUa;
            String str3 = this.pVL.czZ;
            double d = this.pVL.vwh.getDouble("total_fee");
            String string = this.pVL.vwh.getString("fee_type");
            String str4 = this.tgC.field_bindSerial;
            String str5 = this.tgC.field_bankcardType;
            s.cNC();
            a(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str, str2, str3, d, string, str4, str5, s.cND().thy.field_bindSerial), true, false);
            AppMethodBeat.o(48493);
        } else {
            a(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.pVL.czZ, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), this.tgC.field_bankcardType, this.tgC.field_bindSerial, this.tUa, this.gHr), true, true);
            AppMethodBeat.o(48493);
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48494);
        com.tencent.mm.plugin.wallet_payu.pay.a.b bVar;
        if (i == 0 && i2 == 0) {
            Bundle bundle;
            if (mVar instanceof c) {
                this.pWy = ((c) mVar).pWy;
                this.mCount = this.pWy != null ? this.pWy.tAq.size() : 0;
                ab.d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.pWy != null ? Integer.valueOf(this.pWy.tuo) : ""));
                arW();
                if (!(this.pWy == null || this.pWy.tAq == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.pWy.tAq) {
                        if (bo.isNullOrNil(commodity.cAa)) {
                            commodity.cAa = this.pVL.czZ;
                        }
                        linkedList.add(commodity.cAa);
                    }
                    if (linkedList.size() > 0) {
                        uu uuVar = new uu();
                        uuVar.cRC.cRE = linkedList;
                        com.tencent.mm.sdk.b.a.xxA.m(uuVar);
                    }
                    bundle = new Bundle();
                    bundle.putDouble("total_fee", this.pWy.pTN);
                    bundle.putString("fee_type", "ZAR");
                    if (this.pVL.vwh == null) {
                        this.pVL.vwh = bundle;
                    } else {
                        this.pVL.vwh.putAll(bundle);
                    }
                }
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
                s.cNC();
                this.tgB = s.cND().ng(cOk());
                s.cNC();
                this.tgC = s.cND().a(null, null, cOk(), false);
                this.pTi.setClickable(true);
                if (!(this.pWy == null || this.tgB == null || this.pVL == null)) {
                    d.a(this.pVL, this.pWy);
                    h hVar = h.pYm;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.pVL.cIf);
                    objArr[1] = Integer.valueOf(0);
                    s.cNC();
                    objArr[2] = Integer.valueOf(s.cND().cQg() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pWy.pTN * 100.0d));
                    objArr[4] = this.pWy.pcl;
                    hVar.e(10690, objArr);
                }
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) mVar;
                bundle = this.mBundle;
                bundle.putParcelable("key_pay_info", this.pVL);
                bundle.putParcelable("key_bankcard", this.tgC);
                bundle.putString("key_bank_type", this.tgC.field_bankcardType);
                if (!bo.isNullOrNil(this.gHr)) {
                    bundle.putString("key_pwd1", this.gHr);
                }
                bundle.putString("kreq_token", bVar.getToken());
                bundle.putParcelable("key_authen", cOb());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.tgC.field_mobile);
                if (bVar.isSuccess()) {
                    bundle.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.d.a(this.pWy, bVar.tTW, bVar.tTX, bVar.timestamp, bVar.tDT));
                }
                this.mBundle.putBoolean("key_should_redirect", bVar.tTU);
                this.mBundle.putString("key_gateway_code", bVar.tSz);
                this.mBundle.putString("key_gateway_reference", bVar.tSy);
                this.mBundle.putBoolean("key_should_force_adjust", bVar.tTV);
                this.mBundle.putString("key_force_adjust_code", bVar.tSB);
                bundle.putInt("key_pay_flag", 3);
                Q(bundle);
                AppMethodBeat.o(48494);
                return true;
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) {
                com.tencent.mm.plugin.wallet_payu.remittance.a.a aVar = (com.tencent.mm.plugin.wallet_payu.remittance.a.a) mVar;
                bundle = this.mBundle;
                bundle.putParcelable("key_pay_info", this.pVL);
                bundle.putParcelable("key_bankcard", this.tgC);
                bundle.putString("key_bank_type", this.tgC.field_bankcardType);
                if (!bo.isNullOrNil(this.gHr)) {
                    bundle.putString("key_pwd1", this.gHr);
                }
                bundle.putString("kreq_token", aVar.getToken());
                bundle.putParcelable("key_authen", cOb());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.tgC.field_mobile);
                bundle.putParcelable("key_orders", this.pWy);
                bundle.putInt("key_pay_flag", 3);
                Q(bundle);
                AppMethodBeat.o(48494);
                return true;
            }
            cu();
            AppMethodBeat.o(48494);
            return true;
        }
        if (mVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) mVar;
                    this.tpC = this.mBundle;
                    this.tpC.putParcelable("key_pay_info", this.pVL);
                    this.tpC.putParcelable("key_bankcard", this.tgC);
                    if (!bo.isNullOrNil(this.gHr)) {
                        this.tpC.putString("key_pwd1", this.gHr);
                    }
                    this.tpC.putString("kreq_token", bVar.getToken());
                    this.tpC.putString("key_mobile", this.tgC.field_mobile);
                    this.tpC.putInt("key_err_code", i2);
                    this.tpC.putParcelable("key_orders", this.pWy);
                    if (bo.isNullOrNil(str)) {
                        string = getString(R.string.fp0);
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.h.d(this, string, "", getString(R.string.foz), getString(R.string.or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48486);
                            WalletPayUPayUI.this.tpC.putInt("key_pay_flag", 3);
                            WalletPayUPayUI.this.Q(WalletPayUPayUI.this.tpC);
                            AppMethodBeat.o(48486);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48487);
                            if (WalletPayUPayUI.this.bwP()) {
                                WalletPayUPayUI.this.finish();
                            }
                            AppMethodBeat.o(48487);
                        }
                    });
                    AppMethodBeat.o(48494);
                    return true;
                case 404:
                    if (!(this.tgC == null || this.pWy == null)) {
                        this.tgC.twR = this.pWy.czZ;
                        if (this.tgB == null || this.tgB.size() <= 1) {
                            b(true, 4, str);
                        } else {
                            c(true, 4, str);
                        }
                        AppMethodBeat.o(48494);
                        return true;
                    }
                    break;
            }
        }
        AppMethodBeat.o(48494);
        return false;
    }
}

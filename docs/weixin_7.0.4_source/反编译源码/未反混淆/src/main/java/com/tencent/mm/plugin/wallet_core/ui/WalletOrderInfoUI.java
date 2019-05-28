package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;

@a(3)
public class WalletOrderInfoUI extends WalletBaseUI {
    private String oXY;
    protected b.a tIU = new b.a() {
        public final void o(String str, boolean z) {
            AppMethodBeat.i(47523);
            g.RQ();
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            ab.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoUI.this.S(aoO);
            AppMethodBeat.o(47523);
        }
    };
    private Orders tog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOrderInfoUI() {
        AppMethodBeat.i(47525);
        AppMethodBeat.o(47525);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47526);
        super.onCreate(bundle);
        if (cgg()) {
            this.tog = cRD();
            this.oXY = this.mBundle.getString("key_trans_id");
            int i = this.mBundle.getInt("key_pay_type", -1);
            ab.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", this.oXY);
            if (this.oXY != null) {
                if (i == -1) {
                    adb(this.oXY);
                    AppMethodBeat.o(47526);
                    return;
                }
                dt(this.oXY, i);
                AppMethodBeat.o(47526);
                return;
            } else if (this.tog != null) {
                e(this.tog);
            }
        }
        AppMethodBeat.o(47526);
    }

    public void onDestroy() {
        AppMethodBeat.i(47527);
        super.onDestroy();
        if (!(this.tog == null || bo.isNullOrNil(this.tog.username))) {
            ao.a.flu.or(this.tog.username);
        }
        AppMethodBeat.o(47527);
    }

    /* Access modifiers changed, original: protected */
    public boolean cgg() {
        return true;
    }

    public int getLayoutId() {
        return R.layout.b0t;
    }

    /* Access modifiers changed, original: protected */
    public void adb(String str) {
        AppMethodBeat.i(47529);
        a(new z(str), true, true);
        AppMethodBeat.o(47529);
    }

    /* Access modifiers changed, original: protected */
    public void dt(String str, int i) {
        AppMethodBeat.i(47530);
        a(new z(str, i), true, true);
        AppMethodBeat.o(47530);
    }

    private void e(Orders orders) {
        AppMethodBeat.i(47531);
        ab.c("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", Integer.valueOf(orders.tAA));
        if (orders.tAA == 1) {
            dOD().b(this, WalletOrderInfoNewUI.class, this.mBundle);
        } else {
            dOD().b(this, WalletOrderInfoOldUI.class, this.mBundle);
        }
        finish();
        AppMethodBeat.o(47531);
    }

    /* Access modifiers changed, original: protected */
    public void S(ad adVar) {
        AppMethodBeat.i(47532);
        if (!(adVar == null || ((int) adVar.ewQ) == 0)) {
            String Oi = adVar.Oi();
            ab.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + Oi + " username: " + adVar.field_username);
            if (this.tog.tAq != null && this.tog.tAq.size() > 0) {
                for (Commodity commodity : this.tog.tAq) {
                    commodity.pcm = Oi;
                }
            }
        }
        AppMethodBeat.o(47532);
    }

    protected static String d(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(47533);
        try {
            String encode = URLEncoder.encode(URLEncoder.encode(str5, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.indexOf("%7Breqkey%7D") > 0 || str.indexOf("%7Btransid%7D") > 0 || str.indexOf("%7Bphone%7D") > 0 || str.indexOf("%7Bremark%7D") > 0) {
                ab.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
                str = str.replace("%7Breqkey%7D", str2).replace("%7Btransid%7D", str3).replace("%7Bphone%7D", str4).replace("%7Bremark%7D", encode);
                AppMethodBeat.o(47533);
                return str;
            }
            if (str.indexOf("{reqkey}") > 0 || str.indexOf("{transid}") > 0 || str.indexOf("{phone}") > 0 || str.indexOf("{remark}") > 0) {
                ab.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
                str = str.replace("{reqkey}", str2).replace("{transid}", str3).replace("{phone}", str4).replace("{remark}", encode);
            } else {
                ab.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
                str = str + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[]{str2, str3, str4, encode});
            }
            AppMethodBeat.o(47533);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletOrderInfoUI", e, "", new Object[0]);
        }
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47534);
        if ((mVar instanceof z) && i == 0 && i2 == 0) {
            this.tog = ((z) mVar).tux;
            if (this.tog != null) {
                if (!(this.tog.tAq == null || this.tog.tAq.size() == 0)) {
                    Commodity commodity = (Commodity) this.tog.tAq.get(0);
                    this.oXY = commodity.cAa;
                    ab.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                    g.RQ();
                    ad aoO = ((j) g.K(j.class)).XM().aoO(commodity.pcm);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        ao.a.flu.a(commodity.pcm, "", this.tIU);
                    } else {
                        S(aoO);
                    }
                }
                e(this.tog);
            } else {
                ab.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
                h.a(this.mController.ylL, (int) R.string.fkw, 0, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(47524);
                        WalletOrderInfoUI.this.finish();
                        AppMethodBeat.o(47524);
                    }
                });
            }
            AppMethodBeat.o(47534);
            return true;
        }
        AppMethodBeat.o(47534);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public Orders cRD() {
        AppMethodBeat.i(47528);
        Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
        AppMethodBeat.o(47528);
        return orders;
    }
}

package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22564z;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI */
public class WalletOrderInfoUI extends WalletBaseUI {
    private String oXY;
    protected C9636a tIU = new C296611();
    private Orders tog;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI$2 */
    class C226132 implements OnClickListener {
        C226132() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47524);
            WalletOrderInfoUI.this.finish();
            AppMethodBeat.m2505o(47524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI$1 */
    class C296611 implements C9636a {
        C296611() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(47523);
            C1720g.m3537RQ();
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            C4990ab.m7410d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoUI.this.mo47912S(aoO);
            AppMethodBeat.m2505o(47523);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletOrderInfoUI() {
        AppMethodBeat.m2504i(47525);
        AppMethodBeat.m2505o(47525);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47526);
        super.onCreate(bundle);
        if (cgg()) {
            this.tog = cRD();
            this.oXY = this.mBundle.getString("key_trans_id");
            int i = this.mBundle.getInt("key_pay_type", -1);
            C4990ab.m7417i("MicroMsg.WalletOrderInfoUI", "mTransId %s", this.oXY);
            if (this.oXY != null) {
                if (i == -1) {
                    adb(this.oXY);
                    AppMethodBeat.m2505o(47526);
                    return;
                }
                mo47914dt(this.oXY, i);
                AppMethodBeat.m2505o(47526);
                return;
            } else if (this.tog != null) {
                m47043e(this.tog);
            }
        }
        AppMethodBeat.m2505o(47526);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47527);
        super.onDestroy();
        if (!(this.tog == null || C5046bo.isNullOrNil(this.tog.username))) {
            C26417a.flu.mo20969or(this.tog.username);
        }
        AppMethodBeat.m2505o(47527);
    }

    /* Access modifiers changed, original: protected */
    public boolean cgg() {
        return true;
    }

    public int getLayoutId() {
        return 2130970969;
    }

    /* Access modifiers changed, original: protected */
    public void adb(String str) {
        AppMethodBeat.m2504i(47529);
        mo39970a(new C22564z(str), true, true);
        AppMethodBeat.m2505o(47529);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dt */
    public void mo47914dt(String str, int i) {
        AppMethodBeat.m2504i(47530);
        mo39970a(new C22564z(str, i), true, true);
        AppMethodBeat.m2505o(47530);
    }

    /* renamed from: e */
    private void m47043e(Orders orders) {
        AppMethodBeat.m2504i(47531);
        C4990ab.m7409c("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", Integer.valueOf(orders.tAA));
        if (orders.tAA == 1) {
            dOD().mo64571b(this, WalletOrderInfoNewUI.class, this.mBundle);
        } else {
            dOD().mo64571b(this, WalletOrderInfoOldUI.class, this.mBundle);
        }
        finish();
        AppMethodBeat.m2505o(47531);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: S */
    public void mo47912S(C7616ad c7616ad) {
        AppMethodBeat.m2504i(47532);
        if (!(c7616ad == null || ((int) c7616ad.ewQ) == 0)) {
            String Oi = c7616ad.mo16706Oi();
            C4990ab.m7410d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + Oi + " username: " + c7616ad.field_username);
            if (this.tog.tAq != null && this.tog.tAq.size() > 0) {
                for (Commodity commodity : this.tog.tAq) {
                    commodity.pcm = Oi;
                }
            }
        }
        AppMethodBeat.m2505o(47532);
    }

    /* renamed from: d */
    protected static String m47042d(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(47533);
        try {
            String encode = URLEncoder.encode(URLEncoder.encode(str5, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.indexOf("%7Breqkey%7D") > 0 || str.indexOf("%7Btransid%7D") > 0 || str.indexOf("%7Bphone%7D") > 0 || str.indexOf("%7Bremark%7D") > 0) {
                C4990ab.m7416i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
                str = str.replace("%7Breqkey%7D", str2).replace("%7Btransid%7D", str3).replace("%7Bphone%7D", str4).replace("%7Bremark%7D", encode);
                AppMethodBeat.m2505o(47533);
                return str;
            }
            if (str.indexOf("{reqkey}") > 0 || str.indexOf("{transid}") > 0 || str.indexOf("{phone}") > 0 || str.indexOf("{remark}") > 0) {
                C4990ab.m7416i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
                str = str.replace("{reqkey}", str2).replace("{transid}", str3).replace("{phone}", str4).replace("{remark}", encode);
            } else {
                C4990ab.m7416i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
                str = str + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[]{str2, str3, str4, encode});
            }
            AppMethodBeat.m2505o(47533);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletOrderInfoUI", e, "", new Object[0]);
        }
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47534);
        if ((c1207m instanceof C22564z) && i == 0 && i2 == 0) {
            this.tog = ((C22564z) c1207m).tux;
            if (this.tog != null) {
                if (!(this.tog.tAq == null || this.tog.tAq.size() == 0)) {
                    Commodity commodity = (Commodity) this.tog.tAq.get(0);
                    this.oXY = commodity.cAa;
                    C4990ab.m7410d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                    C1720g.m3537RQ();
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(commodity.pcm);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        C26417a.flu.mo20966a(commodity.pcm, "", this.tIU);
                    } else {
                        mo47912S(aoO);
                    }
                }
                m47043e(this.tog);
            } else {
                C4990ab.m7412e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
                C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C226132());
            }
            AppMethodBeat.m2505o(47534);
            return true;
        }
        AppMethodBeat.m2505o(47534);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public Orders cRD() {
        AppMethodBeat.m2504i(47528);
        Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
        AppMethodBeat.m2505o(47528);
        return orders;
    }
}

package com.tencent.p177mm.plugin.remittance.p497ui;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18267fx;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.remittance.model.C13048o;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C7549ow;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultUI */
public class RemittanceResultUI extends WalletBaseUI {
    private Orders pWy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45156);
        super.onCreate(bundle);
        if (cgg()) {
            int i;
            boolean z;
            int i2;
            PayInfo payInfo;
            C18267fx c18267fx;
            mo9439AM(4);
            getWindow().setBackgroundDrawableResource(C25738R.color.a3p);
            this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
            PayInfo payInfo2 = (PayInfo) this.mBundle.getParcelable("key_pay_info");
            if (payInfo2 != null) {
                i = payInfo2.cIf;
            } else {
                i = 0;
            }
            if (i == 31 || i == 5) {
                z = false;
            } else {
                z = true;
            }
            String str = "MicroMsg.RemittanceResultUI";
            String str2 = "orders==null:%s, paysScene: %s, needFetchF2fData: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.pWy == null);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            if (this.pWy != null) {
                C4990ab.m7417i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", Integer.valueOf(this.pWy.tAA));
                if (this.pWy.tAA != 1) {
                    m6031at(RemittanceResultOldUI.class);
                } else if (z) {
                    Orders orders = this.pWy;
                    if (payInfo2 == null || payInfo2.vwh == null) {
                        m6031at(RemittanceResultNewUI.class);
                        finish();
                    } else {
                        C4990ab.m7416i("MicroMsg.RemittanceResultUI", "fetch f2f data");
                        String string = payInfo2.vwh.getString("extinfo_key_11");
                        String str3 = "";
                        if (orders != null && orders.tAq.size() > 0) {
                            str3 = ((Commodity) orders.tAq.get(0)).cAa;
                        }
                        int i3 = payInfo2.vwh.getInt("extinfo_key_15", 0);
                        str2 = payInfo2.vwh.getString("extinfo_key_7");
                        String string2 = payInfo2.vwh.getString("extinfo_key_3");
                        int i4 = payInfo2.vwh.getInt("extinfo_key_12", 0);
                        String string3 = payInfo2.vwh.getString("extinfo_key_13");
                        String string4 = payInfo2.vwh.getString("extinfo_key_14");
                        String string5 = payInfo2.vwh.getString("extinfo_key_16");
                        if (C5046bo.isNullOrNil(string5)) {
                            string5 = str3;
                        }
                        C4990ab.m7417i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", string, string5, Integer.valueOf(i3), str2, string2, Integer.valueOf(i4), string3, string4, Integer.valueOf(payInfo2.cIb), Integer.valueOf(payInfo2.cIf));
                        mo39992nf(2773);
                        mo39970a(new C13048o(string, string5, i3, str2, string2, payInfo2.cIb, i4, string3, string4), true, true);
                    }
                }
                i2 = 0;
                payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
                if (payInfo != null) {
                    i2 = payInfo.cIf;
                }
                if (i2 == 33 || i2 == 32 || i2 == 48 || i2 == 31) {
                    c18267fx = new C18267fx();
                    c18267fx.czY.czZ = payInfo.czZ;
                    if (i2 != 31) {
                        c18267fx.czY.type = 0;
                    } else if (i2 == 32 || i2 == 33) {
                        c18267fx.czY.type = 1;
                    }
                    if (!(this.pWy == null || this.pWy.tAq.isEmpty())) {
                        c18267fx.czY.cAa = ((Commodity) this.pWy.tAq.get(0)).cAa;
                    }
                    C4879a.xxA.mo10055m(c18267fx);
                }
            }
            m6031at(RemittanceResultNewUI.class);
            finish();
            i2 = 0;
            payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
            if (payInfo != null) {
            }
            c18267fx = new C18267fx();
            c18267fx.czY.czZ = payInfo.czZ;
            if (i2 != 31) {
            }
            c18267fx.czY.cAa = ((Commodity) this.pWy.tAq.get(0)).cAa;
            C4879a.xxA.mo10055m(c18267fx);
        }
        AppMethodBeat.m2505o(45156);
    }

    /* renamed from: at */
    private void m6031at(Class<?> cls) {
        AppMethodBeat.m2504i(45157);
        if (dOD() == null) {
            mo17381a((Class) cls, getIntent());
            AppMethodBeat.m2505o(45157);
            return;
        }
        dOD().mo64571b(this, cls, this.mBundle);
        AppMethodBeat.m2505o(45157);
    }

    /* Access modifiers changed, original: protected */
    public boolean cgg() {
        return true;
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45158);
        if (c1207m instanceof C13048o) {
            C4990ab.m7417i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            C13048o c13048o = (C13048o) c1207m;
            if (i == 0 && i2 == 0) {
                C7549ow c7549ow = c13048o.pPe;
                C4990ab.m7417i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", Integer.valueOf(c7549ow.kCl), c7549ow.kCm, c7549ow.tBw);
                if (c7549ow.kCl == 0) {
                    try {
                        this.mBundle.putByteArray("key_succpage_resp", c7549ow.toByteArray());
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.RemittanceResultUI", e, "pass succ page resp error: %s", e.getMessage());
                    }
                    m6031at(RemittanceResultNewUI.class);
                    finish();
                    AppMethodBeat.m2505o(45158);
                    return true;
                }
                Toast.makeText(this, c7549ow.kCm, 1).show();
            }
            m6031at(RemittanceResultNewUI.class);
            finish();
            AppMethodBeat.m2505o(45158);
            return true;
        }
        AppMethodBeat.m2505o(45158);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45159);
        super.onDestroy();
        mo39993ng(2773);
        AppMethodBeat.m2505o(45159);
    }

    public int getLayoutId() {
        return -1;
    }
}

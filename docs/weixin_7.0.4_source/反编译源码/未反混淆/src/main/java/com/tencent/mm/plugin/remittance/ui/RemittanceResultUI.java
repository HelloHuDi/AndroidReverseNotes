package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.plugin.remittance.model.o;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class RemittanceResultUI extends WalletBaseUI {
    private Orders pWy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45156);
        super.onCreate(bundle);
        if (cgg()) {
            int i;
            boolean z;
            int i2;
            PayInfo payInfo;
            fx fxVar;
            AM(4);
            getWindow().setBackgroundDrawableResource(R.color.a3p);
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
            ab.i(str, str2, objArr);
            if (this.pWy != null) {
                ab.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", Integer.valueOf(this.pWy.tAA));
                if (this.pWy.tAA != 1) {
                    at(RemittanceResultOldUI.class);
                } else if (z) {
                    Orders orders = this.pWy;
                    if (payInfo2 == null || payInfo2.vwh == null) {
                        at(RemittanceResultNewUI.class);
                        finish();
                    } else {
                        ab.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
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
                        if (bo.isNullOrNil(string5)) {
                            string5 = str3;
                        }
                        ab.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", string, string5, Integer.valueOf(i3), str2, string2, Integer.valueOf(i4), string3, string4, Integer.valueOf(payInfo2.cIb), Integer.valueOf(payInfo2.cIf));
                        nf(2773);
                        a(new o(string, string5, i3, str2, string2, payInfo2.cIb, i4, string3, string4), true, true);
                    }
                }
                i2 = 0;
                payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
                if (payInfo != null) {
                    i2 = payInfo.cIf;
                }
                if (i2 == 33 || i2 == 32 || i2 == 48 || i2 == 31) {
                    fxVar = new fx();
                    fxVar.czY.czZ = payInfo.czZ;
                    if (i2 != 31) {
                        fxVar.czY.type = 0;
                    } else if (i2 == 32 || i2 == 33) {
                        fxVar.czY.type = 1;
                    }
                    if (!(this.pWy == null || this.pWy.tAq.isEmpty())) {
                        fxVar.czY.cAa = ((Commodity) this.pWy.tAq.get(0)).cAa;
                    }
                    com.tencent.mm.sdk.b.a.xxA.m(fxVar);
                }
            }
            at(RemittanceResultNewUI.class);
            finish();
            i2 = 0;
            payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
            if (payInfo != null) {
            }
            fxVar = new fx();
            fxVar.czY.czZ = payInfo.czZ;
            if (i2 != 31) {
            }
            fxVar.czY.cAa = ((Commodity) this.pWy.tAq.get(0)).cAa;
            com.tencent.mm.sdk.b.a.xxA.m(fxVar);
        }
        AppMethodBeat.o(45156);
    }

    private void at(Class<?> cls) {
        AppMethodBeat.i(45157);
        if (dOD() == null) {
            a((Class) cls, getIntent());
            AppMethodBeat.o(45157);
            return;
        }
        dOD().b(this, cls, this.mBundle);
        AppMethodBeat.o(45157);
    }

    /* Access modifiers changed, original: protected */
    public boolean cgg() {
        return true;
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45158);
        if (mVar instanceof o) {
            ab.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            o oVar = (o) mVar;
            if (i == 0 && i2 == 0) {
                ow owVar = oVar.pPe;
                ab.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", Integer.valueOf(owVar.kCl), owVar.kCm, owVar.tBw);
                if (owVar.kCl == 0) {
                    try {
                        this.mBundle.putByteArray("key_succpage_resp", owVar.toByteArray());
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.RemittanceResultUI", e, "pass succ page resp error: %s", e.getMessage());
                    }
                    at(RemittanceResultNewUI.class);
                    finish();
                    AppMethodBeat.o(45158);
                    return true;
                }
                Toast.makeText(this, owVar.kCm, 1).show();
            }
            at(RemittanceResultNewUI.class);
            finish();
            AppMethodBeat.o(45158);
            return true;
        }
        AppMethodBeat.o(45158);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(45159);
        super.onDestroy();
        ng(2773);
        AppMethodBeat.o(45159);
    }

    public int getLayoutId() {
        return -1;
    }
}

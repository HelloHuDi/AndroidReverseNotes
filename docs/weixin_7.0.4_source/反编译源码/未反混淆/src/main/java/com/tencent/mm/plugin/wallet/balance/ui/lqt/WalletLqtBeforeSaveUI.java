package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet.balance.a.a.r;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;

@a(7)
public class WalletLqtBeforeSaveUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45514);
        super.onCreate(bundle);
        final Dialog b = g.b(this, false, null);
        new l().acy().b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bnr>>() {
            public final /* synthetic */ Object call(Object obj) {
                boolean z = true;
                AppMethodBeat.i(45513);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.WalletLqtBeforeSaveUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                b.dismiss();
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    bnr bnr = (bnr) aVar.fsy;
                    ab.i("MicroMsg.WalletLqtBeforeSaveUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                    if (bnr.kdT == 0) {
                        boolean z2;
                        com.tencent.mm.plugin.wallet.balance.a.a.ab.ach(bnr.tgu);
                        ArrayList arrayList = new ArrayList();
                        if (bnr.wQx != null && bnr.wQx.size() > 0) {
                            Iterator it = bnr.wQx.iterator();
                            while (it.hasNext()) {
                                xg xgVar = (xg) it.next();
                                if (!(bo.isNullOrNil(xgVar.title) || bo.isNullOrNil(xgVar.wdd))) {
                                    arrayList.add(String.format("%s||%s", new Object[]{xgVar.title, xgVar.wdd}));
                                }
                            }
                        }
                        ((r) new c().a(WalletLqtBeforeSaveUI.this.mController.ylL, r.class)).tfF.ge(bnr.wao, 1);
                        Intent intent = new Intent(WalletLqtBeforeSaveUI.this.mController.ylL, WalletLqtSaveFetchUI.class);
                        intent.putExtra("lqt_save_fund_code", bnr != null ? bnr.wPv : null);
                        intent.putExtra("lqt_save_fetch_mode", 1);
                        String str = "lqt_is_show_protocol";
                        if (bnr.cRh == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        intent.putExtra(str, z2);
                        String str2 = "lqt_is_agree_protocol";
                        if (bnr.wQw != 1) {
                            z = false;
                        }
                        intent.putExtra(str2, z);
                        intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
                        intent.putExtra("lqt_profile_wording", bnr.wQp);
                        intent.putExtra("lqt_account_type", bnr.wao);
                        intent.putExtra("lqt_fund_spid", bnr.wPx);
                        WalletLqtBeforeSaveUI.this.startActivity(intent);
                        WalletLqtBeforeSaveUI.this.setResult(-1);
                    }
                }
                WalletLqtBeforeSaveUI.this.finish();
                Void voidR = zXH;
                AppMethodBeat.o(45513);
                return voidR;
            }
        });
        AppMethodBeat.o(45514);
    }

    public void onDestroy() {
        AppMethodBeat.i(45515);
        super.onDestroy();
        AppMethodBeat.o(45515);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}

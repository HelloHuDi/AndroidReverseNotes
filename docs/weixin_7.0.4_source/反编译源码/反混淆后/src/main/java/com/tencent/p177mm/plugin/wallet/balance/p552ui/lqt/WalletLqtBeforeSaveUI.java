package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14103ab;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35397l;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4314r;
import com.tencent.p177mm.protocal.protobuf.C44191xg;
import com.tencent.p177mm.protocal.protobuf.bnr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.app.C40919c;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBeforeSaveUI */
public class WalletLqtBeforeSaveUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45514);
        super.onCreate(bundle);
        final Dialog b = C30901g.m49318b(this, false, null);
        new C35397l().acy().mo60487b(new C5681a<Void, C37441a<bnr>>() {
            public final /* synthetic */ Object call(Object obj) {
                boolean z = true;
                AppMethodBeat.m2504i(45513);
                C37441a c37441a = (C37441a) obj;
                C4990ab.m7417i("MicroMsg.WalletLqtBeforeSaveUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                b.dismiss();
                if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    bnr bnr = (bnr) c37441a.fsy;
                    C4990ab.m7417i("MicroMsg.WalletLqtBeforeSaveUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                    if (bnr.kdT == 0) {
                        boolean z2;
                        C14103ab.ach(bnr.tgu);
                        ArrayList arrayList = new ArrayList();
                        if (bnr.wQx != null && bnr.wQx.size() > 0) {
                            Iterator it = bnr.wQx.iterator();
                            while (it.hasNext()) {
                                C44191xg c44191xg = (C44191xg) it.next();
                                if (!(C5046bo.isNullOrNil(c44191xg.title) || C5046bo.isNullOrNil(c44191xg.wdd))) {
                                    arrayList.add(String.format("%s||%s", new Object[]{c44191xg.title, c44191xg.wdd}));
                                }
                            }
                        }
                        ((C4314r) new C40919c().mo64541a(WalletLqtBeforeSaveUI.this.mController.ylL, C4314r.class)).tfF.mo9336ge(bnr.wao, 1);
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
                AppMethodBeat.m2505o(45513);
                return voidR;
            }
        });
        AppMethodBeat.m2505o(45514);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45515);
        super.onDestroy();
        AppMethodBeat.m2505o(45515);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}

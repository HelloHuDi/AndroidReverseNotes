package com.tencent.p177mm.wallet_core.p650ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42071un;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36884b;
import com.tencent.p177mm.wallet_core.p649c.C30860n;
import com.tencent.p177mm.wallet_core.p649c.C44430q;
import com.tencent.p177mm.wallet_core.p760d.C40933h;
import com.tencent.p177mm.wallet_core.tenpay.model.C40944q;
import com.tencent.p177mm.wallet_core.tenpay.model.C46723p;

/* renamed from: com.tencent.mm.wallet_core.ui.f */
public final class C16100f {
    private static String hxN = null;
    private static int lqL = 0;
    private static int lqz = 0;

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m24406a(final WalletBaseUI walletBaseUI, int i, int i2, String str, final C1207m c1207m, boolean z) {
        boolean z2;
        Object obj;
        AppMethodBeat.m2504i(49332);
        if (C5046bo.isNullOrNil(str)) {
            str = walletBaseUI.getString(C25738R.string.fu2);
        }
        boolean z3 = true;
        if (c1207m instanceof C44430q) {
            z3 = ((C44430q) c1207m).bXm();
        }
        if (c1207m instanceof C30860n) {
            z2 = ((C30860n) c1207m).cNi;
        } else {
            z2 = z3;
        }
        C4990ab.m7417i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z2), c1207m);
        if (!((c1207m instanceof C40944q) || (c1207m instanceof C36884b))) {
            if (c1207m instanceof C44430q) {
                C44430q c44430q = (C44430q) c1207m;
                Bundle bundle;
                if (c44430q.dNO()) {
                    C4990ab.m7410d("MicroMsg.WalletDispatcher", "order pay end!!!");
                    bundle = walletBaseUI.mBundle;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", c44430q.AfI);
                    bundle.putString("intent_wap_pay_jump_url", c44430q.AfJ);
                    bundle.putBoolean("intent_pay_end", true);
                    C24143a.m37117k(walletBaseUI, bundle);
                } else if ((c1207m instanceof C46723p) && ((C46723p) c1207m).tpw) {
                    C4990ab.m7416i("MicroMsg.WalletDispatcher", "delay order pay end");
                    bundle = walletBaseUI.mBundle;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", c44430q.AfI);
                    bundle.putString("intent_wap_pay_jump_url", c44430q.AfJ);
                    bundle.putBoolean("intent_pay_end", true);
                    C24143a.m37117k(walletBaseUI, bundle);
                }
                if (z2 && C40933h.m70996a(walletBaseUI, c1207m, i, i2, str) && !c44430q.cOW()) {
                    obj = null;
                } else {
                    int obj2 = 1;
                }
                if (obj2 == null) {
                    C4990ab.m7410d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
                } else if ((walletBaseUI.dOD() == null || !walletBaseUI.dOE().mo9365c(i, i2, str, c1207m)) && !walletBaseUI.mo7885c(i, i2, str, (C44430q) c1207m) && z2) {
                    if (i == 0 && i2 == 0) {
                        C4990ab.m7410d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
                    } else {
                        lqL = i;
                        lqz = i2;
                        hxN = str;
                        C4990ab.m7410d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                    }
                }
            } else if ((walletBaseUI.dOD() == null || !walletBaseUI.dOE().mo9365c(i, i2, str, c1207m)) && !walletBaseUI.mo7885c(i, i2, str, c1207m) && z2) {
                if (i == 0 && i2 == 0) {
                    C4990ab.m7410d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
                } else {
                    lqL = i;
                    lqz = i2;
                    hxN = str;
                    C4990ab.m7410d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                }
            }
        }
        if (z) {
            C4990ab.m7411d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", Boolean.valueOf(z2));
            if (lqz != 0) {
                C4990ab.m7412e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + lqz);
                if (c1207m instanceof C44430q) {
                    final String dNP = ((C44430q) c1207m).dNP();
                    if (!C5046bo.isNullOrNil(dNP)) {
                        C4990ab.m7416i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
                        C30379h.m48445a(walletBaseUI.mController.ylL, hxN, null, walletBaseUI.getResources().getString(C25738R.string.fek), walletBaseUI.getResources().getString(C25738R.string.f9187s6), true, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49330);
                                C16100f.m24407e(walletBaseUI);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", dNP);
                                C25985d.m41467b(walletBaseUI.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                C36391e.m59978QS(3);
                                AppMethodBeat.m2505o(49330);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49331);
                                C16100f.m24407e(walletBaseUI);
                                AppMethodBeat.m2505o(49331);
                            }
                        });
                        C16100f.dOB();
                        C36391e.m59978QS(4);
                        obj2 = 1;
                        if (obj2 == null) {
                            AppMethodBeat.m2505o(49332);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                        C30379h.m48448a(walletBaseUI.mController.ylL, hxN, null, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49329);
                                C16100f.m24407e(walletBaseUI);
                                if (!(c1207m == null || c1207m.ftl == null)) {
                                    C42071un c42071un = new C42071un();
                                    c42071un.cQI.uri = c1207m.ftl.getUri();
                                    C4879a.xxA.mo10055m(c42071un);
                                }
                                AppMethodBeat.m2505o(49329);
                            }
                        });
                        AppMethodBeat.m2505o(49332);
                        return;
                    }
                }
                obj2 = null;
                if (obj2 == null) {
                }
            } else if (!walletBaseUI.bwQ()) {
                walletBaseUI.mo9439AM(0);
            }
        }
        AppMethodBeat.m2505o(49332);
    }

    public static void dOB() {
        lqL = 0;
        lqz = 0;
        hxN = null;
    }

    /* renamed from: e */
    static /* synthetic */ void m24407e(WalletBaseUI walletBaseUI) {
        AppMethodBeat.m2504i(49333);
        if (lqL == 1000) {
            switch (lqz) {
                case 1:
                    if (!walletBaseUI.bwQ()) {
                        walletBaseUI.mo9439AM(0);
                    }
                    walletBaseUI.mo8137wU(0);
                    break;
                case 3:
                    C24143a.m37113b(walletBaseUI.mController.ylL, walletBaseUI.mBundle, lqz);
                    break;
                default:
                    if (!walletBaseUI.bwP() && walletBaseUI.mController.contentView.getVisibility() == 0) {
                        walletBaseUI.mo8137wU(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
            }
        }
        C24143a.m37118o(walletBaseUI.mController.ylL, lqz);
        lqL = 0;
        lqz = 0;
        hxN = null;
        AppMethodBeat.m2505o(49333);
    }
}

package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.un;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.d.h;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.p;

public final class f {
    private static String hxN = null;
    private static int lqL = 0;
    private static int lqz = 0;

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(final WalletBaseUI walletBaseUI, int i, int i2, String str, final m mVar, boolean z) {
        boolean z2;
        Object obj;
        AppMethodBeat.i(49332);
        if (bo.isNullOrNil(str)) {
            str = walletBaseUI.getString(R.string.fu2);
        }
        boolean z3 = true;
        if (mVar instanceof q) {
            z3 = ((q) mVar).bXm();
        }
        if (mVar instanceof n) {
            z2 = ((n) mVar).cNi;
        } else {
            z2 = z3;
        }
        ab.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z2), mVar);
        if (!((mVar instanceof com.tencent.mm.wallet_core.tenpay.model.q) || (mVar instanceof b))) {
            if (mVar instanceof q) {
                q qVar = (q) mVar;
                Bundle bundle;
                if (qVar.dNO()) {
                    ab.d("MicroMsg.WalletDispatcher", "order pay end!!!");
                    bundle = walletBaseUI.mBundle;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", qVar.AfI);
                    bundle.putString("intent_wap_pay_jump_url", qVar.AfJ);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                } else if ((mVar instanceof p) && ((p) mVar).tpw) {
                    ab.i("MicroMsg.WalletDispatcher", "delay order pay end");
                    bundle = walletBaseUI.mBundle;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", qVar.AfI);
                    bundle.putString("intent_wap_pay_jump_url", qVar.AfJ);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                }
                if (z2 && h.a(walletBaseUI, mVar, i, i2, str) && !qVar.cOW()) {
                    obj = null;
                } else {
                    int obj2 = 1;
                }
                if (obj2 == null) {
                    ab.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
                } else if ((walletBaseUI.dOD() == null || !walletBaseUI.dOE().c(i, i2, str, mVar)) && !walletBaseUI.c(i, i2, str, (q) mVar) && z2) {
                    if (i == 0 && i2 == 0) {
                        ab.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
                    } else {
                        lqL = i;
                        lqz = i2;
                        hxN = str;
                        ab.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                    }
                }
            } else if ((walletBaseUI.dOD() == null || !walletBaseUI.dOE().c(i, i2, str, mVar)) && !walletBaseUI.c(i, i2, str, mVar) && z2) {
                if (i == 0 && i2 == 0) {
                    ab.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
                } else {
                    lqL = i;
                    lqz = i2;
                    hxN = str;
                    ab.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                }
            }
        }
        if (z) {
            ab.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", Boolean.valueOf(z2));
            if (lqz != 0) {
                ab.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + lqz);
                if (mVar instanceof q) {
                    final String dNP = ((q) mVar).dNP();
                    if (!bo.isNullOrNil(dNP)) {
                        ab.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
                        com.tencent.mm.ui.base.h.a(walletBaseUI.mController.ylL, hxN, null, walletBaseUI.getResources().getString(R.string.fek), walletBaseUI.getResources().getString(R.string.s6), true, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49330);
                                f.e(walletBaseUI);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", dNP);
                                d.b(walletBaseUI.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                e.QS(3);
                                AppMethodBeat.o(49330);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49331);
                                f.e(walletBaseUI);
                                AppMethodBeat.o(49331);
                            }
                        });
                        dOB();
                        e.QS(4);
                        obj2 = 1;
                        if (obj2 == null) {
                            AppMethodBeat.o(49332);
                            return;
                        }
                        ab.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                        com.tencent.mm.ui.base.h.a(walletBaseUI.mController.ylL, hxN, null, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49329);
                                f.e(walletBaseUI);
                                if (!(mVar == null || mVar.ftl == null)) {
                                    un unVar = new un();
                                    unVar.cQI.uri = mVar.ftl.getUri();
                                    com.tencent.mm.sdk.b.a.xxA.m(unVar);
                                }
                                AppMethodBeat.o(49329);
                            }
                        });
                        AppMethodBeat.o(49332);
                        return;
                    }
                }
                obj2 = null;
                if (obj2 == null) {
                }
            } else if (!walletBaseUI.bwQ()) {
                walletBaseUI.AM(0);
            }
        }
        AppMethodBeat.o(49332);
    }

    public static void dOB() {
        lqL = 0;
        lqz = 0;
        hxN = null;
    }

    static /* synthetic */ void e(WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(49333);
        if (lqL == 1000) {
            switch (lqz) {
                case 1:
                    if (!walletBaseUI.bwQ()) {
                        walletBaseUI.AM(0);
                    }
                    walletBaseUI.wU(0);
                    break;
                case 3:
                    a.b(walletBaseUI.mController.ylL, walletBaseUI.mBundle, lqz);
                    break;
                default:
                    if (!walletBaseUI.bwP() && walletBaseUI.mController.contentView.getVisibility() == 0) {
                        walletBaseUI.wU(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
            }
        }
        a.o(walletBaseUI.mController.ylL, lqz);
        lqL = 0;
        lqz = 0;
        hxN = null;
        AppMethodBeat.o(49333);
    }
}

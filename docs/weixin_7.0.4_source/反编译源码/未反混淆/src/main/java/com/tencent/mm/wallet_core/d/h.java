package com.tencent.mm.wallet_core.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h {
    /* JADX WARNING: Missing block: B:8:0x0025, code skipped:
            r2 = false;
     */
    /* JADX WARNING: Missing block: B:9:0x0026, code skipped:
            if (r2 == false) goto L_0x0123;
     */
    /* JADX WARNING: Missing block: B:10:0x0028, code skipped:
            r10.Ahw = 2;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:43:0x0123, code skipped:
            r10.Ahw = 3;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:44:0x0129, code skipped:
            r0 = false;
            r2 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final WalletBaseUI walletBaseUI, final m mVar, int i, final int i2, String str) {
        boolean z = false;
        AppMethodBeat.i(49136);
        if (i == 1000) {
            String string;
            if (bo.isNullOrNil(str)) {
                string = walletBaseUI.getString(R.string.fu2);
            } else {
                string = str;
            }
            c aE = a.aE(walletBaseUI);
            boolean z2;
            boolean z3;
            switch (i2) {
                case -100869:
                    com.tencent.mm.ui.base.h.a((Context) walletBaseUI, walletBaseUI.getString(R.string.fep), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(49135);
                            a.b(walletBaseUI, walletBaseUI.mBundle, i2);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(49135);
                        }
                    });
                    z2 = true;
                    break;
                case -100868:
                    com.tencent.mm.ui.base.h.a((Context) walletBaseUI, walletBaseUI.getString(R.string.feq), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(49134);
                            a.b(walletBaseUI, walletBaseUI.mBundle, i2);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(49134);
                        }
                    });
                    z2 = true;
                    z3 = true;
                    break;
                case 401:
                    int i3;
                    if (mVar instanceof n) {
                        i3 = ((n) mVar).tAz;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 1) {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, "", walletBaseUI.getString(R.string.ff8), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49125);
                                if (walletBaseUI.bwP()) {
                                    walletBaseUI.finish();
                                }
                                AppMethodBeat.o(49125);
                            }
                        });
                    } else {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, false, string, "", walletBaseUI.getString(R.string.ff9), walletBaseUI.getString(R.string.ta), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49128);
                                String str = "";
                                if (mVar instanceof n) {
                                    str = ((n) mVar).tqG;
                                }
                                if (bo.isNullOrNil(str)) {
                                    bi biVar = new bi();
                                    biVar.dck = 1;
                                    biVar.dcl = 1;
                                    biVar.ajK();
                                    if (r.YM()) {
                                        a.b(walletBaseUI, "PayUForgotPwdProcess", null);
                                    } else {
                                        a.b(walletBaseUI, "ForgotPwdProcess", null);
                                    }
                                    if (walletBaseUI.bwP()) {
                                        walletBaseUI.finish();
                                    }
                                    AppMethodBeat.o(49128);
                                    return;
                                }
                                bi biVar2 = new bi();
                                biVar2.dck = 1;
                                biVar2.dcl = 2;
                                biVar2.ajK();
                                ab.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", str);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("showShare", false);
                                d.b(walletBaseUI, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(49128);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49129);
                                walletBaseUI.wU(1);
                                AppMethodBeat.o(49129);
                            }
                        });
                    }
                    z2 = true;
                    z3 = true;
                    break;
                case 402:
                case 403:
                case 408:
                    if (aE != null) {
                        z2 = aE.a(walletBaseUI, i2, string);
                        z3 = true;
                        break;
                    }
                case 404:
                    if (aE != null) {
                        z2 = aE.a(walletBaseUI, i2, string);
                        z3 = true;
                        break;
                    }
                case 405:
                    if (mVar instanceof n) {
                        z = ((n) mVar).tAz;
                    }
                    if (z) {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, "", walletBaseUI.getString(R.string.ff8), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49131);
                                if (walletBaseUI.bwP()) {
                                    walletBaseUI.finish();
                                }
                                AppMethodBeat.o(49131);
                            }
                        });
                    } else {
                        com.tencent.mm.ui.base.h.d(walletBaseUI, string, "", walletBaseUI.getString(R.string.frt), walletBaseUI.getString(R.string.or), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49132);
                                walletBaseUI.rl(true);
                                AppMethodBeat.o(49132);
                            }
                        }, null);
                    }
                    z2 = true;
                    z3 = true;
                    break;
                case 407:
                    dOk();
                    if (r.YM()) {
                        b(walletBaseUI, i2, string);
                    } else {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, null, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(49130);
                                a.b(walletBaseUI, null, i2);
                                if (walletBaseUI.bwP()) {
                                    walletBaseUI.finish();
                                }
                                AppMethodBeat.o(49130);
                            }
                        });
                    }
                    z2 = true;
                    z3 = true;
                    break;
                case 412:
                    com.tencent.mm.ui.base.h.d(walletBaseUI, string, "", walletBaseUI.getString(R.string.fus), walletBaseUI.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(49133);
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("key_is_bind_bankcard", false);
                            a.a(walletBaseUI, "BindCardProcess", bundle, new c.a() {
                                public final Intent n(int i, Bundle bundle) {
                                    return null;
                                }
                            });
                            AppMethodBeat.o(49133);
                        }
                    }, null);
                    z2 = true;
                    z3 = true;
                    break;
                case 414:
                    dOk();
                    b(walletBaseUI, i2, string);
                    z2 = true;
                    z3 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
        }
        if (mVar instanceof q) {
            ((q) mVar).AfO = z;
        }
        AppMethodBeat.o(49136);
        return z;
    }

    private static void dOk() {
        m bVar;
        AppMethodBeat.i(49137);
        if (r.YM()) {
            bVar = new b();
        } else {
            bVar = new com.tencent.mm.wallet_core.tenpay.model.q();
        }
        g.RQ();
        g.RO().eJo.a(bVar, 0);
        AppMethodBeat.o(49137);
    }

    private static void b(final WalletBaseUI walletBaseUI, final int i, String str) {
        AppMethodBeat.i(49138);
        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, false, str, "", walletBaseUI.getString(R.string.feo), walletBaseUI.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(49126);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
                d.b(walletBaseUI, "webview", ".ui.tools.WebViewUI", intent);
                if (walletBaseUI.bwP() || walletBaseUI.mController.contentView.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
                AppMethodBeat.o(49126);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(49127);
                a.b(walletBaseUI, walletBaseUI.mBundle, i);
                if (walletBaseUI.bwP() || walletBaseUI.mController.contentView.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
                AppMethodBeat.o(49127);
            }
        });
        AppMethodBeat.o(49138);
    }
}

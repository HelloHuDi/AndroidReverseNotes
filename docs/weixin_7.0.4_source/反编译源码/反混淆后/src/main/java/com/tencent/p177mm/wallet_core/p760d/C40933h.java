package com.tencent.p177mm.wallet_core.p760d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C46880bi;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36884b;
import com.tencent.p177mm.wallet_core.p649c.C44430q;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.tenpay.model.C30875n;
import com.tencent.p177mm.wallet_core.tenpay.model.C40944q;

/* renamed from: com.tencent.mm.wallet_core.d.h */
public final class C40933h {
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
    /* renamed from: a */
    public static boolean m70996a(final WalletBaseUI walletBaseUI, final C1207m c1207m, int i, final int i2, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(49136);
        if (i == 1000) {
            String string;
            if (C5046bo.isNullOrNil(str)) {
                string = walletBaseUI.getString(C25738R.string.fu2);
            } else {
                string = str;
            }
            C40931c aE = C24143a.m37112aE(walletBaseUI);
            boolean z2;
            boolean z3;
            switch (i2) {
                case -100869:
                    C30379h.m48448a((Context) walletBaseUI, walletBaseUI.getString(C25738R.string.fep), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(49135);
                            C24143a.m37113b(walletBaseUI, walletBaseUI.mBundle, i2);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.m2505o(49135);
                        }
                    });
                    z2 = true;
                    break;
                case -100868:
                    C30379h.m48448a((Context) walletBaseUI, walletBaseUI.getString(C25738R.string.feq), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(49134);
                            C24143a.m37113b(walletBaseUI, walletBaseUI.mBundle, i2);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.m2505o(49134);
                        }
                    });
                    z2 = true;
                    z3 = true;
                    break;
                case 401:
                    int i3;
                    if (c1207m instanceof C30875n) {
                        i3 = ((C30875n) c1207m).tAz;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 1) {
                        C30379h.m48443a((Context) walletBaseUI, string, "", walletBaseUI.getString(C25738R.string.ff8), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49125);
                                if (walletBaseUI.bwP()) {
                                    walletBaseUI.finish();
                                }
                                AppMethodBeat.m2505o(49125);
                            }
                        });
                    } else {
                        C30379h.m48453a((Context) walletBaseUI, false, string, "", walletBaseUI.getString(C25738R.string.ff9), walletBaseUI.getString(C25738R.string.f9216ta), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49128);
                                String str = "";
                                if (c1207m instanceof C30875n) {
                                    str = ((C30875n) c1207m).tqG;
                                }
                                if (C5046bo.isNullOrNil(str)) {
                                    C46880bi c46880bi = new C46880bi();
                                    c46880bi.dck = 1;
                                    c46880bi.dcl = 1;
                                    c46880bi.ajK();
                                    if (C1853r.m3831YM()) {
                                        C24143a.m37114b(walletBaseUI, "PayUForgotPwdProcess", null);
                                    } else {
                                        C24143a.m37114b(walletBaseUI, "ForgotPwdProcess", null);
                                    }
                                    if (walletBaseUI.bwP()) {
                                        walletBaseUI.finish();
                                    }
                                    AppMethodBeat.m2505o(49128);
                                    return;
                                }
                                C46880bi c46880bi2 = new C46880bi();
                                c46880bi2.dck = 1;
                                c46880bi2.dcl = 2;
                                c46880bi2.ajK();
                                C4990ab.m7417i("MicroMsg.WalletErrMgr", "jump to forget_url %s", str);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("showShare", false);
                                C25985d.m41467b(walletBaseUI, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.m2505o(49128);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49129);
                                walletBaseUI.mo8137wU(1);
                                AppMethodBeat.m2505o(49129);
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
                        z2 = aE.mo26470a(walletBaseUI, i2, string);
                        z3 = true;
                        break;
                    }
                case 404:
                    if (aE != null) {
                        z2 = aE.mo26470a(walletBaseUI, i2, string);
                        z3 = true;
                        break;
                    }
                case 405:
                    if (c1207m instanceof C30875n) {
                        z = ((C30875n) c1207m).tAz;
                    }
                    if (z) {
                        C30379h.m48443a((Context) walletBaseUI, string, "", walletBaseUI.getString(C25738R.string.ff8), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49131);
                                if (walletBaseUI.bwP()) {
                                    walletBaseUI.finish();
                                }
                                AppMethodBeat.m2505o(49131);
                            }
                        });
                    } else {
                        C30379h.m48466d(walletBaseUI, string, "", walletBaseUI.getString(C25738R.string.frt), walletBaseUI.getString(C25738R.string.f9076or), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49132);
                                walletBaseUI.mo39994rl(true);
                                AppMethodBeat.m2505o(49132);
                            }
                        }, null);
                    }
                    z2 = true;
                    z3 = true;
                    break;
                case 407:
                    C40933h.dOk();
                    if (C1853r.m3831YM()) {
                        C40933h.m70997b(walletBaseUI, i2, string);
                    } else {
                        C30379h.m48448a((Context) walletBaseUI, string, null, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(49130);
                                C24143a.m37113b(walletBaseUI, null, i2);
                                if (walletBaseUI.bwP()) {
                                    walletBaseUI.finish();
                                }
                                AppMethodBeat.m2505o(49130);
                            }
                        });
                    }
                    z2 = true;
                    z3 = true;
                    break;
                case 412:
                    C30379h.m48466d(walletBaseUI, string, "", walletBaseUI.getString(C25738R.string.fus), walletBaseUI.getString(C25738R.string.f9076or), new OnClickListener() {

                        /* renamed from: com.tencent.mm.wallet_core.d.h$9$1 */
                        class C363821 implements C30857a {
                            C363821() {
                            }

                            /* renamed from: n */
                            public final Intent mo7785n(int i, Bundle bundle) {
                                return null;
                            }
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(49133);
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("key_is_bind_bankcard", false);
                            C24143a.m37107a(walletBaseUI, "BindCardProcess", bundle, new C363821());
                            AppMethodBeat.m2505o(49133);
                        }
                    }, null);
                    z2 = true;
                    z3 = true;
                    break;
                case 414:
                    C40933h.dOk();
                    C40933h.m70997b(walletBaseUI, i2, string);
                    z2 = true;
                    z3 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
        }
        if (c1207m instanceof C44430q) {
            ((C44430q) c1207m).AfO = z;
        }
        AppMethodBeat.m2505o(49136);
        return z;
    }

    private static void dOk() {
        C1207m c36884b;
        AppMethodBeat.m2504i(49137);
        if (C1853r.m3831YM()) {
            c36884b = new C36884b();
        } else {
            c36884b = new C40944q();
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c36884b, 0);
        AppMethodBeat.m2505o(49137);
    }

    /* renamed from: b */
    private static void m70997b(final WalletBaseUI walletBaseUI, final int i, String str) {
        AppMethodBeat.m2504i(49138);
        C30379h.m48453a((Context) walletBaseUI, false, str, "", walletBaseUI.getString(C25738R.string.feo), walletBaseUI.getString(C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(49126);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
                C25985d.m41467b(walletBaseUI, "webview", ".ui.tools.WebViewUI", intent);
                if (walletBaseUI.bwP() || walletBaseUI.mController.contentView.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
                AppMethodBeat.m2505o(49126);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(49127);
                C24143a.m37113b(walletBaseUI, walletBaseUI.mBundle, i);
                if (walletBaseUI.bwP() || walletBaseUI.mController.contentView.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
                AppMethodBeat.m2505o(49127);
            }
        });
        AppMethodBeat.m2505o(49138);
    }
}

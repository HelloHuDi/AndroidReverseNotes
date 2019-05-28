package com.tencent.p177mm.plugin.wallet_ecard.p1315a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_ecard.p562b.C22680b;
import com.tencent.p177mm.protocal.protobuf.bks;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C40933h;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.a.b */
public final class C22672b {

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.a.b$4 */
    static class C226754 implements OnClickListener {
        C226754() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.a.b$a */
    public interface C22676a {
        boolean cSR();
    }

    /* renamed from: d */
    public static String m34359d(Context context, String... strArr) {
        AppMethodBeat.m2504i(48052);
        String string = context.getString(C25738R.string.fu2);
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!C5046bo.isNullOrNil(str)) {
                    break;
                }
            }
        }
        String str2 = string;
        AppMethodBeat.m2505o(48052);
        return str2;
    }

    /* renamed from: a */
    public static boolean m34357a(WalletBaseUI walletBaseUI, C1207m c1207m, int i, String str, int i2, String str2) {
        AppMethodBeat.m2504i(48053);
        if (i2 == 0) {
            str2 = str;
        } else {
            i = i2;
        }
        C4990ab.m7417i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", Integer.valueOf(i), str2);
        if (i == 269293577) {
            C30379h.m48448a((Context) walletBaseUI, str, "", false, new C226754());
            AppMethodBeat.m2505o(48053);
            return true;
        }
        boolean a = C40933h.m70996a(walletBaseUI, c1207m, 1000, i, str2);
        AppMethodBeat.m2505o(48053);
        return a;
    }

    /* renamed from: a */
    public static void m34356a(int i, String str, String str2, String str3, Context context, C30857a c30857a) {
        AppMethodBeat.m2504i(48054);
        C4990ab.m7417i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", Integer.valueOf(i), Boolean.valueOf(C5046bo.isNullOrNil(str)), str2, str3);
        Bundle bundle = new Bundle();
        bundle.putInt(C43818a.tPH, i);
        bundle.putString(C43818a.tPI, str);
        bundle.putString(C43818a.tPM, str2);
        bundle.putString(C43818a.tPN, str3);
        C24143a.m37106a((Activity) context, C22680b.class, bundle, c30857a);
        AppMethodBeat.m2505o(48054);
    }

    /* renamed from: a */
    public static boolean m34358a(final WalletBaseUI walletBaseUI, final bks bks) {
        AppMethodBeat.m2504i(48051);
        if (bks == null) {
            C4990ab.m7416i("MicroMsg.ECardUtil", "no popItem");
        } else if (!C5046bo.isNullOrNil(bks.wNN)) {
            if (!C5046bo.isNullOrNil(bks.tod) && !C5046bo.isNullOrNil(bks.wNO)) {
                C4990ab.m7416i("MicroMsg.ECardUtil", "show guide info 1");
                C30379h.m48445a((Context) walletBaseUI, bks.wNN, "", bks.tod, bks.wNO, false, new OnClickListener() {
                    final /* synthetic */ C22676a tQg = null;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(48048);
                        if (!C5046bo.isNullOrNil(bks.wdd)) {
                            Context context = walletBaseUI;
                            String str = bks.wdd;
                            C22676a c22676a = this.tQg;
                            C4990ab.m7417i("MicroMsg.ECardUtil", "url: %s", str);
                            if (!C5046bo.isNullOrNil(str)) {
                                if (str.startsWith("native.")) {
                                    C4990ab.m7416i("MicroMsg.ECardUtil", "goto native");
                                    if (!((c22676a != null && c22676a.cSR()) || str.equals("native.qryacctdesc") || str.equals("native.openecardauth") || str.equals("native.cancloseecard") || !str.equals("native.withdraw"))) {
                                    }
                                } else {
                                    C4990ab.m7411d("MicroMsg.ECardUtil", "url: %s", str);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str);
                                    intent.putExtra("showShare", false);
                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                                }
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(48048);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(48049);
                        C40931c dOD;
                        if (bks.wvn == C43818a.tPD) {
                            C4990ab.m7416i("MicroMsg.ECardUtil", "do end process");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.mo8125b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (bks.wvn == C43818a.tPG) {
                            C4990ab.m7416i("MicroMsg.ECardUtil", "back bank list");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.mo8127c(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(48049);
                    }
                });
                AppMethodBeat.m2505o(48051);
                return true;
            } else if (!C5046bo.isNullOrNil(bks.wNO)) {
                C4990ab.m7416i("MicroMsg.ECardUtil", "show guide info 2");
                C30379h.m48447a((Context) walletBaseUI, bks.wNN, "", bks.wNO, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(48050);
                        C40931c dOD;
                        if (bks.wvn == C43818a.tPD) {
                            C4990ab.m7416i("MicroMsg.ECardUtil", "do end process");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.mo8125b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (bks.wvn == C43818a.tPG) {
                            C4990ab.m7416i("MicroMsg.ECardUtil", "back bank list");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.mo8127c(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(48050);
                    }
                });
                AppMethodBeat.m2505o(48051);
                return true;
            }
        }
        AppMethodBeat.m2505o(48051);
        return false;
    }
}

package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class b {

    public interface a {
        boolean cSR();
    }

    public static String d(Context context, String... strArr) {
        AppMethodBeat.i(48052);
        String string = context.getString(R.string.fu2);
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!bo.isNullOrNil(str)) {
                    break;
                }
            }
        }
        String str2 = string;
        AppMethodBeat.o(48052);
        return str2;
    }

    public static boolean a(WalletBaseUI walletBaseUI, m mVar, int i, String str, int i2, String str2) {
        AppMethodBeat.i(48053);
        if (i2 == 0) {
            str2 = str;
        } else {
            i = i2;
        }
        ab.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", Integer.valueOf(i), str2);
        if (i == 269293577) {
            h.a((Context) walletBaseUI, str, "", false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(48053);
            return true;
        }
        boolean a = com.tencent.mm.wallet_core.d.h.a(walletBaseUI, mVar, 1000, i, str2);
        AppMethodBeat.o(48053);
        return a;
    }

    public static void a(int i, String str, String str2, String str3, Context context, com.tencent.mm.wallet_core.c.a aVar) {
        AppMethodBeat.i(48054);
        ab.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", Integer.valueOf(i), Boolean.valueOf(bo.isNullOrNil(str)), str2, str3);
        Bundle bundle = new Bundle();
        bundle.putInt(a.tPH, i);
        bundle.putString(a.tPI, str);
        bundle.putString(a.tPM, str2);
        bundle.putString(a.tPN, str3);
        com.tencent.mm.wallet_core.a.a((Activity) context, com.tencent.mm.plugin.wallet_ecard.b.b.class, bundle, aVar);
        AppMethodBeat.o(48054);
    }

    public static boolean a(final WalletBaseUI walletBaseUI, final bks bks) {
        AppMethodBeat.i(48051);
        if (bks == null) {
            ab.i("MicroMsg.ECardUtil", "no popItem");
        } else if (!bo.isNullOrNil(bks.wNN)) {
            if (!bo.isNullOrNil(bks.tod) && !bo.isNullOrNil(bks.wNO)) {
                ab.i("MicroMsg.ECardUtil", "show guide info 1");
                h.a((Context) walletBaseUI, bks.wNN, "", bks.tod, bks.wNO, false, new OnClickListener() {
                    final /* synthetic */ a tQg = null;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(48048);
                        if (!bo.isNullOrNil(bks.wdd)) {
                            Context context = walletBaseUI;
                            String str = bks.wdd;
                            a aVar = this.tQg;
                            ab.i("MicroMsg.ECardUtil", "url: %s", str);
                            if (!bo.isNullOrNil(str)) {
                                if (str.startsWith("native.")) {
                                    ab.i("MicroMsg.ECardUtil", "goto native");
                                    if (!((aVar != null && aVar.cSR()) || str.equals("native.qryacctdesc") || str.equals("native.openecardauth") || str.equals("native.cancloseecard") || !str.equals("native.withdraw"))) {
                                    }
                                } else {
                                    ab.d("MicroMsg.ECardUtil", "url: %s", str);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str);
                                    intent.putExtra("showShare", false);
                                    d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                }
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.o(48048);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(48049);
                        c dOD;
                        if (bks.wvn == a.tPD) {
                            ab.i("MicroMsg.ECardUtil", "do end process");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (bks.wvn == a.tPG) {
                            ab.i("MicroMsg.ECardUtil", "back bank list");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.c(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.o(48049);
                    }
                });
                AppMethodBeat.o(48051);
                return true;
            } else if (!bo.isNullOrNil(bks.wNO)) {
                ab.i("MicroMsg.ECardUtil", "show guide info 2");
                h.a((Context) walletBaseUI, bks.wNN, "", bks.wNO, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(48050);
                        c dOD;
                        if (bks.wvn == a.tPD) {
                            ab.i("MicroMsg.ECardUtil", "do end process");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (bks.wvn == a.tPG) {
                            ab.i("MicroMsg.ECardUtil", "back bank list");
                            dOD = walletBaseUI.dOD();
                            if (dOD != null) {
                                dOD.c(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.o(48050);
                    }
                });
                AppMethodBeat.o(48051);
                return true;
            }
        }
        AppMethodBeat.o(48051);
        return false;
    }
}

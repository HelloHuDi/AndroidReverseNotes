package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;

public final class b {
    public static void b(Activity activity, String str) {
        AppMethodBeat.i(43469);
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(R.string.fu2);
        }
        h.a((Context) activity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43465);
                dialogInterface.dismiss();
                AppMethodBeat.o(43465);
            }
        });
        AppMethodBeat.o(43469);
    }

    public static void c(final Activity activity, String str, final String str2) {
        String string;
        AppMethodBeat.i(43470);
        if (TextUtils.isEmpty(str)) {
            string = activity.getString(R.string.fu2);
        } else {
            string = str;
        }
        if (bo.isNullOrNil(str2)) {
            b(activity, string);
            AppMethodBeat.o(43470);
            return;
        }
        ab.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
        h.a((Context) activity, string, null, activity.getResources().getString(R.string.fek), activity.getResources().getString(R.string.s6), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43466);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                d.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                e.QS(3);
                dialogInterface.dismiss();
                AppMethodBeat.o(43466);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43467);
                dialogInterface.dismiss();
                AppMethodBeat.o(43467);
            }
        });
        AppMethodBeat.o(43470);
    }

    public static void T(final Activity activity) {
        AppMethodBeat.i(43471);
        ab.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
        h.a((Context) activity, activity.getString(R.string.fvc), null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43468);
                if (activity instanceof WalletOfflineCoinPurseUI) {
                    ((WalletOfflineCoinPurseUI) activity).par = false;
                }
                dialogInterface.dismiss();
                AppMethodBeat.o(43468);
            }
        });
        AppMethodBeat.o(43471);
    }
}

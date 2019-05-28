package com.tencent.p177mm.plugin.offline.p479ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.offline.ui.b */
public final class C12759b {

    /* renamed from: com.tencent.mm.plugin.offline.ui.b$1 */
    static class C127571 implements OnClickListener {
        C127571() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43465);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(43465);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.b$3 */
    static class C127583 implements OnClickListener {
        C127583() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43467);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(43467);
        }
    }

    /* renamed from: b */
    public static void m20772b(Activity activity, String str) {
        AppMethodBeat.m2504i(43469);
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(C25738R.string.fu2);
        }
        C30379h.m48448a((Context) activity, str, null, false, new C127571());
        AppMethodBeat.m2505o(43469);
    }

    /* renamed from: c */
    public static void m20773c(final Activity activity, String str, final String str2) {
        String string;
        AppMethodBeat.m2504i(43470);
        if (TextUtils.isEmpty(str)) {
            string = activity.getString(C25738R.string.fu2);
        } else {
            string = str;
        }
        if (C5046bo.isNullOrNil(str2)) {
            C12759b.m20772b(activity, string);
            AppMethodBeat.m2505o(43470);
            return;
        }
        C4990ab.m7416i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
        C30379h.m48445a((Context) activity, string, null, activity.getResources().getString(C25738R.string.fek), activity.getResources().getString(C25738R.string.f9187s6), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(43466);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                C25985d.m41467b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                C36391e.m59978QS(3);
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(43466);
            }
        }, new C127583());
        AppMethodBeat.m2505o(43470);
    }

    /* renamed from: T */
    public static void m20771T(final Activity activity) {
        AppMethodBeat.m2504i(43471);
        C4990ab.m7412e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
        C30379h.m48448a((Context) activity, activity.getString(C25738R.string.fvc), null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(43468);
                if (activity instanceof WalletOfflineCoinPurseUI) {
                    ((WalletOfflineCoinPurseUI) activity).par = false;
                }
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(43468);
            }
        });
        AppMethodBeat.m2505o(43471);
    }
}

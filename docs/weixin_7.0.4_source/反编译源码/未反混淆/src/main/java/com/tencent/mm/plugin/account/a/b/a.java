package com.tencent.mm.plugin.account.a.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class a {

    public enum a {
        TwoPasswordsNotMatch,
        BeyondMaximumLength,
        NotReachMinimumLength,
        DisallowShortNumericPassword;

        static {
            AppMethodBeat.o(73682);
        }
    }

    public static void b(Context context, String str, int i, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(73683);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        String str2 = "neverGetA8Key";
        if (!z) {
            z2 = true;
        }
        intent.putExtra(str2, z2);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        if (i > 0) {
            d.b(context, "webview", ".ui.tools.WebViewUI", intent, i);
            AppMethodBeat.o(73683);
            return;
        }
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(73683);
    }

    public static boolean O(Context context, String str) {
        AppMethodBeat.i(73684);
        if (str.length() > 16) {
            a(context, a.BeyondMaximumLength);
            AppMethodBeat.o(73684);
            return false;
        } else if (bo.amT(str)) {
            h.g(context, R.string.dkt, R.string.dln);
            AppMethodBeat.o(73684);
            return false;
        } else if (bo.amY(str)) {
            AppMethodBeat.o(73684);
            return true;
        } else {
            if (str.length() < 8 || str.length() >= 16) {
                a(context, a.NotReachMinimumLength);
            } else {
                a(context, a.DisallowShortNumericPassword);
            }
            AppMethodBeat.o(73684);
            return false;
        }
    }

    private static void a(Context context, a aVar) {
        AppMethodBeat.i(73685);
        switch (aVar) {
            case TwoPasswordsNotMatch:
                h.g(context, R.string.dll, R.string.dln);
                AppMethodBeat.o(73685);
                return;
            case BeyondMaximumLength:
                h.g(context, R.string.dlm, R.string.dln);
                AppMethodBeat.o(73685);
                return;
            case DisallowShortNumericPassword:
                h.g(context, R.string.f0r, R.string.pq);
                AppMethodBeat.o(73685);
                return;
            case NotReachMinimumLength:
                h.g(context, R.string.f0t, R.string.pq);
                break;
        }
        AppMethodBeat.o(73685);
    }
}

package com.tencent.p177mm.plugin.account.p765a.p1216b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.a.b.a */
public final class C32921a {

    /* renamed from: com.tencent.mm.plugin.account.a.b.a$a */
    public enum C18796a {
        TwoPasswordsNotMatch,
        BeyondMaximumLength,
        NotReachMinimumLength,
        DisallowShortNumericPassword;

        static {
            AppMethodBeat.m2505o(73682);
        }
    }

    /* renamed from: b */
    public static void m53856b(Context context, String str, int i, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(73683);
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
            C25985d.m41468b(context, "webview", ".ui.tools.WebViewUI", intent, i);
            AppMethodBeat.m2505o(73683);
            return;
        }
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(73683);
    }

    /* renamed from: O */
    public static boolean m53854O(Context context, String str) {
        AppMethodBeat.m2504i(73684);
        if (str.length() > 16) {
            C32921a.m53855a(context, C18796a.BeyondMaximumLength);
            AppMethodBeat.m2505o(73684);
            return false;
        } else if (C5046bo.amT(str)) {
            C30379h.m48467g(context, C25738R.string.dkt, C25738R.string.dln);
            AppMethodBeat.m2505o(73684);
            return false;
        } else if (C5046bo.amY(str)) {
            AppMethodBeat.m2505o(73684);
            return true;
        } else {
            if (str.length() < 8 || str.length() >= 16) {
                C32921a.m53855a(context, C18796a.NotReachMinimumLength);
            } else {
                C32921a.m53855a(context, C18796a.DisallowShortNumericPassword);
            }
            AppMethodBeat.m2505o(73684);
            return false;
        }
    }

    /* renamed from: a */
    private static void m53855a(Context context, C18796a c18796a) {
        AppMethodBeat.m2504i(73685);
        switch (c18796a) {
            case TwoPasswordsNotMatch:
                C30379h.m48467g(context, C25738R.string.dll, C25738R.string.dln);
                AppMethodBeat.m2505o(73685);
                return;
            case BeyondMaximumLength:
                C30379h.m48467g(context, C25738R.string.dlm, C25738R.string.dln);
                AppMethodBeat.m2505o(73685);
                return;
            case DisallowShortNumericPassword:
                C30379h.m48467g(context, C25738R.string.f0r, C25738R.string.f9109pq);
                AppMethodBeat.m2505o(73685);
                return;
            case NotReachMinimumLength:
                C30379h.m48467g(context, C25738R.string.f0t, C25738R.string.f9109pq);
                break;
        }
        AppMethodBeat.m2505o(73685);
    }
}

package com.tencent.p177mm.plugin.order.p1008c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.HashMap;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.order.c.c */
public final class C12785c {
    public static boolean isNumeric(String str) {
        AppMethodBeat.m2504i(43933);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.m2505o(43933);
        return matches;
    }

    /* renamed from: UB */
    private static HashMap<String, String> m20785UB(String str) {
        AppMethodBeat.m2504i(43934);
        if (str == null) {
            AppMethodBeat.m2505o(43934);
            return null;
        }
        int indexOf = str.indexOf(NativeProtocol.WEB_DIALOG_ACTION);
        if (indexOf <= 0) {
            AppMethodBeat.m2505o(43934);
            return null;
        }
        String substring = str.substring(indexOf, str.length());
        if (TextUtils.isEmpty(substring)) {
            AppMethodBeat.m2505o(43934);
            return null;
        }
        String[] split = substring.split("&");
        if (split == null) {
            AppMethodBeat.m2505o(43934);
            return null;
        }
        HashMap<String, String> hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            if (split3 != null && split3.length == 2) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        AppMethodBeat.m2505o(43934);
        return hashMap;
    }

    /* renamed from: aM */
    public static boolean m20788aM(Context context, String str) {
        AppMethodBeat.m2504i(43935);
        C4990ab.m7418v("MicroMsg.MallUtil", "jumpToUrl:".concat(String.valueOf(str)));
        Intent intent = new Intent();
        HashMap UB = C12785c.m20785UB(str);
        if (UB != null && !UB.isEmpty()) {
            String str2 = (String) UB.get(NativeProtocol.WEB_DIALOG_ACTION);
            if (!TextUtils.isEmpty(str2) && C12785c.isNumeric(str2)) {
                switch (Integer.valueOf(str2).intValue()) {
                    case 1:
                        intent.putExtra("rawUrl", (String) UB.get("3rdurl"));
                        intent.putExtra("showShare", false);
                        intent.putExtra("pay_channel", 1);
                        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        break;
                    case 2:
                        C36391e.m59991ae(context, (String) UB.get("username"));
                        break;
                    case 3:
                        intent.putExtra("key_func_id", (String) UB.get("functionid"));
                        intent.putExtra("key_scene", 1);
                        C25985d.m41467b(context, "mall", ".ui.MallIndexUI", intent);
                        break;
                    case 4:
                        intent.putExtra("key_product_id", (String) UB.get("productid"));
                        intent.putExtra("key_product_scene", 5);
                        C25985d.m41467b(context, "product", ".ui.MallProductUI", intent);
                        break;
                }
            }
            C4990ab.m7412e("MicroMsg.MallUtil", "jumpToUrl illegal action:".concat(String.valueOf(str2)));
            AppMethodBeat.m2505o(43935);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.MallUtil", "jumpToUrl illegal url:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(43935);
            return false;
        } else {
            C12785c.m20787aL(context, str);
        }
        AppMethodBeat.m2505o(43935);
        return true;
    }

    /* renamed from: aN */
    public static void m20789aN(Context context, String str) {
        AppMethodBeat.m2504i(43936);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43936);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_product_scene", 5);
        C25985d.m41467b(context, "product", ".ui.MallProductUI", intent);
        AppMethodBeat.m2505o(43936);
    }

    /* renamed from: aL */
    public static void m20787aL(Context context, String str) {
        AppMethodBeat.m2504i(43937);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(43937);
    }

    /* renamed from: a */
    public static void m20786a(Boolean bool, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(43938);
        if (bool.booleanValue()) {
            C7060h.pYm.mo8381e(11030, str, "", str3, str4);
            AppMethodBeat.m2505o(43938);
            return;
        }
        C7060h.pYm.mo8381e(11030, str, str2, str3, str4);
        AppMethodBeat.m2505o(43938);
    }
}

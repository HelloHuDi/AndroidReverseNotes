package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class c {
    public static boolean isNumeric(String str) {
        AppMethodBeat.i(43933);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(43933);
        return matches;
    }

    private static HashMap<String, String> UB(String str) {
        AppMethodBeat.i(43934);
        if (str == null) {
            AppMethodBeat.o(43934);
            return null;
        }
        int indexOf = str.indexOf(NativeProtocol.WEB_DIALOG_ACTION);
        if (indexOf <= 0) {
            AppMethodBeat.o(43934);
            return null;
        }
        String substring = str.substring(indexOf, str.length());
        if (TextUtils.isEmpty(substring)) {
            AppMethodBeat.o(43934);
            return null;
        }
        String[] split = substring.split("&");
        if (split == null) {
            AppMethodBeat.o(43934);
            return null;
        }
        HashMap<String, String> hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            if (split3 != null && split3.length == 2) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        AppMethodBeat.o(43934);
        return hashMap;
    }

    public static boolean aM(Context context, String str) {
        AppMethodBeat.i(43935);
        ab.v("MicroMsg.MallUtil", "jumpToUrl:".concat(String.valueOf(str)));
        Intent intent = new Intent();
        HashMap UB = UB(str);
        if (UB != null && !UB.isEmpty()) {
            String str2 = (String) UB.get(NativeProtocol.WEB_DIALOG_ACTION);
            if (!TextUtils.isEmpty(str2) && isNumeric(str2)) {
                switch (Integer.valueOf(str2).intValue()) {
                    case 1:
                        intent.putExtra("rawUrl", (String) UB.get("3rdurl"));
                        intent.putExtra("showShare", false);
                        intent.putExtra("pay_channel", 1);
                        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        break;
                    case 2:
                        e.ae(context, (String) UB.get("username"));
                        break;
                    case 3:
                        intent.putExtra("key_func_id", (String) UB.get("functionid"));
                        intent.putExtra("key_scene", 1);
                        d.b(context, "mall", ".ui.MallIndexUI", intent);
                        break;
                    case 4:
                        intent.putExtra("key_product_id", (String) UB.get("productid"));
                        intent.putExtra("key_product_scene", 5);
                        d.b(context, "product", ".ui.MallProductUI", intent);
                        break;
                }
            }
            ab.e("MicroMsg.MallUtil", "jumpToUrl illegal action:".concat(String.valueOf(str2)));
            AppMethodBeat.o(43935);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.MallUtil", "jumpToUrl illegal url:".concat(String.valueOf(str)));
            AppMethodBeat.o(43935);
            return false;
        } else {
            aL(context, str);
        }
        AppMethodBeat.o(43935);
        return true;
    }

    public static void aN(Context context, String str) {
        AppMethodBeat.i(43936);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43936);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_product_scene", 5);
        d.b(context, "product", ".ui.MallProductUI", intent);
        AppMethodBeat.o(43936);
    }

    public static void aL(Context context, String str) {
        AppMethodBeat.i(43937);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(43937);
    }

    public static void a(Boolean bool, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(43938);
        if (bool.booleanValue()) {
            h.pYm.e(11030, str, "", str3, str4);
            AppMethodBeat.o(43938);
            return;
        }
        h.pYm.e(11030, str, str2, str3, str4);
        AppMethodBeat.o(43938);
    }
}

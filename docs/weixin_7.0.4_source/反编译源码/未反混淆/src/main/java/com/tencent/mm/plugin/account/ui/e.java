package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class e {

    /* renamed from: com.tencent.mm.plugin.account.ui.e$1 */
    static class AnonymousClass1 implements c {
        final /* synthetic */ int gBr;
        final /* synthetic */ Context val$context;

        AnonymousClass1(int i, Context context) {
            this.gBr = i;
            this.val$context = context;
        }

        public final void a(l lVar) {
            AppMethodBeat.i(124868);
            if ((this.gBr & 1) != 0) {
                lVar.e(1, this.val$context.getString(R.string.djs));
            }
            if ((this.gBr & 2) != 0) {
                lVar.e(2, this.val$context.getString(R.string.djt));
            }
            if ((this.gBr & 4) != 0) {
                lVar.e(4, this.val$context.getString(R.string.djr));
            }
            if ((this.gBr & 8) > 0) {
                lVar.e(8, this.val$context.getString(R.string.g0m));
            }
            AppMethodBeat.o(124868);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.e$2 */
    static class AnonymousClass2 implements d {
        final /* synthetic */ String gBs = null;
        final /* synthetic */ String gBt = null;
        final /* synthetic */ String gBu = null;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context) {
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(124869);
            StringBuilder stringBuilder;
            String str;
            switch (menuItem.getItemId()) {
                case 1:
                    a.wA("F100_100_QQ");
                    stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_QQ,");
                    g.RN();
                    a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("F100_100_QQ")).append(",1").toString());
                    e.Q(this.val$context, this.val$context.getString(R.string.ezl));
                    AppMethodBeat.o(124869);
                    return;
                case 2:
                    a.wA("F100_100_Email");
                    stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_Email,");
                    g.RN();
                    a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("F100_100_Email")).append(",1").toString());
                    e.Q(this.val$context, this.val$context.getString(R.string.g7t) + aa.dor());
                    AppMethodBeat.o(124869);
                    return;
                case 4:
                    Context context = this.val$context;
                    String str2 = this.gBs;
                    str = this.gBt;
                    String str3 = this.gBu;
                    a.wA("F100_100_phone");
                    StringBuilder stringBuilder2 = new StringBuilder();
                    g.RN();
                    stringBuilder2 = stringBuilder2.append(com.tencent.mm.kernel.a.Rb()).append(",").append(context.getClass().getName()).append(",F100_100_phone,");
                    g.RN();
                    a.f(true, stringBuilder2.append(com.tencent.mm.kernel.a.lF("F100_100_phone")).append(",1").toString());
                    if (com.tencent.mm.protocal.d.vxr) {
                        Toast.makeText(context, context.getString(R.string.fm), 0).show();
                        AppMethodBeat.o(124869);
                        return;
                    }
                    Intent intent = new Intent(context, MobileInputUI.class);
                    if (str != null) {
                        int indexOf = str.indexOf("+");
                        if (indexOf != -1 && str.length() > 0) {
                            str = str.substring(indexOf + 1);
                        }
                        intent.putExtra("couttry_code", str);
                    }
                    if (str2 != null) {
                        intent.putExtra("country_name", str2);
                    }
                    if (str3 != null) {
                        intent.putExtra("bindmcontact_shortmobile", str3);
                    }
                    intent.putExtra("mobile_input_purpose", 1);
                    context.startActivity(intent);
                    AppMethodBeat.o(124869);
                    return;
                case 8:
                    str = this.val$context.getString(R.string.g0n);
                    if (aa.dor().equals("zh_CN")) {
                        str = str + "zh_CN";
                    } else {
                        str = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                    }
                    e.Q(this.val$context, str);
                    break;
            }
            AppMethodBeat.o(124869);
        }
    }

    public static void Q(Context context, String str) {
        AppMethodBeat.i(124870);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("KFromLoginHistory", false);
        com.tencent.mm.bp.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(124870);
    }
}

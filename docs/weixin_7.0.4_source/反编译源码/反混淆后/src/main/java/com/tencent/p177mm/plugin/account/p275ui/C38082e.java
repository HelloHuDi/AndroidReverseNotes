package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4988aa;

/* renamed from: com.tencent.mm.plugin.account.ui.e */
public final class C38082e {

    /* renamed from: com.tencent.mm.plugin.account.ui.e$1 */
    static class C380801 implements C36073c {
        final /* synthetic */ int gBr;
        final /* synthetic */ Context val$context;

        C380801(int i, Context context) {
            this.gBr = i;
            this.val$context = context;
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(124868);
            if ((this.gBr & 1) != 0) {
                c44273l.mo70068e(1, this.val$context.getString(C25738R.string.djs));
            }
            if ((this.gBr & 2) != 0) {
                c44273l.mo70068e(2, this.val$context.getString(C25738R.string.djt));
            }
            if ((this.gBr & 4) != 0) {
                c44273l.mo70068e(4, this.val$context.getString(C25738R.string.djr));
            }
            if ((this.gBr & 8) > 0) {
                c44273l.mo70068e(8, this.val$context.getString(C25738R.string.g0m));
            }
            AppMethodBeat.m2505o(124868);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.e$2 */
    static class C380812 implements C5279d {
        final /* synthetic */ String gBs = null;
        final /* synthetic */ String gBt = null;
        final /* synthetic */ String gBu = null;
        final /* synthetic */ Context val$context;

        C380812(Context context) {
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(124869);
            StringBuilder stringBuilder;
            String str;
            switch (menuItem.getItemId()) {
                case 1:
                    C42756a.m75796wA("F100_100_QQ");
                    stringBuilder = new StringBuilder();
                    C1720g.m3534RN();
                    stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_QQ,");
                    C1720g.m3534RN();
                    C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F100_100_QQ")).append(",1").toString());
                    C38082e.m64431Q(this.val$context, this.val$context.getString(C25738R.string.ezl));
                    AppMethodBeat.m2505o(124869);
                    return;
                case 2:
                    C42756a.m75796wA("F100_100_Email");
                    stringBuilder = new StringBuilder();
                    C1720g.m3534RN();
                    stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_Email,");
                    C1720g.m3534RN();
                    C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F100_100_Email")).append(",1").toString());
                    C38082e.m64431Q(this.val$context, this.val$context.getString(C25738R.string.g7t) + C4988aa.dor());
                    AppMethodBeat.m2505o(124869);
                    return;
                case 4:
                    Context context = this.val$context;
                    String str2 = this.gBs;
                    str = this.gBt;
                    String str3 = this.gBu;
                    C42756a.m75796wA("F100_100_phone");
                    StringBuilder stringBuilder2 = new StringBuilder();
                    C1720g.m3534RN();
                    stringBuilder2 = stringBuilder2.append(C1668a.m3397Rb()).append(",").append(context.getClass().getName()).append(",F100_100_phone,");
                    C1720g.m3534RN();
                    C42756a.m75795f(true, stringBuilder2.append(C1668a.m3407lF("F100_100_phone")).append(",1").toString());
                    if (C7243d.vxr) {
                        Toast.makeText(context, context.getString(C25738R.string.f8809fm), 0).show();
                        AppMethodBeat.m2505o(124869);
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
                    AppMethodBeat.m2505o(124869);
                    return;
                case 8:
                    str = this.val$context.getString(C25738R.string.g0n);
                    if (C4988aa.dor().equals("zh_CN")) {
                        str = str + "zh_CN";
                    } else {
                        str = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                    }
                    C38082e.m64431Q(this.val$context, str);
                    break;
            }
            AppMethodBeat.m2505o(124869);
        }
    }

    /* renamed from: Q */
    public static void m64431Q(Context context, String str) {
        AppMethodBeat.m2504i(124870);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("KFromLoginHistory", false);
        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(124870);
    }
}

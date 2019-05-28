package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class c {
    public static void a(final Context context, TextView textView) {
        AppMethodBeat.i(48412);
        Assert.assertTrue(textView != null);
        j jVar = new j(context);
        jVar.tHw = new a() {
            public final void onClick(View view) {
                AppMethodBeat.i(48410);
                ab.i("MicroMsg.PayUUtil", "hy: user clicked the span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/terms-and-conditions/");
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(48410);
            }
        };
        j jVar2 = new j(context);
        jVar2.tHw = new a() {
            public final void onClick(View view) {
                AppMethodBeat.i(48411);
                ab.i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms");
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(48411);
            }
        };
        String charSequence = context.getText(R.string.fpm).toString();
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(jVar, 94, 115, 33);
        spannableString.setSpan(jVar2, charSequence.length() - 3, charSequence.length(), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(48412);
    }
}

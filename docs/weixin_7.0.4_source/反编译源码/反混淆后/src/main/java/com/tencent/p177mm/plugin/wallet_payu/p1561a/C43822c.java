package com.tencent.p177mm.plugin.wallet_payu.p1561a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.wallet_payu.a.c */
public final class C43822c {
    /* renamed from: a */
    public static void m78564a(final Context context, TextView textView) {
        AppMethodBeat.m2504i(48412);
        Assert.assertTrue(textView != null);
        C46373j c46373j = new C46373j(context);
        c46373j.tHw = new C29672a() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(48410);
                C4990ab.m7416i("MicroMsg.PayUUtil", "hy: user clicked the span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/terms-and-conditions/");
                intent.putExtra("showShare", false);
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(48410);
            }
        };
        C46373j c46373j2 = new C46373j(context);
        c46373j2.tHw = new C29672a() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(48411);
                C4990ab.m7416i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms");
                intent.putExtra("showShare", false);
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(48411);
            }
        };
        String charSequence = context.getText(C25738R.string.fpm).toString();
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(c46373j, 94, 115, 33);
        spannableString.setSpan(c46373j2, charSequence.length() - 3, charSequence.length(), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(48412);
    }
}

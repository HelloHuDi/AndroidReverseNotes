package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.conversation.a.g */
public final class C40849g extends C14933b {
    boolean yFW = false;
    String zwk = null;
    String zwl = null;

    /* renamed from: com.tencent.mm.ui.conversation.a.g$2 */
    class C362612 implements OnClickListener {
        C362612() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34653);
            C9638aw.m17190ZK().mo33886Yl().mo60660oW(C40849g.this.zwk);
            C9638aw.m17190ZK().mo33886Yl().mo60660oW(C40849g.this.zwl);
            AppMethodBeat.m2505o(34653);
        }
    }

    public C40849g(Context context, String str, String str2, boolean z) {
        super(context);
        AppMethodBeat.m2504i(34654);
        this.zwk = str;
        this.zwl = str2;
        this.yFW = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(2131822696);
            String ao = C9638aw.m17190ZK().mo33886Yl().mo60658ao(this.zwk, "wording");
            String ao2 = C9638aw.m17190ZK().mo33886Yl().mo60658ao(this.zwl, "wording");
            if (!C5046bo.isNullOrNil(ao)) {
                textView.setText(ao);
            } else if (!C5046bo.isNullOrNil(ao2)) {
                textView.setText(ao2);
            }
            ao = C9638aw.m17190ZK().mo33886Yl().mo60658ao(this.zwk, "linkname");
            ao2 = C9638aw.m17190ZK().mo33886Yl().mo60658ao(this.zwk, "linksrc");
            textView = (TextView) this.view.findViewById(2131822697);
            if (!C5046bo.isNullOrNil(ao)) {
                textView.setText(ao);
            }
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(34652);
                    Intent intent = new Intent();
                    intent.putExtra("k_username", C40849g.this.zwk);
                    int i = 39;
                    if (C40849g.this.yFW) {
                        i = 36;
                    }
                    intent.putExtra("showShare", false);
                    if (C5046bo.isNullOrNil(ao2)) {
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
                    } else {
                        intent.putExtra("rawUrl", ao2);
                    }
                    if (C40849g.this.vlu.get() != null) {
                        C25985d.m41467b((Context) C40849g.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    C9638aw.m17190ZK().mo33886Yl().mo60660oW(C40849g.this.zwk);
                    C9638aw.m17190ZK().mo33886Yl().mo60660oW(C40849g.this.zwl);
                    AppMethodBeat.m2505o(34652);
                }
            });
            ((ImageView) this.view.findViewById(2131822698)).setOnClickListener(new C362612());
        }
        AppMethodBeat.m2505o(34654);
    }

    public final int getLayoutId() {
        return 2130969120;
    }

    public final void destroy() {
    }
}
